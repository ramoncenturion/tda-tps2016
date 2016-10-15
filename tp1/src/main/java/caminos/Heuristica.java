package caminos;

import java.util.Comparator;

public abstract class Heuristica implements Comparator<Integer> {
	
	public abstract int compare(Integer a, Integer b);
	
	public abstract double distancia(int v);
}
