package tp2;

import static org.junit.Assert.*;

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

}
