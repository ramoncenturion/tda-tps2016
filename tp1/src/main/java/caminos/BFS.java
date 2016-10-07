package main.java.caminos;

public class BFS extends Caminos {
	
	private double dist[];  // Inicializar a +inf.
	private Arista edge[];
	
	public BFS(Digraph g, int origin, int destino) {
	    super(g, origin);
	
	    // código del algoritmo, rellena "dist" y "edge".
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
