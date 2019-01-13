package agenda;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccesoDatos {

	private static String separador = ";";
	private static String ruta = "C:\\Contacto\\agenda.csv";
	
	public static void crearFichero(Contacto c) {
		// TODO Auto-generated method stub
		
		String texto = c.getNombre() + separador + c.getTelefono();
		try {
			FileWriter fw = new FileWriter(ruta, true);
			
			fw.write(texto);
			fw.write("\n");  //nueva linea
			fw.close();
			
			
		} catch (IOException ex) {
            Logger.getLogger(AccesoDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
		
		
		
	}

	public static ArrayList<Contacto> obtenerContacto() {
		// TODO Auto-generated method stub
		 ArrayList<Contacto> lista_contactos=new ArrayList<>();
		
		try {
			 FileReader fr=new FileReader(ruta);
			 BufferedReader br=new BufferedReader(fr);
			 String linea=br.readLine();
			
			while(linea!=null)
			{
				String[] campos=linea.split(separador);
				Contacto c=new Contacto(campos[0], campos[1]);
				lista_contactos.add(c);
				linea=br.readLine();
			}
		} catch (FileNotFoundException ex) {
            Logger.getLogger(AccesoDatos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AccesoDatos.class.getName()).log(Level.SEVERE, null, ex);
		}
		 return lista_contactos;
	}

	public static Contacto buscarContacto(String contacto) {
		// TODO Auto-generated method stub
		
		FileReader fr=null;
        Contacto c=null;
        
		try {
			 fr=new FileReader(ruta);
			 BufferedReader br=new BufferedReader(fr);
			 String linea=br.readLine();
			 boolean encontrado=false;
			 
			 while (linea!=null && encontrado==false)
	            {
				 if (linea.contains(contacto)) {
					 encontrado=true;
					 String[] campos=linea.split(separador);
	                 c=new Contacto(campos[0],campos[1]);
					
				}
				 linea=br.readLine();
	            }
			 
			
			
		} catch (FileNotFoundException ex) {
            Logger.getLogger(AccesoDatos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AccesoDatos.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(AccesoDatos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return c;
	}

}
