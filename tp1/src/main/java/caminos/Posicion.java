package caminos;

public class Posicion {
	
	private int x;
	private int y;
	
	public Posicion(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public double distancia(Posicion p) {
		
		double x2 = Math.pow(x - p.getX(), 2);
		double y2 = Math.pow(y - p.getY(), 2);
		double distancia = Math.sqrt(x2 + y2);
		return distancia;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
}
