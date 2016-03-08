/**
 * 
 */
package br.com.qtslive.login.dao;

import br.com.qtslive.model.usuario.Usuario;


/**
 * 
 * Interface para acesso ao dados do Usu�rio no banco de dados.
 * 
 * @author Tom�s Azevedo
 *
 */
public interface LoginDAO {
	
	/**
	 * 
	 * Verifica se um determinado usu�rio existe na base.
	 * 
	 * @param usuario - dados do usu�rio a ser pesquisado.
	 * 
	 * @return usuario
	 */
	public boolean verificarUsuario(Usuario usuario);
	
	
	/**
	 * 
	 * Retorna um determinado usu�rio pelo email.
	 * 
	 * @param email - email do usu�rio.
	 * 
	 * @return usuario
	 */
	public Usuario obterUsuarioPorEmail(String email);

}
