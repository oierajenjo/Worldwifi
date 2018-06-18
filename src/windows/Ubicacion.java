package windows;

public class Ubicacion {
    
    public double latitud=0.0;
    public double longitud=0.0;
    public String direccion;

    public Ubicacion() {
    	super();
	}
    
    public Ubicacion(double latitud, double longitud, String direccion) {
		super();
		this.latitud = latitud;
		this.longitud = longitud;
		this.direccion = direccion;
	}

	public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setLatitud(double aLatitud) {
        latitud = aLatitud;
    }

    public void setLongitud(double aLongitud) {
        longitud = aLongitud;
    }

    public void setDireccion(String aDireccion) {
        direccion = aDireccion;
    }

	@Override
	public String toString() {
		return "Ubicacion [latitud=" + latitud + ", longitud=" + longitud + ", direccion=" + direccion + "]";
	}
    
    
}
