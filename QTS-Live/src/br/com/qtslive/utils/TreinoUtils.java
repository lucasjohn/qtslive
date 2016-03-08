/**
 * 
 */
package br.com.qtslive.utils;

import java.util.ArrayList;
import java.util.List;

import br.com.qtslive.model.Atleta;
import br.com.qtslive.model.Grupo;
import br.com.qtslive.model.TipoTreinamentoFisico;
import br.com.qtslive.model.TipoTreinamentoTatico;
import br.com.qtslive.model.TipoTreinamentoTecnico;
import br.com.qtslive.model.treino.Atividade;
import br.com.qtslive.model.treino.AtletaAtividades;
import br.com.qtslive.model.treino.GrupoAtletas;

/**
 * 
 * Classe utilitária para o treinamento.
 * 
 * @author Tomás Azevedo
 *
 */
public class TreinoUtils {
	
	private static final String SEPARADOR_OBJETO = "@";
	private static final String SEPARADOR_ATRIBUTO = "\\|";
	private static final String SEPARADOR_VALOR = "=";
	
	private static final int NOME_ATRIBUTO = 0;
	private static final int VALOR_ATRIBUTO = 1;
	
	private static final String SEPARADOR_IDS = ",";
	private static final String SEPARADOR_GRP_ATL = ":";
	
	private static final int CD_GRUPO = 0;
	private static final int IDS_ATLETAS = 1;
	
	private static final String ID_GRUPO = "idGrupo";
	//private static final String NOME_GRUPO = "nomeGrupo";
	private static final String TP_ATIVIDADE = "tipoAtividade";
	private static final String ID_ATIVIDADE = "idAtividade";
	private static final String NOME_ATIVIDADE = "nomeAtividade";
	private static final String DURACAO = "duracao";
	private static final String OBSERVACOES = "observacoes";
	
	
	
	/**
	 * 
	 * Retorna uma lista de grupos de atletas de acordo com a string concatenada que vem da jsp calendarioTreinamento.jsp / treina.jsp.
	 * 
	 * @param string - string concatenada.
	 * 
	 * @return lista de grupos de atletas.
	 * 
	 */
	public static List<GrupoAtletas> obterGruposAtltetas(String gruposString, String atividadesString) {
		
		//Código grupo: id, id, id, etc@código grupo: id, id, id, etc.
		//1:6,8,11,12,13@2:7,10,21,22,24
		
		List<GrupoAtletas> lista = new ArrayList<GrupoAtletas>();
		
		String grupos[] = gruposString.split(SEPARADOR_OBJETO);
		
		//Para cada grupo
		for (String g : grupos) {
			
			String[] idGrupoIdAtletas = g.split(SEPARADOR_GRP_ATL);
			
			GrupoAtletas grupoAtletas = new GrupoAtletas();
			
			Grupo grupo = new Grupo();
			grupo.setId(Long.parseLong(idGrupoIdAtletas[CD_GRUPO]));			
			grupoAtletas.setGrupo(grupo);
			
			List<AtletaAtividades> listaAtletaAtividades = new ArrayList<AtletaAtividades>();

			if(idGrupoIdAtletas.length > 1) {
				
				String[] ids = idGrupoIdAtletas[IDS_ATLETAS].split(SEPARADOR_IDS);
				for (String id : ids) {
					
					AtletaAtividades atletaAtividades = new AtletaAtividades();
					
					Atleta atleta = new Atleta();
					atleta.setId(Long.parseLong(id));
					atletaAtividades.setAtleta(atleta);
					
					atletaAtividades.setListaAtividade(obterAtividades(atividadesString, grupo.getId()));
					listaAtletaAtividades.add(atletaAtividades);
				}
				
			}
			
			grupoAtletas.setListaAtletaAtividades(listaAtletaAtividades);
			
			lista.add(grupoAtletas);
						
		}
				
		return lista;
	}
	
	
	
	/**
	 * 
	 * Retorna uma lista de atividades de acordo com a string concatenada que vem da jsp calendarioTreinamento.jsp / treina.jsp.
	 * 
	 * @param string - string concatenada.
	 * 
	 * @return lista de atividades.
	 * 
	 */
	private static List<Atividade> obterAtividades(String string, Long codigoGrupo) {
		
		//idGrupo=1|nomeGrupo=Titulares|tipoAtividade=1|idAtividade=1|nomeAtividade=AceleraÃ§Ã£o|duracao=56|observacoes=@
		//idGrupo=1|nomeGrupo=Titulares|tipoAtividade=1|idAtividade=2|nomeAtividade=AerÃ³bio|duracao=56|observacoes=@
		//idGrupo=2|nomeGrupo=Reservas|tipoAtividade=1|idAtividade=2|nomeAtividade=AerÃ³bio|duracao=56|observacoes=@
		//idGrupo=2|nomeGrupo=Reservas|tipoAtividade=1|idAtividade=6|nomeAtividade=CORE|duracao=56|observacoes=
		
		List<Atividade> lista = new ArrayList<Atividade>();
		
		String[] atividades;
		atividades = string.split(SEPARADOR_OBJETO);
		
		for (String s : atividades) {
			
			Atividade atividade = new Atividade();
			
			String[] atributos = s.split(SEPARADOR_ATRIBUTO);
			
			Long cdGrupo = 0L;
			
			for (String campo : atributos) {
				
				String nomeValor[] = campo.split(SEPARADOR_VALOR);				
				
				if(nomeValor[NOME_ATRIBUTO].equals(ID_GRUPO)) {
					cdGrupo = Long.parseLong(nomeValor[VALOR_ATRIBUTO]);
				}	
				
				if(nomeValor[NOME_ATRIBUTO].equals(TP_ATIVIDADE)) {					
					//atividade.setTipoAtividade();
					atividade.setCdTipoAtividade(Integer.parseInt(nomeValor[VALOR_ATRIBUTO]));
				}
				
				if(nomeValor[NOME_ATRIBUTO].equals(ID_ATIVIDADE)) {
					atividade.setIdAtividade(Long.parseLong(nomeValor[VALOR_ATRIBUTO]));
				}	
				
				if(nomeValor[NOME_ATRIBUTO].equals(NOME_ATIVIDADE)) {
					atividade.setNomeAtividade(nomeValor[VALOR_ATRIBUTO]);
				}
				
				if(nomeValor[NOME_ATRIBUTO].equals(DURACAO)) {
					atividade.setDuracao(Integer.parseInt(nomeValor[VALOR_ATRIBUTO]));
				}
				
				if(nomeValor[NOME_ATRIBUTO].equals(OBSERVACOES)) {
					if(nomeValor.length > 1) {
						atividade.setObservacoes(nomeValor[VALOR_ATRIBUTO]);
					}
				}	
				
			}
			
			if(cdGrupo == codigoGrupo) {
				lista.add(atividade);
			}
			
		}
		
		return lista;
		
	}
	
	
	/**
	 * 
	 * Retorna o nome da atividade de acordo com o tipo de treinamento.
	 * 
	 * @param tipo - tipo de treinamento (TREINAMENTO_FISICO = 1, TREINAMENTO_TATICO = 2 e TREINAMENTO_TECNICO = 3)
	 * @param codigo - código da atividade.
	 * @param listaFisico - lista de atividades físicas.
	 * @param listaTatico - lista de atividades táticas.
	 * @param listaTecnico - lista de atividades técnicas.
	 * 
	 * @return nome da atividade.
	 */
	public static String getNomeAtividade(int tipo, Long codigo, List<TipoTreinamentoFisico> listaFisico, List<TipoTreinamentoTatico> listaTatico, List<TipoTreinamentoTecnico> listaTecnico) {
		
		String nome = "";
		
		if(tipo==Constantes.TREINAMENTO_FISICO) {
			
			for (TipoTreinamentoFisico tipoTreinamentoFisico : listaFisico) {
				
				if(codigo == tipoTreinamentoFisico.getId()) {
					nome = tipoTreinamentoFisico.getNome();
					break;
				}
			}
		}
		
		if(tipo==Constantes.TREINAMENTO_TATICO) {
			
			for (TipoTreinamentoTatico tipoTreinamentoTatico : listaTatico) {
				
				if(codigo == tipoTreinamentoTatico.getId()) {
					nome = tipoTreinamentoTatico.getNome();
					break;
				}
			}
		}

		if(tipo==Constantes.TREINAMENTO_TECNICO) {
			
			for (TipoTreinamentoTecnico tipoTreinamentoTecnico : listaTecnico) {
				
				if(codigo == tipoTreinamentoTecnico.getId()) {
					nome = tipoTreinamentoTecnico.getNome();
					break;
				}
			}
		}
		
		return nome;
	}
	
	
	

}
