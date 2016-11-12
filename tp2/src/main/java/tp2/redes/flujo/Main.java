package tp2.redes.flujo;

public class Main {

	public static void main(String[] args) {
		String path = "src\\main\\resources\\tp2\\redes\\flujo\\entradaRed.txt";
		
		SelectorProyectos selector = new SelectorProyectos(path);
		selector.mostrarRed();
		
//		try {
//			String direccion = "C:\\Dev\\tda\\tda-tps2016\\tp2\\src\\main\\resources\\tp2\\redes\\flujo\\entradaRed.txt";
//			ParserEntradaRedFlujo parser = new ParserEntradaRedFlujo(direccion);
//			
//			List<Proyecto> proyectos = parser.getProyectos();
//			List<Area> areas = parser.getAreas();
//			
//			//********************** Muestro como lei el archivo ****************			
//			for (Proyecto proyecto : proyectos) {
//				System.out.println("Proyecto: "+proyecto.getIdProyecto()+" - ganancia: "+proyecto.getGanancia());
//				String areasNecesarias = "";
//				for (Area area : proyecto.getAreasNecesarias()) {					
//					areasNecesarias += " Area-"+area.getId()+" Costo: "+area.getCosto();
//				}
//				System.out.println("Necesita:"+areasNecesarias);
//			}
//			//*******************************************************************
//			//Vertices = #Areas+#Proyectos+Sumidero+Destino
//			int cantidadAreas = parser.getCantidadAreas();
//			int cantidadProyectos = parser.getCantidadProyectos();
//			int cantidadVertices = cantidadAreas + cantidadProyectos+2;
//			int origen = 0;
//			int destino = cantidadVertices-1;
//			
//			int pesoInfinito = 0;
//			//----------------------------------------------
//			//Armo grafo de proyecto - area Version 
//			for (Proyecto proyecto : proyectos) {	
//				if (proyecto.getGanancia()>pesoInfinito){
//					pesoInfinito = proyecto.getGanancia();
//				}
//			}
//			
//			Red grafo = new Red(cantidadVertices);
//			for (Proyecto proyecto : proyectos) {				
//				grafo.add_edge(origen, proyecto.getIdProyecto(), proyecto.getGanancia());
//				for (Area area : proyecto.getAreasNecesarias()) {
//					grafo.add_edge(proyecto.getIdProyecto(), area.getId()+cantidadProyectos,pesoInfinito);
//				}
//			}
//			
//			for (Area area : areas) {
//				grafo.add_edge(area.getId()+cantidadProyectos, destino , area.getCosto());
//			}
//			//----------------------------------------------
//
//
//			//genero ford fulkerson para obtener el flujo maximo
//			//busco el corte minimal
//			//lo que esta en S es lo que tomo para realizar
//		} catch (NumberFormatException e ) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
