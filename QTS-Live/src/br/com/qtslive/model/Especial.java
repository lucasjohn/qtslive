/**
 * 
 */
package br.com.qtslive.model;

/**
 * 
 * Classe que representa uma condição especial para um treino.
 * Ex.: Ausente, Liberado, DM, etc.
 * 
 * @author Tomás Azevedo
 *
 */
public class Especial {
	
	private Long id;
	private Long idClube;
	private String nome;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdClube() {
		return idClube;
	}
	public void setIdClube(Long idClube) {
		this.idClube = idClube;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
