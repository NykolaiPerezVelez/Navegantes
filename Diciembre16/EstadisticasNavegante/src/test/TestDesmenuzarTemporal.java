package test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import funciones.Funciones;

public class TestDesmenuzarTemporal {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		//Que archivo?
		String direccionArchivo = "C:/Users/nico_/Downloads/navegante1.rtf";
		
		Funciones f = new Funciones();
		
		//Agarro un temporal , el primero
		ArrayList<String> temporal =  f.listaTemporalesSeparados(f.leerTemporales(direccionArchivo)).get(1);
		
		
		//Veamos el temporal que agarre...
		System.out.println("Este es el temporal: ");
		for (String s: temporal){
			System.out.println(s);
		}
		System.out.println("--------------------");
		
		System.out.println("Este es el numero de temporal: ");
		System.out.println(f.conseguirNumeroTemporal(temporal));
		System.out.println("--------------------");
		
		
		System.out.println("Que es lo que hace???: ");
		System.out.println(f.conseguirQueHace(temporal));
		System.out.println("--------------------");
		
		
		System.out.println("Que es ???: ");
		System.out.println(f.conseguirQueEs(temporal));
		System.out.println("--------------------");
		
		
		
		
		
		
		
		
		
	}

}
