import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;


public class MaestroAgentesInfec extends JFrame implements ActionListener{
	
	JLabel labelCodInfeccion, labelNomInfeccion, labelTratamiento, labelDiasTrata, labelFrecuencia, labelAplicacion;
	JTextField textCodInfeccion, textNomInfeccion, textTratamiento, textDiasTrata, textFrecuencia, textAplicacion;
	JButton botonCrear, botonGuardar, botonModificar, botonConsultar, botonEliminar, botonSalir;
	

    public MaestroAgentesInfec() {
    	
    	super("Maestro Agentes Infecciosos ");
        getContentPane().setLayout(null);
        setSize(643, 220);
        setResizable(false);
        setLocation(350, 100);
        setVisible(true);
        
        labelCodInfeccion = new JLabel("Código Infección:");
        labelCodInfeccion.setBounds(20, 25, 150, 25);
        this.getContentPane().add(labelCodInfeccion);
        labelCodInfeccion.setVisible(true);
        
        textCodInfeccion = new JTextField("");
        textCodInfeccion.setBounds(125, 25, 100, 25);
        this.getContentPane().add(textCodInfeccion);
        textCodInfeccion.setVisible(true);
        
        labelNomInfeccion = new JLabel("Nombre Infección: ");
        labelNomInfeccion.setBounds(255, 25, 180, 25);
        this.getContentPane().add(labelNomInfeccion);
        labelNomInfeccion.setVisible(true);
        
        textNomInfeccion = new JTextField("");
        textNomInfeccion.setBounds(365, 25, 250, 25);
        this.getContentPane().add(textNomInfeccion);
        textNomInfeccion.setVisible(true);
        
        labelDiasTrata = new JLabel("Días Tratamiento:");
        labelDiasTrata.setBounds(20, 65, 150, 25);
        this.getContentPane().add(labelDiasTrata);
        labelDiasTrata.setVisible(true);
        
        textDiasTrata = new JTextField("");
        textDiasTrata.setBounds(125, 65, 100, 25);
        this.getContentPane().add(textDiasTrata);
        textDiasTrata.setVisible(true);
        
        labelTratamiento = new JLabel("Tratamiento: ");
        labelTratamiento.setBounds(255, 65, 180, 25);
        this.getContentPane().add(labelTratamiento);
        labelTratamiento.setVisible(true);
        
        textTratamiento = new JTextField("");
        textTratamiento.setBounds(365, 65, 250, 25);
        this.getContentPane().add(textTratamiento);
        textTratamiento.setVisible(true);
        
        labelFrecuencia = new JLabel("Frecuencia:");
        labelFrecuencia.setBounds(20, 105, 150, 25);
        this.getContentPane().add(labelFrecuencia);
        labelFrecuencia.setVisible(true);
        
        textFrecuencia = new JTextField("");
        textFrecuencia.setBounds(125, 105, 100, 25);
        this.getContentPane().add(textFrecuencia);
        textFrecuencia.setVisible(true);
        
        labelAplicacion = new JLabel("Aplicación: ");
        labelAplicacion.setBounds(255, 105, 180, 25);
        this.getContentPane().add(labelAplicacion);
        labelAplicacion.setVisible(true);
        
        textAplicacion = new JTextField("");
        textAplicacion.setBounds(365, 105, 250, 25);
        this.getContentPane().add(textAplicacion);
        textAplicacion.setVisible(true);
        
        botonCrear = new JButton("Crear");
        botonCrear.setBounds(10, 150, 90, 30);
        this.getContentPane().add(botonCrear);
        botonCrear.setVisible(true);
        botonCrear.addActionListener(this);
        
        botonGuardar = new JButton("Guardar");
        botonGuardar.setBounds(115, 150, 90, 30);
        this.getContentPane().add(botonGuardar);
        botonGuardar.setVisible(true);
        botonGuardar.addActionListener(this);
        
        botonModificar = new JButton("Modificar");
        botonModificar.setBounds(220, 150, 90, 30);
        this.getContentPane().add(botonModificar);
        botonModificar.setVisible(true);
        botonModificar.addActionListener(this);
        
        botonConsultar = new JButton("Consultar");
        botonConsultar.setBounds(325, 150, 90, 30);
        this.getContentPane().add(botonConsultar);
        botonConsultar.setVisible(true);
        botonConsultar.addActionListener(this);
        
        botonEliminar = new JButton("Eliminar");
        botonEliminar.setBounds(430, 150, 90, 30);
        this.getContentPane().add(botonEliminar);
        botonEliminar.setVisible(true);
        botonEliminar.addActionListener(this);
        
        botonSalir = new JButton("Salir");
        botonSalir.setBounds(535, 150, 90, 30);
        this.getContentPane().add(botonSalir);
        botonSalir.setVisible(true);
        botonSalir.addActionListener(this);
    	
		repaint();
    		
    }
    
     public void actionPerformed(ActionEvent event) {
    
     }	
    	
    	
    	
   
    
    
}