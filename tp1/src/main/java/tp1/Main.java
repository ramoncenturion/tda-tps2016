package tp1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
//import java.util.Scanner;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import algoritmosOrdenK.FuerzaBruta;
import algoritmosOrdenK.HeapSelect;
import algoritmosOrdenK.KHeapsort;
import algoritmosOrdenK.KSelecciones;
import algoritmosOrdenK.OrdenarSeleccionar;
import algoritmosOrdenK.QuickSelect;

public class Main {

	private static String entradaGrafo = "C:\\Users\\Usuario\\git\\tda-tps2016\\tp1\\src\\main\\resources\\entradaGrafos.txt";
	private static String entradaOrdenK = "C:\\Users\\Usuario\\git\\tda-tps2016\\tp1\\src\\main\\resources\\entradaOrdenK.txt";
	private static String entradaFuerzaBruta = "C:\\Users\\Usuario\\git\\tda-tps2016\\tp1\\src\\main\\resources\\entradaFuerzaBruta.txt";
	private static FileWriter salida;
	private static String rutaArchivoSalida = "c:\\dev\\archivoSalida.xls";
	private static HSSFWorkbook libro;
	private static HSSFSheet hoja;
	private static int cantFilas = 0;
	
	public static void main(String[] args) throws IOException {
		// Descomentar para ingresar el path por consola
/*		System.out.println("Ingrese la direccion el archivo a procesar");
		String entradaTeclado = "";
	    Scanner entradaEscaner = new Scanner(System.in);
	    entradaTeclado = entradaEscaner.nextLine ();
*/
		
		
		// para correr primer parte del TP
	    LectorArchivo lectorOrdenK = new LectorArchivo(entradaFuerzaBruta,false);
		
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
	    
		File archivoXLS = new File(rutaArchivoSalida );
		archivoXLS.createNewFile();
		libro = new HSSFWorkbook();
		FileOutputStream archivo = new FileOutputStream(archivoXLS);
		hoja = libro.createSheet("Estadisticas");
		
		escribirFila("", "Fuerza Bruta", "");
		escribirFila("Estadistico K", "Value", "Time");
		
	    System.out.println("\n****************************");
	    System.out.println("Fuerza Bruta");
	    
	    FuerzaBruta algoFuerzaBrutaMin = new FuerzaBruta(lectorOrdenK.getConjuntoElementos(),minimo);
	    System.out.println("Minimo: "+algoFuerzaBrutaMin.getElementK());
	    System.out.println("Time: "+ algoFuerzaBrutaMin.getProcessTime());
	    
	    escribirFila("Minimo", String.valueOf(algoFuerzaBrutaMin.getElementK()),String.valueOf(algoFuerzaBrutaMin.getProcessTime()));
		    
	    FuerzaBruta algoFuerzaBrutaMed = new FuerzaBruta(lectorOrdenK.getConjuntoElementos(),mediana);
	    System.out.println("Mediana: "+algoFuerzaBrutaMed.getElementK());
	    System.out.println("Time: "+ algoFuerzaBrutaMed.getProcessTime());

	    escribirFila("Mediana", String.valueOf(algoFuerzaBrutaMed.getElementK()),String.valueOf(algoFuerzaBrutaMed.getProcessTime()));
	    
	    FuerzaBruta algoFuerzaBrutaMax = new FuerzaBruta(lectorOrdenK.getConjuntoElementos(),maximo);
	    System.out.println("Maximo: "+algoFuerzaBrutaMax.getElementK());
	    System.out.println("Time: "+ algoFuerzaBrutaMax.getProcessTime());
	    
	    escribirFila("Maximo", String.valueOf(algoFuerzaBrutaMax.getElementK()),String.valueOf(algoFuerzaBrutaMax.getProcessTime()));

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
	    
		List<Integer> A = new ArrayList<Integer>();
    	A.add(4);
    	A.add(1);
    	A.add(3);
    	A.add(2);
    	A.add(16);
    	A.add(9);
    	A.add(10);
    	A.add(14);
    	A.add(8);
    	A.add(7);
    	
    	int k = 11;
    	
    	System.out.println("\n****************************");
	    System.out.println("K HeapSort");
	    
    	KHeapsort khMin = new KHeapsort(lectorOrdenK.getConjuntoElementos(), minimo);
	    System.out.println("Minimo: "+khMin.getElementK());
	    System.out.println("Time: "+ khMin.getProcessTime());

	    KHeapsort khMed = new KHeapsort(lectorOrdenK.getConjuntoElementos(), mediana);
	    System.out.println("Mediana: "+khMed.getElementK());
	    System.out.println("Time: "+ khMed.getProcessTime());

	    KHeapsort khMax = new KHeapsort(lectorOrdenK.getConjuntoElementos(), maximo);
	    System.out.println("Maximo: "+khMax.getElementK());
	    System.out.println("Time: "+ khMax.getProcessTime());

    	System.out.println("\n****************************");
	    System.out.println("HeapSelect");
	    
    	HeapSelect heapSelMin = new HeapSelect(lectorOrdenK.getConjuntoElementos(), minimo);
	    System.out.println("Minimo: "+heapSelMin.getElementK());
	    System.out.println("Time: "+ heapSelMin.getProcessTime());

    	HeapSelect heapSelMed = new HeapSelect(lectorOrdenK.getConjuntoElementos(), mediana);
	    System.out.println("Mediana: "+heapSelMed.getElementK());
	    System.out.println("Time: "+ heapSelMed.getProcessTime());

	    HeapSelect heapSelMax = new HeapSelect(lectorOrdenK.getConjuntoElementos(), maximo);
	    System.out.println("Maximo: "+heapSelMax.getElementK());
	    System.out.println("Time: "+ heapSelMax.getProcessTime());
	    
    	System.out.println("\n****************************");
	    System.out.println("QuickSelect");
	    
    	QuickSelect quickSelMin = new QuickSelect(lectorOrdenK.getConjuntoElementos(), minimo);
	    System.out.println("Minimo: "+quickSelMin.getElementK());
	    System.out.println("Time: "+ quickSelMin.getProcessTime());

    	QuickSelect quickSelMed = new QuickSelect(lectorOrdenK.getConjuntoElementos(), mediana);
	    System.out.println("Mediana: "+quickSelMed.getElementK());
	    System.out.println("Time: "+ quickSelMed.getProcessTime());

    	QuickSelect quickSelMax = new QuickSelect(lectorOrdenK.getConjuntoElementos(), maximo);
	    System.out.println("Maximo: "+quickSelMax.getElementK());
	    System.out.println("Time: "+ quickSelMax.getProcessTime());
	    
	    
	    
	    libro.write(archivo);
		archivo.close();
	}

	private static void escribirFila(String valorCol1, String valorCol2, String valorCol3) throws IOException {
		int i = 0;
		Row fila = hoja.createRow(cantFilas );
		Cell celda1 = fila.createCell(i);
		celda1.setCellValue(valorCol1);
		i++;
		Cell celda2 = fila.createCell(i);
		celda2.setCellValue(valorCol2);
		i++;
		Cell celda3 = fila.createCell(i);
		celda3.setCellValue(valorCol3);
		cantFilas++;
	}

}
