package tp2.redes.flujo;

public class Arista {
	
	private int sumidero;
	private int destino;
	private int capacidad;
	private int flujo;
	
	public Arista(int src, int dst, int capacidad) {
		sumidero = src;
		destino = dst;
		this.capacidad = capacidad;
		flujo = 0;
	}
	
	public int getSrc() {
		return sumidero;
	}
	
	public int getDst() {
		return destino;
	}
	
	public int getCapacidad() {
		return capacidad;
	}

	public int getFlujo() {
		return flujo;
	}

	public void setFlujo(int flujo) {
		this.flujo = flujo;
	}

}
