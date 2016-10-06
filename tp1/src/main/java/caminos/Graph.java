package main.java.caminos;

import java.util.ArrayList;
import java.util.List;

public class Graph {
	
	private final int v;
	private int e;
	private List<List<Integer>> adj;
	
	public Graph(int v) {
		this.v = v;
		this.e = 0;
		this.adj = new ArrayList<List<Integer>>();
				
		for (int i = 0; i < v; i++) {
			adj.add(new ArrayList<Integer>());
		}
	}
	
	public void addEdge(Arista arista) {
		int v = arista.getSrc();
		int w = arista.getDst();
		
		this.adj.get(v).add(w);
		this.adj.get(w).add(v);
		this.e++;
	}

	public int getV() {
		return v;
	}

	public int getE() {
		return e;
	}

	public List<List<Integer>> getAdj() {
		return adj;
	}
	
	
}
