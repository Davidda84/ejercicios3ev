package unida8.colecciones;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Iterator;

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

		// Test4
		List<String> lista = new ArrayList<String>();
		lista.add("uno");
		lista.add("dos");
		lista.add("tres");
		lista.add("cuatro");

		System.out.println(algunaSeRepiteAlMenos3Veces(lista));

		// Test5
		Deque<Integer> pil = new LinkedList<Integer>();
		pil.push(89);
		pil.push(-55);
		pil.push(-19);
		pil.push(29);
		pil.push(37);
		pil.push(-5);
		pil.push(23);

		System.out.println(negativosAbajoPositivosArriba(pil));

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

	private static boolean algunaSeRepiteAlMenos3Veces(List<String> cadena) {
		/*
		 * Método llamado algunaSeRepiteAlMenos3Veces que acepte una lista de cadenas
		 * como parámetro y retornoe verdadero si alguna cadena se repite al menos 3
		 * veces en la lista o falso en caso contrario. Resolver el problema utilizando
		 * un mapa como almacenamiento auxiliar.
		 */
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String s : cadena) {
			if (map.containsKey(s)) {
				if (map.get(s) == 2) {
					return true;
				} else {
					map.put(s, map.get(s) + 1);
				}
			} else {
				map.put(s, 1);
			}
		}
		return false;
	}

	private static Deque<Integer> negativosAbajoPositivosArriba(Deque<Integer> pila) {
		/*
		 * Método llamado negativosAbajoPositivosArriba que acepte una pila de números
		 * enteros como parámetro y la reorganice para que se queden debajo los
		 * negativos y encima los positivos. Usa una cola como estructura de datos
		 * auxiliar para realizar el proceso.
		 */
		Queue<Integer> cola = new LinkedList<Integer>();
		Iterator<Integer> i = pila.iterator();
		while (i.hasNext()) {
			int num = i.next();
			if (num >= 0) {
				cola.offer(num);
				i.remove();
			}
		}
		while (!cola.isEmpty()) {
			pila.push(cola.poll());
		}
		return pila;

	}

}
