package tp2.redes.flujo;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		
		try {
			String direccion = "C:\\Dev\\tda\\tda-tps2016\\tp2\\src\\main\\resources\\tp2\\redes\\flujo\\entradaRed.txt";
			ParserEntradaRedFlujo parser = new ParserEntradaRedFlujo(direccion);
			
			parser.getProyectos();
			parser.getAreas();
			
			
		} catch (NumberFormatException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
