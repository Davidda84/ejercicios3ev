package unida8.colecciones;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import unidad5.Mazo;
import unidad5.Naipe;

public class Ejercicio8 {
	static Scanner teclado = new Scanner(System.in);
	static Mazo mazoPartida = new Mazo();
	static Map<String, Mazo> jugadores = new LinkedHashMap<String, Mazo>();
	static Map<String, Integer> partida = new LinkedHashMap<String, Integer>();
	static int lineaEntrada = 0;

	public static void main(String[] args) {
		while (ejecutar())
			;
		Set<String> keys = jugadores.keySet();
		resultadoFinal(keys);

		System.out.println(partida.toString().replace("{", "").replace("}", "").replace(", ", "\n"));
		System.out.println("Fin del programa");

	}

	private static void resultadoFinal(Set<String> keys) {
		for (String key : keys) {
			int totalJugador = 0;
			Mazo mazoJugador = jugadores.get(key);
			Map<String, Naipe> mano = new LinkedHashMap<String, Naipe>();
			for (Naipe n : mazoJugador.getAll()) {
				String naipe = n.getValor() + n.getPalo();
				mano.put(naipe, n);
			}
			Set<String> naipeKeys = mano.keySet();
			for (String naipeKey : naipeKeys) {
				Naipe n = mano.get(naipeKey);
				if (n.getPalo().equalsIgnoreCase("tréboles")) {
					totalJugador += 1 * n.getValor();
				} else if (n.getPalo().equalsIgnoreCase("diamantes")) {
					totalJugador += 2 * n.getValor();
				} else if (n.getPalo().equalsIgnoreCase("corazones")) {
					totalJugador += 3 * n.getValor();
				} else if (n.getPalo().equalsIgnoreCase("picas")) {
					totalJugador += 4 * n.getValor();
				}
			}
			partida.put(key, totalJugador);
		}
	}

	private static boolean ejecutar() {
		lineaEntrada++;
		String entrada = teclado.nextLine();
		if (entrada.contains(":")) {
			jugada(entrada);
			return true;
		} else if (!entrada.equalsIgnoreCase("fin") && !entrada.contains(":")) {
			System.out.println("Entrada " + lineaEntrada + " incorrecta");
			return true;
		} else {
			return false;
		}
	}

	private static void jugada(String entrada) {
		String[] arrayEntrada = entrada.split(": ");
		String jugador = arrayEntrada[0];
		String[] naipes = arrayEntrada[1].split(" ");
		Mazo mazoJugador;
		if (jugadores.get(jugador) != null) {
			mazoJugador = jugadores.get(jugador);
		} else {
			mazoJugador = new Mazo(0);
		}
		for (String s : naipes) {
			Naipe naipe = new Naipe(String.valueOf(valorNaipe(s.substring(0, s.length() - 1))),
					palo(s.substring(s.length() - 1, s.length()).toUpperCase()));
			Mazo.addNaipes(mazoJugador, naipe);
		}
		jugadores.put(jugador, mazoJugador);
	}

	private static String palo(String palo) {
		switch (palo) {
		case "S":
			return "picas";
		case "H":
			return "corazones";
		case "D":
			return "diamantes";
		case "C":
			return "tréboles";
		}
		return null;
	}

	private static String valorNaipe(String valor) {
		switch (valor) {
		case "A":
			return "Ace";
		case "K":
			return "King";
		case "Q":
			return "Queen";
		case "J":
			return "Jack";
		default:
			return valor;
		}
	}

}
