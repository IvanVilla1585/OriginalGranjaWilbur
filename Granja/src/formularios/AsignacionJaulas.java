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


public class AsignacionJaulas extends JFrame implements ActionListener{
	
	JPanel panelDatosJaula, panelDatosAnimal, panelEstado;
	JButton botonCrear, botonGuardar, botonModificar, botonConsultar, botonEliminar, botonSalir;
	JLabel  labelCodJaula, labelExtencion, labelMetros, labelNumCerdos, labelCodCerdo, labelNomEtapa, labelSemanas, labelIngreso, labelEgreso;
	JTextField textCodJaula, textExtencion, textNumCerdos, textCodCerdo, textNomEtapa, textSemanas;
	JRadioButton radioPresente, radioTransferir;
	JComboBox comboIngreso, comboEgreso;
	TitledBorder rotulo1, rotulo2, rotulo3;
	
    public AsignacionJaulas() {
    	
    	super("Gestionar Asignación de Jaulas   ");
        getContentPane().setLayout(null);
        setSize(650, 420);
        setResizable(true);
        setLocation(300, 50);
        setVisible(true);
        
        JPanel panelDatosJaula = new JPanel();

        rotulo1 = BorderFactory.createTitledBorder("Datos de la Jaula");
        panelDatosJaula.setBorder(rotulo1);
        panelDatosJaula.setLayout(null);
        panelDatosJaula.setBounds(23, 10, 590, 100);
        panelDatosJaula.setVisible(true);
        panelDatosJaula.setBackground(Color.lightGray);
        this.getContentPane().add(panelDatosJaula);
        
        labelCodJaula = new JLabel("Código de la Jaula:");
        labelCodJaula.setBounds(5, 25, 180, 25);
        this.getContentPane().add(labelCodJaula);
        panelDatosJaula.add(labelCodJaula);
        labelCodJaula.setVisible(true);
        
        textCodJaula = new JTextField("");
        textCodJaula.setBounds(175, 25, 100, 25);
        this.getContentPane().add(textCodJaula);
        panelDatosJaula.add(textCodJaula);
        textCodJaula.setVisible(true);
        
        labelExtencion = new JLabel("Extensión: ");
        labelExtencion.setBounds(315, 25, 180, 25);
        this.getContentPane().add(labelExtencion);
        panelDatosJaula.add(labelExtencion);
        labelExtencion.setVisible(true);
        
        textExtencion = new JTextField("");
        textExtencion.setBounds(432, 25, 100, 25);
        this.getContentPane().add(textExtencion);
        panelDatosJaula.add(textExtencion);
        textExtencion.setVisible(true);
        
        labelMetros = new JLabel("Mts ");
        labelMetros.setBounds(535, 25, 150, 25);
        this.getContentPane().add(labelMetros);
        panelDatosJaula.add(labelMetros);
        labelMetros.setVisible(true);
        
        labelNumCerdos = new JLabel("Número de Cerdos por Jaula:");
        labelNumCerdos.setBounds(5, 65, 180, 25);
        this.getContentPane().add(labelNumCerdos);
        panelDatosJaula.add(labelNumCerdos);
        labelNumCerdos.setVisible(true);
        
        textNumCerdos = new JTextField("");
        textNumCerdos.setBounds(175, 65, 100, 25);
        this.getContentPane().add(textNumCerdos);
        panelDatosJaula.add(textNumCerdos);
        textNumCerdos.setVisible(true);
        
        JPanel panelDatosAnimal = new JPanel();

        rotulo2 = BorderFactory.createTitledBorder("Datos del Animal");
        panelDatosAnimal.setBorder(rotulo2);
        panelDatosAnimal.setLayout(null);
        panelDatosAnimal.setBounds(23, 120, 590, 100);
        panelDatosAnimal.setVisible(true);
        panelDatosAnimal.setBackground(Color.lightGray);
        this.getContentPane().add(panelDatosAnimal);
        
        labelCodCerdo = new JLabel("Código del Animal:");
        labelCodCerdo.setBounds(5, 25, 180, 25);
        this.getContentPane().add(labelCodCerdo);
        panelDatosAnimal.add(labelCodCerdo);
        labelCodCerdo.setVisible(true);
        
        textCodCerdo = new JTextField("");
        textCodCerdo.setBounds(175, 25, 100, 25);
        this.getContentPane().add(textCodCerdo);
        panelDatosAnimal.add(textCodCerdo);
        textCodCerdo.setVisible(true);
        
        labelNomEtapa = new JLabel("Etapa de Desarrollo: ");
        labelNomEtapa.setBounds(315, 25, 180, 25);
        this.getContentPane().add(labelNomEtapa);
        panelDatosAnimal.add(labelNomEtapa);
        labelNomEtapa.setVisible(true);
        
        textNomEtapa = new JTextField("");
        textNomEtapa.setBounds(432, 25, 150, 25);
        this.getContentPane().add(textNomEtapa);
        panelDatosAnimal.add(textNomEtapa);
        textNomEtapa.setVisible(true);
        
        labelSemanas = new JLabel("Edad en Semanas:");
        labelSemanas.setBounds(5, 65, 180, 25);
        this.getContentPane().add(labelSemanas);
        panelDatosAnimal.add(labelSemanas);
        labelSemanas.setVisible(true);
        
        textSemanas = new JTextField("");
        textSemanas.setBounds(175, 65, 100, 25);
        this.getContentPane().add(textSemanas);
        panelDatosAnimal.add(textSemanas);
        textSemanas.setVisible(true);
        
        JPanel panelEstado = new JPanel();

        rotulo3 = BorderFactory.createTitledBorder("Estado");
        panelEstado.setBorder(rotulo3);
        panelEstado.setLayout(null);
        panelEstado.setBounds(23, 230, 590, 100);
        panelEstado.setVisible(true);
        panelEstado.setBackground(Color.lightGray);
        this.getContentPane().add(panelEstado);
        
        radioPresente = new JRadioButton("Presente", false);
        add(radioPresente);
        radioPresente.setBounds(5, 25, 100, 25);
        panelEstado.add(radioPresente);
        radioPresente.setVisible(true);
        
        radioTransferir = new JRadioButton("Transferir", false);
        add(radioTransferir);
        radioTransferir.setBounds(315, 25, 100, 25);
        panelEstado.add(radioTransferir);
        radioTransferir.setVisible(true);
        
        labelIngreso = new JLabel("Fecha de Ingreso: ");
        labelIngreso.setBounds(5, 65, 180, 25);
        this.getContentPane().add(labelIngreso);
        panelEstado.add(labelIngreso);
        labelIngreso.setVisible(true);
        
        comboIngreso = new JComboBox();
        comboIngreso.addItem("");
        comboIngreso.setBounds(175,65, 120, 25);
        this.getContentPane().add(comboIngreso);
        panelEstado.add(comboIngreso);
        comboIngreso.setVisible(true);
        
        labelEgreso = new JLabel("Fecha de Egreso: ");
        labelEgreso.setBounds(315, 65, 180, 25);
        this.getContentPane().add(labelEgreso);
        panelEstado.add(labelEgreso);
        labelEgreso.setVisible(true);
        
        comboEgreso = new JComboBox();
        comboEgreso.addItem("");
        comboEgreso.setBounds(432,65, 120, 25);
        this.getContentPane().add(comboEgreso);
        panelEstado.add(comboEgreso);
        comboEgreso.setVisible(true);
        
        botonCrear = new JButton("Crear");
        botonCrear.setBounds(10, 340, 90, 30);
        this.getContentPane().add(botonCrear);
        botonCrear.setVisible(true);
        botonCrear.addActionListener(this);
        
        botonGuardar = new JButton("Guardar");
        botonGuardar.setBounds(115, 340, 90, 30);
        this.getContentPane().add(botonGuardar);
        botonGuardar.setVisible(true);
        botonGuardar.addActionListener(this);
        
        botonModificar = new JButton("Modificar");
        botonModificar.setBounds(220, 340, 90, 30);
        this.getContentPane().add(botonModificar);
        botonModificar.setVisible(true);
        botonModificar.addActionListener(this);
        
        botonConsultar = new JButton("Consultar");
        botonConsultar.setBounds(325, 340, 90, 30);
        this.getContentPane().add(botonConsultar);
        botonConsultar.setVisible(true);
        botonConsultar.addActionListener(this);
        
        botonEliminar = new JButton("Eliminar");
        botonEliminar.setBounds(430, 340, 90, 30);
        this.getContentPane().add(botonEliminar);
        botonEliminar.setVisible(true);
        botonEliminar.addActionListener(this);
        
        botonSalir = new JButton("Salir");
        botonSalir.setBounds(535, 340, 90, 30);
        this.getContentPane().add(botonSalir);
        botonSalir.setVisible(true);
        botonSalir.addActionListener(this);
        
        
        
        
        
               	repaint();
    	
    	
    	
    	
    }
    
     public void actionPerformed(ActionEvent event) {
    
     }
    
}