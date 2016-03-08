/**
 * 
 */
package br.com.qtslive.atleta.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.qtslive.atleta.facade.AtletaServiceFacade;
import br.com.qtslive.configuracoes.facade.ConfiguracaoServiceFacade;
import br.com.qtslive.model.Atleta;
import br.com.qtslive.model.Categoria;
import br.com.qtslive.model.Dominancia;
import br.com.qtslive.model.Posicao;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * Action responsável por inicializar a página principal de atletas.
 * 
 * @author Tomás Azevedo
 *
 */
@Controller
@Scope("request")
public class ListarAtletasAction extends ActionSupport {

	private static final long serialVersionUID = 4680502377161706799L;
	
	@Autowired
	private ConfiguracaoServiceFacade configuracaoServiceFacade;
	@Autowired
	private AtletaServiceFacade atletaServiceFacade;
	
	private List<Posicao> listaPosicao = new ArrayList<Posicao>();
	private List<Dominancia> listaDominancia = new ArrayList<Dominancia>();
	private List<Categoria> listaCategoria = new ArrayList<Categoria>();
	
	private List<Atleta> listaAtleta = new ArrayList<Atleta>();
	
	private Long idClube;
	
	public String iniciar() {
		
		//Lista de posições.
		this.listaPosicao = configuracaoServiceFacade.listarPosicoes(idClube);
		//Lista de dominâncias.
		this.listaDominancia = configuracaoServiceFacade.listarDominancias(idClube);
		//Lista de categorias.
		this.listaCategoria = configuracaoServiceFacade.listarCategorias(idClube);
		//Lista de atletas.
		this.listaAtleta = atletaServiceFacade.listarAtletas(idClube);
		
		return SUCCESS;
	}

	public List<Posicao> getListaPosicao() {
		return listaPosicao;
	}

	public void setListaPosicao(List<Posicao> listaPosicao) {
		this.listaPosicao = listaPosicao;
	}

	public List<Dominancia> getListaDominancia() {
		return listaDominancia;
	}

	public void setListaDominancia(List<Dominancia> listaDominancia) {
		this.listaDominancia = listaDominancia;
	}

	public List<Categoria> getListaCategoria() {
		return listaCategoria;
	}

	public void setListaCategoria(List<Categoria> listaCategoria) {
		this.listaCategoria = listaCategoria;
	}

	public Long getIdClube() {
		return idClube;
	}

	public void setIdClube(Long idClube) {
		this.idClube = idClube;
	}

	public List<Atleta> getListaAtleta() {
		return listaAtleta;
	}

	public void setListaAtleta(List<Atleta> listaAtleta) {
		this.listaAtleta = listaAtleta;
	}
	

}
