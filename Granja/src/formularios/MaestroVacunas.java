import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;


public class MaestroVacunas extends JFrame implements ActionListener{
	
	JLabel labelCodVacuna, labelNomVacuna, labelNumDosis, labelAplicacion;
	JTextField textCodVacuna, textNomVacuna, textNumDosis, textAplicacion;
	JButton botonCrear, botonGuardar, botonModificar, botonConsultar, botonEliminar, botonSalir;

    public MaestroVacunas() {
    	
    	super("Maestro Vacunas ");
        getContentPane().setLayout(null);
        setSize(655, 180);
        setResizable(true);
        setLocation(350, 100);
        setVisible(true);
        
        labelCodVacuna = new JLabel("Código de la Vacuna:");
        labelCodVacuna.setBounds(7, 25, 150, 25);
        this.getContentPane().add(labelCodVacuna);
        labelCodVacuna.setVisible(true);
        
        textCodVacuna = new JTextField("");
        textCodVacuna.setBounds(130, 25, 100, 25);
        this.getContentPane().add(textCodVacuna);
        textCodVacuna.setVisible(true);
        
        labelNomVacuna = new JLabel("Nombre de la Vacuna: ");
        labelNomVacuna.setBounds(255, 25, 180, 25);
        this.getContentPane().add(labelNomVacuna);
        labelNomVacuna.setVisible(true);
        
        textNomVacuna = new JTextField("");
        textNomVacuna.setBounds(385, 25, 250, 25);
        this.getContentPane().add(textNomVacuna);
        textNomVacuna.setVisible(true);
        
        labelNumDosis = new JLabel("Número de Dosis:");
        labelNumDosis.setBounds(7, 65, 150, 25);
        this.getContentPane().add(labelNumDosis);
        labelNumDosis.setVisible(true);
        
        textNumDosis = new JTextField("");
        textNumDosis.setBounds(130, 65, 100, 25);
        this.getContentPane().add(textNumDosis);
        textNumDosis.setVisible(true);
        
        labelAplicacion = new JLabel("Aplicación: ");
        labelAplicacion.setBounds(255, 65, 180, 25);
        this.getContentPane().add(labelAplicacion);
        labelAplicacion.setVisible(true);
        
        textAplicacion = new JTextField("");
        textAplicacion.setBounds(385, 65, 250, 25);
        this.getContentPane().add(textAplicacion);
        textAplicacion.setVisible(true);
        
        botonCrear = new JButton("Crear");
        botonCrear.setBounds(10, 105, 90, 30);
        this.getContentPane().add(botonCrear);
        botonCrear.setVisible(true);
        botonCrear.addActionListener(this);
        
        botonGuardar = new JButton("Guardar");
        botonGuardar.setBounds(115, 105, 90, 30);
        this.getContentPane().add(botonGuardar);
        botonGuardar.setVisible(true);
        botonGuardar.addActionListener(this);
        
        botonModificar = new JButton("Modificar");
        botonModificar.setBounds(220, 105, 90, 30);
        this.getContentPane().add(botonModificar);
        botonModificar.setVisible(true);
        botonModificar.addActionListener(this);
        
        botonConsultar = new JButton("Consultar");
        botonConsultar.setBounds(325, 105, 90, 30);
        this.getContentPane().add(botonConsultar);
        botonConsultar.setVisible(true);
        botonConsultar.addActionListener(this);
        
        botonEliminar = new JButton("Eliminar");
        botonEliminar.setBounds(430, 105, 90, 30);
        this.getContentPane().add(botonEliminar);
        botonEliminar.setVisible(true);
        botonEliminar.addActionListener(this);
        
        botonSalir = new JButton("Salir");
        botonSalir.setBounds(535, 105, 90, 30);
        this.getContentPane().add(botonSalir);
        botonSalir.setVisible(true);
        botonSalir.addActionListener(this);
    	
		repaint();
    		
    }
    
     public void actionPerformed(ActionEvent event) {
    
     }	    
    
    
}