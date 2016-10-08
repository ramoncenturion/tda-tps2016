package caminos;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestDijksta {
	private Digraph grafo;
	private int origin;
	private int destino;
	private Dijkstra dijkstra;
	
	@Before
	public void setup() {
		inicializarValores();
	}
	
	private void inicializarValores() {
		grafo = new Digraph(4);
		origin = 0;
		destino = 3;
	}
	
	@Test
	public void testDeberiaEncontrarUnCamino() {
		grafo.add_edge(0, 1, 2);
		grafo.add_edge(1, 2, 1);
		grafo.add_edge(2, 3, 3);
		grafo.add_edge(1, 3, 5);
		
		dijkstra = new Dijkstra(grafo, origin, destino);
		
	
		List<Arista> camino = dijkstra.camino(destino);
		
		Assert.assertTrue(camino != null && camino.size() > 0);
		//Assert.assertTrue(dijkstra.dist != null && dijkstra.dist.length > 0);
	}
}
