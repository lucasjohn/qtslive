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
 * Action para excluir um Especial.
 * 
 * @author Tomás Azevedo
 *
 */
@Controller
@Scope("request")
public class EspecialExcluirJsonAction extends ActionSupport {

	private static final long serialVersionUID = -34226719665599484L;

	@Autowired
	private ConfiguracaoServiceFacade configuracaoServiceFacade;
	
	private Especial especial;
	
	public String excluir() {
		configuracaoServiceFacade.excluirEspecial(especial);
		return SUCCESS;
	}

	public Especial getEspecial() {
		return especial;
	}

	public void setEspecial(Especial especial) {
		this.especial = especial;
	}

	

	
	
	

}
