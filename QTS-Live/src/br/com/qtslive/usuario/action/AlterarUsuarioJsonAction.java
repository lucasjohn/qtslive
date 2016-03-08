/**
 * 
 */
package br.com.qtslive.usuario.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.qtslive.model.usuario.Usuario;
import br.com.qtslive.usuario.facade.UsuarioServiceFacade;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * Action que edita os dados de um Usuário.
 * 
 * @author Tomás Azevedo
 *
 */
@Controller
@Scope("request")
public class AlterarUsuarioJsonAction extends ActionSupport {

	private static final long serialVersionUID = -1780651603241770401L;
	
	@Autowired
	private UsuarioServiceFacade usuarioServiceFacade;
	
	private Usuario usuarioPerfil;
	
	public String alterar() {
		usuarioServiceFacade.alterar(usuarioPerfil);
		return SUCCESS;
	}

	public Usuario getUsuarioPerfil() {
		return usuarioPerfil;
	}

	public void setUsuarioPerfil(Usuario usuarioPerfil) {
		this.usuarioPerfil = usuarioPerfil;
	}
	
	
	

}
