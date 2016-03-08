/**
 * 
 */
package br.com.qtslive.model.treino;

import java.util.ArrayList;
import java.util.List;

import br.com.qtslive.model.Atleta;
import br.com.qtslive.model.Especial;
import br.com.qtslive.model.Grupo;
import br.com.qtslive.model.LocalDor;

/**
 * 
 * Classe que representa as atividades de um atleta em um determinado treino.
 * 
 * @author Tomás Azevedo
 *
 */
public class AtletaAtividades extends Header {
		
	private Atleta atleta;
	private Grupo grupo;
	private List<Atividade> listaAtividade = new ArrayList<Atividade>();
	private int gps;
	private Especial especial = new Especial();
	private int fad;
	private int dmt;
	private int pse;
	private LocalDor localDor = new LocalDor();
		
	public Atleta getAtleta() {
		return atleta;
	}
	public void setAtleta(Atleta atleta) {
		this.atleta = atleta;
	}
	public List<Atividade> getListaAtividade() {
		return listaAtividade;
	}
	public void setListaAtividade(List<Atividade> listaAtividade) {
		this.listaAtividade = listaAtividade;
	}
	public int getGps() {
		return gps;
	}
	public void setGps(int gps) {
		this.gps = gps;
	}
	public Especial getEspecial() {
		return especial;
	}
	public void setEspecial(Especial especial) {
		this.especial = especial;
	}
	public int getFad() {
		return fad;
	}
	public void setFad(int fad) {
		this.fad = fad;
	}
	public int getDmt() {
		return dmt;
	}
	public void setDmt(int dmt) {
		this.dmt = dmt;
	}
	public int getPse() {
		return pse;
	}
	public void setPse(int pse) {
		this.pse = pse;
	}
	public LocalDor getLocalDor() {
		return localDor;
	}
	public void setLocalDor(LocalDor localDor) {
		this.localDor = localDor;
	}
	public Grupo getGrupo() {
		return grupo;
	}
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}	

}
