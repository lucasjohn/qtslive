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
 * Action para editar um Tipo de Treinamento Tático.
 * 
 * @author Tomás Azevedo
 *
 */
@Controller
@Scope("request")
public class TipoTreinamentoTaticoEditarJsonAction extends ActionSupport {

	private static final long serialVersionUID = -3030932123320337251L;

	@Autowired
	private ConfiguracaoServiceFacade configuracaoServiceFacade;
	
	private TipoTreinamentoTatico tipoTreinamentoTatico;
	
	public String editar() {
		configuracaoServiceFacade.editarTipoTreinamentoTatico(tipoTreinamentoTatico);
		return SUCCESS;
	}

	public TipoTreinamentoTatico getTipoTreinamentoTatico() {
		return tipoTreinamentoTatico;
	}

	public void setTipoTreinamentoTatico(TipoTreinamentoTatico tipoTreinamentoTatico) {
		this.tipoTreinamentoTatico = tipoTreinamentoTatico;
	}
	

}
