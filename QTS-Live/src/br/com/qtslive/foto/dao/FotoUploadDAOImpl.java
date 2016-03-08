/**
 * 
 */
package br.com.qtslive.foto.dao;

import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

/**
 * 
 * Implementação da interface FotoUploadDAO.
 * 
 * @author Tomás Azevedo
 *
 */
@Repository
public class FotoUploadDAOImpl implements FotoUploadDAO {
	
	private static Logger LOGGER = LoggerFactory.getLogger(FotoUploadDAOImpl.class);
	
	private SimpleJdbcInsert fotoSimpleJdbcInsert;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
    public void setDataSource(DataSource dataSource) {     
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        this.fotoSimpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("foto").usingGeneratedKeyColumns("id");
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

	@Override
	public Long salvarFoto(InputStream inputStream) {
		
		Long id = null;
		
		try {
			
			byte[] bytes = IOUtils.toByteArray(inputStream);
			
			Map<String, Object> parameters = new HashMap<String, Object>(1);
	        parameters.put("foto", bytes);
	        
	        id = (Long) this.fotoSimpleJdbcInsert.executeAndReturnKey(parameters);	               
			
		} catch (Exception e) {
			LOGGER.error("Erro ao inserir uma nova posição no banco de dados.");
			e.printStackTrace();			
		}
		
		return id;
	}

	@Override
	public byte[] obterFoto(Long id) {
		
		byte[] bytes = null;
		
		try {
			
			Map<String, Object> parameters = new HashMap<String, Object>(1);
	        parameters.put("id", id);
	        
			bytes = namedParameterJdbcTemplate.queryForObject("SELECT foto FROM foto WHERE id = :id", parameters,
					new RowMapper<byte[]>() {
						public byte[] mapRow(ResultSet rs, int i) throws SQLException {
							byte[] blobBytes = rs.getBytes("foto");
							return blobBytes;
						}
					});
	        
	        
	        
	        
		} catch (Exception e) {
			LOGGER.error("Erro ao recuperar uma determinada foto do banco de dados.");
			e.printStackTrace();
			throw e;			
		}
		
        return bytes;
	}

	@Override
	public boolean temFoto(Long id) {
		
		boolean existeFoto = false;
		
		try {
			
			int count = jdbcTemplate.queryForObject("SELECT count(id) FROM foto WHERE id = ?", Integer.class, id);
			
	        if(count>0) {existeFoto=true;}
	        
		} catch (Exception e) {
			LOGGER.error("Erro ao verificar se existe uma determinada foto no banco de dados.");
			e.printStackTrace();
			throw e;			
		}
		
        return existeFoto;
	}

}
