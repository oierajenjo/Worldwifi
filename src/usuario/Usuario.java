package usuario;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;


public class Usuario implements Serializable {

	private static final long serialVersionUID = 8119678942285632886L;

	private String id;
	private String user;
	private String password;
	private String nombre;
	private String apellidos;
	private long nacimiento;
	private String email;
	private String ciudad;
	private String twitter;
	private String facebook;
	private ArrayList<Usuario> amigos;
	private long fechaCreacion;
	private TipoUsuario tipo;
	private long fechaUltimoLogin;

	public void setId(String id) {
		this.id = id;
	}
	public ArrayList<Usuario> getAmigos() {
		return amigos;
	}
	public void setAmigos(ArrayList<Usuario> amigos) {
		this.amigos = amigos;
	}
	public long getFechaUltimoLogin() {
		return fechaUltimoLogin;
	}
	public void setFechaUltimoLogin(long fechaUltimoLogin) {
		this.fechaUltimoLogin = fechaUltimoLogin;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getId() {
		return id;
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
	public ArrayList<Usuario> getAmigo() {
		return amigos;
	}
	public void setAmigo(ArrayList<Usuario> amigos) {
		this.amigos = amigos;
	}
//	public String getAmigo() {
//		ArrayList<Amigo> ret;
//		if (amigos.size()>0) ret = amigos.get(0);
//		for (String i=1; i<amigos.size(); i++) ret (", " + amigos.get(i));
//		return ret;
//	}
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
	public long getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(long fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public TipoUsuario getTipo() {
		return tipo;
	}
	public void setTipo(TipoUsuario tipo) {
		this.tipo = tipo;
	}
	/** Constructor privado, sólo para uso Stringerno
	 */
	private Usuario() {
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
	
	public Usuario(String id, String user, String password, String nombre, String apellidos, long nacimiento, String email,
			String ciudad, String twitter, String facebook, ArrayList<Usuario> amigos, long fechaCreacion,
			TipoUsuario tipo) {
		super();
		this.id = id;
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
	/** Constructor de usuario recibiendo los email como una lista de parámetros de tipo String
	 * @param user
	 * @param password
	 * @param nombre
	 * @param apellidos
	 * @param telefono
	 * @param tipo
	 * @param email
	 * @param 
	 */
	
	public Usuario(String id, String user, String password, String nombre, String apellidos, long nacimiento, String email,
			String ciudad, String twitter, String facebook, Usuario amigos, long fechaCreacion, TipoUsuario tipo ) {
		this(id, user, password, nombre, apellidos, nacimiento, email, ciudad, twitter, facebook, new ArrayList<Usuario>(),
			fechaCreacion, tipo);
	}
	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", user=" + user + ", password=" + password + ", nombre=" + nombre + ", apellidos="
				+ apellidos + ", nacimiento=" + nacimiento + ", email=" + email + ", ciudad=" + ciudad + ", twitter="
				+ twitter + ", facebook=" + facebook + ", fechaCreacion=" + fechaCreacion + ", tipo=" + tipo + "]";
	}


	
	/** Devuelve los datos del usuario en una línea separados por comas<p>
	 * Formato: user,password,nombre,apellidos,telefono,fechaCreacion(msgs.),tipo,email1,email2...
	 * @return	Línea con los datos formateados
	 */
	public String aLinea() {
		String ret = user + "," + password + "," + nombre + "," + apellidos + "," +
			 "," + fechaCreacion + "," + tipo + "," + email;
		return ret;
	}


	/** Crea y devuelve un nuevo Usuario partiendo de los datos de una línea separados por comas
	 * Formato: user,password,nombre,apellidos,telefono,fechaCreacion(msgs.),tipo,email1,email2...
	 * @param linea	Línea de texto
	 * @return	Usuario creado partiendo de la línea, null si hay cualquier error
	 */
	public static Usuario crearDeLinea( String linea ) {
		Usuario u = new Usuario();
		StringTokenizer st = new StringTokenizer( linea, "," );
		try {
			u.id = st.nextToken();
			u.user = st.nextToken();
			u.password = st.nextToken();
			u.nombre = st.nextToken();
			u.apellidos = st.nextToken();
			u.nacimiento = Long.parseLong( st.nextToken() );
			u.fechaCreacion = Long.parseLong( st.nextToken() );
			u.tipo = TipoUsuario.valueOf( st.nextToken() );
			u.email = st.nextToken();
			u.amigos = new ArrayList<Usuario>();
			while (st.hasMoreTokens()) {
				
				u.amigos.add( st.nextToken() );
			}
			return u;
			
		} catch (NoSuchElementException e) {  // Error en datos insuficientes (faltan campos)
			return null;
		} catch (NumberFormatException e) {  // Error en tipo long de telefono o fechaLogin
			return null;
		} catch (IllegalArgumentException e) {  // Error en tipo usuario (enumerado)
			return null;
		} catch (Exception e) {  // Cualquier otro error
			return null;
		}
		return u;
	}

	/** main de prueba
	 * @param s	Parámetros estándar (no se utilizan)
	 */
	public static void main( String[] s ) {
//		Usuario u = new Usuario( "buzz", "#9abbf", "Buzz", "Lightyear", 101202303, TipoUsuario.Admin, "buzz@gmail.com", "amigo.de.woody@gmail.com" );
//		u.getListaEmails().add( "buzz@hotmail.com" );
//		// String ape = u.getApellidos(); ape = "Apellido falso";  // esto no cambia nada
//		System.out.println( u );
	}


}
