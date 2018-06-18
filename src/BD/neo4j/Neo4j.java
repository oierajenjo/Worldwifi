package BD.neo4j;
import org.neo4j.driver.v1.*;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;



import Comun.DocumentReader;
import WiFi.Wifi;
import java.util.ArrayList;
import static org.neo4j.driver.v1.Values.parameters;

public class Neo4j {
	/* Logger for Neo4j */
	//	private static final java.util.logging.Logger LOG = java.util.logging.Logger.getLogger(Neo4j.class.getName());
	//	static {
	//		try {
	//			LOG.addHandler(new FileHandler(
	//					"logs/" + Neo4j.class.getName() + "." +
	//							DateUtils.currentFormattedDate() + ".log.xml", true));
	//		} catch (SecurityException | IOException e) {
	//			LOG.log(Level.SEVERE, "Unable to create log file.");
	//		}
	//	}
	/* END Logger for Neo4j */
	private String username;
	private String password;
	private String server_address;
	private Driver driver;
	private static Session session;
	/**
	 * Constructor for the class Neoj
	 */
	public Neo4j() {
		readConfig();
		while (!startSession()) {
			//			LOG.log(Level.INFO, " Retrying Connection in 5s");
			try {
				Thread.sleep(5000);                 //1000 milliseconds is one second.
			} catch (InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
		}
	}
	/* Server Utility Methods */
 	private void readConfig() {
		NodeList nList = DocumentReader.getDoc("config.xml").getElementsByTagName("neo4j-server");
		Node nNode = nList.item(0);
		Element eElement = (Element) nNode;
		username = eElement.getElementsByTagName("username").item(0).getTextContent();
		password = eElement.getElementsByTagName("password").item(0).getTextContent();
		server_address = eElement.getElementsByTagName("server_address").item(0).getTextContent();
	}

	public Session getSession() {
		return session;
	}

	public boolean startSession() {
		try {
			driver = GraphDatabase.driver(server_address, AuthTokens.basic(username, password));
			session = driver.session();
			System.out.println("Connection to Neo4j server started");
			//			LOG.log(Level.INFO, "Connection to Neo4j server started");
			return true;
		} catch (org.neo4j.driver.v1.exceptions.ServiceUnavailableException e) {
			System.out.println("Unable to connect to server," +
					" ensure the database is running and that there is a working network connection to it.");
			//			LOG.log(Level.SEVERE, "Unable to connect to server," +
			//					" ensure the database is running and that there is a working network connection to it.");
			return false;
		} catch (org.neo4j.driver.v1.exceptions.AuthenticationException e) {
			//			LOG.log(Level.SEVERE, ": The client is unauthorized due to authentication failure.");
			System.out.println(": The client is unauthorized due to authentication failure.");
			System.exit(0);
		}
		return false;
	}
	public void closeSession() {
		session.close();
		driver.close();
		//		LOG.log(Level.INFO, "Connection to Neo4j server ended");
		System.out.println("Connection to Neo4j server ended");
	}
	/* END Server Utility Methods */
	/* DB utility Methods */
	/**
	 * Deletes all nodes and relationships from the DB
	 */
	public void clearDB() {
		session.run("MATCH (n) DETACH DELETE n;");
		cleanDB();
		//		LOG.log(Level.INFO, "Cleared Neo4j DB");
		System.out.println("Cleared Neo4j DB");
	}
	/**
	 * Deletes all nodes without relationships from the DB
	 */
	public void cleanDB() {
		session.run("MATCH (n) WHERE size((n)--())=0 DELETE (n)");
		//		LOG.log(Level.INFO, "Cleaned DB");
		System.out.println("Cleaned DB");
	}
	/**
	 * Check if a Node exists in the DB
	 *
	 * @param name - Identifier of the Node
	 * @return true if the Node exists
	 */
	public boolean checkNode(String name, String type) {
		boolean existance = false;
		StatementResult result = session.run("MATCH (a:" + type + ") WHERE a.name={name} RETURN a.name",
				parameters("name", name));
		while (result.hasNext()) {
			Record record = result.next();
			if (record.get("a.name").asString().equals(name)) {
				existance = true;
			}
		}
		return existance;
	}
	//	/**
	//	 * Check if a Relation exists in the DB
	//	 */
	//	public boolean checkRelation(String node, String node_type, String title, String relation_type) {
	//		boolean existance = false;
	//		StatementResult result = session.run("MATCH (a:" + node_type + ")-[:" + relation_type + "]->(b) " +
	//				"WHERE a.name={node} AND b.name={title} RETURN a.name", parameters("node", node, "title", title));
	//		while (result.hasNext()) {
	//			Record record = result.next();
	//			if (record.get("a.name").asString().equals(node)) {
	//				existance = true;
	//			}
	//		}
	//		return existance;
	//	}

	@SuppressWarnings("unused")
	public void addNewCities(String fileName) {
		StatementResult result = session.run("LOAD CSV WITH HEADERS FROM 'file:///" + fileName + "' AS line FIELDTERMINATOR ';' WITH line LIMIT 1000000"
				+"create (w:Wifi {id: line.PK, x: line.COORDENADAX, y: line.COORDENADAY, la: line.LATITUD, lo: line.LONGITUD})" +
				"merge (ci: Ciudad {ci: line.LOCALIDAD, pr: line.PROVINCIA})" +
				"merge (b:Barrio {ba: line.BARRIO})" +
				"merge (d:Distrito {di: line.DISTRITO})" +
				"merge (ci)-[e2:En]->(d)" +
				"merge (d)-[e3:En]->(b)" +
				"merge (b)-[h:Tiene]->(w))");
	}


	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ArrayList<Wifi> conseguirWifis(String ciudad) {
		ArrayList<Wifi> informacionWifis = new ArrayList();
		try {
			StatementResult result = session.run("MATCH (c:Ciudad)-[:En]->(d:Distrito)-[:En]->(b:Barrio)-[:Tiene]->(w:Wifi)" +
					"WHERE c.ci = '" + ciudad.toUpperCase()+"'" +
					"RETURN w.id, w.la, w.lo"); //+
			//								", w.x, w.y");
			while (result.hasNext()) {
				Wifi wifi = new Wifi();
				Record record = result.next();
				//			System.out.println(record.get("w.la").toString());
				//			System.out.println(Double.parseDouble(record.get("w.la").toString().replace("\"", "").replaceAll(",", ".")));
				wifi.setId(record.get("w.id").asString());
				wifi.setLatitud(Double.parseDouble(record.get("w.la").toString().replace("\"", "").replaceAll(",", ".")));
				wifi.setLongitud(Double.parseDouble(record.get("w.lo").toString().replace("\"", "").replaceAll(",", ".")));
				//			wifi.setX(record.get("w.x").asLong());
				//			wifi.setY(record.get("w.y").asLong());
				informacionWifis.add(wifi);
				
		} }catch (Exception e) {
			System.out.println("La ciudad escogida no está disponible");
		}
		
		
		
		return informacionWifis;
	}
}