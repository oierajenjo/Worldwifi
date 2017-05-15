package WiFi;

import java.awt.image.BufferedImage;

public class WifiContrasenya extends Wifi implements Conectado, Desconectado, Cerca, ContrasenyaCorrecta, ContrasenyaErronea{
	private String contrasenya;
	protected BufferedImage icono;
	
	public WifiContrasenya(String nombre, int intensidad, int x, int y, String contrasenya, BufferedImage icono) {
		super(nombre, intensidad, x, y);
		this.contrasenya = contrasenya;
		this.icono = icono;
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
	public boolean contrasenyaErronea() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contrasenyaCorrecta() {
		
		
		return false;
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
