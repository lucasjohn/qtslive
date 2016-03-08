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
import br.com.qtslive.model.Dominancia;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * Action para listar as Dominâncias (Destro, Canhoto...).
 * 
 * @author Tomás Azevedo
 *
 */
@Controller
@Scope("request")
public class DominanciaListarAction extends ActionSupport {

	private static final long serialVersionUID = 8125350726349985886L;
	
	@Autowired
	private ConfiguracaoServiceFacade configuracaoServiceFacade;
	
	private Long idClube;
	private List<Dominancia> listaDominancia = new ArrayList<Dominancia>();
	
	public String listar() {
		this.listaDominancia = configuracaoServiceFacade.listarDominancias(idClube);
		return SUCCESS;
	}

	public List<Dominancia> getListaDominancia() {
		return listaDominancia;
	}

	public void setListaDominancia(List<Dominancia> listaDominancia) {
		this.listaDominancia = listaDominancia;
	}

	public Long getIdClube() {
		return idClube;
	}

	public void setIdClube(Long idClube) {
		this.idClube = idClube;
	}

}
