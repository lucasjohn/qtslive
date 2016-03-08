/**
 * 
 */
package br.com.qtslive.usuario.facade;

import java.util.List;

import br.com.qtslive.model.usuario.Usuario;

/**
 * 
 * Interface com os servi�os de Usu�rios.
 * 
 * @author Tom�s Azevedo
 *
 */
public interface UsuarioServiceFacade {
	
	public List<Usuario> listarUsuarios(Long idClube);
	
	public Usuario criar(Usuario usuario);

	public Usuario obter(Long id);

	public void excluir(Long id, Long idClube);

	public void alterar(Usuario usuarioPerfil);

}
