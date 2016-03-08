/**
 * 
 */
package br.com.qtslive.model.treino;

import java.util.List;

import br.com.qtslive.model.Grupo;

/**
 * 
 * Classe que representa um grupo de atletas em determinado treino.
 * 
 * @author Tomás Azevedo
 *
 */
public class GrupoAtletas extends Header {
	
	private Grupo grupo;
	private List<AtletaAtividades> listaAtletaAtividades;
	
	public Grupo getGrupo() {
		return grupo;
	}
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	public List<AtletaAtividades> getListaAtletaAtividades() {
		return listaAtletaAtividades;
	}
	public void setListaAtletaAtividades(
			List<AtletaAtividades> listaAtletaAtividades) {
		this.listaAtletaAtividades = listaAtletaAtividades;
	}

}
