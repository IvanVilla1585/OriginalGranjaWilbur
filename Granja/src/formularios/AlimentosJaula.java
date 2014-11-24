import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;


public class AlimentosJaula extends JFrame implements ActionListener{
	
	JLabel labelCodAlimento, labelNomJaula, labelMetros, labelArea, labelNumAnimales, labelRacion, labelRaciDia, labelNumRaciones;
	JTextField textCodAlimento, textArea, textNumAnimales, textRacion, textRaciDia, textNumRaciones;
	JComboBox comboNomJaula;
	JButton botonCrear, botonGuardar, botonModificar, botonConsultar, botonEliminar, botonSalir;
	JPanel panelAnimaJaulas;
	JTable tablecrearAnimaJaulas;
	JScrollPane paneTablaAniJaulas;
	TitledBorder rotulo1; 
	private Object[][] datos = new Object[10][10];
    private Object[] columnas = {"Código Animal", "Edad en Semanas", "Etapa Desarrollo", "Alimento Kg./Día", "Alimento Kg./Semana"};
    private DefaultTableModel dataModel = new DefaultTableModel(datos, columnas);
	

    public AlimentosJaula() {
    	
    	super("Gestionar Alimentos por Jaula ");
        getContentPane().setLayout(null);
        setSize(652, 390);
        setResizable(true);
        setLocation(450, 150);
        setVisible(true);
    	
    	labelCodAlimento = new JLabel("Código del Alimento:");
        labelCodAlimento.setBounds(30, 25, 180, 25);
        this.getContentPane().add(labelCodAlimento);
        labelCodAlimento.setVisible(true);
        
        textCodAlimento = new JTextField("");
        textCodAlimento.setBounds(155, 25, 100, 25);
        this.getContentPane().add(textCodAlimento);
        textCodAlimento.setVisible(true);
        
        labelNomJaula = new JLabel("Nombre de la Jaula: ");
        labelNomJaula.setBounds(325, 25, 180, 25);
        this.getContentPane().add(labelNomJaula);
        labelNomJaula.setVisible(true);
        
        comboNomJaula = new JComboBox();
        comboNomJaula.addItem("");
        comboNomJaula.setBounds(452,25, 150, 25);
        this.getContentPane().add(comboNomJaula);
        comboNomJaula.setVisible(true);
        
        labelArea = new JLabel("Extensión:");
        labelArea.setBounds(30, 65, 180, 25);
        this.getContentPane().add(labelArea);
        labelArea.setVisible(true);
        
        textArea = new JTextField("");
        textArea.setBounds(155, 65, 100, 25);
        this.getContentPane().add(textArea);
        textArea.setVisible(true);
    	
    	labelMetros = new JLabel("Mts.");
        labelMetros.setBounds(255, 65, 180, 25);
        this.getContentPane().add(labelMetros);
        labelMetros.setVisible(true);
        
        labelNumAnimales = new JLabel("Número de Animales : ");
        labelNumAnimales.setBounds(325, 65, 180, 25);
        this.getContentPane().add(labelNumAnimales);
        labelNumAnimales.setVisible(true);
        
        textNumAnimales = new JTextField("");
        textNumAnimales.setBounds(452,65, 100, 25);
        this.getContentPane().add(textNumAnimales);
        textNumAnimales.setVisible(true);
        
        labelRacion = new JLabel("Kgs/Ración:");
        labelRacion.setBounds(30, 105, 180, 25);
        this.getContentPane().add(labelRacion);
        labelRacion.setVisible(true);
        
        textRacion = new JTextField("");
        textRacion.setBounds(155, 105, 100, 25);
        this.getContentPane().add(textRacion);
        textRacion.setVisible(true);
        
        labelRaciDia = new JLabel("Kgs/Día: ");
        labelRaciDia.setBounds(325, 105, 180, 25);
        this.getContentPane().add(labelRaciDia);
        labelRaciDia.setVisible(true);
        
        textRaciDia = new JTextField("");
        textRaciDia.setBounds(452,105, 100, 25);
        this.getContentPane().add(textRaciDia);
        textRaciDia.setVisible(true);
    	
    	labelNumRaciones = new JLabel("Número de Raciones:");
        labelNumRaciones.setBounds(30, 145, 180, 25);
        this.getContentPane().add(labelNumRaciones);
        labelNumRaciones.setVisible(true);
        
        textNumRaciones = new JTextField("");
        textNumRaciones.setBounds(155, 145, 100, 25);
        this.getContentPane().add(textNumRaciones);
        textNumRaciones.setVisible(true);
        
        JPanel panelAnimaJaulas = new JPanel();

        rotulo1 = BorderFactory.createTitledBorder("Identificación Animales en la Jaula");
        panelAnimaJaulas.setBorder(rotulo1);
        panelAnimaJaulas.setLayout(null);
        panelAnimaJaulas.setBounds(5, 180, 625, 125);
        panelAnimaJaulas.setVisible(true);
        panelAnimaJaulas.setBackground(Color.LIGHT_GRAY);
        this.getContentPane().add(panelAnimaJaulas);
        
        tablecrearAnimaJaulas = new JTable(dataModel);
        paneTablaAniJaulas = new JScrollPane(tablecrearAnimaJaulas);
        paneTablaAniJaulas.setBounds(8, 15, 610, 100);
        this.getContentPane().add(paneTablaAniJaulas);
        tablecrearAnimaJaulas.setVisible(true);
        paneTablaAniJaulas.setVisible(true);
        panelAnimaJaulas.add(paneTablaAniJaulas);
    	
    	botonCrear = new JButton("Crear");
        botonCrear.setBounds(10, 315, 90, 30);
        this.getContentPane().add(botonCrear);
        botonCrear.setVisible(true);
        botonCrear.addActionListener(this);
        
        botonGuardar = new JButton("Guardar");
        botonGuardar.setBounds(115, 315, 90, 30);
        this.getContentPane().add(botonGuardar);
        botonGuardar.setVisible(true);
        botonGuardar.addActionListener(this);
        
        botonModificar = new JButton("Modificar");
        botonModificar.setBounds(220, 315, 90, 30);
        this.getContentPane().add(botonModificar);
        botonModificar.setVisible(true);
        botonModificar.addActionListener(this);
        
        botonConsultar = new JButton("Consultar");
        botonConsultar.setBounds(325, 315, 90, 30);
        this.getContentPane().add(botonConsultar);
        botonConsultar.setVisible(true);
        botonConsultar.addActionListener(this);
        
        botonEliminar = new JButton("Eliminar");
        botonEliminar.setBounds(430, 315, 90, 30);
        this.getContentPane().add(botonEliminar);
        botonEliminar.setVisible(true);
        botonEliminar.addActionListener(this);
        
        botonSalir = new JButton("Salir");
        botonSalir.setBounds(535, 315, 90, 30);
        this.getContentPane().add(botonSalir);
        botonSalir.setVisible(true);
        botonSalir.addActionListener(this);
        
    	
    repaint();
    	
    	
    	
    	
    }
    
      public void actionPerformed(ActionEvent event) {
   			
  	}	
    	
    
    
    
}