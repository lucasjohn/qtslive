/**
 * 
 */
package br.com.qtslive.model.treino;

import java.util.ArrayList;
import java.util.List;

import br.com.qtslive.model.LocalTreino;

/**
 * 
 * Classe que representa um treinamento.
 * 
 * @author Tomás Azevedo
 *
 */
public class Treino extends Header {
	
	private LocalTreino localTreino;
	private int pseEsperado;
	
	//Grupos de Atletas
	private List<GrupoAtletas> listaGrupoAtletas = new ArrayList<GrupoAtletas>();

	public LocalTreino getLocalTreino() {
		return localTreino;
	}

	public void setLocalTreino(LocalTreino localTreino) {
		this.localTreino = localTreino;
	}	

	public int getPseEsperado() {
		return pseEsperado;
	}

	public void setPseEsperado(int pseEsperado) {
		this.pseEsperado = pseEsperado;
	}

	public List<GrupoAtletas> getListaGrupoAtletas() {
		return listaGrupoAtletas;
	}

	public void setListaGrupoAtletas(List<GrupoAtletas> listaGrupoAtletas) {
		this.listaGrupoAtletas = listaGrupoAtletas;
	}
	
	
}
