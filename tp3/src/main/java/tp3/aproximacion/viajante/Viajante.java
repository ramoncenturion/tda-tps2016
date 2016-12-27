package tp3.aproximacion.viajante;

import tp3.aproximacion.viajante.Graph;
import tp3.aproximacion.viajante.Arista;
import tp3.aproximacion.viajante.Prim;
import java.util.ArrayList;
import java.util.List;

public class Viajante {

	private Prim arbolTendidoMinimo = null;
	
	public Viajante (Graph grafo, int raiz) {
		arbolTendidoMinimo = new Prim(grafo, raiz);
	}

	public Integer getDistanciaMinima() {
		return arbolTendidoMinimo.getPeso();
	}
	
	// Lista de vertices
	public List<Integer> getCaminoMinimo() {
		List<Integer> recorrido = new ArrayList<Integer>();
		for (Arista e : arbolTendidoMinimo.getCamino()) {
			recorrido.add(e.getSrc());
		}
		return recorrido;
	}
}
