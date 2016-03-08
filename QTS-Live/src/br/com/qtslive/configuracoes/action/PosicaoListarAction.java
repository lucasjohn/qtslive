/**
 * 
 */
package br.com.qtslive.configuracoes.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.qtslive.configuracoes.facade.ConfiguracaoServiceFacade;
import br.com.qtslive.model.Posicao;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * Action para listar as posições.
 * 
 * @author Tomás Azevedo
 *
 */
@Controller
@Scope("request")
public class PosicaoListarAction extends ActionSupport {

	private static final long serialVersionUID = 8181418849731652842L;
	
	@Autowired
	private ConfiguracaoServiceFacade configuracaoServiceFacade;
	
	private List<Posicao> listaPosicoes = new ArrayList<Posicao>();
	
	private Long idClube;
	
		
	public String listar() {
		listaPosicoes = configuracaoServiceFacade.listarPosicoes(idClube);
		return SUCCESS;
	}	

	public List<Posicao> getListaPosicoes() {
		return listaPosicoes;
	}

	public void setListaPosicoes(List<Posicao> listaPosicoes) {
		this.listaPosicoes = listaPosicoes;
	}

	public Long getIdClube() {
		return idClube;
	}

	public void setIdClube(Long idClube) {
		this.idClube = idClube;
	}
	
	

}
