package unida8.colecciones;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Ejercicio1 {
	/*Programa que lee de la entrada estándar una secuencia de nombres y los guarda en una colección de forma
	que ésta no contenga nombres repetidos. La primera línea de entrada contiene la cantidad de nombres. El
	resto de las líneas contienen los nombres a razón de uno por línea. El programa finalizará mostrando los
	nombres guardados en la colección en el mismo orden en que se insertaron.*/
	
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
