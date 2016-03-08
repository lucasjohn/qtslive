/**
 * 
 */
package br.com.qtslive.configuracoes.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.qtslive.configuracoes.facade.ConfiguracaoServiceFacade;
import br.com.qtslive.model.LocalDor;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * Action para criar um Exercicio novo.
 * 
 * @author Tom�s Azevedo
 *
 */
@Controller
@Scope("request")
public class LocalDorCriarJsonAction extends ActionSupport {

	private static final long serialVersionUID = 318404494247673168L;

	@Autowired
	private ConfiguracaoServiceFacade configuracaoServiceFacade;
		
	private LocalDor localDor;
	
	
	public String criar() {
		this.localDor = configuracaoServiceFacade.criarLocalDor(localDor);		
		return SUCCESS;
	}


	public LocalDor getLocalDor() {
		return localDor;
	}


	public void setLocalDor(LocalDor localDor) {
		this.localDor = localDor;
	}
	
	

}
