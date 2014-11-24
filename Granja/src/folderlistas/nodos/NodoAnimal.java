package nodos;

import logica.DatosAnimal;


public class NodoAnimal {
	
	private DatosAnimal animal;
	private NodoAnimal liga;
	
	public NodoAnimal(){
		
	}
	
	public DatosAnimal getAnimal(){
		
		return animal;
	}
	
	public void setAnimal(DatosAnimal animal){
		
		this.animal=animal;
	}
	
	public NodoAnimal getLiga(){
		
		return liga;
	}
	
	public void setLiga(NodoAnimal lig){
		
		this.liga=lig;
	}
}
