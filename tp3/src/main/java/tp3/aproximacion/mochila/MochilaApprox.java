package tp3.aproximacion.mochila;

import tp3.problema.mochila.Mochila;
import tp3.problema.mochila.MochilaResult;

public class MochilaApprox {

	Mochila mochila;
	double epsilon;
	
	public MochilaApprox(int pesoMaximo, double epsilon){ 
		this.mochila = new Mochila(pesoMaximo);
		this.epsilon = epsilon;
	}
	
	public void agregarItem(int peso, int valor) {
		this.mochila.agregarItem(peso, valor);
	}
	 
	public MochilaResult resolver() {
		mochila.overrideValues(epsilon);
		MochilaResult result = mochila.resolver();
		
		return result;
	}
}
