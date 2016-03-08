/**
 * 
 */
package br.com.qtslive.foto.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.qtslive.foto.facade.FotoUploadServiceFacade;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * Action que obtém uma foto e retorna um json
 * 
 * @author Tomás Azevedo
 *
 */
@Controller
@Scope("request")
public class ObterFotoStreamAction  extends ActionSupport {

	private static final long serialVersionUID = 3688181272492762469L;
	
	@Autowired
	private FotoUploadServiceFacade fotoUploadServiceFacade;
	
	private Long id;
	private InputStream inputStream;
	
	public String obter() {
		
		byte[] bytes = fotoUploadServiceFacade.obterFoto(id);
		
		if(null!=bytes) {
			inputStream = new ByteArrayInputStream(bytes);
		}	
		
		return SUCCESS;
	}
	

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
	
	
	

}
