package BD.mySQL;


import common.time.DateUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.*;
import java.util.logging.FileHandler;
import java.util.logging.Level;

public class MySQL {

    /* Logger for Neo4j */
    private static final java.util.logging.Logger LOG = java.util.logging.Logger.getLogger(MySQL.class.getName());
//
//    static {
//        try {
//            LOG.addHandler(new FileHandler(
//                    "logs/" + MySQL.class.getName() + "." +
//                            DateUtils.currentFormattedDate() + ".log.xml", true));
//        } catch (SecurityException | IOException e) {
//            LOG.log(Level.SEVERE, "Unable to create log file.");
//        }
//    }
    /* END Logger for Neo4j */

    private String username;
    private String password;

    private Connection connect = null;
    private static Statement statement = null;
    private ResultSet resultSet = null;

    /**
     * Constructor for the class MySQL
     */
    public MySQL() {
        startSession();
    }

    /* Server Utility Methods */

    public void setup() {
        try {
            MySQL mySQL = new MySQL();
            mySQL.startSession();

            ScriptRunner scriptRunner = new ScriptRunner(mySQL.getConnect(), false, false);
            Reader reader = new BufferedReader(new FileReader("src/main/resources/mysql/setup/setup.sql"));
            scriptRunner.runScript(reader);

            mySQL.clearDB();
            mySQL.closeSession();

        } catch (IOException e) {
            LOG.log(Level.SEVERE, "IOException - SQL file not Found");
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "SQLException - SQL file not Found");
        }
    }

    /**
     * Deletes all data from the DB
     *
     * @throws SQLException If the database is not properly created
     */
    public void clearDB() {
        try {
            statement.executeUpdate("DELETE FROM neo4j_log");
            statement.executeUpdate("DELETE FROM user_ratings");
            statement.executeUpdate("DELETE FROM user_viewing_history");
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "SQLException: Error Clearing DB");
        }
    }

    public void startSession() {
        username = "worldwifi";
        password = "worldwifi2017";
    	try {
            connect = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/dwh?"
                            + "user=" + username + "&password=" + password);

            statement = connect.createStatement();
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "SQLException: Access denied");
            System.exit(0);
        }
    }

    public void closeSession() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connect != null) {
                connect.close();
            }
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, "SQLException: Error closing session");
            System.exit(0);
        }
    }
    /* Server Utility Methods */

    /* MySQL Methods */

    public static Statement getStatement() {
        return statement;
    }

    public Connection getConnect() {
        return connect;
    }

    /* END MySQL Methods */
}
