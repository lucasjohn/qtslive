/**
 * 
 */
package br.com.qtslive.usuario.facade;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.qtslive.model.usuario.Usuario;
import br.com.qtslive.usuario.dao.UsuarioDAO;

/**
 * 
 * Implementação da interface UsuarioServiceFacade.
 * 
 * @author Tomás Azevedo
 *
 */
@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class UsuarioServiceFacadeImpl implements UsuarioServiceFacade {

	private static Logger LOGGER = LoggerFactory.getLogger(UsuarioServiceFacadeImpl.class);
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Override
	public List<Usuario> listarUsuarios(Long idClube) {
		
		List<Usuario> lista = new ArrayList<Usuario>();
		
		try {
			
			lista = usuarioDAO.listarUsuarios(idClube);
			
		} catch (Exception e) {
			LOGGER.error("Erro ao listar usuários.");
			e.printStackTrace();
			throw(e);
		}
		
		return lista;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public Usuario criar(Usuario usuario) {
		
		Usuario usuarioCriado = new Usuario();
		
		try {
			
			/*if(null!=usuario.getClube()) {
				Clube clube = usuarioDAO.criarClube(usuario.getClube());
				usuario.setClube(clube);
			}*/		
			
			usuarioCriado = usuarioDAO.criarUsuario(usuario);
			
			usuario.setPerfil(usuarioDAO.obterPerfil(usuario.getId()));
			
		} catch (Exception e) {
			LOGGER.error("Erro ao criar novo usuário.");
			e.printStackTrace();
			throw(e);
		}
		
		return usuarioCriado;
	}

	@Override
	public Usuario obter(Long id) {
		return usuarioDAO.obter(id);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void excluir(Long id, Long idClube) {
		usuarioDAO.excluir(id, idClube);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void alterar(Usuario usuarioPerfil) {
		usuarioDAO.alterar(usuarioPerfil);
	}

}
