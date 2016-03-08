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
import br.com.qtslive.model.Especial;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * Action para listar os Especial.
 * 
 * @author Tomás Azevedo
 *
 */
@Controller
@Scope("request")
public class EspecialListarAction  extends ActionSupport {
	
	private static final long serialVersionUID = 6758602631351132714L;
	
	@Autowired
	private ConfiguracaoServiceFacade configuracaoServiceFacade;
	private Long idClube;
	private List<Especial> lista = new ArrayList<Especial>();
	
	public String listar() {
		lista = configuracaoServiceFacade.listarEspecial(idClube);
		return SUCCESS;
	}

	public Long getIdClube() {
		return idClube;
	}

	public void setIdClube(Long idClube) {
		this.idClube = idClube;
	}

	public List<Especial> getLista() {
		return lista;
	}

	public void setLista(List<Especial> lista) {
		this.lista = lista;
	}
	
	
	
	

}
