package algoritmosOrdenK;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Ordenar y seleccionar: 
 * ordena el conjunto mediante un algoritmo veloz de comparación 
 * y luego seleccionar el k elemento del arreglo ordenado.
 * 
 * @author 
 *
 */
public class OrdenarSeleccionar extends EstadisticoK {

	public OrdenarSeleccionar(List<Integer> conjuntoElementos, int ordenK) {		
		this.conjuntoElementos = new ArrayList<Integer>(conjuntoElementos);
		long timeStart = System.nanoTime();
		this.elementK = obtenerElementoOrdenK(ordenK);
		long timeEnd = System.nanoTime();
		this.processTime = timeEnd - timeStart;
	}


	private int obtenerElementoOrdenK(int ordenK) {
		this.ordenar(this.conjuntoElementos);
		return this.conjuntoElementos.get(ordenK);
	}


	private void ordenar(List<Integer> conjuntoElementos) {
		Comparator<Integer> c = new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				if (o1<o2) return -1;
				if (o1>o2) return 1;
				return 0;
			}
		};
		conjuntoElementos.sort(c);
	}

}
