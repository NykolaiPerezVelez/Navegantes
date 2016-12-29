package test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import funciones.Funciones;

public class TestMuestraTemporales {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		
		
		String direccionArchivo = "C:/Users/nico_/Downloads/navegante1.rtf";
		Funciones f = new Funciones();
		
		
		
		//System.out.println(f.listaTemporalesSeparados(f.leerTemporales(direccionArchivo)).get(1).size());
		
		
		for (ArrayList<String> a:f.listaTemporalesSeparados(f.leerTemporales(direccionArchivo))){
			System.out.println("Nuevo temporal");
			for(String s: a){
				
				System.out.println(s);
			}
			System.out.println("-----------------");
			
		}
		
		
		
		
	

	}

}
