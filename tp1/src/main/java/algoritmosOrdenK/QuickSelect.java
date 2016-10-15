package algoritmosOrdenK;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 *  Se usa una estrategia de división y conquista similar a la de quicksort 
 *  pero descartando las divisiones que sabemos que no incluyen al k buscado.
 *
 */

public class QuickSelect extends EstadisticoK {

	public QuickSelect(List<Integer> conjuntoElementos, int ordenK) {
		this.conjuntoElementos = new ArrayList<Integer>(conjuntoElementos);
		long timeStart = System.nanoTime();
		this.elementK = obtenerElementoOrdenK(ordenK);
		long timeEnd = System.nanoTime();
		this.processTime = timeEnd - timeStart;
	}

	private int obtenerElementoOrdenK(int ordenK) {
		int left = 0;
		int right = this.conjuntoElementos.size()-1;
		if(left == right) {
  			return this.conjuntoElementos.get(left);
  		}
  		
		boolean findK = false;
  		while(!findK) {
  			int pivotIndex = generatePivot(left, right);
  			pivotIndex = partition(left, right, pivotIndex);
  			
  			if(ordenK == pivotIndex) {
  				findK = true;
  			} else if(ordenK < pivotIndex) {
  				right = pivotIndex - 1;
  			} else {
  				left = pivotIndex + 1;
  			}
  		}
  		
  		return this.conjuntoElementos.get(ordenK);
	}

	private int partition(int left, int right, int pivotIndex) {
		int pivotValue = this.conjuntoElementos.get(pivotIndex);
		swap(pivotIndex, right); // move pivot to end
		int storeIndex = left;
		for(int i = left; i < right; i++) {
			if(this.conjuntoElementos.get(i) < pivotValue) {
				swap(storeIndex, i);
				storeIndex++;
			}
		}
		swap(right, storeIndex); // Move pivot to its final place
		return storeIndex;
	}

	private int generatePivot(int left, int right) {
		//return left + (int) Math.floor(Math.random() * (right - left + 1));
		return left + (right-left)/2;
	}
	
}
