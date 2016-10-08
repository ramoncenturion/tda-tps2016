package caminos;

import java.util.ArrayList;
import java.util.List;

public abstract class Caminos {
	
	private int src;
	protected Digraph grafo;
	protected Arista edge[];
	
	protected Caminos(Digraph g, int origin) {
		src = origin;
		grafo = g;
	}
	
	public abstract double distancia(int v);
	
	protected abstract Arista edge_to(int v);
	
	public boolean visitado(int v) {
		return distancia(v) < Double.POSITIVE_INFINITY;
	}
	
	public List<Arista> camino(int v) {
		
		List<Arista> camino = new ArrayList<Arista>();
		
		for (int i = src; i < edge.length; i++) {
			Arista arista = edge[i];
			if (arista != null) {
				camino.add(arista);
				if (arista.getDst() == v) {
					break;
				}
			}
		}
		
		return camino;
	}

}