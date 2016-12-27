package tp3.aproximacion.viajante;

public class Arista implements Comparable<Arista> {
	
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

    /**
     * {@inheritDoc}
     */
    @Override
    public int compareTo(Arista e) {
        if (this.peso < e.peso)
            return -1;
        if (this.peso > e.peso)
            return 1;


        return 0;
    }
    
    public String toString() {
        return "[ARISTA] ("+sumidero+","+destino+") - "+peso;
    }
}
