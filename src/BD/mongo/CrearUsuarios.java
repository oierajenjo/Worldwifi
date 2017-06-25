package BD.mongo;

import org.json.JSONObject;


import Comun.*;
import BD.mongo.ConectarMongo;
import java.io.IOException;

public class CrearUsuarios {

	public CrearUsuarios() {
		
		
		
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
