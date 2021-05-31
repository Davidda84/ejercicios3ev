package unida8.colecciones;


import java.util.HashSet;
import java.util.Set;

public class Colecciones {

	public static void main(String[] args) {
		
		//Test1
		Set<String> set = new HashSet<String>();
		set.add("uno");
		set.add("otro");
		set.add("el");
		set.add("dos");
		set.add("un");
		eliminarLasDeLongitudPar(set);

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

}
