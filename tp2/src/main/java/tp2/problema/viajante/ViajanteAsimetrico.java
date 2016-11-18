package tp2.problema.viajante;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ViajanteAsimetrico {
	private Integer[][] distancias;
	private Integer cantNodos;
	private Integer inicio;
	private List<Integer> caminoMinimo;
	private Integer minDistancia;
	private List<Map<Long,Integer>> distanciaMinimaPD;
		
	public ViajanteAsimetrico(Integer inicio, Integer[][] distancias) {
		this.inicio = inicio-1;
		this.distancias = distancias;
		this.cantNodos = distancias.length;
		this.caminoMinimo = new ArrayList<Integer>();
		this.distanciaMinimaPD = new ArrayList<>(this.cantNodos);
		
		long mask = (long)Math.pow(2,cantNodos)-1;
		
		Set<Integer> S = new HashSet<>();
		
		for (Integer i = 0; i < this.cantNodos; i++) {
			distanciaMinimaPD.add(new HashMap<>());
			if(i.equals(this.inicio)) {
				mask &= ~(1 << i);
			} else {
				S.add(i);
			}
		}
		
		this.minDistancia = heldKarp(this.inicio, mask, S);
		generarCamino(mask, S);
	}
	
	public Integer getDistanciaMinima() {
		return minDistancia;
	}
	
	public List<Integer> getCaminoMinimo() {
		return caminoMinimo;
	}
	
	private Integer heldKarp(Integer nodo, long mask, Set<Integer> S) {
		if (S.size() == 0) {			
			return distancias[inicio][nodo];			
		} else {
			Integer min = Integer.MAX_VALUE;

			for (Integer u : S) {
				Set<Integer> S_u = new HashSet<Integer>(S);
				S_u.remove(u);
				long mask_u = mask & ~(1 << u);
				
				Integer distance_u;
				if ((distance_u = distanciaMinimaPD.get(u).get(mask_u)) == null ) {
					distance_u = heldKarp(u,mask_u,S_u);
					distanciaMinimaPD.get(u).put(mask_u, distance_u);
				}
				min = Math.min(min, distancias[u][nodo] + distance_u);
			}
			
			return min;
		}
	}

	private void generarCamino(long mask, Set<Integer> S) { // O(V*(V-1) /2) = O(V^2)
		caminoMinimo.add(inicio +1);
		Integer nodo = inicio;
		while ( !S.isEmpty() ) {
			Integer min = Integer.MAX_VALUE;
			Integer proximoNodo = nodo;
			
			for (Integer u : S) {
				Set<Integer> S_u = new HashSet<Integer>(S);
				S_u.remove(u);
				long mask_u = mask & ~(1 << u);
				Integer uDistance = distanciaMinimaPD.get(u).get(mask_u);
				if ( min > distancias[u][nodo] + uDistance){
					proximoNodo = u;
					min = distancias[u][nodo] + uDistance;
				}
			}
			
			caminoMinimo.add(proximoNodo+1);
			nodo = proximoNodo;
			S.remove(proximoNodo);
			mask &= ~(1 << proximoNodo);
		}
		
		caminoMinimo.add(inicio+1);
	}
	
	public Integer recalcularDistanciaMinima() { // O(V)
		Integer distance = 0;
		for (int i = 1; i < caminoMinimo.size() ; i++) {
			distance += distancias[caminoMinimo.get(i)-1][caminoMinimo.get(i-1)-1];
		}
		return distance;
	}
}
