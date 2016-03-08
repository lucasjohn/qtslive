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
import br.com.qtslive.model.LocalTreino;

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
public class LocalTreinoListarAction  extends ActionSupport {
	
	
	private static final long serialVersionUID = 7024386745537878589L;
	
	@Autowired
	private ConfiguracaoServiceFacade configuracaoServiceFacade;
	private Long idClube;
	private List<LocalTreino> lista = new ArrayList<LocalTreino>();
	
	public String listar() {
		lista = configuracaoServiceFacade.listarLocalTreino(idClube);
		return SUCCESS;
	}

	public Long getIdClube() {
		return idClube;
	}

	public void setIdClube(Long idClube) {
		this.idClube = idClube;
	}

	public List<LocalTreino> getLista() {
		return lista;
	}

	public void setLista(List<LocalTreino> lista) {
		this.lista = lista;
	}

	
	
	
	
	

}
