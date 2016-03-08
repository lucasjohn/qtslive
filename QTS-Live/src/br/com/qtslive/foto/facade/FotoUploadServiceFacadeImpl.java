/**
 * 
 */
package br.com.qtslive.foto.facade;

import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.qtslive.foto.dao.FotoUploadDAO;
import br.com.qtslive.model.Foto;

/**
 * 
 * Implementação da interface FotoUploadServiceFacade.
 * 
 * @author Tomás Azevedo
 *
 */
@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class FotoUploadServiceFacadeImpl implements FotoUploadServiceFacade {

	@Autowired
	private FotoUploadDAO fotoUploadDAO;

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public Foto salvarFoto(InputStream inputStream) {
		
		Foto foto = new Foto();
		foto.setId(fotoUploadDAO.salvarFoto(inputStream));
		//foto.setBytes(bytes);
		return foto;
	}

	@Override
	public byte[] obterFoto(Long idFoto) {
		byte[] bytes = fotoUploadDAO.obterFoto(idFoto);
//		StringBuilder sb = new StringBuilder();
//		//sb.append("data:image/png;base64,");
//		sb.append(StringUtils.newStringUtf8(Base64.encodeBase64(bytes, false)));
//		return sb.toString();	
		return bytes;
	}

	@Override
	public boolean temFoto(Long id) {
		return fotoUploadDAO.temFoto(id);
	}

}
