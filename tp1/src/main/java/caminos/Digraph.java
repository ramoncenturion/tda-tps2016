package caminos;

import java.util.ArrayList;
import java.util.List;

public abstract class Digraph {
	
	public Digraph(Graph g, int v) {
		g = new Graph(v);
	}
	
	public int v(Graph g) {
		return g.getV();
	}
	
	public int e(Graph g) {
		return g.getE();
	}
	
	public List<Arista> adj_e(Graph g, int v) {
		
		List<Arista> aristasAdy = new ArrayList<Arista>();
		List<Arista> aristas = g.getAristas();
		
		for (Arista arista : aristas) {
			if (arista.getSrc() == v) {
				aristasAdy.add(arista);
			}
		}
		
		return aristasAdy;
	}
	
	public List<Integer> adj(Graph g, int v) {
		return g.getAdj().get(v);
	}
	
	public void add_edge(Graph g, int u, int v, double weight) {
		Arista arista = new Arista(u, v, weight);
		g.addEdge(arista);
	}
	
	public void iter(Graph g) {
//	  def __iter__(g):
//	    """Itera de 0 a V."""
//	    return iter(range(g.V()))
		return;
	}
	
	public List<Arista> iter_edges(Graph g) {
		return g.getAristas();
	}
	
}
