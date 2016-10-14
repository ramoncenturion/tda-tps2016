package tp1;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class GeneradorConjuntoRandom {
	private static int cantidadDeElementos;
	private static Random random;
	
	public GeneradorConjuntoRandom(int cantElem) {
		cantidadDeElementos = cantElem;
		random = new Random();
	}
	
	public List<Integer> generate() {
		List<Integer> conjuntoRandom = new ArrayList<Integer>();
		
		while(conjuntoRandom.size() < cantidadDeElementos) {
			int r = random.nextInt(cantidadDeElementos);
			r++;
			if (!conjuntoRandom.contains(r)) conjuntoRandom.add(r);
		}
		
		return conjuntoRandom;
	}
	
//	public static void main(String[] args) {
//		GeneradorConjuntoRandom cr = new GeneradorConjuntoRandom(50);
//		List<Integer> conjunto = cr.generate();
//		System.out.println(conjunto.size());
//		Iterator it = conjunto.iterator();
//		while (it.hasNext()) {
//			System.out.println(it.next());
//		}
//	}
}
