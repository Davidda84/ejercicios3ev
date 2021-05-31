package unida8.colecciones;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Palabras {
	private Map<Integer, Set<String>> mapa = new TreeMap<Integer, Set<String>>();

	public Palabras() {
		this.mapa = new TreeMap<Integer, Set<String>>();
	}

	public Palabras(String cadena) {
		this();
		this.addPalabras(cadena);
		
	}

	public Map<Integer, Set<String>> getMapa() {
		return Collections.unmodifiableMap(mapa);
	}

	public void addPalabra(String s) {
		Set<String> palabras = mapa.get(s.length());
		if(palabras==null) {
			palabras = new TreeSet<String>();
		}
		palabras.add(s);
		this.mapa.put(s.length(), palabras);
	}

	public void addPalabras(String cadena) {
		for (String s : cadena.split("\\P{L}+")) {
			this.addPalabra(s);
		}
	}
	
	public void removeAll() {
		mapa.clear();
	}

	public boolean comprobar(String s) {
		return (this.mapa.get(s.length()).contains(s));
	}

}
