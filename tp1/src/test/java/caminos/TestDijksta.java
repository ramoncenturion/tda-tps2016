package caminos;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class TestDijksta {
	private Digraph grafo;
	private int origen;
	private int destino;
	private Dijkstra dijkstra;
	private List<Arista> camino;
	
	private void inicializarGrafo(int cantidadVertices) {
		grafo = new Digraph(cantidadVertices);
	}
	
	private void inicializarOrigenDestino(int i, int j) {
		origen = i;
		destino = j;
	}
	
	private void encontrarCamino() {
		dijkstra = new Dijkstra(grafo, origen, destino);
		camino = dijkstra.camino(destino);
	}
	
	@Test
	public void testDijkstraDeberiaEncontrarUnCamino() {
		
		inicializarGrafo(4);
		inicializarOrigenDestino(0, 3);
		
		grafo.add_edge(0, 1, 2);
		grafo.add_edge(1, 2, 1);
		grafo.add_edge(2, 3, 3);
		grafo.add_edge(1, 3, 5);
		
		encontrarCamino();
		
		Assert.assertTrue(camino != null && camino.size() > 0);
	}
	
	/**
	 * 2 posibles caminos:
	 * el minimo tiene longitud 6.
	 * el otro tiene longitud 7.
	 */
	@Test
	public void testDijkstraDeberiaEncontrarUnCaminoMinimo() {

		double caminoMinimo = 6;
		inicializarGrafo(4);
		inicializarOrigenDestino(0, 3);
		
		grafo.add_edge(0, 1, 2);
		grafo.add_edge(1, 2, 1);
		grafo.add_edge(2, 3, 3);
		grafo.add_edge(1, 3, 5);
		
		encontrarCamino();
		
		double sumaDePesos = 0;
		for (Arista arista : camino) {
			sumaDePesos += arista.getWeight();
		}
		
		Assert.assertTrue(sumaDePesos == caminoMinimo);
	}
	
	/**
	 * Se prueba Dijkstra en el grafo de wikipedia:
	 * https://es.wikipedia.org/wiki/Algoritmo_de_Dijkstra
	 * Camino Minimo: 20
	 */
	@Test
	public void testDijkstraDeberiaEncontrarUnCaminoMinimoEnUnGrafoComplicado() {
		
		double caminoMinimo = 20;
		inicializarGrafo(6);
		inicializarOrigenDestino(0, 4);
		
		grafo.add_edge(0, 1, 7);
		grafo.add_edge(0, 2, 9);
		grafo.add_edge(0, 5, 14);
		grafo.add_edge(1, 2, 10);
		grafo.add_edge(1, 3, 15);
		grafo.add_edge(2, 5, 2);
		grafo.add_edge(2, 3, 11);
		grafo.add_edge(5, 4, 9);
		grafo.add_edge(3, 4, 6);
		
		encontrarCamino();
		
		double sumaDePesos = 0;
		for (Arista arista : camino) {
			sumaDePesos += arista.getWeight();
		}
		
		Assert.assertTrue(sumaDePesos == caminoMinimo);
	}
}
