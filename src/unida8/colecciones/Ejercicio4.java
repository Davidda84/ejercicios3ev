package unida8.colecciones;

import java.util.Scanner;

public class Ejercicio4 {
	static Palabras p = new Palabras();
	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		while (programa(teclado.nextLine())) {
			System.out.println(p.getMapa());
		}

		System.out.println("Fin del programa");
		System.out.println(p.getMapa());
		
	}
	
	public static boolean programa (String s) {
		Scanner cmd = new Scanner (s);
		switch (cmd.next("añadir:|lista|borrar|borrar:|fin")) {
			case "añadir:":
				String palabras = cmd.nextLine().trim();
				System.out.println(palabras);
				p.addPalabras(palabras);
				break;
			
			case "lista":
				int n = cmd.nextInt();
				System.out.println(p.getMapa().get(n));
				break;
			case "borrar":
				p.removeAll();
				break;
			case "borrar:":
				String palabrasReplace = cmd.nextLine().trim();
				clear(palabrasReplace);
				break;
			case "fin":
				cmd.close();
				return false;
		}
		cmd.close();
		return true;
	}

	private static void clear(String s) {
		p.removeAll();
		p.addPalabras(s);
		
	}
}
