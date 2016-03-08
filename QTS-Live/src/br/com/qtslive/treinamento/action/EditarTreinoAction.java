/**
 * 
 */
package br.com.qtslive.treinamento.action;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.qtslive.atleta.facade.AtletaServiceFacade;
import br.com.qtslive.configuracoes.facade.ConfiguracaoServiceFacade;
import br.com.qtslive.model.Especial;
import br.com.qtslive.model.Grupo;
import br.com.qtslive.model.LocalDor;
import br.com.qtslive.model.LocalTreino;
import br.com.qtslive.model.Periodo;
import br.com.qtslive.model.TipoTreinamentoFisico;
import br.com.qtslive.model.TipoTreinamentoTatico;
import br.com.qtslive.model.TipoTreinamentoTecnico;
import br.com.qtslive.model.treino.Atividade;
import br.com.qtslive.model.treino.AtletaAtividades;
import br.com.qtslive.model.treino.GrupoAtletas;
import br.com.qtslive.model.treino.Header;
import br.com.qtslive.model.treino.Treino;
import br.com.qtslive.treinamento.facade.TreinoServiceFacade;
import br.com.qtslive.utils.TreinoUtils;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * Action que inicia a tela dos treinos do dia.
 * 
 * @author Tomás Azevedo
 *
 */
@Controller
@Scope("request")
public class EditarTreinoAction extends ActionSupport /*implements SessionAware*/ {

	private static final long serialVersionUID = 4357511798331910999L;
	
	private static Logger LOGGER = LoggerFactory.getLogger(EditarTreinoAction.class);
	
	@Autowired
	private TreinoServiceFacade treinoServiceFacade;
	@Autowired
	private ConfiguracaoServiceFacade configuracaoServiceFacade;
	@Autowired
	private AtletaServiceFacade atletaServiceFacade;
	
	private Header header = new Header();
	
	private List<Periodo> listaPeriodo = new ArrayList<Periodo>();
	private List<Grupo> listaGrupo = new ArrayList<Grupo>();
	private List<LocalTreino> listaLocalTreino = new ArrayList<LocalTreino>();
	private List<TipoTreinamentoFisico> listaTipoTreinamentoFisico = new  ArrayList<TipoTreinamentoFisico>();
	private List<TipoTreinamentoTatico> listaTipoTreinamentoTatico = new  ArrayList<TipoTreinamentoTatico>();
	private List<TipoTreinamentoTecnico> listaTipoTreinamentoTecnico = new  ArrayList<TipoTreinamentoTecnico>();
	private List<LocalDor> listaLocalDor = new ArrayList<LocalDor>();
	//private List<Atleta> listaAtleta = new ArrayList<Atleta>();
	private List<Especial> listaEspecial = new ArrayList<Especial>();
	
	private List<Treino> listaTreino = new ArrayList<Treino>();
	
	//private Map<String, Object> session;
	
	private Long idClube;
	private Long idPeriodo;
	
	public String iniciar() {
		
		//Usuario usuario = obterUsuarioSessao();
		
		idClube = header.getIdClube();
		idPeriodo = header.getPeriodo().getId();
		
		listaGrupo = configuracaoServiceFacade.listarGrupo(idClube);
		listaPeriodo = configuracaoServiceFacade.listarPeriodo(idClube);
		listaLocalTreino = configuracaoServiceFacade.listarLocalTreino(idClube);
		listaTipoTreinamentoFisico = configuracaoServiceFacade.listarTipoTreinamentoFisico(idClube);
		listaTipoTreinamentoTatico = configuracaoServiceFacade.listarTipoTreinamentoTatico(idClube);
		listaTipoTreinamentoTecnico = configuracaoServiceFacade.listarTipoTreinamentoTecnico(idClube);
		listaLocalDor = configuracaoServiceFacade.listarLocalDor(idClube);
		listaEspecial = configuracaoServiceFacade.listarEspecial(idClube);
		/*if(null!=usuario.getCategoria()) {
			listaAtleta = atletaServiceFacade.listarAtletasCategoria(idClube, usuario.getCategoria().getId());
		} else {
			listaAtleta = atletaServiceFacade.listarAtletas(idClube);
		}*/
		
		listaTreino = treinoServiceFacade.listarTreinos(header);
		
		setNomeAtividades(listaTreino);
		
		return SUCCESS;
	}

	/*private Usuario obterUsuarioSessao() {
		return (Usuario) session.get(Constantes.USUARIO_SESSION);
	}*/

	private void setNomeAtividades(List<Treino> lista) {
		
		try {
			
			for (Treino treino : lista) {
				
				for (GrupoAtletas grupoAtleta : treino.getListaGrupoAtletas()) {
					
					for (AtletaAtividades atletaAtividades : grupoAtleta.getListaAtletaAtividades()) {
						
						for (Atividade atividade : atletaAtividades.getListaAtividade()) {
							
							String nomeAtividade = getNomeAtividade(atividade.getCdTipoAtividade(), atividade.getIdAtividade());
							
							atividade.setNomeAtividade(nomeAtividade);
							
						}
						
					}
					
				}
				
			}
			
		} catch (Exception e) {
			LOGGER.error("Erro setar os nomes das atividades nos treinos. ");
			e.printStackTrace();
			throw(e);
		}
		
	}

	private String getNomeAtividade(int cdTipoAtividade, Long idAtividade) {
		
		return TreinoUtils.getNomeAtividade(cdTipoAtividade, idAtividade, listaTipoTreinamentoFisico, listaTipoTreinamentoTatico, listaTipoTreinamentoTecnico);
		
	}

	public List<Periodo> getListaPeriodo() {
		return listaPeriodo;
	}

	public void setListaPeriodo(List<Periodo> listaPeriodo) {
		this.listaPeriodo = listaPeriodo;
	}

	public List<LocalTreino> getListaLocalTreino() {
		return listaLocalTreino;
	}

	public void setListaLocalTreino(List<LocalTreino> listaLocalTreino) {
		this.listaLocalTreino = listaLocalTreino;
	}

	public List<TipoTreinamentoFisico> getListaTipoTreinamentoFisico() {
		return listaTipoTreinamentoFisico;
	}

	public void setListaTipoTreinamentoFisico(
			List<TipoTreinamentoFisico> listaTipoTreinamentoFisico) {
		this.listaTipoTreinamentoFisico = listaTipoTreinamentoFisico;
	}

	public List<TipoTreinamentoTatico> getListaTipoTreinamentoTatico() {
		return listaTipoTreinamentoTatico;
	}

	public void setListaTipoTreinamentoTatico(
			List<TipoTreinamentoTatico> listaTipoTreinamentoTatico) {
		this.listaTipoTreinamentoTatico = listaTipoTreinamentoTatico;
	}

	public List<TipoTreinamentoTecnico> getListaTipoTreinamentoTecnico() {
		return listaTipoTreinamentoTecnico;
	}

	public void setListaTipoTreinamentoTecnico(
			List<TipoTreinamentoTecnico> listaTipoTreinamentoTecnico) {
		this.listaTipoTreinamentoTecnico = listaTipoTreinamentoTecnico;
	}

	public List<LocalDor> getListaLocalDor() {
		return listaLocalDor;
	}

	public void setListaLocalDor(List<LocalDor> listaLocalDor) {
		this.listaLocalDor = listaLocalDor;
	}

	/*public List<Atleta> getListaAtleta() {
		return listaAtleta;
	}

	public void setListaAtleta(List<Atleta> listaAtleta) {
		this.listaAtleta = listaAtleta;
	}*/

	public Long getIdClube() {
		return idClube;
	}

	public void setIdClube(Long idClube) {
		this.idClube = idClube;
	}	
	
	public List<Especial> getListaEspecial() {
		return listaEspecial;
	}

	public void setListaEspecial(List<Especial> listaEspecial) {
		this.listaEspecial = listaEspecial;
	}	

	public List<Treino> getListaTreino() {
		return listaTreino;
	}

	public void setListaTreino(List<Treino> listaTreino) {
		this.listaTreino = listaTreino;
	}	

	public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}

	public Long getIdPeriodo() {
		return idPeriodo;
	}

	public void setIdPeriodo(Long idPeriodo) {
		this.idPeriodo = idPeriodo;
	}

	public List<Grupo> getListaGrupo() {
		return listaGrupo;
	}

	public void setListaGrupo(List<Grupo> listaGrupo) {
		this.listaGrupo = listaGrupo;
	}
	
	

	/*@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;		
	}*/

}
