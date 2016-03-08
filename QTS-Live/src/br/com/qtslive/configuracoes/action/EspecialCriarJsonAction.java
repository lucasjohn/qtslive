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
 * Action para criar um Especial novo.
 * 
 * @author Tomás Azevedo
 *
 */
@Controller
@Scope("request")
public class EspecialCriarJsonAction extends ActionSupport {

	private static final long serialVersionUID = 318404494247673168L;

	@Autowired
	private ConfiguracaoServiceFacade configuracaoServiceFacade;
		
	private Especial especial;
	
	
	public String criar() {
		this.especial = configuracaoServiceFacade.criarEspecial(especial);		
		return SUCCESS;
	}


	public Especial getEspecial() {
		return especial;
	}


	public void setEspecial(Especial especial) {
		this.especial = especial;
	}
	
	

}
