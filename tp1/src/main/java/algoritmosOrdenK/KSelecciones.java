package algoritmosOrdenK;

import java.util.ArrayList;
import java.util.List;

/**
 * k-selecciones: 
 * el algoritmo de ordenamiento por selección busca el menor elemento de una secuencia 
 * y lo intercambia con el primero. 
 * Se propone realizar k selecciones para encontrar el k elemento más pequeño.
 * @author 
 *
 */
public class KSelecciones {

	public KSelecciones(List<Integer> conjuntoElementos) {
		List<Integer> conjuntoElementosParaMin = new ArrayList<Integer>(conjuntoElementos);
		List<Integer> conjuntoElementosParaMax = new ArrayList<Integer>(conjuntoElementos);
		List<Integer> conjuntoElementosParaMed = new ArrayList<Integer>(conjuntoElementos);
		
		int minimo = 0;
		int maximo = conjuntoElementos.size()-1;
		int mediana = conjuntoElementos.size()/2;
		
		int minimoK = obtenerElementoOrdenK(minimo, conjuntoElementosParaMin);
		int medianaK = obtenerElementoOrdenK(mediana, conjuntoElementosParaMed);
		int maximoK = obtenerElementoOrdenK(maximo, conjuntoElementosParaMax);
		
		System.out.println("Minimo: "+minimoK);
		System.out.println("Mediana: "+medianaK);
		System.out.println("Maximo: "+maximoK);
	}

	/**
	 *  function select(list[1..n], k)
     for i from 1 to k
         minIndex = i
         minValue = list[i]
         for j from i+1 to n
             if list[j] < minValue
                 minIndex = j
                 minValue = list[j]
         swap list[i] and list[minIndex]
     return list[k]
     
	 * @param ordenK
	 * @param conjuntoElementos
	 * @return
	 */
	
	private int obtenerElementoOrdenK(int ordenK, List<Integer> conjuntoElementos) {
		int primero = 0;
		int k;
		for (k = 0; k < ordenK+1; k++) {
			int posicionMinimo = 1;
			for (int i = 1; i < conjuntoElementos.size(); i++) {
				if (conjuntoElementos.get(i) < conjuntoElementos.get(posicionMinimo)){
					posicionMinimo = i;
				}
			}
			int aux = conjuntoElementos.get(posicionMinimo);
			conjuntoElementos.set(posicionMinimo,conjuntoElementos.get(primero));
			conjuntoElementos.set(primero,aux);
		}
		return conjuntoElementos.get(primero);
	}

}
