/**
 * 
 */
package br.com.qtslive.atleta.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.qtslive.atleta.facade.AtletaServiceFacade;
import br.com.qtslive.configuracoes.facade.ConfiguracaoServiceFacade;
import br.com.qtslive.foto.facade.FotoUploadServiceFacade;
import br.com.qtslive.model.Atleta;
import br.com.qtslive.model.Categoria;
import br.com.qtslive.model.Dominancia;
import br.com.qtslive.model.Posicao;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * Action que inicia a tela de perfil de um atleta.
 * 
 * @author Tomás Azevedo
 *
 */
public class PerfilAtletaAction extends ActionSupport {

	private static final long serialVersionUID = 7560750882510719544L;
	
	@Autowired
	private AtletaServiceFacade atletaServiceFacade;
	@Autowired
	private FotoUploadServiceFacade fotoUploadServiceFacade;
	@Autowired
	private ConfiguracaoServiceFacade configuracaoServiceFacade;
	
	private Long idAtleta;
	private Long idClube;
	private Atleta atleta;
	private List<Posicao> listaPosicao = new ArrayList<Posicao>();
	private List<Dominancia> listaDominancia = new ArrayList<Dominancia>();
	private List<Categoria> listaCategoria = new ArrayList<Categoria>();
	
	public String iniciar() {
		
		//Lista de posições.
		this.listaPosicao = configuracaoServiceFacade.listarPosicoes(idClube);
		//Lista de dominâncias.
		this.listaDominancia = configuracaoServiceFacade.listarDominancias(idClube);
		//Lista de categorias.
		this.listaCategoria = configuracaoServiceFacade.listarCategorias(idClube);
		
		atleta = atletaServiceFacade.obterAtleta(idAtleta);
		
//		if(fotoUploadServiceFacade.temFoto(idAtleta)) {
//			Foto foto = new Foto();
//			foto.setId(idAtleta);
//			atleta.setFoto(foto);
//		}
		
		List<Long> listaIds = new ArrayList<Long>();
		for (Posicao p : atleta.getListaPosicao()) {
			listaIds.add(p.getId());
		}
		
		for (Posicao p : listaPosicao) {
			if(listaIds.contains(p.getId())) {
				p.setSelecionado(true);
			}
		}
		
		return SUCCESS;
	}

	public Atleta getAtleta() {
		return atleta;
	}

	public void setAtleta(Atleta atleta) {
		this.atleta = atleta;
	}

	public Long getIdAtleta() {
		return idAtleta;
	}

	public void setIdAtleta(Long idAtleta) {
		this.idAtleta = idAtleta;
	}

	public List<Posicao> getListaPosicao() {
		return listaPosicao;
	}

	public void setListaPosicao(List<Posicao> listaPosicao) {
		this.listaPosicao = listaPosicao;
	}

	public List<Dominancia> getListaDominancia() {
		return listaDominancia;
	}

	public void setListaDominancia(List<Dominancia> listaDominancia) {
		this.listaDominancia = listaDominancia;
	}

	public List<Categoria> getListaCategoria() {
		return listaCategoria;
	}

	public void setListaCategoria(List<Categoria> listaCategoria) {
		this.listaCategoria = listaCategoria;
	}

	public Long getIdClube() {
		return idClube;
	}

	public void setIdClube(Long idClube) {
		this.idClube = idClube;
	}
	
	

}
