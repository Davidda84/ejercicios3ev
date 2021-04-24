package unida8.colecciones;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Ejercicio6 {
	static Scanner teclado = new Scanner(System.in);
	static Map<String,Set<Integer>> agenda = new TreeMap<String,Set<Integer>>();

	public static void main(String[] args) {		
		while(ejecutar());
		System.out.println("Fin del programa");
	}

	private static boolean ejecutar() {
		System.out.print("> ");
		String entrada = teclado.nextLine();
		String[] arrayEntrada = null;
		String opcion;
		if(entrada.contains(":")) {
			arrayEntrada = entrada.split(":");
			opcion = arrayEntrada[0];
		}
		else {
			opcion = entrada;
		}
		
		switch(opcion) {
			default:
				agenda(arrayEntrada);
				break;
			case "buscar":
				buscar(arrayEntrada[1]);
				break;
			case "eliminar":
				agenda.remove(arrayEntrada[1]);
				System.out.println("El contacto ha sido eliminado de la agenda");
				break;
			case "contactos":
				System.out.println(agenda.toString().replace("{","").replace("}","").replace("[","").replace("]",""));
				break;
			case "salir":
				return false;
		}
		return true;
	}

	private static void buscar(String string) {
		if(agenda.get(string) != null) {
			Set<Integer> telefonos = agenda.get(string);
			if(telefonos.size() > 1){
				System.out.print("Teléfonos: ");
			}
			else {
				System.out.print("Teléfono: ");
			}
			System.out.println(telefonos.toString().replace("[", "").replace("]", ""));
		}
		else{
			System.out.println("El contacto no existe");
		}
	}

	private static void agenda(String[] arrayEntrada) {
		String nombre = arrayEntrada[0];
		int telefono = Integer.parseInt(arrayEntrada[1]);
		Set<Integer> telefonos = new LinkedHashSet<Integer>();
		if(agenda.get(nombre) != null) {
			telefonos = agenda.get(nombre);
			telefonos.add(telefono);
		}
		else {
			telefonos.add(telefono);
			agenda.put(nombre, telefonos);
		}
		System.out.println("El contacto ha sido añadido a la agenda");
	}

}
