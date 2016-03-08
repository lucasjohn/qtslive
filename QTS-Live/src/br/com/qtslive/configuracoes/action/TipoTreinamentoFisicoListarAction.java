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
import br.com.qtslive.model.TipoTreinamentoFisico;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * Action para listar os Locais de Dor.
 * 
 * @author Tomás Azevedo
 *
 */
@Controller
@Scope("request")
public class TipoTreinamentoFisicoListarAction  extends ActionSupport {

	private static final long serialVersionUID = 5033033609387501470L;
	
	@Autowired
	private ConfiguracaoServiceFacade configuracaoServiceFacade;
	private Long idClube;
	private List<TipoTreinamentoFisico> lista = new ArrayList<TipoTreinamentoFisico>();
	
	public String listar() {
		lista = configuracaoServiceFacade.listarTipoTreinamentoFisico(idClube);
		return SUCCESS;
	}

	public Long getIdClube() {
		return idClube;
	}

	public void setIdClube(Long idClube) {
		this.idClube = idClube;
	}

	public List<TipoTreinamentoFisico> getLista() {
		return lista;
	}

	public void setLista(List<TipoTreinamentoFisico> lista) {
		this.lista = lista;
	}
	
	
	
	

}
