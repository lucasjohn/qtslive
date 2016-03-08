/**
 * 
 */
package br.com.qtslive.configuracoes.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.qtslive.configuracoes.facade.ConfiguracaoServiceFacade;
import br.com.qtslive.model.TipoSessao;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * Action para criar um Tipo de Treinamento Técnico novo.
 * 
 * @author Tomás Azevedo
 *
 */
@Controller
@Scope("request")
public class TipoSessaoCriarJsonAction extends ActionSupport {

	private static final long serialVersionUID = 1217366922729527229L;

	@Autowired
	private ConfiguracaoServiceFacade configuracaoServiceFacade;
		
	private TipoSessao tipoSessao;
	
	
	public String criar() {
		this.tipoSessao = configuracaoServiceFacade.criarTipoSessao(tipoSessao);		
		return SUCCESS;
	}


	public TipoSessao getTipoSessao() {
		return tipoSessao;
	}


	public void setTipoSessao(
			TipoSessao tipoSessao) {
		this.tipoSessao = tipoSessao;
	}
	

}
