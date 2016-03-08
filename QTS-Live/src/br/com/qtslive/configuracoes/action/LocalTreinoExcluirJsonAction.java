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
 * Action para excluir um Local de Treino.
 * 
 * @author Tomás Azevedo
 *
 */
@Controller
@Scope("request")
public class LocalTreinoExcluirJsonAction extends ActionSupport {

	private static final long serialVersionUID = -5953361649044331998L;

	@Autowired
	private ConfiguracaoServiceFacade configuracaoServiceFacade;
	
	private LocalTreino localTreino;
	
	public String excluir() {
		configuracaoServiceFacade.excluirLocalTreino(localTreino);
		return SUCCESS;
	}

	public LocalTreino getLocalTreino() {
		return localTreino;
	}


	public void setLocalTreino(LocalTreino localTreino) {
		this.localTreino = localTreino;
	}

	

	
	
	

}
