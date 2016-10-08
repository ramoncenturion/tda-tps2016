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
	
	private int obtenerElementoOrdenK(int ordenK, List<Integer> conjuntoElementos) {
		int primero = 0;
		for (int i = 0; i < ordenK+1; i++) {
			int minIndex = i;
			int minValue = conjuntoElementos.get(i);
			for (int j = i+1; j < conjuntoElementos.size(); j++) {
				if (conjuntoElementos.get(j) < minValue){
					minIndex = j;
					minValue =conjuntoElementos.get(minIndex);
				}
			}
			int aux = conjuntoElementos.get(i);
			conjuntoElementos.set(i,conjuntoElementos.get(minIndex));
			conjuntoElementos.set(minIndex,aux);
		}
		return conjuntoElementos.get(ordenK);
	}

}
