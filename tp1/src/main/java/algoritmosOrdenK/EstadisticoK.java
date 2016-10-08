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

}
