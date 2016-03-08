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
 * Action para excluir um Tipo de Treinamento Tecnico.
 * 
 * @author Tomás Azevedo
 *
 */
@Controller
@Scope("request")
public class TipoTreinamentoTecnicoExcluirJsonAction extends ActionSupport {

	private static final long serialVersionUID = -2108512392774487039L;

	@Autowired
	private ConfiguracaoServiceFacade configuracaoServiceFacade;
	
	private TipoTreinamentoTecnico tipoTreinamentoTecnico;
	
	public String excluir() {
		configuracaoServiceFacade.excluirTipoTreinamentoTecnico(tipoTreinamentoTecnico);
		return SUCCESS;
	}

	public TipoTreinamentoTecnico getTipoTreinamentoTecnico() {
		return tipoTreinamentoTecnico;
	}

	public void setTipoTreinamentoTecnico(TipoTreinamentoTecnico tipoTreinamentoTecnico) {
		this.tipoTreinamentoTecnico = tipoTreinamentoTecnico;
	}

	

}
