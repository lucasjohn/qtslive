/**
 * 
 */
package br.com.qtslive.treinamento.action;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.qtslive.model.treino.Treino;
import br.com.qtslive.model.usuario.Usuario;
import br.com.qtslive.treinamento.facade.TreinoServiceFacade;
import br.com.qtslive.utils.Constantes;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * Action que lista os treinos em um intervalo.
 * 
 * @author Tomás Azevedo
 *
 */
@Controller
@Scope("request")
public class ListarTreinosSimplificadosJsonAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 533049677333753300L;
	
	@Autowired
	private TreinoServiceFacade treinoServiceFacade;
	
	private Map<String, Object> session;
		
	private String start;
	private String end;
	
	private List<Treino> listaTreino = new ArrayList<Treino>();
	
	public String listar() {
		
		Usuario usuario = new Usuario();
		usuario =  (Usuario) session.get(Constantes.USUARIO_SESSION);
		
		listaTreino = treinoServiceFacade.listarTreinosSimplificados(usuario.getClube().getId(), usuario.getCategoria().getId(), data(start), data(end));
		
		return SUCCESS;
	}

	private LocalDate data(String dataString) {
		LocalDate data = null;
		if(null!=dataString) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			data = LocalDate.parse(dataString, formatter);
		}
		return data;
	}
	
	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public List<Treino> getListaTreino() {
		return listaTreino;
	}

	public void setListaTreino(List<Treino> listaTreino) {
		this.listaTreino = listaTreino;
	}
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;		
	}
	

}
