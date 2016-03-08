/**
 * 
 */
package br.com.qtslive.configuracoes.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.qtslive.configuracoes.facade.ConfiguracaoServiceFacade;
import br.com.qtslive.model.TipoTreinamentoFisico;

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
public class TipoTreinamentoFisicoCriarJsonAction extends ActionSupport {

	private static final long serialVersionUID = -8094954407802038704L;

	@Autowired
	private ConfiguracaoServiceFacade configuracaoServiceFacade;
		
	private TipoTreinamentoFisico tipoTreinamentoFisico;
	
	
	public String criar() {
		this.tipoTreinamentoFisico = configuracaoServiceFacade.criarTipoTreinamentoFisico(tipoTreinamentoFisico);		
		return SUCCESS;
	}


	public TipoTreinamentoFisico getTipoTreinamentoFisico() {
		return tipoTreinamentoFisico;
	}


	public void setTipoTreinamentoFisico(TipoTreinamentoFisico tipoTreinamentoFisico) {
		this.tipoTreinamentoFisico = tipoTreinamentoFisico;
	}
	
	

}
