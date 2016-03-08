/**
 * 
 */
package br.com.qtslive.login.facade;

import br.com.qtslive.model.usuario.Usuario;


/**
 * 
 * Interface com os servi�os de login.
 * 
 * @author Tom�s Azevedo
 *
 */
public interface LoginServiceFacade {
	
	/**
	 * 
	 * M�todo que valida o usu�rio.
	 * 
	 * @param usuario - usu�rio do sistema.
	 * 
	 * @return true - usu�rio ok / false - usu�rio inv�lido.
	 */
	public boolean autenticar(Usuario usuario);
	
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
