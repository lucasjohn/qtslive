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
 * Action que exibe o perfil de um usuário.
 * 
 * @author Tomás Azevedo
 *
 */
@Controller
@Scope("request")
public class PerfilUsuarioAction extends ActionSupport {

	private static final long serialVersionUID = 6312826895153132062L;
	
	@Autowired
	private UsuarioServiceFacade usuarioServiceFacade;
	@Autowired
	private ConfiguracaoServiceFacade configuracaoServiceFacade;
	
	private Long idUsuario;
	private Usuario usuarioPerfil;
	private List<Perfil> listaPerfil = new ArrayList<Perfil>();
	private List<Categoria> listaCategoria = new ArrayList<Categoria>();
	
	public String exibir() {
		
		usuarioPerfil = usuarioServiceFacade.obter(idUsuario);
		listaCategoria = configuracaoServiceFacade.listarCategorias(usuarioPerfil.getClube().getId());
		listaPerfil = configuracaoServiceFacade.listarPerfis(usuarioPerfil.getClube().getId());
		return SUCCESS;
	}

	public Usuario getUsuarioPerfil() {
		return usuarioPerfil;
	}

	public void setUsuarioPerfil(Usuario usuarioPerfil) {
		this.usuarioPerfil = usuarioPerfil;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
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
