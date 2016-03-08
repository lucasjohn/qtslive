/**
 * 
 */
package br.com.qtslive.utils;

/**
 * 
 * Enum de atividades.
 * 
 * @author Tomás Azevedo
 *
 */
public enum TipoAtividadeEnum {
	
	FISICA(1), TATICA(2), TECNICA(3); 
	
	private final int valor; 
	
	TipoAtividadeEnum(int valorOpcao) {
		valor = valorOpcao; 
	} 
	
	public int getValor() {
		return valor; 
	}


}
