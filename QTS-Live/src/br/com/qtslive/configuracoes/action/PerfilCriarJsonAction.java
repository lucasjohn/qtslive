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
 * Action para criar um Perfil novo.
 * 
 * @author Tomás Azevedo
 *
 */
@Controller
@Scope("request")
public class PerfilCriarJsonAction extends ActionSupport {

	private static final long serialVersionUID = 5016785001793527586L;
	
	@Autowired
	private ConfiguracaoServiceFacade configuracaoServiceFacade;
		
	private Perfil perfil;
	
	
	public String criar() {
		this.perfil = configuracaoServiceFacade.criarPerfil(perfil);		
		return SUCCESS;
	}


	public Perfil getPerfil() {
		return perfil;
	}


	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
	
	

}
