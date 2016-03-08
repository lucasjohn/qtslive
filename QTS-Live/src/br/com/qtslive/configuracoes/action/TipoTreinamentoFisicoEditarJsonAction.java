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
 * Action para editar um Local de Dor.
 * 
 * @author Tomás Azevedo
 *
 */
@Controller
@Scope("request")
public class TipoTreinamentoFisicoEditarJsonAction extends ActionSupport {

	private static final long serialVersionUID = 6893345197987031819L;

	@Autowired
	private ConfiguracaoServiceFacade configuracaoServiceFacade;
	
	private TipoTreinamentoFisico tipoTreinamentoFisico;
	
	public String editar() {
		configuracaoServiceFacade.editarTipoTreinamentoFisico(tipoTreinamentoFisico);
		return SUCCESS;
	}

	public TipoTreinamentoFisico getTipoTreinamentoFisico() {
		return tipoTreinamentoFisico;
	}

	public void setTipoTreinamentoFisico(TipoTreinamentoFisico tipoTreinamentoFisico) {
		this.tipoTreinamentoFisico = tipoTreinamentoFisico;
	}
	

}
