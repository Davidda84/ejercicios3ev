package unida8.colecciones;

import java.util.HashSet;
import java.util.Set;

public class Colecciones {

	public static void main(String[] args) {

		// Test1
		Set<String> set = new HashSet<String>();
		set.add("uno");
		set.add("otro");
		set.add("el");
		set.add("dos");
		set.add("un");
		eliminarLasDeLongitudPar(set);

		// Test2
		Set<Integer> seti = new HashSet<Integer>();
		seti.add(1);
		seti.add(2);
		seti.add(4);
		System.out.println(contieneImpares(seti));

	}

	private static void eliminarLasDeLongitudPar(Set<String> conjunto) {
		/*
		 * Método llamado eliminarLasDeLongitudPar que acepte un conjunto de cadenas y
		 * elimine del mismo todas aquellas cadenas de una longitud par. No se permite
		 * el uso de ninguna otra estructura de datos auxiliar.
		 */
		conjunto.removeIf(n -> (n.length() % 2 == 0));
		System.out.println(conjunto);
	}
	
	private static boolean contieneImpares(Set<Integer> conjunto) {
		/*
		 * Método llamado contieneImpares que acepte un conjunto de números enteros y
		 * retorne true si contiene al menos un número impar o false en caso contrario.
		 */
		/*
		 * for(int n: conjunto) { if(n%2 != 0) { return true; } } return false;
		 */
		return conjunto.stream().anyMatch(n -> (n % 2 != 0));
	}

}
