import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.TitledBorder;


public class MaestroEtapas extends JFrame implements ActionListener{
	
	JLabel labelCodEtapa, labelNomEtapa, labelDeSemana, labelASemana,labelDia, labelSemana, labelSemana1, labelSemana2, labelSemana3, labelSemana4;
	JLabel labelSemana5, labelSemana6, labelSemana7, labelSemana8, labelKg1, labelKg2, labelKg3, labelKg4, labelKg5, labelKg6, labelKg7, labelKg8;
	JTextField textCodEtapa, textNomEtapa, textDeSemana, textASemana, textSemana1, textSemana2, textSemana3, textSemana4, textSemana5, textSemana6, textSemana7;
	JTextField textSemana, textSemana8, textDia1, textDia2, textDia3, textDia4, textDia5, textDia6, textDia7, textDia8;
	JTextField textSem1, textSem2, textSem3, textSem4, textSem5, textSem6, textSem7, textSem8;
	JPanel panelDiaSemana;
	JButton botonCrear, botonGuardar, botonModificar, botonConsultar, botonEliminar, botonSalir;
	TitledBorder rotulo1;
	

    public MaestroEtapas() {
    	
    	super("Maestro Etapas de Desarrollo ");
        getContentPane().setLayout(null);
        setSize(643, 490);
        setResizable(false);
        setLocation(350, 100);
        setVisible(true);
        
        labelCodEtapa = new JLabel("Código Etapa:");
        labelCodEtapa.setBounds(30, 25, 150, 25);
        this.getContentPane().add(labelCodEtapa);
        labelCodEtapa.setVisible(true);
        
        textCodEtapa = new JTextField("");
        textCodEtapa.setBounds(118, 25, 100, 25);
        this.getContentPane().add(textCodEtapa);
        textCodEtapa.setVisible(true);
        
        labelNomEtapa = new JLabel("Nombre de Etapa: ");
        labelNomEtapa.setBounds(300, 25, 180, 25);
        this.getContentPane().add(labelNomEtapa);
        labelNomEtapa.setVisible(true);
        
        textNomEtapa= new JTextField("");
        textNomEtapa.setBounds(405, 25, 200, 25);
        this.getContentPane().add(textNomEtapa);
        textNomEtapa.setEnabled(false);
        textNomEtapa.setVisible(true);
        
        labelDeSemana = new JLabel("De la Semana:");
        labelDeSemana.setBounds(30, 65, 150, 25);
        this.getContentPane().add(labelDeSemana);
        labelDeSemana.setVisible(true);
        
        textDeSemana = new JTextField("");
        textDeSemana.setBounds(116, 65, 100, 25);
        this.getContentPane().add(textDeSemana);
        textDeSemana.setVisible(true);
        
        labelASemana = new JLabel("A la Semana: ");
        labelASemana.setBounds(300, 65, 180, 25);
        this.getContentPane().add(labelASemana);
        labelASemana.setVisible(true);
        
        textASemana= new JTextField("");
        textASemana.setBounds(405, 65, 100, 25);
        this.getContentPane().add(textASemana);
        textASemana.setVisible(true);
        
        JPanel panelDiaSemana = new JPanel();

        rotulo1 = BorderFactory.createTitledBorder("Alimentación por Día y Semana en Kg.");
        panelDiaSemana.setBorder(rotulo1);
        panelDiaSemana.setLayout(null);
        panelDiaSemana.setBounds(105, 110, 426, 300);
        panelDiaSemana.setVisible(true);
        panelDiaSemana.setBackground(Color.lightGray);
        this.getContentPane().add(panelDiaSemana);
        
        labelDia = new JLabel("Día");
        labelDia.setBounds(190, 25, 180, 25);
        this.getContentPane().add(labelDia);
        panelDiaSemana.add(labelDia);
        labelDia.setVisible(true);
        
        labelSemana = new JLabel("Semana");
        labelSemana.setBounds(301, 25, 180, 25);
        this.getContentPane().add(labelSemana);
        panelDiaSemana.add(labelSemana);
        labelSemana.setVisible(true);
        
        labelSemana1 = new JLabel("Semana:");
        labelSemana1.setBounds(25, 55, 100, 25);
        this.getContentPane().add(labelSemana1);
        panelDiaSemana.add(labelSemana1);
        labelSemana1.setVisible(true);
        
        textSem1 = new JTextField("");
        textSem1.setBounds(85, 55, 30, 25);
        this.getContentPane().add(textSem1);
        panelDiaSemana.add(textSem1);
        textSem1.setBackground(Color.LIGHT_GRAY);
        textSem1.setVisible(true);
        
        textDia1 = new JTextField("");
        textDia1.setBounds(150, 55, 100, 25);
        this.getContentPane().add(textDia1);
        panelDiaSemana.add(textDia1);
        textDia1.setVisible(true);
        
        textSemana1 = new JTextField("");
        textSemana1.setBounds(275, 55, 100, 25);
        this.getContentPane().add(textSemana1);
        panelDiaSemana.add(textSemana1);
        textSemana1.setVisible(true);
        
        labelKg1 = new JLabel("Kg.");
        labelKg1.setBounds(376, 55, 50, 25);
        this.getContentPane().add(labelKg1);
        panelDiaSemana.add(labelKg1);
        labelKg1.setVisible(true);
        
        labelSemana2 = new JLabel("Semana:");
        labelSemana2.setBounds(25, 85, 100, 25);
        this.getContentPane().add(labelSemana2);
        panelDiaSemana.add(labelSemana2);
        labelSemana2.setVisible(true);
        
        textSem2 = new JTextField("");
        textSem2.setBounds(85, 85, 30, 25);
        this.getContentPane().add(textSem2);
        panelDiaSemana.add(textSem2);
        textSem2.setBackground(Color.LIGHT_GRAY);
        textSem2.setVisible(true);
        
        textDia2 = new JTextField("");
        textDia2.setBounds(150, 85, 100, 25);
        this.getContentPane().add(textDia2);
        panelDiaSemana.add(textDia2);
        textDia2.setVisible(true);
        
        textSemana2 = new JTextField("");
        textSemana2.setBounds(275, 85, 100, 25);
        this.getContentPane().add(textSemana2);
        panelDiaSemana.add(textSemana2);
        textSemana2.setVisible(true);
        
        labelKg2 = new JLabel("Kg.");
        labelKg2.setBounds(376, 85, 50, 25);
        this.getContentPane().add(labelKg2);
        panelDiaSemana.add(labelKg2);
        labelKg2.setVisible(true);
        
        labelSemana3 = new JLabel("Semana:");
        labelSemana3.setBounds(25, 115, 100, 25);
        this.getContentPane().add(labelSemana3);
        panelDiaSemana.add(labelSemana3);
        labelSemana3.setVisible(true);
        
        textSem3 = new JTextField("");
        textSem3.setBounds(85, 115, 30, 25);
        this.getContentPane().add(textSem3);
        panelDiaSemana.add(textSem3);
        textSem3.setBackground(Color.LIGHT_GRAY);
        textSem3.setVisible(true);
        
        textDia3 = new JTextField("");
        textDia3.setBounds(150, 115, 100, 25);
        this.getContentPane().add(textDia3);
        panelDiaSemana.add(textDia3);
        textDia3.setVisible(true);
        
        textSemana3 = new JTextField("");
        textSemana3.setBounds(275, 115, 100, 25);
        this.getContentPane().add(textSemana3);
        panelDiaSemana.add(textSemana3);
        textSemana3.setVisible(true);
        
        labelKg3 = new JLabel("Kg.");
        labelKg3.setBounds(376, 115, 50, 25);
        this.getContentPane().add(labelKg3);
        panelDiaSemana.add(labelKg3);
        labelKg3.setVisible(true);
        
        labelSemana4 = new JLabel("Semana:");
        labelSemana4.setBounds(25, 145, 100, 25);
        this.getContentPane().add(labelSemana4);
        panelDiaSemana.add(labelSemana4);
        labelSemana4.setVisible(true);
        
        textSem4 = new JTextField("");
        textSem4.setBounds(85, 145, 30, 25);
        this.getContentPane().add(textSem4);
        panelDiaSemana.add(textSem4);
        textSem4.setBackground(Color.LIGHT_GRAY);
        textSem4.setVisible(true);
        
        textDia4 = new JTextField("");
        textDia4.setBounds(150, 145, 100, 25);
        this.getContentPane().add(textDia4);
        panelDiaSemana.add(textDia4);
        textDia4.setVisible(true);
        
        textSemana4 = new JTextField("");
        textSemana4.setBounds(275, 145, 100, 25);
        this.getContentPane().add(textSemana4);
        panelDiaSemana.add(textSemana4);
        textSemana4.setVisible(true);
        
        labelKg4 = new JLabel("Kg.");
        labelKg4.setBounds(376, 145, 50, 25);
        this.getContentPane().add(labelKg4);
        panelDiaSemana.add(labelKg4);
        labelKg4.setVisible(true);
        
        labelSemana5 = new JLabel("Semana:");
        labelSemana5.setBounds(25, 175, 100, 25);
        this.getContentPane().add(labelSemana5);
        panelDiaSemana.add(labelSemana5);
        labelSemana5.setVisible(true);
        
        textSem5 = new JTextField("");
        textSem5.setBounds(85, 175, 30, 25);
        this.getContentPane().add(textSem5);
        panelDiaSemana.add(textSem5);
        textSem5.setBackground(Color.LIGHT_GRAY);
        textSem5.setVisible(true);
        
        textDia5 = new JTextField("");
        textDia5.setBounds(150, 175, 100, 25);
        this.getContentPane().add(textDia5);
        panelDiaSemana.add(textDia5);
        textDia5.setVisible(true);
        
        textSemana5 = new JTextField("");
        textSemana5.setBounds(275, 175, 100, 25);
        this.getContentPane().add(textSemana5);
        panelDiaSemana.add(textSemana5);
        textSemana5.setVisible(true);
        
        labelKg5 = new JLabel("Kg.");
        labelKg5.setBounds(376, 175, 50, 25);
        this.getContentPane().add(labelKg5);
        panelDiaSemana.add(labelKg5);
        labelKg5.setVisible(true);
        
        labelSemana6 = new JLabel("Semana:");
        labelSemana6.setBounds(25, 205, 100, 25);
        this.getContentPane().add(labelSemana6);
        panelDiaSemana.add(labelSemana6);
        labelSemana6.setVisible(true);
        
        textSem6 = new JTextField("");
        textSem6.setBounds(85, 205, 30, 25);
        this.getContentPane().add(textSem6);
        panelDiaSemana.add(textSem6);
        textSem6.setBackground(Color.LIGHT_GRAY);
        textSem6.setVisible(true);
        
        textDia6 = new JTextField("");
        textDia6.setBounds(150, 205, 100, 25);
        this.getContentPane().add(textDia6);
        panelDiaSemana.add(textDia6);
        textDia6.setVisible(true);
        
        textSemana6 = new JTextField("");
        textSemana6.setBounds(275, 205, 100, 25);
        this.getContentPane().add(textSemana6);
        panelDiaSemana.add(textSemana6);
        textSemana6.setVisible(true);
        
        labelKg6 = new JLabel("Kg.");
        labelKg6.setBounds(376, 205, 50, 25);
        this.getContentPane().add(labelKg6);
        panelDiaSemana.add(labelKg6);
        labelKg6.setVisible(true);
        
        labelSemana7 = new JLabel("Semana:");
        labelSemana7.setBounds(25, 235, 100, 25);
        this.getContentPane().add(labelSemana7);
        panelDiaSemana.add(labelSemana7);
        labelSemana7.setVisible(true);
        
        textSem7 = new JTextField("");
        textSem7.setBounds(85, 235, 30, 25);
        this.getContentPane().add(textSem7);
        panelDiaSemana.add(textSem7);
        textSem7.setBackground(Color.LIGHT_GRAY);
        textSem7.setVisible(true);
        
        textDia7 = new JTextField("");
        textDia7.setBounds(150, 235, 100, 25);
        this.getContentPane().add(textDia7);
        panelDiaSemana.add(textDia7);
        textDia7.setVisible(true);
        
        textSemana7 = new JTextField("");
        textSemana7.setBounds(275, 235, 100, 25);
        this.getContentPane().add(textSemana7);
        panelDiaSemana.add(textSemana7);
        textSemana7.setVisible(true);
        
        labelKg7 = new JLabel("Kg.");
        labelKg7.setBounds(376, 235, 50, 25);
        this.getContentPane().add(labelKg7);
        panelDiaSemana.add(labelKg7);
        labelKg7.setVisible(true);
        
        labelSemana8 = new JLabel("Semana:");
        labelSemana8.setBounds(25, 265, 100, 25);
        this.getContentPane().add(labelSemana8);
        panelDiaSemana.add(labelSemana8);
        labelSemana8.setVisible(true);
        
        textSem8 = new JTextField("");
        textSem8.setBounds(85, 265, 30, 25);
        this.getContentPane().add(textSem8);
        panelDiaSemana.add(textSem8);
        textSem8.setBackground(Color.LIGHT_GRAY);
        textSem8.setVisible(true);
        
        textDia8 = new JTextField("");
        textDia8.setBounds(150, 265, 100, 25);
        this.getContentPane().add(textDia8);
        panelDiaSemana.add(textDia8);
        textDia8.setVisible(true);
        
        textSemana8 = new JTextField("");
        textSemana8.setBounds(275, 265, 100, 25);
        this.getContentPane().add(textSemana8);
        panelDiaSemana.add(textSemana8);
        textSemana8.setVisible(true);
        
        labelKg8 = new JLabel("Kg.");
        labelKg8.setBounds(376, 265, 50, 25);
        this.getContentPane().add(labelKg8);
        panelDiaSemana.add(labelKg8);
        labelKg8.setVisible(true);
        
        botonCrear = new JButton("Crear");
        botonCrear.setBounds(10, 420, 90, 30);
        this.getContentPane().add(botonCrear);
        botonCrear.setVisible(true);
        botonCrear.addActionListener(this);
        
        botonGuardar = new JButton("Guardar");
        botonGuardar.setBounds(115, 420, 90, 30);
        this.getContentPane().add(botonGuardar);
        botonGuardar.setVisible(true);
        botonGuardar.addActionListener(this);
        
        botonModificar = new JButton("Modificar");
        botonModificar.setBounds(220, 420, 90, 30);
        this.getContentPane().add(botonModificar);
        botonModificar.setVisible(true);
        botonModificar.addActionListener(this);
        
        botonConsultar = new JButton("Consultar");
        botonConsultar.setBounds(325, 420, 90, 30);
        this.getContentPane().add(botonConsultar);
        botonConsultar.setVisible(true);
        botonConsultar.addActionListener(this);
        
        botonEliminar = new JButton("Eliminar");
        botonEliminar.setBounds(430, 420, 90, 30);
        this.getContentPane().add(botonEliminar);
        botonEliminar.setVisible(true);
        botonEliminar.addActionListener(this);
        
        botonSalir = new JButton("Salir");
        botonSalir.setBounds(535, 420, 90, 30);
        this.getContentPane().add(botonSalir);
        botonSalir.setVisible(true);
        botonSalir.addActionListener(this);
    	
		repaint();
    		
    }
    
     public void actionPerformed(ActionEvent event) {
    
     }
    	
    
    
    
}