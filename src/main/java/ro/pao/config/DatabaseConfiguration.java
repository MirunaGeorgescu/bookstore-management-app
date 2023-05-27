package ro.pao.config;

import java.sql.Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfiguration {
    // DATA BASE CONNECTION
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "root";
    private static Connection databaseConnection;

    // constructor with no parameters
    private DatabaseConfiguration() {
    }

    private Connection getDatabaseConnection(){
        try {
            if (databaseConnection == null || databaseConnection.isClosed()) {
                databaseConnection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return databaseConnection;
    }

    public static void closeDatabaseConnection() {
        try {
            if (databaseConnection != null && !databaseConnection.isClosed()) {
                databaseConnection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
