package nodos;

import logica.DatosPersonal;

public class NodoPersonal {
	
	private DatosPersonal personal;
	private NodoPersonal liga;
	
	public NodoPersonal(){
		
		
	}
	
	public DatosPersonal getPersonal(){
		
		return personal;
	}
	
	public void setPersonal(DatosPersonal perso){
		
		this.personal=perso;
	}
	
	public NodoPersonal getLiga(){
		
		return liga;
	}
	
	public void setLiga(NodoPersonal lig){
		
		this.liga=lig;
	}
}
