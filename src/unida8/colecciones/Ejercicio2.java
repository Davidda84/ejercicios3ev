package unida8.colecciones;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Ejercicio2 {
	public static void main(String[] args) {
		
		Random ran = new Random();
		List<Integer> original = new ArrayList<Integer>();
		Set<Integer> sinrepetir = new LinkedHashSet<Integer>();
		Set<Integer> ordenados = new TreeSet<Integer>();
		for(int i=0;i<100;i++) {
			original.add(ran.nextInt(100)+1);
		}

		System.out.println("Lista Original");
		original.forEach(n->System.out.print(n+" "));
		original.forEach(n->sinrepetir.add(n));
		ordenados.addAll(original);
		System.out.println();
		System.out.println("Lista no repetidos");
		Iterator<Integer> i = sinrepetir.iterator();
		while(i.hasNext()) {
			System.out.print(i.next()+" ");
		}
		System.out.println();
		System.out.println("Lista ordenados");
		for(int o : ordenados) {
			System.out.print(o+" ");
		}
		
	}
}
