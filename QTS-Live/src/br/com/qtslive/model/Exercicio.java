/**
 * 
 */
package br.com.qtslive.model;

/**
 * 
 * Classe que representa um Exercício.
 * 
 * @author Tomás Azevedo 
 *
 */
public class Exercicio {
	
	private Long id;
	private Long idClube;
	private String nome;
	private String descricao;
	
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
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

}
