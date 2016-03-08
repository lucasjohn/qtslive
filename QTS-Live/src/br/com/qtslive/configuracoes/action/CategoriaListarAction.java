/**
 * 
 */
package br.com.qtslive.configuracoes.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.qtslive.configuracoes.facade.ConfiguracaoServiceFacade;
import br.com.qtslive.model.Categoria;
import br.com.qtslive.utils.Constantes;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * Action para listar as Categorias.
 * 
 * @author Tomás Azevedo
 *
 */
@Controller
@Scope("request")
public class CategoriaListarAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = -8195905741840938762L;
	
	private Map<String, Object> session;

	@Autowired
	private ConfiguracaoServiceFacade configuracaoServiceFacade;
	
	private Long idClube;	
	private List<Categoria> lista = new ArrayList<Categoria>();
	
	private String idioma;
	
		
	public String listar() {
		idioma = (String) session.get(Constantes.IDIOMA_SESSION);
		lista = configuracaoServiceFacade.listarCategorias(idClube);
		return SUCCESS;
	}


	public List<Categoria> getLista() {
		return lista;
	}

	public void setLista(List<Categoria> lista) {
		this.lista = lista;
	}


	public Long getIdClube() {
		return idClube;
	}


	public void setIdClube(Long idClube) {
		this.idClube = idClube;
	}	
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;		
	}


	public String getIdioma() {
		return idioma;
	}


	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	
	
	
}
