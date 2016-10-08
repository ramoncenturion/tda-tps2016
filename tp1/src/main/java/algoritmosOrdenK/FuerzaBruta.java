package algoritmosOrdenK;

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
public class FuerzaBruta {

	private List<Integer> conjuntoElementos;

	public FuerzaBruta(List<Integer> conjuntoElementos) {
		this.conjuntoElementos = conjuntoElementos;
		int minimo = 0;
		int maximo = this.conjuntoElementos.size()-1;
		int mediana = this.conjuntoElementos.size()/2;
		
		int minimoK = obtenerElementoOrdenK(minimo);
		int medianaK = obtenerElementoOrdenK(mediana);
		int maximoK = obtenerElementoOrdenK(maximo);
		
		System.out.println("Minimo: "+minimoK);
		System.out.println("Mediana: "+medianaK);
		System.out.println("Maximo: "+maximoK);
		
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
