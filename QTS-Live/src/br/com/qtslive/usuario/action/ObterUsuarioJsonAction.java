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
 * Action respons�vel por retornar um determinado Usu�rio.
 * 
 * @author Tom�s Azevedo
 *
 */
@Controller
@Scope("request")
public class ObterUsuarioJsonAction extends ActionSupport {

	private static final long serialVersionUID = -8283396932751224685L;
	
	@Autowired
	private UsuarioServiceFacade usuarioServiceFacade;
	
	private Long id;
	private Usuario usuario = new Usuario();
	
	public String obter() {
		usuario = usuarioServiceFacade.obter(id);
		return SUCCESS;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}	
	
	
	

}
