package tp3.aproximacion.viajante;

public class Arista {
	
	int sumidero;
	int destino;
	double peso;
	
	public Arista(int src, int dst, double weight) {
		sumidero = src;
		destino = dst;
		peso = weight;
	}
	
	public int getSrc() {
		return sumidero;
	}
	
	public int getDst() {
		return destino;
	}
	
	public double getWeight() {
		return peso;
	}

}
