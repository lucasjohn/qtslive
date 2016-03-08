/**
 * 
 */
package br.com.qtslive.usuario.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.qtslive.configuracoes.facade.ConfiguracaoServiceFacade;
import br.com.qtslive.model.Categoria;
import br.com.qtslive.model.Perfil;
import br.com.qtslive.model.usuario.Usuario;
import br.com.qtslive.usuario.facade.UsuarioServiceFacade;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * Actions relacionadas a Usuarios.
 * 
 * @author Tomás Azevedo
 *
 */
@Controller
@Scope("request")
public class ListarUsuariosAction extends ActionSupport {

	private static final long serialVersionUID = 3555828429944693301L;
	
	@Autowired
	private UsuarioServiceFacade usuarioServiceFacade;
	@Autowired
	private ConfiguracaoServiceFacade configuracaoServiceFacade;
	
	private List<Usuario> lista = new ArrayList<Usuario>();
	private List<Perfil> listaPerfil = new ArrayList<Perfil>();
	private List<Categoria> listaCategoria = new ArrayList<Categoria>();
	private Long idClube;
	
	public String listarUsuarios() {
		
		this.listaPerfil = configuracaoServiceFacade.listarPerfis(idClube);
		this.listaCategoria = configuracaoServiceFacade.listarCategorias(idClube);
		this.lista = usuarioServiceFacade.listarUsuarios(idClube);
		
		return SUCCESS;
	}


	public List<Usuario> getLista() {
		return lista;
	}


	public void setLista(List<Usuario> lista) {
		this.lista = lista;
	}


	public Long getIdClube() {
		return idClube;
	}


	public void setIdClube(Long idClube) {
		this.idClube = idClube;
	}


	public List<Perfil> getListaPerfil() {
		return listaPerfil;
	}


	public void setListaPerfil(List<Perfil> listaPerfil) {
		this.listaPerfil = listaPerfil;
	}


	public List<Categoria> getListaCategoria() {
		return listaCategoria;
	}


	public void setListaCategoria(List<Categoria> listaCategoria) {
		this.listaCategoria = listaCategoria;
	}

	

}
