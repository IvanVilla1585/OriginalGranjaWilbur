/**
 * ListaPerfil.java
 *
 * Clase que contiene los metodos de un CRUD en una lista simplemente ligada
 *
 * @author Veronica Andrea Velez
 * @author Jhon Fredy Parra
 * @author Ivan Dario Villa Ramirez
 * @version 1.0 12/11/2014
 * @since JDK version 1.6.0_20
 */

package listas;

import logica.DatosPerfil;
import nodos.NodoPerfil;
import java.util.Date;

public class ListaPerfil {
	
	/** primer nodo dela lista */
	private NodoPerfil cabeza;
	
	/** ultimo nodo dela lista */
	private NodoPerfil ultimo;
	
	/** milisegundos que contiened un día */
	private final long  MILI_SEGU_DIA= 24 * 60 * 60 * 1000;
	
	public ListaPerfil(){
		
		cabeza = null;
		ultimo = null;
	} 
	
	public NodoPerfil getCabeza() {
        
        return cabeza;
    }

    public void setCabeza(NodoPerfil cabeza) {
        
        this.cabeza = cabeza;
    }

    public NodoPerfil getUltimo() {
        
        return ultimo;
    }

    public void setUltimo(NodoPerfil ultimo) {
        
        this.ultimo = ultimo;
    }
    
    public boolean guardarPerfil(DatosPerfil perfil){
    	
    	NodoPerfil nuevoPerfil = new NodoPerfil(); 
    	nuevoPerfil.setPerfil(perfil);
    	
    	if (cabeza==null){
    		
    		nuevoPerfil.setLiga(null);
    		cabeza=nuevoPerfil;
    		ultimo=nuevoPerfil;
    		return true;
    	}else{
    		
    		nuevoPerfil.setLiga(ultimo.getLiga());
    		ultimo.setLiga(nuevoPerfil);
    		ultimo=nuevoPerfil;
    		return true;
    	}
    }
    
    public boolean modificarPerfil(DatosPerfil perfil){
    	
    	NodoPerfil auxi=cabeza;
    	
    	while (auxi !=null){
    		
    		if (auxi.getPerfil().getNumCedula().equals(perfil.getNumCedula())){
    			
    			auxi.setPerfil(perfil);
    			return true;
    		}
    		auxi=auxi.getLiga();
    	}
    	return false;
    }
    
    public boolean eliminarPerfil(String doc){
    	
    	NodoPerfil auxi= cabeza;
        NodoPerfil ant= null;
        while(auxi!=null){
        	
            if(auxi.getPerfil().getNumCedula().equals(doc)){
            	
                if(auxi==cabeza)
                {
                    cabeza=cabeza.getLiga();
                    return true;
                    
                }
                else
                {
                    if(auxi==ultimo)
                    {
                        ant.setLiga(auxi.getLiga());
                        ultimo=ant;
                        return true;
                    }
                    ant.setLiga(auxi.getLiga());
                    
                }
            }
            ant=auxi;
            auxi=auxi.getLiga();
        }
        return false;
    }
    
    public DatosPerfil BuscarPerfil(String doc){
    	
    	NodoPerfil auxi=cabeza;
    	DatosPerfil perfil=null;
    	while (auxi !=null){
    		
    		if (auxi.getPerfil().getNumCedula().equals(doc)){
    			
    			perfil = auxi.getPerfil();
    			return perfil;
    		}
    		auxi=auxi.getLiga();
    	}
    	return perfil;
    }
    
    public DatosPerfil BuscarPerfilNomUsuario(String usuario){
    	
    	NodoPerfil auxi=cabeza;
    	DatosPerfil perfil=null;
    	while (auxi !=null){
    		
    		if (auxi.getPerfil().getUsuario().equals(usuario)){
    			
    			perfil = auxi.getPerfil();
    			return perfil;
    		}
    		auxi=auxi.getLiga();
    	}
    	return perfil;
    }
    
    public DatosPerfil BuscarPerfilCorreo(String contra){
    	
    	NodoPerfil auxi=cabeza;
    	DatosPerfil perfil=null;
    	while (auxi !=null){
    		
    		if (auxi.getPerfil().getCorreoCorpora().equals(contra)){
    			
    			perfil = auxi.getPerfil();
    			return perfil;
    		}
    		auxi=auxi.getLiga();
    	}
    	return perfil;
    }
    
    public boolean existePerfil(String doc){
    	
    	NodoPerfil auxi=cabeza;
    	while (auxi !=null){
    		
    		if (auxi.getPerfil().getNumCedula().equals(doc)){
    			
    			return true;
    		}
    		auxi=auxi.getLiga();
    	}
    	return false;
    }
    
    /** Confirmar los datos del usuario para recuperar la contraseña en la lista de perfiles
     *
     *@param usuario nombre de usuario de ingreso al sistema
     *@param pregunta  pregunta secreta
     *@param respuesta respuesta a la pregunta secreta
     *@return retorna todos los datos del usuario consultado
     */
    public DatosPerfil confirmarDatosContra(String usuario, String pregunta,String respuesta){
    	
    	NodoPerfil auxi = cabeza;
    	DatosPerfil perfil=null;
    	while (auxi != null){
    		
    		if (auxi.getPerfil().getUsuario().equals(usuario) && auxi.getPerfil().getPregunta().equals(pregunta) && auxi.getPerfil().getRespuesta().equals(respuesta)){
    			
    			perfil = auxi.getPerfil();
    			return perfil;
    		}
    		auxi = auxi.getLiga();
    	}
    	return perfil;
    }
    
    /** Confirmar los datos del usuario al ingreso al sistema en la lista de perfiles
     *
     *@param usuario nombre de usuario de ingreso al sistema
     *@param contra  contraseña de ingreso al sistema
     *@return retorna todos los datos del usuario y la contraseña dada
     */
    public DatosPerfil confirmarUsuario(String usuario, String contra){
    	
    	NodoPerfil auxi = cabeza;
    	while (auxi != null){
    		
    		if (auxi.getPerfil().getUsuario().equals(usuario) && auxi.getPerfil().getContraIngreso().equals(contra)){
    			return auxi.getPerfil();
    		}else{
    			
    			auxi = auxi.getLiga();
    		}
    	}
    	return null;
    }
    
    public boolean fechaCambioContra(Date fecha){
    	
    	Date fechaActual = new Date();
    	if (((fechaActual.getTime() - fecha.getTime())/MILI_SEGU_DIA) >= 25){
    		
    		return true;
    	}else{
    		
    		return false;
    	}
    }
    
    /** Modificar la contraseña de ingreso en la lista de perfiles
     *
     *@param perfil contiene los datos del perfil ya modificado 
     *@return retorna todos los datos del perfil ya modificado y almacenado
     */
    public DatosPerfil modificarContraseñaIngrse(DatosPerfil perfil){
    	
    	NodoPerfil auxi = cabeza;
    	while ( auxi != null ){
    		
    		if (auxi.getPerfil().getUsuario().equals(perfil.getUsuario()) && auxi.getPerfil().getContraIngreso().equals(perfil.getContra()) 
    			&& auxi.getPerfil().getPregunta().equals(perfil.getPregunta()) && auxi.getPerfil().getRespuesta().equals(perfil.getRespuesta())){
    				
    				auxi.getPerfil().setContraIngreso(perfil.getContraIngreso());
    				auxi.getPerfil().setRepetirContraIngreso(perfil.getRepetirContraIngreso());
    				return auxi.getPerfil();
    		}else{
    			
    			auxi = auxi.getLiga();
    		}
    	}
    	return null;
    }
    
    
}
