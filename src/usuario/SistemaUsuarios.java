package usuario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;
import usuario.Usuario;

public class SistemaUsuarios {
	public HashMap<String, Usuario> grupoUsuarios;
	public ArrayList<Usuario> usuariosLoggeados;
	
	public SistemaUsuarios(){
		this.grupoUsuarios = new HashMap<>();
		this.usuariosLoggeados = new ArrayList<>();
	}
	
	public boolean addNewUser( Usuario u ){
		String nick = u.getNombreUsuario();
		if( grupoUsuarios.containsKey(nick)){
			return false;
		}
		else{
			grupoUsuarios.put(nick, u);
			return true;
		}
	}

	public boolean login (String nick, String contrasenya){
		if (!grupoUsuarios.containsKey(nick)){
			return false;
		}
		
		Usuario u = grupoUsuarios.get(nick); 
		
		if (! u.getContrasenya().equals(contrasenya)){
			return false;
		}
		
		if (usuariosLoggeados.contains(u)){
			return false;
		}
		
		usuariosLoggeados.add(u);
		u.setFechaUltimoLogin(System.currentTimeMillis());
		return true;
		
	}
	
	public boolean logout (String nick){
		if (!grupoUsuarios.containsKey(nick)){
			return false;
		}
		
		Usuario u = grupoUsuarios.get(nick);
			
		if (!usuariosLoggeados.contains(nick)){
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
