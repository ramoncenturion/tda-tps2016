package tp2.redes.flujo;

import java.util.ArrayList;
import java.util.List;

public class Red {
	
	private final int n; // Cantidad de vertices
	private int m;		// Cantidad de aristas
	private List<List<Integer>> adj;
	private List<Arista> aristas;
	
	public Red(int v) {
		this.n = v;
		this.m = 0;
		this.adj = new ArrayList<List<Integer>>();
		this.aristas = new ArrayList<Arista>();
		
		for (int i = 0; i < v; i++) {
			adj.add(new ArrayList<Integer>());
		}
	}
	
	/**
	 * 
	 * @return cantidad de vertices
	 */
	public int n() {
		return n;
	}
	/**
	 * 
	 * @return cantidad de aristas
	 */
	public int m() {
		return m;
	}
	
	/**
	 *
	 * @param v
	 * @return aristas adjacentes a un nodo
	 */
	public List<Arista> adj_e(int v) {
		
		List<Arista> aristasAdy = new ArrayList<Arista>();
		
		for (Arista arista : aristas) {
			if (arista.getSrc() == v) {
				aristasAdy.add(arista);
			}
		}
		
		return aristasAdy;
	}
	
	/**
	 *  Devuelve la arista que une el vertice1 y el vertice2
	 *  Null si no existe.
	 * @param vertice1
	 * @param vertice2
	 * @return
	 */
	public Arista getArista(int vertice1, int vertice2) {
		for (Arista arista : this.adj_e(vertice1)) {
			if (arista.getSrc() == vertice1 && arista.getDst() == vertice2) {
				return arista;
			}
		}
		return null;
	}
	
	public void add_edge(int u, int v, int weight) {
		Arista arista = new Arista(u, v, weight);
		
		this.adj.get(u).add(v);
		this.aristas.add(arista);
		this.m++;
		
	}
	
	public List<Arista> adj_fuente() {
		return this.adj_e(0);
	}
	
	public List<Arista> adj_sumidero() {
		return this.adj_e(this.n-1);
	}
	
}
