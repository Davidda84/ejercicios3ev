package unida8.ficheros;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ejercicio8 {
	
	static Scanner teclado = new Scanner (System.in);

	public static void main(String[] args) {
		try (PrintWriter writer = new PrintWriter(new FileWriter("archivos\\torneo.txt"))){
			String linea;
			while(!(linea = teclado.nextLine()).equalsIgnoreCase("torneo")) {
				writer.println(linea);
			}
			writer.println("torneo");
			while(!(linea = teclado.next("fuego|agua|electricidad|hielo|acero|psíquico|piedra|fin")).equalsIgnoreCase("fin")) {
				writer.println(linea);
			}
			writer.print("fin");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
