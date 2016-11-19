package tp2.problema.viajante;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ViajanteAsimetricoParser {

	private Integer[][] distancias;
	private List<Integer> caminoMinimo;
	private Integer minDistancia;
	
	public ViajanteAsimetricoParser(String filename) throws IOException {
		caminoMinimo = new ArrayList<Integer>();
		minDistancia = -1;
		parseFile(filename);
	}
	
	public Integer[][] getMatrix() {
		return distancias;
	}
	
	public Integer getMinDistancia() {
		return minDistancia;
	}
	
	public List<Integer> getCaminoMinimo() {
		return caminoMinimo;
	}
	
	private void parseFile(String filename) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(filename));
		
		br.readLine(); // DIMENSION
		Integer dimension = Integer.parseInt(br.readLine());
		
		br.readLine(); // EDGE_WEIGHT_FORMAT
		String format = br.readLine();
		
		br.readLine(); // DELIMITER
		String delimiter = br.readLine();
		
		br.readLine(); // EDGE_WEIGHT_SECTION
		
		distancias = new Integer[dimension][dimension];
		
		if (format.trim().equals("FULL_MATRIX")) {
			parseFullMatrix(br, dimension, delimiter);
		} else if (format.trim().equals("LOWER_DIAG_ROW")) {
			parseLowerDiag(br, dimension, delimiter);
		}
		
		parseSolution(br, dimension);
	}
	
	private void parseFullMatrix(BufferedReader br, Integer dimension, String delimiter) throws IOException {
		int fila = 0;
		int columna = 0;
		for (int i=0 ; i < dimension ; i++) {
			for (String field : br.readLine().split(" ")) {
				if (field.equals("")) continue;
				distancias[fila][columna] = Integer.parseInt(field);
				columna++;
			}
			fila++;
			columna=0;
		}
		
	}
	
	private void parseLowerDiag(BufferedReader br, Integer dimension, String delimiter) throws IOException {
		int fila = 0;
		int columna = 0;
		String linea = "";
		while (fila < dimension) {
			linea = br.readLine().trim();
			while (!linea.equals("0")) {
				distancias[fila][columna] = Integer.parseInt(linea);
				distancias[columna][fila] = Integer.parseInt(linea);
				columna++;
				linea = br.readLine().trim();
			}
			if (linea.equals("0")) {
				distancias[fila][columna] = Integer.parseInt(linea);
				fila++;
				columna = 0;
			}
		}
	}
	
	private void parseSolution(BufferedReader br, Integer dimension) throws IOException {
		br.readLine(); // SOLUTION:
		int nodo, nodoAnterior;
		minDistancia = 0;
		for (int i=0 ; i<dimension+1 ; i++) {
			nodo = Integer.parseInt(br.readLine().trim());
			caminoMinimo.add(nodo);
			if (i>0) {
				nodoAnterior = caminoMinimo.get(i-1);
				minDistancia += distancias[nodoAnterior-1][nodo-1];
			}
		}
	}
}
