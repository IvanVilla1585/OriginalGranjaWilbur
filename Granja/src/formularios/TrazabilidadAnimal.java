import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;


public class TrazabilidadAnimal extends JFrame implements ActionListener{
	
	JLabel labelCodAnimal, labelFechaParto, labelRaza, labelEdad, labelSemanas, labelSemanas1, labelEstado, labelSexo, labelPesoNacer, labelPesoDeste, labelK1, labelK2, labelK3;
	JLabel labelPesoActual, labelFechaDeste, labelFechaConsu, labelCodParto, labelCodMadre, labelEdadMadre, labelRazaMadre, labelRazaPadre, labelProcedencia;
	JLabel labelEtapaActual, labelAliDia, labelAliSema, labelK4, labelK5, labelJaula;
	JTextField textCodAnimal, textFechaParto, textRaza, textEdad, textEstado, textSexo, textPesoNacer, textPesoDeste, textFechaDeste;
	JTextField  textFechaConsu, textCodParto, textCodMadre, textEdadMadre, textRazaMadre, textRazaPadre, textProcedencia, textPesoActual;
	JTextField  textEtapaActual, textAliDia, textAliSema,textJaula;
	JPanel panelDatosAnimal, panelPesoAnimal, panelDatosParto, panelEtapaDesa, panelVacunas, panelInfecc;
	JRadioButton radioEngorde, radioReemplazo;
	JButton botonImprimir, botonLimpiar, botonConsultar, botonEliminar, botonSalir;
	JTable tablecrearVacunas, tablecrearInfecc;
	JScrollPane paneTablaVacunas, paneTablaInfecc;
	TitledBorder rotulo1, rotulo2, rotulo3, rotulo4,rotulo5, rotulo6; 
	private Object[][] datos = new Object[10][10];
    private Object[] columnas = {"Nombre", "Aplicación", "Fecha de Vacunación", "Número de Dosis", "Edad en Semanas"};
    private DefaultTableModel dataModel = new DefaultTableModel(datos, columnas);
    private Object[][] datos1 = new Object[10][10];
    private Object[] columnas1 = {"Nombre", "Tratamiento", "Fecha Inicio", "Fecha Final", "Frecuencia", "Aplicación", "Temperatura", "Edad en Semanas"};
    private DefaultTableModel dataModel1 = new DefaultTableModel(datos1, columnas1);

    public TrazabilidadAnimal() {
    	
    	super("Trazabilidad del Animal en la Granja ");
        getContentPane().setLayout(null);
        setSize(800, 700);
        setResizable(false);
        setLocation(350, 10);
        setVisible(true);
        
        JPanel panelDatosAnimal = new JPanel();

        rotulo1 = BorderFactory.createTitledBorder("Datos del Animal");
        panelDatosAnimal.setBorder(rotulo1);
        panelDatosAnimal.setLayout(null);
        panelDatosAnimal.setBounds(5, 25, 390, 140);
        panelDatosAnimal.setVisible(true);
        panelDatosAnimal.setBackground(Color.lightGray);
        this.getContentPane().add(panelDatosAnimal);
        
        labelCodAnimal = new JLabel("Código del Animal:");
        labelCodAnimal.setBounds(7, 25, 180, 25);
        this.getContentPane().add(labelCodAnimal);
        panelDatosAnimal.add(labelCodAnimal);
        labelCodAnimal.setVisible(true);
        
        textCodAnimal = new JTextField("");
        textCodAnimal.setBounds(115, 25, 100, 25);
        this.getContentPane().add(textCodAnimal);
        panelDatosAnimal.add(textCodAnimal);
        textCodAnimal.setVisible(true);
        
        labelRaza = new JLabel("Raza: ");
        labelRaza.setBounds(225, 25, 180, 25);
        this.getContentPane().add(labelRaza);
        panelDatosAnimal.add(labelRaza);
        labelRaza.setVisible(true);
        
        textRaza = new JTextField("");
        textRaza.setBounds(260, 25, 120, 25);
        this.getContentPane().add(textRaza);
        panelDatosAnimal.add(textRaza);
        textRaza.setVisible(true);
        
        labelSexo = new JLabel("Sexo:");
        labelSexo.setBounds(7, 65, 150, 25);
        this.getContentPane().add(labelSexo);
        panelDatosAnimal.add(labelSexo);
        labelSexo.setVisible(true);
        
        textSexo = new JTextField("");
        textSexo.setBounds(115, 65, 100, 25);
        this.getContentPane().add(textSexo);
        panelDatosAnimal.add(textSexo);
        textSexo.setVisible(true);
        
        labelEdad = new JLabel("Edad: ");
        labelEdad.setBounds(225, 65, 180, 25);
        this.getContentPane().add(labelEdad);
        panelDatosAnimal.add(labelEdad);
        labelEdad.setVisible(true);
        
        textEdad = new JTextField("");
        textEdad.setBounds(260, 65, 50, 25);
        this.getContentPane().add(textEdad);
        panelDatosAnimal.add(textEdad);
        textEdad.setVisible(true);
        
        labelSemanas = new JLabel("Semanas ");
        labelSemanas.setBounds(315, 65, 180, 25);
        this.getContentPane().add(labelSemanas);
        panelDatosAnimal.add(labelSemanas);
        labelSemanas.setVisible(true);
        
        labelEstado = new JLabel("Estado:");
        labelEstado.setBounds(7, 105, 150, 25);
        this.getContentPane().add(labelEstado);
        panelDatosAnimal.add(labelEstado);
        labelEstado.setVisible(true);
        
        textEstado = new JTextField("");
        textEstado.setBounds(115, 105, 100, 25);
        this.getContentPane().add(textEstado);
        panelDatosAnimal.add(textEstado);
        textEstado.setVisible(true);
        
        JPanel panelPesoAnimal = new JPanel();

        rotulo2 = BorderFactory.createTitledBorder("Peso del Animal");
        panelPesoAnimal.setBorder(rotulo2);
        panelPesoAnimal.setLayout(null);
        panelPesoAnimal.setBounds(400, 25, 390, 140);
        panelPesoAnimal.setVisible(true);
        panelPesoAnimal.setBackground(Color.lightGray);
        this.getContentPane().add(panelPesoAnimal);
        
        labelPesoNacer = new JLabel("Peso al Nacer:");
        labelPesoNacer.setBounds(7, 25, 180, 25);
        this.getContentPane().add(labelPesoNacer);
        panelPesoAnimal.add(labelPesoNacer);
        labelPesoNacer.setVisible(true);
        
        textPesoNacer = new JTextField("");
        textPesoNacer.setBounds(95, 25, 50, 25);
        this.getContentPane().add(textPesoNacer);
        panelPesoAnimal.add(textPesoNacer);
        textPesoNacer.setVisible(true);
        
        labelK1 = new JLabel("Kg.");
        labelK1.setBounds(147, 25, 180, 25);
        this.getContentPane().add(labelK1);
        panelPesoAnimal.add(labelK1);
        labelK1.setVisible(true);
        
        labelPesoDeste = new JLabel("Peso al Destete: ");
        labelPesoDeste.setBounds(175, 25, 180, 25);
        this.getContentPane().add(labelPesoDeste);
        panelPesoAnimal.add(labelPesoDeste);
        labelPesoDeste.setVisible(true);
        
        textPesoDeste = new JTextField("");
        textPesoDeste.setBounds(283, 25, 50, 25);
        this.getContentPane().add(textPesoDeste);
        panelPesoAnimal.add(textPesoDeste);
        textPesoDeste.setVisible(true);
        
        labelK2 = new JLabel("Kg.");
        labelK2.setBounds(335, 25, 180, 25);
        this.getContentPane().add(labelK2);
        panelPesoAnimal.add(labelK2);
        labelK2.setVisible(true);
        
        labelPesoActual = new JLabel("Peso Actual:");
        labelPesoActual.setBounds(7, 65, 180, 25);
        this.getContentPane().add(labelPesoActual);
        panelPesoAnimal.add(labelPesoActual);
        labelPesoActual.setVisible(true);
        
        textPesoActual = new JTextField("");
        textPesoActual.setBounds(95, 65, 50, 25);
        this.getContentPane().add(textPesoActual);
        panelPesoAnimal.add(textPesoActual);
        textPesoActual.setVisible(true);
        
        labelK3 = new JLabel("Kg.");
        labelK3.setBounds(147, 65, 180, 25);
        this.getContentPane().add(labelK3);
        panelPesoAnimal.add(labelK3);
        labelK3.setVisible(true);
        
        labelFechaDeste = new JLabel("Fecha del Destete: ");
        labelFechaDeste.setBounds(175, 65, 180, 25);
        this.getContentPane().add(labelFechaDeste);
        panelPesoAnimal.add(labelFechaDeste);
        labelFechaDeste.setVisible(true);
        
        textFechaDeste = new JTextField("");
        textFechaDeste.setBounds(283, 65, 100, 25);
        this.getContentPane().add(textFechaDeste);
        panelPesoAnimal.add(textFechaDeste);
        textFechaDeste.setVisible(true);
        
        labelFechaConsu = new JLabel("Fecha Ultimo Alimento:");
        labelFechaConsu.setBounds(150, 105, 180, 25);
        this.getContentPane().add(labelFechaConsu);
        panelPesoAnimal.add(labelFechaConsu);
        labelFechaConsu.setVisible(true);
        
        textFechaConsu = new JTextField("");
        textFechaConsu.setBounds(283, 105, 100, 25);
        this.getContentPane().add(textFechaConsu);
        panelPesoAnimal.add(textFechaConsu);
        textFechaConsu.setVisible(true);
        
        JPanel panelDatosParto = new JPanel();

        rotulo3 = BorderFactory.createTitledBorder("Datos del Parto");
        panelDatosParto.setBorder(rotulo3);
        panelDatosParto.setLayout(null);
        panelDatosParto.setBounds(5, 170, 390, 180);
        panelDatosParto.setVisible(true);
        panelDatosParto.setBackground(Color.lightGray);
        this.getContentPane().add(panelDatosParto);
        
        labelCodParto = new JLabel("Código Parto:");
        labelCodParto.setBounds(7, 25, 180, 25);
        this.getContentPane().add(labelCodParto);
        panelDatosParto.add(labelCodParto);
        labelCodParto.setVisible(true);
        
        textCodParto = new JTextField("");
        textCodParto.setBounds(91, 25, 100, 25);
        this.getContentPane().add(textCodParto);
        panelDatosParto.add(textCodParto);
        textCodParto.setVisible(true);
        
        labelFechaParto = new JLabel("Fecha Parto: ");
        labelFechaParto.setBounds(205, 25, 180, 25);
        this.getContentPane().add(labelFechaParto);
        panelDatosParto.add(labelFechaParto);
        labelFechaParto.setVisible(true);
        
        textFechaParto = new JTextField("");
        textFechaParto.setBounds(280, 25, 100, 25);
        this.getContentPane().add(textFechaParto);
        panelDatosParto.add(textFechaParto);
        textFechaParto.setVisible(true);
        
        labelCodMadre = new JLabel("Código Madre:");
        labelCodMadre.setBounds(7, 65, 180, 25);
        this.getContentPane().add(labelCodMadre);
        panelDatosParto.add(labelCodMadre);
        labelCodMadre.setVisible(true);
        
        textCodMadre = new JTextField("");
        textCodMadre.setBounds(91, 65, 100, 25);
        this.getContentPane().add(textCodMadre);
        panelDatosParto.add(textCodMadre);
        textCodMadre.setVisible(true);
        
        labelEdadMadre = new JLabel("Edad Madre: ");
        labelEdadMadre.setBounds(205, 65, 180, 25);
        this.getContentPane().add(labelEdadMadre);
        panelDatosParto.add(labelEdadMadre);
        labelEdadMadre.setVisible(true);
        
        textEdadMadre = new JTextField("");
        textEdadMadre.setBounds(280, 65, 50, 25);
        this.getContentPane().add(textEdadMadre);
        panelDatosParto.add(textEdadMadre);
        textEdadMadre.setVisible(true);
        
        labelSemanas1 = new JLabel("Semanas ");
        labelSemanas1.setBounds(330, 65, 180, 25);
        this.getContentPane().add(labelSemanas1);
        panelDatosParto.add(labelSemanas1);
        labelSemanas1.setVisible(true);
        
        labelRazaMadre = new JLabel("Raza Madre:");
        labelRazaMadre.setBounds(7, 105, 180, 25);
        this.getContentPane().add(labelRazaMadre);
        panelDatosParto.add(labelRazaMadre);
        labelRazaMadre.setVisible(true);
        
        textRazaMadre = new JTextField("");
        textRazaMadre.setBounds(91, 105, 100, 25);
        this.getContentPane().add(textRazaMadre);
        panelDatosParto.add(textRazaMadre);
        textRazaMadre.setVisible(true);
        
        labelRazaPadre = new JLabel("Edad Madre: ");
        labelRazaPadre.setBounds(205, 105, 180, 25);
        this.getContentPane().add(labelRazaPadre);
        panelDatosParto.add(labelRazaPadre);
        labelRazaPadre.setVisible(true);
        
        textRazaPadre = new JTextField("");
        textRazaPadre.setBounds(280, 105, 100, 25);
        this.getContentPane().add(textRazaPadre);
        panelDatosParto.add(textRazaPadre);
        textRazaPadre.setVisible(true);
        
        labelProcedencia = new JLabel("Procedencia:");
        labelProcedencia.setBounds(7, 145, 180, 25);
        this.getContentPane().add(labelProcedencia);
        panelDatosParto.add(labelProcedencia);
        labelProcedencia.setVisible(true);
        
        textProcedencia = new JTextField("");
        textProcedencia.setBounds(91, 145, 290, 25);
        this.getContentPane().add(textProcedencia);
        panelDatosParto.add(textProcedencia);
        textProcedencia.setVisible(true);
        
        JPanel panelEtapaDesa = new JPanel();

        rotulo4 = BorderFactory.createTitledBorder("Datos Etapa de Desarrollo");
        panelEtapaDesa.setBorder(rotulo4);
        panelEtapaDesa.setLayout(null);
        panelEtapaDesa.setBounds(400, 170, 390, 180);
        panelEtapaDesa.setVisible(true);
        panelEtapaDesa.setBackground(Color.lightGray);
        this.getContentPane().add(panelEtapaDesa);
        
        labelEtapaActual = new JLabel("Etapa Actual:");
        labelEtapaActual.setBounds(15, 25, 180, 25);
        this.getContentPane().add(labelEtapaActual);
        panelEtapaDesa.add(labelEtapaActual);
        labelEtapaActual.setVisible(true);
        
        textEtapaActual = new JTextField("");
        textEtapaActual.setBounds(95, 25, 287, 25);
        this.getContentPane().add(textEtapaActual);
        panelEtapaDesa.add(textEtapaActual);
        textEtapaActual.setVisible(true);
        
        labelAliDia = new JLabel("Consumo Alimento por Día: ");
        labelAliDia.setBounds(15, 65, 180, 25);
        this.getContentPane().add(labelAliDia);
        panelEtapaDesa.add(labelAliDia);
        labelAliDia.setVisible(true);
        
        textAliDia = new JTextField("");
        textAliDia.setBounds(203, 65, 50, 25);
        this.getContentPane().add(textAliDia);
        panelEtapaDesa.add(textAliDia);
        textAliDia.setVisible(true);
        
        labelK4 = new JLabel("Kg.");
        labelK4.setBounds(256, 65, 180, 25);
        this.getContentPane().add(labelK4);
        panelEtapaDesa.add(labelK4);
        labelK4.setVisible(true);
        
        labelAliSema = new JLabel("Consumo Alimento por Semana: ");
        labelAliSema.setBounds(15, 105, 200, 25);
        this.getContentPane().add(labelAliSema);
        panelEtapaDesa.add(labelAliSema);
        labelAliSema.setVisible(true);
        
        textAliSema = new JTextField("");
        textAliSema.setBounds(202, 105, 50, 25);
        this.getContentPane().add(textAliSema);
        panelEtapaDesa.add(textAliSema);
        textAliSema.setVisible(true);
        
        labelK5 = new JLabel("Kg.");
        labelK5.setBounds(255, 105, 100, 25);
        this.getContentPane().add(labelK5);
        panelEtapaDesa.add(labelK5);
        labelK5.setVisible(true);
        
        labelJaula = new JLabel("Jaula Actual:");
        labelJaula.setBounds(15, 145, 180, 25);
        this.getContentPane().add(labelJaula);
        panelEtapaDesa.add(labelJaula);
        labelJaula.setVisible(true);
        
        textJaula = new JTextField("");
        textJaula.setBounds(95, 145, 287, 25);
        this.getContentPane().add(textJaula);
        panelEtapaDesa.add(textJaula);
        textJaula.setVisible(true);
        
        radioEngorde = new JRadioButton("Animal de Engorde", false);
        add(radioEngorde);
        radioEngorde.setBounds(10, 350, 150, 25);
        radioEngorde.setVisible(true);
        
        radioReemplazo = new JRadioButton("Animal de Reemplazo", false);
        add(radioReemplazo);
        radioReemplazo.setBounds(170, 350, 150, 25);
        radioReemplazo.setVisible(true);
        
        JPanel panelVacunas = new JPanel();

        rotulo5 = BorderFactory.createTitledBorder("Vacunas");
        panelVacunas.setBorder(rotulo5);
        panelVacunas.setLayout(null);
        panelVacunas.setBounds(5, 375, 785, 125);
        panelVacunas.setVisible(true);
        panelVacunas.setBackground(Color.LIGHT_GRAY);
        this.getContentPane().add(panelVacunas);
        
        tablecrearVacunas = new JTable(dataModel);
        paneTablaVacunas = new JScrollPane(tablecrearVacunas);
        paneTablaVacunas.setBounds(8, 15, 770, 100);
        this.getContentPane().add(paneTablaVacunas);
        tablecrearVacunas.setVisible(true);
        paneTablaVacunas.setVisible(true);
        panelVacunas.add(paneTablaVacunas);
        
        JPanel panelInfecc = new JPanel();

        rotulo6 = BorderFactory.createTitledBorder("Agentes Infecciosos");
        panelInfecc.setBorder(rotulo6);
        panelInfecc.setLayout(null);
        panelInfecc.setBounds(5, 505, 785, 125);
        panelInfecc.setVisible(true);
        panelInfecc.setBackground(Color.LIGHT_GRAY);
        this.getContentPane().add(panelInfecc);
        
        tablecrearInfecc = new JTable(dataModel1);
        paneTablaInfecc = new JScrollPane(tablecrearInfecc);
        paneTablaInfecc.setBounds(5, 15, 770, 100);
        this.getContentPane().add(paneTablaInfecc);
        tablecrearInfecc.setVisible(true);
        paneTablaInfecc.setVisible(true);
        panelInfecc.add(paneTablaInfecc);
        
        botonConsultar = new JButton("Consultar");
        botonConsultar.setBounds(70, 635, 90, 30);
        this.getContentPane().add(botonConsultar);
        botonConsultar.setVisible(true);
        botonConsultar.addActionListener(this);
        
        botonImprimir = new JButton("Imprimir");
        botonImprimir.setBounds(210, 635, 90, 30);
        this.getContentPane().add(botonImprimir);
        botonImprimir.setVisible(true);
        botonImprimir.addActionListener(this);
        
        botonLimpiar = new JButton("Limpiar");
        botonLimpiar.setBounds(350, 635, 90, 30);
        this.getContentPane().add(botonLimpiar);
        botonLimpiar.setVisible(true);
        botonLimpiar.addActionListener(this);
              
        botonEliminar = new JButton("Eliminar");
        botonEliminar.setBounds(490, 635, 90, 30);
        this.getContentPane().add(botonEliminar);
        botonEliminar.setVisible(true);
        botonEliminar.addActionListener(this);
        
        botonSalir = new JButton("Salir");
        botonSalir.setBounds(630, 635, 90, 30);
        this.getContentPane().add(botonSalir);
        botonSalir.setVisible(true);
        botonSalir.addActionListener(this);
    	
    	repaint();
    		
    }
    
     public void actionPerformed(ActionEvent event) {
    
     }
    
    	
    
    
    
}