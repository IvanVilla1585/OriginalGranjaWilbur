package logica;

import java.util.Date;


public class DatosPartos {
	
	private   String codParto,codMadre, raza,razaPadre, edad, numVivos,numMuertos, totalCamada;
	private   Date fechaPart;
	
	public String getCodParto (){
	
		return codParto;
	}

	public void setCodParto (String codParto){
		
		this.codParto=codParto;	
	}
	
	public Date getFechaPart (){

		return fechaPart;
	}
	
	public void setFechaPart (Date fechaPart){
		
		this.fechaPart=fechaPart;
		
	}
	
	public String getCodMadre (){
	
		return  codMadre;	
	}
	
	public void setCodMadre (String codMadre){
		
		this.codMadre=codMadre;
		
	}
	
	public  String getRaza(){
	
		return raza;	
	}
	
	public void setRaza (String raza){
		
		this.raza=raza;
		
	}
	
	public  String getRazaPadre(){
	
		return razaPadre;	
	}
	
	public void setRazaPadre (String razaPadre){
		
		this.razaPadre=razaPadre;
		
	}
	
	public String getEdad (){
	
		return  edad;	
	}
	
	public void setEdad (String edad){
		
		this.edad=edad;
		
	}
	
	public  String getNumVivos(){
	
		return numVivos;	
	}
	
	public void setNumVivos (String numVivos){
		
		this.numVivos=numVivos;
		
	}
	
	public String getNumMuertos (){
	
		return  numMuertos;	
	}
	
	public void setNumMuertos (String numMuertos){
		
		this.numMuertos=numMuertos;
		
	}
	
	public  String getTotalCamada(){
	
		return totalCamada;	
	}
	
	public void setTotalCamada (String totalCamada){
		
		this.totalCamada=totalCamada;
		
	}
}
