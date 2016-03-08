/**
 * 
 */
package br.com.qtslive.configuracoes.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.qtslive.configuracoes.facade.ConfiguracaoServiceFacade;
import br.com.qtslive.model.Especial;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * Action para editar um Especial.
 * 
 * @author Tom�s Azevedo
 *
 */
@Controller
@Scope("request")
public class EspecialEditarJsonAction extends ActionSupport {

	private static final long serialVersionUID = 8653214827494630003L;

	@Autowired
	private ConfiguracaoServiceFacade configuracaoServiceFacade;
	
	private Especial especial;
	
	public String editar() {
		configuracaoServiceFacade.editarEspecial(especial);
		return SUCCESS;
	}

	public Especial getEspecial() {
		return especial;
	}

	public void setEspecial(Especial especial) {
		this.especial = especial;
	}
	

}
