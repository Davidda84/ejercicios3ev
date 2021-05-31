package unida8.ficheros;

import java.io.File;
import java.util.Scanner;

public class Ejercicio1 {

	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		File ruta;

		if (args.length > 0) {
			ruta = new File(args[0]);
		} else {
			ruta = new File(teclado.nextLine());
		}

		if (ruta.exists()) {
			System.out.println("Si exite el fichero o directorio referenciado.");
			if (ruta.isDirectory() || ruta.isFile()) {
				System.out.println("Si se trata de un fichero o de un directorio.");
				System.out.println(ruta.getName() + " " + (ruta.canExecute() ? "ejecutable" : "") + " "
						+ (ruta.canRead() ? "lectura" : "") + " " + (ruta.canWrite() ? "editable" : ""));
				if (ruta.isFile()) {
					System.out.println(ruta.getName() + " " + "tamaño de fichero: " + ruta.length() + " bytes");
				}
			}
		} else {
			System.out.println("No exite el fichero o directorio referenciado.");
		}
	}
}
