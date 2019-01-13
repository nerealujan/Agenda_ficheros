package agenda;

import java.util.ArrayList;

public class ClasePrincipal {
	
/* Crea una agenda con un menú:
1-Insertar contacto
2-Listar contactos
3-Buscar contacto
4-Salir.
Cada contacto tendrá las propiedades nombre y teléfono.
Para conseguir la persistencia, graba los datos como CSV*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int opcion = EntradaSalida.pedirOpcion();
		while(opcion != 4)
		{
			switch (opcion) {
			case 1: //Insertar
				Contacto c=EntradaSalida.pedirContacto();
				AccesoDatos.crearFichero(c);
				break;
			case 2:// Listar
				ArrayList<Contacto> lista= AccesoDatos.obtenerContacto();
				EntradaSalida.mostrarContactos(lista);
				break;
			case 3: //buscar
				String contacto = EntradaSalida.pedirContactoNombre();
				Contacto c_buscado = AccesoDatos.buscarContacto(contacto);
				EntradaSalida.mostrarContactos(c_buscado);
				break;
			}
			opcion = EntradaSalida.pedirOpcion();
		}

	}

}
