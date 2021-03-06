package BD.mongo;
import com.mongodb.MongoClient;
import Comun.*;
import usuario.Usuario;
import com.mongodb.client.MongoCollection;
import com.mongodb.MongoCommandException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import com.mongodb.DB;
import com.mongodb.BasicDBObject;
import org.bson.Document;
import org.json.JSONObject;

import static com.mongodb.client.model.Filters.*;

public class ConectarMongo {

	@SuppressWarnings({ "deprecation", "resource", "unused" })
	public static void main( String args[] ) {

		try{

			// To connect to mongodb server
			MongoClient mongoClient = new MongoClient( "localhost", 27890 );

			// Now connect to your databases
			DB db = mongoClient.getDB( "Usuarios" );
			System.out.println("Connect to database successfully");
			//         boolean auth = ((Object) db).authenticate("", "");//tu usuario y contraseņa
			//         System.out.println("Authentication: "+auth);

		}catch(Exception e){
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		}
	}


	@SuppressWarnings("resource")
	private static MongoDatabase getUsersDB(){
		MongoClient mongoClient = new MongoClient("localhost", 27890);
		MongoDatabase db = mongoClient.getDatabase("Usuarios");
		try {
			db.createCollection("usuario");
		} catch (MongoCommandException e) {
			/* Database is already created */
		}
		return db;
	}
	@SuppressWarnings("rawtypes")
	public static Document getUser(String userName) throws UserNotFoundException {

		/* lowercase usernames */
		userName = userName.toLowerCase();
		MongoDatabase db = getUsersDB();
		MongoCollection collection = db.getCollection("src/BD/mongo/sources/usuarios.json");
		FindIterable iterable = collection.find(new BasicDBObject("username", userName));
		for (Object o: iterable) {
			if (o instanceof Document) {
				if(((Document) o).get("username").equals(userName)) {
					return (Document) o;
				}
			}
		}
		throw new UserNotFoundException(userName);
	}

	@SuppressWarnings({ "rawtypes", "unused" })
	public void coseguirUsuarios(String user){
		MongoDatabase db = getUsersDB();
		MongoCollection collection = db.getCollection("usuario");
		FindIterable iterable = collection.find(new BasicDBObject("username", user)); 
	}

	public static char[] getPassword(String userName) throws UserNotFoundException, AdminEditException {
		userName = userName.toLowerCase();
		if (!userExists(userName)) {
			throw new UserNotFoundException("User " + userName + "not found.");
		}
		Document user = getUser(userName);
		return ((String) user.get("password")).toCharArray();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void createUser(Document user) {
		MongoDatabase db = getUsersDB();
		MongoCollection collection = db.getCollection("usuario");
		collection.insertOne(user);
	}
	@SuppressWarnings("rawtypes")
	public static void printCollection( MongoCollection collection){
		Document myDoc = (Document) (collection).find().first();
		System.out.println(myDoc.toJson());
	}
	@SuppressWarnings("rawtypes")
	public static void actualizarDoc ( MongoCollection collection){
		collection.updateOne(eq("i", 10), new Document("$set", new Document("i", 110)));
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void crearUsuario (JSONObject ousuario){
		MongoDatabase db = getUsersDB();
		MongoCollection collection = db.getCollection("usuario");
		collection.insertOne(Document.parse(ousuario.toString()));
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void createUser(Usuario user) throws NewUserExistsException  {

		if (!userExists(user.getUser())) {
			MongoDatabase db = getUsersDB();
			MongoCollection collection = db.getCollection("usuario");
			BasicDBObject doc = new BasicDBObject("username", user.getUser())
					.append("password", new String(user.getPassword()))
					.append("nombre", user.getNombre())
					.append("apellidos", user.getApellidos())
					.append("nacimiento", user.getNacimiento())
					.append("email", user.getEmail())
					.append("ciudad", user.getCiudad())
					.append("twitter", user.getTwitter())
					.append("facebook", user.getFacebook())
					.append("amigos", user.getAmigos())
					.append("fechaCreacion", user.getFechaCreacion())
					.append("tipo", user.getTipo().toString());
			collection.insertOne(Document.parse(doc.toJson()));
		}else {
			throw new NewUserExistsException(user.getUser());
		}
	}

	@SuppressWarnings("rawtypes")
	public static boolean userExists(String userName){
		userName = userName.toLowerCase();

		MongoDatabase db = getUsersDB();
		MongoCollection collection = db.getCollection("usuario");
		BasicDBObject query = new BasicDBObject();
		query.put("usuario", userName);

		return collection.count(query) != 0;
	}
}

