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

	private List<Integer> conjuntoElementosParaMin;
	private List<Integer> conjuntoElementosParaMax;
	private List<Integer> conjuntoElementosParaMed;
	private int posibleEstadistico;

	public OrdenarSeleccionar(List<Integer> conjuntoElementos) {
		this.conjuntoElementosParaMin = new ArrayList<Integer>(conjuntoElementos);
		this.conjuntoElementosParaMax = new ArrayList<Integer>(conjuntoElementos);
		this.conjuntoElementosParaMed = new ArrayList<Integer>(conjuntoElementos);
		
		
		Random rn = new Random();
		
		int candidato = rn.nextInt(conjuntoElementos.size());
		posibleEstadistico = conjuntoElementos.get(candidato);
		System.out.println("Candidato:"+posibleEstadistico);
		
		if (this.esMinElemento(candidato)){
			System.out.println("Minimo: "+conjuntoElementos.get(candidato));
		}
		if (this.esMaxElemento(candidato)){
			System.out.println("Maximo: "+conjuntoElementos.get(candidato));
		}
		if (this.esMediaElemento(candidato)){
			System.out.println("Mediana: "+conjuntoElementos.get(candidato));
		}
		
	}

	private boolean esMediaElemento(int candidato) {
		this.ordenar(this.conjuntoElementosParaMed);
		return false;
	}

	private boolean esMaxElemento(int candidato) {
		this.ordenar(this.conjuntoElementosParaMax);
//		System.out.println("ordenados:");
//		for (Integer elemento : this.conjuntoElementosParaMax) {
//			System.out.print(elemento+" | ");
//		}
		return this.conjuntoElementosParaMax.get(this.conjuntoElementosParaMax.size()-1).equals(this.posibleEstadistico);
	}


	private boolean esMinElemento(int candidato) {
		this.ordenar(this.conjuntoElementosParaMin);
		return this.conjuntoElementosParaMin.get(0).equals(this.posibleEstadistico);
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
