package caminos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Caminos {
	
	private int src;
	protected Digraph grafo;
	protected Arista edge[];
	private double pesoMinimo;
	
	protected Caminos(Digraph g, int origin) {
		src = origin;
		grafo = g;
		pesoMinimo = -1;
	}
	
	public abstract double distancia(int v);
	
	protected abstract Arista edge_to(int v);
	
	private Arista getAristaByDestino(int v) {
		Arista arista = null;
		
		if (edge.length > 0) {
			
			for (int i = 0; i < edge.length; i++) {
				if (edge[i] != null && edge[i].getDst() == v) {
					arista = edge[i];
					break;
				}
			}
		}
		
		return arista;
	}
	
	public boolean visitado(int v) {
		return distancia(v) < Double.POSITIVE_INFINITY;
	}
	
	public List<Arista> camino(int v) {
		
		List<Arista> camino = new ArrayList<Arista>();
		Boolean caminoEncontrado = false;
		int ultimoSrc = v;
		pesoMinimo = 0;
		
		while (!caminoEncontrado ) {
			Arista arista = getAristaByDestino(ultimoSrc);
	
			if (arista != null) {
				camino.add(arista);
				pesoMinimo += arista.getWeight();
				ultimoSrc = arista.getSrc();
				caminoEncontrado = ultimoSrc == this.src;
			} else {
				break;
			}
		}
		
		Collections.reverse(camino);
		return camino;
	}
	
	public double getPesoMinimo() {
		return pesoMinimo;
	}
	
	
// Cuando el algoritmo de camino verifiquemos que ande 100%, borramos estas dos alternativas. Por ahora anda bien
//	
//	public List<Arista> camino(int v) {
//		
//		List<Arista> camino = new ArrayList<Arista>();
//		int ultimoSrc = -1;
//		
//		for (int i = edge.length - 1; i > 0; i--) {
//			Arista arista = edge[i];
//			
//			if (arista != null) {
//				
//				if (arista.getDst() == v || ultimoSrc == arista.getDst()) {
//					
//					camino.add(arista);
//					ultimoSrc = arista.getSrc();
//					if (arista.getSrc() == src) {
//						break;
//					}
//				}
//			}
//		}
//		
//		Collections.reverse(camino);
//		return camino;
//	}
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