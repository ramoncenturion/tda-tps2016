package caminos;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class HeuristicaEuclidiana extends Heuristica implements Comparator<Integer> {
	
	private int destino;
	private Map<Integer, Posicion> vertices2D;
	
	public HeuristicaEuclidiana(Digraph grafo, int origen, int destino) {
		this.destino = destino;
		this.vertices2D = new HashMap<Integer, Posicion>();
		
		int x = 0;
		int y = 0;
		int columnas = (int) Math.ceil(Math.sqrt(grafo.v()));
		
		for (int i = 0; i < grafo.v(); i++) {
			
			Posicion posicion = new Posicion(x,y);
			vertices2D.put(i, posicion);
			y++;
			if (y >= columnas) {
				x++;
				y = 0;
			}
		}
	}
	
	public double distancia(int v) {
		Posicion inicio = vertices2D.get(v);
		Posicion fin = vertices2D.get(destino);
		return inicio.distancia(fin);
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
