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
 * Action responsável por criar um usuário novo.
 * 
 * @author Tomás Azevedo
 *
 */
@Controller
@Scope("request")
public class CriarUsuarioJsonAction extends ActionSupport {

	private static final long serialVersionUID = -6033586117130045886L;
	
	@Autowired
	private UsuarioServiceFacade usuarioServiceFacade;
	
	private Usuario usuario;
	
	
	public String criar() {
		
		try {
			
			usuario = usuarioServiceFacade.criar(usuario);
			
		} catch (Exception e) {
			return ERROR;
		}
		
		return SUCCESS;
	}
	
	
	

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	

}
