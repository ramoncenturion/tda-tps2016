package tp2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import tp2.redes.flujo.Red;
import tp2.redes.flujo.SelectorProyectos;

public class RedFlujoTest {

	 private static final String PATH = "src/main/resources/tp2/redes/flujo/entradaRed.txt";

	@Test
	public void redtest() {
		try {
            SelectorProyectos selector = new SelectorProyectos(PATH);
                        
            int max_flujo = selector.getFordFulkerson().getFlujoMaximo();
            Red red = selector.getRed();
        
            assertEquals(red.n(), 7);
            assertEquals(red.m(), 8);
            assertEquals(max_flujo, 29);
            assertEquals(selector.getMaximaGanancia(), 1);
            

        } catch (Exception e) {
            fail(e.getMessage());
        }
	}

}
