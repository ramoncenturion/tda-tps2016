package tp2.redes.flujo;

import java.util.List;

public class Proyecto {

	private Integer idProyecto;
	private Integer ganancia;
	private List<Integer> areasNecesarias;
	
	public Proyecto(Integer idProyecto, Integer ganancia, List<Integer> areasNecesarias){
		this.idProyecto = idProyecto;
		this.ganancia = ganancia;
		this.areasNecesarias = areasNecesarias;
	}

	public Integer getIdProyecto() {
		return idProyecto;
	}

	public void setIdProyecto(Integer idProyecto) {
		this.idProyecto = idProyecto;
	}

	public Integer getganancia() {
		return ganancia;
	}

	public void setganancia(Integer ganancia) {
		this.ganancia = ganancia;
	}

	public List<Integer> getAreasNecesarias() {
		return areasNecesarias;
	}

	public void setAreasNecesarias(List<Integer> areasNecesarias) {
		this.areasNecesarias = areasNecesarias;
	}
}
