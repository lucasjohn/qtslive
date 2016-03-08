/**
 * 
 */
package br.com.qtslive.treinamento.facade;

import java.time.LocalDate;
import java.util.List;

import br.com.qtslive.model.treino.Header;
import br.com.qtslive.model.treino.Treino;

/**
 * 
 * Interface para as funcionalidades relacionadas a um treino.
 * 
 * @author Tomás Azevedo
 *
 */
public interface TreinoServiceFacade {
	
	public boolean criar(Treino treino);
	
	public Treino obterTreinoSimplificado(Header header);
	
	public List<Treino> listarTreinosSimplificados(Long idClube, Long idCategoria, LocalDate dataInicio, LocalDate dataFim);
	
	public boolean excluir(Header header);
	
	public List<Treino> listarTreinos(Header header);

}
