package usuario;

import java.util.ArrayList;
import java.util.HashMap;

public class Amigo {
	public HashMap<String, Amigo> grupoAmigos;
	public ArrayList<Usuario> Amigo;
	
	public Amigo(){
		this.grupoAmigos = new HashMap<>();
		this.Amigo = new ArrayList<>();
	}
	public Amigo(HashMap<String, Amigo> grupoAmigos, ArrayList<Usuario> amigo) {
		super();
		this.grupoAmigos = grupoAmigos;
		Amigo = amigo;
	}
	public HashMap<String, Amigo> getGrupoAmigos() {
		return grupoAmigos;
	}
	public void setGrupoAmigos(HashMap<String, Amigo> grupoAmigos) {
		this.grupoAmigos = grupoAmigos;
	}
	public ArrayList<Usuario> getAmigo() {
		return Amigo;
	}
	public void setAmigo(ArrayList<Usuario> amigo) {
		Amigo = amigo;
		
	} 
	
	
	
}
