package tp1;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {

	private static String entradaGrafo = "C:/Users/Usuario/git/tda-tps2016/tp1/src/main/resources/entradaGrafos.txt";
	private static String entradaOrdenK = "C:/Users/Usuario/git/tda-tps2016/tp1/src/main/resources/entradaOrdenK.txt";
	
	public static void main(String[] args) {
		
		// Descomentar para ingresar el path por consola
/*		System.out.println("Ingrese la direccion el archivo a procesar");
		String entradaTeclado = "";
	    Scanner entradaEscaner = new Scanner(System.in);
	    entradaTeclado = entradaEscaner.nextLine ();
*/
		
		// Descomentar para correr primer parte del TP
	    LectorArchivo lector = new LectorArchivo(entradaOrdenK,false);
		
		// Descomentar para correr segunda parte del TP
//	    LectorArchivo lector = new LectorArchivo(entradaGrafo,true);
	    
	    try {
			lector.procesarArchivo();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
//	    System.out.println("Cantidad Vertices: "+lector.getCantidadVertices()+" - "
//	    		+ "Cantidad Aristas: "+lector.getCantidadAristas());
	    List<String> elementos = lector.getElementos();
	    System.out.println("Elementos:");
	    for (String elemento : elementos) {
			System.out.println(elemento);
		}
	    
	}

}
