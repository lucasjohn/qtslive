/**
 * 
 */
package br.com.qtslive.model.treino;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.com.qtslive.model.Categoria;
import br.com.qtslive.model.Periodo;
import br.com.qtslive.utils.Constantes;

/**
 * 
 * Classe que contém os dados que identificam qual é o treino.
 * 
 * @author Tomás Azevedo
 *
 */
public class Header {
	
	private Long idClube;
	private Categoria categoria;
	private String dataString;
	private LocalDate data;
	private Periodo periodo;
	private int codigoTreino;
	
	private DateTimeFormatter formatador = DateTimeFormatter.ofPattern(Constantes.FORMATO_DATA);
	
	public String getDataString() {
		return dataString;
	}

	public void setDataString(String dataString) {
		this.dataString = dataString;
		this.data = LocalDate.parse(dataString, formatador);
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
		this.dataString = data.format(formatador);
	}

	public Periodo getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}
	
	public Long getIdClube() {
		return idClube;
	}

	public void setIdClube(Long idClube) {
		this.idClube = idClube;
	}

	public int getCodigoTreino() {
		return codigoTreino;
	}

	public void setCodigoTreino(int codigoTreino) {
		this.codigoTreino = codigoTreino;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	
	
	

}
