package caminos;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class TestBFS {
	
	private static int PESO_ARISTA = 0;
	private Digraph grafo;
	private int origen;
	private int destino;
	private BFS bfs;
	private List<Arista> camino;
	
	private void inicializarGrafo(int cantidadVertices) {
		grafo = new Digraph(cantidadVertices);
	}
	
	private void inicializarOrigenDestino(int i, int j) {
		origen = i;
		destino = j;
	}
	
	private void encontrarCamino() {
		bfs = new BFS(grafo, origen, destino);
		camino = bfs.camino(destino);
	}
	
	@Test
	public void testBFSDeberiaEncontrarUnCaminoCorrectoEnUnGrafoSimple() {
		inicializarGrafo(2);
		inicializarOrigenDestino(0, 1);
		
		grafo.add_edge(0, 1, PESO_ARISTA);
		
		encontrarCamino();
		
		Boolean hayUnCamino = camino != null && camino.size() > 0;
		Boolean caminoCorrecto = camino.get(0).getSrc() == 0 && camino.get(0).getDst() == 1;
		Assert.assertTrue(hayUnCamino && caminoCorrecto);
	}
	
	@Test
	public void testBFSDeberiaEncontrarUnCamino() {
		inicializarGrafo(3);
		inicializarOrigenDestino(0, 2);
		
		grafo.add_edge(0, 1, PESO_ARISTA);
		grafo.add_edge(0, 2, PESO_ARISTA);
		grafo.add_edge(1, 2, PESO_ARISTA);
		
		encontrarCamino();
		Assert.assertTrue(camino != null && camino.size() > 0);
	}
	
	@Test
	public void testBFSDeberiaEncontrarUnCaminoEnUnGrafoCiclico() {
		inicializarGrafo(3);
		inicializarOrigenDestino(0, 2);
		
		grafo.add_edge(2, 1, PESO_ARISTA);
		grafo.add_edge(1, 2, PESO_ARISTA);
		grafo.add_edge(0, 1, PESO_ARISTA);
		
		encontrarCamino();
		Assert.assertTrue(camino != null && camino.size() > 0);
	}
	
	@Test
	public void testBFSDeberiaEncontrarUnCaminoCorrectoEnUnGrafoLargo() {
		inicializarGrafo(8);
		inicializarOrigenDestino(0, 5);
		
		grafo.add_edge(0, 1, PESO_ARISTA);
		grafo.add_edge(1, 2, PESO_ARISTA);
		grafo.add_edge(2, 3, PESO_ARISTA);
		grafo.add_edge(3, 4, PESO_ARISTA);
		grafo.add_edge(4, 5, PESO_ARISTA);
		grafo.add_edge(4, 6, PESO_ARISTA);
		grafo.add_edge(1, 7, PESO_ARISTA);
		grafo.add_edge(2, 7, PESO_ARISTA);
		
		encontrarCamino();
		
		Boolean caminoCorrecto = false;
		
		if (camino != null && camino.size() > 0) {
			int i = 0;
			for(Arista arista : camino) {
				caminoCorrecto = arista.getSrc() == i && arista.getDst() == i+1;
				i++;
				if (!caminoCorrecto) break;
			}
		}
		Assert.assertTrue(caminoCorrecto);
	}
	
	@Test
	public void testBFSDeberiaEncontrarUnCaminoCorrectoEnUnGrafoConDistintosCaminosPosibles() {
		inicializarGrafo(4);
		inicializarOrigenDestino(0, 3);
		
		grafo.add_edge(0, 1, PESO_ARISTA);
		grafo.add_edge(1, 2, PESO_ARISTA);
		grafo.add_edge(2, 3, PESO_ARISTA);
		grafo.add_edge(1, 3, PESO_ARISTA);
		
		encontrarCamino();
		Boolean caminoCorrecto = false;
		
		if (camino != null && camino.size() > 0) {
			
			if (camino.size() == 2) {
				Arista a1 = camino.get(0);
				Arista a2 = camino.get(1);
				caminoCorrecto = a1.getSrc() == 0 && a1.getDst() == 1 && a2.getSrc() == 1 && a2.getDst() == 3;
			} else if (camino.size() == 3) {
				Arista a1 = camino.get(0);
				Arista a2 = camino.get(1);
				Arista a3 = camino.get(2);
				caminoCorrecto = a1.getSrc() == 0 && a1.getDst() == 1 && a2.getSrc() == 1 && a2.getDst() == 2 && a3.getSrc() == 2 && a3.getDst() == 3;
			} else {
				caminoCorrecto = false;
			}
		}
		
		Assert.assertTrue(caminoCorrecto);
		
	}
	
}
