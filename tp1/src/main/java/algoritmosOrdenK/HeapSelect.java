package algoritmosOrdenK;

import java.util.ArrayList;
import java.util.List;

public class HeapSelect extends EstadisticoK{
	private static int k;
	public HeapSelect(List<Integer> A, int kElegido) {
		conjuntoElementos = new ArrayList<Integer>(A);
		k = kElegido;
		
		process();
	}
	
	private void process() {
		ordenamientoInicial();
		setearElemento();
	}
	
	private void ordenamientoInicial() {
		int last = conjuntoElementos.size() - 1;
		int padreMasJoven = last / 2;
		for (int i = padreMasJoven; i >= 0; i--) {
			moveDown(i, last);
		}
	}
	
	private void setearElemento() {
		int last = conjuntoElementos.size() - 1;
		int limit = last - k;
		for (int i = last; i > limit; i--) {
			if (conjuntoElementos.get(0) < conjuntoElementos.get(i)) {
				swap(0, i);
				moveDown(0, i - 1);
		    }
		}
		
		elementK = conjuntoElementos.get(0);
	}
		 
	private void moveDown(int first, int last) {
		int elementoMasGrande = 2 * first + 1;
		while (elementoMasGrande <= last) {
			if (elementoMasGrande < last && conjuntoElementos.get(elementoMasGrande) > conjuntoElementos.get(elementoMasGrande + 1)) {
				elementoMasGrande++;
			}
			if (conjuntoElementos.get(first) > conjuntoElementos.get(elementoMasGrande)) {
				swap(first, elementoMasGrande);
				first = elementoMasGrande;
				elementoMasGrande = 2 * first + 1;
			} else {
				return;
			}
		}
	}
	
	private void swap(int first, int last) {
		Integer temp = conjuntoElementos.get(first);
		conjuntoElementos.set(first, conjuntoElementos.get(last));
		conjuntoElementos.set(last, temp);
	}
}
