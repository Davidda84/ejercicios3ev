package unida8.colecciones;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
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
			case "guardar":
				guardar(arrayEntrada[1]);
				break;
			case "cargar":
				cargar(arrayEntrada[1]);
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
	
	private static void guardar(String string) {
		File archivo = new File (string);
		if(!archivo.exists()) {
			try(PrintWriter writer = new PrintWriter(new FileWriter(archivo))){
				for(Entry<String,Set<Integer>> e : agenda.entrySet()) {
					writer.println(e.getKey() + " - " +e.getValue().toString().replace("[", "").replace("]", ""));
				}
				System.out.println("Archivo agenda creado");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else {
			String linea;
			Map<String,String> agendaExistente = new TreeMap<String,String>();
			try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
				while((linea = reader.readLine())!=null) {
					String[] contacto = linea.split(" - ");
					agendaExistente.put(contacto[0], contacto[1]);
				}
				Set<String> agendaKeys = agenda.keySet();
				for(String s: agendaKeys) {
					if(!agendaExistente.containsKey(s)) {
						agendaExistente.put(s, agenda.get(s).toString().replace("[", "").replace("]", ""));
					}
					else {
						if(!agendaExistente.get(s).equalsIgnoreCase(agenda.get(s).toString().replace("[", "").replace("]", ""))) {
							agendaExistente.put(s, agenda.get(s).toString().replace("[", "").replace("]", ""));
						}
					}
				}
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try(PrintWriter writer = new PrintWriter(new FileWriter(archivo))){
				for(Entry<String,String> e : agendaExistente.entrySet()) {
					writer.println(e.getKey() + " - " +e.getValue());
				}
				System.out.println("Archivo agenda modificado");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void cargar(String string) {
		File archivo = new File (string);
		String linea;
		Map<String,String> agendaExistente = new TreeMap<String,String>();
		try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
			while((linea = reader.readLine())!=null) {
				String[] contacto = linea.split(" - ");
				agendaExistente.put(contacto[0], contacto[1]);
			}
			Set<String> agendaKeys = agenda.keySet();
			for(String s: agendaKeys) {
				if(!agendaExistente.containsKey(s)) {
					agendaExistente.put(s, agenda.get(s).toString().replace("[", "").replace("]", ""));
				}
				else {
					if(!agendaExistente.get(s).equalsIgnoreCase(agenda.get(s).toString().replace("[", "").replace("]", ""))) {
						System.out.println("El telefono de " + s + " es diferente al existente en la agenda, ¿Desea modificarlo? S/N");
						String respuesta = teclado.nextLine();
						if(respuesta.equalsIgnoreCase("S")) {
							guardar(string);
						}
						else {
							System.out.println("No se ha modificado la agenda");
						}
					}
				}
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
