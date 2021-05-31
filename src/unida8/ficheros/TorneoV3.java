package unida8.ficheros;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import unidad6.ElementoPokemon;
import unidad6.EntrenadorV2;
import unidad6.PokemonV2;

public class TorneoV3 {
	public static ArrayList<EntrenadorV2> entrenadoresTorneo2 = new ArrayList<EntrenadorV2>();
	public static Scanner teclado;
	public static ArrayList<PokemonV2> pokemonMuertos = new ArrayList<PokemonV2>();

	public static void main(String[] args) throws IOException {
		if(args.length == 1) {
			teclado = new Scanner(new File (args[0]));
		}
		else {
			teclado = new Scanner(System.in);
		}
		String entrada = teclado.next();
		while (!entrada.equalsIgnoreCase("torneo")) {
			try {
				EntrenadorV2 aspirante = new EntrenadorV2(entrada);
				if (entrenadoresTorneo2.contains(aspirante)) {
					entrenadoresTorneo2.get(entrenadoresTorneo2.indexOf(aspirante)).addPokemon(AnadirPokemon());
				} else {
					entrenadoresTorneo2.add(aspirante);
					aspirante.addPokemon(AnadirPokemon());
				}
			} catch (InputMismatchException e) {
				señalarError(teclado);
			} catch (NoSuchElementException e) {
				System.out.println("Datos insuficientes, introdúcelos de nuevo");
			}
			entrada = teclado.next();
		}
		entrada = teclado.next();
		while (!entrada.equalsIgnoreCase("fin")) {
			ElementoPokemon elmentoJuego = ElementoPokemon.valueOf(entrada.toUpperCase());
			for (EntrenadorV2 e : entrenadoresTorneo2) {
				boolean tieneElemento = false;
				for (PokemonV2 p : e.getColeccion()) {
					if (CompruebaElemento(elmentoJuego, p)) {
						tieneElemento = true;
					}
				}
				if (tieneElemento) {
					e.setInsignias();
				} else {
					for (PokemonV2 p : e.getColeccion()) {
						p.setSalud();
						if (p.getSalud() <= 0) {
							pokemonMuertos.add(p);
						}
					}
				}
				for (PokemonV2 pr : pokemonMuertos) {
					e.deletePokemon(pr);
				}
			}
			entrada = teclado.next();
		}
		for (EntrenadorV2 e : entrenadoresTorneo2) {
			System.out.println(e.toString());
		}
	}

	public static PokemonV2 AnadirPokemon() throws IOException {
		PokemonV2 poke = null;
		try {
			String nombrePokemon = teclado.next();
			String strElemento = teclado.next().toUpperCase();
			ElementoPokemon elmentoPokemon = ElementoPokemon.valueOf(strElemento);
			poke = new PokemonV2(nombrePokemon, elmentoPokemon, teclado.nextInt());
		} catch (InputMismatchException e) {
			señalarError(teclado);
		} catch (NoSuchElementException e) {
			System.out.println("Datos insuficientes, introdúcelos de nuevo");
		}
		return poke;

	}

	static void señalarError(Scanner teclado) {
		String error = teclado.next();
		int i = teclado.match().start();
		String formato = String.format("%%%ds\n'" + error + "' no es correcto, introduce los datos de nuevo\n", i + 1);
		System.out.printf(formato, "^");
	}

	public static boolean CompruebaElemento(ElementoPokemon elementoJuego, PokemonV2 poke) {
		if (poke.getElemento() == elementoJuego) {
			return true;
		} else {
			return false;
		}
	}
}
