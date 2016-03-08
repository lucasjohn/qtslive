/**
 * 
 */
package br.com.qtslive.model;

/**
 * 
 * Classe que representa uma foto.
 * 
 * @author Tomás Azevedo
 *
 */
public class Foto {
	
	private Long id;
	private byte[] bytes;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public byte[] getBytes() {
		return bytes;
	}
	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}
	
	

}
