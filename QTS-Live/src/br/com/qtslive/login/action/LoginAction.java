/**
 * 
 */
package br.com.qtslive.login.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.qtslive.login.facade.LoginServiceFacade;
import br.com.qtslive.model.usuario.Usuario;
import br.com.qtslive.utils.Constantes;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * Actions relacionadas ao Login do sistema.
 * 
 * @author Tomás Azevedo
 *
 */
@Controller
@Scope("request")
public class LoginAction extends ActionSupport implements SessionAware {
	
	private static final long serialVersionUID = 9117541377594533380L;
	
	private Usuario usuario = new Usuario();
	
	private Map<String, Object> session;
	
	@Autowired
	private LoginServiceFacade loginServiceFacade;	
	
	public String iniciar() {
		return SUCCESS;
	}
	
	public String login() {
		try {
			if(loginServiceFacade.autenticar(usuario)) {
				usuario = loginServiceFacade.obterUsuarioPorEmail(usuario.getEmail());
				session.put(Constantes.USUARIO_SESSION, usuario);
				return SUCCESS;
			} else {
				return LOGIN;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
	
	
	
    public String logout() {
        session.remove(Constantes.USUARIO_SESSION);
        addActionMessage("Logout efetuado com sucesso.");
        return SUCCESS;
    }
	
	
	

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;		
	}
	
	

}
