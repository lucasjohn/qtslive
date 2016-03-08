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
 * Action para excluir uma Dominância.
 * 
 * @author Tomás Azevedo
 *
 */
@Controller
@Scope("request")
public class DominanciaExcluirJsonAction extends ActionSupport {

	private static final long serialVersionUID = -7291253494692591697L;
	
	@Autowired
	private ConfiguracaoServiceFacade configuracaoServiceFacade;
	
	private Dominancia dominancia;
	
	public String excluir() {
		configuracaoServiceFacade.excluirDominancia(dominancia);
		return SUCCESS;
	}

	public Dominancia getDominancia() {
		return dominancia;
	}

	public void setDominancia(Dominancia dominancia) {
		this.dominancia = dominancia;
	}

}
