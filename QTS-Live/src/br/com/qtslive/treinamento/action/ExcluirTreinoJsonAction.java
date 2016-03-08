/**
 * 
 */
package br.com.qtslive.treinamento.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.qtslive.model.treino.Header;
import br.com.qtslive.treinamento.facade.TreinoServiceFacade;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * Action que cria o treino.
 * 
 * @author Tomás Azevedo
 *
 */
@Controller
@Scope("request")
public class ExcluirTreinoJsonAction extends ActionSupport {

	private static final long serialVersionUID = -7895260586108926819L;

	@Autowired
	private TreinoServiceFacade treinoServiceFacade;
	
	private Header header = new Header();	
	
	public String excluir() {		
		
		treinoServiceFacade.excluir(header);
		
		return SUCCESS;
	}

	public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}
	
	
}
