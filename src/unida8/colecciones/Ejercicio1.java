package unida8.colecciones;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Ejercicio1 {
	
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		Set<String> nombres = new LinkedHashSet<String>();
		int n = teclado.nextInt();
		
		for(int i=0;i<n;i++) {
			nombres.add(teclado.next());
		}
		teclado.close();
		nombres.forEach(nom-> System.out.println(nom));
	}
	
	
}
