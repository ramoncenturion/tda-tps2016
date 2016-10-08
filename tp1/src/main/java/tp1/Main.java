package tp1;

import java.io.IOException;
import java.util.List;
//import java.util.Scanner;

import algoritmosOrdenK.FuerzaBruta;
import algoritmosOrdenK.KSelecciones;
import algoritmosOrdenK.OrdenarSeleccionar;

public class Main {

	private static String entradaGrafo = "C:\\Dev\\tda\\tda-tps2016\\tp1\\src\\main\\resources\\entradaGrafos.txt";
	private static String entradaOrdenK = "C:\\Dev\\tda\\tda-tps2016\\tp1\\src\\main\\resources\\entradaOrdenK.txt";
	
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

	    int minimo = 0;
		int maximo = lectorOrdenK.getConjuntoElementos().size()-1;
		int mediana = lectorOrdenK.getConjuntoElementos().size()/2;
	    
	    System.out.println("\n****************************");
	    System.out.println("Fuerza Bruta");
	    
	    FuerzaBruta algoFuerzaBrutaMin = new FuerzaBruta(lectorOrdenK.getConjuntoElementos(),minimo);
	    System.out.println("Minimo: "+algoFuerzaBrutaMin.getElementK());
	    System.out.println("Time: "+ algoFuerzaBrutaMin.getProcessTime());
	    
	    FuerzaBruta algoFuerzaBrutaMed = new FuerzaBruta(lectorOrdenK.getConjuntoElementos(),mediana);
	    System.out.println("Mediana: "+algoFuerzaBrutaMed.getElementK());
	    System.out.println("Time: "+ algoFuerzaBrutaMed.getProcessTime());

	    FuerzaBruta algoFuerzaBrutaMax = new FuerzaBruta(lectorOrdenK.getConjuntoElementos(),maximo);
	    System.out.println("Maximo: "+algoFuerzaBrutaMax.getElementK());
	    System.out.println("Time: "+ algoFuerzaBrutaMax.getProcessTime());
	    
	    
	    System.out.println("\n****************************");
	    System.out.println("Ordenar y seleccionar");
	    
	    OrdenarSeleccionar algoOrdSelMin = new OrdenarSeleccionar(lectorOrdenK.getConjuntoElementos(),minimo);
	    System.out.println("Minimo: " + algoOrdSelMin.getElementK());
	    System.out.println("Time: " + algoOrdSelMin.getProcessTime());
	    
	    OrdenarSeleccionar algoOrdSelMed = new OrdenarSeleccionar(lectorOrdenK.getConjuntoElementos(),mediana);
	    System.out.println("Mediana: " + algoOrdSelMed.getElementK());
	    System.out.println("Time: "+ algoOrdSelMed.getProcessTime());
	    	    
	    OrdenarSeleccionar algoOrdSelMax = new OrdenarSeleccionar(lectorOrdenK.getConjuntoElementos(),maximo);
	    System.out.println("Maximo: "+algoOrdSelMax.getElementK());
	    System.out.println("Time: "+ algoOrdSelMax.getProcessTime());
	    
	    System.out.println("\n****************************");
	    System.out.println("K selecciones");
	    
	    KSelecciones algoKSelMin = new KSelecciones(lectorOrdenK.getConjuntoElementos(),minimo);
	    System.out.println("Minimo: "+algoKSelMin.getElementK());
	    System.out.println("Time: "+ algoKSelMin.getProcessTime());
	    
	    KSelecciones algoKSelMed = new KSelecciones(lectorOrdenK.getConjuntoElementos(),mediana);
	    System.out.println("Mediana: "+algoKSelMed.getElementK());
	    System.out.println("Time: "+ algoKSelMed.getProcessTime());
	    
	    KSelecciones algoKSelMax = new KSelecciones(lectorOrdenK.getConjuntoElementos(),maximo);
	    System.out.println("Maximo: "+algoKSelMax.getElementK());
	    System.out.println("Time: "+ algoKSelMax.getProcessTime());
	    
	}

}
