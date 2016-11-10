package tp2.redes.flujo;

import java.util.List;

public class Proyecto {

	private Integer idProyecto;
	private Integer ganancia;
	private List<Area> areasNecesarias;
	
	public Proyecto(Integer idProyecto, Integer ganancia, List<Area> areasNecesarias){
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

	public Integer getGanancia() {
		return ganancia;
	}

	public void setGanancia(Integer ganancia) {
		this.ganancia = ganancia;
	}

	public List<Area> getAreasNecesarias() {
		return areasNecesarias;
	}

	public void setAreasNecesarias(List<Area> areasNecesarias) {
		this.areasNecesarias = areasNecesarias;
	}
}
