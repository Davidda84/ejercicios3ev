package unida8.colecciones;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Ejercicio3 {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		Set<String> repiten = new TreeSet<String>();
		Set<String> noRepiten = new TreeSet<String>();
		String frase = teclado.nextLine();
		String[] palabras = frase.split(" ");
		
		for(String s : palabras) {
			if(!noRepiten.add(s)) {
				repiten.add(s);
			}
		}
		noRepiten.removeAll(repiten);
		teclado.close();
		System.out.println("Frase - > " + frase);
		System.out.println("Palabras no Repetidas - > " + noRepiten);
		System.out.println("Palabras Repetidas - > " + repiten);
	}

}
