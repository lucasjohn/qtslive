/**
 * 
 */
package br.com.qtslive.foto.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.qtslive.foto.facade.FotoUploadServiceFacade;
import br.com.qtslive.model.Foto;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * Action para fazer upload de fotos.
 * 
 * @author Tomás Azevedo
 *
 */
@Controller
@Scope("request")
public class FotoUploadJsonAction extends ActionSupport {

	private static final long serialVersionUID = 1027616658463641469L;
	
	private static Logger LOGGER = LoggerFactory.getLogger(FotoUploadJsonAction.class);
	
	private File file;
	
	private Long idFoto;
	
	@Autowired
	private FotoUploadServiceFacade fotoUploadServiceFacade;
	
	public String upload() {
					
		InputStream inputStream = null;
		
		try {
			
			inputStream = new FileInputStream(file);
			
		} catch (FileNotFoundException e) {
			LOGGER.error("Erro ao salvar foto, arquivo não encontrado.");
			e.printStackTrace();
		}			
		
		Foto foto = new Foto();
		foto = fotoUploadServiceFacade.salvarFoto(inputStream);
		idFoto = foto.getId();
		
		return SUCCESS;
	}
	

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}


	public Long getIdFoto() {
		return idFoto;
	}


	public void setIdFoto(Long idFoto) {
		this.idFoto = idFoto;
	}
	
	
		

}
