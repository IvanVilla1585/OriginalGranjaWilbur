import javax.swing.*;
import java.io.*;
import java.util.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.JLabel;
import javax.swing.JButton;

public class ivan extends JFrame implements ActionListener {


    JLabel labTitulo,labEstudio;
    JTextField TDocEstMod;
    JComboBox ComboEstudio;
    JButton BotonVerificar;
    	
    	  public ivan () {
    	  	
    	  	
        super("registro ivan ");
        getContentPane().setLayout(null);
        setSize(600, 400);
        setResizable(true);
        setLocation(400, 100);
        setVisible(true);

        labTitulo = new JLabel(" ivan  ");
        labTitulo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
        labTitulo.setBounds(80, 15, 600, 40);
        this.getContentPane().add(labTitulo);
        labTitulo.setVisible(true);
        setResizable(false);
        Font labTitulo = new Font("Logo", Font.PLAIN, 18);
        getContentPane().setBackground(Color.WHITE);
        ((JPanel) getContentPane()).setOpaque(false);
        ImageIcon img = new ImageIcon("fondoinfmatri.jpg");
        JLabel fondo = new JLabel(img);
        fondo.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        getLayeredPane().add(fondo, JLayeredPane.FRAME_CONTENT_LAYER);
        
        
        
        labEstudio = new JLabel("Estudia:");
        labEstudio.setBounds(50, 50, 50, 25);
        this.getContentPane().add(labEstudio);
        labEstudio.setVisible(true);

        ComboEstudio = new JComboBox();
        ComboEstudio.addItem("");
        ComboEstudio.setBounds(128,58, 200, 25);
        ComboEstudio.addItem("Ing_Civil");
        ComboEstudio.addItem("ing_Sistemas");
        ComboEstudio.addItem("Ing_Mecanica");
        ComboEstudio.addItem("ing_Ambiental");
        ComboEstudio.addItem("ing_Agropecuaria");
        ComboEstudio.addItem("Otras");
        this.getContentPane().add(ComboEstudio);
        ComboEstudio.setVisible(true);

     
        BotonVerificar = new JButton("Generar", new ImageIcon("maestos.jpg"));
        // BotonVerificar.setBackground(Color.white);
        BotonVerificar.setBounds(170, 110, 130, 80);
        this.getContentPane().add(BotonVerificar);
        BotonVerificar.setVisible(true);
        BotonVerificar.addActionListener(this);
    	  	
    	  	repaint();
    	  	
    	 
    	  	   }
    	  	   
    	  	   
    	  	    public void actionPerformed(ActionEvent event) {
    	  	    	
    	  	    	}
    	  	   
    	  	   
    	  	  
    	  	   
    	  	      }