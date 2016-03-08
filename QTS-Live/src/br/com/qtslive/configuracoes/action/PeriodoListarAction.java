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
import br.com.qtslive.model.Periodo;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * Action para listar os Período.
 * 
 * @author Tomás Azevedo
 *
 */
@Controller
@Scope("request")
public class PeriodoListarAction  extends ActionSupport {

	private static final long serialVersionUID = 969174541111535811L;
	
	@Autowired
	private ConfiguracaoServiceFacade configuracaoServiceFacade;
	private Long idClube;
	private List<Periodo> lista = new ArrayList<Periodo>();
	
	public String listar() {
		lista = configuracaoServiceFacade.listarPeriodo(idClube);
		return SUCCESS;
	}

	public Long getIdClube() {
		return idClube;
	}

	public void setIdClube(Long idClube) {
		this.idClube = idClube;
	}

	public List<Periodo> getLista() {
		return lista;
	}

	public void setLista(List<Periodo> lista) {
		this.lista = lista;
	}
	
	
	
	

}
