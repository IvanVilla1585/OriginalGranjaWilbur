import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.TitledBorder;

public class MaestroJaulas extends JFrame implements ActionListener{
	
	JLabel labelCodJaula, labelNomJaula, labelExtencion, labelMetros, labelFechaConstru;
	JTextField textCodJaula, textNomJaula, textExtencion;
	JButton botonCrear, botonGuardar, botonModificar, botonConsultar, botonEliminar, botonSalir;
	JComboBox comboFechaConstru;
	JRadioButton radioActiva, radioInactiva;
	JPanel panelEstado;
	TitledBorder rotulo1;

    public MaestroJaulas() {
    	
    	super("Maestro Jaulas ");
        getContentPane().setLayout(null);
        setSize(643, 260);
        setResizable(false);
        setLocation(350, 100);
        setVisible(true);
        
        labelCodJaula = new JLabel("Código Jaula:");
        labelCodJaula.setBounds(20, 25, 150, 25);
        this.getContentPane().add(labelCodJaula);
        labelCodJaula.setVisible(true);
        
        textCodJaula = new JTextField("");
        textCodJaula.setBounds(110, 25, 100, 25);
        this.getContentPane().add(textCodJaula);
        textCodJaula.setVisible(true);
        
        labelNomJaula = new JLabel("Nombre de la Jaula: ");
        labelNomJaula.setBounds(255, 25, 180, 25);
        this.getContentPane().add(labelNomJaula);
        labelNomJaula.setVisible(true);
        
        textNomJaula = new JTextField("");
        textNomJaula.setBounds(375, 25, 250, 25);
        this.getContentPane().add(textNomJaula);
        textNomJaula.setVisible(true);
        
        labelExtencion = new JLabel("Extensión:");
        labelExtencion.setBounds(20, 65, 150, 25);
        this.getContentPane().add(labelExtencion);
        labelExtencion.setVisible(true);
        
        textExtencion = new JTextField("");
        textExtencion.setBounds(110, 65, 100, 25);
        this.getContentPane().add(textExtencion);
        textExtencion.setVisible(true);
        
        labelMetros = new JLabel("Mts.");
        labelMetros.setBounds(213, 65, 150, 25);
        this.getContentPane().add(labelMetros);
        labelMetros.setVisible(true);
        
        labelFechaConstru = new JLabel("Fecha Construcción: ");
        labelFechaConstru.setBounds(255, 65, 180, 25);
        this.getContentPane().add(labelFechaConstru);
        labelFechaConstru.setVisible(true);
        
        comboFechaConstru = new JComboBox();
        comboFechaConstru.addItem("");
        comboFechaConstru.setBounds(375,65, 150, 25);
        this.getContentPane().add(comboFechaConstru);
        comboFechaConstru.setVisible(true);
        
        JPanel panelEstado = new JPanel();

        rotulo1 = BorderFactory.createTitledBorder("Estado");
        panelEstado.setBorder(rotulo1);
        panelEstado.setLayout(null);
        panelEstado.setBounds(65, 105, 503, 70);
        panelEstado.setVisible(true);
        panelEstado.setBackground(Color.lightGray);
        this.getContentPane().add(panelEstado);
        
        radioActiva = new JRadioButton("Activa", false);
        add(radioActiva);
        radioActiva.setBounds(90, 25, 80, 25);
        panelEstado.add(radioActiva);
        radioActiva.setVisible(true);
        
        radioInactiva = new JRadioButton("Inactiva", false);
        add(radioInactiva);
        radioInactiva.setBounds(355, 25, 80, 25);
        panelEstado.add(radioInactiva);
        radioInactiva.setVisible(true);
        
        botonCrear = new JButton("Crear");
        botonCrear.setBounds(10, 190, 90, 30);
        this.getContentPane().add(botonCrear);
        botonCrear.setVisible(true);
        botonCrear.addActionListener(this);
        
        botonGuardar = new JButton("Guardar");
        botonGuardar.setBounds(115, 190, 90, 30);
        this.getContentPane().add(botonGuardar);
        botonGuardar.setVisible(true);
        botonGuardar.addActionListener(this);
        
        botonModificar = new JButton("Modificar");
        botonModificar.setBounds(220, 190, 90, 30);
        this.getContentPane().add(botonModificar);
        botonModificar.setVisible(true);
        botonModificar.addActionListener(this);
        
        botonConsultar = new JButton("Consultar");
        botonConsultar.setBounds(325, 190, 90, 30);
        this.getContentPane().add(botonConsultar);
        botonConsultar.setVisible(true);
        botonConsultar.addActionListener(this);
        
        botonEliminar = new JButton("Eliminar");
        botonEliminar.setBounds(430, 190, 90, 30);
        this.getContentPane().add(botonEliminar);
        botonEliminar.setVisible(true);
        botonEliminar.addActionListener(this);
        
        botonSalir = new JButton("Salir");
        botonSalir.setBounds(535, 190, 90, 30);
        this.getContentPane().add(botonSalir);
        botonSalir.setVisible(true);
        botonSalir.addActionListener(this);
    	
		repaint();
    		
    }
    
     public void actionPerformed(ActionEvent event) {
    
     }
    	
    
    
    
}