/**
 * 
 */
package br.com.qtslive.atleta.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.qtslive.atleta.dao.AtletaDAO;
import br.com.qtslive.configuracoes.facade.ConfiguracaoServiceFacade;
import br.com.qtslive.model.Atleta;
import br.com.qtslive.model.Posicao;

/**
 * 
 * Implementação da interface AtletaServiceFacade.
 * 
 * @author Tomás Azevedo
 *
 */
@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class AtletaServiceFacadeImpl implements AtletaServiceFacade {
	
	@Autowired
	private AtletaDAO atletaDAO;
	@Autowired
	private ConfiguracaoServiceFacade configuracaoServiceFacade;

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public Atleta criarAtleta(Atleta atleta) {		
		
		atleta = atletaDAO.criarAtleta(atleta);
		//Pega o nome da categoria.
		String nomeCategoria = configuracaoServiceFacade.obterNomeCategoria(atleta.getCategoria().getId(), atleta.getClube().getId());
		atleta.getCategoria().setNome(nomeCategoria);
		//Pega o nome da dominancia.
		String nomeDominancia = configuracaoServiceFacade.obterNomeDominancia(atleta.getDominancia().getId(), atleta.getClube().getId());
		atleta.getDominancia().setNome(nomeDominancia);
		//Pego o nome e sigla das posições
		for (Posicao posicao : atleta.getListaPosicao()) {
			posicao.setSigla(configuracaoServiceFacade.obterSiglaPosicao(posicao.getId(), atleta.getClube().getId()));
			posicao.setNome(configuracaoServiceFacade.obterNomePosicao(posicao.getId(), atleta.getClube().getId()));
		}
		
		return atleta;
	}

	@Override
	public List<Atleta> listarAtletas(Long idClube) {
		return atletaDAO.listar(idClube);
	}

	@Override
	public Atleta obterAtleta(Long idAtleta) {
		return atletaDAO.obterAtleta(idAtleta);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void atualizar(Atleta atleta) {
		atletaDAO.atualizar(atleta);
	}

	@Override
	public List<Atleta> listarAtletasCategoria(Long idClube, Long idCategoria) {
		return atletaDAO.listarAtletasCategoria(idClube, idCategoria);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void excluir(Long idAtleta, Long idClube) {
		Long idPosicoes = atletaDAO.obterIdPosicoes(idAtleta, idClube);
		atletaDAO.excluir(idAtleta, idClube, idPosicoes);
	}

}
