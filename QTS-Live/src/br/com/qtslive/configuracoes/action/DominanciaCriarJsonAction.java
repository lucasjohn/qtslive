/**
 * 
 */
package br.com.qtslive.configuracoes.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.qtslive.configuracoes.facade.ConfiguracaoServiceFacade;
import br.com.qtslive.model.Dominancia;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * Action para criar uma nova Dominância.
 * 
 * @author Tomás Azevedo
 *
 */
@Controller
@Scope("request")
public class DominanciaCriarJsonAction extends ActionSupport {

	private static final long serialVersionUID = -8091876559978609157L;
	
	@Autowired
	private ConfiguracaoServiceFacade configuracaoServiceFacade;
	
	private Dominancia dominancia;
	
	public String criar() {
		this.dominancia = configuracaoServiceFacade.criarDominancia(dominancia);		
		return SUCCESS;
	}
	


	public Dominancia getDominancia() {
		return dominancia;
	}


	public void setDominancia(Dominancia dominancia) {
		this.dominancia = dominancia;
	}
	
	

}
