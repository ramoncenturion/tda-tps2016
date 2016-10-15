package caminos;

import java.util.ArrayList;
import java.util.List;

public class Dijkstra extends Caminos {
	public double dist[];
	private List<Integer> nodos;

	protected Dijkstra(Digraph grafo, int origin, int destino) {
		super(grafo, origin);
		dist = new double[grafo.v()];
		edge = new Arista[(grafo.v() * grafo.v())];
		
		// Inicializo las distancias en infinito
		for (int i = 0; i < grafo.v(); i++) {
	    	dist[i] = Double.POSITIVE_INFINITY;
	    }
		
		nodos = new ArrayList<Integer>();
		nodos.add(origin);
		dist[origin] = 0;
		Arista aristaMin = null;
		
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
							vertice_min = w;
							aristaMin = arista;
						}
					}
				}
			}
			nodos.add(vertice_min);
			edge[vertice_min] = aristaMin;
		}
		
	}
	
	@Override
	public double distancia(int v) {
		return dist[v];
	}

	@Override
	protected Arista edge_to(int v) {
		return edge[v]; 
	}

}