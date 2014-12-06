import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;

import java.awt.*;
import javax.swing.JLabel;
import javax.swing.JButton;
import listas.*;
import nodos.*;
import logica.*;
import Utilidades.Validaciones;
import Utilidades.ListarPerfil;

public class GestionarPerfil extends JFrame implements ActionListener, KeyListener {
	
	JLabel labelNumCed, labelCodPerfil, labelPerfil, labelCorreoCor, labelContra, labelRepetirContra, labelPregunta, labelRespuesta;
	JLabel labelFondo,labelUsuario, labelContraIngreso, labelRepetirContraIngreso;
	JTextField textNumCed, textCodPerfil, textUsuario, textCorreoCor, textRespuesta;
	JPasswordField pasContra, pasRepetirContra, pasContraIngreso, pasRepetirContraIngreso;
	JComboBox comboPerfil, comboPregunta;
	JButton botonCrear, botonGuardar, botonModificar, botonConsultar, botonEliminar, botonSalir,botonListar,botonLimpiar,botonMas;
	Image icoCabecera;
	ImageIcon icoGuardar, icoCrear, icoModificar, icoBuscar, icoEliminar, icoSalir, iconFondo,iconMas,icoLimpiar,icoListar,iconFondoR;
	ImageIcon icoMensajePre,icoMensajeInfor;
	int swModi=0;
	ListaPerfil listaPerfi;
	ListaPersonal listaPeson;
	DatosPerfil perfil,buscarPerfil;
	Validaciones v = new Validaciones();
	String email;
	int [] cont;

    public GestionarPerfil(ListaPerfil listaPerfil, ListaPersonal listaPersonal) {
    	
    	super("Gestionar Perfil ");
        getContentPane().setLayout(null);
        setSize(735, 435);
        setResizable(true);
        setLocation(325, 150);
        setVisible(true);
        
        icoCabecera=Toolkit.getDefaultToolkit().getImage("Imagenes\\Perfil.jpg");
        setIconImage(icoCabecera);
        this.getContentPane().setBackground(Color.white); 
        	
        labelNumCed = new JLabel("Número de Documento:");
        labelNumCed.setBounds(20, 25, 200, 25);
        this.getContentPane().add(labelNumCed);
        labelNumCed.setVisible(true);
        
        textNumCed = new JTextField("");
        textNumCed.setBounds(155, 25, 120, 25);
        this.getContentPane().add(textNumCed);
        textNumCed.setVisible(true);
        textNumCed.addKeyListener(this);
        
        labelCodPerfil = new JLabel("Código del Perfil :");
        labelCodPerfil.setBounds(295, 25, 200, 25);
        this.getContentPane().add(labelCodPerfil);
        labelCodPerfil.setVisible(true);
        
        textCodPerfil = new JTextField("");
        textCodPerfil.setBounds(410, 25, 120, 25);
        this.getContentPane().add(textCodPerfil);
        textCodPerfil.setVisible(true);
        textCodPerfil.addKeyListener(this);
        
        iconFondoR = new ImageIcon("Imagenes\\CERDO2.jpg");
        labelFondo = new JLabel(iconFondoR);
        labelFondo.setBounds(500, 5, 250, 180);
        this.getContentPane().add(labelFondo);
        setVisible(true);
        
        labelPerfil = new JLabel("Perfil :");
        labelPerfil.setBounds(20, 65, 200, 25);
        this.getContentPane().add(labelPerfil);
        labelPerfil.setVisible(true);
        
        comboPerfil = new JComboBox(); 
        comboPerfil.addItem("ADMINISTRADOR");
        comboPerfil.addItem("ADMINISTRADOR DE JAULAS");
        comboPerfil.addItem("VETERINARIO");
        comboPerfil.setBounds(155,65, 375, 25);
        this.getContentPane().add(comboPerfil);
        comboPerfil.setVisible(true);
        comboPerfil.addKeyListener(this);
        
        labelUsuario = new JLabel("Nombre de Usuario:");
        labelUsuario.setBounds(20, 105, 200, 25);
        this.getContentPane().add(labelUsuario);
        labelUsuario.setVisible(true);
        
        textUsuario = new JTextField("");
        textUsuario.setBounds(155, 105, 375, 25);
        this.getContentPane().add(textUsuario);
        textUsuario.setVisible(true);
        textUsuario.addKeyListener(this);
        
        labelContraIngreso = new JLabel("Ingreso al Sistema:");
        labelContraIngreso.setBounds(20, 145, 200, 25);
        this.getContentPane().add(labelContraIngreso);
        labelContraIngreso.setVisible(true);
        
        pasContraIngreso = new JPasswordField("");
        pasContraIngreso.setBounds(155, 145, 120, 25);
        this.getContentPane().add(pasContraIngreso);
        pasContraIngreso.setVisible(true);
        pasContraIngreso.addKeyListener(this);
        
        labelRepetirContraIngreso = new JLabel("Repetir Ingreso:");
        labelRepetirContraIngreso.setBounds(295, 145, 200, 25);
        this.getContentPane().add(labelRepetirContraIngreso);
        labelRepetirContraIngreso.setVisible(true);
        
        pasRepetirContraIngreso = new JPasswordField("");
        pasRepetirContraIngreso.setBounds(410, 145, 120, 25);
        this.getContentPane().add(pasRepetirContraIngreso);
        pasRepetirContraIngreso.setVisible(true);
        pasRepetirContraIngreso.addKeyListener(this);
        
        labelCorreoCor = new JLabel("Correo Corporativo:");
        labelCorreoCor.setBounds(20, 185, 200, 25);
        this.getContentPane().add(labelCorreoCor);
        labelCorreoCor.setVisible(true);
        
        textCorreoCor = new JTextField("");
        textCorreoCor.setBounds(155, 185, 375, 25);
        this.getContentPane().add(textCorreoCor);
        textCorreoCor.setVisible(true);
        textCorreoCor.addKeyListener(this);
        
        labelContra = new JLabel("Contraseña:");
        labelContra.setBounds(20, 225, 200, 25);
        this.getContentPane().add(labelContra);
        labelContra.setVisible(true);
        
        pasContra = new JPasswordField("");
        pasContra.setBounds(155, 225, 120, 25);
        this.getContentPane().add(pasContra);
        pasContra.setVisible(true);
        pasContra.addKeyListener(this);
        
        labelRepetirContra = new JLabel("Repetir Contraseña:");
        labelRepetirContra.setBounds(295, 225, 200, 25);
        this.getContentPane().add(labelRepetirContra);
        labelRepetirContra.setVisible(true);
        
        pasRepetirContra = new JPasswordField("");
        pasRepetirContra.setBounds(410, 225, 120, 25);
        this.getContentPane().add(pasRepetirContra);
        pasRepetirContra.setVisible(true);
        pasRepetirContra.addKeyListener(this);
        
        labelPregunta = new JLabel("Pregunta Secreta:");
        labelPregunta.setBounds(20, 265, 200, 25);
        this.getContentPane().add(labelPregunta);
        labelPregunta.setVisible(true);
        
        comboPregunta = new JComboBox(); 
        comboPregunta.addItem("MASCOTA PREFERIDA");
        comboPregunta.setBounds(155,265, 375, 25);
        this.getContentPane().add(comboPregunta);
        comboPregunta.setVisible(true);
        comboPregunta.addKeyListener(this);
        
        iconMas = new ImageIcon("Imagenes\\Mas.jpg");
        botonMas = new JButton(iconMas);
        botonMas.setBounds(540, 265, 50, 25);
        this.getContentPane().add(botonMas);
        botonMas.setVisible(true);
        botonMas.addActionListener(this);
        
        labelRespuesta = new JLabel("Respuesta:");
        labelRespuesta.setBounds(20, 305, 200, 25);
        this.getContentPane().add(labelRespuesta);
        labelRespuesta.setVisible(true);
        
        textRespuesta = new JTextField("");
        textRespuesta.setBounds(155, 305, 375, 25);
        this.getContentPane().add(textRespuesta);
        textRespuesta.setVisible(true);
        textRespuesta.addKeyListener(this);
        
        icoCrear = new ImageIcon("Imagenes\\Gesper.jpg");
        botonCrear = new JButton(icoCrear);
        botonCrear.setBounds(10, 345, 70, 40);
        this.getContentPane().add(botonCrear);
        botonCrear.setVisible(true);
        botonCrear.setToolTipText("Crear Perfil");
        botonCrear.addActionListener(this);
        
        icoGuardar=new ImageIcon("Imagenes\\Guardar.jpg");
        botonGuardar = new JButton(icoGuardar);
        botonGuardar.setBounds(100, 345, 70, 40);
        this.getContentPane().add(botonGuardar);
        botonGuardar.setVisible(true);
        botonGuardar.setEnabled(false);
        botonGuardar.setToolTipText("Guardar");
        botonGuardar.addActionListener(this);
        
        icoModificar = new ImageIcon("Imagenes\\Modificar.jpg");
        botonModificar = new JButton(icoModificar);
        botonModificar.setBounds(190, 345, 70, 40);
        this.getContentPane().add(botonModificar);
        botonModificar.setVisible(true);
        botonModificar.setToolTipText("Modificar");
        botonModificar.addActionListener(this);
        
        icoBuscar = new ImageIcon("Imagenes\\Buscar.jpg");
        botonConsultar = new JButton(icoBuscar);
        botonConsultar.setBounds(280, 345, 70, 40);
        this.getContentPane().add(botonConsultar);
        botonConsultar.setVisible(true);
        botonConsultar.setToolTipText("Consultar");
        botonConsultar.addActionListener(this);
        
        icoEliminar = new ImageIcon("Imagenes\\Eliminar.jpg");
        botonEliminar = new JButton(icoEliminar);
        botonEliminar.setBounds(370, 345, 70, 40);
        this.getContentPane().add(botonEliminar);
        botonEliminar.setVisible(true);
        botonEliminar.setToolTipText("Eliminar");
        botonEliminar.addActionListener(this);
        
        icoListar = new ImageIcon("Imagenes\\Listar.jpg");        
        botonListar = new JButton(icoListar);
        botonListar.setBounds(460, 345, 70, 40);
        this.getContentPane().add(botonListar);
        botonListar.setVisible(true);
        botonListar.setToolTipText("Listar Perfiles");
        botonListar.addActionListener(this);
        
        icoLimpiar = new ImageIcon("Imagenes\\Limpiar.jpg");
        botonLimpiar = new JButton(icoLimpiar);
        botonLimpiar.setBounds(550, 345, 70, 40);
        this.getContentPane().add(botonLimpiar);
        botonLimpiar.setVisible(true);
        botonLimpiar.setToolTipText("Limpiar Campos");
        botonLimpiar.addActionListener(this);
        
        icoSalir = new ImageIcon("Imagenes\\Salir.jpg");
        botonSalir = new JButton(icoSalir);
        botonSalir.setBounds(640, 345, 70, 40);
        this.getContentPane().add(botonSalir);
        botonSalir.setVisible(true);
        botonSalir.setToolTipText("Salir");
        botonSalir.addActionListener(this);
        
        icoMensajeInfor = new ImageIcon("Imagenes\\IconoInformacion.jpg");
        icoMensajePre = new ImageIcon("Imagenes\\IconoPregunta.jpg"); 
        this.listaPerfi = listaPerfil;
        this.listaPeson = listaPersonal;
        this.DesactivarCampos();
        this.validarCamposPerfil();
        this.LimpiarCampos();
        cont = new int [4];
        
        repaint(); 	
    }
    
    public void actionPerformed(ActionEvent event) {
      	
      	if (event.getSource()==botonMas){
        
        	comboPregunta.addItem(JOptionPane.showInputDialog("Ingrese la Nueva Pregunta"));	
        }
        
        if (event.getSource()==botonCrear){
        	
        	textNumCed.setEnabled(true);
        	textNumCed.requestFocus(); 
        	this.LimpiarCampos();
        	this.ActivarCampos();
        	swModi=0;	
        	this.desactivarBotones();
        }	
   			
  		if (event.getSource() == botonSalir) {
            int opc ;
            opc = JOptionPane.showConfirmDialog(null,"¿Está seguro que desea salir de Gestionar Perfil?",
            								  "Salir.  Sistematización Grajas Porcícolas - S.G.P.",JOptionPane.YES_NO_OPTION,
            
            								  JOptionPane.QUESTION_MESSAGE,icoMensajePre);
            if (opc == 0) {
                this.dispose();

            }
        }
    
	    if(event.getSource()==botonGuardar){
	        
	    	this.guardarCamposPerfil();
	    	this.inicializarCont(cont);
			if (!v.validarContraseñ(pasContraIngreso.getText(),cont)){
				
				JOptionPane.showMessageDialog(null,"La contraseña debe contener al menos un:" + "\n" + "caracter especial, letra mayuscula,"
											  + "\n" + "letra minuscula, número y un tamnaño como minimo de 8 caracteres","Gestionar Perfil - S.G.P",
											  JOptionPane.OK_OPTION,icoMensajeInfor);
				pasContraIngreso.requestFocus();
				pasContraIngreso.setText("");
			}else{
			
		        if (swModi==0){
		        	
		        	if (listaPerfi.existePerfil(perfil.getNumCedula())){
		        		
		        		JOptionPane.showMessageDialog(null,"El número de documento ya existe","Gestionar Perfil - S.G.P",
												 	  JOptionPane.OK_OPTION,icoMensajeInfor); 
		        	}else{
		        		if (listaPerfi.guardarPerfil(perfil)){
		        			
		        			JOptionPane.showMessageDialog(null,"El registro se guardo correctamente","Gestionar Perfil - S.G.P",
												 	  	  JOptionPane.OK_OPTION,icoMensajeInfor);  
			        		this.LimpiarCampos();
			        		this.DesactivarCampos();
		        		}else{
		        			
		        			JOptionPane.showMessageDialog(null,"El registro no fue guardado","Gestionar Perfil - S.G.P",
												 	  	  JOptionPane.OK_OPTION,icoMensajeInfor); 
		        		}
		        	}
		        	
		        }else{
		        	
		        	int n= JOptionPane.showConfirmDialog(this,"Esta seguro que desea modificar este registro");
		            if(n==0){
			   			if (listaPerfi.modificarPerfil(perfil)){
			        		
			        		JOptionPane.showMessageDialog(null,"El registro se modifico correctamente","Gestionar Perfil - S.G.P",
												 	  	  JOptionPane.OK_OPTION,icoMensajeInfor);  
			        		this.LimpiarCampos();
			        		this.DesactivarCampos();
			    		}else{
			        		
			        		JOptionPane.showMessageDialog(null,"El registro no fue modificado","Gestionar Perfil - S.G.P",
												 	  	  JOptionPane.OK_OPTION,icoMensajeInfor); 
			    		}
			    	}	
				}
		    		
		    	botonGuardar.setEnabled(false);
	        }		
		}
	    	
		if (event.getSource()==botonLimpiar){
			
			this.LimpiarCampos();
			this.DesactivarCampos();
			this.activarBotones();
		}
	
//****************************************** PROGRAMAR EL BOTON MODIFICAR *********************************************************************//
        
        if (event.getSource()==botonModificar){
        	
        	swModi=1;
        	llenarDatosPerfil(); 
        	this.ActivarCampos();
        }
        
 //******************************************** CODIGOBOTON CONSULTAR ******************************************************************//
    	
    	if(event.getSource()==botonConsultar){
		
			swModi = 0;
 			this.llenarDatosPerfil();
			this.DesactivarCampos();
		}

//******************************************* PROGRAMAMOS EL BOTON ELIMINAR ***************************************************************//		
     	
     	if(event.getSource()==botonEliminar){
     		
    		String s=JOptionPane.showInputDialog(null,"Ingrese el número de documento del perfil que desea eliminar","Gestionar Perfil - S.G.P.",
    											 JOptionPane.QUESTION_MESSAGE);
	        if(listaPerfi.existePerfil(s)){
	        	
	            if(listaPerfi.eliminarPerfil(s)){
	            	
	            	JOptionPane.showMessageDialog(null,"El perfil ha sido eliminado","Gestionar Perfil - S.G.P",
											 	  JOptionPane.OK_OPTION,icoMensajeInfor); 
                	this.LimpiarCampos();
                
            	}else{
            		
            		JOptionPane.showMessageDialog(null,"El perfil no se pudo eliminar","Gestionar Perfil - S.G.P",
											  	  JOptionPane.OK_OPTION,icoMensajeInfor);  
            	}
        	}else{
        		
        		JOptionPane.showMessageDialog(null,"El número de documento no existe","Gestionar Perfil - S.G.P",
											  JOptionPane.OK_OPTION,icoMensajeInfor);  
        	}
    	}
    	
    	if (event.getSource()==botonListar){
        
	       ListarPerfil lper= new ListarPerfil(listaPerfi.getCabeza());	
	    } 
	
	}
	
//******************************************** CODIGO PARA VALIDAR CUADROS DE TEXTO ********************************************************************************************//
	
	public void keyPressed(KeyEvent e){
		
		if((e.getKeyCode() == KeyEvent.VK_ENTER)){
     		
   			Component c = (Component) e.getSource(); 
			c.transferFocus(); 	
		}
		
		if (e.getSource() == textNumCed && e.getKeyCode() == KeyEvent.VK_ENTER){
			
			if (!listaPeson.existePersonal(textNumCed.getText())){
				
				JOptionPane.showMessageDialog(null,"El número de documento no existe","Gestionar Perfil - S.G.P",
											  JOptionPane.OK_OPTION,icoMensajeInfor);  
				textNumCed.requestFocus();
			}
		}
		
		if (e.getSource() == textRespuesta && e.getKeyCode() == KeyEvent.VK_ENTER){
			
			if (textNumCed.getText().equals("") || textCodPerfil.getText().equals("") ||/* comboPerfil.getSelectedItem().equals("") ||*/ textCorreoCor.getText().equals("") || 
				pasContra.getText().equals("") || pasRepetirContra.getText().equals("") ||/* comboPerfil.getSelectedItem().equals("") ||*/ textRespuesta.getText().equals("")){
				
				JOptionPane.showMessageDialog(null,"Digite todos los campos obligatorios","Gestionar Perfil - S.G.P",
											  JOptionPane.OK_OPTION,icoMensajeInfor);  
				e.consume();	
			}else{
				this.DesactivarCampos();
				botonGuardar.setEnabled(true);
			}
		}
		
		if (e.getSource()==textCorreoCor && e.getKeyCode()==KeyEvent.VK_ENTER){
			
			email = textCorreoCor.getText();
			
			if (!v.validarEmail(email)){  //Validamos si el correo electronico si corresponde al formato
				
				JOptionPane.showMessageDialog(null,"Este formato no corresponde al de un email","Gestionar Perfil - S.G.P",
											  JOptionPane.OK_OPTION,icoMensajeInfor); 
				textCorreoCor.requestFocus();
			}	
		
		}
		
		if (e.getSource() == pasContraIngreso && e.getKeyCode() == KeyEvent.VK_ENTER){
			
			this.inicializarCont(cont);
			if (!v.validarContraseñ(pasContraIngreso.getText(),cont)){
				
				JOptionPane.showMessageDialog(null,"La contraseña debe contener al menos:" + "\n" + "1 caracter especial" + "\n"+"1 letra mayúscula, minúscula"
											  + "\n" + "1 número y un tamnaño como mínimo de 8 caracteres","Gestionar Perfil - S.G.P",
											  JOptionPane.OK_OPTION,icoMensajeInfor);
				pasContraIngreso.requestFocus();
				pasContraIngreso.setText("");
			}
		}
		
		if (e.getSource() == pasRepetirContraIngreso && e.getKeyCode() == KeyEvent.VK_ENTER){
			
			if (pasContraIngreso.getText().equals("") || pasRepetirContraIngreso.getText().equals("")){
				
				JOptionPane.showMessageDialog(null,"Digite los campos son obligatorios","Gestionar Perfil - S.G.P",
											  JOptionPane.OK_OPTION,icoMensajeInfor);
				pasContraIngreso.requestFocus();
			}else{
				 
				if (!pasContraIngreso.getText().equals(pasRepetirContraIngreso.getText())){
					
					JOptionPane.showMessageDialog(null,"Las contraseñas no son iguales","Gestionar Perfil - S.G.P",
												  JOptionPane.OK_OPTION,icoMensajeInfor);
					pasContraIngreso.setText("");
					pasRepetirContraIngreso.setText("");
					pasContraIngreso.requestFocus();
					
				}
			}
		}
		
		if (e.getSource() == pasRepetirContra && e.getKeyCode() == KeyEvent.VK_ENTER){
			
			if (pasContra.getText().equals("") || pasRepetirContra.getText().equals("")){
				
				JOptionPane.showMessageDialog(null,"Digite los campos son obligatorios","Gestionar Perfil - S.G.P",
											  JOptionPane.OK_OPTION,icoMensajeInfor);
				pasContra.requestFocus();
			}else{
				
				String contra = pasRepetirContra.getText();
				if (pasContra.getText().equals(contra)){
					
					JOptionPane.showMessageDialog(null,"Las contraseñas no son iguales","Gestionar Perfil - S.G.P",
												  JOptionPane.OK_OPTION,icoMensajeInfor);
					pasContra.setText("");
					pasRepetirContra.setText("");
					pasContra.requestFocus();
					
				}
			}
		}
	
	}
	
	public void keyReleased(KeyEvent e) {

    } 
    	 	
  	public void keyTyped(KeyEvent e) {
	}
	
//************************************** METODOS PARA EL CRUD *********************************************************************************************************//
	
	public void LimpiarCampos() {
    
		textNumCed.setText(""); 
		textCodPerfil.setText("");
		textUsuario.setText("");
	   	pasContraIngreso.setText("");
	   	pasRepetirContraIngreso.setText("");
		comboPerfil.setSelectedItem(null);
		textCorreoCor.setText("");
		pasContra.setText("");
		pasRepetirContra.setText("");
		comboPregunta.setSelectedItem(null);
		textRespuesta.setText("");
    
	}

 	public void guardarCamposPerfil() {
	 
		try{	
		    perfil = new DatosPerfil();
		    perfil.setNumCedula(textNumCed.getText()); 
		    perfil.setCodPerfil(textCodPerfil.getText());
		    perfil.setPerfil((String)comboPerfil.getSelectedItem());
		    perfil.setUsuario(textUsuario.getText());
		    perfil.setContraIngreso(pasContraIngreso.getText());
		    perfil.setRepetirContraIngreso(pasRepetirContraIngreso.getText());
		    perfil.setCorreoCorpora(textCorreoCor.getText());
		    perfil.setContra(pasContra.getText()); 
		    perfil.setRepetirContra(pasRepetirContra.getText());
		    perfil.setPregunta((String)comboPregunta.getSelectedItem());
		    perfil.setRespuesta(textRespuesta.getText());
		    perfil.setFecha(new Date());
		}
	   	catch(Exception e){
	   		System.out.println("Error al listar los datos"+e.getMessage());
	   	}
	}
	
	public void llenarDatosPerfil() {
		
		int opc=-2;
		String[]opciones = { "Número de Documento","Nombre de Usuario","Contraseña de Ingreso"};
		if (swModi==1){
				
			buscarPerfil = listaPerfi.BuscarPerfil(JOptionPane.showInputDialog("Ingrese el número de documento del perfil a modificar"));
		}else{
			
			opc = JOptionPane.showOptionDialog(null,"Seleccione la forma en que desea realizar la consulta",
												   "Consulta Perfiles. Sistematización Granjas Porcícola - S.G.P.",JOptionPane.YES_NO_CANCEL_OPTION,
												   JOptionPane.QUESTION_MESSAGE,icoMensajePre,opciones,true);									   
			switch (opc){
				
				case 0:
					buscarPerfil = listaPerfi.BuscarPerfil(JOptionPane.showInputDialog("Ingrese el número de documento del perfil a consultar"));
					break;
				case 1:
					buscarPerfil = listaPerfi.BuscarPerfilNomUsuario(JOptionPane.showInputDialog("Ingrese el nombre de usuario del perfil a consultar"));
					break;
				case 2:
					buscarPerfil = listaPerfi.BuscarPerfilContraIngreso(JOptionPane.showInputDialog("Ingrese la contraseña de ingreso del perfil a consultar"));
					break;
			}
		}
		if (opc != -1){
			if (buscarPerfil!= null){
			    textNumCed.setText(buscarPerfil.getNumCedula());   
			    textCodPerfil.setText(buscarPerfil.getCodPerfil());
			    comboPerfil.setSelectedItem(buscarPerfil.getPerfil());
			    textUsuario.setText(buscarPerfil.getUsuario());
			   	pasContraIngreso.setText(buscarPerfil.getContraIngreso());
			   	pasRepetirContraIngreso.setText(buscarPerfil.getRepetirContraIngreso());
				textCorreoCor.setText(buscarPerfil.getCorreoCorpora());
			    pasContra.setText(buscarPerfil.getContra());
			    pasRepetirContra.setText(buscarPerfil.getRepetirContra());
			    comboPregunta.setSelectedItem(buscarPerfil.getPregunta());
	   		    textRespuesta.setText(buscarPerfil.getRespuesta());
			}else{
				
				JOptionPane.showMessageDialog(null,"El perfil no existe","Gestionar Perfil - S.G.P",
											  JOptionPane.OK_OPTION,icoMensajeInfor); 
			}	
		}else{
			
			JOptionPane.showMessageDialog(null,"Se cancelo la consulta","Gestionar Perfil - S.G.P",
										  JOptionPane.OK_OPTION,icoMensajeInfor); 
		} 
		
		buscarPerfil = null;
	}

	public void ActivarCampos(){
	    	 
	   	textCodPerfil.setEnabled(true);
	   	comboPerfil.setEnabled(true);
	   	textUsuario.setEnabled(true);
	   	pasContraIngreso.setEnabled(true);
	   	pasRepetirContraIngreso.setEnabled(true);
	   	textCorreoCor.setEnabled(true);
	    pasContra.setEnabled(true);
	    pasRepetirContra.setEnabled(true);
	    comboPregunta.setEnabled(true);
	    botonMas.setEnabled(true);
	    textRespuesta.setEnabled(true);
	}
	    
	public void DesactivarCampos(){
		
	    textNumCed.setEnabled(false);
	    textCodPerfil.setEnabled(false);
	   	comboPerfil.setEnabled(false);
	   	textUsuario.setEnabled(false);
	   	pasContraIngreso.setEnabled(false);
	   	pasRepetirContraIngreso.setEnabled(false);
	   	textCorreoCor.setEnabled(false);
	    pasContra.setEnabled(false);
	    pasRepetirContra.setEnabled(false);
	    comboPregunta.setEnabled(false);
	    botonMas.setEnabled(false);
	    textRespuesta.setEnabled(false);
	}
	
	public void  inicializarCont(int cont[]){
		
		for (int j = 0; j < 3; j++){
			
				cont[j] = 0;
			} 	
	}
	
	public void desactivarBotones(){
		
		botonGuardar.setEnabled(false);
		botonCrear.setEnabled(false);
		botonModificar.setEnabled(false);
		botonConsultar.setEnabled(false);
		botonEliminar.setEnabled(false);
		botonListar.setEnabled(false);
	}
	
	public void activarBotones(){
		 
		botonCrear.setEnabled(true);
		botonModificar.setEnabled(true);
		botonConsultar.setEnabled(true);
		botonEliminar.setEnabled(true);
		botonListar.setEnabled(true);
	}
	
	public void validarCamposPerfil() {
    
	    textNumCed.addKeyListener(new java.awt.event.KeyAdapter() {
	    	public void keyTyped(java.awt.event.KeyEvent e) {
	        	v.validarLongitud(10, textNumCed, e);
	            v.SoloNumeros(textNumCed, e);
	            v.Obligatorios(textNumCed, e);
	        }
	    });
	
	    this.textCodPerfil.addKeyListener(new java.awt.event.KeyAdapter() {
	        public void keyTyped(java.awt.event.KeyEvent e) {
	            v.validarLongitud(5, textCodPerfil, e);
	            v.SoloNumeros(textCodPerfil, e);
	            v.Obligatorios(textCodPerfil, e);
	        }
	    });
	    
	    this.textUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
	        public void keyTyped(java.awt.event.KeyEvent e) {
	            v.validarLongitud(10, textUsuario, e); 
	            v.Obligatorios(textUsuario, e);
	        }
	    });
	    
	    this.pasContraIngreso.addKeyListener(new java.awt.event.KeyAdapter() {
	        public void keyTyped(java.awt.event.KeyEvent e) {
	            v.validarLongitud(10, pasContraIngreso, e); 
	            v.ObligatoriosP(pasContraIngreso, e);
	            //v.validarContraseña(pasContraIngreso, e,cont);
	        }
	    });
	        
	    this.pasRepetirContraIngreso.addKeyListener(new java.awt.event.KeyAdapter() {
	        public void keyTyped(java.awt.event.KeyEvent e) {
	            v.validarLongitud(10, pasRepetirContraIngreso, e); 
	            v.ObligatoriosP(pasRepetirContraIngreso, e);
	        }
	    });
	        
	    this.textCorreoCor.addKeyListener(new java.awt.event.KeyAdapter() {
	        public void keyTyped(java.awt.event.KeyEvent e) {
	            v.validarLongitud(40, textCorreoCor, e); 
	            v.Obligatorios(textCorreoCor, e);
	        }
	    });
	        
	    this.pasContra.addKeyListener(new java.awt.event.KeyAdapter() {
	        public void keyTyped(java.awt.event.KeyEvent e) {
	            v.validarLongitud(10, pasContra, e); 
	            v.ObligatoriosP(pasContra, e);
	        }
	    });
	        
	    this.pasRepetirContra.addKeyListener(new java.awt.event.KeyAdapter() {
	        public void keyTyped(java.awt.event.KeyEvent e) {
	            v.validarLongitud(10, pasRepetirContra, e); 
	            v.ObligatoriosP(pasRepetirContra, e);
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

