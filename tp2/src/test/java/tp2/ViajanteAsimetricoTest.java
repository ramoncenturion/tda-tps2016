package tp2;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import tp2.problema.viajante.ViajanteAsimetrico;
import tp2.problema.viajante.ViajanteAsimetricoParser;

public class ViajanteAsimetricoTest {

	@Test
	public void testParser01() {
		String filename = "D:\\TDA\\tda-tps2016\\tp2\\src\\main\\resources\\tp2\\viajante\\test01.txt";
		try {
			ViajanteAsimetricoParser parser = new ViajanteAsimetricoParser(filename);
			Integer[][] distancias = parser.getMatrix();
			int costoSolucion = parser.getMinDistancia();
					
			ViajanteAsimetrico tsp = new ViajanteAsimetrico(1, distancias);
			int costo = tsp.getDistanciaMinima();
			
			Assert.assertEquals(costoSolucion, costo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	@Test
	public void testParser02() {
		String filename = "D:\\TDA\\tda-tps2016\\tp2\\src\\main\\resources\\tp2\\viajante\\test02.txt";
		try {
			ViajanteAsimetricoParser parser = new ViajanteAsimetricoParser(filename);
			Integer[][] distancias = parser.getMatrix();
			int costoSolucion = parser.getMinDistancia();
			
			ViajanteAsimetrico tsp = new ViajanteAsimetrico(1, distancias);
			int costo = tsp.getDistanciaMinima();
			
			Assert.assertEquals(costoSolucion, costo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testParser03() {
		String filename = "D:\\TDA\\tda-tps2016\\tp2\\src\\main\\resources\\tp2\\viajante\\test03.txt";
		try {
			ViajanteAsimetricoParser parser = new ViajanteAsimetricoParser(filename);
			Integer[][] distancias = parser.getMatrix();
			int costoSolucion = parser.getMinDistancia();
			
			ViajanteAsimetrico tsp = new ViajanteAsimetrico(1, distancias);
			int costo = tsp.getDistanciaMinima();
			
			Assert.assertEquals(costoSolucion, costo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/
}
