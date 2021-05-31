package unida8.colecciones;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

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

		// Test6
		List<Integer> listam = new ArrayList<Integer>();
		listam.add(1);
		listam.add(2);
		listam.add(1);
		listam.add(1);
		listam.add(5);
		listam.add(2);
		listam.add(6);
		listam.add(7);

		System.out.println(moda(listam));

		// Test7
		Deque<Integer> pilrep = new LinkedList<Integer>();

		pilrep.push(6);
		pilrep.push(22);
		pilrep.push(17);
		pilrep.push(17);
		pilrep.push(10);
		pilrep.push(7);
		pilrep.push(9);
		pilrep.push(14);
		pilrep.push(5);
		pilrep.push(12);
		pilrep.push(7);
		pilrep.push(2);

		System.out.println(pilrep);
		System.out.println(eliminarSiMayoresEncima(pilrep));

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

	private static int moda(List<Integer> numeros) {

		/*
		 * Método llamado moda que acepte una lista de números enteros como parámetro y
		 * retorne el número que se repite con mayor frecuencia (la moda). Retornar 0 si
		 * la lista está vacía.
		 */
		if (!numeros.isEmpty()) {
			Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
			for (int n : numeros) {
				if (map.containsKey(n)) {
					map.put(n, map.get(n) + 1);
				} else {
					map.put(n, 1);
				}
			}
			int max = 0;
			int key = 0;
			for (Entry<Integer, Integer> n : map.entrySet()) {
				if (n.getValue() > max) {
					max = n.getValue();
					key = n.getKey();
				}
			}
			return key;
		} else {
			return 0;
		}
	}

	public static Deque<Integer> eliminarSiMayoresEncima(Deque<Integer> pila) {
		/*
		 * Método llamado eliminarSiMayoresEncima que acepte una pila de números enteros
		 * como parámetro y elimine de ella los elementos que tienen por encima alguno
		 * cuyo valor sea mayor. Por ejemplo, suponiendo que una pila almacena los
		 * siguientes números: Tope → [2, 7, 12, 5, 14, 9, 7, 10, 17, 17, 22, 6] Los
		 * números 5, 9, 7, 10 y 6 deben eliminarse porque todos ellos tienen algún
		 * número mayor por encima. Sólo se permite el uso de otras pilas o colas para
		 * solucionar este problema.
		 */
		Deque<Integer> pilaaux = new ArrayDeque<Integer>();
		while (!pila.isEmpty()) {
			if (pilaaux.isEmpty()) {
				pilaaux.push(pila.pop());
			}
			int n = pila.pop();
			if (n >= pilaaux.peek()) {
				pilaaux.push(n);
			}
		}
		while (!pilaaux.isEmpty()) {
			pila.push(pilaaux.poll());
		}
		return pila;
	}

}
