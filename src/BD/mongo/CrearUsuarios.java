package BD.mongo;

import org.json.JSONObject;
import Comun.*;

import BD.mongo.ConectarMongo;
import java.io.IOException;

public class CrearUsuarios {

	public CrearUsuarios() {

	}
//	PrimitiveValue texto = (PrimitiveValue) fv.getFactSlot("pregunta");
//	theText = texto.toString();
//	theText.replaceAll("""", "");
	
	@SuppressWarnings("deprecation")
	public static boolean authUser(String userName, char[] password) throws UserNotFoundException, AdminEditException{	
		try {
			return (new PasswordAuthentication().authenticate( userName.replaceAll("\"", ""), ConectarMongo.getPassword( userName.replaceAll("\"", "")).toString().replaceAll("\"", "")));
		} catch (UserNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (AdminEditException e) {
			e.printStackTrace();
			return false;
		}
		
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
