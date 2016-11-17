package tp2.problema.viajante;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ViajanteAsimetricoParser {

	private Integer[][] distancias;
	
	public ViajanteAsimetricoParser(String filename) throws IOException {
		parseFile(filename);
	}
	
	public Integer[][] getMatrix() {
		return this.distancias;
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
		
		this.distancias = new Integer[dimension][dimension];
		
		if (format.trim().equals("FULL_MATRIX")) {
			parseFullMatrix(br, dimension, delimiter);
		} else if (format.trim().equals("LOWER_DIAG_ROW")) {
			parseLowerDiag(br, dimension, delimiter);
		}
	}
	
	private void parseFullMatrix(BufferedReader br, Integer dimension, String delimiter) throws IOException {
		int fila = 0;
		int columna = 0;
		for (int i=0 ; i < dimension ; i++) {
			for (String field : br.readLine().split(" ")) {
				if (field.equals("")) continue;
				this.distancias[fila][columna] = Integer.parseInt(field);
				columna++;
			}
			fila++;
		}
		
	}
	
	private void parseLowerDiag(BufferedReader br, Integer dimension, String delimiter) throws IOException {
		int fila = 0;
		int columna = 0;
		String linea = "";
		while (!linea.trim().equals("SOLUTION") && fila < dimension) {
			linea = br.readLine().trim();
			while (!linea.equals("SOLUTION") && !linea.equals("0")) {
				this.distancias[fila][columna] = Integer.parseInt(linea);
				this.distancias[columna][fila] = Integer.parseInt(linea);
				columna++;
				linea = br.readLine().trim();
			}
			if (linea.equals("0")) {
				this.distancias[fila][columna] = Integer.parseInt(linea);
				fila++;
				columna = 0;
			}
		}
	}
}
