/**
 * 
 */
package br.com.qtslive.treinamento.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.qtslive.atleta.facade.AtletaServiceFacade;
import br.com.qtslive.configuracoes.facade.ConfiguracaoServiceFacade;
import br.com.qtslive.model.Atleta;
import br.com.qtslive.model.Grupo;
import br.com.qtslive.model.LocalTreino;
import br.com.qtslive.model.Periodo;
import br.com.qtslive.model.TipoTreinamentoFisico;
import br.com.qtslive.model.TipoTreinamentoTatico;
import br.com.qtslive.model.TipoTreinamentoTecnico;
import br.com.qtslive.model.usuario.Usuario;
import br.com.qtslive.utils.Constantes;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * Action para inciar a tela de Treinamentos.
 * 
 * @author Tomás Azevedo
 *
 */
@Controller
@Scope("request")
public class IniciarCalendarioTreinosAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = -6591157024186804835L;
	
	@Autowired
	private ConfiguracaoServiceFacade configuracaoServiceFacade;
	@Autowired
	private AtletaServiceFacade atletaServiceFacade;
	
	private List<Periodo> listaPeriodo = new ArrayList<Periodo>();
	private List<LocalTreino> listaLocalTreino = new ArrayList<LocalTreino>();
	private List<TipoTreinamentoFisico> listaTipoTreinamentoFisico = new  ArrayList<TipoTreinamentoFisico>();
	private List<TipoTreinamentoTatico> listaTipoTreinamentoTatico = new  ArrayList<TipoTreinamentoTatico>();
	private List<TipoTreinamentoTecnico> listaTipoTreinamentoTecnico = new  ArrayList<TipoTreinamentoTecnico>();
	//private List<LocalDor> listaLocalDor = new ArrayList<LocalDor>();
	private List<Atleta> listaAtleta = new ArrayList<Atleta>();
	private List<Grupo> listaGrupo = new ArrayList<Grupo>();
	
	private Map<String, Object> session;
	
	private Long idClube;
	
	public String iniciar() {

		Usuario usuario = obterUsuarioSessao();
		idClube = usuario.getClube().getId();
		
		listaGrupo = configuracaoServiceFacade.listarGrupo(idClube);
		listaPeriodo = configuracaoServiceFacade.listarPeriodo(idClube);
		listaLocalTreino = configuracaoServiceFacade.listarLocalTreino(idClube);
		listaTipoTreinamentoFisico = configuracaoServiceFacade.listarTipoTreinamentoFisico(idClube);
		listaTipoTreinamentoTatico = configuracaoServiceFacade.listarTipoTreinamentoTatico(idClube);
		listaTipoTreinamentoTecnico = configuracaoServiceFacade.listarTipoTreinamentoTecnico(idClube);
		//listaLocalDor = configuracaoServiceFacade.listarLocalDor(idClube);
		if(null!=usuario.getCategoria()) {
			listaAtleta = atletaServiceFacade.listarAtletasCategoria(idClube, usuario.getCategoria().getId());
		} else {
			listaAtleta = atletaServiceFacade.listarAtletas(idClube);
		}
		
		return SUCCESS;
	}
	
	private Usuario obterUsuarioSessao() {
		return (Usuario) session.get(Constantes.USUARIO_SESSION);
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

//	public List<LocalDor> getListaLocalDor() {
//		return listaLocalDor;
//	}
//
//	public void setListaLocalDor(List<LocalDor> listaLocalDor) {
//		this.listaLocalDor = listaLocalDor;
//	}

	public List<Atleta> getListaAtleta() {
		return listaAtleta;
	}

	public void setListaAtleta(List<Atleta> listaAtleta) {
		this.listaAtleta = listaAtleta;
	}

	public Long getIdClube() {
		return idClube;
	}

	public void setIdClube(Long idClube) {
		this.idClube = idClube;
	}
	
	public List<Grupo> getListaGrupo() {
		return listaGrupo;
	}

	public void setListaGrupo(List<Grupo> listaGrupo) {
		this.listaGrupo = listaGrupo;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;		
	}

}
