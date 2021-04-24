package unida8.colecciones;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Ejercicio5 {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		int N = teclado.nextInt();
		int K = teclado.nextInt();
		int X = teclado.nextInt();
		
		Queue<Integer> cola = new LinkedList<Integer>();
		
		for(int i = 0; i < N; i++) {
			cola.offer(Integer.parseInt(teclado.next()));
		}
		
		for(int i = 0; i < K; i++) {
			cola.poll();
		}

		if(cola.contains(X) && !cola.isEmpty()) {
			System.out.println("true");
		}
		else if(!cola.contains(X) && !cola.isEmpty()){
			Scanner valores = new Scanner(cola.toString().replace("[", "").replace(",", "").replace("]", ""));
			Queue<Integer> orden = new PriorityQueue<Integer>();
			for(int i = 0; i < (N-K); i++) {
				int valor = Integer.parseInt(valores.next());
				orden.offer(valor);
			}
			System.out.println(orden.peek());
		}
		else {
			System.out.println(0);
		}
		
		teclado.close();

	}

}
