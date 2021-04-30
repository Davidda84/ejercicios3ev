package unida8.colecciones;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ejercicio7 {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		int n = teclado.nextInt();
		int m = teclado.nextInt();
		teclado.nextLine();

		Queue<Integer> cola1 = new LinkedList<Integer>();
		Queue<Integer> cola2 = new LinkedList<Integer>();
		Queue<Integer> cola3 = new LinkedList<Integer>();

		for (int i = 0; i < n; i++) {
			cola1.offer(teclado.nextInt());
		}

		for (int i = 0; i < m; i++) {
			cola2.offer(teclado.nextInt());
		}

		for (Integer c1 : cola1) {
			if (cola2.contains(c1)) {
				cola3.offer(c1);
			}
		}

		System.out.println(cola3.toString().replace("[", "").replace("]", "").replace(",", ""));

		teclado.close();
	}
}
