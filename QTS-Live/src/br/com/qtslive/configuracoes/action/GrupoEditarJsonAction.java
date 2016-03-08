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
 * Action para editar um Grupo.
 * 
 * @author Tomás Azevedo
 *
 */
@Controller
@Scope("request")
public class GrupoEditarJsonAction extends ActionSupport {

	private static final long serialVersionUID = 7129608111787517622L;

	@Autowired
	private ConfiguracaoServiceFacade configuracaoServiceFacade;
	
	private Grupo grupo;
	
	public String editar() {
		configuracaoServiceFacade.editarGrupo(grupo);
		return SUCCESS;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	

}
