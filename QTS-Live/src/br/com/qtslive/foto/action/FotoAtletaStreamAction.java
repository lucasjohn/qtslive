/**
 * 
 */
package br.com.qtslive.foto.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.qtslive.foto.facade.FotoUploadServiceFacade;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * Action que obtém uma foto e retorna um json
 * 
 * @author Tomás Azevedo
 *
 */
public class FotoAtletaStreamAction  extends ActionSupport {

	private static final long serialVersionUID = 3688181272492762469L;
	
	@Autowired
	private FotoUploadServiceFacade fotoUploadServiceFacade;
	
	private Long idAtleta;
	private InputStream inputStream;
	
	public String obter() {
		
		byte[] bytes = fotoUploadServiceFacade.obterFoto(idAtleta);
		
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


	public Long getIdAtleta() {
		return idAtleta;
	}


	public void setIdAtleta(Long idAtleta) {
		this.idAtleta = idAtleta;
	}
	
	
	

}
