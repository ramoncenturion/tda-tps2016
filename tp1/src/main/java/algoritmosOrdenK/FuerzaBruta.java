package algoritmosOrdenK;

import java.util.List;
import java.util.Random;

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
		Random rn = new Random();
		
		int candidato = rn.nextInt(this.conjuntoElementos.size());
		System.out.println("Candidato:"+this.conjuntoElementos.get(candidato));
		
		if (this.esMinElemento(candidato)){
			System.out.println("Minimo: "+this.conjuntoElementos.get(candidato));
		}
		if (this.esMaxElemento(candidato)){
			System.out.println("Maximo: "+this.conjuntoElementos.get(candidato));
		}
		if (this.esMediaElemento(candidato)){
			System.out.println("Mediana: "+this.conjuntoElementos.get(candidato));
		}
		
	}

	private boolean esMediaElemento(int candidato) {
		int mediana = this.conjuntoElementos.get(candidato);
		
		int medioOrden = this.conjuntoElementos.size()%2==0?this.conjuntoElementos.size()/2:(this.conjuntoElementos.size()+1)/2;
		
		boolean esMediana = true;
		int index = 0;
		while (esMediana && index < this.conjuntoElementos.size()) {
//			if(this.conjuntoElementos.get(index) > maximo){
				esMediana = false;
//			}
//			index++;
		}
		return esMediana;
	}

	private boolean esMaxElemento(int candidato) {
		int maximo = this.conjuntoElementos.get(candidato);
		boolean esMaximo = true;
		int index = 0;
		while (esMaximo && index < this.conjuntoElementos.size()) {
			if(this.conjuntoElementos.get(index) > maximo){
				esMaximo = false;
			}
			index++;
		}
		return esMaximo;
	}

	private boolean esMinElemento(int candidato) {
		int minimo = this.conjuntoElementos.get(candidato);
		boolean esMinimo = true;
		int index = 0;
		while (esMinimo && index < this.conjuntoElementos.size()-1) {
			if(this.conjuntoElementos.get(index) < minimo){
				esMinimo = false;
			}
			index++;
		}
		return esMinimo;
	}

	
}
