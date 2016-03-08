/**
 * 
 */
package br.com.qtslive.model;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;

import br.com.qtslive.utils.Constantes;

/**
 *
 * Classe que representa um Atleta.
 * 
 * @author Tomás Azevedo
 *
 */
public class Atleta {
	
	private Long id;	
	private String nome;
	private String apelido;
	private String email;
	private LocalDate dataNascimento;
	private String dataNascimentoString;
	private int idade;
	private String telefone;
	private Categoria categoria;
	private Dominancia dominancia;	
	private List<Posicao> listaPosicao;
	private String siglasPosicoesString;
	private Clube clube;
	private Foto foto;
	private DateTimeFormatter formatador = DateTimeFormatter.ofPattern(Constantes.FORMATO_DATA);
		
	
	public String getDataNascimentoString() {
		return dataNascimentoString;
	}
	public void setDataNascimentoString(String dataNascimentoString) {		
		this.dataNascimentoString = dataNascimentoString;
		this.dataNascimento =  LocalDate.parse(dataNascimentoString, formatador);
	}	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getApelido() {
		return apelido;
	}
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
		this.dataNascimentoString = dataNascimento.format(formatador);
		if(null!=this.dataNascimento) {
			Period periodo = Period.between(this.dataNascimento, LocalDate.now());
			this.idade = periodo.getYears();
		}
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}	
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Dominancia getDominancia() {
		return dominancia;
	}
	public void setDominancia(Dominancia dominancia) {
		this.dominancia = dominancia;
	}
	public List<Posicao> getListaPosicao() {
		return listaPosicao;
	}
	public void setListaPosicao(List<Posicao> listaPosicao) {
		this.listaPosicao = listaPosicao;
		this.siglasPosicoesString = obterSiglasPosicoesString(listaPosicao);
	}
	public Clube getClube() {
		return clube;
	}
	public void setClube(Clube clube) {
		this.clube = clube;
	}
	public Foto getFoto() {
		return foto;
	}
	public void setFoto(Foto foto) {
		this.foto = foto;
	}
	public int getIdade() {	
		/*if(null!=this.dataNascimento) {
			Period periodo = Period.between(this.dataNascimento, LocalDate.now());
			this.idade = periodo.getYears();
		}*/
		return this.idade;
	}	
	public String getSiglasPosicoesString() {
		return siglasPosicoesString;
	}		
	public void setSiglasPosicoesString(String siglasPosicoesString) {
		this.siglasPosicoesString = siglasPosicoesString;
	}
	private String obterSiglasPosicoesString(List<Posicao> lista) {
		
		StringBuilder texto = new StringBuilder();
		int tam = lista.size();
		int cont = 0;
		for (Posicao posicao : lista) {
			if(cont==0) {
				texto.append(posicao.getSigla());
			} else {
				if(cont==tam-1) {
					texto.append(" e ").append(posicao.getSigla());
				} else {
					texto.append(", ").append(posicao.getSigla());
				}
			}	
			cont++;
		}
		return texto.toString();
		
	}

}
