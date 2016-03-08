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
 * Action para editar um Local de Dor.
 * 
 * @author Tomás Azevedo
 *
 */
@Controller
@Scope("request")
public class LocalDorEditarJsonAction extends ActionSupport {

	private static final long serialVersionUID = 7129608111787517622L;

	@Autowired
	private ConfiguracaoServiceFacade configuracaoServiceFacade;
	
	private LocalDor localDor;
	
	public String editar() {
		configuracaoServiceFacade.editarLocalDor(localDor);
		return SUCCESS;
	}

	public LocalDor getLocalDor() {
		return localDor;
	}

	public void setLocalDor(LocalDor localDor) {
		this.localDor = localDor;
	}
	

}
