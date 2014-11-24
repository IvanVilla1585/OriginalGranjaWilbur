package logica;


public class DatosPerfil {
	
	private String numCedula, codPerfil, perfil, correoCorpora, contra, repetirContra, pregunta, respuesta;
	private String usuario, contraIngreso, RepetirContraIngreso;
	
	public String getNumCedula (){
	
		return numCedula;
	}
	
	public void setNumCedula (String numCedula){
		
		this.numCedula=numCedula;	
	}
	
	public String getCodPerfil (){
	
		return  codPerfil;	
	}
	
	public void setCodPerfil (String codPerfil){
		
		this.codPerfil=codPerfil;
		
	}
	
	public  String getPerfil(){
	
		return perfil;	
	}
	
	public void setPerfil (String perfil){
		
		this.perfil=perfil;
		
	}

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraIngreso() {
        return contraIngreso;
    }

    public void setContraIngreso(String contraIngreso) {
        this.contraIngreso = contraIngreso;
    }

    public String getRepetirContraIngreso() {
        return RepetirContraIngreso;
    }

    public void setRepetirContraIngreso(String RepetirContraIngreso) {
        this.RepetirContraIngreso = RepetirContraIngreso;
    }
	
	public  String getCorreoCorpora(){
	
		return correoCorpora;	
	}
	
	public void setCorreoCorpora (String correoCorpora){
		
		this.correoCorpora=correoCorpora;
		
	}
	
	public String getContra (){
	
		return  contra;	
	}
	
	public void setContra(String contra){
		
		this.contra=contra;
		
	}
	
	public  String getRepetirContra(){
	
		return repetirContra;	
	}
	
	public void setRepetirContra (String repetirContra){
		
		this.repetirContra=repetirContra;
		
	}
	
	public String getPregunta (){
	
		return  pregunta;	
	}
	
	public void setPregunta (String pregunta){
		
		this.pregunta=pregunta;
		
	}
	
	public  String getRespuesta(){
	
		return respuesta;	
	}
	
	public void setRespuesta (String respuesta){
		
		this.respuesta=respuesta;
		
	}
}
