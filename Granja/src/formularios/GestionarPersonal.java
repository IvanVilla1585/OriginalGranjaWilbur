//******************************** LIBRERIAS A UTILIZAR EN LA CREACION DEL FORMULARIO Y SUS EVENTOS *************************************************************************//

import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.TitledBorder;
import Utilidades.*;
import java.awt.event.KeyEvent; 
import java.awt.event.FocusListener; 
import java.awt.image.BufferedImage;//guarda imagenes contenidas
import javax.imageio.ImageIO;//entrada y salida de archivos de formato imágen 
import javax.swing.border.Border;//borde de donde va a estar contenida la imagen
import java.awt.Desktop;
import javax.swing.table.*;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import com.toedter.calendar.JDateChooser;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import listas.ListaPersonal;
import logica.DatosPersonal;

//************************************* CLASE PARA CREAR EL FORMULARIO *********************************************************************//


public class GestionarPersonal extends JFrame implements ActionListener, KeyListener,MouseListener,PropertyChangeListener{
	
	
//************************************** DECLARACION DE LOS OBJETOS A UTILIZAR EN EL FORMULARIO ********************************************//
	DatosPersonal personal, buscarPersonal;
	ListaPersonal listaPer;
	Validaciones v = new Validaciones (); 
	JDesktopPane DPanelFoto;
	JPanel panelDatosPerso, panelDomicilio, panelFormacion, panelDatosLaborales, panelOtrosEstu;
	JLabel labelTipoDoc, labelNumDoc, labelNombre, labelFechaNaci, labelDepar, labelMuni, labelTipoSangre, labelRh, labelDireccion;
	JLabel labelTelMovil, LabelCorreo, labelProfesion, labelEstado, labelFechaTitulo, labelOtrosEstudios, labelObtenido, labelTel;
	JLabel labelFechaFin, labelCargo, labelFechaContra, labelTipoContra,labelFondo, labelManual;
	JTextField textNumDoc, textNombre, textDireccion, textTelMovil, textCorreo, textOtrosEstudios, textTel;
	JTextField textCargo, textTipoContra; 
	JDateChooser dateFechaNaci, dateFechaTitulo, dateFechaFin, dateFechaContra;
	JComboBox comboTipoDoc,  ComboDepar, comboMuni, comboTipoSangre, comboRh, comboProfesion;
	JRadioButton radioActiva, radioInactiva, radioSi, radioNo;
	ButtonGroup GrupoEstado, GrupoObtenido;
	Image icoCabecera;
	ImageIcon icoGuardar, icoCrear, icoModificar, icoBuscar, icoEliminar, icoSalir, iconFondo,iconMas,icoLimpiar,icoListar,icoCalendario;
	ImageIcon icoMensajeInfor,icoMensajePre;
	JButton botonCrear, botonGuardar, botonModificar, botonConsultar, botonEliminar, botonSalir, botonMas, botonImagen, botonListar,botonLimpiar;
	TitledBorder rotulo1, rotulo2, rotulo3, rotulo4, rotulo5;
	JFileChooser FileChExaminarEntrada;//seleccionar cualquier archivo de nuestro computador
	File FileImagen,FileIma,FileImag;//entrada y salida de imagen
	private String Esta, Obte,Fec,email;
	private int swModifi=0;
	DepartamentosMunicipios depaMuni = new DepartamentosMunicipios ();
	String [] vecDep,vecMuni;
 
	 	
//*********** VECTORES Y OBJETOS PARA EL CRUD ***********************************************************************************************//


	Vector DatosPersonal, NomColumnas; 
	JTable TablaGuardar;
    DefaultTableModel ModeloDatos;
    JScrollPane barraPersonal;

//*************************************** METODO PARA LA CREACION DEL FORMULARIO Y SUS CAMPOS *****************************************************//

    public GestionarPersonal(ListaPersonal listaPerso) {
    	
//************************************** CODIGO PARA CREAR EL FORMULARIO ****************************************************************************//
    	
    	super("Gestionar Personal ");
        getContentPane().setLayout(null);
        setSize(800, 700);
        setResizable(false);
        setLocation(300, 10);
        
        icoCabecera=Toolkit.getDefaultToolkit().getImage("Imagenes\\Gesper.jpg");
        setIconImage(icoCabecera);
        this.getContentPane().setBackground(Color.white);
        setVisible(true);
        
//************************************** CODIGO DE LOS OBJETOS A USAR EN EL FORMULARIO ****************************************************************//
        
        JPanel panelDatosPerso = new JPanel();

        rotulo1 = BorderFactory.createTitledBorder("Datos Personales");
        panelDatosPerso.setBorder(rotulo1);
        panelDatosPerso.setLayout(null);
        panelDatosPerso.setBounds(10, 15, 775, 180);
        panelDatosPerso.setVisible(true);
        panelDatosPerso.setBackground(Color.WHITE);
        this.getContentPane().add(panelDatosPerso);
        
        labelTipoDoc = new JLabel("Tipo de Documento:");
        labelTipoDoc.setBounds(10, 25, 150, 25); 
        panelDatosPerso.add(labelTipoDoc);
        labelTipoDoc.setVisible(true);
        
        comboTipoDoc = new JComboBox();
        comboTipoDoc.addItem("CC");
        comboTipoDoc.addItem("CE");
        comboTipoDoc.addItem("RC");
        comboTipoDoc.addItem("Pasaporte");
        comboTipoDoc.setBounds(135,25, 70, 25); 
        panelDatosPerso.add(comboTipoDoc);
        comboTipoDoc.addKeyListener(this);
        comboTipoDoc.setVisible(true);
        
        labelNumDoc = new JLabel("*Número Documento:");
        labelNumDoc.setBounds(398, 25, 150, 25); 
        panelDatosPerso.add(labelNumDoc);
        labelNumDoc.setVisible(true);
        
        textNumDoc = new JTextField("");
        textNumDoc.setBounds(520,25, 120, 25); 
        panelDatosPerso.add(textNumDoc); 
        textNumDoc.addKeyListener(this); 
        textNumDoc.setToolTipText( "Ingrese solo números" );
        textNumDoc.setVisible(true);
        
        labelNombre = new JLabel("*Nombres y Apellidos:");
        labelNombre.setBounds(10, 65, 150, 25); 
        panelDatosPerso.add(labelNombre);
        labelNombre.setVisible(true);
        
        textNombre = new JTextField("");
        textNombre.setBounds(135,65, 250, 25); 
        panelDatosPerso.add(textNombre);
        textNombre.addKeyListener(this);
        textNombre.setVisible(true);
        
        labelFechaNaci = new JLabel("*Fecha Nacimiento:");
        labelFechaNaci.setBounds(398, 65, 150, 25); 
        panelDatosPerso.add(labelFechaNaci);
        labelFechaNaci.setVisible(true);
        
        //Calendario        
        icoCalendario = new ImageIcon("Imagenes\\iconoCalendario.jpg");  
		dateFechaNaci = new JDateChooser();
		dateFechaNaci.setIcon(icoCalendario);
		dateFechaNaci.setBounds( 520, 65, 120, 25 );
		panelDatosPerso.add(dateFechaNaci); 
		dateFechaNaci.setMaxSelectableDate(new Date(96,30,12));
        
        labelDepar = new JLabel("*Departamento:");
        labelDepar.setBounds(10, 105, 150, 25); 
        panelDatosPerso.add(labelDepar);
        labelDepar.setVisible(true);
        
        vecDep = new String [34];
        vecDep = depaMuni.cargarDepartamentos();
        ComboDepar = new JComboBox(vecDep); 
        ComboDepar.setBounds(135,105, 120, 25); 
        panelDatosPerso.add(ComboDepar);
        ComboDepar.setVisible(true);
        ComboDepar.addActionListener(this);
        
        labelMuni = new JLabel("*Municipio:");
        labelMuni.setBounds(275, 105, 150, 25); 
        panelDatosPerso.add(labelMuni);
        labelMuni.setVisible(true);
        
        comboMuni = new JComboBox(); 
        comboMuni.setBounds(340,105, 120, 25); 
        panelDatosPerso.add(comboMuni);
        comboMuni.setVisible(true);
        comboMuni.addKeyListener(this);
        
        labelTipoSangre = new JLabel("Tipo de Sangre:");
        labelTipoSangre.setBounds(470, 105, 150, 25); 
        panelDatosPerso.add(labelTipoSangre);
        labelTipoSangre.setVisible(true);
        
        comboTipoSangre = new JComboBox();
        comboTipoSangre.addItem("A");
        comboTipoSangre.addItem("B");
        comboTipoSangre.addItem("AB");
        comboTipoSangre.addItem("O");
        comboTipoSangre.setBounds(570,105, 70, 25); 
        panelDatosPerso.add(comboTipoSangre);
        comboTipoSangre.setVisible(true);
        comboTipoSangre.addKeyListener(this);
        
        labelRh = new JLabel("Tipo de RH:");
        labelRh.setBounds(10, 145, 120, 25); 
        panelDatosPerso.add(labelRh);
        labelRh.setVisible(true);
        
        comboRh = new JComboBox();
        comboRh.addItem("+");
        comboRh.addItem("-");
        comboRh.setBounds(135,145, 70, 25); 
        panelDatosPerso.add(comboRh);
        comboRh.setVisible(true);
        comboRh.addKeyListener(this);
        
        labelEstado = new JLabel("*Estado:");
        labelEstado.setBounds(275, 145, 150, 25); 
        panelDatosPerso.add(labelEstado);
        labelEstado.setVisible(true);
        
        radioActiva = new JRadioButton("Activo", false);
        add(radioActiva);
        radioActiva.setBounds(335, 145, 80, 25);
        panelDatosPerso.add(radioActiva);
        radioActiva.setBackground(Color.white);
        radioActiva.setVisible(true);
        
        radioInactiva = new JRadioButton("Inactivo", false);
        add(radioInactiva);
        radioInactiva.setBounds(395, 145, 70, 25);
        panelDatosPerso.add(radioInactiva);
        radioInactiva.setBackground(Color.white);
        radioInactiva.setVisible(true);
        
        GrupoEstado = new ButtonGroup ();
        GrupoEstado.add(radioActiva);
        GrupoEstado.add(radioInactiva);
        
        DPanelFoto = new JDesktopPane ();
        DPanelFoto.setBounds(648, 25, 118, 145);
        panelDatosPerso.add(DPanelFoto);
        DPanelFoto.setBackground(Color.gray);
        DPanelFoto.setVisible(true);
        
        botonImagen = new JButton("Cargar Imagen");
        botonImagen.setBounds(520, 145, 118, 25); 
        panelDatosPerso.add(botonImagen);
        botonImagen.setVisible(true);
        botonImagen.addActionListener(this);
        
        JPanel panelDomicilio = new JPanel();

        rotulo2 = BorderFactory.createTitledBorder("Domicilio");
        panelDomicilio.setBorder(rotulo2);
        panelDomicilio.setLayout(null);
        panelDomicilio.setBounds(10, 205, 775, 102);
        panelDomicilio.setVisible(true);
        panelDomicilio.setBackground(Color.WHITE);
        this.getContentPane().add(panelDomicilio);
        
        labelDireccion = new JLabel("Dirección:");
        labelDireccion.setBounds(10, 25, 150, 25); 
        panelDomicilio.add(labelDireccion);
        labelDireccion.setVisible(true);
        
        textDireccion = new JTextField("");
        textDireccion.setBounds(135,25, 320, 25); 
        panelDomicilio.add(textDireccion);
        textDireccion.setVisible(true);
        textDireccion.addKeyListener(this);
        
        labelTel = new JLabel("*Teléfono Fijo:");
        labelTel.setBounds(510, 25, 150, 25); 
        panelDomicilio.add(labelTel);
        labelTel.setVisible(true);
        
        textTel = new JTextField("");
        textTel.setBounds(645, 25, 120, 25); 
        panelDomicilio.add(textTel);
        textTel.addKeyListener(this);
        textTel.setVisible(true);
        
        LabelCorreo = new JLabel("Correo Electrónico:");
        LabelCorreo.setBounds(10, 65, 150, 25); 
        panelDomicilio.add(LabelCorreo);
        LabelCorreo.setVisible(true);
        
        textCorreo = new JTextField("");
        textCorreo.setBounds(135,65, 320, 25); 
        panelDomicilio.add(textCorreo);
        textCorreo.setVisible(true);
        textCorreo.addKeyListener(this);
        
        labelTelMovil = new JLabel("*Teléfono Móvil: ");
        labelTelMovil.setBounds(510, 65, 180, 25); 
        panelDomicilio.add(labelTelMovil);
        labelTelMovil.setVisible(true);
        
        textTelMovil = new JTextField("");
        textTelMovil.setBounds(645, 65, 120, 25); 
        panelDomicilio.add(textTelMovil);
        textTelMovil.addKeyListener(this);
        textTelMovil.setVisible(true);
        
                
        JPanel panelFormacion = new JPanel();

        rotulo3 = BorderFactory.createTitledBorder("Formación Académica");
        panelFormacion.setBorder(rotulo3);
        panelFormacion.setLayout(null);
        panelFormacion.setBounds(10, 315, 775, 165);
        panelFormacion.setVisible(true);
        panelFormacion.setBackground(Color.WHITE);
        this.getContentPane().add(panelFormacion);
        
        labelProfesion = new JLabel("Profesión:");
        labelProfesion.setBounds(10, 25, 150, 25); 
        panelFormacion.add(labelProfesion);
        labelProfesion.setVisible(true);
        
        comboProfesion = new JComboBox();
        comboProfesion.addItem("VETERINARIO");
        comboProfesion.setBounds(135,25, 150, 25); 
        panelFormacion.add(comboProfesion);
        comboProfesion.setVisible(true);
        comboProfesion.addKeyListener(this);
        
        iconMas = new ImageIcon("Imagenes\\Mas.jpg");
        botonMas = new JButton(iconMas);
        botonMas.setBounds(287, 25, 50, 25);
        this.getContentPane().add(botonMas);
        panelFormacion.add(botonMas);
        botonMas.setVisible(true);
        botonMas.addActionListener(this);
        
        labelFechaTitulo = new JLabel("Fecha Obtención Titulo: ");
        labelFechaTitulo.setBounds(510, 25, 180, 25); 
        panelFormacion.add(labelFechaTitulo);
        labelFechaTitulo.setVisible(true); 
        	
        	
        //Calendario 
		dateFechaTitulo = new JDateChooser();
		dateFechaTitulo.setBounds( 645, 25, 120, 25 );
		dateFechaTitulo.setIcon(icoCalendario);
		panelFormacion.add(dateFechaTitulo);  
		dateFechaTitulo.setMaxSelectableDate(new Date());
        
        JPanel panelOtrosEstu = new JPanel();

        rotulo4 = BorderFactory.createTitledBorder("Otros Estudios");
        panelOtrosEstu.setBorder(rotulo4);
        panelOtrosEstu.setLayout(null);
        panelOtrosEstu.setBounds(5, 55, 760, 100);
        panelOtrosEstu.setVisible(true);
        panelOtrosEstu.setBackground(Color.WHITE);
        this.getContentPane().add(panelOtrosEstu);
        panelFormacion.add(panelOtrosEstu);
        
        labelOtrosEstudios = new JLabel("Titulo Otros Estudios:");
        labelOtrosEstudios.setBounds(5, 25, 180, 25); 
        panelOtrosEstu.add(labelOtrosEstudios);
        labelOtrosEstudios.setVisible(true);
        
        textOtrosEstudios = new JTextField("");
        textOtrosEstudios.setBounds(130,25, 315, 25); 
        panelOtrosEstu.add(textOtrosEstudios);
        textOtrosEstudios.addKeyListener(this);
        textOtrosEstudios.setVisible(true);
        
        labelFechaFin = new JLabel("Fecha Finalización:");
        labelFechaFin.setBounds(505, 25, 180, 25); 
        panelOtrosEstu.add(labelFechaFin);
        labelFechaFin.setVisible(true);
        
        //Calendario 
		dateFechaFin = new JDateChooser();
		dateFechaFin.setIcon(icoCalendario);
		dateFechaFin.setBounds( 630, 25, 120, 25 );
		panelOtrosEstu.add(dateFechaFin);
		dateFechaFin.addKeyListener(this);
		dateFechaTitulo.setMaxSelectableDate(new Date());
        
        labelObtenido = new JLabel("Obtenido:");
        labelObtenido.setBounds(5, 65, 180, 25); 
        panelOtrosEstu.add(labelObtenido);
        labelObtenido.setVisible(true);
        
        radioSi = new JRadioButton("Si", false);
        add(radioSi);
        radioSi.setBounds(130, 65, 40, 25);
        panelOtrosEstu.add(radioSi);
        radioSi.setBackground(Color.white);
        radioSi.setVisible(true);
        
        radioNo = new JRadioButton("No", false);
        add(radioNo);
        radioNo.setBounds(180, 65, 40, 25);
        panelOtrosEstu.add(radioNo);
        radioNo.setBackground(Color.white);
        radioNo.setVisible(true); 
        
        GrupoObtenido = new ButtonGroup ();
        GrupoObtenido.add(radioSi);
        GrupoObtenido.add(radioNo);
                
        JPanel panelDatosLaborales = new JPanel();

        rotulo5 = BorderFactory.createTitledBorder("Datos Laborales");
        panelDatosLaborales.setBorder(rotulo5);
        panelDatosLaborales.setLayout(null);
        panelDatosLaborales.setBounds(10, 487, 775, 200);
        panelDatosLaborales.setVisible(true);
        panelDatosLaborales.setBackground(Color.WHITE);
        this.getContentPane().add(panelDatosLaborales);
        
        labelCargo = new JLabel("*Cargo:");
        labelCargo.setBounds(10, 25, 150, 25); 
        panelDatosLaborales.add(labelCargo);
        labelCargo.setVisible(true);
        
        textCargo = new JTextField("");
        textCargo.setBounds(135, 25, 320, 25); 
        panelDatosLaborales.add(textCargo);
        textCargo.addKeyListener(this);
        textCargo.setVisible(true);
        
        labelFechaContra = new JLabel("*Fecha Contratación: ");
        labelFechaContra.setBounds(510, 25, 180, 25); 
        panelDatosLaborales.add(labelFechaContra);
        labelFechaContra.setVisible(true); 
        
        //Calendario 
		dateFechaContra = new JDateChooser();
		dateFechaContra.setIcon(icoCalendario);
		dateFechaContra.setBounds( 645, 25, 120, 25 );
		panelDatosLaborales.add(dateFechaContra); 
		dateFechaTitulo.setMaxSelectableDate(new Date());
        
        labelTipoContra = new JLabel("*Tipo de Contrato:");
        labelTipoContra.setBounds(10, 65, 150, 25); 
        panelDatosLaborales.add(labelTipoContra);
        labelTipoContra.setVisible(true);
        
        textTipoContra = new JTextField("");
        textTipoContra.setBounds(135, 65, 320, 25); 
        panelDatosLaborales.add(textTipoContra);
        textTipoContra.addKeyListener(this);
        textTipoContra.setVisible(true);
        
        icoLimpiar = new ImageIcon("Imagenes\\Limpiar.jpg");
        botonLimpiar = new JButton(icoLimpiar);
        botonLimpiar.setBounds(530, 65, 70, 40);
        panelDatosLaborales.add(botonLimpiar);
        botonLimpiar.setVisible(true);
        botonLimpiar.setToolTipText("Limpiar Campos");
        botonLimpiar.addActionListener(this);
       
        icoCrear = new ImageIcon("Imagenes\\Crear.jpg");
        botonCrear = new JButton(icoCrear);
        botonCrear.setBounds(20, 125, 70, 40);
        panelDatosLaborales.add(botonCrear);
        botonCrear.setVisible(true);
        botonCrear.setToolTipText("Nuevo Registro");
        botonCrear.addActionListener(this);
        
        icoGuardar=new ImageIcon("Imagenes\\Guardar.jpg");
        botonGuardar = new JButton(icoGuardar);
        botonGuardar.setBounds(105, 125, 70, 40);
        panelDatosLaborales.add(botonGuardar);
        botonGuardar.setToolTipText( "Guardar" );
        botonGuardar.setVisible(true);
        botonGuardar.addActionListener(this);
        botonGuardar.setEnabled(false);
        
        icoModificar = new ImageIcon("Imagenes\\Modificar.jpg");
        botonModificar = new JButton(icoModificar);
        botonModificar.setBounds(190, 125, 70, 40);
        panelDatosLaborales.add(botonModificar);
        botonModificar.setVisible(true);
        botonModificar.setToolTipText("Modificar");
        botonModificar.addActionListener(this); 
        
        icoBuscar = new ImageIcon("Imagenes\\Buscar.jpg");
        botonConsultar = new JButton(icoBuscar);
        botonConsultar.setBounds(275, 125, 70, 40);
        panelDatosLaborales.add(botonConsultar);
        botonConsultar.setToolTipText("Consultar");
        botonConsultar.setVisible(true);
        botonConsultar.addActionListener(this);
        
        icoEliminar = new ImageIcon("Imagenes\\Eliminar.jpg");        
        botonEliminar = new JButton(icoEliminar);
        botonEliminar.setBounds(360, 125, 70, 40);
        panelDatosLaborales.add(botonEliminar);
        botonEliminar.setVisible(true);
        botonEliminar.setToolTipText("Eliminar");
        botonEliminar.addActionListener(this);
        
        icoListar = new ImageIcon("Imagenes\\Listar.jpg");        
        botonListar = new JButton(icoListar);
        botonListar.setBounds(445, 125, 70, 40);
        panelDatosLaborales.add(botonListar);
        botonListar.setVisible(true);
        botonListar.setToolTipText("Listar Personal");
        botonListar.addActionListener(this);
        
        icoSalir = new ImageIcon("Imagenes\\Salir.jpg");
        botonSalir = new JButton(icoSalir);
        botonSalir.setBounds(530, 125, 70, 40);
        panelDatosLaborales.add(botonSalir);
        botonSalir.setVisible(true);
        botonSalir.setToolTipText("Salir");
        botonSalir.addActionListener(this); 
        
        iconFondo = new ImageIcon("Imagenes\\CERDO1.jpg");
        labelFondo = new JLabel(iconFondo);
        labelFondo.setBounds(600, 60, 180, 115);
        panelDatosLaborales.add(labelFondo);
        setVisible(true);
        
        FileChExaminarEntrada = new JFileChooser ();
        icoMensajePre = new ImageIcon("Imagenes\\IconoPregunta.jpg");
        icoMensajeInfor = new ImageIcon("Imagenes\\IconoInformacion.jpg");       
        
        this.listaPer = listaPerso;    	
    	this.DesactivarCampos(); 
    	this.Nuevo();
    	this.ValidarCamposPersonal();
    	this.repaint();	
    }
 
 //*************************************** CODIGO PARA PROGRAMAR TODOS LOS BOTONES *****************************************************//
    
    public void actionPerformed(ActionEvent event) {
     	
     	if (event.getSource()==botonImagen){
     		
   			/**
			 *Mostramos el jFileChooser
			 */
			int returnVal = FileChExaminarEntrada.showOpenDialog(getContentPane());

			/**
			 *Nos aseguramos q haya selecionado algún archivo
			 */
			if (returnVal == FileChExaminarEntrada.APPROVE_OPTION)
				{
				/**
				 *Obtenemos el archivo selecionado
				 */
				FileImagen = FileChExaminarEntrada.getSelectedFile();

					/**
					 *Mostramos la ruta del archivo en la caja de texto
					 */
					//TxtRutaArchivo.setText(FileImagen.toString());
			}
			if ( FileImagen != null){
				
				cargarImagen(DPanelFoto,FileImagen);
			}	
		}
	 
     	if (event.getSource() == botonSalir) {
            int opc ;
	        opc = JOptionPane.showConfirmDialog(null,"¿Está seguro que desea salir de gestionar personal?",
	        								  "Salir.  Sistematización Grajas Porcícolas - S.G.P.",JOptionPane.YES_NO_OPTION,
	        								  JOptionPane.QUESTION_MESSAGE,icoMensajePre);
	        if (opc == 0) {
	            this.dispose();
	
	        }
        }
        
        if (event.getSource()==botonMas){
        
        	comboProfesion.addItem(JOptionPane.showInputDialog("Ingrese la Nueva Profesión"));	
        }
        
        if (event.getSource()==botonCrear){
        	
        	comboTipoDoc.setEnabled(true);
        	textNumDoc.setEnabled(true); 
        	this.Nuevo();
        	this.ActivarCampos();
        	this.desactivarBotones();
        	swModifi=0;	
        	
        }
        
//****************************************** PROGRAMAR EL BOTON MODIFICAR *********************************************************************//
        
        if (event.getSource()==botonModificar){
        	
        	swModifi=1;
        	llenarDatos(); 
        	this.ActivarCampos();
        	this.desactivarBotones();
        }
        
//****************************************** PROGRAMAR EL BOTON GUARDAR *********************************************************************//
        
    if(event.getSource()==botonGuardar){
        
    	this.guardar();
        if (swModifi==0){
        	
        	if (listaPer.existePersonal(personal.getNumeroDocumento())){
        		
        		JOptionPane.showMessageDialog(null,"El número de documento ya existe","Gestionar Personal - S.G.P",
										      JOptionPane.OK_OPTION,icoMensajeInfor);  
        	}else{
        		if (listaPer.guardarPersonal(personal)){
        		
        			JOptionPane.showMessageDialog(null,"El registro se guardo correctamente","Gestionar Personal - S.G.P",
										          JOptionPane.OK_OPTION,icoMensajeInfor);  
	        		this.Nuevo();
	        		this.DesactivarCampos();
	        		this.activarBotones();
        		}else{
        			
        			JOptionPane.showMessageDialog(null,"El registro no fue guardado","Gestionar Personal - S.G.P",
										          JOptionPane.OK_OPTION,icoMensajeInfor); 
        		}
        	}
        	
        }else{
        	
        	int opc ;
	        opc = JOptionPane.showConfirmDialog(null,"Esta seguro que desea modificar este registro",
	        								  "Gestionar Personal - S.G.P",JOptionPane.YES_NO_OPTION,
	        								  JOptionPane.QUESTION_MESSAGE,icoMensajePre);
	        if (opc == 0) { 
	   			if (listaPer.modificarPersonal(personal)){
	        		
	        		JOptionPane.showMessageDialog(null,"El registro se modifico correctamente","Gestionar Personal - S.G.P",
										          JOptionPane.OK_OPTION,icoMensajeInfor);  
	        		this.Nuevo();
	        		this.DesactivarCampos();
	        		this.activarBotones();
	    		}else{
	        		
	        		JOptionPane.showMessageDialog(null,"El registro no fue modificado","Gestionar Personal - S.G.P",
										          JOptionPane.OK_OPTION,icoMensajeInfor);  
	    		}
	    	}	
		}
    		
    	botonGuardar.setEnabled(false);
    		
	}
    	
    	if (event.getSource()==botonLimpiar){
    		
    		this.Nuevo();
    		this.DesactivarCampos();
    		this.activarBotones();
    	}
    	
//******************************************** CODIGOBOTON CONSULTAR ******************************************************************//
    	
    	if(event.getSource()==botonConsultar){
    		
    		swModifi = 0;
 			this.llenarDatos();
			this.DesactivarCampos();
		}

//******************************************* PROGRAMAMOS EL BOTON ELIMINAR ***************************************************************//		
     	
     	if(event.getSource()==botonEliminar){
     		
    		String s=JOptionPane.showInputDialog(this,"Ingrese el número de documento del registro que desea eliminar");
	        if(listaPer.existePersonal(s)){
	        	
	            if(listaPer.eliminarPersonal(s)){
	            	
	            	JOptionPane.showMessageDialog(null,"El registro ha sido eliminado","Gestionar Personal - S.G.P",
										          JOptionPane.OK_OPTION,icoMensajeInfor); 
                	Nuevo();
                
            	}else{
            		
            		JOptionPane.showMessageDialog(null,"El registro no se pudo eliminar","Gestionar Personal - S.G.P",
										         JOptionPane.OK_OPTION,icoMensajeInfor); 
            	}
        	}else{
        		
        		JOptionPane.showMessageDialog(null,"El número de documento no existe","Gestionar Personal - S.G.P",
										     JOptionPane.OK_OPTION,icoMensajeInfor);  
        	}
    	} 
    		
    	if (event.getSource()==botonListar){
        
	       ListarPersonal lp= new ListarPersonal(listaPer.getCabeza());	
	    }
	    
	    if (event.getSource() == ComboDepar ){
	    	
	    	comboMuni.removeAllItems();
	    	vecMuni = depaMuni.cargarMunicipios(ComboDepar.getSelectedIndex());
	    	for (int j = 0; j < 125; j++){
				
				if (vecMuni[j] == null){
					
					break;
				}else{
					
					comboMuni.addItem(vecMuni[j]);
				} 
			}
	    	
	    }
	     	 
	}
      
//********************************************* METODOS PARA VALIDAR CUADROS DE TEXTO ***************************************************//
     
    public void keyPressed(KeyEvent e) {
     
   		if((e.getKeyCode() == KeyEvent.VK_ENTER)){
     		
   			Component c = (Component) e.getSource(); 
			c.transferFocus(); 	
		} 

/************************************** VALIDAMOS SI LA FECHA ES MAYOR A LA FECHA ACTUAL ************************************************/
	
		
		if (e.getSource()==textCorreo && e.getKeyCode()==KeyEvent.VK_ENTER){
			
			email = textCorreo.getText();
			
			if (!v.validarEmail(email)){  //Validamos si el correo electronico si corresponde al formato
				
				JOptionPane.showMessageDialog(null,"Este formato no es el de un email","Gestionar Personal - S.G.P",
										     JOptionPane.OK_OPTION,icoMensajeInfor);   
				textCorreo.requestFocus();
			}	
		
		}
		
		if (e.getSource()==textTipoContra && e.getKeyCode()==KeyEvent.VK_ENTER){
			
			if (textTipoContra.getText().equals("") || textNombre.getText().equals("") || textCargo.getText().equals("")){
				
				JOptionPane.showMessageDialog(null,"Digite todos los Campos Obligatorios","Gestionar Personal - S.G.P",
										     JOptionPane.OK_OPTION,icoMensajeInfor);  
				textTipoContra.requestFocus();
			}else{
				this.DesactivarCampos();
				botonGuardar.setEnabled(true);
			}
		}  
    }

    public void keyReleased(KeyEvent e) {

    } 
    	 	
  	public void keyTyped(KeyEvent e) {
	}  
	
	public void mouseClicked(MouseEvent e) {  
		
    }
    
    public void mousePressed(MouseEvent e) {
    	
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }
    
    public void propertyChange(PropertyChangeEvent evt){  
		 
    }
    
 /*   public void itemStateChanged(ItemEvent evento){
		
		if (evento.getStateChange()== ItemEvent.SELECTED ){
			int indi =  ComboDepar.getSelectedIndex(); 		
			String [] muni = new String [125];
			for (int j = 1; j < 126; j++){
				
				comboMuni.addItem(depaMuni.departamentos[indi][j]);
			} 
	
		}

	} */
	
	
//**************************************** METODOS PARA EL CRUD *****************************************************************************//

	public void guardar(){
		 
		if (radioActiva.isSelected()) {
        	
        		Esta = "Activo";            
    	}
    	if (radioInactiva.isSelected()) {
             
        	Esta = "Inactivo";
    	}
        
    	if (radioSi.isSelected()) {
        	
    		Obte = "Si";            
    	}
    	if (radioNo.isSelected()) {
         
        	Obte = "No";
    	}	
		try{

			personal = new DatosPersonal();
			personal.setTipoDoc((String)comboTipoDoc.getSelectedItem());
			personal.setNumeroDocumento(textNumDoc.getText());
			personal.setNombre(textNombre.getText());
			personal.setFechaNacimiento(dateFechaNaci.getDate());
			personal.setDepartamento((String)ComboDepar.getSelectedItem());
			personal.setMunicipio((String)comboMuni.getSelectedItem());
			personal.setTipoSangre((String)comboTipoSangre.getSelectedItem());
			personal.setRh((String)comboRh.getSelectedItem());
			personal.setEstado(Esta);
			personal.setRutaImagen(FileImagen);
			personal.setDireccion(textDireccion.getText());
			personal.setTelefono(textTel.getText());
			personal.setCorreo(textCorreo.getText());
			personal.setTelMovil(textTelMovil.getText());
			personal.setProfesion((String)comboProfesion.getSelectedItem());
			personal.setFechaTitulo(dateFechaTitulo.getDate());
			personal.setOtrosEstu(textOtrosEstudios.getText());
			personal.setObtenido(Obte);
			personal.setFechaFin(dateFechaFin.getDate());
			personal.setCargo(textCargo.getText());
			personal.setFechaContra(dateFechaContra.getDate());
			personal.setTipoContra(textTipoContra.getText());	
		}catch(Exception e){
   			System.out.println("Error al listar los datos"+e.getMessage());
   		}
	}
	
	public void llenarDatos(){
		
		int opc=-2;
		String[]opciones = { "Número de Documento","Nombre","Correo"};
		if (swModifi==1){
			
			buscarPersonal = listaPer.BuscarPersonal(JOptionPane.showInputDialog("Ingrese el número de documento del registro a modificar"));
		}else{
			
			opc = JOptionPane.showOptionDialog(null,"Seleccione la forma en que desea realizar la consulta",
												   "Consulta de Personal. Sistematización Granjas Porcícola - S.G.P.",JOptionPane.YES_NO_CANCEL_OPTION,
												   JOptionPane.QUESTION_MESSAGE,icoMensajePre,opciones,true);									   
			switch (opc){
				
				case 0:
					buscarPersonal = listaPer.BuscarPersonal(JOptionPane.showInputDialog("Ingrese el número de documento del personal a consultar"));
					break;
				case 1:
					buscarPersonal = listaPer.BuscarPersonalNombre(JOptionPane.showInputDialog("Ingrese el nombre del personal a consultar"));
					break;
				case 2:
					buscarPersonal = listaPer.BuscarPersonalCorreo(JOptionPane.showInputDialog("Ingrese el correo del personal a consultar"));
					break;
			}
		}
		if (opc != -1){
		
			if (buscarPersonal!= null){
				
				comboTipoDoc.setSelectedItem(buscarPersonal.getTipoDoc());
				textNumDoc.setText(buscarPersonal.getNumeroDocumento());
				textNombre.setText(buscarPersonal.getNombre());
				dateFechaNaci.setDate(buscarPersonal.getFechaNacimiento());
				ComboDepar.setSelectedItem(buscarPersonal.getDepartamento());
				comboMuni.setSelectedItem(buscarPersonal.getMunicipio());
				comboTipoSangre.setSelectedItem(buscarPersonal.getTipoSangre());
				comboRh.setSelectedItem(buscarPersonal.getRh());
				if (buscarPersonal.getEstado().equals("Activo")){
	   				
	   				radioActiva.setSelected(true);
	   			}
	   			if (buscarPersonal.getEstado().equals("Inactivo")){
	   				
	   				radioInactiva.setSelected(true);
	   			}
	   			FileImag= buscarPersonal.getRutaImagen();
	   			try
				{
	   				cargarImagen(DPanelFoto,FileImag); 
				}
				catch (Exception e)
				{
					System.out.println("No cargó imagen");
					JOptionPane.showMessageDialog(this.getContentPane(),"Error No Cargó La Imagen","Error S.G.P.",JOptionPane.ERROR_MESSAGE);
				}
				textDireccion.setText(buscarPersonal.getDireccion());
				textTel.setText(buscarPersonal.getTelefono());
				textCorreo.setText(buscarPersonal.getCorreo());
				textTelMovil.setText(buscarPersonal.getTelMovil());
				comboProfesion.setSelectedItem(buscarPersonal.getProfesion());
				dateFechaTitulo.setDate(buscarPersonal.getFechaTitulo());
				textOtrosEstudios.setText(buscarPersonal.getOtrosEstu());
				if (buscarPersonal.getObtenido().equals("Si")){
	   				radioSi.setSelected(true);
	   			}
	   			if (buscarPersonal.getObtenido().equals("No")){
	   				radioNo.setSelected(true);
	   			}
	   			dateFechaFin.setDate(buscarPersonal.getFechaFin());
	   			textCargo.setText(buscarPersonal.getCargo());
	   			dateFechaContra.setDate(buscarPersonal.getFechaContra());
	   			textTipoContra.setText(buscarPersonal.getTipoContra());
			}else{
				
				JOptionPane.showMessageDialog(null,"El registro no existe","Gestionar Personal - S.G.P",
										     JOptionPane.OK_OPTION,icoMensajeInfor); 
			}
		}else{
			
			JOptionPane.showMessageDialog(null,"Se cancelo la consulta","Gestionar Personal - S.G.P",
										 JOptionPane.OK_OPTION,icoMensajeInfor); 
		}
		buscarPersonal = null;
	}	
   	
   	public void DesactivarCampos (){
   	
   		comboTipoDoc.setEnabled(false);
   		textNumDoc.setEnabled(false);
   		textNombre.setEnabled(false);
   		dateFechaNaci.setEnabled(false);
   		ComboDepar.setEnabled(false);
   		comboMuni.setEnabled(false);
   		comboTipoSangre.setEnabled(false);
   		comboRh.setEnabled(false);
   		DPanelFoto.setEnabled(false);
   		radioActiva.setEnabled(false);
   		radioInactiva.setEnabled(false);
   		botonImagen.setEnabled(false);
   		textDireccion.setEnabled(false);
   		textTel.setEnabled(false);
   		textTelMovil.setEnabled(false);
   		textCorreo.setEnabled(false);
   		comboProfesion.setEnabled(false);
   		botonMas.setEnabled(false);
   		dateFechaTitulo.setEnabled(false);
   		textOtrosEstudios.setEnabled(false);
   		radioSi.setEnabled(false);
   		radioNo.setEnabled(false);
   		dateFechaFin.setEnabled(false);
   		textCargo.setEnabled(false);
   		dateFechaContra.setEnabled(false);
   		textTipoContra.setEnabled(false);   	
   	
   	}
   	
   	public void ActivarCampos (){
   	
   		//comboTipoDoc.setEnabled(true);
   		//textNumDoc.setEnabled(true);
   		textNombre.setEnabled(true);
   		dateFechaNaci.setEnabled(true);
   		ComboDepar.setEnabled(true);
   		comboMuni.setEnabled(true);
   		comboTipoSangre.setEnabled(true);
   		comboRh.setEnabled(true);
   		DPanelFoto.setEnabled(true);
   		radioActiva.setEnabled(true);
   		radioInactiva.setEnabled(true);
   		botonImagen.setEnabled(true);
   		textDireccion.setEnabled(true);
   		textTel.setEnabled(true);
   		textTelMovil.setEnabled(true);
   		textCorreo.setEnabled(true);
   		comboProfesion.setEnabled(true);
   		botonMas.setEnabled(true);
   		dateFechaTitulo.setEnabled(true);
   		textOtrosEstudios.setEnabled(true);
   		radioSi.setEnabled(true);
   		radioNo.setEnabled(true);
   		dateFechaFin.setEnabled(true);
   		textCargo.setEnabled(true);
   		dateFechaContra.setEnabled(true);
   		textTipoContra.setEnabled(true);   	
   	
   	}
   	
   	 public void Nuevo(){
   	 	
   	 	FileIma = new File ( "Imagenes\\Foto.jpg");
   		comboTipoDoc.setSelectedItem(null);
		textNumDoc.setText("");
		textNombre.setText("");
		dateFechaNaci.setDate(null); 
		comboMuni.setSelectedItem(null);
		comboTipoSangre.setSelectedItem(null);
		comboRh.setSelectedItem(null); 
		GrupoEstado.clearSelection();	
		cargarImagen(DPanelFoto,FileIma);
		textDireccion.setText("");
		textTel.setText("");
		textTelMovil.setText("");
		textCorreo.setText("");
		comboProfesion.setSelectedItem(null);
		dateFechaTitulo.setDate(null);
		textOtrosEstudios.setText("");
		dateFechaFin.setDate(null);
		GrupoObtenido.clearSelection();
		textCargo.setText("");
		dateFechaContra.setDate(null);
		textTipoContra.setText(""); 
	}
    
    public  void cargarImagen(javax.swing.JDesktopPane jDeskp,File fileImagen){
    	
		try
		{
			BufferedImage image = ImageIO.read(fileImagen);
			jDeskp.setBorder(new PintaImagen(image));
		}
		catch (Exception e)
		{
			System.out.println("No cargó imagen");
			JOptionPane.showMessageDialog(this.getContentPane(),"Error No Cargó La Imagen","Error S.G.P.",JOptionPane.ERROR_MESSAGE);
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
	
		
    public void ValidarCamposPersonal() {
        this.textNumDoc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent e) {
                v.validarLongitud(10, textNumDoc, e);
                v.SoloNumeros(textNumDoc, e);
                v.Obligatorios(textNumDoc,e);
            }
        });

        this.textTel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent e) {
              v.validarLongitud(7, textTel, e);
              v.SoloNumeros(textTel, e);
              v.Obligatorios(textTel, e);
            }
        });
        this.textTelMovil.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent e) {
                v.validarLongitud(10, textTelMovil, e);
                v.SoloNumeros(textTelMovil, e);
                v.Obligatorios(textTelMovil, e);
            }
        });
        this.textNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent e) {
                v.validarLongitud(40, textNombre, e);
                v.SoloLetras(textNombre, e);
                v.Obligatorios(textNombre,e);
            }
        });
        this.textOtrosEstudios.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent e) {
                v.validarLongitud(50, textOtrosEstudios, e);
                v.SoloLetras(textOtrosEstudios, e);
            }
        });
        this.textCargo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent e) {
                v.validarLongitud(40, textCargo, e);
                v.SoloLetras(textCargo, e);
            }
        });
        this.textTipoContra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent e) {
                v.validarLongitud(50, textTipoContra, e);
                v.SoloLetras(textTipoContra, e);
            }
        });
        
        this.textCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent e) {
            	
            	v.validarLongitud(35, textCorreo, e);
            }
        });
        
    /*    ComboDepar.addItemListener(new ItemListener(){ 
	   		public void itemStateChanged(ItemEvent evento){
		
				if (evento.getStateChange()== ItemEvent.SELECTED ){
					int indi =  ComboDepar.getSelectedIndex(); 		
					String [] muni = new String [125];
					for (int j = 1; j < 126; j++){
						
						comboMuni.addItem(depaMuni.departamentos[indi][j]);
					} 
	 		
				}
		
			} 
		}); */
        
    	 

    } 
}