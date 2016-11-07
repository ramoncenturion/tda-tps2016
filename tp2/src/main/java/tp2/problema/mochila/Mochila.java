package tp2.problema.mochila;

import java.util.Collections; 
import java.util.LinkedList; 
import java.util.List; 

public class Mochila {
    private List<Item> listaItems; 
    private int pesoMaximo;
    private int[][] P; // Matriz de soluciones
     
    public Mochila(int pesoMaximo){ 
        this.listaItems = new LinkedList<Item>(); 
        this.pesoMaximo = pesoMaximo; 
    } 
    
    public void agregarItem(int peso, int valor) {
    	this.listaItems.add(new Item(peso,valor));
    }
    
    public MochilaResult resolver() {
    	int n = this.listaItems.size(); // Cantidad de elementos 
    	int W = this.pesoMaximo;
    	
    	calcularMatrizdeSoluciones(n, W);
    	List<Item> itemsSolucion = analizarSolucion(n, W);
    	
    	return new MochilaResult(itemsSolucion, P[n][W]);
    }
    
    private void calcularMatrizdeSoluciones(int n, int W) {
    	P = new int[n+1][W+1]; // Matriz de soluciones
    	
    	// Inicializacion de la matriz
    	for (int w=0 ; w<=W ; w++) {
    		P[0][w] = 0; 
    	}
    	for (int i=0 ; i<=n ; i++) {
    		P[i][0] = 0; 
    	}
    	
    	for (int i=1 ; i<=n ; i++) {
    		for (int w=0 ; w<=W ; w++) {
    			Item item = listaItems.get(i-1);
    			int wi = item.getPeso();
    			if (wi <= w) { // el elemento i puede ser parte de la solucion
    				if (item.getValor() + P[i-1][w-wi] > P[i-1][w]) {
    					P[i][w] = item.getValor() + P[i-1][w-wi]; 
    				} else {
    					P[i][w] = P[i-1][w];
    				}
    			} else {
    				P[i][w] = P[i-1][w]; // wi > w
    			}
    		}
    	}    	
    }
    
    private List<Item> analizarSolucion(int i, int k) {
    	List<Item> itemsSolucion  = new LinkedList<Item>();
    	
    	while (i*k > 0) {
	    	if (P[i][k] != P[i-1][k]) {
	    		Item item = listaItems.get(i-1);
	    		itemsSolucion.add(item);
	    		i--;
	    		k -= item.getPeso();
	    	} else {
	    		i--;
	    	}
    	}
    	
    	return itemsSolucion;
    }
    
    public String toString(){ 
        return "Peso máximo: " + pesoMaximo + "\nLista de items: " + listaItems.toString(); 
    }
}
