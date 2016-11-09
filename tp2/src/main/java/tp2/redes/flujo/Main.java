package tp2.redes.flujo;

import java.io.IOException;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		try {
			String direccion = "C:\\Dev\\tda\\tda-tps2016\\tp2\\src\\main\\resources\\tp2\\redes\\flujo\\entradaRed.txt";
			ParserEntradaRedFlujo parser = new ParserEntradaRedFlujo(direccion);
			
			List<Proyecto> proyectos = parser.getProyectos();
			List<Area> areas = parser.getAreas();
			//de proyecto a areas
			//creo un difgrafo de v=cant. proy + cant. areas + 2
			//agrego las aristas de proyecto desde el sumidero (nodo 0) con peso igual a la ganancia
			//agrego las aristas de proyecto a area segun las areas necesarias por proyecto con valor infinito
			//agrego las aristas de areas al nodo final con el peso igual al costo
			
			//genero ford fulkerson para obtener el flujo maximo
			//busco el corte minimal
			//lo que esta en S es lo que tomo para realizar
		} catch (NumberFormatException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
