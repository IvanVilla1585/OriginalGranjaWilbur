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

public class MenuAdministrador extends JFrame implements ActionListener {
	
	JPanel panelPersonal, panelAnimales, panelReportes, panelBackup, panelMaestros, panelJaula, panelAliJaula, panelAlmacen, panelPublicidad, panelAyuda;
	JButton botonPersonal, botonPerfil, botonContraseña, botonAnimal, botonHojaVida, botonReportes, botonBackup, botonDepar, botonMuni, botonRazas;
	JButton botonJaulas, botonPermisos, botonVacunas, botonetapas, botonagentes, botonAnimalJaula, botonAlimentoJaula, botonAlimentos, botonMedicamentos;
	JButton botonCatalogo, botonPagina, botonAcercade, botonManual, botonSalir;
	JLabel labelTitulo, labelTitulo1, labelTitulo3, labelNomUsuario, labelFondo;
    TitledBorder rotulo1, rotulo2, rotulo3, rotulo4, rotulo5, rotulo6, rotulo7, rotulo8, rotulo9, rotulo10;
	ImageIcon iconFondo;
	
    public MenuAdministrador() {
    	
    	super("Menú Principal Administrador  ");
        getContentPane().setLayout(null);
        setSize(805, 640);
        setResizable(true);
        setLocation(275, 50);
        getContentPane().setBackground(Color.white);
        setVisible(true);
        
       // ((JPanel)getContentPane()).setOpaque(false);
        iconFondo = new ImageIcon("Imagenes//CERDO1.jpg");
        labelFondo = new JLabel(iconFondo);
        labelFondo.setBounds(490, 500, 180, 115);
        getContentPane().add(labelFondo);
        setVisible(true);
        
        labelTitulo = new JLabel(" Sistematización Granjas Porcicolas - ");
        labelTitulo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
        labelTitulo.setBounds(10, 10, 400, 40);
        this.getContentPane().add(labelTitulo);
        labelTitulo.setVisible(true);
        setResizable(false);
        
        labelNomUsuario = new JLabel("Usuario: Administrador");
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
        panelPersonal.setBounds(10, 90, 380, 100);
        panelPersonal.setVisible(true);
        panelPersonal.setBackground(Color.lightGray);
        this.getContentPane().add(panelPersonal);
        
        botonPersonal = new JButton("Registro de Personal");
        botonPersonal.setBounds(5, 25, 180, 30);
        this.getContentPane().add(botonPersonal);
        panelPersonal.add(botonPersonal);
        botonPersonal.setVisible(true);
        botonPersonal.addActionListener(this);
        
        botonContraseña = new JButton("Modificar Contraseña");
        botonContraseña.setBounds(195, 25, 180, 30);
        this.getContentPane().add(botonContraseña);
        panelPersonal.add(botonContraseña);
        botonContraseña.setVisible(true);
        botonContraseña.addActionListener(this);
        
        botonPerfil = new JButton("Asignar Perfil");
        botonPerfil.setBounds(5, 55, 180, 30);
        this.getContentPane().add(botonPerfil);
        panelPersonal.add(botonPerfil);
        botonPerfil.setVisible(true);
        botonPerfil.addActionListener(this);
        
        JPanel panelJaula = new JPanel();

        rotulo6 = BorderFactory.createTitledBorder("Gestionar Jaulas");
        panelJaula.setBorder(rotulo6);
        panelJaula.setLayout(null);
        panelJaula.setBounds(410, 90, 380, 100);
        panelJaula.setVisible(true);
        panelJaula.setBackground(Color.lightGray);
        this.getContentPane().add(panelJaula);
        
        botonAnimalJaula = new JButton("Asignar Animal a Jaula");
        botonAnimalJaula.setBounds(5, 25, 180, 30);
        this.getContentPane().add(botonAnimalJaula);
        panelJaula.add(botonAnimalJaula);
        botonAnimalJaula.setVisible(true);
        botonAnimalJaula.addActionListener(this);
        
        JPanel panelAnimales = new JPanel();

        rotulo2 = BorderFactory.createTitledBorder("Gestionar Animales");
        panelAnimales.setBorder(rotulo2);
        panelAnimales.setLayout(null);
        panelAnimales.setBounds(10, 200, 380, 70);
        panelAnimales.setVisible(true);
        panelAnimales.setBackground(Color.lightGray);
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

        rotulo7 = BorderFactory.createTitledBorder("Gestionar Alimentos por Jaula");
        panelAliJaula.setBorder(rotulo7);
        panelAliJaula.setLayout(null);
        panelAliJaula.setBounds(410, 200, 380, 70);
        panelAliJaula.setVisible(true);
        panelAliJaula.setBackground(Color.lightGray);
        this.getContentPane().add(panelAliJaula);
        
        botonAlimentoJaula = new JButton("Alimento por Jaula");
        botonAlimentoJaula.setBounds(5, 25, 180, 30);
        this.getContentPane().add(botonAlimentoJaula);
        panelAliJaula.add(botonAlimentoJaula);
        botonAlimentoJaula.setVisible(true);
        botonAlimentoJaula.addActionListener(this);
        
        JPanel panelReportes = new JPanel();

        rotulo3 = BorderFactory.createTitledBorder("Gestionar Reportes");
        panelReportes.setBorder(rotulo3);
        panelReportes.setLayout(null);
        panelReportes.setBounds(10, 280, 380, 70);
        panelReportes.setVisible(true);
        panelReportes.setBackground(Color.lightGray);
        this.getContentPane().add(panelReportes);
        
        botonReportes = new JButton("Reportes");
        botonReportes.setBounds(5, 25, 180, 30);
        this.getContentPane().add(botonReportes);
        panelReportes.add(botonReportes);
        botonReportes.setVisible(true);
        botonReportes.addActionListener(this);
        
        JPanel panelAlmacen = new JPanel();

        rotulo8 = BorderFactory.createTitledBorder("Gestionar Almacen");
        panelAlmacen.setBorder(rotulo8);
        panelAlmacen.setLayout(null);
        panelAlmacen.setBounds(410, 280, 380, 70);
        panelAlmacen.setVisible(true);
        panelAlmacen.setBackground(Color.lightGray);
        this.getContentPane().add(panelAlmacen);
        
        botonAlimentos = new JButton("Alimentos");
        botonAlimentos.setBounds(5, 25, 180, 30);
        this.getContentPane().add(botonAlimentos);
        panelAlmacen.add(botonAlimentos);
        botonAlimentos.setVisible(true);
        botonAlimentos.addActionListener(this);
        
        botonMedicamentos = new JButton("Medicamentos");
        botonMedicamentos.setBounds(195, 25, 180, 30);
        this.getContentPane().add(botonMedicamentos);
        panelAlmacen.add(botonMedicamentos);
        botonMedicamentos.setVisible(true);
        botonMedicamentos.addActionListener(this);
        
        JPanel panelBackup = new JPanel();

        rotulo4 = BorderFactory.createTitledBorder("Gestionar Buckups");
        panelBackup.setBorder(rotulo4);
        panelBackup.setLayout(null);
        panelBackup.setBounds(10, 360, 380, 70);
        panelBackup.setVisible(true);
        panelBackup.setBackground(Color.lightGray);
        this.getContentPane().add(panelBackup);
        
        botonBackup = new JButton("Copia de Seguridad");
        botonBackup.setBounds(5, 25, 180, 30);
        this.getContentPane().add(botonBackup);
        panelBackup.add(botonBackup);
        botonBackup.setVisible(true);
        botonBackup.addActionListener(this);
        
        JPanel panelPublicidad = new JPanel();

        rotulo9 = BorderFactory.createTitledBorder("Gestionar Publicidad");
        panelPublicidad.setBorder(rotulo8);
        panelPublicidad.setLayout(null);
        panelPublicidad.setBounds(410, 360, 380, 70);
        panelPublicidad.setVisible(true);
        panelPublicidad.setBackground(Color.lightGray);
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
        
        JPanel panelMaestros = new JPanel();

        rotulo5 = BorderFactory.createTitledBorder("Gestionar Maestros");
        panelMaestros.setBorder(rotulo5);
        panelMaestros.setLayout(null);
        panelMaestros.setBounds(10, 440, 380, 160);
        panelMaestros.setVisible(true);
        panelMaestros.setBackground(Color.lightGray);
        this.getContentPane().add(panelMaestros);
        
        botonDepar = new JButton("Departamentos");
        botonDepar.setBounds(5, 25, 180, 30);
        this.getContentPane().add(botonDepar);
        panelMaestros.add(botonDepar);
        botonDepar.setVisible(true);
        botonDepar.addActionListener(this);
        
        botonRazas = new JButton("Razas");
        botonRazas.setBounds(195, 25, 180, 30);
        this.getContentPane().add(botonRazas);
        panelMaestros.add(botonRazas);
        botonRazas.setVisible(true);
        botonRazas.addActionListener(this);
        
        botonMuni = new JButton("Municipios");
        botonMuni.setBounds(5, 55, 180, 30);
        this.getContentPane().add(botonMuni);
        panelMaestros.add(botonMuni);
        botonMuni.setVisible(true);
        botonMuni.addActionListener(this);
        
        botonPermisos = new JButton("Permisos");
        botonPermisos.setBounds(195, 55, 180, 30);
        this.getContentPane().add(botonPermisos);
        panelMaestros.add(botonPermisos);
        botonPermisos.setVisible(true);
        botonPermisos.addActionListener(this);
        
        botonJaulas = new JButton("Jaulas");
        botonJaulas.setBounds(5, 85, 180, 30);
        this.getContentPane().add(botonJaulas);
        panelMaestros.add(botonJaulas);
        botonJaulas.setVisible(true);
        botonJaulas.addActionListener(this);
        
        botonetapas = new JButton("Etapas de Desarrollo");
        botonetapas.setBounds(195, 85, 180, 30);
        this.getContentPane().add(botonetapas);
        panelMaestros.add(botonetapas);
        botonetapas.setVisible(true);
        botonetapas.addActionListener(this);
        
        botonVacunas = new JButton("Vacunas");
        botonVacunas.setBounds(5, 115, 180, 30);
        this.getContentPane().add(botonVacunas);
        panelMaestros.add(botonVacunas);
        botonVacunas.setVisible(true);
        botonVacunas.addActionListener(this);
        
        botonagentes = new JButton("Agentes Infecciosos");
        botonagentes.setBounds(195, 115, 180, 30);
        this.getContentPane().add(botonagentes);
        panelMaestros.add(botonagentes);
        botonagentes.setVisible(true);
        botonagentes.addActionListener(this);
        
        JPanel panelAyuda = new JPanel();

        rotulo10 = BorderFactory.createTitledBorder("Ayudas");
        panelAyuda.setBorder(rotulo10);
        panelAyuda.setLayout(null);
        panelAyuda.setBounds(410, 440, 380, 70);
        panelAyuda.setVisible(true);
        panelAyuda.setBackground(Color.lightGray);
        this.getContentPane().add(panelAyuda);
        
        botonAcercade = new JButton("Acerca de");
        botonAcercade.setBounds(5, 25, 180, 30);
        this.getContentPane().add(botonAcercade);
        panelAyuda.add(botonAcercade);
        botonAcercade.setVisible(true);
        botonAcercade.addActionListener(this);
        
        botonManual = new JButton("Manual de Usuario");
        botonManual.setBounds(195, 25, 180, 30);
        this.getContentPane().add(botonManual);
        panelAyuda.add(botonManual);
        botonManual.setVisible(true);
        botonManual.addActionListener(this);
        
        botonSalir = new JButton("Salir");
        botonSalir.setBounds(690, 570, 100, 30);
        this.getContentPane().add(botonSalir);
        botonSalir.setVisible(true);
        botonSalir.addActionListener(this);
        
        
        
    
    	repaint();
    
    }
    
    public void actionPerformed(ActionEvent event) {
   			
  	}
    
}