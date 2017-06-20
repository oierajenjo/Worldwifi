package BD.mongo;
import com.mongodb.MongoClient;


import Comun.*;
import usuario.TipoUsuario;
import usuario.Usuario;
import com.mongodb.client.MongoCollection;
import com.mongodb.MongoCommandException;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.result.DeleteResult;
import static com.mongodb.client.model.Updates.*;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.List;
import com.mongodb.ServerAddress;
import java.util.Arrays;
import java.util.Collection;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConectarMongo {
	private static final Logger LOG = Logger.getLogger(ConectarMongo.class.getName());
    private static String COLLECTION = "users";
    private static final String ns = DocumentReader.getAttr(DocumentReader.getDoc("conf/properties.xml"),
            "network", "mongodb-server", "host").getTextContent();
    private static final int port = Integer.parseInt(DocumentReader.getAttr(DocumentReader.getDoc("conf/properties.xml"),
            "network", "mongodb-server", "port").getTextContent());

   public static void main( String args[] ) {
	
      try{
		
         // To connect to mongodb server
         MongoClient mongoClient = new MongoClient( ns , port );
			
         // Now connect to your databases
         DB db = mongoClient.getDB( "test" );
         System.out.println("Connect to database successfully");
         boolean auth = db.authenticate(user, password);
         System.out.println("Authentication: "+auth);
			
      }catch(Exception e){
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      }
   }

   
	   private static MongoDatabase getUsersDB(){
	       MongoClient mongoClient = new MongoClient(ns, port);
	       MongoDatabase db = mongoClient.getDatabase(COLLECTION);
	       try {
	           db.createCollection(COLLECTION);
	       } catch (MongoCommandException e) {
	           /* Database is already created */
	       }
	       return db;
	   }
	   
	   public void coseguirUsuarios(){
		   MongoDatabase db = getUsersDB();
		   MongoCollection collection = db.getCollection(COLLECTION);
		   FindIterable iterable = collection.find(new BasicDBObject("username", user)); 
	   }
//	   public static void changePassword(Usuario usuario)
//	            throws UserNotFoundException, IncorrectPasswordException, AdminEditException {
//
//	        userName = usuario.getUser();
//	        AutentificarUsuario.checkAdmin(userName);
//
//	        if(userExists(userName)) {
//	            if (getUser(userName).get("password").equals(oldPassword)) {
//	                MongoDatabase db = getUsersDB();
//	                MongoCollection collection = db.getCollection(COLLECTION);
//	                collection.updateMany(
//	                        new BasicDBObject("username", userName),
//	                        new BasicDBObject("$set",
//	                                new BasicDBObject("password", newPassword)
//	                        )
//	                );
//	                LOG.log(Level.INFO, "Changed password of user `" + userName +  "`.");
//	            } else {
//	                throw new IncorrectPasswordException(userName);
//	            }
//	        } else {
//	            throw new UserNotFoundException(userName);
//	        }
//	    }
//
//	   
//	   public static void changePassword(String userName, char[] oldPassword, char[] newPassword)
//	            throws UserNotFoundException, IncorrectPasswordException, AdminEditException {
//	        changePassword(userName, new String(oldPassword), new String(newPassword));
//	    }
	  
	   
	   public static void createUser(Document user) {
	       MongoDatabase db = getUsersDB();
	       MongoCollection collection = db.getCollection(COLLECTION);
	       collection.insertOne(user);
	   }
	   
	   public static void printCollection(MongoCollection collection){
		   Document myDoc = (Document) (collection).find().first();
		   System.out.println(myDoc.toJson());
	   }
	   
	   public static void actualizarDoc (MongoCollection collection){
	   collection.updateOne(eq("i", 10), new Document("$set", new Document("i", 110)));
	   }
	   
	   
	   public static void createUser(Usuario user) throws NewUserExistsException  {

	        /* lowercase usernames */
	        user.setUser(user.getUser().toLowerCase());
//	        UserAuthentication.checkAdmin(user.getUserName());
//	        UserAuthentication.isValidName(user.getUserName());


	    	
	        if (!userExists(user.getUser())) {
	            MongoDatabase db = getUsersDB();
	            MongoCollection collection = db.getCollection(COLLECTION);
	            BasicDBObject doc = new BasicDBObject("username", user.getUser())
	            		.append("id", user.getId())
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
	                    .append("tipo", user.getTipo().toString())
	            		.append("fechaUltimoLogin", user.getFechaUltimoLogin());
	            collection.insertOne(Document.parse(doc.toJson()));
	            StringBuilder logInfo = new StringBuilder();
	            int i = 1;
	            for(String key: doc.keySet()) {
	                logInfo.append("\n").append(key).append(": '").append(doc.get(key)).append("'");
	                if (i < doc.size()) {
	                    logInfo.append(",");
	                }
	                i++;
	            }
	            LOG.log(Level.INFO, "New user created:" + logInfo);
	        } else {
	        	throw new NewUserExistsException(user.getUser());
	        }
	    }
	   
	   public static boolean userExists(String userName){
		   userName = userName.toLowerCase();
		   
		   MongoDatabase db = getUsersDB();
		   MongoCollection collection = db.getCollection(COLLECTION);
		   BasicDBObject query = new BasicDBObject();
		   query.put("username", userName);
		   
		   return collection.count(query) != 0;
	   }
	   
	   
}

