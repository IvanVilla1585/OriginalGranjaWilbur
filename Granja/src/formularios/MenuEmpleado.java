import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.border.TitledBorder;


public class MenuEmpleado extends JFrame implements ActionListener  {
	
	JPanel panelPersonal, panelAnimales, panelReportes, panelJaula, panelAliJaula, panelPublicidad, panelAyuda;
	JButton botonContraseña, botonAnimal, botonHojaVida, botonReportes;
	JButton botonAnimalJaula, botonAlimentoJaula;
	JButton botonCatalogo, botonPagina, botonManual, botonSalir;
	JLabel labelTitulo, labelTitulo1, labelTitulo3, labelNomUsuario, labelFondo;
	ImageIcon iconFondo;
    TitledBorder rotulo1, rotulo2, rotulo3, rotulo4, rotulo5, rotulo6, rotulo7;
    
    public MenuEmpleado() {
    	
    	super("Menú Principal Empleado  ");
        getContentPane().setLayout(null);
        setSize(805, 440);
        setResizable(true);
        setLocation(100, 10);
        
        ((JPanel)getContentPane()).setOpaque(false);
        iconFondo = new ImageIcon("Imagenes//CERDO1.jpg");
        labelFondo = new JLabel(iconFondo);
        labelFondo.setBounds(490, 0, 180, 115);
        getLayeredPane().add(labelFondo,JLayeredPane.FRAME_CONTENT_LAYER);
        setVisible(true);
        
        labelTitulo = new JLabel(" Sistematización Granjas Porcicolas - ");
        labelTitulo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
        labelTitulo.setBounds(10, 10, 400, 40);
        this.getContentPane().add(labelTitulo);
        labelTitulo.setVisible(true);
        setResizable(false);
        
        labelNomUsuario = new JLabel("Usuario: Empleado");
        labelNomUsuario.setBounds(650, 10, 200, 25);
        this.getContentPane().add(labelNomUsuario);
        labelNomUsuario.setVisible(true);
        
        labelTitulo1 = new JLabel("S.G.P.");
        labelTitulo1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
        labelTitulo1.setBounds(150, 35, 400, 40);
        this.getContentPane().add(labelTitulo1);
        labelTitulo1.setVisible(true);
        setResizable(false);
        
        JPanel panelPersonal = new JPanel();

        rotulo1 = BorderFactory.createTitledBorder("Gestionar Personal");
        panelPersonal.setBorder(rotulo1);
        panelPersonal.setLayout(null);
        panelPersonal.setBounds(10, 90, 380, 70);
        panelPersonal.setVisible(true);
        panelPersonal.setBackground(Color.lightGray);
        this.getContentPane().add(panelPersonal);
        
        botonContraseña = new JButton("Modificar Contraseña");
        botonContraseña.setBounds(5, 25, 180, 30);
        this.getContentPane().add(botonContraseña);
        panelPersonal.add(botonContraseña);
        botonContraseña.setVisible(true);
        botonContraseña.addActionListener(this);
        
        JPanel panelJaula = new JPanel();

        rotulo2 = BorderFactory.createTitledBorder("Gestionar Jaulas");
        panelJaula.setBorder(rotulo2);
        panelJaula.setLayout(null);
        panelJaula.setBounds(410, 90, 380, 70);
        panelJaula.setVisible(true);
        panelJaula.setBackground(Color.WHITE);
        this.getContentPane().add(panelJaula);
        
        botonAnimalJaula = new JButton("Asignar Animal a Jaula");
        botonAnimalJaula.setBounds(5, 25, 180, 30);
        this.getContentPane().add(botonAnimalJaula);
        panelJaula.add(botonAnimalJaula);
        botonAnimalJaula.setVisible(true);
        botonAnimalJaula.addActionListener(this);
        
        JPanel panelAnimales = new JPanel();

        rotulo3 = BorderFactory.createTitledBorder("Gestionar Animales");
        panelAnimales.setBorder(rotulo3);
        panelAnimales.setLayout(null);
        panelAnimales.setBounds(10, 170, 380, 70);
        panelAnimales.setVisible(true);
        panelAnimales.setBackground(Color.WHITE);
        this.getContentPane().add(panelAnimales);
        
        botonAnimal = new JButton("Datos del Animal");
        botonAnimal.setBounds(5, 25, 180, 30);
        this.getContentPane().add(botonAnimal);
        panelAnimales.add(botonAnimal);
        botonAnimal.setVisible(true);
        botonAnimal.addActionListener(this);
        
        botonHojaVida = new JButton("Trazabilidad del Animal");
        botonHojaVida.setBounds(195, 25, 180, 30);
        this.getContentPane().add(botonHojaVida);
        panelAnimales.add(botonHojaVida);
        botonHojaVida.setVisible(true);
        botonHojaVida.addActionListener(this);
        
        JPanel panelAliJaula = new JPanel();

        rotulo4 = BorderFactory.createTitledBorder("Gestionar Alimentos por Jaula");
        panelAliJaula.setBorder(rotulo4);
        panelAliJaula.setLayout(null);
        panelAliJaula.setBounds(410, 170, 380, 70);
        panelAliJaula.setVisible(true);
        panelAliJaula.setBackground(Color.WHITE);
        this.getContentPane().add(panelAliJaula);
        
        botonAlimentoJaula = new JButton("Alimento por Jaula");
        botonAlimentoJaula.setBounds(5, 25, 180, 30);
        this.getContentPane().add(botonAlimentoJaula);
        panelAliJaula.add(botonAlimentoJaula);
        botonAlimentoJaula.setVisible(true);
        botonAlimentoJaula.addActionListener(this);
        
        JPanel panelReportes = new JPanel();

        rotulo5 = BorderFactory.createTitledBorder("Gestionar Reportes");
        panelReportes.setBorder(rotulo5);
        panelReportes.setLayout(null);
        panelReportes.setBounds(10, 250, 380, 70);
        panelReportes.setVisible(true);
        panelReportes.setBackground(Color.WHITE);
        this.getContentPane().add(panelReportes);
        
        botonReportes = new JButton("Reportes");
        botonReportes.setBounds(5, 25, 180, 30);
        this.getContentPane().add(botonReportes);
        panelReportes.add(botonReportes);
        botonReportes.setVisible(true);
        botonReportes.addActionListener(this);
        
        JPanel panelPublicidad = new JPanel();

        rotulo6 = BorderFactory.createTitledBorder("Gestionar Publicidad");
        panelPublicidad.setBorder(rotulo6);
        panelPublicidad.setLayout(null);
        panelPublicidad.setBounds(410, 250, 380, 70);
        panelPublicidad.setVisible(true);
        panelPublicidad.setBackground(Color.WHITE);
        this.getContentPane().add(panelPublicidad);
        
        botonCatalogo = new JButton("Catalogo");
        botonCatalogo.setBounds(5, 25, 180, 30);
        this.getContentPane().add(botonCatalogo);
        panelPublicidad.add(botonCatalogo);
        botonCatalogo.setVisible(true);
        botonCatalogo.addActionListener(this);
        
        botonPagina = new JButton("Página Web");
        botonPagina.setBounds(195, 25, 180, 30);
        this.getContentPane().add(botonPagina);
        panelPublicidad.add(botonPagina);
        botonPagina.setVisible(true);
        botonPagina.addActionListener(this);
        
        JPanel panelAyuda = new JPanel();

        rotulo7 = BorderFactory.createTitledBorder("Ayudas");
        panelAyuda.setBorder(rotulo7);
        panelAyuda.setLayout(null);
        panelAyuda.setBounds(10, 330, 380, 70);
        panelAyuda.setVisible(true);
        panelAyuda.setBackground(Color.WHITE);
        this.getContentPane().add(panelAyuda);
        
        botonManual = new JButton("Manual de Usuario");
        botonManual.setBounds(5, 25, 180, 30);
        this.getContentPane().add(botonManual);
        panelAyuda.add(botonManual);
        botonManual.setVisible(true);
        botonManual.addActionListener(this);
        
        botonSalir = new JButton("Salir");
        botonSalir.setBounds(690, 372, 100, 30);
        this.getContentPane().add(botonSalir);
        botonSalir.setVisible(true);
        botonSalir.addActionListener(this);
        
        
        
    
    	repaint();
    
    }
    
    public void actionPerformed(ActionEvent event) {
   			
  	}
    	
    	    
}