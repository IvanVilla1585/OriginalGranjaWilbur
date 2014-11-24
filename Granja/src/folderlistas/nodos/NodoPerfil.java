package nodos;

import logica.DatosPerfil;

public class NodoPerfil {
	
	private DatosPerfil perfil;
	private NodoPerfil liga;
	
	public NodoPerfil(){
		
	}
	
	public DatosPerfil getPerfil(){
		
		return perfil;
	}
	
	public void setPerfil(DatosPerfil perfil){
		
		this.perfil=perfil;
	}
	
	public NodoPerfil getLiga(){
		
		return liga;
	}
	
	public void setLiga(NodoPerfil lig){
		
		this.liga=lig;
	}
}
