package caminos;

import java.util.LinkedList;
import java.util.Queue;

public class BFS extends Caminos {
	
	private double dist[];
	
	public BFS(Digraph grafo, int origin, int destino) {
	    super(grafo, origin);
	    
	    dist = new double[grafo.v()];
	    edge = new Arista[(grafo.v() * grafo.v())];
	    
	    for (int i = 0; i < grafo.v(); i++) {
	    	dist[i] = Double.POSITIVE_INFINITY;
	    }
	    Queue<Integer> vecinos = new LinkedList<Integer>();
	    dist[origin] = 0;
	    vecinos.add(origin);

        while (!vecinos.isEmpty()) {
            int v = vecinos.remove();

            for (int w : grafo.adj(v)) {
                if (!visitado(w)) {
                	
                	edge[w] = new Arista(v, w, 0);
                	dist[w] = dist[v] + 1;
                	vecinos.add(w);
                }
            }
        }
	}
	
	public double distancia(int v) { 
		return dist[v];
	}

	protected Arista edge_to(int v) { 
		return edge[v]; 
	}
}
