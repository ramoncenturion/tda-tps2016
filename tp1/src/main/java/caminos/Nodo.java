package caminos;

import java.util.Comparator;

public class Nodo implements Comparator<Nodo> {
	public int nodo;
	public double valor;
	
	public Nodo() {}
	
	public Nodo(int nodo, double valor) {
		this.nodo  = nodo;
		this.valor = valor;
	}
	
	public int compare(Nodo nodo1, Nodo nodo2) {
		if (nodo1.valor < nodo2.valor) {
			return -1;
		}
		if (nodo1.valor > nodo2.valor) {
			return 1;
		}
		return 0;
	}
}