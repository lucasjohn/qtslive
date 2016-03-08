/**
 * 
 */
package br.com.qtslive.model.treino;



/**
 * 
 * Classe que representa uma atividade de um treino.
 * 
 * @author Tomás Azevedo
 *
 */
public class Atividade extends Header {
		
	private int cdTipoAtividade;
	private Long idAtividade;
	private String nomeAtividade;
	private String observacoes;
	private int duracao;
	
	public int getCdTipoAtividade() {
		return cdTipoAtividade;
	}
	public void setCdTipoAtividade(int cdTipoAtividade) {
		this.cdTipoAtividade = cdTipoAtividade;
	}
	public Long getIdAtividade() {
		return idAtividade;
	}
	public void setIdAtividade(Long idAtividade) {
		this.idAtividade = idAtividade;
	}
	public String getNomeAtividade() {
		return nomeAtividade;
	}
	public void setNomeAtividade(String nomeAtividade) {
		this.nomeAtividade = nomeAtividade;
	}
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	public int getDuracao() {
		return duracao;
	}
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	

}
