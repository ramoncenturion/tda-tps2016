package tp3.aproximacion.viajante;

import tp3.aproximacion.viajante.Graph;

public class Viajante {

	private Prim arbolMinimo = null;
	
	
	public Viajante (Graph grafo, int raiz) {
		
		arbolMinimo = new Prim(grafo, raiz);
	}
}
