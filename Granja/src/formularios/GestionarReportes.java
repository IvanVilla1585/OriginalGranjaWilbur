import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;


public class GestionarReportes extends JFrame implements ActionListener{
	
	JPanel panelReportes;
	JCheckBox checkAnimales, checkPartos, checkPeso, checkMortalidad, checkJaula, checkAlimentos, checkMedicamentos, checkPersonas, checkSeleccionar;
	JButton botonConsultar, botonImprimir, botonSalir;
	TitledBorder rotulo1;
	

    public GestionarReportes() {
    	
    	super("Gestionar Reportes ");
        getContentPane().setLayout(null);
        setSize(655, 285);
        setResizable(true);
        setLocation(350, 100);
        setVisible(true);
        
        JPanel panelReportes = new JPanel();

        rotulo1 = BorderFactory.createTitledBorder("Reporte de");
        panelReportes.setBorder(rotulo1);
        panelReportes.setLayout(null);
        panelReportes.setBounds(10, 25, 620, 170);
        panelReportes.setVisible(true);
        panelReportes.setBackground(Color.lightGray);
        this.getContentPane().add(panelReportes);
        
        checkAnimales=new JCheckBox("Animales");
        checkAnimales.setBounds(25,25,100,25);
        this.getContentPane().add(checkAnimales);
        panelReportes.add(checkAnimales);
        checkAnimales.setVisible(true);
        
        checkPartos=new JCheckBox("Partos");
        checkPartos.setBounds(240,25,100,25);
        this.getContentPane().add(checkPartos);
        panelReportes.add(checkPartos);
        checkPartos.setVisible(true);
        
        checkPeso=new JCheckBox("Peso");
        checkPeso.setBounds(465,25,100,25);
        this.getContentPane().add(checkPeso);
        panelReportes.add(checkPeso);
        checkPeso.setVisible(true);
        
        checkMortalidad=new JCheckBox("Mortalidad");
        checkMortalidad.setBounds(25,75,180,25);
        this.getContentPane().add(checkMortalidad);
        panelReportes.add(checkMortalidad);
        checkMortalidad.setVisible(true);
        
        checkPersonas=new JCheckBox("Personas o Usuarios");
        checkPersonas.setBounds(240,75,150,25);
        this.getContentPane().add(checkPersonas);
        panelReportes.add(checkPersonas);
        checkPersonas.setVisible(true);
        
        checkJaula=new JCheckBox("Jaulas");
        checkJaula.setBounds(465,75,100,25);
        this.getContentPane().add(checkJaula);
        panelReportes.add(checkJaula);
        checkJaula.setVisible(true);
        
        checkAlimentos=new JCheckBox("Existencia de Alimentos");
        checkAlimentos.setBounds(25,125,180,25);
        this.getContentPane().add(checkAlimentos);
        panelReportes.add(checkAlimentos);
        checkAlimentos.setVisible(true);
        
        checkMedicamentos=new JCheckBox("Existencia de Medicamentos");
        checkMedicamentos.setBounds(240,125,190,25);
        this.getContentPane().add(checkMedicamentos);
        panelReportes.add(checkMedicamentos);
        checkMedicamentos.setVisible(true);
        
        checkSeleccionar=new JCheckBox("Seleccionas Todos");
        checkSeleccionar.setBounds(465,125,135,25);
        this.getContentPane().add(checkSeleccionar);
        panelReportes.add(checkSeleccionar);
        checkSeleccionar.setVisible(true);
        
        botonConsultar = new JButton("Consultar");
        botonConsultar.setBounds(100, 210, 90, 30);
        this.getContentPane().add(botonConsultar);
        botonConsultar.setVisible(true);
        botonConsultar.addActionListener(this);
        
        botonImprimir = new JButton("Imprimir");
        botonImprimir.setBounds(280, 210, 90, 30);
        this.getContentPane().add(botonImprimir);
        botonImprimir.setVisible(true);
        botonImprimir.addActionListener(this);
        
        botonSalir = new JButton("Salir");
        botonSalir.setBounds(450, 210, 90, 30);
        this.getContentPane().add(botonSalir);
        botonSalir.setVisible(true);
        botonSalir.addActionListener(this);
    	
    	repaint();
    		
    }
    
     public void actionPerformed(ActionEvent event) {
    
     }	
    
    
    
}