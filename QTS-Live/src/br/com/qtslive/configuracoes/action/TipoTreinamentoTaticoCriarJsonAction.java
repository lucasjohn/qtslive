/**
 * 
 */
package br.com.qtslive.configuracoes.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.qtslive.configuracoes.facade.ConfiguracaoServiceFacade;
import br.com.qtslive.model.TipoTreinamentoTatico;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * Action para criar um Tipo de treinamento Tático novo.
 * 
 * @author Tomás Azevedo
 *
 */
@Controller
@Scope("request")
public class TipoTreinamentoTaticoCriarJsonAction extends ActionSupport {

	private static final long serialVersionUID = 1217366922729527229L;

	@Autowired
	private ConfiguracaoServiceFacade configuracaoServiceFacade;
		
	private TipoTreinamentoTatico tipoTreinamentoTatico;
	
	
	public String criar() {
		this.tipoTreinamentoTatico = configuracaoServiceFacade.criarTipoTreinamentoTatico(tipoTreinamentoTatico);		
		return SUCCESS;
	}


	public TipoTreinamentoTatico getTipoTreinamentoTatico() {
		return tipoTreinamentoTatico;
	}


	public void setTipoTreinamentoTatico(
			TipoTreinamentoTatico tipoTreinamentoTatico) {
		this.tipoTreinamentoTatico = tipoTreinamentoTatico;
	}
	

}
