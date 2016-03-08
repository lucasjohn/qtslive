/**
 * 
 */
package br.com.qtslive.model;

/**
 * 
 * Classe que representa uma Categoria de um Atleta.
 * 
 * @author Tomás Azevedo
 *
 */
public class Categoria {
	
	private Long id;
	private Long idClube;
	private String nome;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Long getIdClube() {
		return idClube;
	}
	public void setIdClube(Long idClube) {
		this.idClube = idClube;
	}

}
