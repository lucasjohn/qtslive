/**
 * 
 */
package br.com.qtslive.configuracoes.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.qtslive.configuracoes.dao.ConfiguracaoDAO;
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
 * Implementação da interface ConfiguracaoServiceFacade.
 * 
 * @author Tomás Azevedo
 *
 */
@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class ConfiguracaoServiceFacadeImpl implements ConfiguracaoServiceFacade {

	@Autowired
	private ConfiguracaoDAO configuracaoDAO;
	
	@Override
	public List<Posicao> listarPosicoes(Long idClube) {
		return configuracaoDAO.listarPosicoes(idClube);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public Posicao criarPosicao(Posicao posicao) {
		return configuracaoDAO.criarPosicao(posicao);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void editarPosicao(Posicao posicao) {
		configuracaoDAO.editarPosicao(posicao);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void excluirPosicao(Posicao posicao) {
		configuracaoDAO.excluirPosicao(posicao);		
	}
	
	@Override
	public String obterSiglaPosicao(Long id, Long idClube) {
		return configuracaoDAO.obterSiglaPosicao(id, idClube);
	}

	@Override
	public String obterNomePosicao(Long id, Long idClube) {
		return configuracaoDAO.obterNomePosicao(id, idClube);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public Dominancia criarDominancia(Dominancia dominancia) {
		return configuracaoDAO.criarDominancia(dominancia);
	}

	@Override
	public List<Dominancia> listarDominancias(Long idClube) {
		return configuracaoDAO.listarDominancias(idClube);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void editarDominancia(Dominancia dominancia) {
		configuracaoDAO.editarDominancia(dominancia);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void excluirDominancia(Dominancia dominancia) {
		configuracaoDAO.excluirDominancia(dominancia);
	}
	
	@Override
	public String obterNomeDominancia(Long id, Long idClube) {
		return configuracaoDAO.obterNomeDominancia(id, idClube);
	}

	@Override
	public List<Categoria> listarCategorias(Long idClube) {
		return configuracaoDAO.listarCategorias(idClube);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public Categoria criarCategoria(Categoria categoria) {
		return configuracaoDAO.criarCategoria(categoria);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void editarCategoria(Categoria categoria) {
		configuracaoDAO.editarCategoria(categoria);		
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void excluirCategoria(Categoria categoria) {
		configuracaoDAO.excluirCategoria(categoria);
	}
	
	@Override
	public String obterNomeCategoria(Long id, Long idClube) {
		return configuracaoDAO.obterNomeCategoria(id, idClube);
	}

	@Override
	public List<Perfil> listarPerfis(Long idClube) {
		return configuracaoDAO.listarPerfis(idClube);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public Perfil criarPerfil(Perfil perfil) {
		return configuracaoDAO.criarPerfil(perfil);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void editarPerfil(Perfil perfil) {
		configuracaoDAO.editarPerfil(perfil);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void excluirPerfil(Perfil perfil) {
		configuracaoDAO.excluirPerfil(perfil);
	}

	@Override
	public List<Exercicio> listarExercicio(Long idClube) {
		return configuracaoDAO.listarExercicios(idClube);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void excluirExercicio(Exercicio exercicio) {
		configuracaoDAO.excluirExercicio(exercicio);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void editarExercicio(Exercicio exercicio) {
		configuracaoDAO.editarExercicio(exercicio);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public Exercicio criarExercicio(Exercicio exercicio) {
		return configuracaoDAO.criarExercicio(exercicio);
	}
	
	@Override
	public List<LocalDor> listarLocalDor(Long idClube) {
		return configuracaoDAO.listarLocalDor(idClube);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void excluirLocalDor(LocalDor localDor) {
		configuracaoDAO.excluirLocalDor(localDor);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void editarLocalDor(LocalDor localDor) {
		configuracaoDAO.editarLocalDor(localDor);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public LocalDor criarLocalDor(LocalDor localDor) {
		return configuracaoDAO.criarLocalDor(localDor);
	}
	
	@Override
	public List<TipoTreinamentoFisico> listarTipoTreinamentoFisico(Long idClube) {
		return configuracaoDAO.listarTipoTreinamentoFisico(idClube);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void excluirTipoTreinamentoFisico(TipoTreinamentoFisico tipoTreinamentoFisico) {
		configuracaoDAO.excluirTipoTreinamentoFisico(tipoTreinamentoFisico);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void editarTipoTreinamentoFisico(TipoTreinamentoFisico tipoTreinamentoFisico) {
		configuracaoDAO.editarTipoTreinamentoFisico(tipoTreinamentoFisico);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public TipoTreinamentoFisico criarTipoTreinamentoFisico(TipoTreinamentoFisico tipoTreinamentoFisico) {
		return configuracaoDAO.criarTipoTreinamentoFisico(tipoTreinamentoFisico);
	}

	@Override
	public List<TipoTreinamentoTecnico> listarTipoTreinamentoTecnico(Long idClube) {
		return configuracaoDAO.listarTipoTreinamentoTecnico(idClube);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public TipoTreinamentoTecnico criarTipoTreinamentoTecnico(TipoTreinamentoTecnico tipoTreinamentoTecnico) {
		return configuracaoDAO.criarTipoTreinamentoTecnico(tipoTreinamentoTecnico);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void editarTipoTreinamentoTecnico(TipoTreinamentoTecnico tipoTreinamentoTecnico) {
		configuracaoDAO.editarTipoTreinamentoTecnico(tipoTreinamentoTecnico);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void excluirTipoTreinamentoTecnico(TipoTreinamentoTecnico tipoTreinamentoTecnico) {
		configuracaoDAO.excluirTipoTreinamentoTecnico(tipoTreinamentoTecnico);
	}

	@Override
	public List<TipoTreinamentoTatico> listarTipoTreinamentoTatico(Long idClube) {		
		return configuracaoDAO.listarTipoTreinamentoTatico(idClube);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public TipoTreinamentoTatico criarTipoTreinamentoTatico(TipoTreinamentoTatico tipoTreinamentoTatico) {
		return configuracaoDAO.criarTipoTreinamentoTatico(tipoTreinamentoTatico);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void editarTipoTreinamentoTatico(TipoTreinamentoTatico tipoTreinamentoTatico) {
		configuracaoDAO.editarTipoTreinamentoTatico(tipoTreinamentoTatico);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void excluirTipoTreinamentoTatico(TipoTreinamentoTatico tipoTreinamentoTatico) {
		configuracaoDAO.excluirTipoTreinamentoTatico(tipoTreinamentoTatico);
	}
	
	@Override
	public List<LocalTreino> listarLocalTreino(Long idClube) {
		return configuracaoDAO.listarLocalTreino(idClube);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public LocalTreino criarLocalTreino(LocalTreino localTreino) {
		return configuracaoDAO.criarLocalTreino(localTreino);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void editarLocalTreino(LocalTreino localTreino) {
		configuracaoDAO.editarLocalTreino(localTreino);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void excluirLocalTreino(LocalTreino localTreino) {
		configuracaoDAO.excluirLocalTreino(localTreino);
	}

	@Override
	public List<TipoSessao> listarTipoSessao(Long idClube) {
		return configuracaoDAO.listarTipoSessao(idClube);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public TipoSessao criarTipoSessao(TipoSessao tipoSessao) {
		return configuracaoDAO.criarTipoSessao(tipoSessao);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void editarTipoSessao(TipoSessao tipoSessao) {
		configuracaoDAO.editarTipoSessao(tipoSessao);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void excluirTipoSessao(TipoSessao tipoSessao) {
		configuracaoDAO.excluirTipoSessao(tipoSessao);
	}

	@Override
	public List<Periodo> listarPeriodo(Long idClube) {
		return configuracaoDAO.listarPeriodo(idClube);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public Periodo criarPeriodo(Periodo periodo) {
		return configuracaoDAO.criarPeriodo(periodo);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void editarPeriodo(Periodo periodo) {
		configuracaoDAO.editarPeriodo(periodo);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void excluirPeriodo(Periodo periodo) {
		configuracaoDAO.excluirPeriodo(periodo);
	}

	@Override
	public List<Grupo> listarGrupo(Long idClube) {		
		return configuracaoDAO.listarGrupo(idClube);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public Grupo criarGrupo(Grupo grupo) {		
		return configuracaoDAO.criarGrupo(grupo);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void editarGrupo(Grupo grupo) {
		configuracaoDAO.editarGrupo(grupo);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void excluirGrupo(Grupo grupo) {
		configuracaoDAO.excluirGrupo(grupo);
	}

	@Override
	public List<Especial> listarEspecial(Long idClube) {
		return configuracaoDAO.listarEspecial(idClube);
	}

	@Override
	public void excluirEspecial(Especial especial) {
		configuracaoDAO.excluirEspecial(especial);
	}

	@Override
	public void editarEspecial(Especial especial) {
		configuracaoDAO.editarEspecial(especial);
	}

	@Override
	public Especial criarEspecial(Especial especial) {
		return configuracaoDAO.criarEspecial(especial);
	}
	

}
