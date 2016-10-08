package algoritmosOrdenK;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class KHeapsort {

	private static int heapSize;
    private static int k;
    private static int elementK;
    private static int processTime;
    private static List<Integer> conjuntoElementos;
    
    public KHeapsort(List<Integer> A,  int kElegido) {
    	conjuntoElementos = new ArrayList<Integer>(A);
    	heapSize = conjuntoElementos.size();
    	k = kElegido;
    	elementK = -1;
    
    	if (k <= heapSize) 
    		procesar();
    	else
    		System.out.println("Tamaño fuera de rango");
    }
    
    private static void procesar() {
        ordenamientoInicial();       
        setearElemento();
    }
    
    private static void ordenamientoInicial() {
        for(int i=heapSize/2 ; i>=0 ;i--) {
        	heapify(i);
        }
    }
    
    private static void heapify(int i) {
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
    
    private static void setearElemento() {
        for(int i=1 ; i<=k ; i++) {
        	int ultimo = conjuntoElementos.size() - i;
        	
            Integer temp = conjuntoElementos.get(0);
            conjuntoElementos.set(0, conjuntoElementos.get(ultimo));
            conjuntoElementos.set(ultimo, temp);
            heapSize  = heapSize-1;
            heapify(0);
        }
        
        if (heapSize < conjuntoElementos.size()) elementK = conjuntoElementos.get(heapSize);
    }
    
    private static int LEFT(int i) {
        return 2*i+1;
    }

    private static int RIGHT(int i) {
    	return 2*i+2;
    }
    
    public int getElementK() {
    	return elementK;
    }

    public static void main(String[] args) {

    	List<Integer> A = new ArrayList<Integer>();
    	A.add(4);
    	A.add(1);
    	A.add(3);
    	A.add(2);
    	A.add(16);
    	A.add(9);
    	A.add(10);
    	A.add(14);
    	A.add(8);
    	A.add(7);
    	
    	int k = 11;
    	
    	KHeapsort kh = new KHeapsort(A, k);
    	System.out.println(kh.getElementK());
    }
}