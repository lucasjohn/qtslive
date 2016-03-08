/**
 * 
 */
package br.com.qtslive.configuracoes.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.qtslive.configuracoes.facade.ConfiguracaoServiceFacade;
import br.com.qtslive.model.Grupo;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * Action para criar um Grupo novo.
 * 
 * @author Tomás Azevedo
 *
 */
@Controller
@Scope("request")
public class GrupoCriarJsonAction extends ActionSupport {

	private static final long serialVersionUID = 318404494247673168L;

	@Autowired
	private ConfiguracaoServiceFacade configuracaoServiceFacade;
		
	private Grupo grupo;
	
	
	public String criar() {
		this.grupo = configuracaoServiceFacade.criarGrupo(grupo);		
		return SUCCESS;
	}


	public Grupo getGrupo() {
		return grupo;
	}


	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	
	

}
