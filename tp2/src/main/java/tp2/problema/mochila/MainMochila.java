package tp2.problema.mochila;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MainMochila {
    public static void main(String[] args) {
    	//simpleTest();
    	pisingerTests();
    }
    
    public static void simpleTest() {
    	System.out.println("[Simple Test]"); 
    	Mochila mochila = new Mochila(5);
    	
    	mochila.agregarItem(2, 3);
    	mochila.agregarItem(3, 4);
    	mochila.agregarItem(4, 5);
    	mochila.agregarItem(5, 6);
  
        System.out.println(mochila.toString()); 
        MochilaResult solucion = mochila.resolver(); 
        System.out.println("Solución: \n" + solucion.toString());
    }
    
    public static void pisingerTests() {
    	System.out.println("[Pisinger Tests]");
    	String filename = "D:\\TDA\\tda-tps2016\\tp2\\src\\main\\resources\\tp2\\mochila\\smallcoeff_pisinger\\knapPI_1_50_1000.csv";
    	
    	try {
	    	BufferedReader br = new BufferedReader(new FileReader(filename));
	    	while(pisingerTestInstance(br));
	    	br.close();
	    	
    	} catch (FileNotFoundException e) {
			System.out.println("No se pudo abrir el archivo " + filename);
			e.printStackTrace();
    	} catch (IOException e) {
    		System.out.println("Error de lectura. Archivo " + filename);
    		e.printStackTrace();
		}
    }
    
    public static boolean pisingerTestInstance(BufferedReader br) {
    	int n = -1; // Cantidad de items
    	int c = -1; // Capacidad de la mochila (peso maximo)
    	int z = -1; // Valor optimo
    	float time = -1;
    	
    	Mochila mochila;
    	
    	boolean not_eof = false;
    	
    	try {
	    	String instanceName = br.readLine();
	    	System.out.println("[" + instanceName + "]");
	    	String linea;
	    	
	    	if((linea = br.readLine()) != null){
	    		n = Integer.valueOf(linea.split(" ")[1]);
	    		//System.out.println("n " + n);
			}
	    	if((linea = br.readLine()) != null){
	    		c = Integer.valueOf(linea.split(" ")[1]);
	    		//System.out.println("c " + c);
			}
	    	if((linea = br.readLine()) != null){
	    		z = Integer.valueOf(linea.split(" ")[1]);
	    		//System.out.println("z " + z);
			}
	    	if((linea = br.readLine()) != null){
	    		time = Float.valueOf(linea.split(" ")[1]);
	    		//System.out.println("time " + time);
			}
	    	
	    	mochila = new Mochila(c);
	    	
	    	int num_item = -1, valor, peso, x;
	    	while (num_item < n && (linea = br.readLine()) != null) {
	    		String[] fields = linea.split(",");
	    		num_item = Integer.valueOf(fields[0]);
	    		valor    = Integer.valueOf(fields[1]);
	    		peso     = Integer.valueOf(fields[2]);
	    		x        = Integer.valueOf(fields[3]);
	    		
	    		mochila.agregarItem(peso, valor);
	    		//System.out.println(num_item + ". Nuevo item agregado. Peso: " + peso + " Valor: " + valor);
	    	}
	    	
	    	// Medicion de tiempo
	    	long startTime = System.nanoTime();
	    	MochilaResult result = mochila.resolver();
	    	double timeDuration = (System.nanoTime() - startTime)/1e9;
	    	
	    	System.out.println("Resultado calculado: " + result.getValorOptimo());
	    	if (result.getValorOptimo() != z) {
	    		System.out.println("Resultado calculado NO ES EL OPTIMO!!!!");
	    	}
	    	System.out.println("Tiempo: " + timeDuration);
	    	
	    	// Avanzo el buffer de lectura
	    	br.readLine();
	    	br.readLine();
	    	
	    	not_eof = br.ready();
	    	
    	} catch (IOException e) {
    		System.out.println("Error de lectura");
    		e.printStackTrace();
		}
    	
    	
    	return not_eof;
    }
}
