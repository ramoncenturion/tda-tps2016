package tp2.redes.flujo;

import java.util.ArrayList;
import java.util.List;

public class Digraph {
	
	private final int v; // Cantidad de vertices
	private int e;		// Cantidad de aristas
	private List<List<Integer>> adj;
	private List<Arista> aristas;
	
	public Digraph(int v) {
		this.v = v;
		this.e = 0;
		this.adj = new ArrayList<List<Integer>>();
		this.aristas = new ArrayList<Arista>();
		
		for (int i = 0; i < v; i++) {
			adj.add(new ArrayList<Integer>());
		}
	}
	
	public int v() {
		return v;
	}
	
	public int e() {
		return e;
	}
	
	// Devuelve las aristas adjacentes a un nodo
	public List<Arista> adj_e(int v) {
		
		List<Arista> aristasAdy = new ArrayList<Arista>();
		
		for (Arista arista : aristas) {
			if (arista.getSrc() == v) {
				aristasAdy.add(arista);
			}
		}
		
		return aristasAdy;
	}
	
	// Devuelve la arista que une el vertice1 y el vertice2
	// Null si no existe.
	public Arista getArista(int vertice1, int vertice2) {
		for (Arista arista : this.adj_e(vertice1)) {
			if (arista.getSrc() == vertice1 && arista.getDst() == vertice2) {
				return arista;
			}
		}
		return null;
	}
	
	public List<Integer> adj(int v) {
		return adj.get(v);
	}
	
	public void add_edge(int u, int v, double weight) {
		Arista arista = new Arista(u, v, weight);
		
		this.adj.get(u).add(v);
		this.aristas.add(arista);
		this.e++;
		
	}
	
	public List<List<Integer>> iter() {
		return adj;
	}
	
	public List<Arista> iter_edges() {
		return aristas;
	}
	
}
