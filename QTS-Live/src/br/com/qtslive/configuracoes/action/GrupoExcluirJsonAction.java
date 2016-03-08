/**
 * 
 */
package br.com.qtslive.configuracoes.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.qtslive.configuracoes.facade.ConfiguracaoServiceFacade;
import br.com.qtslive.model.Grupo;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * Action para excluir um Grupo.
 * 
 * @author Tomás Azevedo
 *
 */
@Controller
@Scope("request")
public class GrupoExcluirJsonAction extends ActionSupport {

	private static final long serialVersionUID = -5953361649044331998L;

	@Autowired
	private ConfiguracaoServiceFacade configuracaoServiceFacade;
	
	private Grupo grupo;
	
	public String excluir() {
		configuracaoServiceFacade.excluirGrupo(grupo);
		return SUCCESS;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	

	
	
	

}
