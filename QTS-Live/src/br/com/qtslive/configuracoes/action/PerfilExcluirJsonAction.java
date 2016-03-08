/**
 * 
 */
package br.com.qtslive.configuracoes.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.qtslive.configuracoes.facade.ConfiguracaoServiceFacade;
import br.com.qtslive.model.Perfil;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * Action para excluir um Perfil.
 * 
 * @author Tomás Azevedo
 *
 */
@Controller
@Scope("request")
public class PerfilExcluirJsonAction extends ActionSupport {

	private static final long serialVersionUID = 121037485612818930L;

	@Autowired
	private ConfiguracaoServiceFacade configuracaoServiceFacade;
	
	private Perfil perfil;
	
	public String excluir() {
		configuracaoServiceFacade.excluirPerfil(perfil);
		return SUCCESS;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	
	

}
