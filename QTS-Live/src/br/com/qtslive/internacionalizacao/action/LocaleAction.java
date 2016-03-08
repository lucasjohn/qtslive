/**
 * 
 */
package br.com.qtslive.internacionalizacao.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import br.com.qtslive.utils.Constantes;

/**
 * @author M109344
 *
 */
public class LocaleAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 2561063841982937495L;	
	
	private Map<String, Object> session;
	
	private String idioma;
	private String pais;
	
	public String execute() {
				
		session.put(Constantes.IDIOMA_SESSION, idioma);
		session.put(Constantes.PAIS_SESSION, pais);
		return SUCCESS;
	}		

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getPais() {
		return pais;
	}
	
	public void setPais(String pais) {
		this.pais = pais;
	}


	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;		
	}

}
