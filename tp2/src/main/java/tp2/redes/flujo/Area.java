package tp2.redes.flujo;

public class Area {

	private Integer id;
	private Integer costo;
	
	public Area(Integer idArea, Integer costo){
		this.id = idArea;
		this.costo = costo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCosto() {
		return costo;
	}

	public void setCosto(Integer costo) {
		this.costo = costo;
	}
}
