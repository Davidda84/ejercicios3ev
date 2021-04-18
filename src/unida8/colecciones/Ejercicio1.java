package unida8.colecciones;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Ejercicio1 {
	/*Programa que lee de la entrada est�ndar una secuencia de nombres y los guarda en una colecci�n de forma
	que �sta no contenga nombres repetidos. La primera l�nea de entrada contiene la cantidad de nombres. El
	resto de las l�neas contienen los nombres a raz�n de uno por l�nea. El programa finalizar� mostrando los
	nombres guardados en la colecci�n en el mismo orden en que se insertaron.*/
	
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
