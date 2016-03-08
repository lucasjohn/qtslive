/**
 * 
 */
package br.com.qtslive.configuracoes.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * Action que inicia o painel de configurações.
 * 
 * @author Tomás Azevedo
 *
 */
@Controller
@Scope("request")
public class IniciarPainelConfiguracoesAction extends ActionSupport {

	private static final long serialVersionUID = -3917101190994938730L;
	
	private Long idClube;
	
	public String iniciar() {
		return SUCCESS;
	}

	public Long getIdClube() {
		return idClube;
	}

	public void setIdClube(Long idClube) {
		this.idClube = idClube;
	}
	
	

}
