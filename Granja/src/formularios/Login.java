import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;
import Utilidades.*;
import listas.*;
import logica.*;

public class Login extends JFrame implements ActionListener, KeyListener{
	
	JLabel labelTitulo,labelNomSof, labelNomSof1, labelBienvenido, labelNomUsuario, labelContaraseña, labelFondo;
	JTextField textNomUsuario;
	JPasswordField PasContraseña;
	
	JDesktopPane DpanelFondo;
	JButton botonAceptar, botonSalir, botonOlvido;
	ImageIcon  iconFondo, icoAceptar, icoSalir, icoRecordar,icoMensajePre,icoMensajeInfor;
	Image icoCabecera;
	ListaAnimales listaAnima;
	ListaPartos listaPart;
	ListaPerfil listaPerfi;
	ListaPersonal listaPersona;

	Validaciones v = new Validaciones ();
    public Login(ListaAnimales listaAnimal, ListaPartos listaParto, ListaPerfil listaPerfil, ListaPersonal listaPersonal) {
    	
    	
    	
    	super("Ingreso al Sistema ");
        getContentPane().setLayout(null);
        this.getContentPane().setName("formLogin");
        setSize(700, 355);
        this.getContentPane().setBackground(Color.white);
        icoCabecera=Toolkit.getDefaultToolkit().getImage("Imagenes\\Ingreso.jpg");
        setIconImage(icoCabecera);
        setResizable(false);
        setLocation(350, 150);
        setVisible(true);
        
        
        //((JPanel)getContentPane()).setOpaque(false);
        iconFondo = new ImageIcon("Imagenes//Cerdo.jpg");
        labelFondo = new JLabel(iconFondo);
        labelFondo.setBounds(315, 0, 410, 325);
        getContentPane().add(labelFondo);
        setVisible(true);
        
        
        labelTitulo = new JLabel(" Sistematización ");
        labelTitulo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));
        labelTitulo.setBounds(40, 10, 400, 40);
        this.getContentPane().add(labelTitulo);
        labelTitulo.setVisible(true);
        
        labelNomSof = new JLabel("Granjas Porcícolas - ");
        labelNomSof.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));
        labelNomSof.setBounds(25, 40, 400, 40);
        this.getContentPane().add(labelNomSof);
        labelNomSof.setVisible(true);
        
        
        labelNomSof1 = new JLabel("S.G.P.");
        labelNomSof1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));
        labelNomSof1.setBounds(120, 70, 100, 40);
        this.getContentPane().add(labelNomSof1);
        labelNomSof1.setVisible(true);
        
        
        labelBienvenido = new JLabel("Bienvenido");
        labelBienvenido.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 30));
        labelBienvenido.setBounds(85, 100, 300, 40);
        labelBienvenido.setVisible(true);
        this.getContentPane().add(labelBienvenido);
        
   		
   		labelNomUsuario = new JLabel("Nombre de Usuario:");
        labelNomUsuario.setBounds(20, 155, 200, 25);
        this.getContentPane().add(labelNomUsuario);
        labelNomUsuario.setVisible(true);  
    	
    	textNomUsuario = new JTextField("");
        textNomUsuario.setBounds(135, 155, 200, 25);
        this.getContentPane().add(textNomUsuario);
        textNomUsuario.addKeyListener(this);
        textNomUsuario.setVisible(true);
        
        labelContaraseña = new JLabel("Contraseña:");
        labelContaraseña.setBounds(20, 195, 200, 25);
        this.getContentPane().add(labelContaraseña);
        labelContaraseña.setVisible(true);  
    	
    	PasContraseña = new JPasswordField("");
        PasContraseña.setBounds(135, 195, 200, 25);
        this.getContentPane().add(PasContraseña);
        PasContraseña.setVisible(true);
        PasContraseña.addKeyListener(this);
        
        icoAceptar = new ImageIcon("Imagenes\\Aceptar.jpg");
        botonAceptar = new JButton(icoAceptar);
        botonAceptar.setBackground(Color.lightGray); 
        botonAceptar.setBounds(70, 230, 90, 40);
        this.getContentPane().add(botonAceptar);
        botonAceptar.setVisible(true);
        botonAceptar.setToolTipText("Aceptar");
        botonAceptar.addActionListener(this);
      
        
        icoSalir = new ImageIcon("Imagenes\\Salir.jpg");
        botonSalir = new JButton(icoSalir);
        botonSalir.setBounds(200, 230, 90, 40);
        this.getContentPane().add(botonSalir);
        botonSalir.setVisible(true);
        botonSalir.setToolTipText("Salir");
        botonSalir.addActionListener(this);
    	
    	icoRecordar = new ImageIcon("Imagenes\\Recordar.jpg");
    	botonOlvido = new JButton(icoRecordar);
        botonOlvido.setBounds(140, 280, 90, 40);
        this.getContentPane().add(botonOlvido);
        botonOlvido.setVisible(true);
        botonOlvido.setToolTipText("Recordar Contraseña");
        botonOlvido.addActionListener(this);
       	
       	this.ValidarCamposLogin();
       	icoMensajeInfor = new ImageIcon("Imagenes\\IconoInformacion.jpg"); 
		icoMensajePre = new ImageIcon("Imagenes\\IconoPregunta.jpg");       
        this.listaAnima = listaAnimal;
    	this.listaPart = listaParto;
    	this.listaPerfi = listaPerfil;
    	this.listaPersona = listaPersonal;
        
    	repaint();
    	
    }
    
    public void actionPerformed(ActionEvent event) {
   		
   	 	if (event.getSource() == botonAceptar) {
   	 
   			String  nombre;
   			DatosPerfil perfi = listaPerfi.confirmarUsuario(textNomUsuario.getText(), PasContraseña.getText()); 
   		 
   			if (perfi != null) {
   				if (perfi.getUsuario().equals(textNomUsuario.getText()) && perfi.getContraIngreso().equals(PasContraseña.getText())){
					nombre = perfi.getPerfil();		
					Menu_Principal MeP= new Menu_Principal (listaAnima, listaPart, listaPerfi, listaPersona,nombre);
					textNomUsuario.setText("");
					PasContraseña.setText("");
					textNomUsuario.requestFocus();
					this.dispose();
   				}				
			}else{
			
				JOptionPane.showMessageDialog(null,"El usuario no existe","Inicio de Sesion - S.G.P",
										      JOptionPane.OK_OPTION,icoMensajeInfor); 
				textNomUsuario.requestFocus();
			} 
					
   	}
   		
   	if (event.getSource() == botonOlvido) {
   	 	
		RecuperarClave rC = new RecuperarClave(listaPerfi, listaPersona);	
	}
  
	if (event.getSource() == botonSalir) {
        int opc ;
        opc = JOptionPane.showConfirmDialog(null,"¿Está seguro que desea salir del Programa?",
        								  "Salir.  Sistematización Grajas Porcícolas - S.G.P.",JOptionPane.YES_NO_OPTION,
        								  JOptionPane.QUESTION_MESSAGE,icoMensajePre);
        if (opc == 0) {
            this.dispose();

        }
	}
         
  	}  
  	
  	public void keyPressed(KeyEvent e) {
  		
  		if((e.getKeyCode() == KeyEvent.VK_ENTER)){
     						
			Component c = (Component) e.getSource(); 
			c.transferFocus();
		} 
			
    }

    public void keyReleased(KeyEvent e) {
    }
  	
  	public void keyTyped(KeyEvent e) {

        /*if (e.getSource() == textNomUsuario) {
            char c = e.getKeyChar();
            	if (Character.isDigit(c)) {
               		getToolkit().beep();
  					e.consume(); 
    			}
        }*/
    }
    
/*    public void convertirMayusculas1(JTextField j,java.awt.event.KeyEvent e){
   	
		   		//el dispatcher se registra en forma global, por lo que es recomendable hacerlo dentro del frame principal
		//primero obtenemos le FocusManager (que a su vez es el KeyEventDispatcher)
		KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
		//y enseguida registramos nuestro dispatcher
		manager.addKeyEventDispatcher(new KeyEventDispatcher(){
        public void dispatchKeyEvent(KeyEvent e) {
                //como dije, solo las notificaciones del tipo "typed" son las que actualizan los componentes
                if(e.getID() == KeyEvent.KEY_TYPED){
                        //como vamos a convertir todo a mayúsculas, entonces solo checamos si los caracteres son 
                        //minusculas
                        if(e.getKeyChar() >= 'a' && e.getKeyChar() <= 'z'){
                                //si lo son, entonces lo reemplazamos por su respectivo en mayúscula en el mismo evento
                                // (esto se logra por que en java todas las variables son pasadas por referencia)
                                e.setKeyChar((char)(((int)e.getKeyChar()) - 32));
                        }
                }
                //y listo, regresamos siempre falso para que las demas notificaciones continuen, si regresamos true
                // significa que el dispatcher consumio el evento
                
        }
	});
	}*/
    
    public void ValidarCamposLogin() {
        textNomUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent e) {
                v.validarLongitud(30, textNomUsuario, e);
                v.SoloLetras(textNomUsuario, e);
                v.Obligatorios(textNomUsuario,e);
                v.convertirMayusculas(30,textNomUsuario,e);
            }
        });

  	      	this.PasContraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent e) {
            v.validarLongitudP(10, PasContraseña, e); 
            v.ObligatoriosP(PasContraseña, e);
            }
        }); 
    }
    
}   
