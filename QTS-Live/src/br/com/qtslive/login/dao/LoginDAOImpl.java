/**
 * 
 */
package br.com.qtslive.login.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.qtslive.model.Categoria;
import br.com.qtslive.model.Clube;
import br.com.qtslive.model.Foto;
import br.com.qtslive.model.Perfil;
import br.com.qtslive.model.usuario.Usuario;

/**
 * 
 * Implementação da interface LoginDAO.
 * 
 * @author Tomás Azevedo
 *
 */
@Repository
public class LoginDAOImpl implements LoginDAO {
	
	private NamedParameterJdbcTemplate jdbcTemplate;
	
	@Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }
	
	public boolean verificarUsuario(Usuario usuario) {
		Integer qtd = 0;
		try {
			Map<String, String> params = new HashMap<String, String>();
			params.put("email", usuario.getEmail());
			params.put("senha", usuario.getSenha());
			qtd = jdbcTemplate.queryForObject("SELECT count(*) FROM usuario WHERE email = :email AND senha = :senha  AND (dataFimVigencia IS NULL OR dataFimVigencia >= current_date)", params, Integer.class);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return qtd != null && qtd > 0;
	}

	@Override
	public Usuario obterUsuarioPorEmail(String email) {
		return (Usuario) jdbcTemplate.queryForObject("SELECT u.id, u.idCategoria, ca.nome, u.nome, u.email, u.idFoto, u.dataInicioVigencia, u.dataFimVigencia, p.id, p.nome, c.id, c.nome FROM usuario u, perfil p, clube c, categoria ca WHERE email = :email AND u.idPerfil = p.id AND u.idClube = c.id AND u.idClube = ca.idClube AND u.idCategoria = ca.id ", new MapSqlParameterSource("email", email), new UsuarioRowMapper());
	}
	
	public class UsuarioRowMapper implements RowMapper<Usuario>	{
		public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
			Usuario usuario = new Usuario();
			usuario.setId(new Long(rs.getInt("u.id")));
			Categoria categoria = new Categoria();
			categoria.setId(new Long(rs.getInt("u.idCategoria")));
			categoria.setNome(rs.getString("ca.nome"));
			usuario.setCategoria(categoria);
			usuario.setNome(rs.getString("u.nome"));
			usuario.setEmail(rs.getString("u.email"));			
			usuario.setDataInicioVigencia(rs.getDate("u.dataInicioVigencia").toLocalDate());
			Date date = rs.getDate("u.dataFimVigencia");
			if(null!=date) {
				usuario.setDataFimVigencia(date.toLocalDate());
			}		
			Long idFoto = rs.getLong("u.idFoto");
			if(null!=idFoto) {
				if(idFoto != 0) {
					Foto foto = new Foto();
					foto.setId(idFoto);
					usuario.setFoto(foto);
				}
			}
			Perfil perfil = new Perfil();
			perfil.setId(new Long(rs.getInt("p.id")));
			perfil.setNome(rs.getString("p.nome"));		
			usuario.setPerfil(perfil);
			Clube clube = new Clube();
			clube.setId(rs.getLong("c.id"));
			clube.setNome(rs.getString("c.nome"));
			usuario.setClube(clube);
			return usuario;
		}
	 
	}

}
