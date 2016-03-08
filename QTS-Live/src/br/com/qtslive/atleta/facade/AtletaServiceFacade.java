/**
 * 
 */
package br.com.qtslive.atleta.facade;

import java.util.List;

import br.com.qtslive.model.Atleta;

/**
 * 
 * Interface para operações com Atletas.
 * 
 * @author Tomás Azevedo
 *
 */
public interface AtletaServiceFacade {
	
	public Atleta criarAtleta(Atleta atleta);

	public List<Atleta> listarAtletas(Long idClube);
	
	public List<Atleta> listarAtletasCategoria(Long idClube, Long idCategoria);	

	public Atleta obterAtleta(Long idAtleta);

	public void atualizar(Atleta atleta);
	
	public void excluir(Long idAtleta, Long idClube);

}
