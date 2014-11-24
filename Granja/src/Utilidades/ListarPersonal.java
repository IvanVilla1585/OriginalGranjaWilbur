package Utilidades;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import nodos.NodoPersonal;

public class ListarPersonal extends JFrame {
	
	JTable tablaPersonal=null;//tabla
    JScrollPane scroll;
    DefaultTableModel modeloPersonal;
	
	public ListarPersonal(NodoPersonal auxi){
		
		super ("Base de Datos Personal");
		setSize(1300, 325);
        setVisible(true);
        setResizable(false);
        setLocation(10,150);  
        String nomColumnas[] = new String[22];
        String datosPersonal[] = new String[22];
        modeloPersonal = new DefaultTableModel();
  		tablaPersonal = new JTable(modeloPersonal);//se añade el modelo a la tabla
        scroll = new JScrollPane(tablaPersonal);//se añade la tabla al scroll (contenedor)
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.reshape(50, 50, 1100, 170);//dimensiones
        getContentPane().add(scroll);
        nomColumnas[0]="Tipo Documento";
  		nomColumnas[1]="Numero Documento";
  		nomColumnas[2]="Nombre ";
  		nomColumnas[3]="Fecha Nacimiento";
  		nomColumnas[4]="Departamento";
  		nomColumnas[5]="Municipio";
  		nomColumnas[6]="Tipo Sangre"; 
  		nomColumnas[7]="Rh";
  		nomColumnas[8]="Estado";
  		nomColumnas[9]="Ruta Imagen"; 
  		nomColumnas[10]="Direccion";
  		nomColumnas[11]="Telefono";
  		nomColumnas[12]="Correo";
  		nomColumnas[13]="Telefono Movil";
  		nomColumnas[14]="Profesión"; 
  		nomColumnas[15]="Fecha Obtención Titulo"; 
  		nomColumnas[16]="Otros Estudios";
  		nomColumnas[17]="Obtenido";	
  		nomColumnas[18]="Fecha Finalización";
  		nomColumnas[19]="Cargo";
  		nomColumnas[20]="Fecha Contratación"; 
  		nomColumnas[21]="Tipo Contrato";
  		
  		for (int j = 0; j < 21; j++) //añaden columnas
        {
            modeloPersonal.addColumn(nomColumnas[j]);
        }
        
        try{ 
        
	        while (auxi !=null){
        	
	        	datosPersonal[0]=auxi.getPersonal().getTipoDoc();
	        	datosPersonal[1]=auxi.getPersonal().getNumeroDocumento();
	        	datosPersonal[2]=auxi.getPersonal().getNombre();
	        	datosPersonal[3]=auxi.getPersonal().getFechaNacimiento().toString();
	        	datosPersonal[4]=auxi.getPersonal().getDepartamento();
	        	datosPersonal[5]=auxi.getPersonal().getMunicipio();
	        	datosPersonal[6]=auxi.getPersonal().getTipoSangre();
	        	datosPersonal[7]=auxi.getPersonal().getRh();
	        	datosPersonal[8]=auxi.getPersonal().getEstado();
	        	datosPersonal[9]=auxi.getPersonal().getRutaImagen().toString();
	        	datosPersonal[10]=auxi.getPersonal().getDireccion();
	        	datosPersonal[11]=auxi.getPersonal().getTelefono();
	        	datosPersonal[12]=auxi.getPersonal().getCorreo();
	        	datosPersonal[13]=auxi.getPersonal().getTelMovil();
	        	datosPersonal[14]=auxi.getPersonal().getProfesion();
	        	datosPersonal[15]=auxi.getPersonal().getFechaTitulo().toString();
	        	datosPersonal[16]=auxi.getPersonal().getOtrosEstu();
	        	datosPersonal[17]=auxi.getPersonal().getObtenido();
	        	datosPersonal[18]=auxi.getPersonal().getFechaFin().toString();
	        	datosPersonal[19]=auxi.getPersonal().getCargo();
	        	datosPersonal[20]=auxi.getPersonal().getFechaContra().toString();
	        	datosPersonal[21]=auxi.getPersonal().getTipoContra();
        	
				modeloPersonal.addRow(datosPersonal);
				
				auxi=auxi.getLiga();
        	}
		}catch(Exception ex){
			System.out.print(ex);
		}
		
		this.repaint();
	}	
}
