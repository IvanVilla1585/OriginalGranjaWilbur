package listas;

import logica.DatosPartos;
import nodos.NodoPartos;

public class ListaPartos {
	
	private NodoPartos primero;
	private NodoPartos ultimo;
	private int consecutivoCdigo;
	
	public ListaPartos(){
		
		primero=null;
		ultimo=null;
		consecutivoCdigo = 1;
	}
	
/*	public ListaPartos(ListaPartos listaParto){
		
		this.primero = listaParto.getPrimero();
		this.ultimo = listaParto.getUltimo();
	}*/
	
	public NodoPartos getPrimero() {
       
        return primero;
    }

    public void setPrimero(NodoPartos primero) {
       
        this.primero = primero;
    }

    public NodoPartos getUltimo() {
       
        return ultimo;
    }

    public void setUltimo(NodoPartos ultimo) {
        
        this.ultimo = ultimo;
    }
    
    public int getconsecutivoCdigo() {
       
        return consecutivoCdigo;
    }

    public void setconsecutivoCdigo(int consecutivoCdigo) {
        
        this.consecutivoCdigo = consecutivoCdigo;
    }
    
    public boolean guardarParto(DatosPartos parto){
    	
    	NodoPartos nuevoParto = new NodoPartos(); 
    	nuevoParto.setParto(parto);
    	if (primero==null){
    		
    		nuevoParto.setLiga(null);
    		primero=nuevoParto;
    		ultimo=nuevoParto;
    		consecutivoCdigo += 1;
    		return true;
    	}else{
    		
    		nuevoParto.setLiga(ultimo.getLiga());
    		ultimo.setLiga(nuevoParto);
    		ultimo=nuevoParto;
    		consecutivoCdigo += 1;
    		return true;
    	}
    }
    
    public boolean modificarParto(DatosPartos parto){
    	
    	NodoPartos auxi=primero;
    	while (auxi !=null){
    		
    		if (auxi.getParto().getCodParto().equals(parto.getCodParto())){
    			
    			auxi.setParto(parto);
    			return true;
    		}
    		auxi=auxi.getLiga();
    	}
    	return false;
    }
    
    public boolean eliminarParto(String cod){
    	
    	NodoPartos auxi= primero;
        NodoPartos ant= null;
        while(auxi!=null){
        	
            if(auxi.getParto().getCodParto().equals(cod)){
            	
                if(auxi==primero)
                {
                    primero=primero.getLiga();
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
    
    public DatosPartos BuscarParto(String cod){
    	
    	NodoPartos auxi=primero;
    	DatosPartos parto=null;
    	while (auxi !=null){
    		
    		if (auxi.getParto().getCodParto().equals(cod)){
    			
    			parto = auxi.getParto();
    			return parto;
    		}
    		auxi=auxi.getLiga();
    	}
    	return parto;
    }
    
    public DatosPartos BuscarPartoCodMadre(String cod){
    	
    	NodoPartos auxi=primero;
    	DatosPartos parto=null;
    	while (auxi !=null){
    		
    		if (auxi.getParto().getCodMadre().equals(cod)){
    			
    			parto = auxi.getParto();
    			return parto;
    		}
    		auxi=auxi.getLiga();
    	}
    	return parto;
    }
    
    public DatosPartos BuscarPartoEdadMadre(String edad){
    	
    	NodoPartos auxi=primero;
    	DatosPartos parto=null;
    	while (auxi !=null){
    		
    		if (auxi.getParto().getEdad().equals(edad)){
    			
    			parto = auxi.getParto();
    			return parto;
    		}
    		auxi=auxi.getLiga();
    	}
    	return parto;
    }
    
    public boolean existeParto(String cod){
    	
    	NodoPartos auxi=primero;
    	while (auxi !=null){
    		
    		if (auxi.getParto().getCodParto().equals(cod)){
    			
    			return true;
    		}
    		auxi=auxi.getLiga();
    	}
    	return false;
    }
}
