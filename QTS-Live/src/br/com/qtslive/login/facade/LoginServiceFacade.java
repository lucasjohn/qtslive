/**
 * 
 */
package br.com.qtslive.login.facade;

import br.com.qtslive.model.usuario.Usuario;


/**
 * 
 * Interface com os serviços de login.
 * 
 * @author Tomás Azevedo
 *
 */
public interface LoginServiceFacade {
	
	/**
	 * 
	 * Método que valida o usuário.
	 * 
	 * @param usuario - usuário do sistema.
	 * 
	 * @return true - usuário ok / false - usuário inválido.
	 */
	public boolean autenticar(Usuario usuario);
	
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
