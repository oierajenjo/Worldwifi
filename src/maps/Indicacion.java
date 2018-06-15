package maps;

public class Indicacion {

	public String tiempo;
	public String distancia;
	public String descripcion;
	public String la;
	public String lo;
	
	
	public Indicacion(String tiempo, String distancia, String descripcion, String la, String lo) {
		super();
		this.tiempo = tiempo;
		this.distancia = distancia;
		this.descripcion = descripcion;
		this.la = la;
		this.lo = lo;
	}
	
	public String getTiempo() {
		return tiempo;
	}
	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}
	public String getDistancia() {
		return distancia;
	}
	public void setDistancia(String distancia) {
		this.distancia = distancia;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getLa() {
		return la;
	}
	public void setLa(String la) {
		this.la = la;
	}
	public String getLo() {
		return lo;
	}
	public void setLo(String lo) {
		this.lo = lo;
	}

	@Override
	public String toString() {
		return "Indicacion [tiempo=" + tiempo + ", distancia=" + distancia + ", descripcion=" + descripcion + ", la="
				+ la + ", lo=" + lo + "]";
	}
	
	
	
}
