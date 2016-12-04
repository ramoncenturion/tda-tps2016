package tp3.problema.mochila;

public class Item implements Comparable<Item> {

	private int peso;
	private int valor;
	
	public Item() {
		this(0,0);
	}
	
	public Item(int peso, int valor) {
		this.peso = peso;
		this.valor = valor;
	}

	public int getPeso() {
		return peso;
	}

	public int getValor() {
		return valor;
	}
	
	public void setValor(int valor) {
		this.valor = valor;
	}

    public String toString(){ 
        return "(" + peso + " , " + valor + ")"; 
    } 
    
    public int compareTo(Item other) {
    	if(this.getValor() < other.getValor()) return -1;
    	else if(this.getValor() > other.getValor()) return 1;
    	return 0;
    }
}
