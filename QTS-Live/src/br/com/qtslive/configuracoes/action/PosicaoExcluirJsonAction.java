/**
 * 
 */
package br.com.qtslive.configuracoes.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.qtslive.configuracoes.facade.ConfiguracaoServiceFacade;
import br.com.qtslive.model.Posicao;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * Action para excluir uma Posição.
 * 
 * @author Tomás Azevedo
 *
 */
@Controller
@Scope("request")
public class PosicaoExcluirJsonAction extends ActionSupport {

	private static final long serialVersionUID = 3872093667136118740L;
	
	@Autowired
	private ConfiguracaoServiceFacade configuracaoServiceFacade;
	
	private Posicao posicao;
	
	public String excluir() {
		configuracaoServiceFacade.excluirPosicao(posicao);
		return SUCCESS;
	}

	public Posicao getPosicao() {
		return posicao;
	}

	public void setPosicao(Posicao posicao) {
		this.posicao = posicao;
	}
	

}
