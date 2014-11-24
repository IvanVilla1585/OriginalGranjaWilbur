package logica;

import java.util.Date;

public class DatosAnimal {
	
	private String codAnimal, raza, sexo, estado, edadSem, procedencia, pesoNacer, pesoDestete;
	private String codParto,codMadre, edadMadre, razaMadre, razaPadre, tipoAnimal;
	private Date fechaNaci, fechaDestete,fechaConsuAli,fechaParto;
	
	public String getCodAnimal(){
		
		return codAnimal;
	}
	
	public void setCodAnimal(String codAnimal){
		
		this.codAnimal=codAnimal;
	}
	
	public String getRaza(){
		
		return raza;
	}
	
	public void setRaza(String raza){
		
		this.raza=raza;
	}
	
	public String getSexo(){
		
		return sexo;
	}
	
	public void setSexo(String sexo){
		
		this.sexo=sexo;
	}
	
	public String getEstado(){
		
		return estado;
	}
	
	public void setEstado(String estado){
		
		this.estado=estado;
	}
	
	public  Date getFechaNaci(){
	
		return fechaNaci;	
	}
	
	public void setFechaNaci (Date fechaNaci){
		
		this.fechaNaci=fechaNaci;
		
	}
	
	public String getEdadSem (){
	
		return  edadSem;	
	}
	
	public void setEdadSem (String edadSem){
		
		this.edadSem=edadSem;
		
	}
	
	public  String getProcedencia(){
	
		return procedencia;	
	}
	
	public void setProcedencia (String procedencia){
		
		this.procedencia=procedencia;
		
	}
	
	public String getPesoNacer (){
	
		return  pesoNacer;	
	}
	
	public void setPesoNacer (String pesoNacer){
		
		this.pesoNacer=pesoNacer;
		
	}
	
	public  String getPesoDestete(){
	
		return pesoDestete;	
	}
	
	public void setPesoDestete (String pesoDestete){
		
		this.pesoDestete=pesoDestete;
		
	}
	
	public Date getFechaDestete (){
	
		return fechaDestete;
	}

	public void setFechaDestete(Date fechaDestete){
		
		this.fechaDestete=fechaDestete;	
	}
	
	public Date getFechaConsuAli(){

		return fechaConsuAli;
	}
	
	public void setFechaConsuAli (Date fechaConsuAli){
		
		this.fechaConsuAli=fechaConsuAli;
		
	}
	
	public String getCodParto(){
	
		return  codParto;	
	}
	
	public void setCodParto (String codParto){
		
		this.codParto=codParto;
		
	}
	
	public  Date getFechaParto(){
	
		return fechaParto;	
	}
	
	public void setFechaParto(Date fechaParto){
		
		this.fechaParto=fechaParto;
		
	}
	
	public String getCodMadre(){
	
		return  codMadre;	
	}
	
	public void setCodMadre (String codMadre){
		
		this.codMadre=codMadre;
		
	}
	
	public String getEdadMadre(){

		return edadMadre;
	}
	
	public void setEdadMadre (String edadMadre){
		
		this.edadMadre=edadMadre;
		
	}
	
	public String getRazaMadre(){
	
		return  razaMadre;	
	}
	
	public void setRazaMadre (String razaMadre){
		
		this.razaMadre=razaMadre;
		
	}
	
	public  String getRazaPadre(){
	
		return razaPadre;	
	}
	
	public void setRazaPadre(String razaPadre){
		
		this.razaPadre=razaPadre;
		
	}
	
	public String getTipoAnimal(){
	
		return  tipoAnimal;	
	}
	
	public void setTipoAnimal (String tipoAnimal){
		
		this.tipoAnimal=tipoAnimal;
		
	}
}
