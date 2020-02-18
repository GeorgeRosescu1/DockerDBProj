package main.java.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnector {

    private static Connection connectionM = null;
    private static Connection connectionP = null;

    private DBConnector() {

    }

    public static Connection getConnectionM() throws SQLException, ClassNotFoundException {
        if (connectionM == null) {
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                System.out.println("Connecting to MariaDB...");
                connectionM = DriverManager.getConnection("jdbc:mariadb://maria:3306/persons", "root", "maria");
                String createQuery = "CREATE TABLE if not exists persons (\n" +
                        "id INT(6) AUTO_INCREMENT PRIMARY KEY,\n" +
                        "firstname VARCHAR(150) NOT NULL,\n" +
                        "lastname VARCHAR(150) NOT NULL,\n" +
                        "age int not null)";
                Statement statement = connectionM.createStatement();
                statement.execute(createQuery);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connectionM;
    }

    public static Connection getConnectionP() throws ClassNotFoundException {
        if (connectionP == null) {
            try {
                Class.forName("org.postgresql.Driver");
                connectionP = DriverManager.getConnection("jdbc:postgresql://172.18.0.1/postgrdb", "postgrdb", "postgrdb");
                Statement statement = connectionP.createStatement();
                String createQuery = "CREATE TABLE if not exists persons(\n" +
                        "   id serial PRIMARY KEY,\n" +
                        "   firstname VARCHAR (150) UNIQUE NOT NULL,\n" +
                        "   lastname VARCHAR (150) NOT NULL,\n" +
                        "   age int NOT NULL);";
                statement.execute(createQuery);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connectionP;
    }
}
