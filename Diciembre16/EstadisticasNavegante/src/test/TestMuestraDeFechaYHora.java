package test;

import java.io.FileNotFoundException;
import java.util.ArrayList;


import funciones.Funciones;


public class TestMuestraDeFechaYHora {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		
		//Instancia de funciones
		Funciones f = new Funciones();
		
		//Variables de prueba
		ArrayList<String> m= new ArrayList<String>();
		
		//Archivo en cuestion
		String direccionArchivo = "C:/Users/nico_/Downloads/navegante1.rtf";
		
		
		m = f.leerFecha(direccionArchivo);
		
		
		
		for (int i=0; i<m.size(); i ++){
			System.out.println(m.get(i));
		}
		

	}

}
