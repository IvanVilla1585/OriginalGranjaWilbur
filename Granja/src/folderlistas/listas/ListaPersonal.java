package listas;

import logica.DatosPersonal;
import nodos.NodoPersonal;

public class ListaPersonal {
	
	private NodoPersonal cabeza;
	private NodoPersonal ultimo;
	
	public ListaPersonal(){
		
		cabeza = null;
		ultimo = null;
	}
	
	public ListaPersonal(ListaPersonal listaPerso){
		
		this.cabeza = listaPerso.getCabeza();
		this.ultimo = listaPerso.getUltimo();
	}
	
	public NodoPersonal getCabeza() {
        
        return cabeza;
    }

    public void setCabeza(NodoPersonal cabeza) {
        
        this.cabeza = cabeza;
    }

    public NodoPersonal getUltimo() {
        
        return ultimo;
    }

    public void setUltimo(NodoPersonal ultimo) {
        
        this.ultimo = ultimo;
    }
    
    public boolean guardarPersonal(DatosPersonal perso){
    	
    	NodoPersonal nuevoPersonal = new NodoPersonal(); 
    	nuevoPersonal.setPersonal(perso);
    	if (cabeza==null){
    		
    		nuevoPersonal.setLiga(null);
    		cabeza=nuevoPersonal;
    		ultimo=nuevoPersonal;
    		return true;
    	}else{
    		
    		nuevoPersonal.setLiga(ultimo.getLiga());
    		ultimo.setLiga(nuevoPersonal);
    		ultimo=nuevoPersonal;
    		return true;
    	}
    }
    
    public boolean modificarPersonal(DatosPersonal perso){
    	
    	NodoPersonal auxi=cabeza;
    	while (auxi !=null){
    		
    		if (auxi.getPersonal().getNumeroDocumento().equals(perso.getNumeroDocumento())){
    			
    			auxi.setPersonal(perso);
    			return true;
    		}
    		auxi=auxi.getLiga();
    	}
    	return false;
    }
    
    public boolean eliminarPersonal(String doc){
    	
    	NodoPersonal auxi= cabeza;
        NodoPersonal ant= null;
        while(auxi!=null){
        	
            if(auxi.getPersonal().getNumeroDocumento().equals(doc)){
            	
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
    
    public DatosPersonal BuscarPersonal(String doc){
    	
    	NodoPersonal auxi=cabeza;
    	DatosPersonal perso=null;
    	while (auxi !=null){
    		
    		if (auxi.getPersonal().getNumeroDocumento().equals(doc)){
    			
    			perso = auxi.getPersonal();
    			return perso;
    		}
    		auxi=auxi.getLiga();
    	}
    	return perso;
    }
    
    public DatosPersonal BuscarPersonalCorreo(String correo){
    	
    	NodoPersonal auxi=cabeza;
    	DatosPersonal perso=null;
    	while (auxi !=null){
    		
    		if (auxi.getPersonal().getCorreo().equals(correo)){
    			
    			perso = auxi.getPersonal();
    			return perso;
    		}
    		auxi=auxi.getLiga();
    	}
    	return perso;
    }
    
    public DatosPersonal BuscarPersonalNombre(String nombre){
    	
    	NodoPersonal auxi=cabeza;
    	DatosPersonal perso=null;
    	while (auxi !=null){
    		
    		if (auxi.getPersonal().getNombre().equals(nombre)){
    			
    			perso = auxi.getPersonal();
    			return perso;
    		}
    		auxi=auxi.getLiga();
    	}
    	return perso;
    }
    
    public boolean existePersonal(String doc){
    	
    	NodoPersonal auxi=cabeza;
    	while (auxi !=null){
    		
    		if (auxi.getPersonal().getNumeroDocumento().equals(doc)){
    			
    			return true;
    		}
    		auxi=auxi.getLiga();
    	}
    	return false;
    }
    
    public String capturarNombre(String doc){
    	
    	NodoPersonal auxi = cabeza;
    	while (auxi != null){
    		
    		if (auxi.getPersonal().getNumeroDocumento().equals(doc)){
    			
    			return auxi.getPersonal().getNombre();
    		}
    	}
    	return "";
    }
}
