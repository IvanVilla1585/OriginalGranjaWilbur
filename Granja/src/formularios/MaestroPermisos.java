import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.TitledBorder;


public class MaestroPermisos extends JFrame implements ActionListener{
	
	JLabel labelCodPerfil, labelPerfil, labelAnimal, labelPersonal, labelJaula, labelAlmacen, labelAliJaulas, labelReportes, labelSeguridad;
	JLabel labelPublicidad, labelAyudas, labelMaestros;
	JTextField textCodPerfil, textPerfil;
	JButton botonCrear, botonGuardar, botonModificar, botonConsultar, botonEliminar, botonSalir;
	JPanel panelLectura, panelLecturaEscri;
	JCheckBox checkAnimales, checkJaula, checkReportes, checkSeguridad, checkPublicidad, checkAliJaulas, checkAlmacen, checkPersonal;
	JCheckBox checkAyudas, checkMaestros;
	JCheckBox checkAnimales1, checkJaula1, checkReportes1, checkSeguridad1, checkPublicidad1, checkAliJaulas1, checkAlmacen1, checkPersonal1;
	JCheckBox checkAyudas1, checkMaestros1;
	TitledBorder rotulo1, rotulo2;

    public MaestroPermisos() {
    	
    	super("Maestro Permisos ");
        getContentPane().setLayout(null);
        setSize(643, 490);
        setResizable(false);
        setLocation(350, 100);
        setVisible(true);
        
        labelCodPerfil = new JLabel("Código Perfil:");
        labelCodPerfil.setBounds(30, 25, 150, 25);
        this.getContentPane().add(labelCodPerfil);
        labelCodPerfil.setVisible(true);
        
        textCodPerfil = new JTextField("");
        textCodPerfil.setBounds(111, 25, 100, 25);
        this.getContentPane().add(textCodPerfil);
        textCodPerfil.setVisible(true);
        
        labelPerfil = new JLabel("Perfil: ");
        labelPerfil.setBounds(315, 25, 180, 25);
        this.getContentPane().add(labelPerfil);
        labelPerfil.setVisible(true);
        
        textPerfil = new JTextField("");
        textPerfil.setBounds(355, 25, 250, 25);
        this.getContentPane().add(textPerfil);
        textPerfil.setVisible(true);
        
        labelAnimal = new JLabel("Modulo Gestionar Animal");
        labelAnimal.setBounds(70, 105, 150, 25);
        this.getContentPane().add(labelAnimal);
        labelAnimal.setVisible(true);
        
        labelPersonal = new JLabel("Modulo Gestionar Personal");
        labelPersonal.setBounds(70, 135, 200, 25);
        this.getContentPane().add(labelPersonal);
        labelPersonal.setVisible(true);
        
        labelJaula = new JLabel("Modulo Gestionar Jaula");
        labelJaula.setBounds(70, 165, 150, 25);
        this.getContentPane().add(labelJaula);
        labelJaula.setVisible(true);
        
        labelAliJaulas = new JLabel("Modulo Gestionar Alimento por Jaula");
        labelAliJaulas.setBounds(70, 195, 230, 25);
        this.getContentPane().add(labelAliJaulas);
        labelAliJaulas.setVisible(true);
        
        labelAlmacen = new JLabel("Modulo Gestionar Almacén");
        labelAlmacen.setBounds(70, 225, 200, 25);
        this.getContentPane().add(labelAlmacen);
        labelAlmacen.setVisible(true);
        
        labelReportes = new JLabel("Modulo Gestionar Reportes");
        labelReportes.setBounds(70, 255, 200, 25);
        this.getContentPane().add(labelReportes);
        labelReportes.setVisible(true);
        
        labelSeguridad = new JLabel("Modulo Gestionar Backup");
        labelSeguridad.setBounds(70, 285, 200, 25);
        this.getContentPane().add(labelSeguridad);
        labelSeguridad.setVisible(true);
        
        labelPublicidad = new JLabel("Modulo Gestionar Publicidad");
        labelPublicidad.setBounds(70, 315, 200, 25);
        this.getContentPane().add(labelPublicidad);
        labelPublicidad.setVisible(true);
        
        labelMaestros = new JLabel("Modulo Gestionar Maestros");
        labelMaestros.setBounds(70, 345, 200, 25);
        this.getContentPane().add(labelMaestros);
        labelMaestros.setVisible(true);
        
        labelAyudas = new JLabel("Modulo Ayudas");
        labelAyudas.setBounds(70, 375, 200, 25);
        this.getContentPane().add(labelAyudas);
        labelAyudas.setVisible(true);
        
        JPanel panelLectura = new JPanel();

        rotulo1 = BorderFactory.createTitledBorder("Solo Lectura");
        panelLectura.setBorder(rotulo1);
        panelLectura.setLayout(null);
        panelLectura.setBounds(318, 75, 100, 330);
        panelLectura.setVisible(true);
        panelLectura.setBackground(Color.lightGray);
        this.getContentPane().add(panelLectura);
        
        checkAnimales=new JCheckBox("");
        checkAnimales.setBounds(40,30,22,20);
        this.getContentPane().add(checkAnimales);
        panelLectura.add(checkAnimales);
        checkAnimales.setVisible(true);
        
        checkPersonal=new JCheckBox("");
        checkPersonal.setBounds(40,59,22,20);
        this.getContentPane().add(checkPersonal);
        panelLectura.add(checkPersonal);
        checkPersonal.setVisible(true);
        
        checkJaula=new JCheckBox("");
        checkJaula.setBounds(40,88,22,20);
        this.getContentPane().add(checkJaula);
        panelLectura.add(checkJaula);
        checkJaula.setVisible(true);
        
        checkAliJaulas=new JCheckBox("");
        checkAliJaulas.setBounds(40,119,22,20);
        this.getContentPane().add(checkAliJaulas);
        panelLectura.add(checkAliJaulas);
        checkAliJaulas.setVisible(true);
        
        checkAlmacen=new JCheckBox("");
        checkAlmacen.setBounds(40,149,22,20);
        this.getContentPane().add(checkAlmacen);
        panelLectura.add(checkAlmacen);
        checkAlmacen.setVisible(true);
        
        checkReportes=new JCheckBox("");
        checkReportes.setBounds(40,180,22,20);
        this.getContentPane().add(checkReportes);
        panelLectura.add(checkReportes);
        checkReportes.setVisible(true);
        
        checkSeguridad=new JCheckBox("");
        checkSeguridad.setBounds(40,210,22,20);
        this.getContentPane().add(checkSeguridad);
        panelLectura.add(checkSeguridad);
        checkSeguridad.setVisible(true);
        
        checkPublicidad=new JCheckBox("");
        checkPublicidad.setBounds(40,240,22,20);
        this.getContentPane().add(checkPublicidad);
        panelLectura.add(checkPublicidad);
        checkPublicidad.setVisible(true);
        
        checkMaestros=new JCheckBox("");
        checkMaestros.setBounds(40,270,22,20);
        this.getContentPane().add(checkMaestros);
        panelLectura.add(checkMaestros);
        checkMaestros.setVisible(true);
        
        checkAyudas=new JCheckBox("");
        checkAyudas.setBounds(40,299,22,20);
        this.getContentPane().add(checkAyudas);
        panelLectura.add(checkAyudas);
        checkAyudas.setVisible(true);
        
        JPanel panelLecturaEscri = new JPanel();

        rotulo2 = BorderFactory.createTitledBorder("Lectura Y Escritura");
        panelLecturaEscri.setBorder(rotulo2);
        panelLecturaEscri.setLayout(null);
        panelLecturaEscri.setBounds(433, 75, 125, 330);
        panelLecturaEscri.setVisible(true);
        panelLecturaEscri.setBackground(Color.lightGray);
        this.getContentPane().add(panelLecturaEscri);
        
        checkAnimales1=new JCheckBox("");
        checkAnimales1.setBounds(50,30,22,20);
        this.getContentPane().add(checkAnimales1);
        panelLecturaEscri.add(checkAnimales1);
        checkAnimales1.setVisible(true);
        
        checkPersonal1=new JCheckBox("");
        checkPersonal1.setBounds(50,59,22,20);
        this.getContentPane().add(checkPersonal1);
        panelLecturaEscri.add(checkPersonal1);
        checkPersonal1.setVisible(true);
        
        checkJaula1=new JCheckBox("");
        checkJaula1.setBounds(50,88,22,20);
        this.getContentPane().add(checkJaula1);
        panelLecturaEscri.add(checkJaula1);
        checkJaula1.setVisible(true);
        
        checkAliJaulas1=new JCheckBox("");
        checkAliJaulas1.setBounds(50,119,22,20);
        this.getContentPane().add(checkAliJaulas1);
        panelLecturaEscri.add(checkAliJaulas1);
        checkAliJaulas1.setVisible(true);
        
        checkAlmacen1=new JCheckBox("");
        checkAlmacen1.setBounds(50,149,22,20);
        this.getContentPane().add(checkAlmacen1);
        panelLecturaEscri.add(checkAlmacen1);
        checkAlmacen1.setVisible(true);
        
        checkReportes1=new JCheckBox("");
        checkReportes1.setBounds(50,180,22,20);
        this.getContentPane().add(checkReportes1);
        panelLecturaEscri.add(checkReportes1);
        checkReportes1.setVisible(true);
        
        checkSeguridad1=new JCheckBox("");
        checkSeguridad1.setBounds(50,210,22,20);
        this.getContentPane().add(checkSeguridad1);
        panelLecturaEscri.add(checkSeguridad1);
        checkSeguridad1.setVisible(true);
        
        checkPublicidad1=new JCheckBox("");
        checkPublicidad1.setBounds(50,240,22,20);
        this.getContentPane().add(checkPublicidad1);
        panelLecturaEscri.add(checkPublicidad1);
        checkPublicidad1.setVisible(true);
        
        checkMaestros1=new JCheckBox("");
        checkMaestros1.setBounds(50,270,22,20);
        this.getContentPane().add(checkMaestros1);
        panelLecturaEscri.add(checkMaestros1);
        checkMaestros1.setVisible(true);
        
        checkAyudas1=new JCheckBox("");
        checkAyudas1.setBounds(50,299,22,20);
        this.getContentPane().add(checkAyudas1);
        panelLecturaEscri.add(checkAyudas1);
        checkAyudas1.setVisible(true);
        
        
    	
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