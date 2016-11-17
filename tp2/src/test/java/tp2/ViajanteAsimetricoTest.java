package tp2;

import java.io.IOException;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import tp2.problema.viajante.ViajanteAsimetrico;
import tp2.problema.viajante.ViajanteAsimetricoParser;

public class ViajanteAsimetricoTest {

	@Test
	public void testParser() {
		String filename = "D:\\TDA\\tda-tps2016\\tp2\\src\\main\\resources\\tp2\\viajante\\test02.txt";
		try {
			ViajanteAsimetricoParser parser = new ViajanteAsimetricoParser(filename);
			Integer[][] distance = parser.getMatrix();
			
			ViajanteAsimetrico tsp = new ViajanteAsimetrico();
			int costo = tsp.resolver(distance);
			Assert.assertEquals(19, costo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
    @Test
    public void testDifferentCases() {
    	ViajanteAsimetrico tsp = new ViajanteAsimetrico();
        int[][] distance = {{0, 12, 3, 9, 6, 1, 2},
			                {12, 0, 6, 1, 8, 2, 10},
			                {3, 6, 0, 6, 7, 11, 7},
			                {9, 1, 6, 0, 9, 10, 3},
			                {6, 8, 7, 9, 0, 1, 11},
			                {1, 2, 11, 10, 1, 0, 12},
			                {2, 10, 7, 3, 11, 12, 0}};

        int cost = tsp.resolver(distance);
        Assert.assertEquals(19, cost);

        int[][] distance1 = {{0, 1, 15, 6},
			                {2, 0, 7, 3},
			                {9, 6, 0, 12},
			                {10, 4, 8, 0},
        };

        cost = tsp.resolver(distance1);
        Assert.assertEquals(21, cost);
        

        int[][] distance2 = {{0, 2, 9, 10},
			                {1, 0, 6, 4},
			                {15, 7, 0, 8},
			                {6, 3, 12, 0},
        };

        cost = tsp.resolver(distance2);
        Assert.assertEquals(21, cost);
    }*/
}
