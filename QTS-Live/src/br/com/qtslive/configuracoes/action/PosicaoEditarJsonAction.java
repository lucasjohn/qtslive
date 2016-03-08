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
 * Action para editar uma Posição.
 * 
 * @author Tomás Azevedo
 *
 */
@Controller
@Scope("request")
public class PosicaoEditarJsonAction extends ActionSupport {

	private static final long serialVersionUID = -6170171686586172460L;
	
	@Autowired
	private ConfiguracaoServiceFacade configuracaoServiceFacade;
	
	private Posicao posicao;
	
	public String editar() {
		configuracaoServiceFacade.editarPosicao(posicao);
		return SUCCESS;
	}

	public Posicao getPosicao() {
		return posicao;
	}

	public void setPosicao(Posicao posicao) {
		this.posicao = posicao;
	}
	

}
