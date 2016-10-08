package caminos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Dijkstra extends Caminos {
	public double dist[];
	//private Set<Integer> visitados;
	//private PriorityQueue<Nodo> pq;
	//private double matrizDeAdyacencia[][];
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
							vertice_min = w;
						}
					}
				}
			}
			nodos.add(vertice_min);
		}
		
	}
/*	
	protected Dijkstra(Digraph grafo, int origin, int destino) {
		super(grafo, origin);
		dist = new double[grafo.v()];
		visitados = new HashSet<Integer>();
		matrizDeAdyacencia = grafo.getMatrizDeAdyacencia();
		
		
		for (int i = 0; i < grafo.v(); i++) {
			for (int j = 0; j < grafo.v(); j++) {
				if (i!=j && matrizDeAdyacencia[i][j] == 0) {
					matrizDeAdyacencia[i][j] = Double.POSITIVE_INFINITY;
				}
			}
		}
		
		// Inicializo las distancias en infinito
		for (int i = 0; i < grafo.v(); i++) {
	    	dist[i] = Double.POSITIVE_INFINITY;
	    }
		
		pq = new PriorityQueue<Nodo>(grafo.v(), new Nodo());
		pq.add(new Nodo(origin, 0));
		dist[origin] = 0;
		
		while (!pq.isEmpty()) {
			int vertice_actual = pq.remove().nodo;
			visitados.add(vertice_actual);
			evaluarVecinos(vertice_actual);
		}
		
	}
	
	private void evaluarVecinos(int vertice_actual) {
        double edgeDistance = -1;
        double newDistance = -1;
 
        for (int destinationNode = 0; destinationNode < grafo.v(); destinationNode++) {
            if (!visitados.contains(destinationNode)) {
                if (matrizDeAdyacencia[vertice_actual][destinationNode] != Double.POSITIVE_INFINITY) {
                    edgeDistance = matrizDeAdyacencia[vertice_actual][destinationNode];
                    newDistance = dist[vertice_actual] + edgeDistance;
                    if (newDistance < dist[destinationNode]) {
                        dist[destinationNode] = newDistance;
                    }
                    pq.add(new Nodo(destinationNode,dist[destinationNode]));
                }   
            }
        }
	}
	*/
	
	public List<Arista> camino(int v) {
		List<Arista> camino = new ArrayList<Arista>();
		for (int i=1 ; i<nodos.size() ; i++) {
			camino.add(this.grafo.getArista(nodos.get(i-1), nodos.get(i)));
			if (nodos.get(i) == v) break;
		}
		return camino;
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