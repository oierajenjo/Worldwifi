package neo4j;

import static org.neo4j.driver.v1.Values.parameters;


public class Neo4j{

	    /* Logger for Neo4j */
	    private static final java.util.logging.Logger LOG = java.util.logging.Logger.getLogger(Neo4j.class.getName());

	    static {
	        try {
	            LOG.addHandler(new FileHandler(
	                    "logs/" + Neo4j.class.getName() + "." +
	                            DateUtils.currentFormattedDate() + ".log.xml", true));
	        } catch (SecurityException | IOException e) {
	            LOG.log(Level.SEVERE, "Unable to create log file.");
	        }
	    }
	    /* END Logger for Neo4j */

	    private String username;
	    private String password;
	    private String server_address;
	    private Driver driver;
	    private Session session;

	    private MySQL mySQL;
	    private Statement statement;


	    /**
	     * Constructor for the class Neoj
	     */
	    public Neo4j() {
	        readConfig();
	        while (!startSession()) {
	            LOG.log(Level.INFO, " Retrying Connection in 5s");
	            try {
	                Thread.sleep(5000);                 //1000 milliseconds is one second.
	            } catch (InterruptedException ex) {
	                Thread.currentThread().interrupt();
	            }
	        }

	        startDWH();
	    }
}
