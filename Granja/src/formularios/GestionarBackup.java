import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;
//import javax.swing.JLabel;
//import javax.swing.JCheckBox;
//import javax.swing.JButton;
//import javax.swing.JPanel;
///import javax.swing.JFrame;
//import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;

public class GestionarBackup extends JFrame implements ActionListener{
	
	JPanel panelBackup, panelFecha;
	JCheckBox checkAnimales, checkAlmacen, checkReportes, checkAliJaula, checkJaula, checkPersonal, checkPublicidad, checkMaestros, checkGeneral;
	JButton botonConsultar, botonImprimir, botonSalir;
	JLabel labelDesde, labelHasta;
	JComboBox comboDesde, comboHasta;
	TitledBorder rotulo1, rotulo2;

    public GestionarBackup() {
    	
    	super("Gestionar Backup ");
        getContentPane().setLayout(null);
        setSize(655, 380);
        setResizable(true);
        setLocation(350, 100);
        setVisible(true);
        
        JPanel panelFecha = new JPanel();

        rotulo1 = BorderFactory.createTitledBorder("Ingrese la Fecha del Backup");
        panelFecha.setBorder(rotulo1);
        panelFecha.setLayout(null);
        panelFecha.setBounds(10, 25, 620, 70);
        panelFecha.setVisible(true);
        panelFecha.setBackground(Color.lightGray);
        this.getContentPane().add(panelFecha);
        
        labelDesde = new JLabel("Desde:");
        labelDesde.setBounds(50, 25, 150, 25);
        this.getContentPane().add(labelDesde);
        panelFecha.add(labelDesde);
        labelDesde.setVisible(true);
        
        comboDesde = new JComboBox();
        comboDesde.addItem("");
        comboDesde.setBounds(100,25, 150, 25);
        this.getContentPane().add(comboDesde);
        panelFecha.add(comboDesde);
        comboDesde.setVisible(true);
        
        labelHasta = new JLabel("Hasta: ");
        labelHasta.setBounds(375, 25, 180, 25);
        this.getContentPane().add(labelHasta);
        panelFecha.add(labelHasta);
        labelHasta.setVisible(true);
        
        comboHasta = new JComboBox();
        comboHasta.addItem("");
        comboHasta.setBounds(420,25, 150, 25);
        this.getContentPane().add(comboHasta);
        panelFecha.add(comboHasta);
        comboHasta.setVisible(true);
        
        JPanel panelBackup = new JPanel();

        rotulo2 = BorderFactory.createTitledBorder("Backup de");
        panelBackup.setBorder(rotulo2);
        panelBackup.setLayout(null);
        panelBackup.setBounds(10, 110, 620, 170);
        panelBackup.setVisible(true);
        panelBackup.setBackground(Color.lightGray);
        this.getContentPane().add(panelBackup);
        
        checkAnimales=new JCheckBox("Módulo Animales");
        checkAnimales.setBounds(25,25,130,25);
        this.getContentPane().add(checkAnimales);
        panelBackup.add(checkAnimales);
        checkAnimales.setVisible(true);
        
        checkAlmacen=new JCheckBox("Módulo Almacén ");
        checkAlmacen.setBounds(240,25,130,25);
        this.getContentPane().add(checkAlmacen);
        panelBackup.add(checkAlmacen);
        checkAlmacen.setVisible(true);
        
        checkReportes=new JCheckBox("Módulo Reportes");
        checkReportes.setBounds(465,25,130,25);
        this.getContentPane().add(checkReportes);
        panelBackup.add(checkReportes);
        checkReportes.setVisible(true);
        
        checkJaula=new JCheckBox("Módulo Jaula");
        checkJaula.setBounds(25,75,130,25);
        this.getContentPane().add(checkJaula);
        panelBackup.add(checkJaula);
        checkJaula.setVisible(true);
        
        checkAliJaula=new JCheckBox("Módulo Alimentos por Jaula");
        checkAliJaula.setBounds(240,75,190,25);
        this.getContentPane().add(checkAliJaula);
        panelBackup.add(checkAliJaula);
        checkAliJaula.setVisible(true);
        
        checkPersonal=new JCheckBox("Módulo Personal");
        checkPersonal.setBounds(465,75,130,25);
        this.getContentPane().add(checkPersonal);
        panelBackup.add(checkPersonal);
        checkPersonal.setVisible(true);
        
        checkPublicidad=new JCheckBox("Módulo Publicidad");
        checkPublicidad.setBounds(25,125,130,25);
        this.getContentPane().add(checkPublicidad);
        panelBackup.add(checkPublicidad);
        checkPublicidad.setVisible(true);
        
        checkMaestros=new JCheckBox("Módulo Maestros");
        checkMaestros.setBounds(240,125,130,25);
        this.getContentPane().add(checkMaestros);
        panelBackup.add(checkMaestros);
        checkMaestros.setVisible(true);
        
        checkGeneral=new JCheckBox("Generaral");
        checkGeneral.setBounds(465,125,130,25);
        this.getContentPane().add(checkGeneral);
        panelBackup.add(checkGeneral);
        checkGeneral.setVisible(true);
        
        botonConsultar = new JButton("Consultar");
        botonConsultar.setBounds(100, 300, 90, 30);
        this.getContentPane().add(botonConsultar);
        botonConsultar.setVisible(true);
        botonConsultar.addActionListener(this);
        
        botonImprimir = new JButton("Imprimir");
        botonImprimir.setBounds(280, 300, 90, 30);
        this.getContentPane().add(botonImprimir);
        botonImprimir.setVisible(true);
        botonImprimir.addActionListener(this);
        
        botonSalir = new JButton("Salir");
        botonSalir.setBounds(450, 300, 90, 30);
        this.getContentPane().add(botonSalir);
        botonSalir.setVisible(true);
        botonSalir.addActionListener(this);
    	
    	repaint();
    		
    }
    
     public void actionPerformed(ActionEvent event) {
    
     }	
    	
    
    
    
}