package algoritmosOrdenK;

import java.util.ArrayList;
import java.util.List;

public class HeapSelect extends EstadisticoK{
	
	private static int heapSize;
	private static List<Integer> conjuntoDeKMinimos;
    
    public HeapSelect(List<Integer> A,  int kElegido) {
    	conjuntoElementos = new ArrayList<Integer>(A);
    	
    	conjuntoDeKMinimos = obtenerConjuntoDeKElementosMinimos(kElegido);
    	heapSize = conjuntoDeKMinimos.size();
    	elementK = -1;
    
		long timeStart = System.nanoTime();
		procesar();
		long timeEnd = System.nanoTime();
		this.processTime = timeEnd - timeStart;
    }
    
    private void procesar() {
        ordenamientoInicial();       
        setearElemento();
    }
    
    private void ordenamientoInicial() {
        for(int i=heapSize/2 ; i>=0 ;i--) {
        	heapify(i);
        }
    }
    
    private void heapify(int i) {
        int l=LEFT(i);
        int r=RIGHT(i);
        int indiceDelElementoMasGrande = -1;
        if(l<heapSize && conjuntoDeKMinimos.get(l)>conjuntoDeKMinimos.get(i)) {
        	indiceDelElementoMasGrande = l;
        }else{
        	indiceDelElementoMasGrande = i;
        }

        if(r<heapSize && conjuntoDeKMinimos.get(r)>conjuntoDeKMinimos.get(indiceDelElementoMasGrande)) {
        	indiceDelElementoMasGrande = r;
        }

        if(indiceDelElementoMasGrande!=i) {
            Integer temp = conjuntoDeKMinimos.get(i);
            conjuntoDeKMinimos.set(i, conjuntoDeKMinimos.get(indiceDelElementoMasGrande));
            conjuntoDeKMinimos.set(indiceDelElementoMasGrande, temp);
            heapify(indiceDelElementoMasGrande);
        }
    }
    
    private void setearElemento() {
    	int ultimo = conjuntoDeKMinimos.size()-1;
    	
        Integer temp = conjuntoDeKMinimos.get(0);
        conjuntoDeKMinimos.set(0, conjuntoDeKMinimos.get(ultimo));
        conjuntoDeKMinimos.set(ultimo, temp);
        heapSize  = heapSize-1;
        heapify(0);
        
        
        if (heapSize < conjuntoElementos.size()) elementK = conjuntoDeKMinimos.get(ultimo);
    }
    
    private int LEFT(int i) {
        return 2*i+1;
    }

    private int RIGHT(int i) {
    	return 2*i+2;
    }
	
	
	private List<Integer> obtenerConjuntoDeKElementosMinimos(int ordenK) {
		List<Integer> conjuntoK = new ArrayList<Integer>();
		for (int i = 0; i <= ordenK; i++) {
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
			conjuntoK.add(minValue);
		}
		return conjuntoK;
	}
}
