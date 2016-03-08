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
 * Action para criar um Período novo.
 * 
 * @author Tomás Azevedo
 *
 */
@Controller
@Scope("request")
public class PeriodoCriarJsonAction extends ActionSupport {

	private static final long serialVersionUID = 1217366922729527229L;

	@Autowired
	private ConfiguracaoServiceFacade configuracaoServiceFacade;
		
	private Periodo periodo;
	
	
	public String criar() {
		this.periodo = configuracaoServiceFacade.criarPeriodo(periodo);		
		return SUCCESS;
	}


	public Periodo getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}

}
