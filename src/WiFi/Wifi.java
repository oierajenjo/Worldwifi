package WiFi;


public class Wifi {

	protected String id;
	protected Double latitud;
	protected Double longitud;
	protected Long x;
	protected Long y;

	public Wifi(String id, Double latitud, Double longitud, Long x, Long y) {
		super();
		this.id = id;
		this.latitud = latitud;
		this.longitud = longitud;
		this.x = x;
		this.y = y;
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

	public Long getX() {
		return x;
	}

	public void setX(Long x) {
		this.x = x;
	}

	public Long getY() {
		return y;
	}

	public void setY(Long y) {
		this.y = y;
	}

	@Override
	public String toString() {
		
		return "";
	}


}
