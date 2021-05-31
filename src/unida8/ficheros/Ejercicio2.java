package unida8.ficheros;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Ejercicio2 {
	
	static String libro  = "archivos\\El Quijote UTF-8.txt";

	public static void main(String[] args) {
		FileInputStream quijote = null;
		BufferedInputStream quijoteBuf = null;
		
		try {
			quijote = new FileInputStream (libro);
			quijoteBuf = new BufferedInputStream(quijote);
			long t0 = System.currentTimeMillis();
			while(quijote.read() != -1);
			
			long t1 = System.currentTimeMillis();
			long t2 = System.nanoTime();
			while(quijoteBuf.read() != -1);
			
			long t3 = System.nanoTime();
			System.out.println("Tiempo SIN Buffer: " + (t1-t0)/1000 + " segundos, CON Buffer: " + (t3-t2) + " nanosegundos");
		}
		catch(IOException e) {
			System.out.println("Ha saltado una excepción " + e);
		}
		finally {
			try {
				quijote.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				quijoteBuf.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
