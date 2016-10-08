package caminos;

import java.util.ArrayList;
import java.util.Collections;
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
		int ultimoSrc = -1;
		
		for (int i = edge.length - 1; i > 0; i--) {
			Arista arista = edge[i];
			
			if (arista != null) {

				if (arista.getDst() == v || ultimoSrc == arista.getDst()) {

					camino.add(arista);
					ultimoSrc = arista.getSrc();
					if (arista.getSrc() == src) {
						break;
					}
				}
			}
		}
		
		Collections.reverse(camino);
		return camino;
	}
//	
//	public List<Arista> camino(int v) {
//		
//		List<Arista> camino = new ArrayList<Arista>();
//		
//		for (int i = src; i < edge.length; i++) {
//			Arista arista = edge[i];
//			if (arista != null) {
//				camino.add(arista);
//				if (arista.getDst() == v) {
//					break;
//				}
//			}
//		}
//		
//		return camino;
//	}

}