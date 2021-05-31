package unida8.colecciones;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
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

		// Test3
		Map<String, String> map = new HashMap<String, String>();
		map.put("Juan", "Antonio");
		map.put("Fran", "Fran");
		map.put("Luna", "Luna");
		System.out.println(valoresUnicos(map));

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

	private static boolean valoresUnicos(Map<String, String> mapa) {
		/*
		 * Método llamado valoresUnicos que acepte un mapa de cadenas a cadenas y
		 * retorne false si dos o más claves se asocian a un mismo valor o true en caso
		 * contrario.
		 */
		Set<String> set = new HashSet<String>();
		for (String s : mapa.values()) {
			if (!set.add(s)) {
				return false;
			}
		}
		return true;
		// return mapa.values().stream().distinct().count() == mapa.values().size();
	}

}
