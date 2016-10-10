package caminos;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class BFSHeuristica extends Caminos {
	
private double dist[];

	private int destino;
	
	public BFSHeuristica(Digraph grafo, int origin, int destino) {
	    super(grafo, origin);
	    this.destino = destino;
	    
	    dist = new double[grafo.v()];
	    edge = new Arista[(grafo.v() * grafo.v())];
	    
	    for (int i = 0; i < grafo.v(); i++) {
	    	dist[i] = Double.POSITIVE_INFINITY;
	    }
	    
	    HeuristicaEuclidiana heuristica = new HeuristicaEuclidiana(grafo, origin, destino);
	    Queue<Integer> vecinos = new PriorityQueue<Integer>(grafo.v(), heuristica);
	    dist[origin] = 0;
	    vecinos.add(origin);

        while (!vecinos.isEmpty()) {
            int v = vecinos.poll();

            for (int w : grafo.adj(v)) {
                if (!visitado(w)) {
                	
                	edge[w] = grafo.getArista(v, w);
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
