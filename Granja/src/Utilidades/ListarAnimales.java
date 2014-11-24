package Utilidades;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import nodos.NodoAnimal;

public class ListarAnimales extends JFrame {
	
	JTable tablaAnimal=null;//tabla
    JScrollPane scroll;
    DefaultTableModel modeloAnimal;
	
	public ListarAnimales(NodoAnimal auxi){
		
		super ("Base de Datos Animales");
		setSize(1300, 325);
        setVisible(true);
        setResizable(false);
        setLocation(10,150);  
        String nomColumnas[] = new String[18];
        String datosAnimal[] = new String[18];
        modeloAnimal = new DefaultTableModel();
  		tablaAnimal = new JTable(modeloAnimal);//se añade el modelo a la tabla
        scroll = new JScrollPane(tablaAnimal);//se añade la tabla al scroll (contenedor)
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.reshape(50, 50, 1100, 170);//dimensiones
        getContentPane().add(scroll);
        nomColumnas[0]="Codigo";
  		nomColumnas[1]="Raza";
  		nomColumnas[2]="Sexo";
  		nomColumnas[3]="Estado";
  		nomColumnas[4]="Fecha Nacimiento";
  		nomColumnas[5]="Edad en Semanas";
  		nomColumnas[6]="Procedencia"; 
  		nomColumnas[7]="Peso al Nacer";
  		nomColumnas[8]="Peso al Destete";
  		nomColumnas[9]="Fecha Destete"; 
  		nomColumnas[10]="Fecha_Alimento";
  		nomColumnas[11]="Codigo Parto";
  		nomColumnas[12]="Fecha Parto";
  		nomColumnas[13]="Codigo Madre";
  		nomColumnas[14]="Edad en Semanas"; 
  		nomColumnas[15]="Raza Madre"; 
  		nomColumnas[16]="Raza Padre";
  		nomColumnas[17]="Tipo Porcino";
  		
  		for (int j = 0; j < 17; j++) //añaden columnas
        {
            modeloAnimal.addColumn(nomColumnas[j]);
        }
        
        try{ 
        
	        while (auxi !=null){
        	
	        	datosAnimal[0]=auxi.getAnimal().getCodAnimal();
	        	datosAnimal[1]=auxi.getAnimal().getRaza();
	        	datosAnimal[2]=auxi.getAnimal().getSexo();
	        	datosAnimal[3]=auxi.getAnimal().getEstado();
	        	datosAnimal[4]=auxi.getAnimal().getFechaNaci().toString();
	        	datosAnimal[5]=auxi.getAnimal().getEdadSem();
	        	datosAnimal[6]=auxi.getAnimal().getProcedencia();
	        	datosAnimal[7]=auxi.getAnimal().getPesoNacer();
	        	datosAnimal[8]=auxi.getAnimal().getPesoDestete();
	        	datosAnimal[9]=auxi.getAnimal().getFechaDestete().toString();
	        	datosAnimal[10]=auxi.getAnimal().getFechaConsuAli().toString();
	        	datosAnimal[11]=auxi.getAnimal().getCodParto();
	        	datosAnimal[12]=auxi.getAnimal().getFechaParto().toString();
	        	datosAnimal[13]=auxi.getAnimal().getCodMadre();
	        	datosAnimal[14]=auxi.getAnimal().getEdadMadre();
	        	datosAnimal[15]=auxi.getAnimal().getRazaMadre();
	        	datosAnimal[16]=auxi.getAnimal().getRazaPadre();
	        	datosAnimal[17]=auxi.getAnimal().getTipoAnimal(); 
        	
				modeloAnimal.addRow(datosAnimal);
				
				auxi=auxi.getLiga();
        	}
		}catch(Exception ex){
			System.out.print(ex);
		}
		
		this.repaint();
	}
}
