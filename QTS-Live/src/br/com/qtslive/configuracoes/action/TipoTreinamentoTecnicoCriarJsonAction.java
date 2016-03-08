/**
 * 
 */
package br.com.qtslive.configuracoes.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.qtslive.configuracoes.facade.ConfiguracaoServiceFacade;
import br.com.qtslive.model.TipoTreinamentoTecnico;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * Action para criar um Tipo de Treinamento Técnico novo.
 * 
 * @author Tomás Azevedo
 *
 */
@Controller
@Scope("request")
public class TipoTreinamentoTecnicoCriarJsonAction extends ActionSupport {

	private static final long serialVersionUID = 1217366922729527229L;

	@Autowired
	private ConfiguracaoServiceFacade configuracaoServiceFacade;
		
	private TipoTreinamentoTecnico tipoTreinamentoTecnico;
	
	
	public String criar() {
		this.tipoTreinamentoTecnico = configuracaoServiceFacade.criarTipoTreinamentoTecnico(tipoTreinamentoTecnico);		
		return SUCCESS;
	}


	public TipoTreinamentoTecnico getTipoTreinamentoTecnico() {
		return tipoTreinamentoTecnico;
	}


	public void setTipoTreinamentoTecnico(
			TipoTreinamentoTecnico tipoTreinamentoTecnico) {
		this.tipoTreinamentoTecnico = tipoTreinamentoTecnico;
	}
	

}
