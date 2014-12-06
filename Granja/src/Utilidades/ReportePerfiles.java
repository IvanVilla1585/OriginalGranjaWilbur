package Utilidades;

import javax.swing.*;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.*;
import nodos.*;
import listas.*;

public class ReportePerfiles {
    
    int NumeroColumnas;
    public static NodoPerfil auxiliar = new NodoPerfil();
    
    Document documento; 
    
    public void crearInformeTabla(String tabla,String campo, ListaPerfil listaPerfil) 
    {
    	
        String nombreArchivo="Informe_Perfil.pdf";
        	Document documento = null;
        	documento = new Document();
        	auxiliar = listaPerfil.getCabeza();
        
       // Se crea el documento 
      try
      {      
	//  ResultSet rs=consultar( "select * from "+ tabla)  ;
	    int NumeroColumnas= numeroDeColumnas();
	    // Se crea el OutputStream para el fichero donde queremos dejar el pdf.
	    System.out.println(" archivo "+ nombreArchivo);
	    FileOutputStream ficheroPdf = new FileOutputStream( nombreArchivo  );
	    // Se asocia el documento al OutputStream y se indica que el espaciado entre
	    // lineas sera de 20. Esta llamada debe hacerse antes de abrir el documento
	    PdfWriter.getInstance(documento,ficheroPdf).setInitialLeading(20);
	    // Se abre el documento.
	    documento.open();
	    //INSETAR objetos al documento
	    documento.add( crearTitulo( "Tabla "+ tabla));// inserta el titulo
	    documento.add(new Paragraph(" "));//para dar un salto de linea
	//  documento.add(obtenerImagen("images.jpg"));// inserta una imagen que se llama images.jpg
	    documento.add( tablaTitulos());// inserta una tabla con las columnas del rs
	    documento.add( tablaDatos());// inserta una tabla con los registros del rs
	    //documento.add( sumaDatosCampo(tabla,campo));
	    documento.close();  
      }	
        catch( IOException r) // errores al copiar en el archivo
	    {
	         System.out.println("error CREAR EL ARCHIVO");
	    }
	        catch(DocumentException h1)
	    {
	         System.out.println("errorL AL ABRIR EL DOCUMENTO");
	    }
	        mostrarArchivo(nombreArchivo);	    
    }
    
      public int numeroDeColumnas()
	  {
	    int numeroColumnas=6;
	    return numeroColumnas; 	
	  }
  
	 public Paragraph crearTitulo(String titulo)
     {
        Paragraph parrafo2= new Paragraph(titulo, 
        FontFactory.getFont("arial", 18, Font.BOLD, BaseColor.BLACK));
                            // fuente, tamaÃ±o, estilo, color
        parrafo2.setAlignment(1);//el 1 es para centrar
        return parrafo2;
     } 
     	 
	  public PdfPTable tablaTitulos()
	  {
	          PdfPTable tabla=null;
	          int numeroColumnas;
	          String V[]= new String[6];
	          V[0] = "Número Documento";
              V[1] = "Código Perfil";
	          V[2] = "Perfil";
              V[3] = "Nombre Usuario"; 
              V[4] = "Correo Corporativo";
              V[5] = "Pregunta"; 
	           // ResultSetMetaData metaDatos = rs.getMetaData();
	            // Se obtiene el numero de columnas.
	          numeroColumnas = 6;//metaDatos.getColumnCount();       
	          tabla = new PdfPTable(numeroColumnas);
	           
	          PdfPCell celda=null;
	          for (int i = 0; i < numeroColumnas; i++)
	          {
	             String tituloColumna=V[i];
	             celda = new PdfPCell(new Paragraph(tituloColumna,  FontFactory.getFont("arial",12, Font.BOLD,   BaseColor.BLACK    )     ) );
	             celda.setBackgroundColor(BaseColor.WHITE);
	             celda.setHorizontalAlignment(Element.ALIGN_CENTER);
	             tabla.addCell(celda);
	          }    
	          return tabla;
	  }
	  
	  public PdfPTable tablaDatos()
	  {
	      
	          PdfPTable tabla=null;
	          int numeroColumnas;
	          
	          String NumDocu, CodiPerfil, Perfil, NomUsuario, Correo, Pregunta;
	          String V[] = new String[6];
	          
	          PdfPCell celda;
	            // Se obtiene el numero de columnas.
	            numeroColumnas = 6;   
	            tabla = new PdfPTable(numeroColumnas);//construye una tabla con el número de columnas requeridas
	            
	            while(auxiliar != null) // recorre cada registro del resultset
	            {
	            	NumDocu = auxiliar.getPerfil().getNumCedula();
	            	CodiPerfil = auxiliar.getPerfil().getCodPerfil();
	            	Perfil = auxiliar.getPerfil().getPerfil();
	            	NomUsuario = auxiliar.getPerfil().getUsuario();
                        Correo = auxiliar.getPerfil().getCorreoCorpora();
                        Pregunta = auxiliar.getPerfil().getPregunta();
	            	
	            	V[0] = NumDocu;
	            	V[1] = CodiPerfil;
	            	V[2] = Perfil;
	            	V[3] = NomUsuario;
                    V[4] = Correo;
                    V[5] = Pregunta;
	                for (int i = 0; i < numeroColumnas; i++)//lee cada campo del registro activo
	                {
	                       String fila = V[i];
	                        celda = new PdfPCell(new Paragraph(fila,  FontFactory.getFont("arial",12, Font.NORMAL,   BaseColor.BLACK    )     ) );
	                        celda.setBackgroundColor(BaseColor.WHITE);
	                        
	                        tabla.addCell(celda);
	                }
	                auxiliar = auxiliar.getLiga();
	            }
	            
	  			
	      return tabla; 
	  }
	  
	   public void mostrarArchivo(String nombreArchivo)
	    {
	          String comando[] = {"C:\\Program Files\\Adobe\\Reader 11.0\\Reader\\AcroRd32.exe", nombreArchivo };
	          
	            try
	            {
	                Runtime.getRuntime().exec(comando);
	             }
	            catch (Exception e) 
	            {
	            	JOptionPane.showMessageDialog(null,"EL ARCHIVO PDF FUE CREADO CORRECTAMENTE PERO NO SE PUEDE MOSTRAR \n CORRIJA LA RUTA DE LA APLICACION ACROR32.EXE");   
	                e.printStackTrace();
	            }       
	    }    
}

