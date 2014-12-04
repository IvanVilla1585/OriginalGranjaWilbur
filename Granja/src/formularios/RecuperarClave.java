import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*; 
import listas.*;
import nodos.*;
import logica.*;
import Utilidades.*;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import java.awt.*;
import Utilidades.Validaciones; 
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent; 
 

public class RecuperarClave extends JFrame implements ActionListener, KeyListener{

	JLabel labNomUsuario, labCorreoElec, labPregunta, labRespuesta, labelFondo;
	JTextField textNomUsuario, textCorreoElec, textRespuesta;
	JComboBox comboPregunta;
	JButton botonAceptar, botonSalir, botonLimpiar;
	Image icoCabecera;
	ImageIcon  iconFondo, icoAceptar, icoSalir,icoMensajePre, icoMensajeInfor, icoLimpiar;
	String correo,nombre, usuario,clave;
	String mensaje = "Se envio un correo a la dirección registrada," + "\n" + "con el nombre de usuario y la contraseña de ingreso";
	String tipoMensaje = "Recuperar Contraseña - S.G.P.";
	int sw = 0;
	ListaPerfil listaPer;
	ListaPersonal listaPerso;
	DatosPerfil perfilcon;
	Validaciones v = new Validaciones();
	EnviarEmail mail;
	
    public RecuperarClave(ListaPerfil listaPer,ListaPersonal listaPerso)  {
    	
    	super("Recordar Contraseña ");
        getContentPane().setLayout(null);
        setSize(450, 280);
        setResizable(false);
        setLocation(450, 250);
        setVisible(true);
        
        icoCabecera=Toolkit.getDefaultToolkit().getImage("Imagenes\\RecuperarContra.jpg");
        setIconImage(icoCabecera);
        this.getContentPane().setBackground(Color.white);
        
        labNomUsuario = new JLabel("Nombre de Usuario:");
        labNomUsuario.setBounds(10, 25, 200, 25);
        this.getContentPane().add(labNomUsuario);
        labNomUsuario.setVisible(true);
        
        textNomUsuario = new JTextField("");
        textNomUsuario.setBounds(125, 25, 200, 25);
        this.getContentPane().add(textNomUsuario);
        textNomUsuario.setVisible(true);
        textNomUsuario.addKeyListener(this);
        textNomUsuario.addActionListener(this);
    	
    	labCorreoElec = new JLabel("Correo Electrónico:");
        labCorreoElec.setBounds(10, 65, 200, 25);
        this.getContentPane().add(labCorreoElec);
        labCorreoElec.setVisible(true);
        
        textCorreoElec = new JTextField("");
        textCorreoElec.setBounds(125, 65, 200, 25);
        this.getContentPane().add(textCorreoElec);
        textCorreoElec.setVisible(true);
        textCorreoElec.addKeyListener(this);
        textCorreoElec.addActionListener(this);
        
        iconFondo = new ImageIcon("Imagenes\\CERDO4.jpg");
        labelFondo = new JLabel(iconFondo);
        labelFondo.setBounds(295, 0, 180, 115);
        this.getContentPane().add(labelFondo);
        setVisible(true);
        
        labPregunta = new JLabel("Pregunta Secreta:");
        labPregunta.setBounds(10, 105, 200, 25);
        this.getContentPane().add(labPregunta);
        labPregunta.setVisible(true);
        
        comboPregunta = new JComboBox();
        comboPregunta.addItem("MASCOTA PREFERIDA");
        comboPregunta.setBounds(125,105, 300, 25);
        this.getContentPane().add(comboPregunta);
        comboPregunta.setVisible(true);
        comboPregunta.addKeyListener(this);
        comboPregunta.addActionListener(this);
        
        labRespuesta = new JLabel("Respuesta:");
        labRespuesta.setBounds(10, 145, 200, 25);
        this.getContentPane().add(labRespuesta);
        labRespuesta.setVisible(true);
        
        textRespuesta = new JTextField("");
        textRespuesta.setBounds(125, 145, 300, 25);
        this.getContentPane().add(textRespuesta);
        textRespuesta.setVisible(true);
        textRespuesta.addKeyListener(this);
        textRespuesta.addActionListener(this);
        
        icoAceptar = new ImageIcon("Imagenes\\Aceptar.jpg");
        botonAceptar = new JButton(icoAceptar);
        botonAceptar.setBounds(50, 190, 70, 40);
        this.getContentPane().add(botonAceptar);
        botonAceptar.setVisible(true);
        botonAceptar.setToolTipText("Aceptar");
        botonAceptar.addActionListener(this);
        botonAceptar.setEnabled(false);
        
        icoSalir = new ImageIcon("Imagenes\\Salir.jpg");
        botonSalir = new JButton(icoSalir);
        botonSalir.setBounds(290, 190, 70, 40);
        this.getContentPane().add(botonSalir);
        botonSalir.setVisible(true);
        botonSalir.setToolTipText("Salir");
        botonSalir.addActionListener(this);
        
        icoLimpiar = new ImageIcon("Imagenes\\Limpiar.jpg");
        botonLimpiar = new JButton(icoLimpiar);
        botonLimpiar.setBounds(170, 190, 70, 40);
        this.getContentPane().add(botonLimpiar);
        botonLimpiar.setVisible(true);
        botonLimpiar.setToolTipText("Limpiar Campos");
        botonLimpiar.addActionListener(this);
    	
    	icoMensajeInfor = new ImageIcon("Imagenes\\IconoInformacion.jpg");
    	icoMensajePre = new ImageIcon("Imagenes\\IconoPregunta.jpg");
    	this.listaPer = listaPer;
    	this.listaPerso = listaPerso;
    	this.limpiarCampos();
    	this.ValidarCampos();
    	repaint();
    	
    }
     
   	public void actionPerformed(ActionEvent event) {
   		
   			
		if(event.getSource() == botonAceptar){
			
			String pregu = (String)comboPregunta.getSelectedItem();
			perfilcon = listaPer.confirmarDatosContra(textNomUsuario.getText(),pregu , textRespuesta.getText());
			this.llenarDatosCorreo(perfilcon);
			if (sw == 1){
				
				mail = new EnviarEmail(correo, nombre, usuario, clave, tipoMensaje, mensaje);	
				sw = 0;
			}
		}
		
		
		if (event.getSource() == botonSalir){
			int opc ;
		    opc = JOptionPane.showConfirmDialog(null,"¿Está seguro que desea salir de recuperar contraseña?",
		    								  "Salir.  Sistematización Grajas Porcícolas - S.G.P.",JOptionPane.YES_NO_OPTION,
		    								  JOptionPane.QUESTION_MESSAGE,icoMensajePre);
		    if (opc == 0) {
		        this.dispose();
		
		    }
		} 
			
		if (event.getSource() == botonLimpiar){
			
			this.limpiarCampos();
		}		
   	}
   	
   	public void keyPressed(KeyEvent e){
   		
   		if((e.getKeyCode() == KeyEvent.VK_ENTER)){
     						
			Component c = (Component) e.getSource(); 
			c.transferFocus();
		} 
   		
   		if (e.getSource() == textRespuesta && e.getKeyCode() == KeyEvent.VK_ENTER){
   			
   			String pregunta = (String)comboPregunta.getSelectedItem();
   			if (textNomUsuario.getText().equals("") || textCorreoElec.getText().equals("") || textRespuesta.getText().equals("")  /*pregunta.equals("")*/){
   				
   				JOptionPane.showMessageDialog(null,"Digite todos los campos obligatorios","Recuperar Contraseña - S.G.P.",JOptionPane.OK_OPTION,icoMensajeInfor);
   				textRespuesta.requestFocus();
   			}else{
   				
   				this.desactivaCampos();
   				botonAceptar.setEnabled(true);
   			}
   		}
   		
   		if (e.getSource() == textCorreoElec && e.getKeyCode() == KeyEvent.VK_ENTER){
   			
   			if (!v.validarEmail(textCorreoElec.getText())){
   				
   				JOptionPane.showMessageDialog(null,"No corresponde a un correo electrónico","Recuperar Contraseña - S.G.P.",JOptionPane.OK_OPTION,icoMensajeInfor);
   				textCorreoElec.requestFocus();
   			}
   		}
   		
   	}
   	
   	public void keyReleased(KeyEvent e) {

    } 
    	 	
  	public void keyTyped(KeyEvent e) {
	}
   	
   	public void llenarDatosCorreo(DatosPerfil perfi){
   		
   		if (perfi != null){
   			
   			this.correo	= perfi.getCorreoCorpora();
   			this.nombre = listaPerso.capturarNombre(perfi.getNumCedula());
   			this.usuario = perfi.getUsuario();
   			this.clave = perfi.getContraIngreso();
   			sw = 1;
   		}else{
   			
   			JOptionPane.showMessageDialog(null,"Datos incorrectos","Recuperar Contraseña - S.G.P.",JOptionPane.OK_OPTION,icoMensajeInfor);
   			textNomUsuario.requestFocus();
   		}
   	}
   	
   	public void desactivaCampos(){
   		
   		textNomUsuario.setEnabled(false);
   		textCorreoElec.setEnabled(false);
   		comboPregunta.setEnabled(false);
   		textRespuesta.setEnabled(false);
   	}
   	
   	public void activarCampos(){
   		
   		textNomUsuario.setEnabled(true);
   		textCorreoElec.setEnabled(true);
   		comboPregunta.setEnabled(true);
   		textRespuesta.setEnabled(true);
   	}
   	
   	public void limpiarCampos(){
   		
   		textNomUsuario.setText("");
   		textCorreoElec.setText("");
   		comboPregunta.setSelectedItem(null);
   		textRespuesta.setText("");
   	}
   	
   	public void ValidarCampos() {
        textNomUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent e) {
                v.validarLongitud(30, textNomUsuario, e);
                v.SoloLetras(textNomUsuario, e);
                v.Obligatorios(textNomUsuario,e);
                //v.convertirMayusculas(30,textNomUsuario,e);
            }
        });

      	this.textCorreoElec.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent e) {
            v.validarLongitud(40, textCorreoElec, e); 
            v.Obligatorios(textCorreoElec, e);
            }
        }); 
        	
        this.textRespuesta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent e) {
            v.validarLongitud(30, textRespuesta, e); 
            v.Obligatorios(textRespuesta, e);
            v.SoloLetras(textRespuesta, e);
            }
        }); 	
    }
    
}