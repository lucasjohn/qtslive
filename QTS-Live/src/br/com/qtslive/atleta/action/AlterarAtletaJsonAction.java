/**
 * 
 */
package br.com.qtslive.atleta.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.qtslive.atleta.facade.AtletaServiceFacade;
import br.com.qtslive.model.Atleta;
import br.com.qtslive.model.Posicao;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * Action para atualizar os dados de um Atleta.
 * 
 * @author Tomás Azevedo
 *
 */
@Controller
@Scope("request")
public class AlterarAtletaJsonAction extends ActionSupport {

	private static final long serialVersionUID = 5256236698187479505L;

	@Autowired
	private AtletaServiceFacade atletaServiceFacade;
	
	private Atleta atleta;		
	private String idsPosicao;	
	
	public String alterar() {
		
		atleta.setListaPosicao(this.obterListaPosicoes(idsPosicao));
		atletaServiceFacade.atualizar(atleta);
		
		return SUCCESS;
	}
	
	
	private List<Posicao> obterListaPosicoes(String idsPosicao) {
		
		List<Posicao> listaPosicao = new ArrayList<Posicao>();
		
		if(null!=idsPosicao) {
			
			String[] ids = idsPosicao.split(",");
			
			for (String id : ids) {
				Posicao posicao = new Posicao();
				posicao.setId(Long.parseLong(id));
				listaPosicao.add(posicao);
			}
		}
		
		return listaPosicao;
	}


	public Atleta getAtleta() {
		return atleta;
	}


	public void setAtleta(Atleta atleta) {
		this.atleta = atleta;
	}


	public String getIdsPosicao() {
		return idsPosicao;
	}


	public void setIdsPosicao(String idsPosicao) {
		this.idsPosicao = idsPosicao;
	}
	
	

}
