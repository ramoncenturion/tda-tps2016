package tp2.redes.flujo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParserEntradaRedFlujo {

	private File archivo = null;
	private FileReader fr = null;
    private BufferedReader br = null;
	private int cantidadAreas;
	private int cantidadProyectos;
	private List<Area> areas = new ArrayList<Area>();
	private List<Proyecto> proyectos = new ArrayList<Proyecto>();
	
    
    
    ParserEntradaRedFlujo(String direccion) throws NumberFormatException, IOException{
		
		try {
			archivo = new File(direccion);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			String linea;
			if((linea=br.readLine()) != null){
				cantidadAreas = Integer.valueOf(linea);
			}
			if((linea=br.readLine()) != null){
				cantidadProyectos = Integer.valueOf(linea);
			}			
			
			for (int i = 0; i < cantidadAreas; i++) {
				if((linea=br.readLine()) != null){
					areas.add( new Area( Integer.valueOf(i), Integer.valueOf(linea)) );
				}				
			}
			
			Integer idProyecto = 1;
			while((linea=br.readLine()) != null){
				
				String[] elementosSplit = linea.split(" ");
				List<Integer> areasNecesarias = new ArrayList<Integer>();
		       	Integer ganancia = Integer.valueOf(elementosSplit[0]);
		       	
				for (int i = 1; i < elementosSplit.length; i++) {
		       		areasNecesarias.add(Integer.valueOf(elementosSplit[i]));
		       	}
				
				Proyecto proyectoNew = new Proyecto(idProyecto, ganancia, areasNecesarias); 

				proyectos.add(proyectoNew);
				
				idProyecto++;
			}

		} catch (FileNotFoundException e) {
			System.out.println("No se pudo abrir el archivo.");
			e.printStackTrace();
		}
	}



	public List<Area> getAreas() {
		return areas;
	}



	public void setAreas(List<Area> areas) {
		this.areas = areas;
	}



	public List<Proyecto> getProyectos() {
		return proyectos;
	}



	public void setProyectos(List<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}

	
}
