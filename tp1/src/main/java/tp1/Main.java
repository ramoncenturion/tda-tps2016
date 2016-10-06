package tp1;

import java.io.IOException;
import java.util.List;
//import java.util.Scanner;

import algoritmosOrdenK.FuerzaBruta;
import algoritmosOrdenK.KSelecciones;
import algoritmosOrdenK.OrdenarSeleccionar;

public class Main {

	private static String entradaGrafo = "C:/Dev/tda/tda-tps2016/tp1/src/main/resources/entradaGrafos.txt";
	private static String entradaOrdenK = "C:/Dev/tda/tda-tps2016/tp1/src/main/resources/entradaOrdenK.txt";
	
	public static void main(String[] args) {
		
		// Descomentar para ingresar el path por consola
/*		System.out.println("Ingrese la direccion el archivo a procesar");
		String entradaTeclado = "";
	    Scanner entradaEscaner = new Scanner(System.in);
	    entradaTeclado = entradaEscaner.nextLine ();
*/
		
		// para correr primer parte del TP
	    LectorArchivo lectorOrdenK = new LectorArchivo(entradaOrdenK,false);
		
		// para correr segunda parte del TP
	    LectorArchivo lectorGrafo = new LectorArchivo(entradaGrafo,true);
	    
	    try {
			lectorOrdenK.procesarArchivoOrdenK();
			lectorGrafo.procesarArchivoGrafo();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	    System.out.println("Cantidad Vertices: "+lectorGrafo.getCantidadVertices()+" - "+ "Cantidad Aristas: "+lectorGrafo.getCantidadAristas());
	    
	    List<Integer> elementos = lectorOrdenK.getConjuntoElementos();
	    System.out.println("Elementos:");
	    for (Integer elemento : elementos) {
			System.out.print(elemento+" | ");
		}

	    System.out.println("\n****************************");
	    System.out.println("\nFuerza Bruta");
	    FuerzaBruta algoFuerzaBruta = new FuerzaBruta(lectorOrdenK.getConjuntoElementos());

	    System.out.println("\n****************************");
	    System.out.println("Ordenar y seleccionar");
	    OrdenarSeleccionar algoOrdenarSeleccionar = new OrdenarSeleccionar(lectorOrdenK.getConjuntoElementos());

	    KSelecciones algoKSelecciones = new KSelecciones(lectorOrdenK.getConjuntoElementos());
	}

}
