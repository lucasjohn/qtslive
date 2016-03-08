/**
 * 
 */
package br.com.qtslive.configuracoes.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.qtslive.configuracoes.facade.ConfiguracaoServiceFacade;
import br.com.qtslive.model.Exercicio;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * Action para excluir um Exercício.
 * 
 * @author Tomás Azevedo
 *
 */
@Controller
@Scope("request")
public class ExercicioExcluirJsonAction extends ActionSupport {

	private static final long serialVersionUID = -5953361649044331998L;

	@Autowired
	private ConfiguracaoServiceFacade configuracaoServiceFacade;
	
	private Exercicio exercicio;
	
	public String excluir() {
		configuracaoServiceFacade.excluirExercicio(exercicio);
		return SUCCESS;
	}

	public Exercicio getExercicio() {
		return exercicio;
	}

	public void setExercicio(Exercicio exercicio) {
		this.exercicio = exercicio;
	}

	
	
	

}
