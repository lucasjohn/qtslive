/**
 * 
 */
package br.com.qtslive.treinamento.dao;

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
import org.springframework.stereotype.Repository;

import br.com.qtslive.model.Atleta;
import br.com.qtslive.model.Categoria;
import br.com.qtslive.model.Especial;
import br.com.qtslive.model.Foto;
import br.com.qtslive.model.Grupo;
import br.com.qtslive.model.LocalDor;
import br.com.qtslive.model.LocalTreino;
import br.com.qtslive.model.Periodo;
import br.com.qtslive.model.treino.Atividade;
import br.com.qtslive.model.treino.AtletaAtividades;
import br.com.qtslive.model.treino.GrupoAtletas;
import br.com.qtslive.model.treino.Header;
import br.com.qtslive.model.treino.Treino;

/**
 * 
 * Implementação da interface TreinoDAO.
 * 
 * @author Tomás Azevedo
 *
 */
@Repository
public class TreinoDAOImpl implements TreinoDAO {
	
	private static Logger LOGGER = LoggerFactory.getLogger(TreinoDAOImpl.class);
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
    public void setDataSource(DataSource dataSource) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }	
	
	@Override
	public boolean criar(Treino treino) {
		
		try {
			
			//Treino
			Map<String, Object> treinoParams = new HashMap<String, Object>(7);
			treinoParams.put("idClube", treino.getIdClube());
			treinoParams.put("idCategoria", treino.getCategoria().getId());
			//treinoParams.put("data", Date.from(treino.getData().atStartOfDay(ZoneId.of("America/Sao_Paulo")).toInstant()));
			treinoParams.put("data", Date.from(treino.getData().atStartOfDay(ZoneId.systemDefault()).toInstant()));			
			treinoParams.put("idPeriodo", treino.getPeriodo().getId());
			//treino.setCodigoTreino(obterCodigoTreino(treino.getIdClube(), treino.getCategoria().getId(), Date.from(treino.getData().atStartOfDay(ZoneId.of("America/Sao_Paulo")).toInstant()), treino.getPeriodo().getId()));
			treino.setCodigoTreino(obterCodigoTreino(treino.getIdClube(), treino.getCategoria().getId(), Date.from(treino.getData().atStartOfDay(ZoneId.systemDefault()).toInstant()), treino.getPeriodo().getId()));			
			treinoParams.put("codigoTreino", treino.getCodigoTreino());
			treinoParams.put("idLocal", treino.getLocalTreino().getId());
			treinoParams.put("pseEsperado", treino.getPseEsperado());	
			
			//Insert
			namedParameterJdbcTemplate
				.update("INSERT INTO treino (idClube, idCategoria, data, idPeriodo, codigoTreino, idLocal, pseEsperado) VALUES (:idClube, :idCategoria, :data, :idPeriodo, :codigoTreino, :idLocal, :pseEsperado)", 
						treinoParams);
			
			for (GrupoAtletas grupoAtletas : treino.getListaGrupoAtletas()) {
				
				Long idGrupo = grupoAtletas.getGrupo().getId();
				
				for (AtletaAtividades atletaAtividades : grupoAtletas.getListaAtletaAtividades()) {
					
					//Grupos
					Map<String, Object> atletaAtividadesParams = new HashMap<String, Object>(13);
					atletaAtividadesParams.put("idClube", atletaAtividades.getIdClube());
					atletaAtividadesParams.put("idCategoria", atletaAtividades.getCategoria().getId());
					//atletaAtividadesParams.put("data", Date.from(atletaAtividades.getData().atStartOfDay(ZoneId.of("America/Sao_Paulo")).toInstant()));
					atletaAtividadesParams.put("data", Date.from(atletaAtividades.getData().atStartOfDay(ZoneId.systemDefault()).toInstant()));					
					atletaAtividadesParams.put("idPeriodo", atletaAtividades.getPeriodo().getId());
					atletaAtividadesParams.put("codigoTreino", treino.getCodigoTreino());
					atletaAtividadesParams.put("idAtleta", atletaAtividades.getAtleta().getId());
					atletaAtividadesParams.put("idGrupo", idGrupo);			
					atletaAtividadesParams.put("gps", atletaAtividades.getGps());
					atletaAtividadesParams.put("idEspecial", atletaAtividades.getEspecial().getId());
					atletaAtividadesParams.put("fad", atletaAtividades.getFad());
					atletaAtividadesParams.put("dmt", atletaAtividades.getDmt());
					atletaAtividadesParams.put("pse", atletaAtividades.getPse());
					atletaAtividadesParams.put("idLocalDor", atletaAtividades.getLocalDor().getId());
					
					StringBuilder sql = new StringBuilder("INSERT INTO treinogrupos (idClube, idCategoria, data, idPeriodo, codigoTreino, idAtleta, idGrupo, gps, idEspecial, fad, dmt, pse, idLocalDor) ");
					                           sql.append("VALUES (:idClube, :idCategoria, :data, :idPeriodo, :codigoTreino, :idAtleta, :idGrupo, :gps, :idEspecial, :fad, :dmt, :pse, :idLocalDor)");
					                           
					namedParameterJdbcTemplate.update(sql.toString(), atletaAtividadesParams);					
					
					Long idAtleta = atletaAtividades.getAtleta().getId();
					
					for (Atividade atividade : atletaAtividades.getListaAtividade()) {
						
						//Atividades
						Map<String, Object> atividadesParams = new HashMap<String, Object>(10);
						atividadesParams.put("idClube", atividade.getIdClube());
						atividadesParams.put("idCategoria", atividade.getCategoria().getId());
						//atividadesParams.put("data", Date.from(atletaAtividades.getData().atStartOfDay(ZoneId.of("America/Sao_Paulo")).toInstant()));
						atividadesParams.put("data", Date.from(atletaAtividades.getData().atStartOfDay(ZoneId.systemDefault()).toInstant()));						
						atividadesParams.put("idPeriodo", atividade.getPeriodo().getId());
						atividadesParams.put("codigoTreino", treino.getCodigoTreino());
						atividadesParams.put("idAtleta", idAtleta);
						atividadesParams.put("idTipoAtividade", atividade.getCdTipoAtividade());
						atividadesParams.put("idAtividade", atividade.getIdAtividade());
						atividadesParams.put("tempo", atividade.getDuracao());
						atividadesParams.put("observacoes", atividade.getObservacoes());
						
						StringBuilder sql2 
							= new StringBuilder("INSERT INTO treinoatividades (idClube, idCategoria, data, idPeriodo, codigoTreino, idAtleta, idTipoAtividade, idAtividade, tempo, observacoes) ");
                                    sql2.append("VALUES (:idClube, :idCategoria, :data, :idPeriodo, :codigoTreino, :idAtleta, :idTipoAtividade, :idAtividade, :tempo, :observacoes)");               
                        
                        namedParameterJdbcTemplate.update(sql2.toString(), atividadesParams);	
						
					}
					
					
				}			
		        
				
			}			
			
			
		} catch (Exception e) {
			LOGGER.error("Erro ao inserir um novo Treino no banco de dados.");
			e.printStackTrace();
			throw(e);
		}
		
		return true;
	}
	
	

	/**
	 * 
	 * Retorna o código do treino disponível.
	 * 
	 * @param idClube - identificador do clube.
	 * @param data - data do treino.
	 * @param idPeriodo - código do turno.
	 * 
	 * @return código do tipo inteiro.
	 * 
	 */
	private int obterCodigoTreino(Long idClube, Long idCategoria, java.util.Date data, Long idPeriodo) {
		
		int codigo = 1;
		
		try {
			
			//Atividades
			Map<String, Object> params = new HashMap<String, Object>(4);
			params.put("idClube", idClube);
			params.put("idCategoria", idCategoria);
			params.put("data", data);
			params.put("idPeriodo", idPeriodo);			
			
			String sql = "SELECT max(codigoTreino) FROM treino WHERE idClube = :idClube AND idCategoria = :idCategoria AND data = :data AND idPeriodo = :idPeriodo ";
			
			Integer ret = namedParameterJdbcTemplate.queryForObject(sql, params, Integer.class);
			
			if(null!=ret) {
				if(ret > 0) {
					codigo = ret + 1;
				}
			}
			
		} catch (Exception e) {
			LOGGER.error("Erro ao obter um código (identificador) para o Treino no banco de dados.");
			e.printStackTrace();
			throw(e);
		}
		
		return codigo;
	}

	@Override
	public Treino obterTreinoSimplificado(Header header) {
		
		return recuperarTreino(header);
		
	}
	
	public class TreinoSimplesRowMapper implements RowMapper<Treino>	{
		public Treino mapRow(ResultSet rs, int rowNum) throws SQLException {
			Treino treino = new Treino();			
			treino.setIdClube(rs.getLong("t.idClube"));
			Categoria categoria = new Categoria();
			categoria.setId(rs.getLong("t.idCategoria"));
			categoria.setNome(rs.getString("c.nome"));
			treino.setCategoria(categoria);
			Date date = rs.getDate("t.data");
			treino.setCodigoTreino(rs.getInt("t.codigoTreino"));
			if(null!=date) {
				treino.setData(date.toLocalDate());				
			}
			Periodo periodo = new Periodo();
			periodo.setIdClube(treino.getIdClube());
			periodo.setId(rs.getLong("t.idPeriodo"));
			periodo.setNome(rs.getString("p.nome"));
			treino.setPeriodo(periodo);
			treino.setCodigoTreino(rs.getInt("t.codigoTreino"));
			LocalTreino localTreino = new LocalTreino();
			localTreino.setIdClube(treino.getIdClube());
			localTreino.setId(rs.getLong("t.idLocal"));
			localTreino.setNome(rs.getString("l.nome"));
			treino.setLocalTreino(localTreino);
			treino.setPseEsperado(rs.getInt("t.pseEsperado"));
			return treino;
		}	 
	}

	@Override
	public List<Treino> listarTreinosSimplificados(Long idClube, Long idCategoria, LocalDate dataInicio, LocalDate dataFim) {
		
		List<Treino> lista = new ArrayList<Treino>();
		
		try {
			
			Map<String, Object> params = new HashMap<String, Object>(12);
			params.put("idClube", idClube);
			params.put("idCategoria", idCategoria);
			//params.put("dataIni", Date.from(dataInicio.atStartOfDay(ZoneId.of("America/Sao_Paulo")).toInstant()));
			params.put("dataIni", Date.from(dataInicio.atStartOfDay(ZoneId.systemDefault()).toInstant()));
			//params.put("dataFim", Date.from(dataFim.atStartOfDay(ZoneId.of("America/Sao_Paulo")).toInstant()));
			params.put("dataFim", Date.from(dataFim.atStartOfDay(ZoneId.systemDefault()).toInstant()));			
			
			StringBuilder sql 
				= new StringBuilder("SELECT t.idClube,  t.idCategoria, c.nome, t.data, t.codigoTreino, t.idPeriodo, p.nome, t.codigoTreino, t.idLocal, l.nome, t.pseEsperado ");
                         sql.append("FROM treino t, periodo p, localtreino l, categoria c ");
                         sql.append("WHERE t.idClube = :idClube ");
                         sql.append("AND t.idClube = p.idClube AND t.idCategoria = :idCategoria AND t.idClube = c.idClube AND t.idCategoria = c.id AND t.idClube = l.idClube AND t.idPeriodo = p.id AND t.idLocal = l.id ");
                         sql.append("AND t.data >= :dataIni AND t.data <= :dataFim ");
                         
            lista = namedParameterJdbcTemplate.query(sql.toString(), params, new TreinoSimplesRowMapper());
			
		} catch (Exception e) {
			LOGGER.error("Erro ao obter a lista de treinos simplificados do banco de dados.");
			e.printStackTrace();
			throw(e);
		}
		
		return lista;
	}

	@Override
	public boolean excluir(Header header) {
			
		boolean sucesso = false;
		
		try {
			
			Map<String, Object> params = new HashMap<String, Object>(12);
			params.put("idClube", header.getIdClube());
			params.put("idCategoria", header.getCategoria().getId());
			//params.put("data", Date.from(header.getData().atStartOfDay(ZoneId.of("America/Sao_Paulo")).toInstant()));
			params.put("data", Date.from(header.getData().atStartOfDay(ZoneId.systemDefault()).toInstant()));			
			//params.put("idPeriodo", header.getPeriodo().getId());
			params.put("codigoTreino", header.getCodigoTreino());
			
			StringBuilder sql = new StringBuilder("DELETE FROM treino, treinogrupos, treinoatividades ");
            sql.append("USING treino INNER JOIN treinogrupos INNER JOIN treinoatividades ");
            sql.append("WHERE treino.idClube = :idClube AND treino.idCategoria = :idCategoria AND treino.data = :data AND treino.codigoTreino = :codigoTreino ");
            sql.append("AND treino.idClube = treinogrupos.idClube AND treino.idClube = treinoatividades.idClube ");
            sql.append("AND treino.idCategoria = treinogrupos.idCategoria AND treino.idCategoria = treinoatividades.idCategoria ");
            sql.append("AND treino.data = treinogrupos.data AND treino.data = treinoatividades.data ");
            sql.append("AND treino.codigoTreino = treinogrupos.codigoTreino AND treino.codigoTreino = treinoatividades.codigoTreino ");
                         
            namedParameterJdbcTemplate.update(sql.toString(), params);
            
            sucesso = true;
			
		} catch (Exception e) {
			LOGGER.error("Erro ao excluir um treino do banco de dados.");
			e.printStackTrace();
			throw(e);
		}
		
		return sucesso;
	}

	@Override
	public Treino obterTreino(Header header) {
		
		Treino treino = new Treino();
		
		treino = recuperarTreino(header);
		
		LOGGER.error("\nTreino " + treino.getPeriodo().getNome());
		
		List<GrupoAtletas> listaGrupoAtletas = recuperarAtletasGrupos(header);
		
		LOGGER.error("\nTreino " + treino.getPeriodo().getNome() + ": grupos = " + listaGrupoAtletas.size());
		
		treino.setListaGrupoAtletas(listaGrupoAtletas);
		
		//Para cada Grupo
		for (GrupoAtletas grupoAtletas : treino.getListaGrupoAtletas()) {
			
			//Para cada Atleta
			for (AtletaAtividades atletaAtividades : grupoAtletas.getListaAtletaAtividades()) {
				
				List<Atividade> listaAtividade = recuperarAtividadesAtleta(header, atletaAtividades.getAtleta().getId());
				
				LOGGER.error("\nTreino " + treino.getPeriodo().getNome() + ": atividades = " + listaAtividade.size());
				
				atletaAtividades.setListaAtividade(listaAtividade);
			}			
			
		}
		
		return treino;
		
	}

	private List<Atividade> recuperarAtividadesAtleta(Header header, Long idAtleta) {
		
		List<Atividade> listaAtividade = new ArrayList<Atividade>();
		
		try {
			
			Map<String, Object> params = new HashMap<String, Object>(6);
			params.put("idClube", header.getIdClube());
			params.put("idCategoria", header.getCategoria().getId());
			//params.put("data", Date.from(header.getData().atStartOfDay(ZoneId.of("America/Sao_Paulo")).toInstant()));
			params.put("data", Date.from(header.getData().atStartOfDay(ZoneId.systemDefault()).toInstant()));			
			params.put("idPeriodo", header.getPeriodo().getId());
			params.put("codigoTreino", header.getCodigoTreino());
			params.put("idAtleta", idAtleta);
			
			StringBuilder sql 
				= new StringBuilder("SELECT idTipoAtividade, idAtividade, tempo, observacoes FROM treinoatividades ");
				         sql.append("WHERE idClube = :idClube AND data = :data AND idCategoria = :idCategoria AND idPeriodo = :idPeriodo AND codigoTreino = :codigoTreino AND idAtleta = :idAtleta ");
				         
            listaAtividade = namedParameterJdbcTemplate.query(sql.toString(), params, new AtividadeRowMapper()); 
			
		} catch (Exception e) {
			LOGGER.error("Erro ao obter a lista de atividades de um atleta do banco de dados.");
			e.printStackTrace();
			throw(e);
		}	
		
		return listaAtividade;
		
	}
	
	public class AtividadeRowMapper implements RowMapper<Atividade>	{
		public Atividade mapRow(ResultSet rs, int rowNum) throws SQLException {
			Atividade atividade = new Atividade();
			atividade.setCdTipoAtividade(rs.getInt("idTipoAtividade"));
			atividade.setIdAtividade(rs.getLong("idAtividade"));
			atividade.setDuracao(rs.getInt("tempo"));
			atividade.setObservacoes(rs.getString("observacoes"));
			return atividade;
		}	 
	}

	/**
	 * @param header - dados identificadores de um treino.
	 * @return lista de grupos de atletas.
	 */
	private List<GrupoAtletas> recuperarAtletasGrupos(Header header) {
		
		List<GrupoAtletas> listaGrupoAtletas = new ArrayList<GrupoAtletas>();
		
		try {
			
			Map<String, Object> params = new HashMap<String, Object>(5);
			params.put("idClube", header.getIdClube());
			params.put("idCategoria", header.getCategoria().getId());
			//params.put("data", Date.from(header.getData().atStartOfDay(ZoneId.of("America/Sao_Paulo")).toInstant()));
			params.put("data", Date.from(header.getData().atStartOfDay(ZoneId.systemDefault()).toInstant()));			
			params.put("idPeriodo", header.getPeriodo().getId());
			params.put("codigoTreino", header.getCodigoTreino());
			
			List<Long> listaCodigosGrupos = namedParameterJdbcTemplate.query("SELECT DISTINCT idGrupo FROM treinogrupos WHERE idClube = :idClube AND data = :data AND idCategoria = :idCategoria AND idPeriodo = :idPeriodo AND codigoTreino = :codigoTreino ", params, new CodigoGrupoRowMapper());
			
			
			for (Long idGrupo : listaCodigosGrupos) {
				
				GrupoAtletas grupoAtletas = new GrupoAtletas();
				
				Map<String, Object> params2 = new HashMap<String, Object>(6);
				params2.put("idClube", header.getIdClube());
				params2.put("idCategoria", header.getCategoria().getId());
				//params2.put("data", Date.from(header.getData().atStartOfDay(ZoneId.of("America/Sao_Paulo")).toInstant()));
				params2.put("data", Date.from(header.getData().atStartOfDay(ZoneId.systemDefault()).toInstant()));				
				params2.put("idPeriodo", header.getPeriodo().getId());
				params2.put("codigoTreino", header.getCodigoTreino());
				params2.put("idGrupo", idGrupo);
				
				StringBuilder sql 
					= new StringBuilder("SELECT g.idAtleta, a.nome, a.apelido, a.idDominancia, a.idFoto, ");
				             sql.append("g.idGrupo, p.nome, g.gps, g.idEspecial, g.fad, g.dmt, g.pse, g.idLocalDor ");
				             sql.append("FROM treinogrupos g, atleta a, grupo p ");
				             sql.append("WHERE g.idClube = :idClube AND g.data = :data AND g.idCategoria = :idCategoria AND g.idPeriodo = :idPeriodo AND g.codigoTreino = :codigoTreino ");
				             sql.append("AND g.idGrupo = :idGrupo AND g.idClube = a.idClube AND g.idAtleta = a.id AND p.id = g.idGrupo AND p.idClube = g.idClube ");
			
				List<AtletaAtividades> listaAtletaAtividades = namedParameterJdbcTemplate.query(sql.toString(), params2, new AtletaAtividadesRowMapper());
				
				Grupo grupo = new Grupo();
				grupo.setId(idGrupo);
				grupoAtletas.setGrupo(grupo);
				grupoAtletas.setIdClube(header.getIdClube());				
				grupoAtletas.setCategoria(header.getCategoria());
				grupoAtletas.setData(header.getData());
				grupoAtletas.setPeriodo(header.getPeriodo());				
				grupoAtletas.setListaAtletaAtividades(listaAtletaAtividades);				
				listaGrupoAtletas.add(grupoAtletas);
				
			}
			
			
			
		} catch (Exception e) {
			LOGGER.error("Erro ao obter a lista de grupos do banco de dados.");
			e.printStackTrace();
			throw(e);
		}		
		
		return listaGrupoAtletas;
	}
	
	public class AtletaAtividadesRowMapper implements RowMapper<AtletaAtividades>	{
		public AtletaAtividades mapRow(ResultSet rs, int rowNum) throws SQLException {
			AtletaAtividades atletaAtividades = new AtletaAtividades();		
			
			Atleta atleta = new Atleta();
			atleta.setId(rs.getLong("g.idAtleta"));
			atleta.setNome(rs.getString("a.nome"));
			atleta.setApelido(rs.getString("a.apelido"));
			Foto foto = new Foto();
			foto.setId(rs.getLong("a.idFoto"));
			atleta.setFoto(foto);
			atletaAtividades.setAtleta(atleta);
			atletaAtividades.setGps(rs.getInt("g.gps"));
			Long idEspecial = rs.getLong("g.idEspecial");
			if(null!=idEspecial) {
				Especial especial = new Especial();
				especial.setId(idEspecial);
				atletaAtividades.setEspecial(especial);
			}
			atletaAtividades.setFad(rs.getInt("g.fad"));
			atletaAtividades.setDmt(rs.getInt("g.dmt"));
			atletaAtividades.setPse(rs.getInt("g.pse"));
			Long idLocalDor = rs.getLong("g.idLocalDor");
			if(null!=idLocalDor) {
				LocalDor localDor = new LocalDor();
				localDor.setId(idEspecial);
				atletaAtividades.setLocalDor(localDor);
			}			
			Grupo grupo = new Grupo();
			grupo.setId(rs.getLong("g.idGrupo"));
			grupo.setNome(rs.getString("p.nome"));
			atletaAtividades.setGrupo(grupo);
		
			return atletaAtividades;
		}	 
	}
	
	public class CodigoGrupoRowMapper implements RowMapper<Long>	{
		public Long mapRow(ResultSet rs, int rowNum) throws SQLException {
			Long codigoGrupo = rs.getLong("idGrupo");
			return codigoGrupo;
		}	 
	}

	/**
	 * @param header - dados identificadores de um treino.
	 * @return um treino simplificado.
	 */
	private Treino recuperarTreino(Header header) {
		
		Treino treino = new Treino();
		
		try {
			
			Map<String, Object> params = new HashMap<String, Object>(12);
			params.put("idClube", header.getIdClube());
			params.put("idCategoria", header.getCategoria().getId());
			//params.put("data", Date.from(header.getData().atStartOfDay(ZoneId.of("America/Sao_Paulo")).toInstant()));
			params.put("data", Date.from(header.getData().atStartOfDay(ZoneId.systemDefault()).toInstant()));			
			params.put("idPeriodo", header.getPeriodo().getId());
			params.put("codigoTreino", header.getCodigoTreino());
			
			StringBuilder sql 
				= new StringBuilder("SELECT t.idClube, t.idCategoria, c.nome, t.data, t.idPeriodo, p.nome, t.codigoTreino, t.idLocal, l.nome, t.pseEsperado ");
                         sql.append("FROM treino t, periodo p, localtreino l, categoria c ");
                         sql.append("WHERE t.idClube = :idClube AND t.idCategoria = :idCategoria AND t.idClube = c.idClube AND t.idCategoria = c.id AND t.data = :data AND t.idPeriodo = :idPeriodo AND t.codigoTreino = :codigoTreino  ");
                         sql.append("AND t.idClube = p.idClube AND t.idPeriodo = p.id AND t.idClube = l.idClube AND t.idLocal = l.id ");
                         
            treino = namedParameterJdbcTemplate.queryForObject(sql.toString(), params, new TreinoSimplesRowMapper());
			
		} catch (Exception e) {
			LOGGER.error("Erro ao obter um treino do banco de dados.");
			e.printStackTrace();
			throw(e);
		}
		
		return treino;
	}

	@Override
	public List<Header> obterTreinosDia(Header header) {

		List<Header> listaHeader = new ArrayList<Header>();
		
		try {
			
			Map<String, Object> params = new HashMap<String, Object>(12);
			params.put("idClube", header.getIdClube());
			params.put("idCategoria", header.getCategoria().getId());
			//params.put("data", Date.from(header.getData().atStartOfDay(ZoneId.of("America/Sao_Paulo")).toInstant()));	
			params.put("data", Date.from(header.getData().atStartOfDay(ZoneId.systemDefault()).toInstant()));			
			
			StringBuilder sql 
				= new StringBuilder("SELECT idClube, idCategoria, data, idPeriodo, codigoTreino ");
                         sql.append("FROM treino WHERE idClube = :idClube AND idCategoria = :idCategoria AND data = :data ");
                         
            listaHeader = namedParameterJdbcTemplate.query(sql.toString(), params, new HeaderRowMapper());            
			
		} catch (Exception e) {
			LOGGER.error("Erro ao obter uma lista de treinos (somente header) de um determinado dia do banco de dados.");
			e.printStackTrace();
			throw(e);
		}
		
		return listaHeader;
		
	}
	
	public class HeaderRowMapper implements RowMapper<Header>	{
		public Header mapRow(ResultSet rs, int rowNum) throws SQLException {
			Header header = new Header();			
			header.setIdClube(rs.getLong("idClube"));
			Categoria categoria = new Categoria();
			categoria.setId(rs.getLong("idCategoria"));
			
			header.setCategoria(categoria);
			Date date = rs.getDate("data");
			header.setCodigoTreino(rs.getInt("codigoTreino"));
			if(null!=date) {
				header.setData(date.toLocalDate());				
			}
			Periodo periodo = new Periodo();
			periodo.setId(rs.getLong("idPeriodo"));
			header.setPeriodo(periodo);
			return header;
		}	 
	}

	

}
