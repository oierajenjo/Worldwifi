package WiFi;


public class Wifi {

	protected String id;
	protected Double latitud;
	protected Double longitud;
	
	
	public Wifi() {
		super();
	}
	
	public Wifi(String id, Double latitud, Double longitud) {
		super();
		this.id = id;
		this.latitud = latitud;
		this.longitud = longitud;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Double getLatitud() {
		return latitud;
	}

	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}

	public Double getLongitud() {
		return longitud;
	}

	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}

	@Override
	public String toString() {
		return "Wifi [id=" + id + ", latitud=" + latitud + ", longitud=" + longitud + "]";
	}




}
