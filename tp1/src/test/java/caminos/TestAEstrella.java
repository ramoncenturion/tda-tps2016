package caminos;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class TestAEstrella {

	private Digraph grafo;
	private int origen;
	private int destino;
	private AEstrella aEstrella;
	private List<Arista> camino;
	
	private void inicializarGrafo(int cantidadVertices) {
		grafo = new Digraph(cantidadVertices);
	}
	
	private void inicializarOrigenDestino(int i, int j) {
		origen = i;
		destino = j;
	}
	
	private void encontrarCamino() {
		aEstrella = new AEstrella(grafo, origen, destino);
		camino = aEstrella.camino(destino);
	}
	
	@Test
	public void testAEstrellaDeberiaEncontrarUnCamino() {
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
	
	@Test
	public void testAEstrellaSinCaminoPosibleNoDeberiaEncontrarUnCamino() {
		inicializarGrafo(4);
		inicializarOrigenDestino(0, 3);
		
		grafo.add_edge(0, 1, 2);
		
		encontrarCamino();
		
		Assert.assertTrue(camino.size() == 0);
	}
	
	@Test
	public void testScoreDeberiaDarDosVecesHipotenusa() {
		inicializarGrafo(4);
		inicializarOrigenDestino(0, 3);
		
		grafo.add_edge(0, 1, 2);
		grafo.add_edge(1, 3, 3);
		
		encontrarCamino();
		
		Heuristica heuristica = aEstrella.getHeuristica();
		
		double distanciaHeuristica = heuristica.distancia(0);
		
		Assert.assertTrue(distanciaHeuristica == 2 + Math.sqrt(2));
	}
}
