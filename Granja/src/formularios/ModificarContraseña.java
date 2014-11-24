import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.JLabel;
import javax.swing.JButton;
import listas.ListaPerfil;
import listas.ListaPersonal;
import logica.DatosPerfil;
import Utilidades.EnviarEmail;
import Utilidades.Validaciones;

public class ModificarContraseña extends JFrame implements ActionListener, KeyListener {
	
	JLabel labNomUsuario, labContra, labPregunta, labRespuesta, labNuevaContra, labConfirNueva, labelFondo;
	JTextField textNomUsuario, textRespuesta;
	JPasswordField pasContra, pasNuevaContra, pasConfirNueva;
	JComboBox comboPregunta;
	JButton botonAceptar, botonSalir,botonModificar,botonGuardar, botonLimpiar;
	Image icoCabecera;
	ImageIcon icoSalir, icoModificar, icoGuardar, icoMensajeInfor, icoMensajePre, icoLimpiar,iconFondoR;
	DatosPerfil perfilModifiContra, datosPerfilEmail;
	ListaPerfil listaPerfi;
	ListaPersonal listaPerso;
	String nombre,correo,usuario,contraseña;
	String mensaje = "Se envio un correo a la dirección registrada," + "\n" + "con los datos de la nueva contraseña de ingreso";
	String tipoMensaje = "Modificar Contraseña - S.G.P.";
	EnviarEmail mail;
	Validaciones v = new Validaciones();
	int [] cont;

    public ModificarContraseña( ListaPerfil listaPerfil, ListaPersonal listaPersonal ) {
    	
    	super("Modificar Contraseña ");
        getContentPane().setLayout(null);
        setSize(605, 250);
        setResizable(true);
        this.setResizable(false);
        setLocation(405, 200);
        setVisible(true);
        
        icoCabecera=Toolkit.getDefaultToolkit().getImage("Imagenes\\IconoModificar.jpg");
        setIconImage(icoCabecera);
        this.getContentPane().setBackground(Color.white); 
        
        labNomUsuario = new JLabel("Nombre de Usuario:");
        labNomUsuario.setBounds(10, 10, 200, 25);
        this.getContentPane().add(labNomUsuario);
        labNomUsuario.setVisible(true);
        
        textNomUsuario = new JTextField("");
        textNomUsuario.setBounds(125, 10, 150, 25);
        this.getContentPane().add(textNomUsuario);
        textNomUsuario.setVisible(true);
        textNomUsuario.addKeyListener(this);
    	
    	labContra = new JLabel("Contraseña Actual:");
        labContra.setBounds(295, 10, 200, 25);
        this.getContentPane().add(labContra);
        labContra.setVisible(true);
        
        pasContra = new JPasswordField("");
        pasContra.setBounds(430, 10, 150, 25);
        this.getContentPane().add(pasContra);
        pasContra.setVisible(true);
        pasContra.addKeyListener(this);
        
        labNuevaContra = new JLabel("Nueva Contraseña:");
        labNuevaContra.setBounds(10, 50, 200, 25);
        this.getContentPane().add(labNuevaContra);
        labNuevaContra.setVisible(true);
        
        pasNuevaContra = new JPasswordField("");
        pasNuevaContra.setBounds(125, 50, 150, 25);
        this.getContentPane().add(pasNuevaContra);
        pasNuevaContra.setVisible(true);
        pasNuevaContra.addKeyListener(this);
        
        labConfirNueva = new JLabel("Confirmar Contraseña:");
        labConfirNueva.setBounds(295, 50, 200, 25);
        this.getContentPane().add(labConfirNueva);
        labConfirNueva.setVisible(true);
        
        pasConfirNueva = new JPasswordField("");
        pasConfirNueva.setBounds(430, 50, 150, 25);
        this.getContentPane().add(pasConfirNueva);
        pasConfirNueva.setVisible(true);
        pasConfirNueva.addKeyListener(this);
        
        labPregunta = new JLabel("Pregunta Secreta:");
        labPregunta.setBounds(10, 90, 200, 25);
        this.getContentPane().add(labPregunta);
        labPregunta.setVisible(true);
        
        comboPregunta = new JComboBox();
        comboPregunta.addItem("MASCOTA PREFERIDA");
        comboPregunta.setBounds(125,90, 300, 25);
        this.getContentPane().add(comboPregunta);
        comboPregunta.setVisible(true);
        comboPregunta.addKeyListener(this);
        
        labRespuesta = new JLabel("Respuesta:");
        labRespuesta.setBounds(10, 130, 200, 25);
        this.getContentPane().add(labRespuesta);
        labRespuesta.setVisible(true);
        
        textRespuesta = new JTextField("");
        textRespuesta.setBounds(125, 130, 300, 25);
        this.getContentPane().add(textRespuesta);
        textRespuesta.setVisible(true);
        textRespuesta.addKeyListener(this);
        
        icoModificar = new ImageIcon("Imagenes\\Modificar.jpg");
        botonModificar = new JButton(icoModificar);
        botonModificar.setBounds(50, 170, 70, 40);
        this.getContentPane().add(botonModificar);
        botonModificar.setVisible(true);
        botonModificar.setToolTipText("Modificar");
        botonModificar.addActionListener(this); 
        
        icoGuardar=new ImageIcon("Imagenes\\Guardar.jpg");
        botonGuardar = new JButton(icoGuardar);
        botonGuardar.setBounds(140, 170, 70, 40);
        this.getContentPane().add(botonGuardar);
        botonGuardar.setVisible(true);
        botonGuardar.setEnabled(false);
        botonGuardar.setToolTipText("Guardar");
        botonGuardar.addActionListener(this);
        
        icoLimpiar = new ImageIcon("Imagenes\\Limpiar.jpg");
        botonLimpiar = new JButton(icoLimpiar);
        botonLimpiar.setBounds(230, 170, 70, 40);
        this.getContentPane().add(botonLimpiar);
        botonLimpiar.setVisible(true);
        botonLimpiar.setToolTipText("Limpiar Campos");
        botonLimpiar.addActionListener(this);
        
        icoSalir = new ImageIcon("Imagenes\\Salir.jpg");
        botonSalir = new JButton(icoSalir);
        botonSalir.setBounds(320, 170, 70, 40);
        this.getContentPane().add(botonSalir);
        botonModificar.setToolTipText("Salir");
        botonSalir.setVisible(true);
        botonSalir.addActionListener(this);
        
        iconFondoR = new ImageIcon("Imagenes\\CERDO7.jpg");
        labelFondo = new JLabel(iconFondoR);
        labelFondo.setBounds(395, 80, 230, 150);
        this.getContentPane().add(labelFondo);
        setVisible(true);
    	
    	icoMensajeInfor = new ImageIcon("Imagenes\\IconoInformacion.jpg");
    	icoMensajePre = new ImageIcon("Imagenes\\IconoPregunta.jpg");
    	perfilModifiContra = new DatosPerfil();
    	cont = new int [4];
    	this.listaPerfi = listaPerfil;
    	this.listaPerso = listaPersonal;
    	this.limpiarCampos();
    	this.desactivarCampos();
    	this.validarCampos();
    	
    	repaint();	
    	
    }
    
    public void actionPerformed(ActionEvent event) {
    	
    	if ( event.getSource() == botonGuardar){
    		
    		this.guardarModificacion();
    		datosPerfilEmail = listaPerfi.modificarContraseñaIngrse(perfilModifiContra);
    		if (datosPerfilEmail != null){
   			
	   			this.correo	= datosPerfilEmail.getCorreoCorpora();
	   			this.nombre = listaPerso.capturarNombre(datosPerfilEmail.getNumCedula());
	   			this.usuario = datosPerfilEmail.getUsuario();
	   			this.contraseña = datosPerfilEmail.getContraIngreso();
	   			mail = new EnviarEmail(correo, nombre, usuario, contraseña, tipoMensaje, mensaje);
	   		}else{
	   			
	   			JOptionPane.showMessageDialog(null,"Datos incorrectos","Modificar Contraseña - S.G.P.",JOptionPane.OK_OPTION,icoMensajeInfor);
	   			textNomUsuario.requestFocus();
   			}
    		
    	}
    	
    	if ( event.getSource() == botonModificar){
    		
    		this.activarCampos();
    		textNomUsuario.requestFocus();
    	}
    	
    	if (event.getSource() == botonSalir){
			int opc ;
		    opc = JOptionPane.showConfirmDialog(null,"¿Está seguro que desea salir de modificar contraseña?",
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
   			if (textNomUsuario.getText().equals("") || pasContra.getText().equals("") || textRespuesta.getText().equals("") 
   				|| pasNuevaContra.getText().equals("") || pasConfirNueva.getText().equals("") /*pregunta.equals("")*/){
   				
   				JOptionPane.showMessageDialog(null,"Digite todos los campos obligatorios","Recuperar Contraseña - S.G.P.",JOptionPane.OK_OPTION,icoMensajeInfor);
   				textRespuesta.requestFocus();
   			}else{
   				
   				this.desactivarCampos();
   				botonGuardar.setEnabled(true);
   			}
   		}
   		
   		if (e.getSource() == pasNuevaContra && e.getKeyCode() == KeyEvent.VK_ENTER){
			
			this.inicializarCont(cont);
			if (!v.validarContraseñ(pasNuevaContra.getText(),cont)){
				
				JOptionPane.showMessageDialog(null,"La contraseña debe contener al menos un:" + "\n" + "caracter especial, letra mayuscula,"
											  + "\n" + "letra minuscula, número y un tamnaño como minimo de 8 caracteres","Gestionar Perfil - S.G.P",
											  JOptionPane.OK_OPTION,icoMensajeInfor);
				pasNuevaContra.requestFocus();
				pasNuevaContra.setText("");
			}
		}
		
		if (e.getSource() == pasConfirNueva && e.getKeyCode() == KeyEvent.VK_ENTER){
			
			if (pasNuevaContra.getText().equals("") || pasConfirNueva.getText().equals("")){
				
				JOptionPane.showMessageDialog(null,"Digite los campos son obligatorios","Gestionar Perfil - S.G.P",
											  JOptionPane.OK_OPTION,icoMensajeInfor);
				pasNuevaContra.requestFocus();
			}else{
				 
				if (!pasNuevaContra.getText().equals(pasConfirNueva.getText())){
					
					JOptionPane.showMessageDialog(null,"Las contraseñas no son iguales","Gestionar Perfil - S.G.P",
												  JOptionPane.OK_OPTION,icoMensajeInfor);
					pasNuevaContra.setText("");
					pasConfirNueva.setText("");
					pasNuevaContra.requestFocus();
					
				}
			}
		}
   		
   	}
   	
   	public void keyReleased(KeyEvent e) {

    } 
    	 	
  	public void keyTyped(KeyEvent e) {
	}
  	
  	public void guardarModificacion(){
  		
  		perfilModifiContra.setUsuario(textNomUsuario.getText());
  		perfilModifiContra.setContra(pasContra.getText());
  		perfilModifiContra.setContraIngreso(pasNuevaContra.getText());
  		perfilModifiContra.setRepetirContraIngreso(pasConfirNueva.getText());
  		perfilModifiContra.setPregunta( (String) comboPregunta.getSelectedItem());
  		perfilModifiContra.setRespuesta(textRespuesta.getText());
  		
  	}
  	
  	public void limpiarCampos(){
  		
  		textNomUsuario.setText("");
  		pasContra.setText("");
  		pasNuevaContra.setText("");
  		pasConfirNueva.setText("");
  		comboPregunta.setSelectedItem(null);
  		textRespuesta.setText("");
  	}
  	
  	public void activarCampos(){
  		
  		textNomUsuario.setEnabled(true);
  		pasContra.setEnabled(true);
  		pasNuevaContra.setEnabled(true);
  		pasConfirNueva.setEnabled(true);
  		comboPregunta.setEnabled(true);
  		textRespuesta.setEnabled(true);
  	}
  	
  	public void desactivarCampos(){
  		
  		textNomUsuario.setEnabled(false);
  		pasContra.setEnabled(false);
  		pasNuevaContra.setEnabled(false);
  		pasConfirNueva.setEnabled(false);
  		comboPregunta.setEnabled(false);
  		textRespuesta.setEnabled(false);
  	}
  	
  	public void  inicializarCont(int cont[]){
		
		for (int j = 0; j < 3; j++){
			
				cont[j] = 0;
			} 	
	}
    
    public void validarCampos() { 
	    
	    this.textNomUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
	        public void keyTyped(java.awt.event.KeyEvent e) {
	            v.validarLongitud(10, textNomUsuario, e); 
	            v.Obligatorios(textNomUsuario, e);
	        }
	    });
	    
	    this.pasContra.addKeyListener(new java.awt.event.KeyAdapter() {
	        public void keyTyped(java.awt.event.KeyEvent e) {
	            v.validarLongitud(10, pasContra, e); 
	            v.ObligatoriosP(pasContra, e);
	            //v.validarContraseña(pasContraIngreso, e,cont);
	        }
	    });
	        
	    this.pasNuevaContra.addKeyListener(new java.awt.event.KeyAdapter() {
	        public void keyTyped(java.awt.event.KeyEvent e) {
	            v.validarLongitud(10, pasNuevaContra, e); 
	            v.ObligatoriosP(pasNuevaContra, e);
	        }
	    });
	        
	    this.pasConfirNueva.addKeyListener(new java.awt.event.KeyAdapter() {
	        public void keyTyped(java.awt.event.KeyEvent e) {
	            v.validarLongitud(10, pasConfirNueva, e); 
	            v.Obligatorios(pasConfirNueva, e);
	        }
	    }); 
	    
	    this.textRespuesta.addKeyListener(new java.awt.event.KeyAdapter() {
	        public void keyTyped(java.awt.event.KeyEvent e) {
	            v.validarLongitud(40, textRespuesta, e); 
	            v.Obligatorios(textRespuesta, e);
	        }
	    });
	     
	}
}