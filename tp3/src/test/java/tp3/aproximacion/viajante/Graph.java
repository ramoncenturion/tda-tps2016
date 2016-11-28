package tp3.aproximacion.viajante;

import java.util.ArrayList;
import java.util.List;

import caminos.Arista;

public class Graph {
	
	private List<Arista> aristas;
	
	public Graph() {
		this.aristas = new ArrayList<Arista>();
	}
	
	// Devuelve las aristas adjacentes a un nodo
	public List<Arista> getAdyacentes(int vertice) {
		
		List<Arista> aristasAdy = new ArrayList<Arista>();
		
		for (Arista arista : aristas) {
			if (arista.getSrc() == vertice) {
				aristasAdy.add(arista);
			}
		}
		
		return aristasAdy;
	}
	
	// Devuelve la arista que une el vertice1 y el vertice2
	// Null si no existe.
	public Arista getArista(int vertice1, int vertice2) {
		for (Arista arista : this.getAdyacentes(vertice1)) {
			if (arista.getSrc() == vertice1 && arista.getDst() == vertice2) {
				return arista;
			}
		}
		return null;
	}
	
	public List<Arista> getAristas() {
		return this.aristas;
	}
	
	public void addArista(int u, int v, double weight) {
		Arista arista1 = new Arista(u, v, weight);
		Arista arista2 = new Arista(v, u, weight);
		this.aristas.add(arista1);
		this.aristas.add(arista2);
	}
	
}
