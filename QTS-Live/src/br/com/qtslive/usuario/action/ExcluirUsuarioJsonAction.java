/**
 * 
 */
package br.com.qtslive.usuario.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.qtslive.usuario.facade.UsuarioServiceFacade;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * Action responsável por excluir um usuário novo.
 * 
 * @author Tomás Azevedo
 *
 */
@Controller
@Scope("request")
public class ExcluirUsuarioJsonAction extends ActionSupport {

	private static final long serialVersionUID = 4490410609952296680L;
	
	@Autowired
	private UsuarioServiceFacade usuarioServiceFacade;
	
	private Long id;
	private Long idClube;
	
	public String excluir() {
		usuarioServiceFacade.excluir(id, idClube);
		return SUCCESS;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdClube() {
		return idClube;
	}
	public void setIdClube(Long idClube) {
		this.idClube = idClube;
	}
	
	

}
