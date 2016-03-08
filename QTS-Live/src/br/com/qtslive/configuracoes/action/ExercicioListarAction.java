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
import br.com.qtslive.model.Exercicio;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * Action para listar os Exerc�cios.
 * 
 * @author Tom�s Azevedo
 *
 */
@Controller
@Scope("request")
public class ExercicioListarAction  extends ActionSupport {
	
	
	private static final long serialVersionUID = 7024386745537878589L;
	
	@Autowired
	private ConfiguracaoServiceFacade configuracaoServiceFacade;
	private Long idClube;
	private List<Exercicio> lista = new ArrayList<Exercicio>();
	
	public String listar() {
		lista = configuracaoServiceFacade.listarExercicio(idClube);
		return SUCCESS;
	}

	public Long getIdClube() {
		return idClube;
	}

	public void setIdClube(Long idClube) {
		this.idClube = idClube;
	}

	public List<Exercicio> getLista() {
		return lista;
	}

	public void setLista(List<Exercicio> lista) {
		this.lista = lista;
	}
	
	
	
	

}
