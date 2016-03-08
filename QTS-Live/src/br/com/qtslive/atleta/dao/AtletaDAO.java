/**
 * 
 */
package br.com.qtslive.atleta.dao;

import java.util.List;

import br.com.qtslive.model.Atleta;

/**
 * 
 * Interface para acesso ao banco de dados.
 * 
 * @author Tomás Azevedo
 *
 */
public interface AtletaDAO {
	
	public Atleta criarAtleta(Atleta atleta);

	public List<Atleta> listar(Long idClube);
	
	public List<Atleta> listarAtletasCategoria(Long idClube, Long idCategoria);	
	
	public Atleta obterAtleta(Long idAtleta);

	public void atualizar(Atleta atleta);
	
	public Long obterIdPosicoes(Long idAtleta, Long idClube);
	
	public void excluir(Long idAtleta, Long idClube, Long idPosicoes);

}
