package unida8.ficheros;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

import unida8.colecciones.Palabras;

public class Ejercicio7 {

	static Palabras palabras = new Palabras();
	static TreeSet<String> coleccion = new TreeSet<String>();

	public static void main(String[] args) {

		try (BufferedReader reader = new BufferedReader(new FileReader("archivos\\Lemario ES UTF-8.txt"))) {
			String line;
			while ((line = reader.readLine()) != null) {
				palabras.addPalabras(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		try (BufferedReader reader1 = new BufferedReader(new FileReader("archivos\\El Quijote UTF-8.txt"))) {
			String line;
			while ((line = reader1.readLine()) != null) {
				for (String l : line.toLowerCase().split("\\P{L}+")) {
					if (l.length() > 0 && !palabras.comprobar(l)) {
						coleccion.add(l);
					}
				}
			}
			System.out.println(coleccion.size() + " palabras que no están en Lemario");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
