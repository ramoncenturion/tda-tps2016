/**
 * 
 */
package tp1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * @author RCenturion
 *
 */
public class LectorArchivo {

	private File archivo = null;
	private FileReader fr = null;
    private BufferedReader br = null;
    private int cantidadVertices = 0;
    private int cantidadAristas = 0;
    private List<String> pesos = null;
	private List<Integer> conjuntoElementos = null;
	
	LectorArchivo(String direccion, boolean tipoGrafo){
		
		try {
			archivo = new File(direccion);
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			pesos = new ArrayList<String>();
			conjuntoElementos = new ArrayList<Integer>();
		} catch (FileNotFoundException e) {
			System.out.println("No se pudo abrir el archivo.");
			e.printStackTrace();
		}
	}

	public void procesarArchivoOrdenK() throws IOException {
		String linea;
		if((linea=br.readLine()) != null){
			String[] elementosSplit = linea.split("-");
	       	for (int i = 0; i < elementosSplit.length; i++) {
	       		conjuntoElementos.add(Integer.valueOf(elementosSplit[i]));
			}
	    }
	}

	public void procesarArchivoGrafo() throws NumberFormatException, IOException {
		String linea;
		if ((linea=br.readLine()) != null){
			cantidadVertices = Integer.valueOf(linea);
		}

		if ((linea=br.readLine()) != null){
			cantidadAristas = Integer.valueOf(linea);
		}

        while((linea=br.readLine()) != null){
        	pesos.add(linea);
        }		
	}

	public int getCantidadVertices() {
		return cantidadVertices;
	}

	public void setCantidadVertices(int cantidadVertices) {
		this.cantidadVertices = cantidadVertices;
	}

	public int getCantidadAristas() {
		return cantidadAristas;
	}

	public void setCantidadAristas(int cantidadAristas) {
		this.cantidadAristas = cantidadAristas;
	}

	public List<String> getPesos() {
		return pesos;
	}

	public void setPesos(List<String> pesos) {
		this.pesos = pesos;
	}

	public List<Integer> getConjuntoElementos() {
		return conjuntoElementos;
	}

	public void setConjuntoElementos(List<Integer> conjuntoElementos) {
		this.conjuntoElementos = conjuntoElementos;
	}


}
