package tp2.redes.flujo;

import java.util.List;

public class Proyecto {

	private Integer idProyecto;
	private Integer costo;
	private List<Integer> areasNecesarias;
	
	public Proyecto(Integer idProyecto, Integer costo, List<Integer> areasNecesarias){
		this.idProyecto = idProyecto;
		this.costo = costo;
		this.areasNecesarias = areasNecesarias;
	}

	public Integer getIdProyecto() {
		return idProyecto;
	}

	public void setIdProyecto(Integer idProyecto) {
		this.idProyecto = idProyecto;
	}

	public Integer getCosto() {
		return costo;
	}

	public void setCosto(Integer costo) {
		this.costo = costo;
	}

	public List<Integer> getAreasNecesarias() {
		return areasNecesarias;
	}

	public void setAreasNecesarias(List<Integer> areasNecesarias) {
		this.areasNecesarias = areasNecesarias;
	}
}
