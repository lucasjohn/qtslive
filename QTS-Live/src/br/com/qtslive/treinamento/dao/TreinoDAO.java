/**
 * 
 */
package br.com.qtslive.treinamento.dao;

import java.time.LocalDate;
import java.util.List;

import br.com.qtslive.model.treino.Header;
import br.com.qtslive.model.treino.Treino;

/**
 * 
 * Interface para gravação de dados relacionados a treinamento.
 * 
 * @author Tomás Azevedo
 *
 */
public interface TreinoDAO {
	
	public boolean criar(Treino treino);
	
	public Treino obterTreinoSimplificado(Header header);
	
	public List<Treino> listarTreinosSimplificados(Long idClube, Long idCategoria, LocalDate dataInicio, LocalDate dataFim);
	
	public boolean excluir(Header header);
	
	public Treino obterTreino(Header header);
	
	public List<Header> obterTreinosDia(Header header);

}
