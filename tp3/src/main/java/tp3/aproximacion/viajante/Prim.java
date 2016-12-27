package tp3.aproximacion.viajante;

import tp3.aproximacion.viajante.Graph;
import tp3.aproximacion.viajante.Arista;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Prim {
	
	private int peso = 0;
	private List<Arista> recorrido = null;
	
    public Prim(Graph grafo, int vertice_inicial) {

        int peso = 0;

        final Set<Integer> unvisited = grafo.getVertices();
        unvisited.remove(vertice_inicial); // O(1)

        final List<Arista> recorrido = new ArrayList<Arista>();
        final Queue<Arista> aristasDisponibles = new PriorityQueue<Arista>();

        int vertice = vertice_inicial;
        while (!unvisited.isEmpty()) {
            // Agrego todas las arisitas a vertices no visitados
            for (Arista e : grafo.getAdyacentes(vertice)) {
                if (unvisited.contains(e.getDst())) {
                    aristasDisponibles.add(e);
                }
            }

            // Quito la arista de menor peso
            final Arista e = aristasDisponibles.remove();
            peso += e.getWeight();
            recorrido.add(e); // O(1)

            vertice = e.getDst();
            unvisited.remove(vertice); // O(1)
        }

        this.peso = peso;
        this.recorrido = recorrido;
    }

    public int getPeso() {
    	return peso;
    }

    public List<Arista> getCamino() {
    	return recorrido;
    }

}
