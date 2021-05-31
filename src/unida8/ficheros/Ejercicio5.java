package unida8.ficheros;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ejercicio5 {

	static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		String ruta = "archivos\\ejercicio4.bin";
		String bin = null;

		try (DataInputStream dis = new DataInputStream(new BufferedInputStream(new FileInputStream(ruta)))){
			bin = dis.readUTF();
		} catch (IOException e) {
			System.out.println("Ha saltado una excepción " + e);
		} 		

		try (PrintWriter pw = new PrintWriter(new FileWriter("archivos\\ejercicio5.txt"))) {
			pw.println(bin);
			System.out.println("Archivo creado");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
