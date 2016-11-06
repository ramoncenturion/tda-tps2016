package tp2.problema.mochila;

public class Item {

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

    public String toString(){ 
        return "(" + peso + " , " + valor + ")"; 
    } 
}
