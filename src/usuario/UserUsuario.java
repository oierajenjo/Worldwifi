package usuario;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class UserUsuario extends Usuario {
	private String userName;
	private String userPassword;
	
	

	
	public UserUsuario( String id, String user, String password, String nombre, String apellidos, long nacimiento, String email,
			String ciudad, String twitter, String facebook, ArrayList<Amigo> amigos, long fechaCreacion,
			TipoUsuario tipo) {
		super(id, user, password, nombre, apellidos, nacimiento, email, ciudad,  
				twitter, facebook, amigos, fechaCreacion, tipo);
		this.userName = user;
		this.userPassword = password;
	}
	
	
	public String getNickName() {
		return userName;
	}
	public void setNickName(String nickName) {
		this.userName = nickName;
	}
	public String getNickContrasenya() {
		return userPassword;
	}
	public void setNickContrasenya(String nickContrasenya) {
		this.userPassword = nickContrasenya;
	}
	
	
	
	
	
	
}
