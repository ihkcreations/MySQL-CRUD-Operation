package mySQLOperations.DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private String fixedDatabaseName = "mysqloperations";
    private String fixedDatabaseUserName = "root";
    private String fixedDatabaseUserPassword = "";
    private String fixedDatabaseURL = "jdbc:mysql://localhost/" + fixedDatabaseName;

    private String databaseName;
    private String databaseUser;
    private String databasePass;

    public DatabaseConnection(){

    }

    public DatabaseConnection(String databaseName, String databaseUser, String databasePass) {
        this.databaseName = databaseName;
        this.databaseUser = databaseUser;
        this.databasePass = databasePass;
    }



    public Connection getFixedConnection() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(fixedDatabaseURL, fixedDatabaseUserName, fixedDatabaseUserPassword);
        return connection;


    }

    public Connection getConnection() throws ClassNotFoundException, SQLException{

        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/" + this.databaseName, this.databaseUser, this.databasePass);
        return connection;

    }
}
