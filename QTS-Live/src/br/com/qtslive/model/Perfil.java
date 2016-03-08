/**
 * 
 */
package br.com.qtslive.model;

import java.util.List;

import br.com.qtslive.model.usuario.Funcionalidade;

/**
 * 
 * Classe que representa um Perfil de um Usuário.
 * 
 * @author Tomás Azevedo
 *
 */
public class Perfil {
	
	private Long id;
	private Long idClube;
	private String nome;
	private String descricao;
	private List<Funcionalidade> listaFuncionalidades;
	
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
	public List<Funcionalidade> getListaFuncionalidades() {
		return listaFuncionalidades;
	}
	public void setListaFuncionalidades(List<Funcionalidade> listaFuncionalidades) {
		this.listaFuncionalidades = listaFuncionalidades;
	}
	public Long getIdClube() {
		return idClube;
	}
	public void setIdClube(Long idClube) {
		this.idClube = idClube;
	}
	
	
}
