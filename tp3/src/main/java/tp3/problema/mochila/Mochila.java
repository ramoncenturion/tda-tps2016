package tp3.problema.mochila;
 
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList; 
import java.util.List; 

public class Mochila {
    private List<Item> listaItems; 
    private int pesoMaximo;
    private int[][] M; // Matriz de soluciones
    private int V; // Suma de valores
     
    public Mochila(int pesoMaximo){ 
        this.listaItems = new LinkedList<Item>(); 
        this.pesoMaximo = pesoMaximo; 
        this.V = 0;
    } 
    
    public void agregarItem(int peso, int valor) {
        if (peso <= this.pesoMaximo) {
            this.listaItems.add(new Item(peso,valor));
            this.V += valor;
        }
    }
    
    // Approximation algorithm
    public void overrideValues(double epsilon) {
        // Buscar el maximo valor
        Item maxItemValue = Collections.max(listaItems);
        int maxValue = maxItemValue.getValor();
        int n = listaItems.size();
        
        // Source: Vazirani, Dasgupta - Algorithms.
        double b = n/(epsilon*maxValue);
        
        
        this.V = 0;
        for (Item item : listaItems) {
            int valor = (int)Math.floor(item.getValor()*b);
            item.setValor(valor);
            this.V += valor;
        }
    }
    
    public MochilaResult resolver() {
        int n = this.listaItems.size(); // Cantidad de elementos 
        int W = this.pesoMaximo;
        
        calcularMatrizdeSoluciones(n);
        List<Item> itemsSolucion  = new LinkedList<Item>();

        int max = -1;
        for (int v=0 ; v<=V ; v++) {
            if (M[n][v] <= this.pesoMaximo) {
                if (max < M[n][v]) {
                    max = M[n][v];
                }
            }
        }
        
        return new MochilaResult(itemsSolucion, max);
    }
    
    private void calcularMatrizdeSoluciones(int n) {
        M = new int[n+1][V+1]; // Matriz de soluciones
        
        // Inicializacion de la matriz
        for (int v=0 ; v<=V ; v++) {
            M[0][v] = 0; 
        }
        for (int i=0 ; i<=n ; i++) {
            M[i][0] = 0; 
        }
        
        for (int i=1 ; i<=n ; i++) {
            int sumV = this.getSumaValores(i);

            for (int v=1 ; v<=sumV ; v++) {
                Item item = listaItems.get(i-1);
                int wi = item.getPeso();
                int vi = item.getValor();

                if (v > this.getSumaValores(i-1)) {
                    M[i][v] = wi + M[i-1][v];
                } else {
                    M[i][v] = Math.min(M[i-1][v], wi + M[i-1][Math.max(0,v-vi)]);
                }
            }
        }       
    }

    private int getSumaValores(int i) {
        int sum = 0;
        for (int j=1 ; j<=i ; j++) {
            Item item = listaItems.get(j-1);
            sum += item.getValor();
        }
        return sum;
    }

}
