package caminos;

import java.util.PriorityQueue;
import java.util.Queue;

public class BFSHeuristica extends Caminos {
	
	private double dist[];
	private HeuristicaEuclidiana heuristica;
	
	public BFSHeuristica(Digraph grafo, int origin, int destino) {
	    super(grafo, origin);
	    
	    dist = new double[grafo.v()];
	    edge = new Arista[(grafo.v() * grafo.v())];
	    
	    for (int i = 0; i < grafo.v(); i++) {
	    	dist[i] = Double.POSITIVE_INFINITY;
	    }
	    
	    heuristica = new HeuristicaEuclidiana(grafo, destino);
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

	public Heuristica getHeuristica() {
		return heuristica;
	}
	
}
