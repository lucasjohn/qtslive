/**
 * 
 */
package br.com.qtslive.configuracoes.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import br.com.qtslive.model.Categoria;
import br.com.qtslive.model.Dominancia;
import br.com.qtslive.model.Especial;
import br.com.qtslive.model.Exercicio;
import br.com.qtslive.model.Grupo;
import br.com.qtslive.model.LocalDor;
import br.com.qtslive.model.LocalTreino;
import br.com.qtslive.model.Perfil;
import br.com.qtslive.model.Periodo;
import br.com.qtslive.model.Posicao;
import br.com.qtslive.model.TipoSessao;
import br.com.qtslive.model.TipoTreinamentoFisico;
import br.com.qtslive.model.TipoTreinamentoTatico;
import br.com.qtslive.model.TipoTreinamentoTecnico;

/**
 * 
 * Implementação da interface ConfiguracaoDAO.
 * 
 * @author Tomás Azevedo
 *
 */
@Repository
public class ConfiguracaoDAOImpl implements ConfiguracaoDAO {
	
	private static Logger LOGGER = LoggerFactory.getLogger(ConfiguracaoDAOImpl.class);
	
	private SimpleJdbcInsert especialSimpleJdbcInsert;
	private SimpleJdbcInsert grupoSimpleJdbcInsert;
	private SimpleJdbcInsert localDorSimpleJdbcInsert;
	private SimpleJdbcInsert exercicioSimpleJdbcInsert;
	private SimpleJdbcInsert perfilSimpleJdbcInsert;
	private SimpleJdbcInsert categoriaSimpleJdbcInsert;
	private SimpleJdbcInsert posicaoSimpleJdbcInsert;
	private SimpleJdbcInsert dominanciaSimpleJdbcInsert;
	private SimpleJdbcInsert tipoTreinamentoFisicoSimpleJdbcInsert;
	private SimpleJdbcInsert tipoTreinamentoTecnicoSimpleJdbcInsert;
	private SimpleJdbcInsert tipoTreinamentoTaticoSimpleJdbcInsert;
	private SimpleJdbcInsert localTreinoSimpleJdbcInsert;
	private SimpleJdbcInsert tipoSessaoSimpleJdbcInsert;
	private SimpleJdbcInsert periodoSimpleJdbcInsert;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
    public void setDataSource(DataSource dataSource) {     
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        this.posicaoSimpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("posicao").usingGeneratedKeyColumns("id");
        this.dominanciaSimpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("dominancia").usingGeneratedKeyColumns("id");
        this.categoriaSimpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("categoria").usingGeneratedKeyColumns("id");
        this.perfilSimpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("perfil").usingGeneratedKeyColumns("id");
        this.exercicioSimpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("exercicio").usingGeneratedKeyColumns("id");
        this.localDorSimpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("localdor").usingGeneratedKeyColumns("id");
        this.tipoTreinamentoFisicoSimpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("tipotreinamentofisico").usingGeneratedKeyColumns("id");
        this.tipoTreinamentoTecnicoSimpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("tipotreinamentotecnico").usingGeneratedKeyColumns("id");
        this.tipoTreinamentoTaticoSimpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("tipotreinamentotatico").usingGeneratedKeyColumns("id");
        this.localTreinoSimpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("localtreino").usingGeneratedKeyColumns("id");
        this.tipoSessaoSimpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("tiposessao").usingGeneratedKeyColumns("id");
        this.periodoSimpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("periodo").usingGeneratedKeyColumns("id");
        this.grupoSimpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("grupo").usingGeneratedKeyColumns("id");
        this.especialSimpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("especial").usingGeneratedKeyColumns("id"); 
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


	@Override
	public List<Posicao> listarPosicoes(Long idClube) {
		
		List<Posicao> lista = new ArrayList<Posicao>();
		
		try {
			
			Map<String, Object> parameters = new HashMap<String, Object>(1);
	        parameters.put("idClube", idClube);
	        
	        lista = namedParameterJdbcTemplate.query("SELECT id, idClube, sigla, nome FROM posicao WHERE idClube=:idClube", parameters, new PosicaoRowMapper());	        
	        
		} catch (Exception e) {
			LOGGER.error("Erro ao recuperar a lista de posições do banco de dados.");
			e.printStackTrace();
			throw e;			
		}
        return lista;
		
		/*
		ZAE	Zagueiro Esquerdo
		ALD	Lateral Direito
		ALE	Lateral Esquerdo
		VOL	Volante Defensivo
		MC	Meia Central
		MA	Armador
		MD	Meia Direita
		ME	Meia Esquerda
		PD	Ala Direito
		PE	Ala Esquerdo
		CA	Centro Avante
		ATA	Atacante*/
		
	}
	
	public class PosicaoRowMapper implements RowMapper<Posicao>	{
		public Posicao mapRow(ResultSet rs, int rowNum) throws SQLException {
			Posicao posicao = new Posicao();
			posicao.setId(rs.getLong("id"));
			posicao.setIdClube(rs.getLong("idClube"));
			posicao.setSigla(rs.getString("sigla"));
			posicao.setNome(rs.getString("nome"));
			return posicao;
		}	 
	}

	@Override
	public Posicao criarPosicao(Posicao posicao) {
		
		try {
			
			Map<String, Object> parameters = new HashMap<String, Object>(4);
	        parameters.put("sigla", posicao.getSigla());
	        parameters.put("nome", posicao.getNome());
	        parameters.put("idClube", posicao.getIdClube());
	        parameters.put("ordem", 0);
	        
	        Long id = (Long) this.posicaoSimpleJdbcInsert.executeAndReturnKey(parameters);
	        
	        posicao.setId(id);	        
			
		} catch (Exception e) {
			LOGGER.error("Erro ao inserir uma nova posição no banco de dados.");
			e.printStackTrace();
			throw(e);
		}
		
		return posicao;
	}


	@Override
	public void editarPosicao(Posicao posicao) {
		
		try {
			
			String sql = "UPDATE posicao SET sigla=:sigla, nome=:nome WHERE id=:id AND idClube=:idClube";
			
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("sigla", posicao.getSigla());
			parameters.put("nome", posicao.getNome());
			parameters.put("id", posicao.getId());
			parameters.put("idClube", posicao.getIdClube());
	 
			this.namedParameterJdbcTemplate.update(sql, parameters);
			
		} catch (Exception e) {
			LOGGER.error("Erro ao atualizar uma posição no banco de dados.");
			e.printStackTrace();
			throw(e);
		}		
		
	}


	@Override
	public void excluirPosicao(Posicao posicao) {		
		
		try {
			
			String sql = "DELETE FROM posicao WHERE id=:id AND idClube=:idClube";
			
			Map<String, Object> parameters = new HashMap<String, Object>(2);			
			parameters.put("id", posicao.getId());
			parameters.put("idClube", posicao.getIdClube());
	 
			this.namedParameterJdbcTemplate.update(sql, parameters);
			
		} catch (Exception e) {
			LOGGER.error("Erro ao excluir uma posição do banco de dados.");
			e.printStackTrace();
			throw(e);
		}
		
	}
	
	@Override
	public String obterSiglaPosicao(Long id, Long idClube) {
		
		String nome = "";

		try {
			
			String sql = "SELECT sigla FROM posicao WHERE id=? and idClube=?";
			
			nome = this.jdbcTemplate.queryForObject(sql, new Object[] { id, idClube }, String.class);
			
		} catch (Exception e) {
			LOGGER.error("Erro ao obter a sigla de uma Posição do banco de dados.");
			e.printStackTrace();
			throw(e);
		}	
		
		return nome;
	}


	@Override
	public String obterNomePosicao(Long id, Long idClube) {
		
		String nome = "";

		try {
			
			String sql = "SELECT nome FROM posicao WHERE id=? and idClube=?";
			
			nome = this.jdbcTemplate.queryForObject(sql, new Object[] { id, idClube }, String.class);
			
		} catch (Exception e) {
			LOGGER.error("Erro ao obter o nome de uma Posição do banco de dados.");
			e.printStackTrace();
			throw(e);
		}	
		
		return nome;
	}


	@Override
	public Dominancia criarDominancia(Dominancia dominancia) {
		
		try {
			
			Map<String, Object> parameters = new HashMap<String, Object>(2);	        
	        parameters.put("nome", dominancia.getNome());
	        parameters.put("idClube", dominancia.getIdClube());
	        
	        Long id = (Long) this.dominanciaSimpleJdbcInsert.executeAndReturnKey(parameters);
	        
	        dominancia.setId(id);
			
		} catch (Exception e) {
			LOGGER.error("Erro ao inserir uma nova Dominância no banco de dados.");
			e.printStackTrace();
			throw(e);
		}
		
		return dominancia;
	}


	@Override
	public List<Dominancia> listarDominancias(Long idClube) {
		
		List<Dominancia> lista = new ArrayList<Dominancia>();
		
		try {
			
			Map<String, Object> parameters = new HashMap<String, Object>(1);
	        parameters.put("idClube", idClube);
	        
	        lista = namedParameterJdbcTemplate.query("SELECT id, idClube, nome FROM dominancia WHERE idClube=:idClube", parameters, new DominanciaRowMapper());	        
	        
		} catch (Exception e) {
			LOGGER.error("Erro ao recuperar a lista de Dominâncias do banco de dados.");
			e.printStackTrace();
			throw e;			
		}
        return lista;
	}
	
	public class DominanciaRowMapper implements RowMapper<Dominancia>	{
		public Dominancia mapRow(ResultSet rs, int rowNum) throws SQLException {
			Dominancia dominancia = new Dominancia();
			dominancia.setId(rs.getLong("id"));
			dominancia.setIdClube(rs.getLong("idClube"));		
			dominancia.setNome(rs.getString("nome"));
			return dominancia;
		}	 
	}

	@Override
	public void editarDominancia(Dominancia dominancia) {
		
		try {
			
			String sql = "UPDATE dominancia SET nome=:nome WHERE id=:id AND idClube=:idClube";
			
			Map<String, Object> parameters = new HashMap<String, Object>(3);			
			parameters.put("nome", dominancia.getNome());
			parameters.put("id", dominancia.getId());
			parameters.put("idClube", dominancia.getIdClube());
	 
			this.namedParameterJdbcTemplate.update(sql, parameters);
			
		} catch (Exception e) {
			LOGGER.error("Erro ao atualizar uma Dominância no banco de dados.");
			e.printStackTrace();
			throw(e);
		}		
		
	}


	@Override
	public void excluirDominancia(Dominancia dominancia) {
		
		try {
			
			String sql = "DELETE FROM dominancia WHERE id=:id AND idClube=:idClube";
			
			Map<String, Object> parameters = new HashMap<String, Object>(2);			
			parameters.put("id", dominancia.getId());
			parameters.put("idClube", dominancia.getIdClube());
	 
			this.namedParameterJdbcTemplate.update(sql, parameters);
			
		} catch (Exception e) {
			LOGGER.error("Erro ao excluir uma Dominância do banco de dados.");
			e.printStackTrace();
			throw(e);
		}
		
	}
	
	@Override
	public String obterNomeDominancia(Long id, Long idClube) {
		
		String nome = "";

		try {
			
			String sql = "SELECT nome FROM dominancia WHERE id=? and idClube=?";
			
			nome = this.jdbcTemplate.queryForObject(sql, new Object[] { id, idClube }, String.class);
			
		} catch (Exception e) {
			LOGGER.error("Erro ao obter o nome de uma Dominancia do banco de dados.");
			e.printStackTrace();
			throw(e);
		}	
		
		return nome;
	}	


	@Override
	public List<Categoria> listarCategorias(Long idClube) {
		
		List<Categoria> lista = new ArrayList<Categoria>();
		
		Map<String, Object> parameters = new HashMap<String, Object>();			
		parameters.put("idClube", idClube);
		
		try {
	        
	        lista = namedParameterJdbcTemplate.query("SELECT id, idClube, nome FROM categoria WHERE idClube = :idClube ORDER BY nome", parameters, new CategoriaRowMapper());	        
	        
		} catch (Exception e) {
			LOGGER.error("Erro ao recuperar a lista de Categorias do banco de dados.");
			e.printStackTrace();
			throw e;			
		}
		
        return lista;
	}
	
	public class CategoriaRowMapper implements RowMapper<Categoria>	{
		public Categoria mapRow(ResultSet rs, int rowNum) throws SQLException {
			Categoria categoria = new Categoria();
			categoria.setId(rs.getLong("id"));
			categoria.setIdClube(rs.getLong("idClube"));	
			categoria.setNome(rs.getString("nome"));
			return categoria;
		}	 
	}

	@Override
	public Categoria criarCategoria(Categoria categoria) {
		
		try {
			
			Map<String, Object> parameters = new HashMap<String, Object>(3);
	        parameters.put("nome", categoria.getNome());
	        parameters.put("idClube", categoria.getIdClube());	 
	        
	        Long id = (Long) this.categoriaSimpleJdbcInsert.executeAndReturnKey(parameters);
	        
	        categoria.setId(id);
			
		} catch (Exception e) {
			LOGGER.error("Erro ao inserir uma nova Categoria no banco de dados.");
			e.printStackTrace();
			throw(e);
		}
		
		return categoria;
	}


	@Override
	public void editarCategoria(Categoria categoria) {
		
		try {
			
			String sql = "UPDATE categoria SET nome=:nome WHERE id=:id and idClube=:idClube";
			
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("id", categoria.getId());
			parameters.put("idClube", categoria.getIdClube());
			parameters.put("nome", categoria.getNome());
	 
			this.namedParameterJdbcTemplate.update(sql, parameters);
			
		} catch (Exception e) {
			LOGGER.error("Erro ao atualizar uma Categoria no banco de dados.");
			e.printStackTrace();
			throw(e);
		}		
		
	}


	@Override
	public void excluirCategoria(Categoria categoria) {

		try {
			
			String sql = "DELETE FROM categoria WHERE id=:id and idClube=:idClube";
			
			Map<String, Object> parameters = new HashMap<String, Object>();			
			parameters.put("id", categoria.getId());
			parameters.put("idClube", categoria.getIdClube());
	 
			this.namedParameterJdbcTemplate.update(sql, parameters);
			
		} catch (Exception e) {
			LOGGER.error("Erro ao excluir uma Categoria do banco de dados.");
			e.printStackTrace();
			throw(e);
		}
		
	}
	
	@Override
	public String obterNomeCategoria(Long id, Long idClube) {
		
		String nomeCategoria = "";

		try {
			
			String sql = "SELECT nome FROM categoria WHERE id=? and idClube=?";
			
			nomeCategoria = this.jdbcTemplate.queryForObject(sql, new Object[] { id, idClube }, String.class);
			
		} catch (Exception e) {
			LOGGER.error("Erro ao obter o nome de uma Categoria do banco de dados.");
			e.printStackTrace();
			throw(e);
		}	
		
		return nomeCategoria;
	}


	@Override
	public List<Perfil> listarPerfis(Long idClube) {

		List<Perfil> lista = new ArrayList<Perfil>();
		
		Map<String, Object> parameters = new HashMap<String, Object>();			
		parameters.put("idClube", idClube);
		
		try {
	        
	        lista = namedParameterJdbcTemplate.query("SELECT id, idClube, nome FROM perfil WHERE idClube = :idClube ORDER BY nome", parameters, new PerfilRowMapper());	        
	        
		} catch (Exception e) {
			LOGGER.error("Erro ao recuperar a lista de Perfis do banco de dados.");
			e.printStackTrace();
			throw e;			
		}
		
        return lista;
	}
	
	public class PerfilRowMapper implements RowMapper<Perfil>	{
		public Perfil mapRow(ResultSet rs, int rowNum) throws SQLException {
			Perfil perfil = new Perfil();
			perfil.setId(rs.getLong("id"));
			perfil.setIdClube(rs.getLong("idClube"));	
			perfil.setNome(rs.getString("nome"));			
			return perfil;
		}	 
	}


	@Override
	public Perfil criarPerfil(Perfil perfil) {
		
		try {
			
			Map<String, Object> parameters = new HashMap<String, Object>(3);
	        parameters.put("nome", perfil.getNome());
	        parameters.put("idClube", perfil.getIdClube());	 
	        
	        Long id = (Long) this.perfilSimpleJdbcInsert.executeAndReturnKey(parameters);
	        
	        perfil.setId(id);
			
		} catch (Exception e) {
			LOGGER.error("Erro ao inserir uma novo Perfil no banco de dados.");
			e.printStackTrace();
			throw(e);
		}
		
		return perfil;
	}


	@Override
	public void editarPerfil(Perfil perfil) {
		
		try {
			
			String sql = "UPDATE perfil SET nome=:nome WHERE id=:id AND idClube=:idClube";
			
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("id", perfil.getId());
			parameters.put("idClube", perfil.getIdClube());
			parameters.put("nome", perfil.getNome());
	 
			this.namedParameterJdbcTemplate.update(sql, parameters);
			
		} catch (Exception e) {
			LOGGER.error("Erro ao atualizar um Perfil no banco de dados.");
			e.printStackTrace();
			throw(e);
		}		
		
	}


	@Override
	public void excluirPerfil(Perfil perfil) {
		
		try {
			
			String sql = "DELETE FROM perfil WHERE id=:id and idClube=:idClube";
			
			Map<String, Object> parameters = new HashMap<String, Object>();			
			parameters.put("id", perfil.getId());
			parameters.put("idClube", perfil.getIdClube());
	 
			this.namedParameterJdbcTemplate.update(sql, parameters);
			
		} catch (Exception e) {
			LOGGER.error("Erro ao excluir um Perfil do banco de dados.");
			e.printStackTrace();
			throw(e);
		}
		
	}


	@Override
	public List<Exercicio> listarExercicios(Long idClube) {
		
		List<Exercicio> lista = new ArrayList<Exercicio>();
		
		Map<String, Object> parameters = new HashMap<String, Object>();			
		parameters.put("idClube", idClube);
		
		try {
	        
	        lista = namedParameterJdbcTemplate.query("SELECT id, idClube, nome, descricao FROM exercicio WHERE idClube = :idClube ORDER BY nome", parameters, new ExercicioRowMapper());	        
	        
		} catch (Exception e) {
			LOGGER.error("Erro ao recuperar a lista de Exercícios do banco de dados.");
			e.printStackTrace();
			throw e;			
		}
		
        return lista;
	}
	
	public class ExercicioRowMapper implements RowMapper<Exercicio>	{
		public Exercicio mapRow(ResultSet rs, int rowNum) throws SQLException {
			Exercicio exercicio = new Exercicio();
			exercicio.setId(rs.getLong("id"));
			exercicio.setIdClube(rs.getLong("idClube"));	
			exercicio.setNome(rs.getString("nome"));
			exercicio.setDescricao(rs.getString("descricao"));
			return exercicio;
		}	 
	}


	@Override
	public void excluirExercicio(Exercicio exercicio) {

		try {
			
			String sql = "DELETE FROM exercicio WHERE id=:id and idClube=:idClube";
			
			Map<String, Object> parameters = new HashMap<String, Object>();			
			parameters.put("id", exercicio.getId());
			parameters.put("idClube", exercicio.getIdClube());
	 
			this.namedParameterJdbcTemplate.update(sql, parameters);
			
		} catch (Exception e) {
			LOGGER.error("Erro ao excluir um Exercício do banco de dados.");
			e.printStackTrace();
			throw(e);
		}
	}


	@Override
	public void editarExercicio(Exercicio exercicio) {

		try {
			
			String sql = "UPDATE exercicio SET nome=:nome, descricao=:descricao WHERE id=:id AND idClube=:idClube";
			
			Map<String, Object> parameters = new HashMap<String, Object>(4);
			parameters.put("id", exercicio.getId());
			parameters.put("idClube", exercicio.getIdClube());
			parameters.put("nome", exercicio.getNome());
			parameters.put("descricao", exercicio.getDescricao());
	 
			this.namedParameterJdbcTemplate.update(sql, parameters);
			
		} catch (Exception e) {
			LOGGER.error("Erro ao atualizar um Exercicio no banco de dados.");
			e.printStackTrace();
			throw(e);
		}		
	}


	@Override
	public Exercicio criarExercicio(Exercicio exercicio) {
		
		try {
			
			Map<String, Object> parameters = new HashMap<String, Object>(3);
	        parameters.put("nome", exercicio.getNome());
	        parameters.put("idClube", exercicio.getIdClube());
	        parameters.put("descricao", exercicio.getDescricao());
	        
	        Long id = (Long) this.exercicioSimpleJdbcInsert.executeAndReturnKey(parameters);
	        
	        exercicio.setId(id);
			
		} catch (Exception e) {
			LOGGER.error("Erro ao inserir uma novo Exercício no banco de dados.");
			e.printStackTrace();
			throw(e);
		}
		
		return exercicio;
	}


	@Override
	public List<LocalDor> listarLocalDor(Long idClube) {

		List<LocalDor> lista = new ArrayList<LocalDor>();
		
		Map<String, Object> parameters = new HashMap<String, Object>();			
		parameters.put("idClube", idClube);
		
		try {
	        
	        lista = namedParameterJdbcTemplate.query("SELECT id, idClube, nome FROM localdor WHERE idClube = :idClube ORDER BY nome", parameters, new LocalDorRowMapper());	        
	        
		} catch (Exception e) {
			LOGGER.error("Erro ao recuperar a lista de Local de Dor do banco de dados.");
			e.printStackTrace();
			throw e;			
		}
		
        return lista;
	}
	
	public class LocalDorRowMapper implements RowMapper<LocalDor>	{
		public LocalDor mapRow(ResultSet rs, int rowNum) throws SQLException {
			LocalDor localDor = new LocalDor();
			localDor.setId(rs.getLong("id"));
			localDor.setIdClube(rs.getLong("idClube"));	
			localDor.setNome(rs.getString("nome"));			
			return localDor;
		}	 
	}


	@Override
	public LocalDor criarLocalDor(LocalDor localDor) {

		try {
			
			Map<String, Object> parameters = new HashMap<String, Object>(2);
	        parameters.put("nome", localDor.getNome());
	        parameters.put("idClube", localDor.getIdClube());	        
	        
	        Long id = (Long) this.localDorSimpleJdbcInsert.executeAndReturnKey(parameters);
	        
	        localDor.setId(id);
			
		} catch (Exception e) {
			LOGGER.error("Erro ao inserir uma novo Local de Dor no banco de dados.");
			e.printStackTrace();
			throw(e);
		}
		
		return localDor;
	}


	@Override
	public void editarLocalDor(LocalDor localDor) {
		
		try {
			
			String sql = "UPDATE localdor SET nome=:nome WHERE id=:id AND idClube=:idClube";
			
			Map<String, Object> parameters = new HashMap<String, Object>(3);
			parameters.put("id", localDor.getId());
			parameters.put("idClube", localDor.getIdClube());
			parameters.put("nome", localDor.getNome());
	 
			this.namedParameterJdbcTemplate.update(sql, parameters);
			
		} catch (Exception e) {
			LOGGER.error("Erro ao atualizar um Local de Dor no banco de dados.");
			e.printStackTrace();
			throw(e);
		}		
		
	}


	@Override
	public void excluirLocalDor(LocalDor localDor) {

		try {
			
			String sql = "DELETE FROM localdor WHERE id=:id and idClube=:idClube";
			
			Map<String, Object> parameters = new HashMap<String, Object>();			
			parameters.put("id", localDor.getId());
			parameters.put("idClube", localDor.getIdClube());
	 
			this.namedParameterJdbcTemplate.update(sql, parameters);
			
		} catch (Exception e) {
			LOGGER.error("Erro ao excluir um Local de Dor do banco de dados.");
			e.printStackTrace();
			throw(e);
		}
		
	}


	@Override
	public List<TipoTreinamentoFisico> listarTipoTreinamentoFisico(Long idClube) {

		List<TipoTreinamentoFisico> lista = new ArrayList<TipoTreinamentoFisico>();
		
		Map<String, Object> parameters = new HashMap<String, Object>();			
		parameters.put("idClube", idClube);
		
		try {
	        
	        lista = namedParameterJdbcTemplate.query("SELECT id, idClube, nome FROM tipotreinamentofisico WHERE idClube = :idClube ORDER BY nome", parameters, new TipoTreinamentoFisicoRowMapper());	        
	        
		} catch (Exception e) {
			LOGGER.error("Erro ao recuperar a lista de Tpos de Treinamento Físicos do banco de dados.");
			e.printStackTrace();
			throw e;			
		}
		
        return lista;
	}
	
	public class TipoTreinamentoFisicoRowMapper implements RowMapper<TipoTreinamentoFisico>	{
		public TipoTreinamentoFisico mapRow(ResultSet rs, int rowNum) throws SQLException {
			TipoTreinamentoFisico tipoTreinamentoFisico = new TipoTreinamentoFisico();
			tipoTreinamentoFisico.setId(rs.getLong("id"));
			tipoTreinamentoFisico.setIdClube(rs.getLong("idClube"));	
			tipoTreinamentoFisico.setNome(rs.getString("nome"));			
			return tipoTreinamentoFisico;
		}	 
	}


	@Override
	public TipoTreinamentoFisico criarTipoTreinamentoFisico(TipoTreinamentoFisico tipoTreinamentoFisico) {

		try {
			
			Map<String, Object> parameters = new HashMap<String, Object>(2);
	        parameters.put("nome", tipoTreinamentoFisico.getNome());
	        parameters.put("idClube", tipoTreinamentoFisico.getIdClube());	        
	        
	        Long id = (Long) this.tipoTreinamentoFisicoSimpleJdbcInsert.executeAndReturnKey(parameters);
	        
	        tipoTreinamentoFisico.setId(id);
			
		} catch (Exception e) {
			LOGGER.error("Erro ao inserir uma novo Tipo de treinamento Físico no banco de dados.");
			e.printStackTrace();
			throw(e);
		}
		
		return tipoTreinamentoFisico;
		
	}


	@Override
	public void editarTipoTreinamentoFisico(TipoTreinamentoFisico tipoTreinamentoFisico) {

		try {
			
			String sql = "UPDATE tipotreinamentofisico SET nome=:nome WHERE id=:id AND idClube=:idClube";
			
			Map<String, Object> parameters = new HashMap<String, Object>(3);
			parameters.put("id", tipoTreinamentoFisico.getId());
			parameters.put("idClube", tipoTreinamentoFisico.getIdClube());
			parameters.put("nome", tipoTreinamentoFisico.getNome());
	 
			this.namedParameterJdbcTemplate.update(sql, parameters);
			
		} catch (Exception e) {
			LOGGER.error("Erro ao atualizar um Tipo de treinamento Físico no banco de dados.");
			e.printStackTrace();
			throw(e);
		}		
	}


	@Override
	public void excluirTipoTreinamentoFisico(TipoTreinamentoFisico tipoTreinamentoFisico) {

		try {
			
			String sql = "DELETE FROM tipotreinamentofisico WHERE id=:id and idClube=:idClube";
			
			Map<String, Object> parameters = new HashMap<String, Object>();			
			parameters.put("id", tipoTreinamentoFisico.getId());
			parameters.put("idClube", tipoTreinamentoFisico.getIdClube());
	 
			this.namedParameterJdbcTemplate.update(sql, parameters);
			
		} catch (Exception e) {
			LOGGER.error("Erro ao excluir um Tipo de treinamento Físico do banco de dados.");
			e.printStackTrace();
			throw(e);
		}
		
	}


	@Override
	public List<TipoTreinamentoTecnico> listarTipoTreinamentoTecnico(Long idClube) {
		
		List<TipoTreinamentoTecnico> lista = new ArrayList<TipoTreinamentoTecnico>();
		
		Map<String, Object> parameters = new HashMap<String, Object>();			
		parameters.put("idClube", idClube);
		
		try {
	        
	        lista = namedParameterJdbcTemplate.query("SELECT id, idClube, nome FROM tipotreinamentotecnico WHERE idClube = :idClube ORDER BY nome", parameters, new TipoTreinamentoTecnicoRowMapper());	        
	        
		} catch (Exception e) {
			LOGGER.error("Erro ao recuperar a lista de Tpos de Treinamento Tecnicos do banco de dados.");
			e.printStackTrace();
			throw e;			
		}
		
        return lista;
	}
	
	public class TipoTreinamentoTecnicoRowMapper implements RowMapper<TipoTreinamentoTecnico>	{
		public TipoTreinamentoTecnico mapRow(ResultSet rs, int rowNum) throws SQLException {
			TipoTreinamentoTecnico tipoTreinamentoTecnico = new TipoTreinamentoTecnico();
			tipoTreinamentoTecnico.setId(rs.getLong("id"));
			tipoTreinamentoTecnico.setIdClube(rs.getLong("idClube"));	
			tipoTreinamentoTecnico.setNome(rs.getString("nome"));			
			return tipoTreinamentoTecnico;
		}	 
	}


	@Override
	public TipoTreinamentoTecnico criarTipoTreinamentoTecnico(TipoTreinamentoTecnico tipoTreinamentoTecnico) {
		
		try {
			
			Map<String, Object> parameters = new HashMap<String, Object>(2);
	        parameters.put("nome", tipoTreinamentoTecnico.getNome());
	        parameters.put("idClube", tipoTreinamentoTecnico.getIdClube());	        
	        
	        Long id = (Long) this.tipoTreinamentoTecnicoSimpleJdbcInsert.executeAndReturnKey(parameters);
	        
	        tipoTreinamentoTecnico.setId(id);
			
		} catch (Exception e) {
			LOGGER.error("Erro ao inserir uma novo Tipo de treinamento tecnico no banco de dados.");
			e.printStackTrace();
			throw(e);
		}
		
		return tipoTreinamentoTecnico;
	}


	@Override
	public void editarTipoTreinamentoTecnico(TipoTreinamentoTecnico tipoTreinamentoTecnico) {
		
		try {
			
			String sql = "UPDATE tipotreinamentotecnico SET nome=:nome WHERE id=:id AND idClube=:idClube";
			
			Map<String, Object> parameters = new HashMap<String, Object>(3);
			parameters.put("id", tipoTreinamentoTecnico.getId());
			parameters.put("idClube", tipoTreinamentoTecnico.getIdClube());
			parameters.put("nome", tipoTreinamentoTecnico.getNome());
	 
			this.namedParameterJdbcTemplate.update(sql, parameters);
			
		} catch (Exception e) {
			LOGGER.error("Erro ao atualizar um Tipo de treinamento Tecnico no banco de dados.");
			e.printStackTrace();
			throw(e);
		}	
		
	}


	@Override
	public void excluirTipoTreinamentoTecnico(TipoTreinamentoTecnico tipoTreinamentoTecnico) {

		try {
			
			String sql = "DELETE FROM tipotreinamentotecnico WHERE id=:id and idClube=:idClube";
			
			Map<String, Object> parameters = new HashMap<String, Object>();			
			parameters.put("id", tipoTreinamentoTecnico.getId());
			parameters.put("idClube", tipoTreinamentoTecnico.getIdClube());
	 
			this.namedParameterJdbcTemplate.update(sql, parameters);
			
		} catch (Exception e) {
			LOGGER.error("Erro ao excluir um Tipo de treinamento Tecnico do banco de dados.");
			e.printStackTrace();
			throw(e);
		}
		
	}


	@Override
	public List<TipoTreinamentoTatico> listarTipoTreinamentoTatico(Long idClube) {

		List<TipoTreinamentoTatico> lista = new ArrayList<TipoTreinamentoTatico>();
		
		Map<String, Object> parameters = new HashMap<String, Object>();			
		parameters.put("idClube", idClube);
		
		try {
	        
	        lista = namedParameterJdbcTemplate.query("SELECT id, idClube, nome FROM tipotreinamentotatico WHERE idClube = :idClube ORDER BY nome", parameters, new TipoTreinamentoTaticoRowMapper());	        
	        
		} catch (Exception e) {
			LOGGER.error("Erro ao recuperar a lista de Tpos de Treinamento Taticos do banco de dados.");
			e.printStackTrace();
			throw e;			
		}
		
        return lista;
	}
	
	public class TipoTreinamentoTaticoRowMapper implements RowMapper<TipoTreinamentoTatico>	{
		public TipoTreinamentoTatico mapRow(ResultSet rs, int rowNum) throws SQLException {
			TipoTreinamentoTatico tipoTreinamentoTatico = new TipoTreinamentoTatico();
			tipoTreinamentoTatico.setId(rs.getLong("id"));
			tipoTreinamentoTatico.setIdClube(rs.getLong("idClube"));	
			tipoTreinamentoTatico.setNome(rs.getString("nome"));			
			return tipoTreinamentoTatico;
		}	 
	}


	@Override
	public TipoTreinamentoTatico criarTipoTreinamentoTatico(TipoTreinamentoTatico tipoTreinamentoTatico) {
		
		try {
			
			Map<String, Object> parameters = new HashMap<String, Object>(2);
	        parameters.put("nome", tipoTreinamentoTatico.getNome());
	        parameters.put("idClube", tipoTreinamentoTatico.getIdClube());	        
	        
	        Long id = (Long) this.tipoTreinamentoTaticoSimpleJdbcInsert.executeAndReturnKey(parameters);
	        
	        tipoTreinamentoTatico.setId(id);
			
		} catch (Exception e) {
			LOGGER.error("Erro ao inserir uma novo Tipo de Treinamento Tático no banco de dados.");
			e.printStackTrace();
			throw(e);
		}
		
		return tipoTreinamentoTatico;
	}


	@Override
	public void editarTipoTreinamentoTatico(TipoTreinamentoTatico tipoTreinamentoTatico) {

		try {
			
			String sql = "UPDATE tipotreinamentotatico SET nome=:nome WHERE id=:id AND idClube=:idClube";
			
			Map<String, Object> parameters = new HashMap<String, Object>(3);
			parameters.put("id", tipoTreinamentoTatico.getId());
			parameters.put("idClube", tipoTreinamentoTatico.getIdClube());
			parameters.put("nome", tipoTreinamentoTatico.getNome());
	 
			this.namedParameterJdbcTemplate.update(sql, parameters);
			
		} catch (Exception e) {
			LOGGER.error("Erro ao atualizar um Tipo de Treinamento Tático no banco de dados.");
			e.printStackTrace();
			throw(e);
		}	
		
	}


	@Override
	public void excluirTipoTreinamentoTatico(TipoTreinamentoTatico tipoTreinamentoTatico) {

		try {
			
			String sql = "DELETE FROM tipotreinamentotatico WHERE id=:id and idClube=:idClube";
			
			Map<String, Object> parameters = new HashMap<String, Object>();			
			parameters.put("id", tipoTreinamentoTatico.getId());
			parameters.put("idClube", tipoTreinamentoTatico.getIdClube());
	 
			this.namedParameterJdbcTemplate.update(sql, parameters);
			
		} catch (Exception e) {
			LOGGER.error("Erro ao excluir um Tipo de Treinamento Tático do banco de dados.");
			e.printStackTrace();
			throw(e);
		}
		
	}


	@Override
	public List<LocalTreino> listarLocalTreino(Long idClube) {

		List<LocalTreino> lista = new ArrayList<LocalTreino>();
		
		Map<String, Object> parameters = new HashMap<String, Object>();			
		parameters.put("idClube", idClube);
		
		try {
	        
	        lista = namedParameterJdbcTemplate.query("SELECT id, idClube, nome FROM localtreino WHERE idClube = :idClube ORDER BY nome", parameters, new LocalTreinoRowMapper());	        
	        
		} catch (Exception e) {
			LOGGER.error("Erro ao recuperar a lista de Locais de Treino do banco de dados.");
			e.printStackTrace();
			throw e;			
		}
		
        return lista;
	}
	
	public class LocalTreinoRowMapper implements RowMapper<LocalTreino>	{
		public LocalTreino mapRow(ResultSet rs, int rowNum) throws SQLException {
			LocalTreino localTreino = new LocalTreino();
			localTreino.setId(rs.getLong("id"));
			localTreino.setIdClube(rs.getLong("idClube"));	
			localTreino.setNome(rs.getString("nome"));			
			return localTreino;
		}	 
	}


	@Override
	public LocalTreino criarLocalTreino(LocalTreino localTreino) {

		try {
			
			Map<String, Object> parameters = new HashMap<String, Object>(2);
	        parameters.put("nome", localTreino.getNome());
	        parameters.put("idClube", localTreino.getIdClube());	        
	        
	        Long id = (Long) this.localTreinoSimpleJdbcInsert.executeAndReturnKey(parameters);
	        
	        localTreino.setId(id);
			
		} catch (Exception e) {
			LOGGER.error("Erro ao inserir uma novo Local de Treino no banco de dados.");
			e.printStackTrace();
			throw(e);
		}
		
		return localTreino;
	}


	@Override
	public void editarLocalTreino(LocalTreino localTreino) {

		try {
			
			String sql = "UPDATE localtreino SET nome=:nome WHERE id=:id AND idClube=:idClube";
			
			Map<String, Object> parameters = new HashMap<String, Object>(3);
			parameters.put("id", localTreino.getId());
			parameters.put("idClube", localTreino.getIdClube());
			parameters.put("nome", localTreino.getNome());
	 
			this.namedParameterJdbcTemplate.update(sql, parameters);
			
		} catch (Exception e) {
			LOGGER.error("Erro ao atualizar um Local de Treino no banco de dados.");
			e.printStackTrace();
			throw(e);
		}	
	}


	@Override
	public void excluirLocalTreino(LocalTreino localTreino) {

		try {
			
			String sql = "DELETE FROM localtreino WHERE id=:id and idClube=:idClube";
			
			Map<String, Object> parameters = new HashMap<String, Object>();			
			parameters.put("id", localTreino.getId());
			parameters.put("idClube", localTreino.getIdClube());
	 
			this.namedParameterJdbcTemplate.update(sql, parameters);
			
		} catch (Exception e) {
			LOGGER.error("Erro ao excluir um Local de Treino do banco de dados.");
			e.printStackTrace();
			throw(e);
		}
		
	}


	@Override
	public List<TipoSessao> listarTipoSessao(Long idClube) {

		List<TipoSessao> lista = new ArrayList<TipoSessao>();
		
		Map<String, Object> parameters = new HashMap<String, Object>();			
		parameters.put("idClube", idClube);
		
		try {
	        
	        lista = namedParameterJdbcTemplate.query("SELECT id, idClube, nome FROM tiposessao WHERE idClube = :idClube ORDER BY nome", parameters, new TipoSessaoRowMapper());	        
	        
		} catch (Exception e) {
			LOGGER.error("Erro ao recuperar a lista de Tipos de Sessão do banco de dados.");
			e.printStackTrace();
			throw e;			
		}
		
        return lista;
	}
	
	public class TipoSessaoRowMapper implements RowMapper<TipoSessao>	{
		public TipoSessao mapRow(ResultSet rs, int rowNum) throws SQLException {
			TipoSessao tipoSessao = new TipoSessao();
			tipoSessao.setId(rs.getLong("id"));
			tipoSessao.setIdClube(rs.getLong("idClube"));	
			tipoSessao.setNome(rs.getString("nome"));			
			return tipoSessao;
		}	 
	}


	@Override
	public TipoSessao criarTipoSessao(TipoSessao tipoSessao) {

		try {
			
			Map<String, Object> parameters = new HashMap<String, Object>(2);
	        parameters.put("nome", tipoSessao.getNome());
	        parameters.put("idClube", tipoSessao.getIdClube());	        
	        
	        Long id = (Long) this.tipoSessaoSimpleJdbcInsert.executeAndReturnKey(parameters);
	        
	        tipoSessao.setId(id);
			
		} catch (Exception e) {
			LOGGER.error("Erro ao inserir uma novo Tipo de Sessão no banco de dados.");
			e.printStackTrace();
			throw(e);
		}
		
		return tipoSessao;
	}


	@Override
	public void editarTipoSessao(TipoSessao tipoSessao) {

		try {
			
			Map<String, Object> parameters = new HashMap<String, Object>(3);
			parameters.put("id", tipoSessao.getId());
			parameters.put("idClube", tipoSessao.getIdClube());
			parameters.put("nome", tipoSessao.getNome());
	 
			this.namedParameterJdbcTemplate.update("UPDATE tiposessao SET nome=:nome WHERE id=:id AND idClube=:idClube", parameters);
			
		} catch (Exception e) {
			LOGGER.error("Erro ao atualizar um Tipo de Sessão no banco de dados.");
			e.printStackTrace();
			throw(e);
		}	
		
	}


	@Override
	public void excluirTipoSessao(TipoSessao tipoSessao) {

		try {
			
			Map<String, Object> parameters = new HashMap<String, Object>();			
			parameters.put("id", tipoSessao.getId());
			parameters.put("idClube", tipoSessao.getIdClube());
	 
			this.namedParameterJdbcTemplate.update("DELETE FROM tiposessao WHERE id=:id and idClube=:idClube", parameters);
			
		} catch (Exception e) {
			LOGGER.error("Erro ao excluir um Tipo de Sessão do banco de dados.");
			e.printStackTrace();
			throw(e);
		}

	}


	@Override
	public List<Periodo> listarPeriodo(Long idClube) {

		List<Periodo> lista = new ArrayList<Periodo>();
		
		Map<String, Object> parameters = new HashMap<String, Object>();			
		parameters.put("idClube", idClube);
		
		try {
	        
	        lista = namedParameterJdbcTemplate.query("SELECT id, idClube, nome FROM periodo WHERE idClube = :idClube ORDER BY id", parameters, new PeriodoRowMapper());	        
	        
		} catch (Exception e) {
			LOGGER.error("Erro ao recuperar a lista de Períodos do banco de dados.");
			e.printStackTrace();
			throw e;			
		}
		
        return lista;
	}
	
	public class PeriodoRowMapper implements RowMapper<Periodo>	{
		public Periodo mapRow(ResultSet rs, int rowNum) throws SQLException {
			Periodo periodo = new Periodo();
			periodo.setId(rs.getLong("id"));
			periodo.setIdClube(rs.getLong("idClube"));	
			periodo.setNome(rs.getString("nome"));			
			return periodo;
		}	 
	}


	@Override
	public Periodo criarPeriodo(Periodo periodo) {

		try {
			
			Map<String, Object> parameters = new HashMap<String, Object>(2);
	        parameters.put("nome", periodo.getNome());
	        parameters.put("idClube", periodo.getIdClube());	        
	        
	        Long id = (Long) this.periodoSimpleJdbcInsert.executeAndReturnKey(parameters);
	        
	        periodo.setId(id);
			
		} catch (Exception e) {
			LOGGER.error("Erro ao inserir uma novo Período no banco de dados.");
			e.printStackTrace();
			throw(e);
		}
		
		return periodo;
	}


	@Override
	public void editarPeriodo(Periodo periodo) {

		try {
			
			Map<String, Object> parameters = new HashMap<String, Object>(3);
			parameters.put("id", periodo.getId());
			parameters.put("idClube", periodo.getIdClube());
			parameters.put("nome", periodo.getNome());
	 
			this.namedParameterJdbcTemplate.update("UPDATE periodo SET nome=:nome WHERE id=:id AND idClube=:idClube", parameters);
			
		} catch (Exception e) {
			LOGGER.error("Erro ao atualizar um Período no banco de dados.");
			e.printStackTrace();
			throw(e);
		}	
		
	}


	@Override
	public void excluirPeriodo(Periodo periodo) {

		try {
			
			Map<String, Object> parameters = new HashMap<String, Object>();			
			parameters.put("id", periodo.getId());
			parameters.put("idClube", periodo.getIdClube());
	 
			this.namedParameterJdbcTemplate.update("DELETE FROM periodo WHERE id=:id and idClube=:idClube", parameters);
			
		} catch (Exception e) {
			LOGGER.error("Erro ao excluir um Período do banco de dados.");
			e.printStackTrace();
			throw(e);
		}
		
	}


	@Override
	public List<Grupo> listarGrupo(Long idClube) {

		List<Grupo> lista = new ArrayList<Grupo>();
		
		Map<String, Object> parameters = new HashMap<String, Object>();			
		parameters.put("idClube", idClube);
		
		try {
	        
	        lista = namedParameterJdbcTemplate.query("SELECT id, idClube, nome FROM grupo WHERE idClube = :idClube ORDER BY nome DESC ", parameters, new GrupoRowMapper());	        
	        
		} catch (Exception e) {
			LOGGER.error("Erro ao recuperar a lista de Períodos do banco de dados.");
			e.printStackTrace();
			throw e;			
		}
		
        return lista;
	}
	
	public class GrupoRowMapper implements RowMapper<Grupo>	{
		public Grupo mapRow(ResultSet rs, int rowNum) throws SQLException {
			Grupo grupo = new Grupo();
			grupo.setId(rs.getLong("id"));
			grupo.setIdClube(rs.getLong("idClube"));	
			grupo.setNome(rs.getString("nome"));			
			return grupo;
		}	 
	}


	@Override
	public Grupo criarGrupo(Grupo grupo) {

		try {
			
			Map<String, Object> parameters = new HashMap<String, Object>(2);
	        parameters.put("nome", grupo.getNome());
	        parameters.put("idClube", grupo.getIdClube());	        
	        
	        Long id = (Long) this.grupoSimpleJdbcInsert.executeAndReturnKey(parameters);
	        
	        grupo.setId(id);
			
		} catch (Exception e) {
			LOGGER.error("Erro ao inserir uma novo Grupo no banco de dados.");
			e.printStackTrace();
			throw(e);
		}
		
		return grupo;
	}


	@Override
	public void editarGrupo(Grupo grupo) {

		try {
			
			Map<String, Object> parameters = new HashMap<String, Object>(3);
			parameters.put("id", grupo.getId());
			parameters.put("idClube", grupo.getIdClube());
			parameters.put("nome", grupo.getNome());
	 
			this.namedParameterJdbcTemplate.update("UPDATE grupo SET nome=:nome WHERE id=:id AND idClube=:idClube", parameters);
			
		} catch (Exception e) {
			LOGGER.error("Erro ao atualizar um Grupo no banco de dados.");
			e.printStackTrace();
			throw(e);
		}	
		
	}


	@Override
	public void excluirGrupo(Grupo grupo) {

		try {
			
			Map<String, Object> parameters = new HashMap<String, Object>();			
			parameters.put("id", grupo.getId());
			parameters.put("idClube", grupo.getIdClube());
	 
			this.namedParameterJdbcTemplate.update("DELETE FROM grupo WHERE id=:id and idClube=:idClube", parameters);
			
		} catch (Exception e) {
			LOGGER.error("Erro ao excluir um Grupo do banco de dados.");
			e.printStackTrace();
			throw(e);
		}
		
	}


	@Override
	public List<Especial> listarEspecial(Long idClube) {
		
		List<Especial> lista = new ArrayList<Especial>();
		
		Map<String, Object> parameters = new HashMap<String, Object>();			
		parameters.put("idClube", idClube);
		
		try {
	        
	        lista = namedParameterJdbcTemplate.query("SELECT id, idClube, nome FROM especial WHERE idClube = :idClube ORDER BY nome", parameters, new EspecialRowMapper());	        
	        
		} catch (Exception e) {
			LOGGER.error("Erro ao recuperar a lista de Especiais do banco de dados.");
			e.printStackTrace();
			throw e;			
		}
		
        return lista;
	}
	
	public class EspecialRowMapper implements RowMapper<Especial>	{
		public Especial mapRow(ResultSet rs, int rowNum) throws SQLException {
			Especial especial = new Especial();
			especial.setId(rs.getLong("id"));
			especial.setIdClube(rs.getLong("idClube"));	
			especial.setNome(rs.getString("nome"));			
			return especial;
		}	 
	}


	@Override
	public void excluirEspecial(Especial especial) {
		
		try {
			
			Map<String, Object> parameters = new HashMap<String, Object>();			
			parameters.put("id", especial.getId());
			parameters.put("idClube", especial.getIdClube());
	 
			this.namedParameterJdbcTemplate.update("DELETE FROM especial WHERE id=:id and idClube=:idClube", parameters);
			
		} catch (Exception e) {
			LOGGER.error("Erro ao excluir um Especial do banco de dados.");
			e.printStackTrace();
			throw(e);
		}
		
	}


	@Override
	public void editarEspecial(Especial especial) {
		
		try {
			
			Map<String, Object> parameters = new HashMap<String, Object>(3);
			parameters.put("id", especial.getId());
			parameters.put("idClube", especial.getIdClube());
			parameters.put("nome", especial.getNome());
	 
			this.namedParameterJdbcTemplate.update("UPDATE especial SET nome=:nome WHERE id=:id AND idClube=:idClube", parameters);
			
		} catch (Exception e) {
			LOGGER.error("Erro ao atualizar um Especial no banco de dados.");
			e.printStackTrace();
			throw(e);
		}	
		
	}


	@Override
	public Especial criarEspecial(Especial especial) {

		try {
			
			Map<String, Object> parameters = new HashMap<String, Object>(2);
	        parameters.put("nome", especial.getNome());
	        parameters.put("idClube", especial.getIdClube());	        
	        
	        Long id = (Long) this.especialSimpleJdbcInsert.executeAndReturnKey(parameters);
	        
	        especial.setId(id);
			
		} catch (Exception e) {
			LOGGER.error("Erro ao inserir uma novo Espceial no banco de dados.");
			e.printStackTrace();
			throw(e);
		}
		
		return especial;
	}




}
