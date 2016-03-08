/**
 * 
 */
package br.com.qtslive.login.interceptor;

import java.util.Map;

import br.com.qtslive.model.usuario.Usuario;
import br.com.qtslive.utils.Constantes;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * 
 * Interceptor para verificar se o usuário está cadastrado.
 * 
 * @author Tomás Azevedo
 *
 */
public class LoginInterceptor implements Interceptor {

	private static final long serialVersionUID = 3025828944493891298L;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		
		Map<String, Object> sessionAttributes = actionInvocation.getInvocationContext().getSession();
		        
        String pais = (String) sessionAttributes.get(Constantes.PAIS_SESSION);
        if(null==pais) {
        	 pais = actionInvocation.getInvocationContext().getLocale().getCountry(); 
        	 actionInvocation.getInvocationContext().getSession().put(Constantes.PAIS_SESSION, pais);
        }
        
        String idioma = (String) sessionAttributes.get(Constantes.IDIOMA_SESSION);
        if(null==idioma) {
        	idioma = actionInvocation.getInvocationContext().getLocale().getLanguage();
        	actionInvocation.getInvocationContext().getSession().put(Constantes.IDIOMA_SESSION, idioma);
        }
        
        Usuario usuario = (Usuario) sessionAttributes.get(Constantes.USUARIO_SESSION);
         
        if(usuario == null){
            return Action.LOGIN;
        }
		
        return actionInvocation.invoke();
	}

}
