package agenda;

import java.util.ArrayList;
import java.util.Scanner;

public class EntradaSalida {
	
	static Scanner sc = new Scanner(System.in); 

	public static int pedirOpcion() {
		// TODO Auto-generated method stub
		
		System.out.println("Elije una opcion");
		System.out.println("1-Insertar contacto");
		System.out.println("2-Listar contactos");
		System.out.println("3-Buscar contacto");
		System.out.println("4-Salir");
		
		int n = sc.nextInt();
		sc.nextLine();
		
		return n;
	}

	public static Contacto pedirContacto() {
		// TODO Auto-generated method stub
		System.out.println("Introduce nombre:");
		
		String nombre= sc.nextLine();
		
		System.out.println("Introduce el telefono:");
		String telefono = sc.nextLine();
		
		Contacto c = new Contacto(nombre, telefono);
		
		return c;
	}

	public static void mostrarContactos(ArrayList<Contacto> lista) {
		// TODO Auto-generated method stub
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i).toString());
			
		}
		
	}

	public static String pedirContactoNombre() {
		// TODO Auto-generated method stub
		
		System.out.println("Introduce el nombre");
		String nombre = sc.nextLine();
		return nombre;
	}

	public static void mostrarContactos(Contacto c_buscado) {
		// TODO Auto-generated method stub
		
		if (c_buscado!=null)
        {
        System.out.println("ENCONTRADO: \n"+c_buscado.toString());
        }
        else
        {
            System.out.println("No existe ese contacto");
        }
        
		
	}


}
