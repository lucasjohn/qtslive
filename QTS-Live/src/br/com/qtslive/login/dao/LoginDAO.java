/**
 * 
 */
package br.com.qtslive.login.dao;

import br.com.qtslive.model.usuario.Usuario;


/**
 * 
 * Interface para acesso ao dados do Usuário no banco de dados.
 * 
 * @author Tomás Azevedo
 *
 */
public interface LoginDAO {
	
	/**
	 * 
	 * Verifica se um determinado usuário existe na base.
	 * 
	 * @param usuario - dados do usuário a ser pesquisado.
	 * 
	 * @return usuario
	 */
	public boolean verificarUsuario(Usuario usuario);
	
	
	/**
	 * 
	 * Retorna um determinado usuário pelo email.
	 * 
	 * @param email - email do usuário.
	 * 
	 * @return usuario
	 */
	public Usuario obterUsuarioPorEmail(String email);

}
