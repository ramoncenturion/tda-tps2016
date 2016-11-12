/**
 * 
 */
package tp2.redes.flujo;

import java.util.LinkedList;
import java.util.List;

/**
 * Algoritmo Ford Fulkerson
 *
 */
public class AlgoritmoFordFulkerson {

	private Red red;
	private int V = 0;
	private int flujoMaximo;

	public AlgoritmoFordFulkerson(Red red) {
		this.red = red;
		this.V = this.red.n();
		this.flujoMaximo = 0;
		resolver();
	}

	private void resolver() {
        int u, v;
       
        // This array is filled by BFS and to store path
        int parent[] = new int[V];
 
        // Augment the flow while there is path from source to sink
        int s = 0;
        int t = V-1;
        while (bfs(this.red, s, t, parent)){
            // Find minimum residual capacity of the edges along the path filled by BFS. 
        	// Or we can say find the maximum flow through the path found.
            int path_flow = Integer.MAX_VALUE;
            for (v=t; v!=s; v=parent[v]){
                u = parent[v];
                Arista arista = this.red.getArista(u,v);
                path_flow = Math.min(path_flow, arista.getCapacidad() - arista.getFlujo());
            }
	    	
            // update residual capacities of the edges and
            // reverse edges along the path
            for (v=t; v != s; v=parent[v]){
                u = parent[v];
                int flujo = this.red.getArista(u, v).getFlujo()+path_flow;
                this.red.getArista(u, v).setFlujo(flujo);
            }
 
            // Add path flow to overall flow
            this.flujoMaximo += path_flow;
        }
    }
	
	boolean bfs(Red redResidual, int s, int t, int parent[]) {
		// Create a visited array and mark all vertices as not visited
		int V = redResidual.n();
		boolean visited[] = new boolean[V];
		for (int i = 0; i < V; ++i)
			visited[i] = false;

		// Create a queue, enqueue source vertex and mark
		// source vertex as visited
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(s);
		visited[s] = true;
		parent[s] = -1;

		// Standard BFS Loop
		while (queue.size() != 0) {
			int u = queue.poll();

			for (Arista arista : redResidual.adj_e(u)){
				int v = arista.getDst();
				if (visited[v] == false && arista.getCapacidad() > arista.getFlujo()){
					queue.add(v);
					parent[v] = u;
					visited[v] = true;
				}
			}
		}

		// If we reached sink in BFS starting from source, then
		// return true, else false
		return (visited[t] == true);
	}

	public int getFlujoMaximo() {
		return flujoMaximo;
	}

}
