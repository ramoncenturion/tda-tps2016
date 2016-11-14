package tp2;

import static org.junit.Assert.*;

import org.junit.Test;

import tp2.redes.flujo.Red;
import tp2.redes.flujo.SelectorProyectos;

public class RedFlujoTest {

	 private static final String PATH = "src/main/resources/tp2/redes/flujo/entradaRed.txt";
	 private static final String PATH1 = "src/main/resources/tp2/redes/flujo/entradaRed1.txt";

	@Test
	public void redtest() {
		try {
            SelectorProyectos selector = new SelectorProyectos(PATH);
                        
            int max_flujo = selector.getFordFulkerson().getFlujoMaximo();
            Red red = selector.getRed();
            selector.mostrarRed();
        
            assertEquals(red.n(), 7);
            assertEquals(red.m(), 8);
            assertEquals(max_flujo, 29);
            assertEquals(selector.getMaximaGanancia(), 1);
            

        } catch (Exception e) {
            fail(e.getMessage());
        }
	}

	
	@Test
	public void redtest2() {
		try {
            SelectorProyectos selector = new SelectorProyectos(PATH1);
                        
            int max_flujo = selector.getFordFulkerson().getFlujoMaximo();
            Red red = selector.getRed();
            selector.mostrarRed();
            
            assertEquals(red.n(), 9);
            assertEquals(red.m(), 11);
            assertEquals(max_flujo, 40);
            assertEquals(selector.getMaximaGanancia(), 1);
            
        } catch (Exception e) {
            fail(e.getMessage());
        }
	}
}