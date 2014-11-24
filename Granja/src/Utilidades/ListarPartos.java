package Utilidades;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import nodos.NodoPartos;

public class ListarPartos extends JFrame {
	
	JTable tablaPartos=null;//tabla
    JScrollPane scroll;
    DefaultTableModel modeloPartos;
	
	public ListarPartos(NodoPartos auxi){
		
		super ("Base de Datos Partos");
		setSize(1300, 325);
        setVisible(true);
        setResizable(false);
        setLocation(10,150);  
        String Identificadores[] = new String[9];
        String datosAnimal[] = new String[9];
        modeloPartos = new DefaultTableModel();
  		tablaPartos = new JTable(modeloPartos);//se añade el modelo a la tabla
        scroll = new JScrollPane(tablaPartos);//se añade la tabla al scroll (contenedor)
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.reshape(50, 50, 1100, 170);//dimensiones
        getContentPane().add(scroll);
        int i = 0;
        Identificadores[0] = "Codigo del Parto";
        Identificadores[1] = "Fecha Parto";
        Identificadores[2] = "Codigo de la Madre";
        Identificadores[3] = "Raza de la Madre";
        Identificadores[4] = "Raza del Padre";
        Identificadores[5] = "Edad de la Madre";
        Identificadores[6] = "Lechones Vivos";
        Identificadores[7] = "Lechones Muertos";
        Identificadores[8] = "Total Camada";
        
        for (int j = 0; j <8; j++) //añaden columnas
        {
            modeloPartos.addColumn(Identificadores[j]);
        }
        
        try{ 
        
	        while (auxi != null) {
	
	            datosAnimal[0] = auxi.getParto().getCodParto();
	        	datosAnimal[1] = auxi.getParto().getFechaPart().toString();
	            datosAnimal[2] = auxi.getParto().getCodMadre();
	            datosAnimal[3] = auxi.getParto().getRaza();
	            datosAnimal[4] = auxi.getParto().getRazaPadre();
	            datosAnimal[5] = auxi.getParto().getEdad();
	            datosAnimal[6] = auxi.getParto().getNumVivos();
	            datosAnimal[7] = auxi.getParto().getNumMuertos();
	            datosAnimal[8] = auxi.getParto().getTotalCamada();
	
	            modeloPartos.addRow(datosAnimal);//se añade el registro al modelo
	            
	            auxi = auxi.getLiga();
	
	        }
	    }catch(Exception ex){
			System.out.print(ex);
		}
		
		this.repaint();
}
}
