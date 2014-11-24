package listas;

import logica.*;
import nodos.*;

public class ListaPerfil {
	
	private NodoPerfil cabeza;
	private NodoPerfil ultimo;
	
	public ListaPerfil(){
		
		cabeza = null;
		ultimo = null;
	}
	
	public ListaPerfil(ListaPerfil listaPerf){
		
	/*	this.cabeza = listaPerf.getCabeza();
		this.ultimo = listaPerf.getUltimo();*/
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
    
    public DatosPerfil BuscarPerfilContraIngreso(String contra){
    	
    	NodoPerfil auxi=cabeza;
    	DatosPerfil perfil=null;
    	while (auxi !=null){
    		
    		if (auxi.getPerfil().getContraIngreso().equals(contra)){
    			
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
