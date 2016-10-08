package caminos;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestBFS {
	
	private static int PESO_ARISTA = 0;
	private Digraph grafo;
	private int origin;
	private int destino;
	private BFS bfs;
	
	@Before
	public void setup() {
		inicializarValores();
	}
	
	private void inicializarValores() {
		grafo = new Digraph(3);
		origin = 0;
		destino = 2;
	}
	
	@Test
	public void testBFSDeberiaEncontrarUnCamino() {
		grafo.add_edge(0, 1, PESO_ARISTA);
		grafo.add_edge(0, 2, PESO_ARISTA);
		grafo.add_edge(1, 2, PESO_ARISTA);
		
		bfs = new BFS(grafo, origin, destino);
		List<Arista> camino = bfs.camino(destino);
		
		Assert.assertTrue(camino != null && camino.size() > 0);
	}
}
