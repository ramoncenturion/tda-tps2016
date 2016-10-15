package algoritmosOrdenK;

import java.util.ArrayList;
import java.util.List;

/**
 * Fuerza bruta: 
 * se implementa un verificador que dado un conjunto y un candidato devuelve un booleano indicando 
 * si el valor indicado es el k elemento más pequeño. 
 * El algoritmo de fuerza bruta itera todos los elementos del conjunto y verifica de a uno si es la solución.
 * Una vez el verificador devuelve true, devuelve ese elemento.
 * 
 * @author 
 *
 */
public class FuerzaBruta extends EstadisticoK{

	public FuerzaBruta(List<Integer> conjuntoElementos, int ordenK) {
		this.conjuntoElementos = new ArrayList<Integer>(conjuntoElementos);
		
		long timeStart = System.nanoTime();
		this.elementK = obtenerElementoOrdenK(ordenK);
		long timeEnd = System.nanoTime();
		this.processTime = timeEnd - timeStart;
	}

	private int obtenerElementoOrdenK(int ordenK) {
		int i = 0;
		boolean elementoEncontrado = false;
		while (i < this.conjuntoElementos.size() && !elementoEncontrado) {
			int candidato = this.conjuntoElementos.get(i);
			elementoEncontrado = verificarOrdenK(candidato, ordenK);
			i++;
		}
		return this.conjuntoElementos.get(i-1);
	}

	private boolean verificarOrdenK(int candidato,int ordenK) {
		int posicioncandidato = 0;
		for (int i = 0; i < this.conjuntoElementos.size(); i++) {
			if (this.conjuntoElementos.get(i) < candidato){
				posicioncandidato++;
			}
		}
		return (posicioncandidato == ordenK);
	}
}
