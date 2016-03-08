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
import br.com.qtslive.model.TipoTreinamentoTecnico;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * Action para listar os Tipo de Treinamento tecnico.
 * 
 * @author Tomás Azevedo
 *
 */
@Controller
@Scope("request")
public class TipoTreinamentoTecnicoListarAction  extends ActionSupport {

	private static final long serialVersionUID = 969174541111535811L;
	
	@Autowired
	private ConfiguracaoServiceFacade configuracaoServiceFacade;
	private Long idClube;
	private List<TipoTreinamentoTecnico> lista = new ArrayList<TipoTreinamentoTecnico>();
	
	public String listar() {
		lista = configuracaoServiceFacade.listarTipoTreinamentoTecnico(idClube);
		return SUCCESS;
	}

	public Long getIdClube() {
		return idClube;
	}

	public void setIdClube(Long idClube) {
		this.idClube = idClube;
	}

	public List<TipoTreinamentoTecnico> getLista() {
		return lista;
	}

	public void setLista(List<TipoTreinamentoTecnico> lista) {
		this.lista = lista;
	}
	
	
	
	

}
