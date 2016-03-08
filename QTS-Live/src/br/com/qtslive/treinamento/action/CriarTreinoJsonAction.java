/**
 * 
 */
package br.com.qtslive.treinamento.action;

import java.time.LocalDate;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.qtslive.model.Categoria;
import br.com.qtslive.model.Periodo;
import br.com.qtslive.model.treino.Atividade;
import br.com.qtslive.model.treino.AtletaAtividades;
import br.com.qtslive.model.treino.GrupoAtletas;
import br.com.qtslive.model.treino.Treino;
import br.com.qtslive.model.usuario.Usuario;
import br.com.qtslive.treinamento.facade.TreinoServiceFacade;
import br.com.qtslive.utils.Constantes;
import br.com.qtslive.utils.TreinoUtils;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * Action que cria o treino.
 * 
 * @author Tomás Azevedo
 *
 */
@Controller
@Scope("request")
public class CriarTreinoJsonAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 8803178680926627919L;
	
	private Map<String, Object> session;
	
	@Autowired
	private TreinoServiceFacade treinoServiceFacade;
	
	private Treino treino = new Treino();
	
	private String listaAtividade;
	private String listaGrupo;
	
	public String criar() {
		
		treino.setListaGrupoAtletas(TreinoUtils.obterGruposAtltetas(listaGrupo, listaAtividade));
		
		setHeader(treino);
		
		treinoServiceFacade.criar(treino);
		
		return SUCCESS;
	}

	private void setHeader(Treino treino) {	
		
		Usuario usuario = new Usuario();
		usuario =  (Usuario) session.get(Constantes.USUARIO_SESSION);
		
		Long idClube = treino.getIdClube();
		Categoria categoria = usuario.getCategoria();
		LocalDate data = treino.getData();
		Periodo periodo = treino.getPeriodo();
		
		treino.setCategoria(categoria);
		
		for (GrupoAtletas grupoAtletas : treino.getListaGrupoAtletas()) {
			
			grupoAtletas.setIdClube(idClube);
			grupoAtletas.setCategoria(categoria);
			grupoAtletas.setData(data);
			grupoAtletas.setPeriodo(periodo);
			
			for (AtletaAtividades atletaAtividades : grupoAtletas.getListaAtletaAtividades()) {
				
				atletaAtividades.setIdClube(idClube);
				atletaAtividades.setCategoria(categoria);
				atletaAtividades.setData(data);
				atletaAtividades.setPeriodo(periodo);
				
				for (Atividade atividade : atletaAtividades.getListaAtividade()) {
					
					atividade.setIdClube(idClube);
					atividade.setCategoria(categoria);
					atividade.setData(data);
					atividade.setPeriodo(periodo);
					
				}				
				
			}	
			
		}	
		
	}

	public Treino getTreino() {
		return treino;
	}

	public void setTreino(Treino treino) {
		this.treino = treino;
	}

	public String getListaAtividade() {
		return listaAtividade;
	}

	public void setListaAtividade(String listaAtividade) {
		this.listaAtividade = listaAtividade;
	}

	public String getListaGrupo() {
		return listaGrupo;
	}

	public void setListaGrupo(String listaGrupo) {
		this.listaGrupo = listaGrupo;
	}
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;		
	}
	
}
