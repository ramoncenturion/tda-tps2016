package caminos;

import java.util.Collection;
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
	    
	    
	    Queue<Integer> vecinos = new PriorityQueue<Integer>(11, new HeuristicaComparator());
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
	
	private double heuristica(int v) {
		double arg = Math.pow(v, 2) + Math.pow(destino, 2);
		return Math.sqrt(arg);
	}
	
	 public class HeuristicaComparator implements Comparator<Integer> {
		 @Override
        public int compare(Integer v, Integer w) {
        	if (heuristica(v) < heuristica(w)) {
        		return -1;
        	} else if (heuristica(v) > heuristica(w)) {
        		return 1;
        	}
            return 0;
        }
    } 
	
}
