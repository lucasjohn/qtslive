/**
 * 
 */
package br.com.qtslive.foto.facade;

import java.io.InputStream;

import br.com.qtslive.model.Foto;

/**
 * 
 * Facade para upload de fotos.
 * 
 * @author Tomás Azevedo
 *
 */
public interface FotoUploadServiceFacade {
	
	public Foto salvarFoto(InputStream inputStream);

	public byte[] obterFoto(Long idFoto);
	
	public boolean temFoto(Long id);
}
