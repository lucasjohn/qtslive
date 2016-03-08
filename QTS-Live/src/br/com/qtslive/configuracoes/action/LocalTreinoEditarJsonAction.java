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
 * Action para editar um Local de Dor.
 * 
 * @author Tomás Azevedo
 *
 */
@Controller
@Scope("request")
public class LocalTreinoEditarJsonAction extends ActionSupport {

	private static final long serialVersionUID = 7129608111787517622L;

	@Autowired
	private ConfiguracaoServiceFacade configuracaoServiceFacade;
	
	private LocalTreino localTreino;
	
	public String editar() {
		configuracaoServiceFacade.editarLocalTreino(localTreino);
		return SUCCESS;
	}

	public LocalTreino getLocalTreino() {
		return localTreino;
	}


	public void setLocalTreino(LocalTreino localTreino) {
		this.localTreino = localTreino;
	}
	

}
