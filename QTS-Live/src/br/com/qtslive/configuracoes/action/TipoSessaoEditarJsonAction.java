/**
 * 
 */
package br.com.qtslive.configuracoes.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.qtslive.configuracoes.facade.ConfiguracaoServiceFacade;
import br.com.qtslive.model.TipoSessao;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * Action para editar um Tipo de Sessão.
 * 
 * @author Tomás Azevedo
 *
 */
@Controller
@Scope("request")
public class TipoSessaoEditarJsonAction extends ActionSupport {

	private static final long serialVersionUID = -3030932123320337251L;

	@Autowired
	private ConfiguracaoServiceFacade configuracaoServiceFacade;
	
	private TipoSessao tipoSessao;
	
	public String editar() {
		configuracaoServiceFacade.editarTipoSessao(tipoSessao);
		return SUCCESS;
	}

	public TipoSessao getTipoSessao() {
		return tipoSessao;
	}

	public void setTipoSessao(TipoSessao tipoSessao) {
		this.tipoSessao = tipoSessao;
	}
	

}
