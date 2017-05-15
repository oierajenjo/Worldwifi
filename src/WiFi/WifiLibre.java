package WiFi;

import java.awt.image.BufferedImage;

public class WifiLibre extends Wifi implements Conectado, Desconectado, Cerca{
	protected BufferedImage icono;
	int distancia;
	
	
	
	public WifiLibre(String nombre, int intensidad, int x, int y, BufferedImage icono) {
		super(nombre, intensidad, x, y);
		this.icono = icono;
	}

	public BufferedImage getIcono() {
		return icono;
	}





	public void setIcono(BufferedImage icono) {
		this.icono = icono;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

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

	@Override
	public boolean cerca() {
		double distancia = Distancia();
		boolean cerca;
		if(distancia > 500) cerca = true;
		else cerca = false;
		return cerca;
	}

	
}
