package caminos;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Score extends Heuristica implements Comparator<Integer> {
	
	private Map<Integer, Double> pesos;
	private HeuristicaEuclidiana heuristica;
	
	public Score(Digraph grafo, int destino) {
		
		pesos = new HashMap<Integer, Double>();
		
		for (Arista arista : grafo.iter_edges()) {
			int v = arista.getSrc();
			double peso = arista.getWeight();
			
			if (pesos.containsKey(v)) {
				if (peso < pesos.get(v)) {
					pesos.put(v, peso);
				}
			} else {
				pesos.put(v, peso);
			}
		}
		heuristica = new HeuristicaEuclidiana(grafo, destino);
	}

	public double distancia(int v) {
		double distanciaHeuristica = heuristica.distancia(v);
		double peso = pesos.containsKey(v) ? pesos.get(v) : 0;
		return (peso + distanciaHeuristica);
	}
	
	@Override
    public int compare(Integer v, Integer w) {
    	if (distancia(v) < distancia(w)) {
    		return -1;
    	} else if (distancia(v) > distancia(w)) {
    		return 1;
    	}
        return 0;
    }

}
