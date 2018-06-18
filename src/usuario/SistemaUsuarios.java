package usuario;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import usuario.Usuario;


@SuppressWarnings("serial")
public class SistemaUsuarios implements Serializable {

	public static HashMap<String, Usuario> grupoUsuarios;
	public ArrayList<Usuario> usuarios;

	public SistemaUsuarios(){
		SistemaUsuarios.grupoUsuarios = new HashMap<>();
		this.usuarios = new ArrayList<>();
	}

	public boolean addNewUser( Usuario u ){
		String user = u.getUser();
		if( grupoUsuarios.containsKey(user)){
			return false;
		}
		else{
			grupoUsuarios.put( user, u);
			return true;
		}
	}

	public boolean login (String user, String password){
		if (!grupoUsuarios.containsKey(user)){
			return false;
		}

		Usuario u = grupoUsuarios.get(user); 

		if (! u.getPassword().equals(password)){
			return false;
		}

		if (usuarios.contains(u)){
			return false;
		}

		usuarios.add(u);
		return true;

	}


	@SuppressWarnings("unlikely-arg-type")
	public boolean logout (String user){
		if (!grupoUsuarios.containsKey(user)){
			return false;
		}

		Usuario u = grupoUsuarios.get(user);

		if (!usuarios.contains(user)){
			return false;
		}

		usuarios.remove(u);
		return true;

	}

	public ArrayList<String> nicksList(){
		ArrayList<String> nicksList = new ArrayList<String>();

		for (Object nick: grupoUsuarios.keySet()) {
			nicksList.add((String) nick);
		}
		return nicksList;
	}

	public ArrayList<Usuario> usersList() {
		ArrayList<Usuario> userList = new ArrayList<Usuario>();

		for (Object n: grupoUsuarios.keySet()){

			userList.add(grupoUsuarios.get(n));
		}
		return userList;
	}

	public ArrayList<String> loggedUsersList(){
		ArrayList<String> loggedUsersList = new ArrayList<String>();

		for (Usuario u: usuarios) {
			loggedUsersList.add(u.getNombre());

		}
		return loggedUsersList;
	}
	public static HashMap<String, Usuario> getGrupoUsuarios() {
		return grupoUsuarios;
	}


}