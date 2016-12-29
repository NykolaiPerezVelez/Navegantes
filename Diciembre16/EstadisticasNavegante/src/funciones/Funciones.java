package funciones;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Funciones {

	
	
	
	
	//////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////
	//Consigue la fecha y la hora del boletin leido, devuelve una lista de dos objetos,
	// en la posicion 0 la fecha, y en la posicion 1 la hora
	public ArrayList<String> conseguirFechaYHoraBoletin(String direccionArchivo) throws FileNotFoundException{
		return leerFecha(direccionArchivo);
	}
	
	
	///////////////////////////////////////////////////////////////////////////////////
	public ArrayList<String> leerFecha(String direccionArchivo) throws FileNotFoundException{
		
		ArrayList<String> fechaSalida = new ArrayList<String>();
		
		try { 
			
			
			
			File original = new File(direccionArchivo); 
			FileInputStream a = new FileInputStream(original); 
			
			
			
			//creo el input stream solo para obtener la codificación del archivo 
			InputStreamReader b = new InputStreamReader(a); 
			
			//reescribo el input stream para que pueda leer el archivo con la codificación original del archivo 
			b = new InputStreamReader(a, b.getEncoding()); 
			
			//b = new InputStreamReader(a, "Unicode"); //con esta leo el archivo como unicode 
			BufferedReader lector = new BufferedReader(b); //creo el lector del archivo 
			
			
			//comienzo la lectura del archivo 
			String line = lector.readLine(); 
			while (line != null) { 
			String[] palabras;
			palabras = line.split(" "); //obtengo cada palabra separada por un espacio 
			
			for(int i = 0; i < palabras.length; i++){ 
			if(palabras[i].equals("UTC.<p>SERVICIO")){ 
			
				int indicePalabraEncontrada = i;
				
				for (int j=0; j<indicePalabraEncontrada; j++){
				fechaSalida.add(palabras[j]);	
				//System.out.println(palabras[j]);
				
				
				
				}
				
			} 
			} 
			line = lector.readLine();
			
			} 
			lector.close();
			} catch (Exception e) { 
				} 
			
		return limpiarFecha(stringFechaLectura(fechaSalida));}
	
	
	////////////////////////////////////////////////////////////////
	//Donde inicia la lectura de la fecha
	public ArrayList<String> stringFechaLectura (ArrayList<String> fechaSalida){
		
		//mi salida pura 10-10-2016, 09:00... por ejemplo
		ArrayList<String> stringFechaLectura = new ArrayList<String>();
		
		int indicePalabraEncontrada =0;
		
		for(int i = 0; i < fechaSalida.size(); i++){ 
			if(fechaSalida.get(i).equals("6")){ 
				
				
			
				//Desde aca guardo
				indicePalabraEncontrada = i;
			}}
				
		
				
				
				for (int j=indicePalabraEncontrada+1; j<fechaSalida.size(); j++){
					
					stringFechaLectura.add(fechaSalida.get(j));
					
				
				}
				
			
			
		
		return stringFechaLectura;
	}
	
	///////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////
	public ArrayList<String> limpiarFecha(ArrayList<String> fechaSucia){
		
		ArrayList<String> fechaLimpia = new ArrayList<String>();
		
		fechaLimpia = fechaSucia;
		
		
		//Borramos los primeros cuatro caracteres de la fecha
		fechaLimpia.set(0,fechaSucia.get(0).substring(4));
		//Borramos la coma :) 
		fechaLimpia.set(0, fechaLimpia.get(0).substring(0,10));
		
		
		
		
		return fechaLimpia;
	}
	
	//////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////
	
	
	///////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////
	//Esto me devuelve todo el texto del temporal separado por palabras
	//RESTA SEPARARLOS A LOS TEMPORALES
	
	public ArrayList<String> leerTemporales(String direccionArchivo) throws FileNotFoundException{
		
		ArrayList<String> listaPalabras = new ArrayList<String>();
		
		try { 
			
			
			
			File original = new File(direccionArchivo); 
			FileInputStream a = new FileInputStream(original); 
			
			
			
			//creo el input stream solo para obtener la codificación del archivo 
			InputStreamReader b = new InputStreamReader(a); 
			
			//reescribo el input stream para que pueda leer el archivo con la codificación original del archivo 
			b = new InputStreamReader(a, b.getEncoding()); 
			
			//b = new InputStreamReader(a, "Unicode"); //con esta leo el archivo como unicode 
			BufferedReader lector = new BufferedReader(b); //creo el lector del archivo 
			
			
			//comienzo la lectura del archivo 
			String line = lector.readLine(); 
			while (line != null) { 
			String[] palabras;
			palabras = line.split(" "); //obtengo cada palabra separada por un espacio 
			
			for(int i = 0; i < palabras.length; i++){ 
			if(palabras[i].equals("SINOPSIS")){ 
				if(palabras[i-1].equals("PARTE")){
			
				int indicePalabraEncontrada = i-1;
				
				for (int j=0; j<indicePalabraEncontrada; j++){
				listaPalabras.add(palabras[j]);	
				//System.out.println(palabras[j]);
				
				
				
				}
				}
				
			} 
			} 
			line = lector.readLine();
			
			} 
			lector.close();
			} catch (Exception e) { 
				} 
		
		ArrayList<String> listaPalabrasTemporales = new ArrayList<String>();
		
		boolean encontrarInicio = false;
		
		for (String s:listaPalabras){
			if (s.equals("TEMPORAL:<p>AVISO")){
				encontrarInicio = true;
				}
			
			if (encontrarInicio){
				
				listaPalabrasTemporales.add(s);
				
			}
			
			
		} //Cierra el For
		
		
		listaPalabrasTemporales.remove(0);
		
		
		return listaPalabrasTemporales;}
	
	
	/////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////
	//Esto es para separar los temporales en listas distintas
	
	public ArrayList<ArrayList<String>> listaTemporalesSeparados (ArrayList<String> listaDePalabrasDeTemporal){
		
		//Lista, de listas de palabras de los temporales por separado....
		ArrayList<ArrayList<String>>  listaTemporalesSeparados = new ArrayList<ArrayList<String>>();
		
		
		//Lista de indices de temporales
		ArrayList<String> indices = new ArrayList<String>();
		
		int iterador = 0;
		
		
		//buscamos donde empiezan los temporales
		
		
		for (int i = 0; i<listaDePalabrasDeTemporal.size();i++){
			
			//Si lo encuentra guarda el indice
			if (listaDePalabrasDeTemporal.get(i).indexOf(":")!=-1){
				
				String indiceEncontrado = Integer.toString(i);
				indices.add(indiceEncontrado);
				
				//System.out.println(indiceEncontrado);
				
				}
			
		}//Recorro mi argumento de entrada
		
		int elegirTemporal = 0;
		
		
		////////////////////////////////////////////////////////////////////
		//LISTO ESTOS SON MIS INDICES FINALES!!!!!!!!!!!!!
		//ACA SON LO CORTES DE MI TEMPORAL
		indices.add(Integer.toString(listaDePalabrasDeTemporal.size()));
		/////////////////////////////////////////////////////////////////////
		
		
		//Inicio mis temporales en nulo, para evitar problemas
		//for (int in =0; in<indices.size()-1;in++){
		//listaTemporalesSeparados.add(null);
		//}
		
		
		
		int indiceInicial = 0;
	
		
		for (String indice:indices){
			
			//indices de temporales
			
			int indiceFinal = Integer.parseInt(indice);
			
		
			
			
			
			if (indiceFinal!=0){
				
				
				ArrayList<String> aux0 = new ArrayList<String>();
				ArrayList<String> aux1 = new ArrayList<String>();
				ArrayList<String> aux2 = new ArrayList<String>();
				ArrayList<String> aux3 = new ArrayList<String>();
				ArrayList<String> aux4 = new ArrayList<String>();
				ArrayList<String> aux5 = new ArrayList<String>();
				ArrayList<String> aux6 = new ArrayList<String>();
				ArrayList<String> aux7 = new ArrayList<String>();
				ArrayList<String> aux8 = new ArrayList<String>();
				ArrayList<String> aux9 = new ArrayList<String>();
				ArrayList<String> aux10 = new ArrayList<String>();
				ArrayList<String> aux11 = new ArrayList<String>();
				
				
				
				
				for (int j= indiceInicial; j<indiceFinal; j++){
					
					
					
					
					
					if (iterador==0){
					aux0.add(listaDePalabrasDeTemporal.get(j));}
					
					if (iterador==1){
						aux1.add(listaDePalabrasDeTemporal.get(j));}
					
					if (iterador==2){
						aux2.add(listaDePalabrasDeTemporal.get(j));}
					
					if (iterador==3){
						aux3.add(listaDePalabrasDeTemporal.get(j));}
						
					if (iterador==4){
						aux4.add(listaDePalabrasDeTemporal.get(j));}
						
					if (iterador==5){
						aux5.add(listaDePalabrasDeTemporal.get(j));}
						
					if (iterador==6){
						aux6.add(listaDePalabrasDeTemporal.get(j));}
							
					if (iterador==7){
						aux7.add(listaDePalabrasDeTemporal.get(j));}
							
					if (iterador==8){
						aux8.add(listaDePalabrasDeTemporal.get(j));}
							
							
					if (iterador==9){
						aux9.add(listaDePalabrasDeTemporal.get(j));}
								
					if (iterador==10){
						aux10.add(listaDePalabrasDeTemporal.get(j));}
								
					if (iterador==11){
						aux11.add(listaDePalabrasDeTemporal.get(j));}
					
					//System.out.println(listaDePalabrasDeTemporal.get(j));
					
					
					
				}//cierra el for
				
				
				//System.out.println("Veamos el auxiliar a poner en la lista");
				//for (String s:aux){
				//System.out.println(s);}
				
				
				
				if (iterador==0){
					listaTemporalesSeparados.add(aux0);}
					
				if (iterador==1){
					listaTemporalesSeparados.add(aux1);}
					
				if (iterador==2){
					listaTemporalesSeparados.add(aux2);}
				
				if (iterador==3){
					listaTemporalesSeparados.add(aux3);}
					
				if (iterador==4){
					listaTemporalesSeparados.add(aux4);}
					
				if (iterador==5){
					listaTemporalesSeparados.add(aux5);}
				
				if (iterador==6){
					listaTemporalesSeparados.add(aux6);}
					
				if (iterador==7){
					listaTemporalesSeparados.add(aux7);}
					
				if (iterador==8){
					listaTemporalesSeparados.add(aux8);}
				
				if (iterador==9){
					listaTemporalesSeparados.add(aux9);}
					
				if (iterador==10){
					listaTemporalesSeparados.add(aux10);}
					
				if (iterador==11){
					listaTemporalesSeparados.add(aux11);}
				
				
				
				iterador=iterador+1;
	
				
			}//cierra la recorrida de indices que sirven
			
			//listaTemporalesSeparados.set(elegirTemporal-1, aux);
			
			
			
			indiceInicial = indiceFinal;
			elegirTemporal = elegirTemporal + 1;
			
			
		}//cierra el recorrido de TODOS lo indides
		
		
		
		
		return listaTemporalesSeparados;
	}//Listo aca retorno una lista con temporales separados, cada elemento de la lista es un temporal
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	//Con una lista de palabras de un temporal, conseguire el numero de temporal
	public int conseguirNumeroTemporal (ArrayList<String> temporal){
		
		int numeroTemporal = 0;
		
		//Me quedo con la primer palabra
		String primerPalabra = temporal.get(0);
		
		//Es de la forma 222:.... le quito los dos puntos
		// Para borar el ultimo digito haces esto 
		String numeroTemporalString = primerPalabra.substring(0, primerPalabra.length()-1);
		
		
		//LO paso a int
		numeroTemporal = Integer.parseInt(numeroTemporalString);
		
		return numeroTemporal;
		
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////
		
	
	
	
	//Con una lista de palabras de un temporal, conseguire el numero de temporal
	public String conseguirQueHace (ArrayList<String> temporal){
		
		String queHace = "PROVOCA";
		
		for (String palabra:temporal){
			if (palabra.equals("PROVOCARA")){
				queHace = "PROVOCARA";}
			
		}
			return queHace;
		
	}
	
	
		/////////////////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////////////////////////
		
			
	//Con una lista de palabras de un temporal, conseguire el numero de temporal
	public String conseguirQueEs (ArrayList<String> temporal){
		
		String queHace = "";
		
		if (temporal.get(1).equals("DEPRESION")){
			queHace = "DEPRESION";
		}
		
		if (temporal.get(1).equals("FUERTE")){
			queHace = "FUERTE GRADIENTE BARICO";
		}
		
		if (temporal.get(1).equals("CFNT")){
			queHace = "FRENTE FRIO";
		}
			return queHace;
		
	}
	
		/////////////////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////////////////////////
		
			
	//Con una lista de palabras de un temporal, conseguire el numero de temporal
	public int conseguirFuerza (ArrayList<String> temporal){
		
		int fuerza = 0;
		
		
		for (String palabra: temporal){
			
		}
		
		
			return fuerza;
		
	}
	
	
		/////////////////////////////////////////////////////////////////////////////////////////////
		///////////////////////////////////////////////////////////////////////////////////////////////
		////////////////////////////////////////////////////////////////////////////////////////////////

	
	
}

	
	
		
		

