package BD.mongo;

import org.json.JSONObject;


import Comun.*;
import BD.mongo.*;
import BD.mongo.ConectarMongo;
import java.io.IOException;

public class CrearUsuarios {

	public CrearUsuarios() {



	}
	
	@SuppressWarnings("deprecation")
	public static boolean authUser(String userName, char[] password) throws UserNotFoundException, AdminEditException{	
		try {
			return (new PasswordAuthentication().authenticate( userName, ConectarMongo.getPassword(userName)));
		} catch (common.exceptions.UserNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (common.exceptions.AdminEditException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	public static void createUserfromWindow(String text) {
		hacer
	}
	public static void main(String[] args) throws UserNotFoundException, IOException,
	InvalidNameException {

		String userList = "src/BD/mongo/sources/usuarios.json";
		JSONObject users = new JSONObject(TextFile.read(userList));
		for (Object o: users.getJSONArray("usuario")) {
			if (o instanceof JSONObject) {
				ConectarMongo.crearUsuario((JSONObject) o);
			}
		}
	}

}
