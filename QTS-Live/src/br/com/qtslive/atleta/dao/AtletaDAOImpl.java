/**
 * 
 */
package br.com.qtslive.atleta.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import br.com.qtslive.model.Atleta;
import br.com.qtslive.model.Categoria;
import br.com.qtslive.model.Clube;
import br.com.qtslive.model.Dominancia;
import br.com.qtslive.model.Foto;
import br.com.qtslive.model.Posicao;

/**
 * 
 * Implementação da interface AtletaDAO.
 * 
 * @author Tomás Azevedo
 *
 */
@Repository
public class AtletaDAOImpl implements AtletaDAO {

	private static Logger LOGGER = LoggerFactory.getLogger(AtletaDAOImpl.class);
	
	private SimpleJdbcInsert simpleJdbcInsert;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
    public void setDataSource(DataSource dataSource) { 
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		this.simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("atleta").usingGeneratedKeyColumns("id");
		this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
	
	@Override
	public Atleta criarAtleta(Atleta atleta) {
		
		try {
			
			Map<String, Object> parameters = new HashMap<String, Object>(3);
	        parameters.put("nome", atleta.getNome());
	        parameters.put("idClube", atleta.getClube().getId());
	        parameters.put("idFoto", atleta.getFoto().getId());
	        parameters.put("apelido", atleta.getApelido());
	        parameters.put("email", atleta.getEmail());
	        parameters.put("dataNascimento", Date.from(atleta.getDataNascimento().atStartOfDay(ZoneId.systemDefault()).toInstant()));
	        parameters.put("telefone", atleta.getTelefone());
	        parameters.put("idCategoria", atleta.getCategoria().getId());
	        parameters.put("idDominancia", atleta.getDominancia().getId());
	        parameters.put("idPosicoes", this.gravarPosicoes(atleta.getListaPosicao()));
	        
	        Long id = (Long) this.simpleJdbcInsert.executeAndReturnKey(parameters);
	        
	        atleta.setId(id);
			
		} catch (Exception e) {
			LOGGER.error("Erro ao inserir um novo Atleta no banco de dados.");
			e.printStackTrace();
			throw(e);
		}
		
		return atleta;
	}

	private Long gravarPosicoes(List<Posicao> listaPosicao) {
		
		Long id = this.obterIdListaPosicao();

		try {
	        
	        for (Posicao posicao : listaPosicao) {
	        	
	        	Map<String, Object> parameters = new HashMap<String, Object>(3);
		        parameters.put("id", id);
		        parameters.put("idPosicao", posicao.getId());
		        
		        namedParameterJdbcTemplate.update("INSERT INTO atletaposicao (id, idPosicao) VALUES (:id, :idPosicao)", parameters);
		        
			}
	       	        
	       			
		} catch (Exception e) {
			LOGGER.error("Erro ao inserir a lista de posições de um usuário no banco de dados.");
			e.printStackTrace();
			throw(e);
		}
		
		return id;
		
	}

	private Long obterIdListaPosicao() {
		
		Long id = 0L;
		
		try {
			
			id = jdbcTemplate.queryForObject("SELECT id FROM atletaposicao ORDER BY id DESC LIMIT 1", Long.class);			
			
		} catch (Exception e) {
			
			if(e instanceof EmptyResultDataAccessException) {
				id = 1L;
				return id;
			}
			
			LOGGER.error("Erro ao obter o id para a lista de posições de um atleta.");
			e.printStackTrace();
			throw(e);
		}
		
		id++;
		return id;
		
	}

	@Override
	public List<Atleta> listar(Long idClube) {
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("SELECT a.id, a.idClube, a.nome, a.apelido, a.email, a.dataNascimento, ");
		sql.append("a.telefone, a.idCategoria, a.idDominancia, a.idPosicoes, a.idFoto, ");
        sql.append("d.id, d.nome, c.id, c.nome ");               
        sql.append("FROM atleta a, dominancia d, categoria c ");
        sql.append("WHERE a.idCategoria = c.id AND a.idDominancia = d.id AND a.idClube = :idClube");

		List<Atleta> lista = new ArrayList<Atleta>();
		
		try {
			
			Map<String, Object> parameters = new HashMap<String, Object>(1);
	        parameters.put("idClube", idClube);
	        
	        lista = namedParameterJdbcTemplate.query(sql.toString(), parameters, new AtletaRowMapper());	        
	        
		} catch (Exception e) {
			LOGGER.error("Erro ao recuperar a lista de Atletas do banco de dados.");
			e.printStackTrace();
			throw e;			
		}
        return lista;
	}
	
	public class AtletaRowMapper implements RowMapper<Atleta>	{
		public Atleta mapRow(ResultSet rs, int rowNum) throws SQLException {
			Atleta atleta = new Atleta();
			atleta.setId(rs.getLong("a.id"));
			Clube clube = new Clube();
			clube.setId(rs.getLong("a.idClube"));
			atleta.setClube(clube);
			atleta.setNome(rs.getString("a.nome"));
			atleta.setApelido(rs.getString("a.apelido"));
			atleta.setEmail(rs.getString("a.email"));
			Date date = rs.getDate("a.dataNascimento");
			if(null!=date) {
				atleta.setDataNascimento(date.toLocalDate());				
			}
			atleta.setTelefone(rs.getString("a.telefone"));
			Categoria categoria = new Categoria();
			categoria.setId(rs.getLong("c.id"));
			categoria.setNome(rs.getString("c.nome"));
			atleta.setCategoria(categoria);
			Dominancia dominancia = new Dominancia();
			dominancia.setId(rs.getLong("d.id"));
			dominancia.setNome(rs.getString("d.nome"));
			atleta.setDominancia(dominancia);
			atleta.setListaPosicao(obterPosicoes(rs.getLong("a.idPosicoes"), atleta.getClube().getId()));
			Long idFoto = rs.getLong("a.idFoto");
			if(null!=idFoto && 0!=idFoto) {
				Foto foto = new Foto();
				foto.setId(idFoto);
				atleta.setFoto(foto);
			}
			return atleta;
		}
		 
	}
	
	private List<Posicao> obterPosicoes(Long idPosicoes, Long idClube) {
		
		List<Posicao> lista = new ArrayList<Posicao>();
		
		try {
			
			Map<String, Object> parameters = new HashMap<String, Object>(2);
			parameters.put("idPosicoes", idPosicoes);
	        parameters.put("idClube", idClube);
	        
	        lista = namedParameterJdbcTemplate.query("SELECT p.id, p.sigla, p.nome FROM atletaposicao a, posicao p WHERE a.idPosicao = p.id AND p.idClube = :idClube AND a.id = :idPosicoes", parameters, new PosicaoRowMapper());	        
	        
		} catch (Exception e) {
			LOGGER.error("Erro ao recuperar a lista de Posições do banco de dados.");
			e.printStackTrace();
			throw e;			
		}
        return lista;
	}	
	
	public class PosicaoRowMapper implements RowMapper<Posicao>	{
		public Posicao mapRow(ResultSet rs, int rowNum) throws SQLException {
			Posicao posicao = new Posicao();
			posicao.setId(rs.getLong("p.id"));
			posicao.setSigla(rs.getString("p.sigla"));
			posicao.setNome(rs.getString("p.nome"));
			return posicao;
		}
		 
	}

	@Override
	public Atleta obterAtleta(Long idAtleta) {
		
		Atleta atleta = new Atleta();
		
		StringBuilder sql = new StringBuilder();		
		sql.append("SELECT a.id, a.idClube, a.nome, a.apelido, a.email, a.dataNascimento, ");
		sql.append("a.telefone, a.idCategoria, a.idDominancia, a.idPosicoes, a.idFoto, ");
        sql.append("d.id, d.nome, c.id, c.nome ");               
        sql.append("FROM atleta a, dominancia d, categoria c ");
        sql.append("WHERE a.idCategoria = c.id AND a.idDominancia = d.id AND a.id = :id");
        
        Map<String, Object> parameters = new HashMap<String, Object>(1);
        parameters.put("id", idAtleta);
        
        try {
        	
        	atleta = namedParameterJdbcTemplate.queryForObject(sql.toString(), parameters, new AtletaRowMapper());
        	
        } catch (Exception e) {
        	LOGGER.error("Erro ao recuperar um Atleta do banco de dados.");
			e.printStackTrace();
			throw e;	
        }
        
        return atleta;
		
	}

	@Override
	public void atualizar(Atleta atleta) {
		
		Map<String, Object> parameters = new HashMap<String, Object>(3);
        parameters.put("nome", atleta.getNome());
        parameters.put("id", atleta.getId());
        //parameters.put("idClube", atleta.getClube().getId());        
        parameters.put("apelido", atleta.getApelido());
        parameters.put("email", atleta.getEmail());
        parameters.put("dataNascimento", Date.from(atleta.getDataNascimento().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        parameters.put("telefone", atleta.getTelefone());
        parameters.put("idCategoria", atleta.getCategoria().getId());
        parameters.put("idDominancia", atleta.getDominancia().getId());        
        parameters.put("idFoto", atleta.getFoto().getId());
        
        this.atualizarPosicoesAtleta(atleta.getListaPosicao(), atleta.getId());

		String sql = "UPDATE atleta SET nome=:nome, apelido=:apelido, email=:email, dataNascimento=:dataNascimento, telefone=:telefone, idCategoria=:idCategoria, idDominancia=:idDominancia, idFoto=:idFoto  WHERE id=:id";
		
		try {
			
			this.namedParameterJdbcTemplate.update(sql, parameters);
			
			//Limpa as fotos não utilizadas
			this.namedParameterJdbcTemplate.update("DELETE FROM foto WHERE id NOT IN (SELECT idFoto FROM atleta) OR id NOT IN (SELECT idFoto FROM usuario)", new HashMap<String, Object>());
			
		} catch (Exception e) {
			LOGGER.error("Erro ao atualizar os dados de um Atleta no banco de dados.");
			e.printStackTrace();
			throw e;
		}
		
	}
	
	
	private void atualizarPosicoesAtleta(List<Posicao> listaPosicao, Long idAtleta) {
		
		
		try {
			
			// 1 - Pega o id das posições do atleta
			Long id = jdbcTemplate.queryForObject("SELECT idPosicoes FROM atleta WHERE id=?", new Object[] {idAtleta}, Long.class);	
			
			// 2 - Apaga as posições
			Map<String, Object> parameters = new HashMap<String, Object>(1);
	        parameters.put("idAtletaPosicao", id);			
			namedParameterJdbcTemplate.update("DELETE FROM atletaposicao WHERE id=:idAtletaPosicao", parameters);
			
			// 3 - Inseri as novas
			for (Posicao posicao : listaPosicao) {

				Map<String, Object> params = new HashMap<String, Object>(3);
				params.put("id", id);
				params.put("idPosicao", posicao.getId());

				namedParameterJdbcTemplate.update("INSERT INTO atletaposicao (id, idPosicao) VALUES (:id, :idPosicao)", params);

			}
			
		} catch (Exception e) {
			LOGGER.error("Erro ao atualizar a lista de posições de um Atleta no banco de dados.");
			e.printStackTrace();
			throw e;
		}
		
	}

	@Override
	public List<Atleta> listarAtletasCategoria(Long idClube, Long idCategoria) {

		StringBuilder sql = new StringBuilder();
		
		sql.append("SELECT a.id, a.idClube, a.nome, a.apelido, a.email, a.dataNascimento, ");
		sql.append("a.telefone, a.idCategoria, a.idDominancia, a.idPosicoes, a.idFoto, ");
        sql.append("d.id, d.nome, c.id, c.nome ");               
        sql.append("FROM atleta a, dominancia d, categoria c ");
        sql.append("WHERE a.idCategoria = c.id AND a.idDominancia = d.id AND a.idClube = :idClube AND a.idCategoria = :idCategoria ");

		List<Atleta> lista = new ArrayList<Atleta>();
		
		try {
			
			Map<String, Object> parameters = new HashMap<String, Object>(2);
	        parameters.put("idClube", idClube);
	        parameters.put("idCategoria", idCategoria);
	        
	        lista = namedParameterJdbcTemplate.query(sql.toString(), parameters, new AtletaRowMapper());	        
	        
		} catch (Exception e) {
			LOGGER.error("Erro ao recuperar a lista de Atletas do banco de dados.");
			e.printStackTrace();
			throw e;			
		}
        return lista;
	}
	
	@Override
	public Long obterIdPosicoes(Long idAtleta, Long idClube) {

		String sql = "SELECT idPosicoes FROM atleta WHERE id = :idAtleta AND idClube = :idClube";
		
		Map<String, Object> params = new HashMap<String, Object>(2);		
		params.put("idAtleta", idAtleta);
		params.put("idClube", idClube);
		
		Long idPosicoes = 0L;
		
		try {
	        
			idPosicoes = namedParameterJdbcTemplate.queryForObject(sql, params, Long.class);        
	        
		} catch (Exception e) {
			LOGGER.error("Erro ao recuperar a lista de Atletas do banco de dados.");
			e.printStackTrace();
			throw e;			
		}
        return idPosicoes;
	}

	@Override
	public void excluir(Long idAtleta, Long idClube, Long idPosicoes) {

		String sql2 = "DELETE FROM atletaposicao WHERE id = :idPosicoes";
		
		Map<String, Object> params2 = new HashMap<String, Object>(1);		
		params2.put("idPosicoes", idPosicoes);
		
		String sql1 = "DELETE FROM atleta WHERE id = :idAtleta AND idClube = :idClube";
		
		Map<String, Object> params1 = new HashMap<String, Object>(2);		
		params1.put("idAtleta", idAtleta);
		params1.put("idClube", idClube);
		
		try {
			
			//exclui as posições primeiro
			this.namedParameterJdbcTemplate.update(sql2, params2);
			
			this.namedParameterJdbcTemplate.update(sql1, params1);
			
		} catch (Exception e) {
			LOGGER.error("Erro excluir um atleta do banco de dados.");
			e.printStackTrace();
			throw e;			
		}
		
	}

	

}
