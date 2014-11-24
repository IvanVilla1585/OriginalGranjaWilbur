package Utilidades;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern; 
import java.util.Date;
import java.text.*;
import com.toedter.calendar.JDateChooser;
import java.io.*;

public class Validaciones {
	
	ImageIcon icoMensajeInfor = new ImageIcon("Imagenes\\IconoInformacion.jpg");
	
	public void validarLongitud(int l, JTextField j, java.awt.event.KeyEvent e) {

        if (j.getText().length() == l) {
            e.consume();
        }

    }
    
    public void validarLongitudP(int l, JPasswordField j, java.awt.event.KeyEvent e) {

        if (j.getText().length() == l) {
            e.consume();
        }

    }

    public void SoloNumeros(JTextField j, java.awt.event.KeyEvent e) {
    
        char c = e.getKeyChar();
    	if (Character.isLetter(c)) {
       		j.getToolkit().beep();
			e.consume(); 
		}
        	   
   }
   
   public void convertirMayusculas(int l, JTextField j, java.awt.event.KeyEvent e) {
     	int i;
        char caracter;
        String cadena;
        for (i = 0; i < (l-1); i++){ 
        	cadena = j.getText().toUpperCase();
		   	j.setText(cadena);  
        }
    	
        	   
   }
     
    
   public void SoloNumerosPa(JPasswordField j, java.awt.event.KeyEvent e) {
        char caracter = e.getKeyChar();//lee el caracter presionado
        int numero = (int) (caracter); 
        if (((caracter < '0') || (caracter > '9')) && (caracter == KeyEvent.VK_TAB)	/* && (numero != 32)*/) {
        	e.consume();  // ignorar el evento de teclado
        }		   
   }

    public void SoloLetras(JTextField j, java.awt.event.KeyEvent e) {
       
        char c = e.getKeyChar();
    	if (Character.isDigit(c)) {
       		j.getToolkit().beep();
			e.consume(); 
		}
    }
    
    
    public void Obligatorios(JTextField j, java.awt.event.KeyEvent e){
    	
    	char caracter = e.getKeyChar();
    	int num = (int) (caracter);
    	if (num==KeyEvent.VK_ENTER){
    		if (j.getText().equals("")){
    			JOptionPane.showMessageDialog(null,"Este campo es obligatorio","Gestionar Perfil - S.G.P",
											  JOptionPane.OK_OPTION,icoMensajeInfor);  
    			j.requestFocus();
    		}
    	}
    }
    
    public void ObligatoriosP(JPasswordField j, java.awt.event.KeyEvent e){
    	
    	char caracter = e.getKeyChar();
    	int num = (int) (caracter);
    	if (num==KeyEvent.VK_ENTER){
    		if (j.getText().equals("")){
    			JOptionPane.showMessageDialog(null,"Este campo es obligatorio","Gestionar Perfil - S.G.P",
											  JOptionPane.OK_OPTION,icoMensajeInfor); 
    			j.requestFocus();
    		}
    	}
    }
    
    public static boolean validarEmail (String email) {
	
	    // Establecer el patron
	    Pattern p = Pattern.compile("[-\\w\\.]+@\\w+\\.\\w+");
	
	    // Asociar el string al patron
	    Matcher m = p.matcher(email);
	
	   // Comprobar si encaja
	   return m.matches();
	
	}
	
	public long  calcularDias(JDateChooser fecha){
		
		final long  MILI_SEGU_SEMANA = 24 * 60 * 60 * 1000 * 7;
		DateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
		Date fechaActual;
		Date fechaNaci=null;
		long  diferencia=0;
		String fe = formato.format(fecha.getDate()); 
		
		try {

    		fechaNaci = formato.parse(fe);

		} catch (ParseException ex) {

   			ex.printStackTrace();

		} 
		fechaActual = new Date();
		
		diferencia=(fechaActual.getTime()-fechaNaci.getTime())/MILI_SEGU_SEMANA;
		
		return diferencia;
	}
	
	public boolean validaFecha(JDateChooser fecha){ 
		
		if (fecha.getDate().after(new Date())){	
			return true;
		}	
		return  false;	
	}
	
	public boolean validarContraseñ(String contra, int control[]){
		
		int sum=0,j,i;
		int numero , tama = contra.length(); 
		for (j = 0; j < (tama-1); j++){ 
			numero = (int) (contra.charAt(j));
			if ((numero > 32 && numero < 40) || (numero > 41 && numero < 48) || (numero > 57 && numero < 65)){
        	
	       		control[0] = 1;
	        }else{
	        	if ((numero > 47 && numero <58)){
	        		
	        		control[1] = 2;	
	        	}else{
	        		
	        		 if ((numero > 64 && numero < 91)){
	        		 	
	        		 	control[2] = 3;
	        		 }else{
	        		 	if ((numero > 96 && numero < 123)){
	        		 		
	        		 		control[3] = 4;
	        		 	}	
	        		 }  
	        	}
	        }
		}
		for (i = 0; i < 4; i++){
			
			sum = sum + control[i];
		}
		if (sum == 10 && tama > 7){
			
			return true;
		}else{ 
			
			return false;
		}  
	}
    
}
