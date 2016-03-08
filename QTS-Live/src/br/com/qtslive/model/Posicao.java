/**
 * 
 */
package br.com.qtslive.model;

/**
 * 
 * Classe que representa uma Posição em campo de um atleta.
 * 
 * @author Tomás Azevedo
 *
 */
public class Posicao {
	
	private Long id;
	private Long idClube;
	private String sigla;
	private String nome;
	private String descricao;
	private boolean selecionado;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
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
	public Long getIdClube() {
		return idClube;
	}
	public void setIdClube(Long idClube) {
		this.idClube = idClube;
	}
	public boolean isSelecionado() {
		return selecionado;
	}
	public void setSelecionado(boolean selecionado) {
		this.selecionado = selecionado;
	}
	

}
