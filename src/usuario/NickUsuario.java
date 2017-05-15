package usuario;

import javafx.scene.chart.PieChart.Data;

public class NickUsuario extends Usuario {
	private String nickName;
	private String nickContrasenya;
	
	

	
	public NickUsuario(String nombreUsuario, String nombre, String apellido, int numTelef, Data fechaNacimiento,
			String correo, String contrasenya, String repiteContrasenya, String twitter, String facebook,
			TipoUsuario tipo, long fechaUltimoLogin, String nickName, String nickContrasenya) {
		super(nombreUsuario, nombre, apellido, numTelef, fechaNacimiento, correo, contrasenya, repiteContrasenya,
				twitter, facebook, tipo, fechaUltimoLogin);
		this.nickName = nickName;
		this.nickContrasenya = nickContrasenya;
	}
	
	
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getNickContrasenya() {
		return nickContrasenya;
	}
	public void setNickContrasenya(String nickContrasenya) {
		this.nickContrasenya = nickContrasenya;
	}
	
	
	
	
	
	
}
