import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;

public class MaestroMunicipios extends JFrame implements ActionListener{
	
	JLabel labelCodMuni, labelNomMuni;
	JTextField textCodMuni, textNomMuni;
	JButton botonCrear, botonGuardar, botonModificar, botonConsultar, botonEliminar, botonSalir;
	

    public MaestroMunicipios() {
    	
    	super("Maestro Municipios ");
        getContentPane().setLayout(null);
        setSize(655, 180);
        setResizable(true);
        setLocation(350, 100);
        setVisible(true);
        
        labelCodMuni = new JLabel("Código del Municipio:");
        labelCodMuni.setBounds(50, 25, 200, 25);
        this.getContentPane().add(labelCodMuni);
        labelCodMuni.setVisible(true);
        
        textCodMuni = new JTextField("");
        textCodMuni.setBounds(200, 25, 100, 25);
        this.getContentPane().add(textCodMuni);
        textCodMuni.setVisible(true);
        
        labelNomMuni = new JLabel("Municipio:");
        labelNomMuni.setBounds(50, 65, 200, 25);
        this.getContentPane().add(labelNomMuni);
        labelNomMuni.setVisible(true);
        
        textNomMuni = new JTextField("");
        textNomMuni.setBounds(200, 65, 380, 25);
        this.getContentPane().add(textNomMuni);
        textNomMuni.setVisible(true);
        
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