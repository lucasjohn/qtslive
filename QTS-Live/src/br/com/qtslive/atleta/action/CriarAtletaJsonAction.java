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
 * Action responsável por criar um Atleta novo.
 * 
 * @author Tomás Azevedo
 *
 */
@Controller
@Scope("request")
public class CriarAtletaJsonAction extends ActionSupport {

	private static final long serialVersionUID = -7446140262987536156L;

	@Autowired
	private AtletaServiceFacade atletaServiceFacade;
	
	private Atleta atleta;		
	private String idsPosicao;	
	
	private Integer idade;	
	
	
	public String criar() {	
		this.atleta.setListaPosicao(this.obterListaPosicoes(idsPosicao));
		atleta = atletaServiceFacade.criarAtleta(atleta);
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

	public String getIdsPosicao() {
		return idsPosicao;
	}

	public void setIdsPosicao(String idsPosicao) {
		this.idsPosicao = idsPosicao;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}	

	public Atleta getAtleta() {
		return atleta;
	}

	public void setAtleta(Atleta atleta) {
		this.atleta = atleta;
	}

	
	
}
