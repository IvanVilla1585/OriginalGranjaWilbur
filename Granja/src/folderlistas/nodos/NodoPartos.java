package nodos;

import logica.DatosPartos;

public class NodoPartos {
	
	private DatosPartos parto;
	private NodoPartos liga;
	
	public NodoPartos(){
		
	}
	
	public DatosPartos getParto(){
		
		return parto;
	}
	
	public void setParto(DatosPartos parto){
		
		this.parto=parto;
	}
	
	public NodoPartos getLiga(){
		
		return liga;
	}
	
	public void setLiga(NodoPartos lig){
		
		this.liga=lig;
	}
}
