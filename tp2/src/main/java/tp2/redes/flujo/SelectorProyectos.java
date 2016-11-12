package tp2.redes.flujo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SelectorProyectos {

//	private ParserEntradaRedFlujo parser;
	private Red red = null;
	private AlgoritmoFordFulkerson fordFulkerson;
	private List<Integer> proyectosSeleccionados = new ArrayList<Integer>();
	private List<Integer> areasSeleccionadas = new ArrayList<Integer>();
	private int maximaGanancia = 0;
	private Integer cantidadAreas = 0; 
	private Integer cantidadProyectos = 0; 
	//Vertices = #Areas+ #Proyectos + Sumidero + Destino
	private int cantidadVertices = 0;
	
	public SelectorProyectos(String path) {
//			parser = new ParserEntradaRedFlujo(path);
			parserRed(path);
//			this.generarRed();
			aplicarFordFulkerson();
			seleccionarProyectos();
	}

	private void parserRed(String path) {
		try {
		    File archivo = new File(path);
		    FileReader fr = new FileReader(archivo);
		    BufferedReader br = new BufferedReader(fr);
			String linea;
			
			if((linea=br.readLine()) != null){
				cantidadAreas = Integer.valueOf(linea);
			}
			
			if((linea=br.readLine()) != null){
				cantidadProyectos = Integer.valueOf(linea);
			}
			cantidadVertices = cantidadAreas + cantidadProyectos + 2;
			int origen = 0;
			int destino = cantidadVertices-1;
			this.red = new Red(cantidadVertices);

			for (int idArea = 1; idArea <= cantidadAreas; idArea++) {
				if((linea=br.readLine()) != null){
					this.red.add_edge(idArea+cantidadProyectos,destino,Integer.valueOf(linea));
				}				
			}
			
			Integer idProyecto = 1;
			while((linea=br.readLine()) != null){
				String[] elementosSplit = linea.split(" ");
		       	Integer ganancia = Integer.valueOf(elementosSplit[0]);
		       	this.red.add_edge(origen,idProyecto,ganancia);
				for (int indexArea = 1; indexArea < elementosSplit.length; indexArea++) {
					Integer idArea = Integer.valueOf(elementosSplit[indexArea]);
					this.red.add_edge(idProyecto,idArea+cantidadProyectos,Integer.MAX_VALUE);
		       	}
				idProyecto++;
			}
			br.close();
			
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}

//	private void generarRed() {
//		int cantidadAreas = parser.getCantidadAreas();
//		int cantidadProyectos = parser.getCantidadProyectos();
//		int cantidadVertices = cantidadAreas + cantidadProyectos + 2;
//		int origen = 0;
//		int destino = cantidadVertices-1;
//		
//		//Armo grafo de proyecto - area Version 
//		this.red = new Red(cantidadVertices);
//
//		for (Area area : parser.getAreas()) {
//			this.red.add_edge(area.getId()+cantidadProyectos,destino ,area.getCosto());
//		}
//		
//		for (Proyecto proyecto : parser.getProyectos()) {				
//			this.red.add_edge(origen, proyecto.getIdProyecto(), proyecto.getGanancia());
//			for (Area area : proyecto.getAreasNecesarias()) {
//				this.red.add_edge(proyecto.getIdProyecto(),area.getId()+cantidadProyectos,Integer.MAX_VALUE);
//			}
//		}
//	}

	private void aplicarFordFulkerson() {
		this.fordFulkerson = new AlgoritmoFordFulkerson(this.red);
		System.out.println("Flujo Maximo " + this.fordFulkerson.getFlujoMaximo());
	}

	public AlgoritmoFordFulkerson getFordFulkerson() {
		return fordFulkerson;
	}

	public Red getRed() {
		return red;
	}

	public int getMaximaGanancia() {
		return maximaGanancia;
	}
	
	private void seleccionarProyectos() {
		//Busco los proyectos que deberia realizar
        for (Arista projecto : this.red.adj_fuente()) {
        	if (projecto.getFlujo() < projecto.getCapacidad()) {
        		proyectosSeleccionados.add(projecto.getDst());
        		//Busco las areas necesarias para realizar el proyecto
        		for (Arista area : this.red.adj_e(projecto.getDst())) {
        			areasSeleccionadas.add(area.getDst());
        		}
        		this.maximaGanancia += projecto.getCapacidad() - projecto.getFlujo();
        	}
        }
	}

	public void mostrarRed(){	
		for (Arista proyecto : this.red.adj_fuente()) {
			System.out.println("Proyecto: "+proyecto.getDst()+" - ganancia: "+proyecto.getCapacidad());
			String areasNecesarias = "";
			for (Arista area : this.red.adj_e(proyecto.getDst())) {					
				areasNecesarias += " Area-"+(area.getDst()-cantidadProyectos)+" Costo: "+this.red.getArista(area.getDst(), cantidadVertices-1).getCapacidad();
			}
			System.out.println("Necesita:"+areasNecesarias);
		}
	}
}
