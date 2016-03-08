/**
 * 
 */
package br.com.qtslive.foto.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.qtslive.model.usuario.Usuario;
import br.com.qtslive.utils.Constantes;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * Action para visualizar uma determinada foto na jsp.
 * 
 * @author Tomás Azevedo
 *
 */
@Controller
@Scope("request")
public class FotoUsuarioStreamAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = -6994669702104643459L;
	
	private Map<String, Object> session;
	private InputStream inputStream;
	
	public String obter() {
		Usuario usuario = (Usuario) session.get(Constantes.USUARIO_SESSION);
		if(null!=usuario.getFoto()) { 
			byte[] bytes = usuario.getFoto().getBytes();
			inputStream = new ByteArrayInputStream(bytes); 
		}
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;	
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	

}
