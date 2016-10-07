package caminos;

import java.util.LinkedList;
import java.util.Queue;

public class BFS extends Caminos {
	
	private double dist[];  // Inicializar a +inf.
	private Arista edge[];
	
	public BFS(Digraph g, int origin, int destino) {
	    super(g, origin);
	    // código del algoritmo, rellena "dist" y "edge".

	    //TODO: esto esta bien?
	    Graph grafo = new Graph(destino);
	    
	    for (int i = origin; i < destino; i++) {
	    	dist[i] = Double.POSITIVE_INFINITY;
	    	Arista a = new Arista(i, i+1, 0);
	    	edge[i] = a;
	    	grafo.addEdge(a);
	    }
	    Queue<Integer> q = new LinkedList<Integer>();
	    dist[origin] = 0;
	    q.add(origin);

        while (!q.isEmpty()) {
            int v = q.remove();
            
            for (int w : g.adj(grafo, v)) {
                if (!visitado(w)) {
                	//TODO: Esto esta bien?
                	edge[w] = edge[v];
                	dist[w] = dist[v] + 1;
                	q.add(w);
                }
            }
        }
	}
	
	public double distancia(int v) { 
		return dist[v];
	}
	
	//TODO: para que devuelve una arista? que hace?
	protected Arista edge_to(int v) { 
		return edge[v]; 
	}

}

//                    edgeTo[w] = v;
//                    distTo[w] = distTo[v] + 1;
//                    marked[w] = true;
//                    q.enqueue(w);