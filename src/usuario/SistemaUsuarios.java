package usuario;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import usuario.Usuario;

@SuppressWarnings("serial")
public class SistemaUsuarios implements Serializable {

	public HashMap<String, Usuario> grupoUsuarios;
	public ArrayList<Usuario> usuariosLoggeados;
	
	public SistemaUsuarios(){
		this.grupoUsuarios = new HashMap<>();
		this.usuariosLoggeados = new ArrayList<>();
	}
	
	public boolean addNewUser( Usuario u ){
		String user = u.getUser();
		if( grupoUsuarios.containsKey(user)){
			return false;
		}
		else{
			grupoUsuarios.put( user, u);
			u.setFechaCreacion(System.currentTimeMillis());
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
		
		if (usuariosLoggeados.contains(u)){
			return false;
		}
		
		usuariosLoggeados.add(u);
		return true;
		
	}
	
	public boolean logout (String user){
		if (!grupoUsuarios.containsKey(user)){
			return false;
		}
		
		Usuario u = grupoUsuarios.get(user);
			
		if (!usuariosLoggeados.contains(user)){
			return false;
		}
		
		usuariosLoggeados.remove(u);
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
		   
		   for (Usuario u: usuariosLoggeados) {
			   loggedUsersList.add(u.getNombre());
			   
		}
		return loggedUsersList;
	   }
	   
	   
}
