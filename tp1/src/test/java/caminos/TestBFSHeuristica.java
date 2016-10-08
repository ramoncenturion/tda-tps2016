package caminos;

import java.util.List;
import java.util.PriorityQueue;

import org.junit.Assert;
import org.junit.Test;

public class TestBFSHeuristica {
	
	private Digraph grafo;
	private int origen;
	private int destino;
	private BFSHeuristica bfs;
	private List<Arista> camino;
	
	private void inicializarGrafo(int cantidadVertices) {
		grafo = new Digraph(cantidadVertices);
	}
	
	private void inicializarOrigenDestino(int i, int j) {
		origen = i;
		destino = j;
	}
	
	private void encontrarCamino() {
		bfs = new BFSHeuristica(grafo, origen, destino);
		camino = bfs.camino(destino);
	}
	
	@Test
	public void testBFSHeuristica() {
		inicializarGrafo(8);
		inicializarOrigenDestino(0, 7);
		
		grafo.add_edge(0, 1, 2);
		grafo.add_edge(1, 2, 3);
		grafo.add_edge(2, 3, 1);
		grafo.add_edge(3, 4, 5);
		grafo.add_edge(4, 5, 2);
		grafo.add_edge(4, 6, 3);
		grafo.add_edge(1, 7, 4);
		grafo.add_edge(2, 7, 3);
		
		encontrarCamino();
		
		Assert.assertTrue(camino != null);
	}
	
	//@Test
	public void testCola() {
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		queue.add(1);
		queue.add(2);
		queue.add(3);
		//...
		
		Integer val = null;
		while( (val = queue.poll()) != null) {
			System.out.println(val);
		}
	}
	
}
