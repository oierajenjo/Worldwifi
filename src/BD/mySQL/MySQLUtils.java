package BD.mySQL;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;

public class MySQLUtils extends MySQL {

    public static void main(String[] args) {
        MySQLUtils mySQL = new MySQLUtils();
        mySQL.dbSetup();
    }

    public void dbSetup() {
        try {

            ScriptRunner scriptRunner = new ScriptRunner(getConnect(), false, false);
            Reader reader = new BufferedReader(new FileReader("src/main/resources/mysql/setup/setup.sql"));
            scriptRunner.runScript(reader);

            clearDB();
            closeSession();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void dwhLog(String barrio) {
        try {
            getStatement().executeUpdate("INSERT INTO BARRIOS VALUES ('" + barrio + "', CURRENT_TIMESTAMP);");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
