/**
 * 
 */
package br.com.qtslive.home.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * Actions relacionadas a tela inicial.
 * 
 * @author Tomás Azevedo
 *
 */
@Controller
@Scope("request")
public class HomeAction extends ActionSupport {
	
	private static final long serialVersionUID = -201068299864148339L;
	
	
	
	public String iniciar() {
		return SUCCESS;
	}
	
	

}
