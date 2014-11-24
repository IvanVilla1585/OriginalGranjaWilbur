import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;

public class GestionarAlimentos extends JFrame implements ActionListener{
	
	JLabel labelCodAlimento, labelNomAlimento, labelUnidad, labelSalida, labelEntrada, labelUni, labelCantAli, labelUni1, labelCantAli1;
	JLabel labelCodJaula, labelNomJaula, labelExistencia;
	JPanel panelMovimiento, panelEntrada, panelSalida;
	JButton botonCrear, botonGuardar, botonModificar, botonConsultar, botonEliminar, botonSalir, botonRegiEntrada, botonRegiSalida;
	JTextField textCodAlimento, textNomAlimento, textUni, textCantAli, textUni1, textCantAli1, textCodJaula, textNomJaula, textExistencia;
	JComboBox comboUnidad, comboIngreso, comboSalida;
	TitledBorder rotulo1, rotulo2, rotulo3;

    public GestionarAlimentos() {
    	
    	super("Gestionar Alimentos ");
        getContentPane().setLayout(null);
        setSize(655, 475);
        setResizable(true);
        setLocation(350, 100);
        setVisible(true);
        
        labelCodAlimento = new JLabel("Código del Alimento:");
        labelCodAlimento.setBounds(30, 25, 180, 25);
        this.getContentPane().add(labelCodAlimento);
        labelCodAlimento.setVisible(true);
        
        textCodAlimento = new JTextField("");
        textCodAlimento.setBounds(155, 25, 100, 25);
        this.getContentPane().add(textCodAlimento);
        textCodAlimento.setVisible(true);
        
        labelNomAlimento = new JLabel("Nombre del Alimento: ");
        labelNomAlimento.setBounds(335, 25, 180, 25);
        this.getContentPane().add(labelNomAlimento);
        labelNomAlimento.setVisible(true);
        
        textNomAlimento = new JTextField("");
        textNomAlimento.setBounds(462,25, 150, 25);
        this.getContentPane().add(textNomAlimento);
        textNomAlimento.setVisible(true);
        
        labelUnidad = new JLabel("Unidad de Medida:");
        labelUnidad.setBounds(30, 65, 180, 25);
        this.getContentPane().add(labelUnidad);
        labelUnidad.setVisible(true);
        
        comboUnidad = new JComboBox();
        comboUnidad.addItem("");
        comboUnidad.setBounds(155,65, 100, 25);
        this.getContentPane().add(comboUnidad);
        comboUnidad.setVisible(true);
        
        JPanel panelMovimiento = new JPanel();

        rotulo1 = BorderFactory.createTitledBorder("Tipo de Movimiento");
        panelMovimiento.setBorder(rotulo1);
        panelMovimiento.setLayout(null);
        panelMovimiento.setBounds(10, 105, 620, 200);
        panelMovimiento.setVisible(true);
        panelMovimiento.setBackground(Color.lightGray);
        this.getContentPane().add(panelMovimiento);
        
        JPanel panelEntrada = new JPanel();

        rotulo2 = BorderFactory.createTitledBorder("Entrada");
        panelEntrada.setBorder(rotulo2);
        panelEntrada.setLayout(null);
        panelEntrada.setBounds(10, 25, 295, 170);
        panelEntrada.setVisible(true);
        panelEntrada.setBackground(Color.lightGray);
        this.getContentPane().add(panelEntrada);
        panelMovimiento.add(panelEntrada);
        
        labelEntrada = new JLabel("Fecha de Entrada:");
        labelEntrada.setBounds(5, 25, 180, 25);
        this.getContentPane().add(labelEntrada);
        panelEntrada.add(labelEntrada);
        labelEntrada.setVisible(true);
        
        comboIngreso = new JComboBox();
        comboIngreso.addItem("");
        comboIngreso.setBounds(135,25, 150, 25);
        this.getContentPane().add(comboIngreso);
        panelEntrada.add(comboIngreso);
        comboIngreso.setVisible(true);
        
        labelUni = new JLabel("Unidad de Medida: ");
        labelUni.setBounds(5, 55, 180, 25);
        this.getContentPane().add(labelUni);
        panelEntrada.add(labelUni);
        labelUni.setVisible(true);
        
        textUni = new JTextField("");
        textUni.setBounds(135, 55, 100, 25);
        this.getContentPane().add(textUni);
        panelEntrada.add(textUni);
        textUni.setVisible(true);
        
        labelCantAli = new JLabel("Cantidad de Alimento: ");
        labelCantAli.setBounds(5, 85, 150, 25);
        this.getContentPane().add(labelCantAli);
        panelEntrada.add(labelCantAli);
        labelCantAli.setVisible(true);
        
        textCantAli = new JTextField("");
        textCantAli.setBounds(135, 85, 100, 25);
        this.getContentPane().add(textCantAli);
        panelEntrada.add(textCantAli);
        textCantAli.setVisible(true);
        
        botonRegiEntrada = new JButton("Registrar");
        botonRegiEntrada.setBounds(100, 125, 90, 30);
        this.getContentPane().add(botonRegiEntrada);
        panelEntrada.add(botonRegiEntrada);
        botonRegiEntrada.setVisible(true);
        botonRegiEntrada.addActionListener(this);
        
        JPanel panelSalida = new JPanel();

        rotulo3 = BorderFactory.createTitledBorder("Salida");
        panelSalida.setBorder(rotulo3);
        panelSalida.setLayout(null);
        panelSalida.setBounds(315, 25, 295, 170);
        panelSalida.setVisible(true);
        panelSalida.setBackground(Color.lightGray);
        this.getContentPane().add(panelSalida);
        panelMovimiento.add(panelSalida);
        
        labelSalida = new JLabel("Fecha de Salida:");
        labelSalida.setBounds(5, 25, 180, 25);
        this.getContentPane().add(labelSalida);
        panelSalida.add(labelSalida);
        labelSalida.setVisible(true);
        
        comboSalida = new JComboBox();
        comboSalida.addItem("");
        comboSalida.setBounds(135,25, 150, 25);
        this.getContentPane().add(comboSalida);
        panelSalida.add(comboSalida);
        comboSalida.setVisible(true);
        
        labelUni1 = new JLabel("Unidad de Medida: ");
        labelUni1.setBounds(5, 55, 180, 25);
        this.getContentPane().add(labelUni1);
        panelSalida.add(labelUni1);
        labelUni1.setVisible(true);
        
        textUni1 = new JTextField("");
        textUni1.setBounds(135, 55, 100, 25);
        this.getContentPane().add(textUni1);
        panelSalida.add(textUni1);
        textUni1.setVisible(true);
        
        labelCantAli1 = new JLabel("Cantidad de Alimento: ");
        labelCantAli1.setBounds(5, 85, 150, 25);
        this.getContentPane().add(labelCantAli1);
        panelSalida.add(labelCantAli1);
        labelCantAli1.setVisible(true);
        
        textCantAli1 = new JTextField("");
        textCantAli1.setBounds(135, 85, 100, 25);
        this.getContentPane().add(textCantAli1);
        panelSalida.add(textCantAli1);
        textCantAli1.setVisible(true);
        
        botonRegiSalida = new JButton("Registrar");
        botonRegiSalida.setBounds(100, 125, 90, 30);
        this.getContentPane().add(botonRegiSalida);
        panelSalida.add(botonRegiSalida);
        botonRegiSalida.setVisible(true);
        botonRegiSalida.addActionListener(this);
        
        labelCodJaula = new JLabel("Código de la Jaula:");
        labelCodJaula.setBounds(30, 320, 180, 25);
        this.getContentPane().add(labelCodJaula);
        labelCodJaula.setVisible(true);
        
        textCodJaula = new JTextField("");
        textCodJaula.setBounds(155, 320, 100, 25);
        this.getContentPane().add(textCodJaula);
        textCodJaula.setVisible(true);
        
        labelNomJaula = new JLabel("Nombre de la Jaula: ");
        labelNomJaula.setBounds(335, 320, 180, 25);
        this.getContentPane().add(labelNomJaula);
        labelNomJaula.setVisible(true);
        
        textNomJaula = new JTextField("");
        textNomJaula.setBounds(462,320, 150, 25);
        this.getContentPane().add(textNomJaula);
        textNomJaula.setVisible(true);
        
        labelExistencia = new JLabel("Existencia Actual:");
        labelExistencia.setBounds(30, 360, 180, 25);
        this.getContentPane().add(labelExistencia);
        labelExistencia.setVisible(true);
        
        textExistencia = new JTextField("");
        textExistencia.setBounds(155,360, 100, 25);
        this.getContentPane().add(textExistencia);
        textExistencia.setVisible(true);
        
      	botonCrear = new JButton("Crear");
        botonCrear.setBounds(10, 395, 90, 30);
        this.getContentPane().add(botonCrear);
        botonCrear.setVisible(true);
        botonCrear.addActionListener(this);
        
        botonGuardar = new JButton("Guardar");
        botonGuardar.setBounds(115, 395, 90, 30);
        this.getContentPane().add(botonGuardar);
        botonGuardar.setVisible(true);
        botonGuardar.addActionListener(this);
        
        botonModificar = new JButton("Modificar");
        botonModificar.setBounds(220, 395, 90, 30);
        this.getContentPane().add(botonModificar);
        botonModificar.setVisible(true);
        botonModificar.addActionListener(this);
        
        botonConsultar = new JButton("Consultar");
        botonConsultar.setBounds(325, 395, 90, 30);
        this.getContentPane().add(botonConsultar);
        botonConsultar.setVisible(true);
        botonConsultar.addActionListener(this);
        
        botonEliminar = new JButton("Eliminar");
        botonEliminar.setBounds(430, 395, 90, 30);
        this.getContentPane().add(botonEliminar);
        botonEliminar.setVisible(true);
        botonEliminar.addActionListener(this);
        
        botonSalir = new JButton("Salir");
        botonSalir.setBounds(535, 395, 90, 30);
        this.getContentPane().add(botonSalir);
        botonSalir.setVisible(true);
        botonSalir.addActionListener(this);
    	
    	
             	repaint();
    	
    	
    	
    	
    }
    
     public void actionPerformed(ActionEvent event) {
    
     }
    
    
}