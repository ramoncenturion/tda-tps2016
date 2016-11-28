package tp3.aproximacion.viajante;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import caminos.Arista;

public class Prim {
	
	public Prim (Graph grafo, int raiz) {
		
		Map<Integer, Double> vertices = new HashMap<Integer, Double>();
		Map<Integer, Double> padres = new HashMap<Integer, Double>();
		Queue<Arista> colaPrioridad = new PriorityQueue<Arista>();
		
		for (Arista arista : grafo.getAristas()) {
			vertices.put(arista.getSrc(), Double.POSITIVE_INFINITY);
			padres.put(arista.getSrc(), null);
			colaPrioridad.add(arista);
		}
		
		vertices.put(raiz, 0D);
		
		while (!colaPrioridad.isEmpty()) {
			Arista arista = colaPrioridad.poll();
			Integer src = arista.getSrc();
			Integer dst = arista.getDst();
			
			for (Arista adyacente : grafo.getAdyacentes(src)) {
				
				Double peso = adyacente.getWeight();
				if (colaPrioridad.contains(adyacente) && peso < vertices.get(dst)) {
					padres.put(dst, src.doubleValue());
					vertices.put(dst, peso);
				}
			}
		}
		
		Boolean estaVacia = colaPrioridad.isEmpty();
	}

}
