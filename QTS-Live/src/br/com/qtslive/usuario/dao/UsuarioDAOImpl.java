/**
 * 
 */
package br.com.qtslive.usuario.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import br.com.qtslive.model.Categoria;
import br.com.qtslive.model.Clube;
import br.com.qtslive.model.Foto;
import br.com.qtslive.model.Perfil;
import br.com.qtslive.model.usuario.Usuario;


/**
 * 
 * Implemntação da interface UsuarioDAO;
 * 
 * @author Tomás Azevedo
 *
 */
@Repository
public class UsuarioDAOImpl implements UsuarioDAO {
	
	private static Logger LOGGER = LoggerFactory.getLogger(UsuarioDAOImpl.class);

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private SimpleJdbcInsert clubeSimpleJdbcInsert;
	private SimpleJdbcInsert usuarioSimpleJdbcInsert;
	
	@Autowired
    public void setDataSource(DataSource dataSource) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        this.clubeSimpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("clube").usingGeneratedKeyColumns("id");
        this.usuarioSimpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("usuario").usingGeneratedKeyColumns("id");
    }
	
	@Override
	public List<Usuario> listarUsuarios(Long idClube) {
		
		List<Usuario> lista = new ArrayList<Usuario>();
		
		try {
			
			Map<String, Object> parameters = new HashMap<String, Object>(1);
	        parameters.put("idClube", idClube);  
			
			StringBuilder sql = new StringBuilder();
			sql.append("select u.id, u.nome, u.email, u.dataInicioVigencia, u.dataFimVigencia, u.senha, p.id, u.idCategoria, p.nome, u.idFoto, c.id, c.nome ");
	        sql.append("from usuario u, perfil p, clube c ");
	        sql.append("where u.IdPerfil = p.id and u.idClube = c.id and c.id=:idClube");
	        
	        lista = namedParameterJdbcTemplate.query(sql.toString(), parameters, new UsuarioRowMapper());	        
	        
		} catch (Exception e) {
			LOGGER.error("Erro ao recuperar a lista de usuários do banco de dados.");
			e.printStackTrace();
			throw e;			
		}
        return lista;
	}
	
	public class UsuarioRowMapper implements RowMapper<Usuario>	{
		public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
			Usuario usuario = new Usuario();
			usuario.setId(new Long(rs.getInt("u.id")));
			usuario.setNome(rs.getString("u.nome"));
			usuario.setEmail(rs.getString("u.email"));
			usuario.setSenha(rs.getString("u.senha"));	
			usuario.setDataInicioVigencia(rs.getDate("u.dataInicioVigencia").toLocalDate());			
			Date date = rs.getDate("u.dataFimVigencia");
			if(null!=date) {
				usuario.setDataFimVigencia(date.toLocalDate());				
			}		
			Perfil perfil = new Perfil();
			perfil.setId(new Long(rs.getInt("p.id")));
			perfil.setNome(rs.getString("p.nome"));	
			//perfil.setDescricao(rs.getString("p.descricao"));
			usuario.setPerfil(perfil);
			Categoria categoria = new Categoria();
			categoria.setId(new Long(rs.getInt("u.idCategoria")));
			usuario.setCategoria(categoria);
			//usuario.setIdCategoria(new Long(rs.getInt("u.idCategoria")));
			Clube clube = new Clube();
			clube.setId(rs.getLong("c.id"));
			clube.setNome(rs.getString("c.nome"));
			usuario.setClube(clube);
			Long idFoto = rs.getLong("u.idFoto");
			if(null!=idFoto && 0!=idFoto) {
				Foto foto = new Foto();
				foto.setId(idFoto);
				usuario.setFoto(foto);
			}
			return usuario;
		}
	 
	}

	@Override
	public Clube criarClube(Clube clube) {
		
		Map<String, Object> parameters = new HashMap<String, Object>(1);
        parameters.put("nome", clube.getNome());        
        
        Long id = (Long) this.clubeSimpleJdbcInsert.executeAndReturnKey(parameters);
         
        clube.setId(id);
		
		return clube;
	}

	@Override
	public Usuario criarUsuario(Usuario usuario) {		
		
		Map<String, Object> parameters = new HashMap<String, Object>(3);
        parameters.put("nome", usuario.getNome());
        parameters.put("email", usuario.getEmail());
        parameters.put("senha", usuario.getSenha());   
        if(null==usuario.getDataInicioVigencia()) {
        	usuario.setDataInicioVigencia(LocalDate.now());
        }
        parameters.put("dataInicioVigencia", Date.from(usuario.getDataInicioVigencia().atStartOfDay(ZoneId.systemDefault()).toInstant()));
//        if(null==usuario.getDataInicioVigencia()) {
//        	usuario.setDataInicioVigencia(LocalDate.now());
//        } else {
//        	parameters.put("dataFimVigencia", Date.from(usuario.getDataFimVigencia().atStartOfDay(ZoneId.systemDefault()).toInstant()));
//        }       
        parameters.put("idPerfil", usuario.getPerfil().getId());
        parameters.put("idCategoria", usuario.getCategoria().getId());
        //parameters.put("idEndereco", usuario.getEndereco().getId());
        parameters.put("idClube", usuario.getClube().getId());
        parameters.put("idFoto", usuario.getFoto().getId());
        
        Long id = (Long) this.usuarioSimpleJdbcInsert.executeAndReturnKey(parameters);
         
        usuario.setId(id);
		
		return usuario;
	}

	@Override
	public Perfil obterPerfil(Long idUsuario) {
		
		Perfil perfil = new Perfil();
		
		try {
			
			Map<String, Object> parameters = new HashMap<String, Object>(1);
	        parameters.put("id", idUsuario);  
			
			String sql = "SELECT p.id, p.nome, p.idFuncionalidadePerfil FROM perfil p, usuario u WHERE p.id = u.idPerfil AND p.idClube = u.idClube AND u.id = :id";			
	        
	        perfil = namedParameterJdbcTemplate.queryForObject(sql, parameters, new PerfilRowMapper());	        
	        
		} catch (Exception e) {
			LOGGER.error("Erro ao recuperar o Perfil de um usuário do banco de dados.");
			e.printStackTrace();
			throw e;			
		}
        return perfil;
	}
	
	public class PerfilRowMapper implements RowMapper<Perfil>	{
		public Perfil mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			Perfil perfil = new Perfil();
			perfil.setId(new Long(rs.getInt("p.id")));
			perfil.setNome(rs.getString("p.nome"));	
			//perfil.setListaFuncionalidades(listaFuncionalidades);
			return perfil;
		}
	 
	}

	@Override
	public Usuario obter(Long id) {
		
		Usuario usuario = new Usuario();
		
		try {
			
			Map<String, Object> parameters = new HashMap<String, Object>(1);
	        parameters.put("id", id);  
			
	        String sql = "SELECT u.id, u.nome, u.email, u.dataInicioVigencia, u.dataFimVigencia, u.idFoto, u.senha, u.idCategoria, p.id, p.nome, c.id, c.nome FROM usuario u, perfil p, clube c WHERE u.IdPerfil = p.id AND u.idClube = c.id AND u.id=:id";			
	        
	        usuario = namedParameterJdbcTemplate.queryForObject(sql.toString(), parameters, new UsuarioRowMapper());	        
	        
		} catch (Exception e) {
			LOGGER.error("Erro ao recuperar um usuário do banco de dados.");
			e.printStackTrace();
			throw e;			
		}
		
		return usuario;
	}

	@Override
	public void excluir(Long id, Long idClube) {

		try {
			
			String sql = "DELETE FROM usuario WHERE id=:id AND idClube=:idClube";
			
			Map<String, Object> parameters = new HashMap<String, Object>(2);			
			parameters.put("id", id);
			parameters.put("idClube", idClube);
	 
			this.namedParameterJdbcTemplate.update(sql, parameters);
			
		} catch (Exception e) {
			LOGGER.error("Erro ao excluir um Usuário do banco de dados.");
			e.printStackTrace();
			throw(e);
		}
		
	}

	@Override
	public void alterar(Usuario usuarioPerfil) {
		
		Map<String, Object> parameters = new HashMap<String, Object>(7);			
		parameters.put("id", usuarioPerfil.getId());
		parameters.put("nome", usuarioPerfil.getNome());
		parameters.put("email", usuarioPerfil.getEmail());
		parameters.put("senha", usuarioPerfil.getSenha());
		//parameters.put("dataInicioVigencia", Date.from(atleta.getDataNascimento().atStartOfDay(ZoneId.systemDefault()).toInstant()));
		parameters.put("idPerfil", usuarioPerfil.getPerfil().getId());
		parameters.put("idCategoria", usuarioPerfil.getCategoria().getId());
		parameters.put("idFoto", usuarioPerfil.getFoto().getId());
		
		try {
			
			String sql = "UPDATE usuario SET nome=:nome, email=:email, senha=:senha, idPerfil=:idPerfil, idCategoria=:idCategoria, idFoto=:idFoto WHERE id=:id";
	 
			this.namedParameterJdbcTemplate.update(sql, parameters);
			
			//Limpa as fotos não utilizadas
			this.namedParameterJdbcTemplate.update("DELETE FROM foto WHERE id NOT IN (SELECT idFoto FROM atleta) OR id NOT IN (SELECT idFoto FROM usuario)", new HashMap<String, Object>());
			
		} catch (Exception e) {
			LOGGER.error("Erro ao alterar um Usuário no banco de dados.");
			e.printStackTrace();
			throw(e);
		}
 
		
	}
	

}
