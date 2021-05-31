package unida8.ficheros;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import unidad7.Libro;
import unidad7.Publicacion;
import unidad7.Revista;

public class Ejercicio9 {
	private static ArrayList<Publicacion> biblioteca = new ArrayList<Publicacion>();

	public static void main(String[] args) throws FileNotFoundException {
		/*A partir de las clases Publicación definidas en el ejercicio 1 de la unidad 7, escribe un programa que
		almacene en un fichero datos de libros y revistas mediante serialización de objetos Libro y Revista.*/
		Publicacion lib = new Libro("Nombre Libro", 2021, "Autor yo");
		biblioteca.add(lib);
		Publicacion rev = new Revista ("Nombre Revista", 2021, 01, "Marzo", 01);
		biblioteca.add(rev);
		Publicacion lib2 = new Libro("Nombre Libro2", 2021, "Autor tu");
		biblioteca.add(lib2);
		Publicacion rev2 = new Revista ("Nombre Revista2", 2021, 10, "Marzo", 02);
		biblioteca.add(rev2);

		try(ObjectOutputStream writer = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("archivos\\biblioteca.obj")))){
			for(Publicacion p : biblioteca) {
				writer.writeObject(p);
			}
			System.out.println("Archivo creado");
		}
		catch(IOException e) {
			
		}
		
		try(ObjectInputStream reader = new ObjectInputStream(new BufferedInputStream(new FileInputStream("archivos\\biblioteca.obj")))){
			Object aux;
			while((aux = reader.readObject()) != null) {
					System.out.println(aux);
			}
		} catch (ClassNotFoundException | EOFException e) {
			System.out.println("Fin");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

}
