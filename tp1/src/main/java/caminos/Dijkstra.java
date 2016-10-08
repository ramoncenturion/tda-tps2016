package caminos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Dijkstra extends Caminos {
	private double dist[];
	private List<Integer> nodos;

	protected Dijkstra(Digraph grafo, int origin, int destino) {
		super(grafo, origin);
		dist = new double[grafo.v()];
		
		// Inicializo las distancias en infinito
		for (int i = 0; i < grafo.v(); i++) {
	    	dist[i] = Double.POSITIVE_INFINITY;
	    }
		
		nodos = new ArrayList<Integer>();
		nodos.add(origin);
		dist[origin] = 0;
		
		while (nodos.size() < grafo.v()) {
			double min_dist = Double.POSITIVE_INFINITY;
			int vertice_min = -1;
			for (int u : nodos) {
				for (int w : grafo.adj(u)) {
					if (nodos.indexOf(w) == -1) {
						Arista arista = grafo.getArista(u, w);
						double weight = arista.getWeight();
						if (dist[w] > dist[u] + weight) {
							dist[w] = dist[u] + weight;
						}
						if (dist[w] < min_dist) {
							min_dist = dist[w];
						}
					}
				}
			}
			nodos.add(vertice_min);
		}
		
	}
	
	public List<Arista> camino(int v) {
		List<Arista> camino = new ArrayList<Arista>();
		for (int i=1 ; i<nodos.size() ; i++) {
			camino.add(this.grafo.getArista(nodos.get(i-1), nodos.get(i)));
			if (nodos.get(i) == v) break;
		}
		return camino;
	}

}