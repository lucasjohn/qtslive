/**
 * 
 */
package br.com.qtslive.foto.dao;

import java.io.InputStream;

/**
 * 
 * Interface para salvar as fotos tempor�rias.
 * 
 * @author Tom�s Azevedo.
 *
 */
public interface FotoUploadDAO {

	public Long salvarFoto(InputStream inputStream);
	
	public byte[] obterFoto(Long id);
	
	public boolean temFoto(Long id);
	
}
