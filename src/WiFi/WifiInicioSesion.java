package WiFi;

import java.awt.image.BufferedImage;

public class WifiInicioSesion extends Wifi implements Conectado, Desconectado, Cerca, CorreoContrasenyaPredet {
	private String correo;
	private String contrasenya;
	protected BufferedImage icono;
	
	
	public WifiInicioSesion(String nombre, int intensidad, int x, int y, String correoPredeterminado,
			String contrasenyaPredeterminada, BufferedImage icono) {
		super(nombre, intensidad, x, y);
		this.correo = correoPredeterminado;
		this.contrasenya = contrasenyaPredeterminada;
		this.icono = icono;
	}


	
	public String getCorreo() {
		return correo;
	}

	
	
	public void setCorreo(String correo) {
		this.correo = correo;
	}




	public String getContrasenya() {
		return contrasenya;
	}




	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}




	public BufferedImage getIcono() {
		return icono;
	}




	public void setIcono(BufferedImage icono) {
		this.icono = icono;
	}




	public static void main(String[] args) {
		
	}



	@Override
	public String guardarCorrePredet() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public String usarCorreoPredet() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public boolean cerca() {
		double distancia = Distancia();
		boolean cerca;
		if(distancia > 500) cerca = true;
		else cerca = false;
		return cerca;
	}


	@Override
	public boolean desconectado() {
		boolean conectado = conectado();
		boolean desconectado = (Boolean) null;
		if (conectado = false){
			while(conectado = false){
				desconectado =true;
			}
		}else desconectado = false;
		return desconectado;
	}



	@Override
	public boolean conectado() {
		boolean conectado = getConexion();
		return conectado;
	}



}
