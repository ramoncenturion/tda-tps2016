package tp2;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import tp2.problema.mochila.Mochila;
import tp2.problema.mochila.MochilaResult;

public class MochilaTest {

	@Test
	public void testSimple() {
    	//System.out.println("[Simple Test]"); 
    	Mochila mochila = new Mochila(5);
    	
    	mochila.agregarItem(2, 3);
    	mochila.agregarItem(3, 4);
    	mochila.agregarItem(4, 5);
    	mochila.agregarItem(5, 6);
  
        //System.out.println(mochila.toString()); 
        MochilaResult solucion = mochila.resolver(); 
        //System.out.println("Solución: \n" + solucion.toString());
        
        assertEquals(7, solucion.getValorOptimo());
        assertEquals(2, solucion.getItemsSolucion().size());
	}
	
	@Test
	public void testPisinger() {
	
		//String filename = "D:\\TDA\\tda-tps2016\\tp2\\src\\main\\resources\\tp2\\mochila\\smallcoeff_pisinger\\knapPI_1_50_1000.csv";
		String filename = "D:\\TDA\\tda-tps2016\\tp2\\src\\main\\resources\\tp2\\mochila\\smallcoeff_pisinger\\knapPI_1_100_1000.csv";
		//String filename = "D:\\TDA\\tda-tps2016\\tp2\\src\\main\\resources\\tp2\\mochila\\smallcoeff_pisinger\\knapPI_1_200_1000.csv";
		//String filename = "D:\\TDA\\tda-tps2016\\tp2\\src\\main\\resources\\tp2\\mochila\\smallcoeff_pisinger\\knapPI_1_500_1000.csv";

		//String filename = "D:\\TDA\\tda-tps2016\\tp2\\src\\main\\resources\\tp2\\mochila\\smallcoeff_pisinger\\knapPI_9_50_1000.csv";
		
		//String filename = "D:\\TDA\\tda-tps2016\\tp2\\src\\main\\resources\\tp2\\mochila\\hardinstances_pisinger\\knapPI_11_20_1000.csv";
		//String filename = "D:\\TDA\\tda-tps2016\\tp2\\src\\main\\resources\\tp2\\mochila\\hardinstances_pisinger\\knapPI_11_50_1000.csv";
		//String filename = "D:\\TDA\\tda-tps2016\\tp2\\src\\main\\resources\\tp2\\mochila\\hardinstances_pisinger\\knapPI_11_100_1000.csv";
		//String filename = "D:\\TDA\\tda-tps2016\\tp2\\src\\main\\resources\\tp2\\mochila\\hardinstances_pisinger\\knapPI_11_200_1000.csv";
	
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
	
	private boolean pisingerTestInstance(BufferedReader br) {
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
	    	
	    	assertEquals(z, result.getValorOptimo());
	    	System.out.println("Tiempo: " + timeDuration + " Tiempo esperado: " + time + " Diferencia: " + (timeDuration - time));
	    	
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
