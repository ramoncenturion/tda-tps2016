package tp2.problema.mochila;

import java.util.List;

public class MochilaResult {
	List<Item> itemsSolucion;
	int valorOptimo;
	
	public MochilaResult(List<Item> itemsSolucion, int valorOptimo) {
		this.itemsSolucion = itemsSolucion;
		this.valorOptimo = valorOptimo;
	}
	
	public List<Item> getItemsSolucion() {
		return itemsSolucion;
	}
	
	public int getValorOptimo() {
		return valorOptimo;
	}
	
	public String toString(){ 
        return "Valor Óptimo: " + valorOptimo + "\nLista de items solucion: " + itemsSolucion.toString(); 
    }
}
