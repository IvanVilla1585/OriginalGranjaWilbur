import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;

public class MaestroRazas extends JFrame implements ActionListener{
	
	JLabel labelCodRaza, labelNomRaza, labelNomVulgar, labelNomCienti;
	JTextField textCodRaza, textNomRaza, textNomVulgar, textNomCienti;
	JButton botonCrear, botonGuardar, botonModificar, botonConsultar, botonEliminar, botonSalir;

    public MaestroRazas() {
    
    	super("Maestro Razas ");
        getContentPane().setLayout(null);
        setSize(655, 180);
        setResizable(true);
        setLocation(350, 100);
        setVisible(true);
        
        labelCodRaza = new JLabel("Código de la Raza:");
        labelCodRaza.setBounds(7, 25, 150, 25);
        this.getContentPane().add(labelCodRaza);
        labelCodRaza.setVisible(true);
        
        textCodRaza = new JTextField("");
        textCodRaza.setBounds(115, 25, 100, 25);
        this.getContentPane().add(textCodRaza);
        textCodRaza.setVisible(true);
        
        labelNomRaza = new JLabel("Nombre de la Raza: ");
        labelNomRaza.setBounds(270, 25, 180, 25);
        this.getContentPane().add(labelNomRaza);
        labelNomRaza.setVisible(true);
        
        textNomRaza = new JTextField("");
        textNomRaza.setBounds(385, 25, 250, 25);
        this.getContentPane().add(textNomRaza);
        textNomRaza.setVisible(true);
        
        labelNomVulgar = new JLabel("Nombre Vulgar:");
        labelNomVulgar.setBounds(7, 65, 150, 25);
        this.getContentPane().add(labelNomVulgar);
        labelNomVulgar.setVisible(true);
        
        textNomVulgar = new JTextField("");
        textNomVulgar.setBounds(115, 65, 150, 25);
        this.getContentPane().add(textNomVulgar);
        textNomVulgar.setVisible(true);
        
        labelNomCienti = new JLabel("Nombre Científico: ");
        labelNomCienti.setBounds(270, 65, 180, 25);
        this.getContentPane().add(labelNomCienti);
        labelNomCienti.setVisible(true);
        
        textNomCienti = new JTextField("");
        textNomCienti.setBounds(385, 65, 250, 25);
        this.getContentPane().add(textNomCienti);
        textNomCienti.setVisible(true);
        
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