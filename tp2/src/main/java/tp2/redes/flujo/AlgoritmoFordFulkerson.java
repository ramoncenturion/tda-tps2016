package tp2.redes.flujo;

import java.util.LinkedList;

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
       
        // Almacenamos en el array las rutas que encuentra el BFS
        int paths[] = new int[V];
 
        int s = 0;
        int t = V-1;
        //Aumentamos el flujo de la red mientras hay ruta de la fuente al sumidero
        while (bfs(this.red, s, t, paths)){
            //Buscamos el flujo maximo que se puede enviar a traves de la ruta encontrada por BFS
        	int path_flow = Integer.MAX_VALUE;
            for (v = t; v != s; v = paths[v]){
                u = paths[v];
                Arista arista = this.red.getArista(u,v);
                path_flow = Math.min(path_flow, arista.getCapacidad() - arista.getFlujo());
            }
	    	
            // Actualizo el flujo en la red
            for (v = t; v != s; v = paths[v]){
                u = paths[v];
                int flujo = this.red.getArista(u, v).getFlujo() + path_flow;
                this.red.getArista(u, v).setFlujo(flujo);
            }
 
            // Actualizo el flujo maximo
            this.flujoMaximo += path_flow;
        }
    }

	boolean bfs(Red redFlujo, int s, int t, int paths[]) {
		// Creo un array para almacenar los las aristas que llegan al vertice destino (index del array)
		Arista visited[] = new Arista[redFlujo.n()];
	
		// Creo la cola, encolo el vertice fuente
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(s);
		paths[s] = -1;

		while (queue.size() != 0) {
			int u = queue.poll();

			for (Arista arista : redFlujo.adj_e(u)){
				int v = arista.getDst();
				if (visited[v] == null && arista.getCapacidad() > arista.getFlujo()){
					queue.add(v);
					paths[v] = u;
					visited[v] = arista;
				}
			}
		}

		// Si encontre un camino de s a t, entonces debo tener una arista que llegue a t
		return (visited[t] != null);
	}

	public int getFlujoMaximo() {
		return flujoMaximo;
	}
}