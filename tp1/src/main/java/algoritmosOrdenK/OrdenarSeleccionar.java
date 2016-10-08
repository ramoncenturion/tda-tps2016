package algoritmosOrdenK;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 * Ordenar y seleccionar: 
 * ordena el conjunto mediante un algoritmo veloz de comparación 
 * y luego seleccionar el k elemento del arreglo ordenado.
 * 
 * @author 
 *
 */
public class OrdenarSeleccionar {

	public OrdenarSeleccionar(List<Integer> conjuntoElementos) {
		List<Integer> conjuntoElementosParaMin = new ArrayList<Integer>(conjuntoElementos);
		List<Integer> conjuntoElementosParaMax = new ArrayList<Integer>(conjuntoElementos);
		List<Integer> conjuntoElementosParaMed = new ArrayList<Integer>(conjuntoElementos);
		
		int minimo = 0;
		int maximo = conjuntoElementos.size()-1;
		int mediana = conjuntoElementos.size()/2;
		
		int minimoK = obtenerElementoOrdenK(minimo, conjuntoElementosParaMin);
		int medianaK = obtenerElementoOrdenK(mediana, conjuntoElementosParaMed);
		int maximoK = obtenerElementoOrdenK(maximo, conjuntoElementosParaMax);
		
		System.out.println("Candidato:"+minimoK);
		System.out.println("Candidato:"+medianaK);
		System.out.println("Candidato:"+maximoK);
	}


	private int obtenerElementoOrdenK(int ordenK, List<Integer> conjuntoElementos) {
		this.ordenar(conjuntoElementos);
		return conjuntoElementos.get(ordenK);
	}


	private void ordenar(List<Integer> conjuntoElementos) {
		Comparator<Integer> c = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if (o1<o2) return -1;
				if (o1>o2) return 1;
				return 0;
			}
		};
		conjuntoElementos.sort(c);
	}

}
