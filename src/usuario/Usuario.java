package usuario;

import java.io.Serializable;
import java.util.*;



public class Usuario implements Serializable {

	private static final long serialVersionUID = 8119678942285632886L;

	
	private String user;
	private char[] password;
	private String nombre;
	private String apellidos;
	private long nacimiento;
	private String email;
	private String ciudad;
	private String twitter;
	private String facebook;
	private ArrayList<Usuario> amigos;
	private String fechaCreacion;
	private TipoUsuario tipo;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public char[] getPassword() {
		return password;
	}
	public void setPassword(char[] password) {
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
	public long getNacimiento() {
		return nacimiento;
	}
	public void setNacimiento(long nacimiento) {
		this.nacimiento = nacimiento;
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
	public ArrayList<Usuario> getAmigos() {
		return amigos;
	}
	public void setAmigos(ArrayList<Usuario> amigos) {
		this.amigos = amigos;
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
	public String getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public TipoUsuario getTipo() {
		return tipo;
	}
	public void setTipo(TipoUsuario tipo) {
		this.tipo = tipo;
	}
	/** Constructor principal de usuario
	 * @param user
	 * @param password
	 * @param nombre
	 * @param apellidos
	 * @param telefono
	 * @param tipo
	 * @param email
	 */
	
	public Usuario(String user, char[] password, String nombre, String apellidos, long nacimiento, String email,
			String ciudad, String twitter, String facebook, ArrayList<Usuario> amigos, String fechaCreacion,
			TipoUsuario tipo) {
		super();
		this.user = user;
		this.password = password;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nacimiento = nacimiento;
		this.email = email;
		this.ciudad = ciudad;
		this.twitter = twitter;
		this.facebook = facebook;
		this.amigos = amigos;
		this.fechaCreacion = fechaCreacion;
		this.tipo = tipo;
	}
}
