/**
 * 
 */
package br.com.qtslive.model.usuario;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.com.qtslive.model.Categoria;
import br.com.qtslive.model.Clube;
import br.com.qtslive.model.Endereco;
import br.com.qtslive.model.Foto;
import br.com.qtslive.model.Perfil;
import br.com.qtslive.utils.Constantes;

/**
 * 
 * Classe que representa um Usuário do sistema.
 * 
 * @author Tomás Azevedo
 *
 */
public class Usuario {
	
	private Long id;
	private String email;
	private String senha;
	private String nome;	
	private LocalDate dataNascimento;
	private String dataNascimentoString;
	private String dataInicioVigenciaString;
	private LocalDate dataInicioVigencia;
	private String dataFimVigenciaString;
	private LocalDate dataFimVigencia;
	private Perfil perfil;
	//private Long idCategoria;
	private Categoria categoria;
	private Endereco endereco;
	private Clube clube;
	private Foto foto;
	
	private DateTimeFormatter formatador = DateTimeFormatter.ofPattern(Constantes.FORMATO_DATA);
	
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
		this.dataFimVigenciaString = dataNascimento.format(formatador);
	}
	public String getDataNascimentoString() {
		return dataNascimentoString;
	}
	public void setDataNascimentoString(String dataNascimentoString) {
		this.dataNascimentoString = dataNascimentoString;
		this.dataNascimento =  LocalDate.parse(dataNascimentoString, formatador);
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
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
	public LocalDate getDataInicioVigencia() {
		return dataInicioVigencia;
	}
	public void setDataInicioVigencia(LocalDate dataInicioVigencia) {
		this.dataInicioVigencia = dataInicioVigencia;
		this.dataInicioVigenciaString = dataInicioVigencia.format(formatador);
	}
	public LocalDate getDataFimVigencia() {
		return dataFimVigencia;
	}
	public void setDataFimVigencia(LocalDate dataFimVigencia) {
		this.dataFimVigencia = dataFimVigencia;
		this.dataFimVigenciaString = dataFimVigencia.format(formatador);		
	}
	public Perfil getPerfil() {
		return perfil;
	}
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}	
	public String getDataInicioVigenciaString() {
		return dataInicioVigenciaString;
	}
	public void setDataInicioVigenciaString(String dataInicioVigenciaString) {
		this.dataInicioVigenciaString = dataInicioVigenciaString;
		this.dataInicioVigencia =  LocalDate.parse(dataInicioVigenciaString, formatador);
	}
	public String getDataFimVigenciaString() {
		return dataFimVigenciaString;
	}
	public void setDataFimVigenciaString(String dataFimVigenciaString) {
		this.dataFimVigenciaString = dataFimVigenciaString;
		this.dataFimVigencia =  LocalDate.parse(dataFimVigenciaString, formatador);
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
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
	
}
