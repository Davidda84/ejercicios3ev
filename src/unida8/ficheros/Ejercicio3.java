package unida8.ficheros;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio3 {
	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		
		String ruta;
		FileReader texto = null;
		BufferedReader archivo = null;
		int caracteres = 0;
		int palabras = 0;
		int lineas = 0;
		String linea;

		if (args.length > 0) {
			ruta = args[0];
		} else {
			ruta = teclado.nextLine();
		}
		
		try{
			texto = new FileReader (ruta);
			archivo = new BufferedReader(texto);
			while((linea=archivo.readLine()) != null) {
				lineas++;
				caracteres += linea.length();
				for(String l : linea.split(" ")) {
					palabras++;
				}
			}
			
			System.out.println("caracteres: " + caracteres + ", palabras: " + palabras + " y lineas: " + lineas);
			
		}
		catch(IOException e) {
			System.out.println("Ha saltado una excepción " + e);
		}
		finally {
			try {
				archivo.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
