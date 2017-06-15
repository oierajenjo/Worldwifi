package usuario;

import javafx.scene.chart.PieChart.Data;


public class Usuario {

	private String nombreUsuario;
	private String nombre;
	private String apellido;
	private int numTelef;//opcional
	private Data fechaNacimiento;
	private String correo;
	private String contrasenya;
	private String repiteContrasenya;
	private String twitter;
	private String facebook;
	private TipoUsuario tipo;
	private long fechaUltimoLogin;
	

	public Usuario(String nombreUsuario, String nombre, String apellido, int numTelef, Data fechaNacimiento,
			String correo, String contrasenya, String repiteContrasenya, String twitter, String facebook,
			TipoUsuario tipo, long fechaUltimoLogin) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.numTelef = numTelef;
		this.fechaNacimiento = fechaNacimiento;
		this.correo = correo;
		this.contrasenya = contrasenya;
		this.repiteContrasenya = repiteContrasenya;
		this.twitter = twitter;
		this.facebook = facebook;
		this.tipo = tipo;
		this.fechaUltimoLogin = fechaUltimoLogin;
	}

	


	public long getFechaUltimoLogin() {
		return fechaUltimoLogin;
	}




	public void setFechaUltimoLogin(long fechaUltimoLogin) {
		this.fechaUltimoLogin = fechaUltimoLogin;
	}




	public TipoUsuario getTipo() {
		return tipo;
	}



	public void setTipo(TipoUsuario tipo) {
		this.tipo = tipo;
	}



	public String getNombreUsuario() {
		return nombreUsuario;
	}



	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApellido() {
		return apellido;
	}



	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



	public int getNumTelef() {
		return numTelef;
	}



	public void setNumTelef(int numTelef) {
		this.numTelef = numTelef;
	}



	public Data getFechaNacimiento() {
		return fechaNacimiento;
	}



	public void setFechaNacimiento(Data fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
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



	public String getRepiteContrasenya() {
		return repiteContrasenya;
	}



	public void setRepiteContrasenya(String repiteContrasenya) {
		this.repiteContrasenya = repiteContrasenya;
	}



	public String getTwitter() {
		return twitter;
	}



	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}



	public String getFacebook() {
		return facebook;
	}



	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
