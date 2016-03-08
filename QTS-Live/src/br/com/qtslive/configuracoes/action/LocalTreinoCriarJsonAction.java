/**
 * 
 */
package br.com.qtslive.configuracoes.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.qtslive.configuracoes.facade.ConfiguracaoServiceFacade;
import br.com.qtslive.model.LocalTreino;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * Action para criar um Exercicio novo.
 * 
 * @author Tomás Azevedo
 *
 */
@Controller
@Scope("request")
public class LocalTreinoCriarJsonAction extends ActionSupport {

	private static final long serialVersionUID = 318404494247673168L;

	@Autowired
	private ConfiguracaoServiceFacade configuracaoServiceFacade;
		
	private LocalTreino localTreino;
	
	
	public String criar() {
		this.localTreino = configuracaoServiceFacade.criarLocalTreino(localTreino);		
		return SUCCESS;
	}


	public LocalTreino getLocalTreino() {
		return localTreino;
	}


	public void setLocalTreino(LocalTreino localTreino) {
		this.localTreino = localTreino;
	}

	

}
