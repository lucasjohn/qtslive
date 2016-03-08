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
import br.com.qtslive.model.Perfil;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * Action para listar os Perfis.
 * 
 * @author Tomás Azevedo
 *
 */
@Controller
@Scope("request")
public class PerfilListarAction  extends ActionSupport {
	
	private static final long serialVersionUID = -3248927182236816665L;
	
	@Autowired
	private ConfiguracaoServiceFacade configuracaoServiceFacade;
	private Long idClube;
	private List<Perfil> lista = new ArrayList<Perfil>();
	
	public String listar() {
		lista = configuracaoServiceFacade.listarPerfis(idClube);
		return SUCCESS;
	}

	public Long getIdClube() {
		return idClube;
	}

	public void setIdClube(Long idClube) {
		this.idClube = idClube;
	}

	public List<Perfil> getLista() {
		return lista;
	}

	public void setLista(List<Perfil> lista) {
		this.lista = lista;
	}
	
	
	
	

}
