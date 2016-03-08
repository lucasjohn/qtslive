/**
 * 
 */
package br.com.qtslive.login.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.qtslive.foto.dao.FotoUploadDAO;
import br.com.qtslive.login.dao.LoginDAO;
import br.com.qtslive.model.usuario.Usuario;

/**
 * 
 * Implementação da interface LoginServiceFacade.
 * 
 * @author Tomás Azevedo
 *
 */
@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class LoginServiceFacadeImpl implements LoginServiceFacade {
	
	@Autowired
	private LoginDAO loginDAO;
	@Autowired
	private FotoUploadDAO fotoDAO;

	@Override
	public boolean autenticar(Usuario usuario) {
		return loginDAO.verificarUsuario(usuario);		
	}

	
	@Override
	public Usuario obterUsuarioPorEmail(String email) {
		Usuario usuario = loginDAO.obterUsuarioPorEmail(email);
		if(null!=usuario.getFoto()) {
			usuario.getFoto().setBytes(fotoDAO.obterFoto(usuario.getFoto().getId())); 
		}
		return usuario;
	}

}
