package logica;

import java.util.Date;
import java.awt.*;
import java.io.*;

public class DatosPersonal {
	
	private String tipoDoc,numeroDocumento,nombre,departamento,municipio,tipoSangre,rh,estado,direccion;
	private String telefono,correo,telMovil,profesion,otrosEstu,obtenido,cargo,tipoContra;
	private Date fechaNacimiento,fechaTitulo,fechaFin,fechaContra;
	private File rutaImagen;
	
	public String getTipoDoc (){
	
		return tipoDoc;
	}

	public void setTipoDoc (String tipoDoc){
		
		this.tipoDoc=tipoDoc;	
	}
	
	public String getNumeroDocumento (){

		return numeroDocumento;
	}
	
	public void setNumeroDocumento (String numeroDocumento){
		
		this.numeroDocumento=numeroDocumento;
		
	}
	
	public String getNombre (){
	
		return  nombre;	
	}
	
	public void setNombre (String nombre){
		
		this.nombre=nombre;
		
	} 
		
	public  Date getFechaNacimiento(){
	
		return fechaNacimiento;	
	}
	
	public void setFechaNacimiento (Date fechaNacimiento){
		
		this.fechaNacimiento=fechaNacimiento;
		
	}
	
	public String getDepartamento (){
	
		return  departamento;	
	}
	
	public void setDepartamento (String departamento){
		
		this.departamento=departamento;
		
	}
	
	public  String getMunicipio(){
	
		return municipio;	
	}
	
	public void setMunicipio (String municipio){
		
		this.municipio=municipio;
		
	}
	
	public String getTipoSangre (){
	
		return  tipoSangre;	
	}
	
	public void setTipoSangre (String tipoSangre){
		
		this.tipoSangre=tipoSangre;
		
	}
	
	public  String getRh(){
	
		return rh;	
	}
	
	public void setRh (String rh){
		
		this.rh=rh;
		
	}
	
	public String getEstado (){
	
		return estado;
	}

	public void setEstado (String estado){
		
		this.estado=estado;	
	}
	
	public File getRutaImagen(){

		return rutaImagen;
	}
	
	public void setRutaImagen (File rutaImagen){
		
		this.rutaImagen=rutaImagen;
		
	}
	
	public String getDireccion(){
	
		return  direccion;	
	}
	
	public void setDireccion (String direccion){
		
		this.direccion=direccion;
		
	}
	
	public  String getTelefono(){
	
		return telefono;	
	}
	
	public void setTelefono (String telefono){
		
		this.telefono=telefono;
		
	}
	
	public String getCorreo (){
	
		return  correo;	
	}
	
	public void setCorreo (String correo){
		
		this.correo=correo;
		
	}
	
	public  String getTelMovil(){
	
		return telMovil;	
	}
	
	public void setTelMovil (String telMovil){
		
		this.telMovil=telMovil;
		
	}
	
	public String getProfesion (){
	
		return  profesion;	
	}
	
	public void setProfesion (String profesion){
		
		this.profesion=profesion;
		
	}
	
	public  Date getFechaTitulo(){
	
		return fechaTitulo;	
	}
	
	public void setFechaTitulo (Date fechaTitulo){
		
		this.fechaTitulo=fechaTitulo;
		
	}
	
	public String getOtrosEstu (){
	
		return  otrosEstu;	
	}
	
	public void setOtrosEstu (String otrosEstu){
		
		this.otrosEstu=otrosEstu;
		
	}
	
	public  String getObtenido(){
	
		return obtenido;	
	}
	
	public void setObtenido (String obtenido){
		
		this.obtenido=obtenido;
		
	}
	
	public  Date getFechaFin(){
	
		return fechaFin;	
	}
	
	public void setFechaFin (Date fechaFin){
		
		this.fechaFin=fechaFin;
		
	}
	
	public String getCargo (){
	
		return  cargo;	
	}
	
	public void setCargo (String cargo){
		
		this.cargo=cargo;
		
	}
	
	public  Date getFechaContra(){
	
		return fechaContra;	
	}
	
	public void setFechaContra (Date fechaContra){
		
		this.fechaContra=fechaContra;
		
	}
	
	public  String getTipoContra(){
	
		return tipoContra;	
	}
	
	public void setTipoContra (String tipoContra){
		
		this.tipoContra=tipoContra;
		
	}
}
