/**
 * 
 */
package br.com.qtslive.treinamento.facade;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.qtslive.model.treino.Header;
import br.com.qtslive.model.treino.Treino;
import br.com.qtslive.treinamento.dao.TreinoDAO;

/**
 * 
 * Implementação da interface TreinoServiceFacade.
 * 
 * @author Tomás Azevedo
 *
 */
@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class TreinoServiceFacadeImpl implements TreinoServiceFacade {
	
	@Autowired
	private TreinoDAO treinoDAO;
	
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public boolean criar(Treino treino) {
		return treinoDAO.criar(treino);		
	}

	@Override
	public Treino obterTreinoSimplificado(Header header) {
		return treinoDAO.obterTreinoSimplificado(header);
	}

	@Override
	public List<Treino> listarTreinosSimplificados(Long idClube, Long idCategoria, LocalDate dataInicio, LocalDate dataFim) {
		return treinoDAO.listarTreinosSimplificados(idClube, idCategoria, dataInicio, dataFim);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public boolean excluir(Header header) {
		return treinoDAO.excluir(header);
	}

	@Override
	public List<Treino> listarTreinos(Header header) {
		
		List<Treino> listaTreino = new ArrayList<Treino>();
		
		List<Header> listaHeader = treinoDAO.obterTreinosDia(header);
		
		for (Header h : listaHeader) {
			
			Treino treino = new Treino();
			
			treino = treinoDAO.obterTreino(h);
			
			listaTreino.add(treino);
			
		}
		
		return listaTreino;
	}

}
