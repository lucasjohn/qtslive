/**
 * 
 */
package br.com.qtslive.usuario.dao;

import java.util.List;

import br.com.qtslive.model.Clube;
import br.com.qtslive.model.Perfil;
import br.com.qtslive.model.usuario.Usuario;

/**
 * 
 * Interface para acesso aos dados de Usuários.
 * 
 * @author Tomás Azevedo
 *
 */
public interface UsuarioDAO {
	
	public List<Usuario> listarUsuarios(Long idClube);

	public Clube criarClube(Clube clube);
	
	public Usuario criarUsuario(Usuario usuario);
	
	public Perfil obterPerfil(Long idUsuario);

	public Usuario obter(Long id);

	public void excluir(Long id, Long idClube);

	public void alterar(Usuario usuarioPerfil);	

}
