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
 * Action para editar um Local de Dor.
 * 
 * @author Tomás Azevedo
 *
 */
@Controller
@Scope("request")
public class TipoTreinamentoTecnicoEditarJsonAction extends ActionSupport {

	private static final long serialVersionUID = -3030932123320337251L;

	@Autowired
	private ConfiguracaoServiceFacade configuracaoServiceFacade;
	
	private TipoTreinamentoTecnico tipoTreinamentoTecnico;
	
	public String editar() {
		configuracaoServiceFacade.editarTipoTreinamentoTecnico(tipoTreinamentoTecnico);
		return SUCCESS;
	}

	public TipoTreinamentoTecnico getTipoTreinamentoTecnico() {
		return tipoTreinamentoTecnico;
	}

	public void setTipoTreinamentoTecnico(TipoTreinamentoTecnico tipoTreinamentoTecnico) {
		this.tipoTreinamentoTecnico = tipoTreinamentoTecnico;
	}
	

}
