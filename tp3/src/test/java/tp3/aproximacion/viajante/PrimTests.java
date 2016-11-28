package tp3.aproximacion.viajante;

import org.junit.Test;

public class PrimTests {
	
	private Graph grafo;
	private int origen;
	
	private void inicializarGrafo() {
		grafo = new Graph();
	}
	
	@Test
	public void test() {
		inicializarGrafo();
		
		grafo.addArista(0, 1, 4);
		grafo.addArista(0, 7, 8);
		
		grafo.addArista(1, 2, 8);
		grafo.addArista(1, 7, 11);
	
		grafo.addArista(2, 8, 2);
		grafo.addArista(2, 5, 4);

		grafo.addArista(3, 4, 9);
		grafo.addArista(3, 5, 14);
		
		grafo.addArista(4, 5, 10);

		grafo.addArista(5, 6, 2);
		
		grafo.addArista(6, 8, 6);
		grafo.addArista(6, 7, 1);
		
		grafo.addArista(7, 8, 7);
		
		grafo.addArista(8, 2, 2);
		
		Prim prim = new Prim(grafo, 0);
	}
	
	/**
	 * Test del grafo de wikipedia
	 * https://es.wikipedia.org/wiki/Algoritmo_de_Prim
	 */
	@Test
	public void test2() {
		inicializarGrafo();
		
		grafo.addArista(0, 1, 7);
		grafo.addArista(0, 3, 5);
		
		grafo.addArista(1, 2, 8);
		grafo.addArista(1, 3, 9);
		grafo.addArista(1, 4, 7);
		
		grafo.addArista(2, 4, 5);
		
		grafo.addArista(3, 4, 15);
		grafo.addArista(3, 5, 6);
		
		grafo.addArista(4, 5, 8);
		grafo.addArista(4, 6, 9);
		
		grafo.addArista(5, 6, 11);
		
		Prim prim = new Prim(grafo, 3);
	}

}
