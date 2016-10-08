package algoritmosOrdenK;

import java.util.List;

public abstract class EstadisticoK {

	protected List<Integer> conjuntoElementos;
	protected int elementK;
	protected long processTime;
	
	public int getElementK() {
		return elementK;
	}

	public long getProcessTime() {
		return processTime;
	}


	protected void swap(int a, int b) {
		int tmp = this.conjuntoElementos.get(a);
		this.conjuntoElementos.set(a,this.conjuntoElementos.get(b));
		this.conjuntoElementos.set(b,tmp);
	}
	
}
