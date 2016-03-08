/**
 * 
 */
package br.com.qtslive.configuracoes.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * Actions relacionadas as configurações do Admin.
 * 
 * @author Tomás Azevedo
 *
 */
@Controller
@Scope("request")
public class ConfiguracoesAction extends ActionSupport {

	private static final long serialVersionUID = 4369601073323009085L;
	
	
	public String iniciarUsuarios(){
		return SUCCESS;
	}
	
	public String iniciarPosicoes(){
		return SUCCESS;
	}	

}
