	
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import Utilidades.*;  
import java.util.Date;
import java.util.Calendar;
import java.beans.*;
import java.text.*;
import logica.*;
import listas.*;
import nodos.*;
import com.toedter.calendar.JDateChooser;

public class GestionarAnimal extends JFrame implements ActionListener, KeyListener,MouseListener {
	
//***************** DECLARACION DE LA PAGINA MULTIPLE Y LOS CAMPOS DE LA PESTAÑA IDENTIFICACION *********************************************************************************************************************//	
	
	String Estad, TipoPor;	 
	JTabbedPane TabPestaAnimal;
	JPanel panelAnimal, panelProcedencia, panelPeso, panelDatosParto;
	JLabel labelCodAnimal, labelRaza, labelSexo, labelEstado, labelFechaNaci, labelEdad, labelSemanas,  labelDestete, labelKg, labelKg1;
	JLabel labelFechaDeste, labelFechaConsu, labelCodParto, labelCodMadre, labelFechaParto, labelProcedencia, labelNacer;
	JLabel labelEdadMadre, labelSemanaas,labelRazaMadre, labelRazaPadre, labelSemanas1, labelFondo,labelFondoPar;
	JTextField textCodAnimal, textEdad, textEstado,  textNacer, textDestete, textCodParto, textCodMadre,textEdadMadre;
	JComboBox comboRaza, comboSexo,comboProcedencia, comboRazaPadre, comboRazaMadre;
	JButton botonCrear, botonGuardar, botonModificar, botonConsultar, botonEliminar, botonSalir, botonSalir1;
	JButton botonMas,botonLimpiar ,botonListar;
	ButtonGroup GrupoEstado, GrupoTipoPor;
	ImageIcon iconFondoR,icoCalendario;
	Image icoCabecera;
	JRadioButton radioWilbur, radioOtra, radioVivo, radioMuerto, radioEngorde, radioReemplazo;
	DateComboBox comboFechaNaci, comboFechaDestete, comboFechaConsuAlimento, comboFechaParto;
	JDateChooser dateFechaNaci, dateFechaDestete, dateFechaConsuAlimento, dateFechaParto;
	TitledBorder rotulo1, rotulo2, rotulo3;
	int swModifiDatos=0,Indice;
	boolean valiFecha;
	DatosAnimal animal, buscarAnimal;
	ListaAnimales listaAni;
	
//********************************-*************** DECLARACION DE LOS OBJETOS DE LA PESTAÑA HISTORIAL CLINICO ************************************************************************************//	
	
	JLabel labelCodAnimalHcli, labelRazaHcli, labelEdadHcli, labelSemanasHcli, labelEstadoHcli, labelSexoHcli, labelPesoHcli,  labelKgHcli, labelNomVacunaHcli, labelNumDosisHcli;
	JLabel labelAplicacionHcli, labelEdad1Hcli, labelSemanas1Hcli, labelFechaVacuHcli, labelNomInfeHcli, labelTrataHcli, labelFechaInicioHcli, labelFechaFinalHcli;
	JLabel labelFrecuenciaHcli, labelAplicacion1Hcli,labelTemperaHcli, labelEdad2Hcli, labelSemanas2Hcli, labelFechaMuerteHcli, labelDiagHcli, labelMuerteHcli;
	JTextField textCodAnimalHcli, textRazaHcli, textEdadHcli, textEstadoHcli, textSexoHcli, textPesoHcli, textNumDosisHcli, textAplicacionHcli, textEdad1Hcli;
	JTextField textTrataHcli, textFrecuenciaHcli, textAplicacion1Hcli, textTemperaHcli, textEdad2Hcli, textSemanas2Hcli, textDiagHcli;
	JPanel panelHistorial, panelVacunas, panelAgentes;
	TitledBorder rotulo4,rotulo5;
	JButton  botonRegistrarHcli, botonRegistrar1Hcli;
	JRadioButton radioSiHcli, radioNoHcli;
	JComboBox comboNomVacunaHcli, comboNomInfeccHcli;
	DateComboBox comboFechaVacunaHcli, comboFechaInicioHcli, comboFechaFinalHcli, comboFechaMuerteHcli;
	
//********************************************* DECLARACION DE LOS OBJETOS DE LA PESTAÑA PARTOS **************************************************************************************//
	
	JLabel labelCodPartoPar, labelFechaPartoPar, labelCodMadrePar, labelRazaPar,labelRazaPadrePar, labelEdadPar, labelSemanasPar, labelVivosPar, labelMuertosPar, labelCamadaPar;
	JTextField textCodPartoPar, textCodMadrePar, textEdadPar, textVivosPar, textMuertosPar, textCamadaPar;
	DateComboBox comboFechaPartoPar;
	JDateChooser dateFechaPartPar;
	JComboBox comboRazaMadrePar,comboRazaPadrePar;
	JPanel panelIdenMadre, panelLechones, panelPartos;
	TitledBorder rotulo7, rotulo8;
	Date Nacimiento= new Date();
	public DatosPartos parto, buscarParto;
	ListaPartos listaPar;
	Validaciones v = new Validaciones(); 
	String Codp;
	int swModPartos=0,IndicePar;
	JButton botonListarPar;

//********************************************** DECLARACION DE OBJETOS DE LA PESTAÑA MORTALIDAD ************************************************************//
	
	JLabel labelDesdeMor, labelHastaMor, labelTotalPartosMor, labelTotalVivosMor, labelTotalMuertosMor, labelMuertosenParMor, labelMuertosenProMor;
	JTextField textCodPartoMor, textCodMadreMor, textTotalPartosMor, textTotalVivosMor, textTotalMuertosMor, textMuertosenParMor, textMuertosenProMor;
	JCheckBox checkCodPartoMor, checkCodMadreMor, checkFechaPartoMor, checkRangoMor;
	DateComboBox comboFechaPartoMor, comboFechaDesdeMor, comboFechaHastaMor;
	JPanel panelTipoConsultaMor, panelMortalidad;
	TitledBorder rotulo9;
	JButton  botonImprimirMor, botonLimpiarMor;
	JTable tableMortalidadMor;
	JScrollPane paneTablaMortalidadMor;
	private Object[][] datos = new Object[20][20];
    private Object[] columnas = {"Código Parto", "Código Madre", "Fecha Parto", "Lechones Vivos", "Lechones Muertos", "Tipo Muerte"};
    private DefaultTableModel dataModel = new DefaultTableModel(datos, columnas);
	
//*******************************************DECLARACION DE OBJETOS DE LA PESTAÑA ALIMENTO ETAPAS ********************************************************************************//
	
	JLabel labelCodAnimalEta, labelRazaEta, labelEdadEta, labelSemanasEta, labelEstadoEta, labelSexoEta, labelPesoEta, labelKgEta, labelEtapaActualEta;
	JLabel labelAliSemaEta, labelAliDiaEta, labelJaulaEta, labelKg1Eta; 
	JTextField textCodAnimalEta, textRazaEta, textEdadEta, textEstadoEta, textSexoEta, textPesoEta, textEtapaActualEta;
	JTextField textAliSemaEta, textAliDiaEta, textJaulaEta;
	JPanel panelEtapa, panelEtapaDesaEta;
	TitledBorder rotulo10;
	JButton botonLimpiarEta;
	
	ImageIcon icoGuardar, icoCrear, icoModificar, icoBuscar, icoEliminar, icoSalir, iconFondo,icoLimpiar,icoMas,icoListar;
	ImageIcon icoMensajeInfor, icoMensajePre;
	
//******************************************* VECTORES PARA EL CRUD ****************************************************************//

	MatDatosAnimales mat;
	Vector DatosAnimal, NomColumnas; 
	JTable TablaGuardar;
    DefaultTableModel ModeloDatos;
    JScrollPane barraAnimal;
	

//******************************* CODIGO PARA CREAR EL FORMULARIO CON SUS CAMPOS **********************************************//s
	
    public GestionarAnimal(ListaAnimales listaAnima, ListaPartos listaParto) {
    	
    	
    	super("Gestionar Animal ");
        getContentPane().setLayout(null);
        setSize(735,720);
        setResizable(false);
        setLocation(350, 10);
        icoCabecera=Toolkit.getDefaultToolkit().getImage("Imagenes\\FondoPar.jpg");
        setIconImage(icoCabecera);
        setVisible(true);
        this.getContentPane().setBackground(Color.white);
        
 //**************************** CODIGO PARA CREAR LA PAGINA MULTIPLE*********************************************************//       
        
        TabPestaAnimal = new JTabbedPane();
        TabPestaAnimal.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
       	TabPestaAnimal.setBounds(55,10,620,625);
       	this.getContentPane().add(TabPestaAnimal);
       	
 //**************************** CODIGO PARA CREAR CADA PESTAÑA IDENTIFICACION DEL ANIMAL Y SUS CAMPOS DE LA PAGINA MULTIPLE ***************************//      	
         
        panelAnimal = new JPanel();
        panelAnimal.setLayout(null);
        panelAnimal.setVisible(true);
        panelAnimal.setBackground(Color.white);
        TabPestaAnimal.addTab("Identificación del Animal",panelAnimal);
        
        
      /*  panelProcedencia = new JPanel();

        rotulo1 = BorderFactory.createTitledBorder("Procedencia del Animal");
        panelProcedencia.setBorder(rotulo1);
        panelProcedencia.setLayout(null);
        panelProcedencia.setBounds(5, 15, 605, 70);
        panelProcedencia.setBackground(Color.lightGray); 
        panelAnimal.add(panelProcedencia);
        panelProcedencia.setBackground(Color.white);
        panelProcedencia.setVisible(true);
        
        radioWilbur = new JRadioButton("Granja Wilbur", false);
        add(radioWilbur);
        radioWilbur.setBounds(15, 25, 110, 25);
        panelProcedencia.add(radioWilbur);
        radioWilbur.setVisible(true);
        
        radioOtra = new JRadioButton("Otra Granja", false);
        add(radioOtra);
        radioOtra.setBounds(355, 25, 110, 25);
        panelProcedencia.add(radioOtra);
        radioOtra.setVisible(true);*/
        
        labelProcedencia = new JLabel("*Procedencia:");
        labelProcedencia.setBounds (25, 45, 180, 25); 
        panelAnimal.add(labelProcedencia);        
        labelProcedencia.setVisible(true);
        
        comboProcedencia = new JComboBox();
        comboProcedencia.addItem("GRANJA WILBUR");
        comboProcedencia.addItem("GRANJA DEL SENA");
        comboProcedencia.setBounds(140,45, 400, 25); 
        panelAnimal.add(comboProcedencia);
        comboProcedencia.addMouseListener(this);
        comboProcedencia.addKeyListener(this);
        comboProcedencia.setVisible(true);
        
        icoMas = new ImageIcon("Imagenes\\Mas.jpg");
        botonMas = new JButton(icoMas);
        botonMas.setBounds(550, 45, 50, 25);
        panelAnimal.add(botonMas); 
        botonMas.setVisible(true);
        botonMas.addActionListener(this);
        
        labelCodAnimal = new JLabel("*Código del Animal:");
        labelCodAnimal.setBounds (25, 85, 180, 25); 
        panelAnimal.add(labelCodAnimal);        
        labelCodAnimal.setVisible(true);
        
        textCodAnimal = new JTextField("");
        textCodAnimal.setBounds(140,85, 100, 25); 
        panelAnimal.add(textCodAnimal);
        textCodAnimal.addKeyListener(this);    
        textCodAnimal.setVisible(true);
        
        labelRaza = new JLabel("*Raza: ");
        labelRaza.setBounds(325, 85, 180, 25); 
        panelAnimal.add(labelRaza);
        labelRaza.setVisible(true);
        
        comboRaza = new JComboBox();
        comboRaza.addItem("HAMPSHIRE");
        comboRaza.addItem("DUROC");
        comboRaza.addItem("PIETRAIN");
        comboRaza.addItem("LANDRACE");
        comboRaza.addItem("YORKSHIRE");
        comboRaza.setBounds(390,85, 150, 25); 
        panelAnimal.add(comboRaza);
        comboRaza.setVisible(true);
        comboRaza.addKeyListener(this);
        
        labelSexo = new JLabel("*Sexo:");
        labelSexo.setBounds(25, 125, 150, 25); 
        panelAnimal.add(labelSexo);
        labelSexo.setVisible(true);
        
        comboSexo = new JComboBox();
        comboSexo.addItem("Hembra");
        comboSexo.addItem("Macho");
        comboSexo.setBounds(140,125, 100, 25); 
        panelAnimal.add(comboSexo);
        comboSexo.addKeyListener(this);
        comboSexo.setVisible(true);
        
        labelEstado = new JLabel("*Estado:");
        labelEstado.setBounds(325, 125, 150, 25); 
        panelAnimal.add(labelEstado);
        labelEstado.setVisible(true);
        
        radioVivo = new JRadioButton("Vivo", false);
        radioVivo.setBounds(390, 125, 80, 25);
        panelAnimal.add(radioVivo);
        radioVivo.setBackground(Color.white);
        radioVivo.setVisible(true);
        
        radioMuerto = new JRadioButton("Muerto", false);
        radioMuerto.setBounds(470, 125, 70, 25);
        panelAnimal.add(radioMuerto);
        radioMuerto.setBackground(Color.white);
        radioMuerto.setVisible(true);
        
        GrupoEstado = new ButtonGroup ();
        GrupoEstado.add(radioVivo);
        GrupoEstado.add(radioMuerto);
        
        labelFechaNaci = new JLabel("*Fecha Nacimiento:");
        labelFechaNaci.setBounds(25, 165, 150, 25); 
        panelAnimal.add(labelFechaNaci);
        labelFechaNaci.setVisible(true); 
        
        
    	icoCalendario = new ImageIcon("Imagenes\\iconoCalendario.jpg");
        dateFechaNaci = new JDateChooser();
        dateFechaNaci.setIcon(icoCalendario);
		dateFechaNaci.setBounds( 140, 165, 120, 25 );
		panelAnimal.add(dateFechaNaci);
		dateFechaNaci.addKeyListener(this);
//		dateFechaNaci.getDateEditor().getUiComponent().addPropertyChangeListener(this);
		dateFechaNaci.getDateEditor().getUiComponent().addMouseListener(this);
        
        labelEdad = new JLabel("Edad: ");
        labelEdad.setBounds(325, 165, 100, 25); 
        panelAnimal.add(labelEdad);
        labelEdad.setVisible(true);
        
        textEdad = new JTextField("");
        textEdad.setBounds(390, 165, 50, 25); 
        panelAnimal.add(textEdad);
        textEdad.addKeyListener(this);
        textEdad.setVisible(true);
        
        labelSemanas = new JLabel("Semanas ");
        labelSemanas.setBounds(442, 165, 180, 25); 
        panelAnimal.add(labelSemanas);
        labelSemanas.setVisible(true);
        
        panelPeso = new JPanel();

        rotulo2 = BorderFactory.createTitledBorder("Peso del Animal");
        panelPeso.setBorder(rotulo2);
        panelPeso.setLayout(null);
        panelPeso.setBounds(5, 210, 605, 60);  
        panelAnimal.add(panelPeso);
        panelPeso.setBackground(Color.white);
        panelPeso.setVisible(true);
        
        labelNacer = new JLabel("*Al Nacer: ");
        labelNacer.setBounds(25, 25, 100, 25); 
        panelPeso.add(labelNacer);
        labelNacer.setVisible(true);
        
        textNacer = new JTextField("");
        textNacer.setBounds(135, 25, 50, 25); 
        panelPeso.add(textNacer);
        textNacer.addKeyListener(this);
        textNacer.setVisible(true);
        
        labelKg = new JLabel("Kg. ");
        labelKg.setBounds(187, 25, 180, 25); 
        panelPeso.add(labelKg);
        labelKg.setVisible(true);
        
        labelDestete = new JLabel("*Al Destete: ");
        labelDestete.setBounds(335, 25, 100, 25); 
        panelPeso.add(labelDestete);
        labelDestete.setVisible(true);
        
        textDestete = new JTextField("");
        textDestete.setBounds(480, 25, 50, 25); 
        panelPeso.add(textDestete);
        textDestete.addKeyListener(this);
        textDestete.setVisible(true);
        
        labelKg1 = new JLabel("Kg. ");
        labelKg1.setBounds(532, 25, 180, 25); 
        panelPeso.add(labelKg1);
        labelKg1.setVisible(true);
        
        labelFechaDeste = new JLabel("Fecha del Destete: ");
        labelFechaDeste.setBounds(25, 285, 180, 25);
        panelAnimal.add(labelFechaDeste); 
        labelFechaDeste.setVisible(true); 
        
        dateFechaDestete = new JDateChooser();
        dateFechaDestete.setIcon(icoCalendario);
		dateFechaDestete.setBounds( 140, 285, 120, 25 );
		panelAnimal.add(dateFechaDestete);
		dateFechaDestete.addKeyListener(this);
		dateFechaDestete.getDateEditor().getUiComponent().addMouseListener(this);
        
        labelFechaConsu = new JLabel("Fecha Ultimo Alimento:");
        labelFechaConsu.setBounds(325, 285, 180, 25);
        panelAnimal.add(labelFechaConsu); 
        labelFechaConsu.setVisible(true); 
        
        dateFechaConsuAlimento = new JDateChooser();
        dateFechaConsuAlimento.setIcon(icoCalendario);
		dateFechaConsuAlimento.setBounds( 460, 285, 120, 25 );
		panelAnimal.add(dateFechaConsuAlimento);
		dateFechaConsuAlimento.addKeyListener(this);
		dateFechaConsuAlimento.getDateEditor().getUiComponent().addMouseListener(this);
        
        JPanel panelDatosParto = new JPanel();

        rotulo3 = BorderFactory.createTitledBorder("Datos del Parto");
        panelDatosParto.setBorder(rotulo3);
        panelDatosParto.setLayout(null);
        panelDatosParto.setBounds(5, 320, 605, 150);
        panelDatosParto.setVisible(true);
        panelDatosParto.setBackground(Color.white);
        panelAnimal.add(panelDatosParto);
        
        labelCodParto = new JLabel("*Código Parto:");
        labelCodParto.setBounds(25, 25, 180, 25); 
        panelDatosParto.add(labelCodParto);
        labelCodParto.setVisible(true);
        
        textCodParto = new JTextField("");
        textCodParto.setBounds(135, 25, 100, 25); 
        panelDatosParto.add(textCodParto);
        textCodParto.addKeyListener(this);
        textCodParto.setVisible(true);
        
        labelFechaParto = new JLabel("*Fecha Parto: ");
        labelFechaParto.setBounds(325, 25, 180, 25); 
        panelDatosParto.add(labelFechaParto);
        labelFechaParto.setVisible(true); 
        
        dateFechaParto = new JDateChooser();
        dateFechaParto.setIcon(icoCalendario);
		dateFechaParto.setBounds( 460, 25, 120, 25 );
		panelDatosParto.add(dateFechaParto);
		dateFechaParto.addKeyListener(this);
		dateFechaParto.getDateEditor().getUiComponent().addMouseListener(this);
        
        labelCodMadre = new JLabel("*Código Madre:");
        labelCodMadre.setBounds(25, 65, 180, 25); 
        panelDatosParto.add(labelCodMadre);
        labelCodMadre.setVisible(true);
        
        textCodMadre = new JTextField("");
        textCodMadre.setBounds(135, 65, 100, 25); 
        panelDatosParto.add(textCodMadre);
        textCodMadre.addKeyListener(this);
        textCodMadre.setVisible(true);
        
        labelEdadMadre = new JLabel("Edad Madre: ");
        labelEdadMadre.setBounds(325, 65, 180, 25); 
        panelDatosParto.add(labelEdadMadre);
        labelEdadMadre.setVisible(true);
        
        textEdadMadre = new JTextField("");
        textEdadMadre.setBounds(460, 65, 50, 25); 
        panelDatosParto.add(textEdadMadre);
        textEdadMadre.addKeyListener(this);
        textEdadMadre.setVisible(true);
        
        labelSemanas1 = new JLabel("Semanas ");
        labelSemanas1.setBounds(512, 65, 180, 25);
        this.getContentPane().add(labelSemanas1);
        panelDatosParto.add(labelSemanas1);
        labelSemanas1.setVisible(true);
        
        labelRazaMadre = new JLabel("Raza Madre:");
        labelRazaMadre.setBounds(25, 105, 180, 25); 
        panelDatosParto.add(labelRazaMadre);
        labelRazaMadre.setVisible(true);
        
        comboRazaMadre = new JComboBox();
        comboRazaMadre.addItem("HAMPSHIRE");
        comboRazaMadre.addItem("DUROC");
        comboRazaMadre.addItem("PIETRAIN");
        comboRazaMadre.addItem("LANDRACE");
        comboRazaMadre.addItem("YORKSHIRE");
        comboRazaMadre.setBounds(135,105, 120, 25); 
        panelDatosParto.add(comboRazaMadre);
        comboRazaMadre.addKeyListener(this);
        comboRazaMadre.setVisible(true);
        
        labelRazaPadre = new JLabel("Raza Padre: ");
        labelRazaPadre.setBounds(325, 105, 180, 25); 
        panelDatosParto.add(labelRazaPadre);
        labelRazaPadre.setVisible(true);
        
        comboRazaPadre = new JComboBox();
        comboRazaPadre.addItem("HAMPSHIRE");
        comboRazaPadre.addItem("DUROC");
        comboRazaPadre.addItem("PIETRAIN");
        comboRazaPadre.addItem("LANDRACE");
        comboRazaPadre.addItem("YORKSHIRE");
        comboRazaPadre.setBounds(460,105, 120, 25); 
        panelDatosParto.add(comboRazaPadre);
        comboRazaPadre.addKeyListener(this);
        comboRazaPadre.setVisible(true);
        
        radioEngorde = new JRadioButton("*Animal de Engorde", false);
        add(radioEngorde);
        radioEngorde.setBounds(140, 470, 150, 25);
        panelAnimal.add(radioEngorde);
        radioEngorde.setBackground(Color.white);
        radioEngorde.addKeyListener(this);
        radioEngorde.addMouseListener(this);
        radioEngorde.setVisible(true);
        
        radioReemplazo = new JRadioButton("*Animal de Reemplazo", false);
        add(radioReemplazo);
        radioReemplazo.setBounds(325, 470, 160, 25);
        panelAnimal.add(radioReemplazo);
        radioReemplazo.setBackground(Color.white);
        radioReemplazo.addKeyListener(this);
        radioReemplazo.addMouseListener(this);
        radioReemplazo.setVisible(true);
        
        GrupoTipoPor = new ButtonGroup ();
        GrupoTipoPor.add(radioEngorde);
        GrupoTipoPor.add(radioReemplazo);
        
        
        iconFondoR = new ImageIcon("Imagenes\\CERDO6.jpg");
        labelFondo = new JLabel(iconFondoR);
        labelFondo.setBounds(445, 470, 200, 125);
        panelAnimal.add(labelFondo);
        setVisible(true);
        
//******************************************* CODIGO PARA CREAR LA PESTAÑA DE HISTORIAL CLINICO Y SUS OBJETOS *****************************************//        

        panelHistorial = new JPanel();
        TabPestaAnimal.addTab( "Historial Clínico", panelHistorial);
        panelHistorial.setLayout(null);
        panelHistorial.setBackground(Color.white);
        setVisible( true );
        
        labelCodAnimalHcli = new JLabel("Código del Animal:");
        labelCodAnimalHcli.setBounds (10, 15, 180, 25); 
        panelHistorial.add(labelCodAnimalHcli);        
        labelCodAnimalHcli.setVisible(true);
        
        textCodAnimalHcli = new JTextField("");
        textCodAnimalHcli.setBounds(118,15, 100, 25); 
        panelHistorial.add(textCodAnimalHcli);    
        textCodAnimalHcli.setVisible(true);
        
        labelSexoHcli = new JLabel("Sexo:");
        labelSexoHcli.setBounds(250, 15, 150, 25); 
        panelHistorial.add(labelSexoHcli);
        labelSexoHcli.setVisible(true);
        
        textSexoHcli = new JTextField("");
        textSexoHcli.setBounds(288,15, 100, 25); 
        panelHistorial.add(textSexoHcli);    
        textSexoHcli.setVisible(true);
        textSexoHcli.setEnabled(false);
        
        
        labelRazaHcli = new JLabel("Raza: ");
        labelRazaHcli.setBounds(413, 15, 180, 25); 
        panelHistorial.add(labelRazaHcli);
        labelRazaHcli.setVisible(true);
        
        textRazaHcli = new JTextField("");
        textRazaHcli.setBounds(460,15, 150, 25); 
        panelHistorial.add(textRazaHcli);    
        textRazaHcli.setVisible(true);
        textRazaHcli.setEnabled(false); 
        
        labelEdadHcli = new JLabel("Edad: ");
        labelEdadHcli.setBounds(10, 55, 100, 25); 
        panelHistorial.add(labelEdadHcli);
        labelEdadHcli.setVisible(true);
        
        textEdadHcli = new JTextField("");
        textEdadHcli.setBounds(118, 55, 50, 25); 
        panelHistorial.add(textEdadHcli);
        textEdadHcli.setVisible(true);
        textEdadHcli.setEnabled(false);
        
        labelSemanasHcli = new JLabel("Semanas ");
        labelSemanasHcli.setBounds(170, 55, 180, 25); 
        panelHistorial.add(labelSemanasHcli);
        labelSemanasHcli.setVisible(true);
        
        labelPesoHcli = new JLabel("Peso: ");
        labelPesoHcli.setBounds(250, 55, 100, 25); 
        panelHistorial.add(labelPesoHcli);
        labelPesoHcli.setVisible(true);
        
        textPesoHcli = new JTextField("");
        textPesoHcli.setBounds(288, 55, 50, 25); 
        panelHistorial.add(textPesoHcli);
        textPesoHcli.setVisible(true);
        textPesoHcli.setEnabled(false);
        
        labelKgHcli = new JLabel("Kg. ");
        labelKgHcli.setBounds(340, 55, 180, 25); 
        panelHistorial.add(labelKgHcli);
        labelKgHcli.setVisible(true);
        
        labelEstadoHcli = new JLabel("Estado:");
        labelEstadoHcli.setBounds(413, 55, 150, 25); 
        panelHistorial.add(labelEstadoHcli);
        labelEstadoHcli.setVisible(true);
        
        textEstadoHcli = new JTextField("");
        textEstadoHcli.setBounds(460,55, 100, 25); 
        panelHistorial.add(textEstadoHcli);    
        textEstadoHcli.setVisible(true);
        textEstadoHcli.setEnabled(false); 
        
        
        JPanel panelVacunas = new JPanel();

        rotulo4 = BorderFactory.createTitledBorder("Vacunas");
        panelVacunas.setBorder(rotulo4);
        panelVacunas.setLayout(null);
        panelVacunas.setBounds(5, 85, 605, 140);
        panelVacunas.setVisible(true);
        panelVacunas.setBackground(Color.white);
        panelHistorial.add(panelVacunas);
        
        labelNomVacunaHcli = new JLabel("Nombre de la Vacuna: ");
        labelNomVacunaHcli.setBounds(25, 25, 200, 25); 
        panelVacunas.add(labelNomVacunaHcli);
        labelNomVacunaHcli.setVisible(true);
        
        comboNomVacunaHcli = new JComboBox();
        comboNomVacunaHcli.addItem("");
        comboNomVacunaHcli.setBounds(155, 25, 250, 25);
        panelVacunas.add(comboNomVacunaHcli);
        comboNomVacunaHcli.setVisible(true);
        
        labelNumDosisHcli = new JLabel("Número Dosis:");
        labelNumDosisHcli.setBounds(445, 25, 150, 25);
        panelVacunas.add(labelNumDosisHcli);
        labelNumDosisHcli.setVisible(true);
        
        textNumDosisHcli = new JTextField("");
        textNumDosisHcli.setBounds(535, 25, 50, 25);
        panelVacunas.add(textNumDosisHcli);
        textNumDosisHcli.setVisible(true);
        
        labelAplicacionHcli = new JLabel("Aplicación: ");
        labelAplicacionHcli.setBounds(25, 65, 250, 25);
        panelVacunas.add(labelAplicacionHcli);
        labelAplicacionHcli.setVisible(true);
        
        textAplicacionHcli = new JTextField("");
        textAplicacionHcli.setBounds(155, 65, 200, 25);
        panelVacunas.add(textAplicacionHcli);
        textAplicacionHcli.setVisible(true);
        textAplicacionHcli.setEnabled(false);
        
        /*labelEdad1Hcli = new JLabel("Edad: ");
        labelEdad1Hcli.setBounds(25, 105, 100, 25); 
        panelVacunas.add(labelEdad1Hcli);
        labelEdad1Hcli.setVisible(true);
        
        textEdad1Hcli = new JTextField("");
        textEdad1Hcli.setBounds(155, 105, 50, 25); 
        panelVacunas.add(textEdad1Hcli);
        textEdad1Hcli.setVisible(true);
        
        labelSemanas1Hcli = new JLabel("Semanas ");
        labelSemanas1Hcli.setBounds(207, 105, 180, 25); 
        panelVacunas.add(labelSemanas1Hcli);
        labelSemanas1Hcli.setVisible(true);*/
        
        labelFechaVacuHcli = new JLabel("Fecha Vacuna:");
        labelFechaVacuHcli.setBounds(375, 65, 150, 25); 
        panelVacunas.add(labelFechaVacuHcli);
        labelFechaVacuHcli.setVisible(true);
        
        comboFechaVacunaHcli=new DateComboBox();
        comboFechaVacunaHcli.setBounds(465,65, 120, 25);
        panelVacunas.add(comboFechaVacunaHcli);
        
        botonRegistrarHcli = new JButton("Registrar");
        botonRegistrarHcli.setBounds(265, 100, 90, 30);
        panelVacunas.add(botonRegistrarHcli);
        botonRegistrarHcli.setVisible(true);
        botonRegistrarHcli.addActionListener(this);
        
        JPanel panelAgentes = new JPanel();

        rotulo5 = BorderFactory.createTitledBorder("Agentes Infecciosos");
        panelAgentes.setBorder(rotulo5);
        panelAgentes.setLayout(null);
        panelAgentes.setBounds(5, 225, 605, 255);
        panelAgentes.setVisible(true);
        panelAgentes.setBackground(Color.white);
        panelHistorial.add(panelAgentes);
        
        labelNomInfeHcli = new JLabel("Nombre de la Infección: ");
        labelNomInfeHcli.setBounds(25, 25, 200, 25); 
        panelAgentes.add(labelNomInfeHcli);
        labelNomInfeHcli.setVisible(true);
        
        comboNomInfeccHcli = new JComboBox();
        comboNomInfeccHcli.addItem("");
        comboNomInfeccHcli.setBounds(155, 25, 430, 25);
        panelAgentes.add(comboNomInfeccHcli);
        comboNomInfeccHcli.setVisible(true);
        
        labelTrataHcli = new JLabel("Tratamiento: ");
        labelTrataHcli.setBounds(25, 65, 200, 25); 
        panelAgentes.add(labelTrataHcli);
        labelTrataHcli.setVisible(true);
        
        
        textTrataHcli = new JTextField("");
        textTrataHcli.setBounds(155, 65, 430, 25);
        panelAgentes.add(textTrataHcli);
        textTrataHcli.setVisible(true);
        textTrataHcli.setEnabled(false);
        
        labelFechaInicioHcli = new JLabel("Fecha Inicio: ");
        labelFechaInicioHcli.setBounds(25, 105, 180, 25);
        panelAgentes.add(labelFechaInicioHcli); 
        labelFechaInicioHcli.setVisible(true);
        
        comboFechaInicioHcli=new DateComboBox();
        comboFechaInicioHcli.setBounds(155,105, 120, 25);
        panelAgentes.add(comboFechaInicioHcli);
        
        labelFechaFinalHcli = new JLabel("Fecha Final:");
        labelFechaFinalHcli.setBounds(320, 105, 180, 25);
        panelAgentes.add(labelFechaFinalHcli); 
        labelFechaFinalHcli.setVisible(true);
        
        comboFechaFinalHcli=new DateComboBox();
        comboFechaFinalHcli.setBounds(465,105, 120, 25);
        panelAgentes.add(comboFechaFinalHcli);
        
        
        labelFrecuenciaHcli = new JLabel("Frecuencia:");
        labelFrecuenciaHcli.setBounds(25, 145, 150, 25);
        panelAgentes.add(labelFrecuenciaHcli);
        labelFrecuenciaHcli.setVisible(true);
        
        textFrecuenciaHcli = new JTextField("");
        textFrecuenciaHcli.setBounds(155, 145, 50, 25);
        panelAgentes.add(textFrecuenciaHcli);
        textFrecuenciaHcli.setVisible(true);
        textFrecuenciaHcli.setEnabled(false);
        
        labelAplicacion1Hcli = new JLabel("Aplicación: ");
        labelAplicacion1Hcli.setBounds(320, 145, 250, 25);
        panelAgentes.add(labelAplicacion1Hcli);
        labelAplicacion1Hcli.setVisible(true);
        
        textAplicacion1Hcli = new JTextField("");
        textAplicacion1Hcli.setBounds(385, 145, 200, 25);
        panelAgentes.add(textAplicacion1Hcli);
        textAplicacion1Hcli.setVisible(true); 
        
        labelEdad2Hcli = new JLabel("Edad: ");
        labelEdad2Hcli.setBounds(25, 185, 100, 25); 
        panelAgentes.add(labelEdad2Hcli);
        labelEdad2Hcli.setVisible(true);
        
        textEdad2Hcli = new JTextField("");
        textEdad2Hcli.setBounds(155, 185, 50, 25); 
        panelAgentes.add(textEdad2Hcli);
        textEdad2Hcli.setVisible(true);
        
        labelSemanas2Hcli = new JLabel("Semanas ");
        labelSemanas2Hcli.setBounds(207, 185, 180, 25); 
        panelAgentes.add(labelSemanas2Hcli);
        labelSemanas2Hcli.setVisible(true);
        
        labelTemperaHcli = new JLabel("Temperatura:");
        labelTemperaHcli.setBounds(320, 185, 150, 25); 
        panelAgentes.add(labelTemperaHcli);
        labelTemperaHcli.setVisible(true);
        
        textTemperaHcli=new JTextField("");
        textTemperaHcli.setBounds(465,185, 120, 25);
        panelAgentes.add(textTemperaHcli);
        textTemperaHcli.setVisible(true);
        
        botonRegistrar1Hcli = new JButton("Registrar");
        botonRegistrar1Hcli.setBounds(265, 215, 90, 30);
        panelAgentes.add(botonRegistrar1Hcli);
        botonRegistrar1Hcli.setVisible(true);
        botonRegistrar1Hcli.addActionListener(this);
        
        labelMuerteHcli = new JLabel("Muerte:");
        labelMuerteHcli.setBounds(25, 490, 150, 25); 
        panelHistorial.add(labelMuerteHcli);
        labelMuerteHcli.setVisible(true);
        
        radioSiHcli = new JRadioButton("Si", false);
        radioSiHcli.setBounds(160, 490, 50, 25);
        panelHistorial.add(radioSiHcli);
        radioSiHcli.setVisible(true);
        
        radioNoHcli = new JRadioButton("No", false);
        radioNoHcli.setBounds(210, 490, 50, 25);
        panelHistorial.add(radioNoHcli);
        radioNoHcli.setVisible(true);
        
        labelFechaMuerteHcli = new JLabel("Fecha Nacimiento:");
        labelFechaMuerteHcli.setBounds(325, 490, 150, 25); 
        panelHistorial.add(labelFechaMuerteHcli);
        labelFechaMuerteHcli.setVisible(true);
        
        comboFechaMuerteHcli=new DateComboBox();
        comboFechaMuerteHcli.setBounds(470,490, 120, 25);
        panelHistorial.add(comboFechaMuerteHcli);
        
        labelDiagHcli = new JLabel("Diagnostico: ");
        labelDiagHcli.setBounds(25, 530, 200, 25); 
        panelHistorial.add(labelDiagHcli);
        labelDiagHcli.setVisible(true);
        
        textDiagHcli = new JTextField("");
        textDiagHcli.setBounds(155, 530, 435, 50);
        panelHistorial.add(textDiagHcli);
        textDiagHcli.setVisible(true); 
        
        
//************************************************ CODIGO PARA CREAR LA PESTAÑA PARTOS Y SUS OBJETOS ****************************************************************//
        
        panelPartos = new JPanel();
        TabPestaAnimal.addTab( "Partos", panelPartos);
        panelPartos.setLayout(null); 
        panelPartos.setBackground(Color.white);
        setVisible( true );
        
        labelCodPartoPar = new JLabel("*Código Parto:");
        labelCodPartoPar.setBounds (45, 115, 180, 25); 
        panelPartos.add(labelCodPartoPar);        
        labelCodPartoPar.setVisible(true);
        
        textCodPartoPar = new JTextField("");
        textCodPartoPar.setBounds(145,115, 100, 25); 
        panelPartos.add(textCodPartoPar);    
        textCodPartoPar.setVisible(true);
        textCodPartoPar.addKeyListener(this);
        
        labelFechaPartoPar = new JLabel("*Fecha del Parto:");
        labelFechaPartoPar.setBounds(338, 115, 150, 25); 
        panelPartos.add(labelFechaPartoPar);
        labelFechaPartoPar.setVisible(true);
        
        comboFechaPartoPar = new DateComboBox ();
        comboFechaPartoPar.setBounds(440, 115, 120, 25);
        panelPartos.add(comboFechaPartoPar);
        comboFechaPartoPar.addKeyListener(this);
        comboFechaPartoPar.setVisible(false);
        
        //Calendario 
		dateFechaPartPar = new JDateChooser();
		dateFechaPartPar.setIcon(icoCalendario);
		dateFechaPartPar.setDateFormatString("dd/MM/yyyy");
		dateFechaPartPar.setBounds( 440, 115, 120, 25 );
		dateFechaPartPar.addKeyListener(this);
		panelPartos.add(dateFechaPartPar);
        
        JPanel panelIdenMadre = new JPanel();

        rotulo7 = BorderFactory.createTitledBorder("Identificación de la Madre");
        panelIdenMadre.setBorder(rotulo7);
        panelIdenMadre.setLayout(null);
        panelIdenMadre.setBounds(5, 160, 605, 120);
        panelIdenMadre.setVisible(true);
        panelIdenMadre.setBackground(Color.white);
        panelPartos.add(panelIdenMadre);
        
        labelCodMadrePar = new JLabel("*Código de la Madre:");
        labelCodMadrePar.setBounds (20, 45, 180, 25); 
        panelIdenMadre.add(labelCodMadrePar);        
        labelCodMadrePar.setVisible(true);
        
        textCodMadrePar = new JTextField("");
        textCodMadrePar.setBounds(140,45, 100, 25); 
        panelIdenMadre.add(textCodMadrePar);    
        textCodMadrePar.setVisible(true);
        textCodMadrePar.addKeyListener(this); 
        
        labelEdadPar = new JLabel("*Edad: ");
        labelEdadPar.setBounds(290, 45, 100, 25); 
        panelIdenMadre.add(labelEdadPar);
        labelEdadPar.setVisible(true);
        
        textEdadPar = new JTextField("");
        textEdadPar.setBounds(408, 45, 50, 25); 
        panelIdenMadre.add(textEdadPar);
        textEdadPar.setVisible(true); 
        textEdadPar.addKeyListener(this);
        
        labelSemanasPar = new JLabel("Semanas ");
        labelSemanasPar.setBounds(460, 45, 180, 25); 
        panelIdenMadre.add(labelSemanasPar);
        labelSemanasPar.setVisible(true);
        
        labelRazaPar = new JLabel("Raza de la Madre:");
        labelRazaPar.setBounds(20, 85, 150, 25); 
        panelIdenMadre.add(labelRazaPar);
        labelRazaPar.setVisible(true);
        
        comboRazaMadrePar = new JComboBox();
        comboRazaMadrePar.addItem("HAMPSHIRE");
        comboRazaMadrePar.addItem("DUROC");
        comboRazaMadrePar.addItem("PIETRAIN");
        comboRazaMadrePar.addItem("LANDRACE");
        comboRazaMadrePar.addItem("YORKSHIRE");
        comboRazaMadrePar.setBounds(140,85, 120, 25); 
        panelIdenMadre.add(comboRazaMadrePar);
        comboRazaMadrePar.addKeyListener(this);
        comboRazaMadrePar.setVisible(true);
        
        labelRazaPadrePar = new JLabel("Raza del Padre:");
        labelRazaPadrePar.setBounds(290, 85, 150, 25); 
        panelIdenMadre.add(labelRazaPadrePar);
        labelRazaPadrePar.setVisible(true);
        
        comboRazaPadrePar = new JComboBox();
        comboRazaPadrePar.addItem("HAMPSHIRE");
        comboRazaPadrePar.addItem("DUROC");
        comboRazaPadrePar.addItem("PIETRAIN");
        comboRazaPadrePar.addItem("LANDRACE");
        comboRazaPadrePar.addItem("YORKSHIRE");
        comboRazaPadrePar.setBounds(408,85, 120, 25); 
        panelIdenMadre.add(comboRazaPadrePar);
        comboRazaPadrePar.addKeyListener(this);
        comboRazaPadrePar.setVisible(true);
        
        JPanel panelLechones = new JPanel();

        rotulo8 = BorderFactory.createTitledBorder("Lechones de la Camada");
        panelLechones.setBorder(rotulo8);
        panelLechones.setLayout(null);
        panelLechones.setBounds(5, 295, 605, 120);
        panelLechones.setVisible(true);
        panelLechones.setBackground(Color.white);
        panelPartos.add(panelLechones);
        
        labelVivosPar = new JLabel("*Lechones Vivos:");
        labelVivosPar.setBounds (20, 45, 180, 25); 
        panelLechones.add(labelVivosPar);        
        labelVivosPar.setVisible(true);
        
        textVivosPar = new JTextField("");
        textVivosPar.setBounds(140,45, 50, 25); 
        panelLechones.add(textVivosPar);    
        textVivosPar.setVisible(true);
        textVivosPar.addKeyListener(this);
        
        labelMuertosPar = new JLabel("*Lechones Muertos:");
        labelMuertosPar.setBounds(290, 45, 150, 25); 
        panelLechones.add(labelMuertosPar);
        labelMuertosPar.setVisible(true);
        
        textMuertosPar = new JTextField("");
        textMuertosPar.setBounds(408,45, 50, 25); 
        panelLechones.add(textMuertosPar);    
        textMuertosPar.setVisible(true);
        textMuertosPar.addKeyListener(this); 
        
        labelCamadaPar = new JLabel("Total Camada: ");
        labelCamadaPar.setBounds(20, 85, 150, 25); 
        panelLechones.add(labelCamadaPar);
        labelCamadaPar.setVisible(true);
        
        textCamadaPar = new JTextField("");
        textCamadaPar.setBounds(140, 85, 50, 25); 
        panelLechones.add(textCamadaPar);
        textCamadaPar.setVisible(true);
        textCamadaPar.setEnabled(false); 
        
        iconFondo = new ImageIcon("Imagenes\\CERDO3.jpg");
        labelFondoPar = new JLabel(iconFondo);
        labelFondoPar.setBounds(350, 430, 300, 170);
        panelPartos.add(labelFondoPar);
        setVisible(true);
        
//*********************************************** CODIGO PARA CREAR LA PESTAÑA MORTALIDAD Y SUS OBJETOS ************************************************//
        
        panelMortalidad = new JPanel();
        TabPestaAnimal.addTab( "Mortalidad", panelMortalidad);
        panelMortalidad.setLayout(null);
        panelMortalidad.setBackground(Color.white); 
        setVisible( true );
        
        JPanel panelTipoConsultaMor = new JPanel();

        rotulo9 = BorderFactory.createTitledBorder("Tipo de Consulta");
        panelTipoConsultaMor.setBorder(rotulo9);
        panelTipoConsultaMor.setLayout(null);
        panelTipoConsultaMor.setBounds(5, 35, 605, 140);
        panelTipoConsultaMor.setVisible(true);
        panelTipoConsultaMor.setBackground(Color.white);
        panelMortalidad.add(panelTipoConsultaMor);
        
        checkCodPartoMor=new JCheckBox("Código Parto");
        checkCodPartoMor.setBounds(25,35,150,25); 
        panelTipoConsultaMor.add(checkCodPartoMor);
        checkCodPartoMor.setBackground(Color.white);
        checkCodPartoMor.setVisible(true);
        
        checkCodMadreMor=new JCheckBox("Código Madre");
        checkCodMadreMor.setBounds(240,35,150,25); 
        panelTipoConsultaMor.add(checkCodMadreMor);
        checkCodMadreMor.setBackground(Color.white);
        checkCodMadreMor.setVisible(true);
        
        checkFechaPartoMor=new JCheckBox("Fecha Parto");
        checkFechaPartoMor.setBounds(465,35,100,25); 
        panelTipoConsultaMor.add(checkFechaPartoMor);
        checkFechaPartoMor.setBackground(Color.white);
        checkFechaPartoMor.setVisible(true);
        
        textCodPartoMor = new JTextField("");
        textCodPartoMor.setBounds(25,60, 100, 25); 
        panelTipoConsultaMor.add(textCodPartoMor);    
        textCodPartoMor.setVisible(true);
        
        textCodMadreMor = new JTextField("");
        textCodMadreMor.setBounds(240,60, 100, 25); 
        panelTipoConsultaMor.add(textCodMadreMor);    
        textCodMadreMor.setVisible(true);
        
        comboFechaPartoMor = new DateComboBox ();
        comboFechaPartoMor.setBounds(465, 60, 120, 25);
        panelTipoConsultaMor.add(comboFechaPartoMor);
        
        checkRangoMor=new JCheckBox("Rango Fecha");
        checkRangoMor.setBounds(25,100,120,25); 
        panelTipoConsultaMor.add(checkRangoMor);
        checkRangoMor.setBackground(Color.white);
        checkRangoMor.setVisible(true);
        
        labelDesdeMor = new JLabel("Desde: ");
        labelDesdeMor.setBounds(195, 100, 150, 25); 
        panelTipoConsultaMor.add(labelDesdeMor);
        labelDesdeMor.setVisible(true);
        
        comboFechaDesdeMor = new DateComboBox ();
        comboFechaDesdeMor.setBounds(240, 100, 120, 25);
        panelTipoConsultaMor.add(comboFechaDesdeMor);
        
        labelHastaMor = new JLabel("Hasta: ");
        labelHastaMor.setBounds(423, 100, 150, 25); 
        panelTipoConsultaMor.add(labelHastaMor);
        labelHastaMor.setVisible(true);
        
        comboFechaHastaMor = new DateComboBox ();
        comboFechaHastaMor.setBounds(465, 100, 120, 25);
        panelTipoConsultaMor.add(comboFechaHastaMor);
        
        tableMortalidadMor = new JTable(dataModel);
        paneTablaMortalidadMor = new JScrollPane(tableMortalidadMor);
        paneTablaMortalidadMor.setBounds(5, 200, 605, 200); 
        tableMortalidadMor.setVisible(true);
        paneTablaMortalidadMor.setVisible(true);
        panelMortalidad.add(paneTablaMortalidadMor);
        
        labelTotalPartosMor = new JLabel("Total Partos: ");
        labelTotalPartosMor.setBounds(210, 415, 150, 25); 
        panelMortalidad.add(labelTotalPartosMor);
        labelTotalPartosMor.setVisible(true);
        
        textTotalPartosMor = new JTextField("");
        textTotalPartosMor.setBounds(335,415, 50, 25); 
        panelMortalidad.add(textTotalPartosMor);    
        textTotalPartosMor.setVisible(true);
        textTotalPartosMor.setEnabled(false);
        
        labelTotalVivosMor = new JLabel("Total Vivos: ");
        labelTotalVivosMor.setBounds(210, 445, 150, 25); 
        panelMortalidad.add(labelTotalVivosMor);
        labelTotalVivosMor.setVisible(true);
        
        textTotalVivosMor = new JTextField("");
        textTotalVivosMor.setBounds(335,445, 50, 25); 
        panelMortalidad.add(textTotalVivosMor);    
        textTotalVivosMor.setVisible(true);
        textTotalVivosMor.setEnabled(false);
        
        labelTotalMuertosMor = new JLabel("Total Muertos: ");
        labelTotalMuertosMor.setBounds(210, 475, 150, 25); 
        panelMortalidad.add(labelTotalMuertosMor);
        labelTotalMuertosMor.setVisible(true);
        
        textTotalMuertosMor = new JTextField("");
        textTotalMuertosMor.setBounds(335,475, 50, 25); 
        panelMortalidad.add(textTotalMuertosMor);    
        textTotalMuertosMor.setVisible(true);
        textTotalMuertosMor.setEnabled(false);
        
        labelMuertosenParMor = new JLabel("Muertos en Parto: ");
        labelMuertosenParMor.setBounds(210, 505, 150, 25); 
        panelMortalidad.add(labelMuertosenParMor);
        labelMuertosenParMor.setVisible(true);
        
        textMuertosenParMor = new JTextField("");
        textMuertosenParMor.setBounds(335,505, 50, 25); 
        panelMortalidad.add(textMuertosenParMor);    
        textMuertosenParMor.setVisible(true);
        textMuertosenParMor.setEnabled(false);
        
        labelMuertosenProMor = new JLabel("Muertos en Proceso: ");
        labelMuertosenProMor.setBounds(210, 535, 150, 25); 
        panelMortalidad.add(labelMuertosenProMor);
        labelMuertosenProMor.setVisible(true);
        
        textMuertosenProMor = new JTextField("");
        textMuertosenProMor.setBounds(335,535, 50, 25); 
        panelMortalidad.add(textMuertosenProMor);    
        textMuertosenProMor.setVisible(true);
        textMuertosenProMor.setEnabled(false);
        
        botonImprimirMor = new JButton("Imprimir");
        botonImprimirMor.setBounds(130, 575, 90, 30);
        panelMortalidad.add(botonImprimirMor);
        botonImprimirMor.setVisible(true);
        botonImprimirMor.addActionListener(this);
        
        botonLimpiarMor = new JButton("Limpiar");
        botonLimpiarMor.setBounds(365, 575, 90, 30);
        panelMortalidad.add(botonLimpiarMor);
        botonLimpiarMor.setVisible(true);
        botonLimpiarMor.addActionListener(this);
        
//*********************************************** CODIGO PARA CREAR LA PESTAÑA ALIMENTO POR ESTAPA Y SUS OBJETOS **********************************************//        
        
        panelEtapa = new JPanel();
        panelEtapa.setLayout(null);
        panelEtapa.setVisible(true);
        panelEtapa.setBackground(Color.white);
        TabPestaAnimal.addTab("Alimento por Etapa de Desarrollo",panelEtapa);
        
        labelCodAnimalEta = new JLabel("Código del Animal:");
        labelCodAnimalEta.setBounds (35, 135, 180, 25); 
        panelEtapa.add(labelCodAnimalEta);        
        labelCodAnimalEta.setVisible(true);
        
        textCodAnimalEta = new JTextField("");
        textCodAnimalEta.setBounds(150,135, 100, 25); 
        panelEtapa.add(textCodAnimalEta);    
        textCodAnimalEta.setVisible(true);        
        
        labelRazaEta = new JLabel("Raza: ");
        labelRazaEta.setBounds(390, 135, 180, 25); 
        panelEtapa.add(labelRazaEta);
        labelRazaEta.setVisible(true);
        
        textRazaEta = new JTextField("");
        textRazaEta.setBounds(437,135, 150, 25); 
        panelEtapa.add(textRazaEta);    
        textRazaEta.setVisible(true);
        textRazaEta.setEnabled(false); 
        
        labelEdadEta = new JLabel("Edad: ");
        labelEdadEta.setBounds(35, 185, 100, 25); 
        panelEtapa.add(labelEdadEta);
        labelEdadEta.setVisible(true);
        
        textEdadEta = new JTextField("");
        textEdadEta.setBounds(150, 185, 50, 25); 
        panelEtapa.add(textEdadEta);
        textEdadEta.setVisible(true);
        textEdadEta.setEnabled(false);
        
        labelSemanasEta = new JLabel("Semanas ");
        labelSemanasEta.setBounds(202, 185, 180, 25); 
        panelEtapa.add(labelSemanasEta);
        labelSemanasEta.setVisible(true);
        
        labelSexoEta = new JLabel("Sexo:");
        labelSexoEta.setBounds(390, 185, 150, 25); 
        panelEtapa.add(labelSexoEta);
        labelSexoEta.setVisible(true);
        
        textSexoEta = new JTextField("");
        textSexoEta.setBounds(437,185, 100, 25); 
        panelEtapa.add(textSexoEta);    
        textSexoEta.setVisible(true);
        textSexoEta.setEnabled(false);
        
        labelPesoEta = new JLabel("Peso: ");
        labelPesoEta.setBounds(35, 225, 100, 25); 
        panelEtapa.add(labelPesoEta);
        labelPesoEta.setVisible(true);
        
        textPesoEta = new JTextField("");
        textPesoEta.setBounds(150, 225, 50, 25); 
        panelEtapa.add(textPesoEta);
        textPesoEta.setVisible(true);
        textPesoEta.setEnabled(false);
        
        labelKgEta = new JLabel("Kg. ");
        labelKgEta.setBounds(202, 225, 180, 25); 
        panelEtapa.add(labelKgEta);
        labelKgEta.setVisible(true);
        
        labelEstadoEta = new JLabel("Estado:");
        labelEstadoEta.setBounds(390, 225, 150, 25); 
        panelEtapa.add(labelEstadoEta);
        labelEstadoEta.setVisible(true);
        
        textEstadoEta = new JTextField("");
        textEstadoEta.setBounds(437,225, 100, 25); 
        panelEtapa.add(textEstadoEta);    
        textEstadoEta.setVisible(true);
        textEstadoEta.setEnabled(false); 
        
        JPanel panelEtapaDesaEta = new JPanel();

        rotulo10 = BorderFactory.createTitledBorder("Datos Etapa de Desarrollo");
        panelEtapaDesaEta.setBorder(rotulo10);
        panelEtapaDesaEta.setLayout(null);
        panelEtapaDesaEta.setBounds(5, 300, 605, 130);
        panelEtapaDesaEta.setVisible(true);
        panelEtapaDesaEta.setBackground(Color.white);
        panelEtapa.add(panelEtapaDesaEta);
        
        labelEtapaActualEta = new JLabel("Etapa Actual:");
        labelEtapaActualEta.setBounds(10, 45, 180, 25); 
        panelEtapaDesaEta.add(labelEtapaActualEta);
        labelEtapaActualEta.setVisible(true);
        
        textEtapaActualEta = new JTextField("");
        textEtapaActualEta.setBounds(90, 45, 200, 25); 
        panelEtapaDesaEta.add(textEtapaActualEta);
        textEtapaActualEta.setVisible(true);
        textEtapaActualEta.setEnabled(false);
        
        labelJaulaEta = new JLabel("Jaula Actual:");
        labelJaulaEta.setBounds(380, 45, 180, 25); 
        panelEtapaDesaEta.add(labelJaulaEta);
        labelJaulaEta.setVisible(true);
        
        textJaulaEta = new JTextField("");
        textJaulaEta.setBounds(490, 45, 100, 25); 
        panelEtapaDesaEta.add(textJaulaEta);
        textJaulaEta.setVisible(true);
        textJaulaEta.setEnabled(false);
        
        labelAliDiaEta = new JLabel("Consumo Alimento por Día: ");
        labelAliDiaEta.setBounds(10, 85, 180, 25); 
        panelEtapaDesaEta.add(labelAliDiaEta);
        labelAliDiaEta.setVisible(true);
        
        textAliDiaEta = new JTextField("");
        textAliDiaEta.setBounds(170, 85, 50, 25); 
        panelEtapaDesaEta.add(textAliDiaEta);
        textAliDiaEta.setVisible(true);
        textAliDiaEta.setEnabled(false);
        
        labelKgEta = new JLabel("Kg.");
        labelKgEta.setBounds(223, 85, 180, 25); 
        panelEtapaDesaEta.add(labelKgEta);
        labelKgEta.setVisible(true);
        
        labelAliSemaEta = new JLabel("Consumo Alimento por Semana: ");
        labelAliSemaEta.setBounds(330, 85, 200, 25); 
        panelEtapaDesaEta.add(labelAliSemaEta);
        labelAliSemaEta.setVisible(true);
        
        textAliSemaEta = new JTextField("");
        textAliSemaEta.setBounds(520, 85, 50, 25); 
        panelEtapaDesaEta.add(textAliSemaEta);
        textAliSemaEta.setVisible(true);
        textAliSemaEta.setEnabled(false);
        
        labelKg1Eta = new JLabel("Kg.");
        labelKg1Eta.setBounds(572, 85, 100, 25); 
        panelEtapaDesaEta.add(labelKg1Eta);
        labelKg1Eta.setVisible(true);
        
        botonLimpiarEta = new JButton("Limpiar");
        botonLimpiarEta.setBounds(270, 450, 90, 30);
        panelEtapa.add(botonLimpiarEta);
        botonLimpiarEta.setVisible(true);
        botonLimpiarEta.addActionListener(this);
        
//*********************************************** CODIGO PARA CREAR LOS BOTONES DEL FORMULARIO *************************************************************//        
        
        icoCrear = new ImageIcon("Imagenes\\Nuevo1.jpg");
        botonCrear = new JButton(icoCrear);
        botonCrear.setBounds(10, 645, 70, 40);
        this.getContentPane().add(botonCrear);
        botonCrear.setVisible(true);
        botonCrear.setToolTipText("Crear Registro");
        botonCrear.addActionListener(this);
        
        icoGuardar=new ImageIcon("Imagenes\\Guardar.jpg");
        botonGuardar = new JButton(icoGuardar);
        botonGuardar.setBounds(100, 645, 70, 40);
        this.getContentPane().add(botonGuardar);
        botonGuardar.setVisible(true);
        botonGuardar.setEnabled(false);
        botonGuardar.setToolTipText("Guardar");
        botonGuardar.addActionListener(this);
        
        icoModificar = new ImageIcon("Imagenes\\Modificar.jpg");
        botonModificar = new JButton(icoModificar);
        botonModificar.setBounds(190, 645, 70, 40);
        this.getContentPane().add(botonModificar);
        botonModificar.setVisible(true);
        botonModificar.setToolTipText("Modificar");
        botonModificar.addActionListener(this);
        
        icoBuscar = new ImageIcon("Imagenes\\Buscar.jpg");
        botonConsultar = new JButton(icoBuscar);
        botonConsultar.setBounds(280, 645, 70, 40);
        this.getContentPane().add(botonConsultar);
        botonConsultar.setVisible(true);
        botonConsultar.setToolTipText("Consultar");
        botonConsultar.addActionListener(this);
        
        icoEliminar = new ImageIcon("Imagenes\\Eliminar.jpg");
        botonEliminar = new JButton(icoEliminar);
        botonEliminar.setBounds(370, 645, 70, 40);
        this.getContentPane().add(botonEliminar);
        botonEliminar.setVisible(true);
        botonEliminar.setToolTipText("Eliminar");
        botonEliminar.addActionListener(this);
        
        icoListar = new ImageIcon("Imagenes\\Listar.jpg");        
        botonListar = new JButton(icoListar);
        botonListar.setBounds(460, 645, 70, 40);
        this.getContentPane().add(botonListar);
        botonListar.setVisible(true);
        botonListar.setToolTipText("Listar");
        botonListar.addActionListener(this);
        
        icoLimpiar = new ImageIcon("Imagenes\\Limpiar.jpg");
        botonLimpiar = new JButton(icoLimpiar);
        botonLimpiar.setBounds(550, 645, 70, 40);
        this.getContentPane().add(botonLimpiar);
        botonLimpiar.setVisible(true);
        botonLimpiar.setToolTipText("Limpiar Campos");
        botonLimpiar.addActionListener(this);
        
        icoSalir = new ImageIcon("Imagenes\\Salir.jpg");
        botonSalir = new JButton(icoSalir);
        botonSalir.setBounds(640, 645, 70, 40);
        this.getContentPane().add(botonSalir);
        botonSalir.setVisible(true);
        botonSalir.setToolTipText("Salir");
        botonSalir.addActionListener(this); 
    	
    	icoMensajeInfor = new ImageIcon("Imagenes\\IconoInformacion.jpg");
    	icoMensajePre = new ImageIcon("Imagenes\\IconoPregunta.jpg");
		this.listaAni = listaAnima;
		this.listaPar = listaParto;
    	this.repaint();
    	this.DesactivarCamposPartos();
    	this.DesactivarCampos();
    	this.validarCamposPartos();
    	this.ValidarCamposDatosAni();
    	this.Nuevo();
    	this.LimpiarCampos(); 
    		
    }
    
//*************************************************** CODIGO PARA PROGRAMAR LA FUNCIONALIDAD DE LOS BOTONES ****************************************************************//
    
	 public void actionPerformed(ActionEvent event) {  

	    	
	    int indi = TabPestaAnimal.getSelectedIndex();
	    
	    if (indi==2){
	    	
	    	botonModificar.setEnabled(true);
	    }
	    
	    if (event.getSource()==botonMas){
	        
	       comboProcedencia.addItem(JOptionPane.showInputDialog("Ingrese la nueva granja de procedencia"));	
	    } 
	    	
	    if ((indi == 0)  || (indi == 2)){    // PREGUNTAMOS SI ALGUNA DE LAS DOS PESTAÑAS ESTA SELECCIONADA	
	    
	//************************************ CODIGO DE EL BOTON GUARDAR DE DATOS ANIMALES ***************************************************************************//    
	    	
		if(event.getSource()==botonGuardar){
				
			if (indi==0){
				
				this.guardarDatosAnimal();
		        if (swModifiDatos==0){
		        	
		        	if (listaAni.existeAnimal(animal.getCodAnimal())){
		        		
		        		JOptionPane.showMessageDialog(null,"El código del animal ya existe","Datos Animal - S.G.P",
											  		  JOptionPane.OK_OPTION,icoMensajeInfor);  
		        	}else{
		        		if (listaAni.guardarAnimal(animal)){
		        			
		        			JOptionPane.showMessageDialog(null,"El registro se guardo correctamente","Datos Animal - S.G.P",
											  		      JOptionPane.OK_OPTION,icoMensajeInfor);  
			        		this.Nuevo();
			        		this.DesactivarCampos();
		        		}else{
		        			
		        			JOptionPane.showMessageDialog(null,"El registro no fue guardado","Datos Animal - S.G.P",
											  		      JOptionPane.OK_OPTION,icoMensajeInfor);  
		        		}
		        	}
		        	
		        }else{
		        	
		        	int opc ;
			        opc = JOptionPane.showConfirmDialog(null,"Esta seguro que desea modificar este registro",
			        								  "Datos Animal - S.G.P",JOptionPane.YES_NO_OPTION,
			        								  JOptionPane.QUESTION_MESSAGE,icoMensajePre);
			        if (opc == 0) {  
			   			if (listaAni.guardarModificacion(animal)){
			        		
			        		JOptionPane.showMessageDialog(null,"El registro se modifico correctamente","Datos Animal - S.G.P",
											  		      JOptionPane.OK_OPTION,icoMensajeInfor);  
			        		this.Nuevo();
			        		this.DesactivarCampos();
			    		}else{
			        		
			        		JOptionPane.showMessageDialog(null,"El registro no fue modificado","Datos Animal - S.G.P",
											  		      JOptionPane.OK_OPTION,icoMensajeInfor); 	 
			    		}
			    	}	
				}
		    		
		    	botonGuardar.setEnabled(false);
	    		
	    		if (!textCodAnimal.getText().equals("")){
					JOptionPane.showMessageDialog(null,"No esposible guardar, no esta en datos del animal","Datos Animal - S.G.P",
											      JOptionPane.OK_OPTION,icoMensajeInfor); 	  
	    		}
	    	}	
	    	
			if (indi==2){ // GUARDAR SI ESTA SELECCIONADA LA PESTAÑA PARTOS
			
				this.GuardarCamposPartos();
		        if (swModPartos==0){
		        	
		        	if (listaPar.existeParto(textCodPartoPar.getText())){
		        		
		        		JOptionPane.showMessageDialog(null,"El código del parto ya existe","Gestionar Partos - S.G.P",
											          JOptionPane.OK_OPTION,icoMensajeInfor);  
		        	}else{
		        		if (listaPar.guardarParto(parto)){
		        			
		        			JOptionPane.showMessageDialog(null,"El registro del parto se guardo correctamente","Gestionar Partos - S.G.P",
											              JOptionPane.OK_OPTION,icoMensajeInfor);  
			        		this.LimpiarCampos();
			        		this.DesactivarCamposPartos();
		        		}else{
		        			
		        			JOptionPane.showMessageDialog(null,"El registro del parto no fue guardado","Gestionar Partos - S.G.P",
											              JOptionPane.OK_OPTION,icoMensajeInfor); 
		        		}
		        	}
		        	
		        }else{
		        	
		        	int opc ;
			        opc = JOptionPane.showConfirmDialog(null,"Esta seguro que desea modificar este registro",
			        								    "Gestionar Partos - S.G.P",JOptionPane.YES_NO_OPTION,
			        								    JOptionPane.QUESTION_MESSAGE,icoMensajePre);
		        	if (opc == 0) { 
			   			if (listaPar.modificarParto(parto)){
			        		
			        		JOptionPane.showMessageDialog(null,"El parto se modifico correctamente","Gestionar Partos - S.G.P",
											              JOptionPane.OK_OPTION,icoMensajeInfor);  
			        		this.LimpiarCampos();
			        		this.DesactivarCamposPartos();
			    		}else{
			        		
			        		JOptionPane.showMessageDialog(null,"El parto no fue modificado","Gestionar Partos - S.G.P",
											              JOptionPane.OK_OPTION,icoMensajeInfor); 
			    		}
			    	}	
				}
		    		
		    	botonGuardar.setEnabled(false);	
	    	}else{
	    		
	    		if (!textCodPartoPar.getText().equals("")){
	    		
	    			JOptionPane.showMessageDialog(null,"No es posible guardar, no esta en partos","Gestionar Partos - S.G.P",
											      JOptionPane.OK_OPTION,icoMensajeInfor);  
	   			}
	   		}
	    		 
	    }
	    
//*********************************************** CODIGO BOTON LISTAR *************************************************************************************//

		if (event.getSource()==botonListar){
			
			if (indi == 0){
				
				ListarAnimales la= new ListarAnimales(listaAni.getPrimero());
			}else{
				if (indi == 2){
					
					ListarPartos lpa= new ListarPartos(listaPar.getPrimero());
				}else{
					
					JOptionPane.showMessageDialog(null,"Pestaña Equivocada","Gestionar Animal - S.G.P",
										  JOptionPane.OK_OPTION,icoMensajeInfor); 
				}
			}       	
		}
	    
	//**************************************** CODIGO BOTONES LIMPIAR ******************************************************************************//	
	    
	    if (event.getSource()==botonLimpiar){
			
			if (indi == 0){
				
				this.Nuevo();
	    		this.DesactivarCampos();
			}else{
				if (indi == 2){
					
					this.LimpiarCampos();
	    			this.DesactivarCamposPartos();
				}else{
					
					JOptionPane.showMessageDialog(null,"Pestaña Equivocada","Gestionar Animal - S.G.P",
										  JOptionPane.OK_OPTION,icoMensajeInfor); 
				}
			}
			this.activarBotones();       	
		} 
			
				
	  	if (event.getSource() == botonSalir) {
	    
	       int opc ;
	        opc = JOptionPane.showConfirmDialog(null,"¿Está seguro que desea salir de gestionar animal?",
	        								  "Salir.  Sistematización Grajas Porcícolas - S.G.P.",JOptionPane.YES_NO_OPTION,
	        								  JOptionPane.QUESTION_MESSAGE,icoMensajePre);
	        if (opc == 0) {
	            this.dispose();
	
	        }
	    }
	    
	//******************************************* CODIGO BOTON CREAR ******************************************************************************//
	        
	    if (event.getSource()==botonCrear){ 
	        	
	       if (indi==0){  // SI ES LA PESTAÑA DATOS ANIMAL
	        		
	        	swModifiDatos=0;
	        	this.Nuevo();   		
	    		textCodAnimal.setText(this.codigoAnimales(listaAni.getconsecutivoCdigo()));
	    		comboRaza.requestFocus();        
	   			comboRaza.setEnabled(true);
	        	this.ActivarCampos();	
	       }else{ 
	       		if (indi == 2){
	       											//SI ES LA PESTAÑA PARTOS 
		        	textCodPartoPar.setText(this.codigoAnimales(listaPar.getconsecutivoCdigo()));
		        	this.ActivarCamposPartos();        	
		   		//	dateFechaPartPar.requestFocus();
		   		 }	
	   	   }
	   	   this.desactivarBotones();
	    }
	    
	//**************************************** CODIGO DEL BOTON MODIFICAR *********************************************************************************//
	        
	    if (event.getSource()==botonModificar){
	    	
	        
	        if (indi==0){   //  PARA SABER SI ESTAMOS EN LA PESTAÑA DATOS ANIMAL
	        	
	        	swModifiDatos=1; 
	        	llenarDatosAnimales(); 
	        	this.ActivarCampos();	
	        }else{
	        	
	        	if (indi==2){
	        	
		        	swModPartos=1; 
		        	llenarDatosPartos(); 
		        	this.ActivarCamposPartos();
		 		}
	        }	
	    }
	        
	    if(event.getSource()==botonConsultar){   	
	 
	 //***************************************** CODIGO DEL BOTON CONSULTAR PARA DATOS ANIMALES *****************************************************//
	    	
	    	if (indi==0){  //PARA SABER SI ESTAMOS PARADOS EN LA PESTAÑA DATOS ANIMALES
	    	
				int o = 4;
	 			this.llenarDatosAnimales();
				this.DesactivarCampos(); 
			}	
			if (indi==2){
				int o = 4;
	 			this.llenarDatosPartos();
				this.DesactivarCamposPartos(); 
	        }	
		}		
			
		if(event.getSource()==botonEliminar){
			
			if (indi==2){
			
	//*********************************** CODIGO PARA ELIMINAR SI ES LA PESTAÑA PARTOS ******************************************************************** //
			
				String s=JOptionPane.showInputDialog(this,"Ingrese el código del parto que desea eliminar");
		        if(listaPar.existeParto(s)){
		        	
		            if(listaPar.eliminarParto(s)){
		            	
		            	JOptionPane.showMessageDialog(null,"El parto ha sido eliminado","Gestionar Partos - S.G.P",
											          JOptionPane.OK_OPTION,icoMensajeInfor);  
	                	this.LimpiarCampos();
	                
	            	}else{
	            		
	            		JOptionPane.showMessageDialog(null,"El parto no se pudo eliminar","Gestionar Partos - S.G.P",
											          JOptionPane.OK_OPTION,icoMensajeInfor);  
	            	}
	        	}else{
	        		
	        		JOptionPane.showMessageDialog(null,"El código del parto no existe","Gestionar Partos - S.G.P",
											      JOptionPane.OK_OPTION,icoMensajeInfor); 
	        	}
	    	}
	    	
	    	if (indi==0){
	    	
	    		String s=JOptionPane.showInputDialog(this,"Ingrese el código del animal que desea eliminar");
		        if(listaAni.existeAnimal(s)){
		        	
		            if(listaAni.eliminarAnimal(s)){
		            	
		            	JOptionPane.showMessageDialog(null,"El registro ha sido eliminado","Datos Animal - S.G.P",
											      JOptionPane.OK_OPTION,icoMensajeInfor); 
	                	Nuevo();
	                
	            	}else{
	            		
	            		JOptionPane.showMessageDialog(null,"El registro no se pudo eliminar","Datos Animal - S.G.P",
											          JOptionPane.OK_OPTION,icoMensajeInfor); 
	            	}
	        	}else{
	        		
	        		JOptionPane.showMessageDialog(null,"El código del animal no existe","Datos Animal - S.G.P",
											      JOptionPane.OK_OPTION,icoMensajeInfor); 
	        	}
	    	}
	    }
	   
	    }else{
	        
	        JOptionPane.showMessageDialog(null,"Pestaña Equivocada","Gestionar Animal - S.G.P",
										  JOptionPane.OK_OPTION,icoMensajeInfor); 
	    }
	    
	   
	     
	 }
	    	  
	//********************************************* METODOS PARA VALIDAR CUADROS DE TEXTO ******************************************************************//
	     
	public void keyPressed(KeyEvent e) {
	     	
		if((e.getKeyCode() == KeyEvent.VK_ENTER)){
	     		
	     	Component c = (Component) e.getSource(); 
			c.transferFocus(); 
	    }
	    
	    if ( e.getSource() == textCodParto && e.getKeyCode() == KeyEvent.VK_ENTER ){
	    	
	    	if (comboProcedencia.getSelectedIndex() == 0){
	    	
	    	
	    	if ( textCodParto.getText().equals("") ){
	    		
	    		JOptionPane.showMessageDialog(null,"Ingrese el código de la madre","Gestionar Animal - S.G.P",
											  JOptionPane.OK_OPTION,icoMensajeInfor);
				textCodParto.requestFocus();
	    	}else{
	    		
	    		DatosPartos datosParto = listaAni.cargarDatosParto(listaPar.getPrimero(),textCodParto.getText());
		    	if ( datosParto != null ){
		    		
		    		this.llenarDatosPartoAnimal();
		    	}else{
		    		
		    		JOptionPane.showMessageDialog(null,"El código del parto no existe","Gestionar Partos - S.G.P",
												  JOptionPane.OK_OPTION,icoMensajeInfor);
					textCodParto.setText("");
					textCodParto.requestFocus();
		    	}
	    	}
	    	}
	    }
	    
	    if ( e.getSource() == textCodMadrePar && e.getKeyCode() == KeyEvent.VK_ENTER){
	    	
	    	if ( textCodMadrePar.getText().equals("") ){
	    		
	    		JOptionPane.showMessageDialog(null,"Ingrese el código de la madre","Gestionar Partos - S.G.P",
											  JOptionPane.OK_OPTION,icoMensajeInfor);
				textCodMadrePar.requestFocus();
	    	}else{
	    		
	    		DatosAnimal datosMadre = listaAni.verificarReproductora(textCodMadrePar.getText());
		    	if ( datosMadre != null ){
		    		
		    		textEdadMadre.setText(datosMadre.getEdadSem());
		    		comboRazaMadrePar.setSelectedItem(datosMadre.getRaza());
		    	}else{
		    		
		    		JOptionPane.showMessageDialog(null,"El código de la madre no existe","Gestionar Partos - S.G.P",
												  JOptionPane.OK_OPTION,icoMensajeInfor);
					textCodMadrePar.setText("");
					textCodMadrePar.requestFocus();
		    	}
	    	}
	    }    
	    
	    if (e.getSource()==textMuertosPar && e.getKeyCode() == KeyEvent.VK_ENTER){
	    	
	    	if (textVivosPar.getText().equals("") && textMuertosPar.getText().equals("")){
	    	
	    		JOptionPane.showMessageDialog(null,"Digite todos los campos Obligatorios","Gestionar Partos - S.G.P",
											  JOptionPane.OK_OPTION,icoMensajeInfor); 
	    		e.consume();
	    	}else{
	    	
	    		textCamadaPar.setText(Integer.toString(Sumatoria(textVivosPar,textMuertosPar)));
	    		botonGuardar.setEnabled(true);
	    	}
	    }
	    


	    

	 /*   if (e.getSource()==textNacer && e.getKeyCode() == KeyEvent.VK_ENTER){
	    
	    	
	    	if (textNacer.getText().equals("")){
	    		
	    		JOptionPane.showMessageDialog(null,"Campo Obligatorios");
	    		e.consume();	
	    	}else{
	    		
	    		if (v.validaFecha(dateFechaNaci)==false){
	    		
	    			textEdad.setText(Long.toString(v.calcularDias(dateFechaNaci)));
	    		}else{
	    			
	    			JOptionPane.showMessageDialog(null,"Fecha mayor a la fecha actual");
	    			dateFechaNaci.requestFocus();
	    		}
	    	}
	    }	
	    /*	if (e.getSource()==comboFechaConsuAlimento && e.getKeyCode() == KeyEvent.VK_ENTER){
	    		
	    		if (v.validaFecha(comboFechaConsuAlimento)==false){
	    		    			
	    			JOptionPane.showMessageDialog(null,"Fecha mayor a la fecha actual");
	    			comboFechaConsuAlimento.requestFocus();
	    		}
	    	
	    	}
	    	
	    	if (e.getSource()==comboFechaDestete && e.getKeyCode() == KeyEvent.VK_ENTER){
	    		
	    		if (v.validaFecha(comboFechaDestete)==true){
	    		    			
	    			JOptionPane.showMessageDialog(null,"Fecha mayor a la fecha actual");
	    			comboFechaDestete.requestFocus();
	    		}
	    	
	    	}
	    
	    if (e.getSource()==comboFechaPartoPar && e.getKeyCode()==KeyEvent.VK_ENTER){
				
				if(v.validaFecha(comboFechaPartoPar)==true){
					
					JOptionPane.showMessageDialog(null,"Fecha mayor a la actual");
					comboFechaPartoPar.requestFocus();
				}
		}*/
	     	
	 }
	
	 public void keyReleased(KeyEvent e) { 
	 	
	 }
	    
	 public void keyTyped(KeyEvent e) {
	 
	 }	
	   
	 public void mouseClicked(MouseEvent e) {
	 	
	 	
	 	if (e.getSource()==radioEngorde || e.getSource()==radioReemplazo /*&& e.getClickCount()==1*/){
	    	
	   /* 	if (/*textEdad.getText().equals("") textNombre.getText().equals("") /*|| textCargo.getText().equals("")){
					
					JOptionPane.showMessageDialog(null,"Digite todos los Campos Obligatorios");
					e.consume();
				}else{*/
					
					botonGuardar.setEnabled(true);
		//	}
	    }
	    
        if ( dateFechaNaci.getDate() == null ){
        	
			JOptionPane.showMessageDialog(null,"Seleccione una fecha","Datos Animal - S.G.P",
										  JOptionPane.OK_OPTION,icoMensajeInfor);  
				
		}else{
			
			if (v.validaFecha(dateFechaNaci)==false){
			
				textEdad.setText(Long.toString(v.calcularDias(dateFechaNaci)));
				textNacer.requestFocus();
			}else{
				
				JOptionPane.showMessageDialog(null,"Fecha mayor a la fecha actual","Datos Animal - S.G.P",
										      JOptionPane.OK_OPTION,icoMensajeInfor);  
				dateFechaNaci.requestFocus();
			}
		} 
			
		if ( dateFechaDestete.getDate() == null){
	    		
    		JOptionPane.showMessageDialog(null,"Seleccione una fecha","Datos Animal - S.G.P",
							      		  JOptionPane.OK_OPTION,icoMensajeInfor); 
    			
    	}else{ 	    		
    		if (v.validaFecha(dateFechaDestete)==false){
    		    			
    			JOptionPane.showMessageDialog(null,"Fecha mayor a la fecha actual","Datos Animal - S.G.P",
							      		  	  JOptionPane.OK_OPTION,icoMensajeInfor); 
    			dateFechaDestete.requestFocus();
    		} 
    	}
    	
    /*	if (/* e.getSource() == dateFechaConsuAlimento && dateFechaConsuAlimento.getDate() == null){
	    		
    		JOptionPane.showMessageDialog(null,"Seleccione una fecha","Datos Animal - S.G.P",
							      		  JOptionPane.OK_OPTION,icoMensajeInfor); 
    			
    	}else{ 	    		
    		if (v.validaFecha(dateFechaConsuAlimento)==false){
    		    			
    			JOptionPane.showMessageDialog(null,"Fecha mayor a la fecha actual","Datos Animal - S.G.P",
							      		  	  JOptionPane.OK_OPTION,icoMensajeInfor); 
    			dateFechaConsuAlimento.requestFocus();
    		} 
    	}
    	
    	if (/* e. == dateFechaParto && dateFechaParto.getDate() == null ){
	    		
    		JOptionPane.showMessageDialog(null,"Seleccione una fecha","Datos Animal - S.G.P",
							      		  JOptionPane.OK_OPTION,icoMensajeInfor); 
    			
    	}else{ 	    		
    		if (v.validaFecha(dateFechaParto)==false){
    		    			
    			JOptionPane.showMessageDialog(null,"Fecha mayor a la fecha actual","Datos Animal - S.G.P",
							      		  	  JOptionPane.OK_OPTION,icoMensajeInfor); 
    			dateFechaParto.requestFocus();
    		} 
    	}*/
	 }
	    
	 public void mousePressed(MouseEvent e) {
	 }
	
	 public void mouseReleased(MouseEvent e) {
	 }
	
	 public void mouseEntered(MouseEvent e) {
	 }
	
	 public void mouseExited(MouseEvent e) {
	 }
	    
	//********************************************** METODOS PARA EL CRUD DATOS ANIMALES *********************************************************************************************************//   
	   
	    
	public void guardarDatosAnimal(){
		
		if (radioVivo.isSelected()) {
	        	
			Estad = "Vivo";            
		}
	
		if (radioMuerto.isSelected()) {
	
			Estad = "Muerto";
		}
	
		if (radioEngorde.isSelected()) {
	
			TipoPor = "Engorde";            
		}
	
		if (radioReemplazo.isSelected()) {
	
			TipoPor = "Reemplazo";
		}		
		try{
			animal = new DatosAnimal();
			animal.setCodAnimal(textCodAnimal.getText());
		   	animal.setRaza((String) comboRaza.getSelectedItem());
		   	animal.setSexo((String) comboSexo.getSelectedItem());
		   	animal.setEstado(Estad);
		   	animal.setFechaNaci(dateFechaNaci.getDate());
		   	animal.setEdadSem(textEdad.getText());
		   	animal.setProcedencia((String) comboProcedencia.getSelectedItem());
		   	animal.setPesoNacer(textNacer.getText()); 
		   	animal.setPesoDestete(textDestete.getText());
		   	animal.setFechaConsuAli(dateFechaConsuAlimento.getDate());
		   	animal.setFechaDestete(dateFechaDestete.getDate());
		   	animal.setCodParto(textCodParto.getText());
		   	animal.setFechaParto(dateFechaParto.getDate());
		   	animal.setCodMadre(textCodMadre.getText());
		   	animal.setEdadMadre(textEdadMadre.getText()); 
		   	animal.setRazaMadre((String) comboRazaMadre.getSelectedItem()); 
		   	animal.setRazaPadre((String) comboRazaPadre.getSelectedItem());
		   	animal.setTipoAnimal(TipoPor); 
	   	}
	   	catch(Exception e){
	   		System.out.println("Error al listar los datos"+e.getMessage());
	   	}
	}
	
	public void llenarDatosAnimales(){
		
		int opc=-2;
		String[]opciones = { "Código Animal","Código Parto","Código Madre"};
		if (swModPartos==1){
				
			buscarAnimal = listaAni.consultarAnimal(JOptionPane.showInputDialog("Ingrese el código del parto a modificar"));
		}else{
			
			opc = JOptionPane.showOptionDialog(null,"Seleccione la forma en que desea realizar la consulta",
												   "Consulta Animales. Sistematización Granjas Porcícola - S.G.P.",JOptionPane.YES_NO_CANCEL_OPTION,
												   JOptionPane.QUESTION_MESSAGE,icoMensajePre,opciones,true);									   
			switch (opc){
				
				case 0:
					buscarAnimal = listaAni.consultarAnimal(JOptionPane.showInputDialog("Ingrese el código del animal a consultar"));
					break;
				case 1:
					buscarAnimal = listaAni.consultarAnimal(JOptionPane.showInputDialog("Ingrese el código del parto a consultar"));
					break;
				case 2:
					buscarAnimal = listaAni.consultarAnimal(JOptionPane.showInputDialog("Ingrese el código de la madre a consultar"));
					break;
			}
		}
		if (opc != -1){ 
			if (buscarAnimal!= null){
				
				textCodAnimal.setText(buscarAnimal.getCodAnimal());
				comboRaza.setSelectedItem(buscarAnimal.getRaza());
		   		comboSexo.setSelectedItem(buscarAnimal.getSexo()); 
		   		if (buscarAnimal.getEstado().equals("Vivo")){
		   			radioVivo.setSelected(true);
		   		}else{
		   			radioMuerto.setSelected(true);
		   		}
		   		dateFechaNaci.setDate(buscarAnimal.getFechaNaci());
		   		textEdad.setText(buscarAnimal.getEdadSem());
		   		comboProcedencia.setSelectedItem(buscarAnimal.getProcedencia());
		   		textNacer.setText(buscarAnimal.getPesoNacer()); 
		   		textDestete.setText(buscarAnimal.getPesoDestete());
		   		dateFechaDestete.setDate(buscarAnimal.getFechaDestete());
		   		dateFechaConsuAlimento.setDate(buscarAnimal.getFechaConsuAli()); 
		   		textCodParto.setText(buscarAnimal.getCodParto());
		   		dateFechaParto.setDate(buscarAnimal.getFechaParto());
		   		textCodMadre.setText(buscarAnimal.getCodMadre());
		   		textEdadMadre.setText(buscarAnimal.getEdadMadre()); 
		   		comboRazaMadre.setSelectedItem(buscarAnimal.getRazaMadre()); 
		   		comboRazaPadre.setSelectedItem(buscarAnimal.getRazaPadre()); 
		   		if (buscarAnimal.getTipoAnimal().equals("Engorde")){
		   			radioEngorde.setSelected(true);
		   		}else{
		   			radioReemplazo.setSelected(true);
		   		}
			}else{
				
				JOptionPane.showMessageDialog(null,"El registro del animal no existe","Datos Animal - S.G.P",
											  JOptionPane.OK_OPTION,icoMensajeInfor); 
			}
		}else{
			JOptionPane.showMessageDialog(null,"Se cancelo la consulta","Datos Animal - S.G.P",
										  JOptionPane.OK_OPTION,icoMensajeInfor);  
		} 	
		buscarAnimal = null;
	}
	
	public void llenarDatosPartoAnimal (){
		
		DatosPartos partoA=listaAni.cargarDatosParto(listaPar.getPrimero(),textCodParto.getText());
		dateFechaParto.setDate(partoA.getFechaPart());
		textCodMadre.setText(partoA.getCodMadre());
		textEdadMadre.setText(partoA.getEdad()); 
		comboRazaMadre.setSelectedItem(partoA.getRaza()); 
		comboRazaPadre.setSelectedItem(partoA.getRazaPadre()); 
	}  
	   	
	public void DesactivarCampos (){
	   	
	   	textCodAnimal.setEnabled(false);
	   	comboRaza.setEnabled(false);
	   	comboSexo.setEnabled(false);
	   	radioVivo.setEnabled(false);
	   	radioMuerto.setEnabled(false);
	   	dateFechaNaci.setEnabled(false);
	   	textEdad.setEnabled(false);
	   	comboProcedencia.setEnabled(false);
	   	textNacer.setEnabled(false);
	   	textDestete.setEnabled(false);
	   	dateFechaDestete.setEnabled(false);
	   	dateFechaConsuAlimento.setEnabled(false);
	   	textCodParto.setEnabled(false);
	   	dateFechaParto.setEnabled(false);
	   	textCodMadre.setEnabled(false);
	   	textEdadMadre.setEnabled(false);
	   	comboRazaMadre.setEnabled(false);
	   	comboRazaPadre.setEnabled(false);
	   	radioEngorde.setEnabled(false);
	   	radioReemplazo.setEnabled(false);
	   	botonMas.setEnabled(false);    	
	   	
	}
	   	
	public void ActivarCampos (){
	   	
	   	comboSexo.setEnabled(true);
	   	radioVivo.setEnabled(true);
	   	radioMuerto.setEnabled(true);
	   	dateFechaNaci.setEnabled(true);
	   	//textEdad.setEnabled(true);
	   	comboProcedencia.setEnabled(true);
	   	textNacer.setEnabled(true);
	   	textDestete.setEnabled(true);
	   	dateFechaDestete.setEnabled(true);
	   	dateFechaConsuAlimento.setEnabled(true);
	   	textCodParto.setEnabled(true);
	   	dateFechaParto.setEnabled(true);
	   	textCodMadre.setEnabled(true);
	   	textEdadMadre.setEnabled(true);
	   	comboRazaMadre.setEnabled(true);
	   	comboRazaPadre.setEnabled(true);
	   	radioEngorde.setEnabled(true);
	   	radioReemplazo.setEnabled(true);
	   	botonMas.setEnabled(true);    	
	   	
	}
	   	
	public void Nuevo(){
	   			
		textCodAnimal.setText("");
		comboRaza.setSelectedItem(null);
		comboSexo.setSelectedItem(null);
		GrupoEstado.clearSelection();
		dateFechaNaci.setDate(null);
		textEdad.setText("");
		comboProcedencia.setSelectedItem(null); 
		textNacer.setText("");
		textDestete.setText("");
		dateFechaDestete.setDate(null);
		dateFechaConsuAlimento.setDate(null);
		textCodParto.setText("");
		dateFechaParto.setDate(null);
		textCodMadre.setText(""); 
		textEdadMadre.setText("");
		comboRazaMadre.setSelectedItem(null); 
		comboRazaPadre.setSelectedItem(null);
		GrupoTipoPor.clearSelection();  
		
	}
	
	//*************************************** METODOS PARA EL CRUD DE PARTOS *****************************************************************************************************************//
	
	    
	public void LimpiarCampos() {
	    
	    textCodPartoPar.setText("");
	    dateFechaPartPar.setDate(null);
	    textCodMadrePar.setText("");
	    comboRazaMadrePar.setSelectedItem(null);
	    comboRazaPadrePar.setSelectedItem(null);
	    textEdadPar.setText("");
	    textVivosPar.setText("");
	    textMuertosPar.setText("");
	    textCamadaPar.setText("");
	    
	}
	
	public void GuardarCamposPartos() {
		 
		try{	
		    parto = new DatosPartos();
		    parto.setCodParto(textCodPartoPar.getText());
		    parto.setFechaPart(dateFechaPartPar.getDate());
		    parto.setCodMadre(textCodMadrePar.getText());
		    parto.setRaza((String)comboRazaMadrePar.getSelectedItem());
		    parto.setRazaPadre((String)comboRazaPadrePar.getSelectedItem());
		    parto.setEdad(textEdadPar.getText()); 
		    parto.setNumVivos(textVivosPar.getText());
		    parto.setNumMuertos(textMuertosPar.getText());
		    parto.setTotalCamada(textCamadaPar.getText());
		}
	   	catch(Exception e){
	   		System.out.println("Error al listar los datos"+e.getMessage());
	   	}
	}
	
	public void llenarDatosPartos() {
		
		int opc=-2;
		String[]opciones = { "Código Parto","Código Madre","Edad Madre"};
		if (swModPartos==1){
				
			buscarParto = listaPar.BuscarParto(JOptionPane.showInputDialog("Ingrese el código del parto a modificar"));
		}else{
			
			opc = JOptionPane.showOptionDialog(null,"Seleccione la forma en que desea realizar la consulta",
												   "Consulta Partos|. Sistematización Granjas Porcícola - S.G.P.",JOptionPane.YES_NO_CANCEL_OPTION,
												   JOptionPane.QUESTION_MESSAGE,icoMensajePre,opciones,true);									   
			switch (opc){
				
				case 0:
					buscarParto = listaPar.BuscarParto(JOptionPane.showInputDialog("Ingrese el código del parto a consultar"));
					break;
				case 1:
					buscarParto = listaPar.BuscarPartoCodMadre(JOptionPane.showInputDialog("Ingrese el código de la madre del parto a consultar"));
					break;
				case 2:
					buscarParto = listaPar.BuscarPartoEdadMadre(JOptionPane.showInputDialog("Ingrese la edad de la madre del parto a consultar"));
					break;
			}
		}
		if (opc != -1){
		
			if (buscarParto!= null){
			    textCodPartoPar.setText(buscarParto.getCodParto());
				dateFechaPartPar.setDate(buscarParto.getFechaPart());  
			    textCodMadrePar.setText(buscarParto.getCodMadre());
			    comboRazaMadrePar.setSelectedItem(buscarParto.getRaza());
			    comboRazaPadrePar.setSelectedItem(buscarParto.getRazaPadre());
			    textEdadPar.setText(buscarParto.getEdad());
			    textVivosPar.setText(buscarParto.getNumVivos());
			    textMuertosPar.setText(buscarParto.getNumMuertos());
			    textCamadaPar.setText(buscarParto.getTotalCamada());
			}else{
				
				JOptionPane.showMessageDialog(null,"El registro del parto no existe","Gestionar Partos - S.G.P",
										      JOptionPane.OK_OPTION,icoMensajeInfor); 
			}
		}else{
			JOptionPane.showMessageDialog(null,"Se cancelo la consulta","Gestionar Partos - S.G.P",
										  JOptionPane.OK_OPTION,icoMensajeInfor);  
		} 	
		buscarParto = null;
	}
	
	public void ActivarCamposPartos(){
	    	
	    dateFechaPartPar.setEnabled(true);
	   	textCodMadrePar.setEnabled(true);
	   	comboRazaMadrePar.setEnabled(true);
	   	comboRazaPadrePar.setEnabled(true);
	    textEdadPar.setEnabled(true);
	    textVivosPar.setEnabled(true);
	    textMuertosPar.setEnabled(true);
	}
	    
	public void DesactivarCamposPartos(){
	    
	    textCodPartoPar.setEnabled(false);	
	    dateFechaPartPar.setEnabled(false);
	    comboRazaMadrePar.setEnabled(false);
	    comboRazaPadrePar.setEnabled(false);
	    textCodMadrePar.setEnabled(false);
	    textEdadPar.setEnabled(false);
	    textVivosPar.setEnabled(false);
	    textMuertosPar.setEnabled(false);
	    comboRazaMadrePar.setEditable(false);
	}
	
	public String codigoAnimales(int contador){
		
		int op; 
		String longitud, codigo = ""; 
		longitud = String.valueOf(contador);
		op = longitud.length(); 
		switch ( op ){
			
			case 1:
				codigo = "000"+longitud;
				break;
			case 2:
				codigo = "00"+longitud;
				break;
			case 3:
				codigo = "0"+longitud;
			case 4:
				codigo = longitud;
				break;
		}
		return codigo;
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
	    
	public void validarCamposPartos() {
	    
	    textCodPartoPar.addKeyListener(new java.awt.event.KeyAdapter() {
	    	public void keyTyped(java.awt.event.KeyEvent e) {
	        	v.validarLongitud(5, textCodPartoPar, e);
	            v.SoloNumeros(textCodPartoPar, e);
	            v.Obligatorios(textCodPartoPar, e);
	        }
	    });
	
	    this.textCodMadrePar.addKeyListener(new java.awt.event.KeyAdapter() {
	        public void keyTyped(java.awt.event.KeyEvent e) {
	            v.validarLongitud(5, textCodMadrePar, e);
	            v.SoloNumeros(textCodMadrePar, e);
	            v.Obligatorios(textCodMadrePar, e);
	        }
	    });
	        
	    this.textEdadPar.addKeyListener(new java.awt.event.KeyAdapter() {
	        public void keyTyped(java.awt.event.KeyEvent e) {
	            v.validarLongitud(3, textEdadPar, e);
	            v.SoloNumeros(textEdadPar, e);
	            v.Obligatorios(textEdadPar, e);
	        }
	    });
	        
	    this.textVivosPar.addKeyListener(new java.awt.event.KeyAdapter() {
	        public void keyTyped(java.awt.event.KeyEvent e) {
	            v.validarLongitud(2, textVivosPar, e);
	            v.SoloNumeros(textVivosPar, e);
	            v.Obligatorios(textVivosPar, e);
	        }
	    });
	        
	    this.textMuertosPar.addKeyListener(new java.awt.event.KeyAdapter() {
	        public void keyTyped(java.awt.event.KeyEvent e) {
	            v.validarLongitud(2, textMuertosPar, e);
	            v.SoloNumeros(textMuertosPar, e);
	            v.Obligatorios(textMuertosPar, e);
	        }
	    });
	     
	}
	    
	public void ValidarCamposDatosAni() {
	    
	    textCodAnimal.addKeyListener(new java.awt.event.KeyAdapter() {
	    	public void keyTyped(java.awt.event.KeyEvent e) {
	        	v.validarLongitud(5, textCodAnimal, e);
	            v.SoloNumeros(textCodAnimal, e);
	            v.Obligatorios(textCodAnimal, e);
	        }
	    });
	
	    this.textEdad.addKeyListener(new java.awt.event.KeyAdapter() {
	        public void keyTyped(java.awt.event.KeyEvent e) {
	            v.validarLongitud(2, textEdad, e);
	            v.SoloNumeros(textEdad, e);
	            v.Obligatorios(textEdad, e);
	        }
	    });
	        
	    this.textCodParto.addKeyListener(new java.awt.event.KeyAdapter() {
	        public void keyTyped(java.awt.event.KeyEvent e) {
	            v.validarLongitud(5, textCodParto, e);
	            v.SoloNumeros(textCodParto, e);
	            v.Obligatorios(textCodParto,e);
	        }
	    });
	        
	    this.textCodMadre.addKeyListener(new java.awt.event.KeyAdapter() {
	        public void keyTyped(java.awt.event.KeyEvent e) {
	            v.validarLongitud(5, textCodMadre, e);
	            v.SoloNumeros(textCodMadre, e);
	            v.Obligatorios(textCodMadre,e);
	        }
	    });
	        
	    this.textEdadMadre.addKeyListener(new java.awt.event.KeyAdapter() {
	        public void keyTyped(java.awt.event.KeyEvent e) {
	            v.validarLongitud(3, textEdadMadre, e);
	            v.SoloNumeros(textEdadMadre, e);
	        }
	    });
	        
	    this.textNacer.addKeyListener(new java.awt.event.KeyAdapter() {
	        public void keyTyped(java.awt.event.KeyEvent e) {
	            v.validarLongitud(5, textNacer, e);
	            v.SoloNumeros(textNacer, e);
	            v.Obligatorios(textNacer,e);
	        }
	    });
	    
	    this.textDestete.addKeyListener(new java.awt.event.KeyAdapter() {
	        public void keyTyped(java.awt.event.KeyEvent e) {
	            v.validarLongitud(5, textDestete, e);
	            v.SoloNumeros(textDestete, e);
	            v.Obligatorios(textDestete,e);
	        }
	    });
	    
		comboProcedencia.addItemListener(new ItemListener(){ 
	   		public void itemStateChanged(ItemEvent evento){
		
				if (evento.getStateChange()== ItemEvent.SELECTED ){ 
			        	if (comboProcedencia.getSelectedIndex() == 0){
			        		dateFechaParto.setEnabled(false);
				    		textCodMadre.setEnabled(false);
				    		textEdadMadre.setEnabled(false);
				    		comboRazaMadre.setEnabled(false);
				    		comboRazaPadre.setEnabled(false);
			        	}else{
					    	dateFechaParto.setEnabled(true);
				    		textCodMadre.setEnabled(true);
				    		textEdadMadre.setEnabled(true);
				    		comboRazaMadre.setEnabled(true);
				    		comboRazaPadre.setEnabled(true);
			    		} 		
				}
		
			} 
		}); 
     	
	      
	}

	public int Sumatoria (JTextField V, JTextField M){
	
		String Vivos, Muertos;
		int Camada;
	 
    	Vivos=V.getText();
    	Muertos=M.getText();
    
    	int   Viv = Integer.parseInt(Vivos);
   		int  Muert = Integer.parseInt(Muertos);
   	
    	Camada= Viv+Muert;
    
    	return Camada;
        
     //  String Cam=Double.toString(Camada);
	}
	
	
       
}