package Utilidades;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import java.awt.*;
 
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
 
import java.util.Properties;
 
//Para manejo de JavaMail
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
public class EnviarEmail{
	
	ImageIcon icoMensajeInfor = new ImageIcon("Imagenes\\IconoInformacion.jpg");	 
    public EnviarEmail(String correo,String nombre, String usuario,String clave, String tipoMensa, String mensaje ){
  
    	if(enviarEmail(correo,nombre, usuario,clave, tipoMensa))
    	{
			JOptionPane.showMessageDialog(null,mensaje,tipoMensa, JOptionPane.OK_OPTION,icoMensajeInfor);  	
    	}else{
    		
    		JOptionPane.showMessageDialog(null,"Error al  Enviar el Mensaje" ,"Informaci\u00f3n de Envio",
										  JOptionPane.OK_OPTION,icoMensajeInfor);  
    	}
    }
    private boolean enviarEmail(String correo,String nombre, String usuario,String clave, String tipoMensa) 
    {
    	
    try
    {
        // Propiedades de la conexión
        Properties props = new Properties();
        props.setProperty("mail.smtp.host",  "smtp.gmail.com");
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.port", "587");
        props.setProperty("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
 
        // Preparamos la sesion
        Session session = Session.getDefaultInstance(props);
                 
	    
	   	String str_De = "granjawilbursgp@gmail.com";
	    String str_PwRemitente = "ivan456123";               
	    String str_Para    = correo;
	    String str_Asunto = tipoMensa;
	    String str_Mensaje ="Sistematización Granjas Porcícolas - S.G.P. Granja Wilbur.\n\n"+
	    					"Los datos de acceso a su cuenta son:\n"+
	    					"\nNombre: "+ nombre +"\n"+"Correo: "+correo+ "\n"+ "Usuario: " +usuario+"\n"+ "Contraseña: "+ clave+
	    					"\n\nAtentamente,"+"\n\nGranja Porcícola Wilbur - S.G.P.";
	    
	    //Obtenemos los destinatarios
	    String destinos[] = str_Para.split(",");
                 
        // Construimos el mensaje
        MimeMessage message = new MimeMessage(session);
         
        message.setFrom(new InternetAddress( str_De ));

        Address [] receptores = new Address [ destinos.length ];
        int j = 0;
        
    	while(j<destinos.length)
    	{                    
        	receptores[j] = new InternetAddress ( destinos[j] ) ;                   
        	j++;                
   		}  
        //receptores.
        message.addRecipients(Message.RecipientType.TO, receptores);        
        message.setSubject( str_Asunto );        
        message.setText( str_Mensaje );
             
        // Lo enviamos.
        Transport t = session.getTransport("smtp");
        t.connect(str_De, str_PwRemitente);
        t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
                 
        // Cierre de la conexion.
        t.close();
        return true;
    }catch (Exception e)
    	{
       	 e.printStackTrace();
       	 return false;
    	}       
    }   
}