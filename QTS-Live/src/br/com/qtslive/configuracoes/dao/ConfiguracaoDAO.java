/**
 * 
 */
package br.com.qtslive.configuracoes.dao;

import java.util.List;

import br.com.qtslive.model.Categoria;
import br.com.qtslive.model.Dominancia;
import br.com.qtslive.model.Especial;
import br.com.qtslive.model.Exercicio;
import br.com.qtslive.model.Grupo;
import br.com.qtslive.model.LocalDor;
import br.com.qtslive.model.LocalTreino;
import br.com.qtslive.model.Perfil;
import br.com.qtslive.model.Periodo;
import br.com.qtslive.model.Posicao;
import br.com.qtslive.model.TipoSessao;
import br.com.qtslive.model.TipoTreinamentoFisico;
import br.com.qtslive.model.TipoTreinamentoTatico;
import br.com.qtslive.model.TipoTreinamentoTecnico;

/**
 * 
 * Interface para acesso aos dados de configuração / listas do sistema.
 * 
 * @author Tomás Azevedo
 *
 */
public interface ConfiguracaoDAO {
	
	/*POSIÇÃO*/
	public List<Posicao> listarPosicoes(Long idClube);	
	public Posicao criarPosicao(Posicao posicao);
	public void editarPosicao(Posicao posicao);
	public void excluirPosicao(Posicao posicao);
	public String obterSiglaPosicao(Long id, Long idClube);
	public String obterNomePosicao(Long id, Long idClube);
	
	/*DOMINÂNCIA*/
	public Dominancia criarDominancia(Dominancia dominancia);
	public List<Dominancia> listarDominancias(Long idClube);
	public void editarDominancia(Dominancia dominancia);
	public void excluirDominancia(Dominancia dominancia);
	public String obterNomeDominancia(Long id, Long idClube);
	
	/*CATEGORIAS*/
	public List<Categoria> listarCategorias(Long idClube);
	public Categoria criarCategoria(Categoria categoria);
	public void editarCategoria(Categoria categoria);
	public void excluirCategoria(Categoria categoria);
	public String obterNomeCategoria(Long id, Long idClube);
	
	/*PERFIL*/
	public List<Perfil> listarPerfis(Long idClube);
	public Perfil criarPerfil(Perfil perfil);
	public void editarPerfil(Perfil perfil);
	public void excluirPerfil(Perfil perfil);
	
	/*EXERCÍCIO*/
	public List<Exercicio> listarExercicios(Long idClube);
	public void excluirExercicio(Exercicio exercicio);
	public void editarExercicio(Exercicio exercicio);
	public Exercicio criarExercicio(Exercicio exercicio);
	
	/*CATEGORIAS*/
	public List<LocalDor> listarLocalDor(Long idClube);
	public LocalDor criarLocalDor(LocalDor localDor);
	public void editarLocalDor(LocalDor localDor);
	public void excluirLocalDor(LocalDor localDor);
	
	/*TPO TREINAMENTO FISICO*/
	public List<TipoTreinamentoFisico> listarTipoTreinamentoFisico(Long idClube);
	public TipoTreinamentoFisico criarTipoTreinamentoFisico(TipoTreinamentoFisico tipoTreinamentoFisico);
	public void editarTipoTreinamentoFisico(TipoTreinamentoFisico tipoTreinamentoFisico);
	public void excluirTipoTreinamentoFisico(TipoTreinamentoFisico tipoTreinamentoFisico);
	
	/*TPO TREINAMENTO TECNICO*/
	public List<TipoTreinamentoTecnico> listarTipoTreinamentoTecnico(Long idClube);
	public TipoTreinamentoTecnico criarTipoTreinamentoTecnico(TipoTreinamentoTecnico tipoTreinamentoTecnico);
	public void editarTipoTreinamentoTecnico(TipoTreinamentoTecnico tipoTreinamentoTecnico);
	public void excluirTipoTreinamentoTecnico(TipoTreinamentoTecnico tipoTreinamentoTecnico);
	
	/*TPO TREINAMENTO TATICO*/
	public List<TipoTreinamentoTatico> listarTipoTreinamentoTatico(Long idClube);
	public TipoTreinamentoTatico criarTipoTreinamentoTatico(TipoTreinamentoTatico tipoTreinamentoTatico);
	public void editarTipoTreinamentoTatico(TipoTreinamentoTatico tipoTreinamentoTatico);
	public void excluirTipoTreinamentoTatico(TipoTreinamentoTatico tipoTreinamentoTatico);
		
	/*LOCAL TREINO*/
	public List<LocalTreino> listarLocalTreino(Long idClube);
	public LocalTreino criarLocalTreino(LocalTreino localTreino);
	public void editarLocalTreino(LocalTreino localTreino);
	public void excluirLocalTreino(LocalTreino localTreino);
	
	/*TIPO SESSAO*/
	public List<TipoSessao> listarTipoSessao(Long idClube);
	public TipoSessao criarTipoSessao(TipoSessao tipoSessao);
	public void editarTipoSessao(TipoSessao tipoSessao);
	public void excluirTipoSessao(TipoSessao tipoSessao);
	
	/*PERÍODO*/
	public List<Periodo> listarPeriodo(Long idClube);
	public Periodo criarPeriodo(Periodo periodo);
	public void editarPeriodo(Periodo periodo);
	public void excluirPeriodo(Periodo periodo);
	
	/*GRUPO*/
	public List<Grupo> listarGrupo(Long idClube);
	public Grupo criarGrupo(Grupo grupo);
	public void editarGrupo(Grupo grupo);
	public void excluirGrupo(Grupo grupo);
	
	/*ESPECIAL*/
	public List<Especial> listarEspecial(Long idClube);
	public void excluirEspecial(Especial especial);
	public void editarEspecial(Especial especial);
	public Especial criarEspecial(Especial especial);

}
