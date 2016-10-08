package algoritmosOrdenK;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * k-selecciones: 
 * el algoritmo de ordenamiento por selección busca el menor elemento de una secuencia 
 * y lo intercambia con el primero. 
 * Se propone realizar k selecciones para encontrar el k elemento más pequeño.
 * @author 
 *
 */
public class KSelecciones extends EstadisticoK {

	public KSelecciones(List<Integer> conjuntoElementos, int ordenK) {
		this.conjuntoElementos = new ArrayList<Integer>(conjuntoElementos);
		long timeStart = System.nanoTime();
		this.elementK = obtenerElementoOrdenK(ordenK);
		long timeEnd = System.nanoTime();
		this.processTime = timeEnd - timeStart;
	}
	
	private int obtenerElementoOrdenK(int ordenK) {
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
