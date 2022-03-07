package app.dbService;

import task2.annotations.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class DB {

    private Connection connection;

    private void connect() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/lab03";
        String username = "postgres";
        String password = "postgres";

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public Connection getConnection() {
        if (connection == null) {
            try {
                connect();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
