package listas;

import logica.DatosAnimal;
import nodos.NodoAnimal;
import logica.DatosPartos;
import nodos.NodoPartos;

public class ListaAnimales {
	
	private NodoAnimal primero;
	private NodoAnimal ultimo;
	int consecutivoCdigo;
	
	public ListaAnimales(){
		
		primero=null;
		ultimo=null;
		consecutivoCdigo=1;
	}
	
	public ListaAnimales(ListaAnimales listaParto){
		
		this.primero = listaParto.getPrimero();
		this.ultimo = listaParto.getUltimo();
	}
	
	public NodoAnimal getPrimero() {
       
        return primero;
    }

    public void setPrimero(NodoAnimal primero) {
       
        this.primero = primero;
    }

    public NodoAnimal getUltimo() {
       
        return ultimo;
    }

    public void setUltimo(NodoAnimal ultimo) {
        
        this.ultimo = ultimo;
    }
    
    public int getconsecutivoCdigo() {
       
        return consecutivoCdigo;
    }

    public void setconsecutivoCdigo(int consecutivoCdigo) {
        
        this.consecutivoCdigo = consecutivoCdigo;
    }
    
    public boolean guardarAnimal(DatosAnimal animal){
    	
    	NodoAnimal nuevoAnimal = new NodoAnimal();
    	nuevoAnimal.setAnimal(animal);
    	if (primero==null){
    		
    		nuevoAnimal.setLiga(null);
    		primero=nuevoAnimal;
    		ultimo=nuevoAnimal;
    		consecutivoCdigo += 1;
    		return true;
    	}else{
    		
    		nuevoAnimal.setLiga(ultimo.getLiga());
    		ultimo.setLiga(nuevoAnimal);
    		ultimo=nuevoAnimal;
    		consecutivoCdigo += 1;
    		return true;	
    	}
    }
    
    public boolean eliminarAnimal(String cod){
    	
    	NodoAnimal auxi = primero;
    	NodoAnimal ante = null;
    	while (auxi != null){
    		
    		if (auxi.getAnimal().getCodAnimal().equals(cod)){
    			
    			if (auxi==primero){
    				
    				primero = auxi.getLiga();
    				return true;
    			}else{
    				
    				if (auxi==ultimo){
    					
    					ante.setLiga(auxi.getLiga());
    					ultimo = ante;
    					return true;
    				}
    				ante.setLiga(auxi.getLiga());
    				return true;
    			}
    		}
    		ante = auxi;
    		auxi = auxi.getLiga();
    	}
    	return false;
    }
    
    public boolean guardarModificacion(DatosAnimal animalModi){
    	
    	NodoAnimal auxi = primero;
    	while (auxi !=null){
    		
    		if (auxi.getAnimal().getCodAnimal().equals(animalModi.getCodAnimal())){
    			
    			auxi.setAnimal(animalModi);
    			return true;
    		}
    		auxi=auxi.getLiga();
    	}
    	return false;
    }
    
    public boolean existeAnimal(String cod){
    	
    	NodoAnimal auxi = primero;
    	while (auxi !=null){
    		
    		if (auxi.getAnimal().getCodAnimal().equals(cod)){
    			
    			return true;
    		}
    		auxi = auxi.getLiga();
    	}
    	return false;
    }
    
    public DatosAnimal consultarAnimal(String cod){
    	
    	NodoAnimal auxi = primero;
    	DatosAnimal animal=null;
    	while(auxi !=null){
    		
    		if (auxi.getAnimal().getCodAnimal().equals(cod)){
    			
    			animal = auxi.getAnimal();
    			return animal;
    		}
    		auxi=auxi.getLiga();
    	}
    	return animal;
    }
    
    public DatosAnimal consultarAnimalCodParto(String cod){
    	
    	NodoAnimal auxi = primero;
    	DatosAnimal animal=null;
    	while(auxi !=null){
    		
    		if (auxi.getAnimal().getCodParto().equals(cod)){
    			
    			animal = auxi.getAnimal();
    			return animal;
    		}
    		auxi=auxi.getLiga();
    	}
    	return animal;
    }
    
    public DatosPartos cargarDatosParto(NodoPartos auxi,String cod){
    	
    	DatosPartos parto=null;
    	while (auxi!=null){
    		if (auxi.getParto().getCodParto().equals(cod)){
    			
    			parto=auxi.getParto();
    			return parto;
    		}
    		auxi=auxi.getLiga();
    	}
    	return parto;
    }
    
    public DatosAnimal verificarReproductora(String codigo){
    		
    	NodoAnimal auxiliar = primero;
    	while ( auxiliar !=null ){
    		
    		if ( auxiliar.getAnimal().getCodAnimal().equals(codigo) && auxiliar.getAnimal().getTipoAnimal().equals("Reemplazo")){
    			
    			return auxiliar.getAnimal();
    		}else{
    			
    			auxiliar = auxiliar.getLiga();
    		}    		
    	}
    	return  null;
    }  
}
