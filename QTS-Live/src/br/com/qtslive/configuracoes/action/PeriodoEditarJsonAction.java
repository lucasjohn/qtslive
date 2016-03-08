/**
 * 
 */
package br.com.qtslive.configuracoes.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.qtslive.configuracoes.facade.ConfiguracaoServiceFacade;
import br.com.qtslive.model.Periodo;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * Action para editar um Período.
 * 
 * @author Tomás Azevedo
 *
 */
@Controller
@Scope("request")
public class PeriodoEditarJsonAction extends ActionSupport {

	private static final long serialVersionUID = -3030932123320337251L;

	@Autowired
	private ConfiguracaoServiceFacade configuracaoServiceFacade;
	
	private Periodo periodo;
	
	public String editar() {
		configuracaoServiceFacade.editarPeriodo(periodo);
		return SUCCESS;
	}

	public Periodo getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}
	

}
