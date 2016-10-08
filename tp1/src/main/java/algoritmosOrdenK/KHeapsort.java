package algoritmosOrdenK;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class KHeapsort extends EstadisticoK{

	private static int heapSize;
    private static int k;
    
    public KHeapsort(List<Integer> A,  int kElegido) {
    	conjuntoElementos = new ArrayList<Integer>(A);
    	heapSize = conjuntoElementos.size();
    	k = kElegido;
    	elementK = -1;
    
    	if (k < heapSize){
    		long timeStart = System.nanoTime();
    		procesar();
    		long timeEnd = System.nanoTime();
    		this.processTime = timeEnd - timeStart;
    	} else {
    		System.out.println("Tamaño fuera de rango");
    	}
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
        int indiceDelElementoMasPequeno = -1;
        if(l<heapSize && conjuntoElementos.get(l)<conjuntoElementos.get(i)) {
        	indiceDelElementoMasPequeno = l;
        }else{
        	indiceDelElementoMasPequeno = i;
        }

        if(r<heapSize && conjuntoElementos.get(r)<conjuntoElementos.get(indiceDelElementoMasPequeno)) {
        	indiceDelElementoMasPequeno = r;
        }

        if(indiceDelElementoMasPequeno!=i) {
            Integer temp = conjuntoElementos.get(i);
            conjuntoElementos.set(i, conjuntoElementos.get(indiceDelElementoMasPequeno));
            conjuntoElementos.set(indiceDelElementoMasPequeno, temp);
            heapify(indiceDelElementoMasPequeno);
        }
    }
    
    private void setearElemento() {
        for(int i=0 ; i<=k ; i++) {
        	int ultimo = conjuntoElementos.size() - i - 1;
        	
            Integer temp = conjuntoElementos.get(0);
            conjuntoElementos.set(0, conjuntoElementos.get(ultimo));
            conjuntoElementos.set(ultimo, temp);
            heapSize  = heapSize-1;
            heapify(0);
        }
        
        if (heapSize < conjuntoElementos.size()) elementK = conjuntoElementos.get(heapSize);
    }
    
    private int LEFT(int i) {
        return 2*i+1;
    }

    private int RIGHT(int i) {
    	return 2*i+2;
    }
    
}
