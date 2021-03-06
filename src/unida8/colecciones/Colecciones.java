package unida8.colecciones;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

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

		// Test8
		Map<String, Integer> mapa1 = new LinkedHashMap<>();
		mapa1.put("Fernando", 53);
		mapa1.put("Manuela", 29);
		mapa1.put("Ana", 41);
		mapa1.put("Luis", 65);
		mapa1.put("Mario", 33);
		mapa1.put("Adri??n", 21);
		mapa1.put("Carmen", 39);
		mapa1.put("Elena", 19);
		Map<String, Integer> mapa2 = new LinkedHashMap<>();
		mapa2.put("Valentina", 37);
		mapa2.put("Ana", 41);
		mapa2.put("Mario", 33);
		mapa2.put("Benito", 67);
		mapa2.put("Carmen", 39);
		mapa2.put("Ram??n", 44);
		mapa2.put("Elena", 19);
		mapa2.put("Hugo", 32);

		System.out.println(interseccion(mapa1, mapa2));

		// Test9
		Map<String, Integer> mapa3 = new LinkedHashMap<>();
		mapa3.put("Juan", 33);
		mapa3.put("Hugo", 29);
		mapa3.put("Ana", 45);
		mapa3.put("Luis", 47);
		mapa3.put("Mario", 33);
		mapa3.put("Rosa", 29);
		mapa3.put("Carmen", 33);
		mapa3.put("Elena", 59);
		mapa3.put("Benito", 33);

		System.out.println(ValorMenosRepetido(mapa3));

		// Test10
		List<String> fruta = new ArrayList<String>();
		fruta.add("banana");
		fruta.add("pera");
		fruta.add("mel??n");
		fruta.add("sand??a");

		System.out.println(cuentaPares(fruta));

		// Test11
		List<Integer> listan1 = new LinkedList<>();
		List<Integer> listan2 = new LinkedList<>();
		listan1.add(2);
		listan1.add(3);
		listan1.add(6);
		listan1.add(4);
		listan1.add(6);
		listan1.add(10);
		listan2.add(2);
		listan2.add(3);
		listan2.add(6);
		listan2.add(4);
		listan2.add(6);
		listan2.add(10);
		listan2.add(2);
		System.out.println(contarComunes(listan1, listan2));
		
		//Test12
        Deque <Integer> numeros3 = new LinkedList<Integer>();
        numeros3.push(7);
        numeros3.push(6);
        numeros3.push(2);
        numeros3.push(9);
        numeros3.push(5);
        System.out.println(duplicar(numeros3));

	}

	private static void eliminarLasDeLongitudPar(Set<String> conjunto) {
		/*
		 * M??todo llamado eliminarLasDeLongitudPar que acepte un conjunto de cadenas y
		 * elimine del mismo todas aquellas cadenas de una longitud par. No se permite
		 * el uso de ninguna otra estructura de datos auxiliar.
		 */
		conjunto.removeIf(n -> (n.length() % 2 == 0));
		System.out.println(conjunto);
	}

	private static boolean contieneImpares(Set<Integer> conjunto) {
		/*
		 * M??todo llamado contieneImpares que acepte un conjunto de n??meros enteros y
		 * retorne true si contiene al menos un n??mero impar o false en caso contrario.
		 */
		/*
		 * for(int n: conjunto) { if(n%2 != 0) { return true; } } return false;
		 */
		return conjunto.stream().anyMatch(n -> (n % 2 != 0));
	}

	private static boolean valoresUnicos(Map<String, String> mapa) {
		/*
		 * M??todo llamado valoresUnicos que acepte un mapa de cadenas a cadenas y
		 * retorne false si dos o m??s claves se asocian a un mismo valor o true en caso
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
		 * M??todo llamado algunaSeRepiteAlMenos3Veces que acepte una lista de cadenas
		 * como par??metro y retornoe verdadero si alguna cadena se repite al menos 3
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
		 * M??todo llamado negativosAbajoPositivosArriba que acepte una pila de n??meros
		 * enteros como par??metro y la reorganice para que se queden debajo los
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
		 * M??todo llamado moda que acepte una lista de n??meros enteros como par??metro y
		 * retorne el n??mero que se repite con mayor frecuencia (la moda). Retornar 0 si
		 * la lista est?? vac??a.
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
		 * M??todo llamado eliminarSiMayoresEncima que acepte una pila de n??meros enteros
		 * como par??metro y elimine de ella los elementos que tienen por encima alguno
		 * cuyo valor sea mayor. Por ejemplo, suponiendo que una pila almacena los
		 * siguientes n??meros: Tope ??? [2, 7, 12, 5, 14, 9, 7, 10, 17, 17, 22, 6] Los
		 * n??meros 5, 9, 7, 10 y 6 deben eliminarse porque todos ellos tienen alg??n
		 * n??mero mayor por encima. S??lo se permite el uso de otras pilas o colas para
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

	public static Map<String, Integer> interseccion(Map<String, Integer> mapa1, Map<String, Integer> mapa2) {
		/*
		 * M??todo llamado interseccion que acepte dos mapas, ambos de String a Integer,
		 * y retorne un nuevo mapa que contenga la intersecci??n de los dos primeros. Por
		 * ejemplo, si recibe los mapas: {Fernando=53, Manuela=29, Ana=41, Luis=65,
		 * Mario=33, Adri??n=21, Carmen=39, Elena=19} {Valentina=37, Ana=41, Mario=33,
		 * Benito=67, Carmen=39, Ram??n=44, Elena=19, Hugo=32} retornar?? el mapa:
		 * {Ana=41, Mario=33, Carmen=39, Elena=19}
		 */
		Map<String, Integer> mapa = new LinkedHashMap<String, Integer>();

		for (Entry<String, Integer> n : mapa1.entrySet()) {
			if (mapa2.entrySet().contains(n)) {
				mapa.put(n.getKey(), n.getValue());
			}
		}
		return mapa;
	}

	public static int ValorMenosRepetido(Map<String, Integer> mapa) {
		/*
		 * M??todo llamado valorMenosRepetido que acepte un mapa cuyas claves de tipo
		 * String representan nombres de personas, y cuyos valores de tipo Integer
		 * representan sus edades. El m??todo retornar?? la edad que menos se repite
		 * dentro del mapa. En caso de empate, retornar?? el valor menor. Por ejemplo, si
		 * el mapa contiene: {Juan=33, Hugo=29, Ana=45, Luis=47, Mario=33, Rosa=29,
		 * Carmen=33, Elena=59, Benito=33} El m??todo retornar?? 45, que es el valor m??s
		 * peque??o de los dos que menos se repiten (45 y 59 se repiten una sola vez).
		 */
		Map<Integer, Integer> mapaAux = new TreeMap<Integer, Integer>();
		int min = 0;
		int minKey = 0;
		for (Entry<String, Integer> n : mapa.entrySet()) {
			if (mapaAux.get(n.getValue()) != null) {
				mapaAux.put(n.getValue(), mapaAux.get(n.getValue()) + 1);
			} else {
				mapaAux.put(n.getValue(), 1);
			}
		}

		for (Entry<Integer, Integer> n : mapaAux.entrySet()) {
			if (min == 0) {
				min = n.getValue();
				minKey = n.getKey();
			}
			if (n.getValue() < min) {
				min = n.getValue();
				minKey = n.getKey();
			}
		}
		return minKey;
	}

	public static Map<String, Integer> cuentaPares(List<String> lista) {
		/*
		 * M??todo llamado cuentaPares que acepte una lista de cadenas que representan
		 * palabras individuales y retorne una estructura de datos en la que se almacene
		 * el resultado de contar el n??mero de ocurrencias de cada secuencia de dos
		 * caracteres. Por ejemplo, dada la lista: [banana, pera, mel??n, o, sand??a] ??? La
		 * palabra banana contiene los pares ba, an, na, an, na. ??? La palabra pera
		 * contiene los pares pe, er, ra. ??? La palabra mel??n contiene los pares me, el,
		 * l??, ??n. ??? La palabra o no contiene secuencias de dos caracteres por ser de
		 * longitud uno. ??? La palabra sand??a contiene los pares sa, an, nd, d??, ??a. Por
		 * tanto, el par ba se repite una vez, el par an tres veces, el par na dos
		 * veces, etc
		 */

		Map<String, Integer> mapa = new HashMap<String, Integer>();
		for (String p : lista) {
			for (int i = 0; i < p.length() - 1; i++) {
				String par = String.valueOf(p.charAt(i)) + String.valueOf(p.charAt(i + 1));
				if (!mapa.containsKey(par)) {
					mapa.put(par, 1);
				} else {
					mapa.put(par, mapa.get(par) + 1);
				}
			}
		}
		return mapa;
	}

	public static int contarComunes(List<Integer> lista1, List<Integer> lista2) {
		/*
		 * M??todo llamado contarComunes que acepte dos listas como par??metros y retorne
		 * la cantidad de n??meros que tienen en com??n sin contar los repetidos.
		 */

		Set<Integer> norepetidos1 = new TreeSet<Integer>();
		Set<Integer> norepetidos2 = new TreeSet<Integer>();
		Set<Integer> repetidos = new TreeSet<Integer>();

		for (int i : lista1) {
			if (!norepetidos1.add(i)) {
				repetidos.add(i);
			}
		}

		norepetidos1.removeAll(repetidos);
		repetidos.clear();

		for (int i : lista2) {
			if (!norepetidos2.add(i)) {
				repetidos.add(i);
			}
		}

		norepetidos2.removeAll(repetidos);
		norepetidos1.retainAll(norepetidos2);

		return norepetidos1.size();
	}
	
	public static Deque<Integer> duplicar(Deque<Integer> numeros) {
		/*M??todo llamado duplicar que acepte una pila de n??meros enteros como par??metro y sustituya cada
		valor almacenado por el mismo duplicado, manteniendo el orden original.
		Por ejemplo, dada la pila:
		Tope ??? [5, 9, 2, 6, 7]
		Almacenar?? en ella los valores:
		Tope ??? [5, 5, 9, 9, 2, 2, 6, 6, 7, 7]*/
			
			Queue<Integer> pilaAux = new LinkedList<Integer>();
			while(!numeros.isEmpty()) {
				pilaAux.offer(numeros.peek());
				pilaAux.offer(numeros.pop());
			}
			
			return (Deque<Integer>) pilaAux;
			
		}

}
