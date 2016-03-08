/**
 * 
 */
package br.com.qtslive.model.usuario;

/**
 * 
 * Classe que representa uma Funcinalidade associada a um Perfil.
 * 
 * @author Tomás Azevedo
 *
 */
public class Funcionalidade {
	
	private Long id;
	private String nome;
	private String descricao;
	
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
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
