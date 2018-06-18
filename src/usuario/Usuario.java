package usuario;

import java.io.Serializable;



public class Usuario implements Serializable {

	private static final long serialVersionUID = 8119678942285632886L;

	
	private String user;
	private String password;
	private String nombre;
	private String apellidos;
	private String email;
	private String ciudad;
	private String twitter;
	private String facebook;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
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
//	public String getAmigoString() {
//		String amigo = "";
//		for (Usuario usuario: amigos) {
//			amigo += usuario.id + ": " + usuario.user;
//			if (!amigos.get(amigos.size() - 1).equals(usuario)) {
//				amigo += ",\r\n";
//			}
//		}
//		return amigo;
//	}
	
	
	/** Constructor principal de usuario
	 * @param user
	 * @param password
	 * @param nombre
	 * @param apellidos
	 * @param telefono
	 * @param tipo
	 * @param email
	 */
	
	public Usuario(String user, String password, String nombre, String apellidos, String email,
			String ciudad, String twitter, String facebook) {
		this.user = user;
		this.password = password;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.ciudad = ciudad;
		this.twitter = twitter;
		this.facebook = facebook;
	}
	
	
	@Override
	public String toString() {
		return user + "/;" + password + "/;" + nombre
				+ "/;" + apellidos + "/;" + email + "/;" + ciudad + "/;" + twitter
				+ "/_;" + facebook + "/n";
	}
	
	
}