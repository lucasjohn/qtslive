/**
 * 
 */
package br.com.qtslive.configuracoes.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.qtslive.configuracoes.facade.ConfiguracaoServiceFacade;
import br.com.qtslive.model.Categoria;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * Action para editar uma Categoria.
 * 
 * @author Tomás Azevedo
 *
 */
@Controller
@Scope("request")
public class CategoriaEditarJsonAction extends ActionSupport {

	private static final long serialVersionUID = 7344121513921302841L;
	
	@Autowired
	private ConfiguracaoServiceFacade configuracaoServiceFacade;
	
	private Categoria categoria;
	
	public String editar() {
		configuracaoServiceFacade.editarCategoria(categoria);		
		return SUCCESS;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	

}
