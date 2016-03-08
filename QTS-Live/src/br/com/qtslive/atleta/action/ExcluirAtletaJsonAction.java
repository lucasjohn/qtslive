/**
 * 
 */
package br.com.qtslive.atleta.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import br.com.qtslive.atleta.facade.AtletaServiceFacade;

/**
 * 
 * Action que exclui um atleta.
 * 
 * @author Tomás Azevedo
 *
 */
@Controller
@Scope("request")
public class ExcluirAtletaJsonAction extends ActionSupport {

	private static final long serialVersionUID = 2918616002636663887L;
	
	@Autowired
	private AtletaServiceFacade atletaServiceFacade;
	
	private Long idAtleta;
	private Long idClube;
	
	public String excluir() {
		atletaServiceFacade.excluir(idAtleta, idClube);		
		return SUCCESS;
	}

	public Long getIdAtleta() {
		return idAtleta;
	}

	public void setIdAtleta(Long idAtleta) {
		this.idAtleta = idAtleta;
	}

	public Long getIdClube() {
		return idClube;
	}

	public void setIdClube(Long idClube) {
		this.idClube = idClube;
	}
	
	

}
