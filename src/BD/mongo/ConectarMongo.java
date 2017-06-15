package BD.mongo;
import com.mongodb.MongoClient;

import usuario.Usuario;
import usuario.Usuario.*;
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
//    private static final String ns = DocumentReader.getAttr(DocumentReader.getDoc("conf/properties.xml"),
//            "network", "mongodb-server", "host").getTextContent();
//    private static final int port = Integer.parseInt(DocumentReader.getAttr(DocumentReader.getDoc("conf/properties.xml"),
//            "network", "mongodb-server", "port").getTextContent());

   public static void main( String args[] ) {
	
      try{
		
         // To connect to mongodb server
         MongoClient mongoClient = new MongoClient( ns , port );
			
         // Now connect to your databases
         DB db = mongoClient.getDB( "test" );
         System.out.println("Connect to database successfully");
         boolean auth = db.authenticate(myUserName, myPassword);
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
		   FindIterable iterable = collection.find(new BasicDBObject("username", userName)); 
	   }
	   
	   
	   public static MongoCollection getCollection(){
		   MongoClient mongoClient = new MongoClient(ns, port);
		   MongoDatabase database = mongoClient.getDatabase("mydb");
		   MongoCollection<Document> collection = database.getCollection("test");
		   Document doc;
		   collection.insertOne(doc);
	   }
	   
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
	   
	   
	   public static void createUser(Usuario user)  {

	        /* lowercase usernames */
	        user.setUserName(user.getUserName().toLowerCase());
//	        UserAuthentication.checkAdmin(user.getUserName());
//	        UserAuthentication.isValidName(user.getUserName());

	        if (!userExists(user.getNombreUsuario())) {
	            MongoDatabase db = getUsersDB();
	            MongoCollection collection = db.getCollection(COLLECTION);
	            BasicDBObject doc = new BasicDBObject("username", user.getNombreUsuario())
	            		.append("nombre", user.getNombre())
	                    .append("apellido", user.getApellido())
	                    .append("fechaNacimiento", user.getFechaNacimiento())
	                    .append("correo", user.getCorreo())
	                    .append("numTelef", user.getNumTelef())
	                    .append("contrasenya", new String(user.getContrasenya()))
	                    .append("tipo", user.getTipo().toString());
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
	            throw new Exception(user.getNombreUsuario());
	        }
	    }
	   
	   
}


