package caminos;

import java.util.Comparator;

public class HeuristicaEuclidiana extends Heuristica implements Comparator<Integer> {
	
	private Digraph grafo;
	private int origen;
	private int destino;
	
	public HeuristicaEuclidiana(Digraph grafo, int origen, int destino) {
		this.grafo = grafo;
		this.origen = origen;
		this.destino = destino;
	}
	
	private double distancia(int v) {
		double arg = Math.pow(v, 2) + Math.pow(destino, 2);
		return Math.sqrt(arg);
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
