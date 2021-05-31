package unida8.ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Ejercicio6 {
	static Charset codificacion;
	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println(
				"¿Qué archivo quiere leer?\n" + "1. El Quijote UTF-8.txt \n" + "2. El Quijote ISO-8859.txt \n");
		int opcion = teclado.nextInt();
		switch (opcion) {
		case 1:
			abrir("archivos\\El Quijote UTF-8.txt");
			break;
		case 2:
			abrir("archivos\\El Quijote ISO-8859.txt");
			break;
		default:
			System.out.println("Opción no valida");
			break;
		}

	}

	public static void abrir(String ruta) {
		File f = new File(ruta);
		codArchivo(f);
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f), codificacion))) {
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static void codArchivo(File f) {
		if (f.getName().contains("ISO")) {
			codificacion = StandardCharsets.ISO_8859_1;
		} else if (f.getName().contains("UTF")) {
			codificacion = StandardCharsets.UTF_8;
		}
	}

}
