import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;


public class Catalogo extends JFrame implements ActionListener{
	
	JLabel labelCodAnimal, labelRaza, labelPeso, labelKg, labelFechaNaci, labelEdad, labelSemanas;
	JTextField textCodAnimal, textPeso, textEdad;
	JComboBox comboRaza, comboFechaNaci;
	JButton botonCrear, botonGuardar, botonVerCatalogo, botonEliminar, botonSalir, botonCargarImag, botonAnterior, botonSiguiente;

    public Catalogo() {
    	
    	super("Catalogo");
        getContentPane().setLayout(null);
        setSize(652, 440);
        setResizable(true);
        setLocation(450, 150);
        setVisible(true);
    	
    	labelCodAnimal = new JLabel("Código del Animal:");
        labelCodAnimal.setBounds(30, 240, 180, 25);
        this.getContentPane().add(labelCodAnimal);
        labelCodAnimal.setVisible(true);
        
        textCodAnimal = new JTextField("");
        textCodAnimal.setBounds(140, 240, 100, 25);
        this.getContentPane().add(textCodAnimal);
        textCodAnimal.setVisible(true);
       
        botonCargarImag = new JButton("Cargar Imagen...");
        botonCargarImag.setBounds(452, 240, 150, 25);
        this.getContentPane().add(botonCargarImag);
        botonCargarImag.setVisible(true);
        botonCargarImag.addActionListener(this);
        
        labelPeso = new JLabel("Peso del Animal:");
        labelPeso.setBounds(30, 280, 180, 25);
        this.getContentPane().add(labelPeso);
        labelPeso.setVisible(true);
        
        textPeso = new JTextField("");
        textPeso.setBounds(140, 280, 50, 25);
        this.getContentPane().add(textPeso);
        textPeso.setVisible(true);
        
        labelKg = new JLabel("Kg.");
        labelKg.setBounds(193, 280, 180, 25);
        this.getContentPane().add(labelKg);
        labelKg.setVisible(true);
        
        labelRaza = new JLabel("Raza: ");
        labelRaza.setBounds(325, 280, 180, 25);
        this.getContentPane().add(labelRaza);
        labelRaza.setVisible(true);
        
        comboRaza = new JComboBox();
        comboRaza.addItem("");
        comboRaza.setBounds(452, 280, 150, 25);
        this.getContentPane().add(comboRaza);
        comboRaza.setVisible(true);
        
        labelEdad = new JLabel("Edad:");
        labelEdad.setBounds(30, 320, 180, 25);
        this.getContentPane().add(labelEdad);
        labelEdad.setVisible(true);
        
        textEdad = new JTextField("");
        textEdad.setBounds(140, 320, 50, 25);
        this.getContentPane().add(textEdad);
        textEdad.setVisible(true);
        
        labelSemanas = new JLabel("Semanas");
        labelSemanas.setBounds(193, 320, 180, 25);
        this.getContentPane().add(labelSemanas);
        labelSemanas.setVisible(true);
        
        labelFechaNaci = new JLabel("Fecha de Nacimiento: ");
        labelFechaNaci.setBounds(325, 320, 180, 25);
        this.getContentPane().add(labelFechaNaci);
        labelFechaNaci.setVisible(true);
        
        comboFechaNaci = new JComboBox();
        comboFechaNaci.addItem("");
        comboFechaNaci.setBounds(452,320, 150, 25);
        this.getContentPane().add(comboFechaNaci);
        comboFechaNaci.setVisible(true);
        
        botonAnterior = new JButton("<<<<<Anterior");
        botonAnterior.setBounds(100, 190, 200, 25);
        this.getContentPane().add(botonAnterior);
        botonAnterior.setVisible(true);
        botonAnterior.addActionListener(this);
        
        botonSiguiente = new JButton("Siguiente>>>>>");
        botonSiguiente.setBounds(340, 190, 200, 25);
        this.getContentPane().add(botonSiguiente);
        botonSiguiente.setVisible(true);
        botonSiguiente.addActionListener(this);
        
        botonCrear = new JButton("Crear");
        botonCrear.setBounds(30, 365, 90, 30);
        this.getContentPane().add(botonCrear);
        botonCrear.setVisible(true);
        botonCrear.addActionListener(this);
        
        botonGuardar = new JButton("Guardar");
        botonGuardar.setBounds(150, 365, 90, 30);
        this.getContentPane().add(botonGuardar);
        botonGuardar.setVisible(true);
        botonGuardar.addActionListener(this);
        
        botonVerCatalogo = new JButton("Ver Catalogo");
        botonVerCatalogo.setBounds(265, 365, 110, 30);
        this.getContentPane().add(botonVerCatalogo);
        botonVerCatalogo.setVisible(true);
        botonVerCatalogo.addActionListener(this);
        
        botonEliminar = new JButton("Eliminar");
        botonEliminar.setBounds(400, 365, 90, 30);
        this.getContentPane().add(botonEliminar);
        botonEliminar.setVisible(true);
        botonEliminar.addActionListener(this);
        
        botonSalir = new JButton("Salir");
        botonSalir.setBounds(520, 365, 90, 30);
        this.getContentPane().add(botonSalir);
        botonSalir.setVisible(true);
        botonSalir.addActionListener(this);
    	
    	repaint();
    		
    }
    
     public void actionPerformed(ActionEvent event) {
    
     }
    
    
    
}