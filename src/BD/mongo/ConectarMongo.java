package BD.mongo;
import com.mongodb.*;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.bson.Document;

import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.result.DeleteResult;
import static com.mongodb.client.model.Updates.*;
import com.mongodb.client.result.UpdateResult;
import com.mongodb.diagnostics.logging.Logger;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.ServerAddress;
import java.util.Arrays;
import java.util.Collection;

public class ConectarMongo {
	
	private static final Logger LOG = Logger.getLogger(MongoDB.class.getName());
    private static String COLLECTION = "users";
    private static final String ns = DocumentReader.getAttr(DocumentReader.getDoc("conf/properties.xml"),
            "network", "mongodb-server", "host").getTextContent();
    private static final int port = Integer.parseInt(DocumentReader.getAttr(DocumentReader.getDoc("conf/properties.xml"),
            "network", "mongodb-server", "port").getTextContent());

   public static void main( String args[] ) {
	
      try{
		
         // To connect to mongodb server
         MongoClient mongoClient = new MongoClient( ns ,  );
			
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
}