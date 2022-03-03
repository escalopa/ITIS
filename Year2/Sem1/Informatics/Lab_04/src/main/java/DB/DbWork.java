package DB;

import java.sql.*;

public class DbWork {

    //DB Creation
    /**
     * CREATE TABLE account(
     *       username  VARCHAR(255)    NOT NULL unique,
     *       first_name VARCHAR(255)    NOT NULL,
     *       last_name  VARCHAR(255)    NOT NULL,
     *       email  VARCHAR(255)    NOT NULL unique,
     *       password  VARCHAR(255)    NOT NULL
     *       );
     *     */
    private static DbWork db;
    private static Connection connection;

    private static DbWork getInstance() {
        DbWork localInstance = db;
        if (localInstance == null) {
            synchronized (DbWork.class) {
                localInstance = db;
                if (localInstance == null) {
                    db = localInstance = new DbWork();
                    getConnection();
                }
            }
        }
        return db;
    }

    public static Connection getConnection() {
        if (db == null) {
            getInstance();
        }

        if (connection == null) {
            try {
                Class.forName("org.postgresql.Driver");
                String url = "jdbc:postgresql://localhost:5432/lab04";
                connection = DriverManager.getConnection(url, "postgres", "postgres");
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        return connection;
    }

    public static void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet accountAuthentication(String username, String password) {
        ResultSet resultSet = null;
        try {
            System.out.println(username+" "+password);
            String query = "SELECT * FROM account WHERE username = ? AND password = ? ";
            PreparedStatement statement = DbWork.getConnection().prepareStatement(query);
            statement.setString(1,username);
            statement.setString(2,password);
            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public static boolean accountExists(String email) throws SQLException {
        ResultSet resultSet = null;
        try {
            String query = "SELECT email FROM account WHERE email = ? ";
            PreparedStatement statement = DbWork.getConnection().prepareStatement(query);
            statement.setString(1,email);
            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet.next();

    }

    public static boolean usernameExists(String username) throws SQLException {
       ResultSet resultSet = null;
        try {
            String query = "SELECT username FROM account WHERE username = ? ";
            PreparedStatement statement = DbWork.getConnection().prepareStatement(query);
            statement.setString(1,username);
            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet.next();
    }

    public static void createAccount(String username, String firstname, String lastname, String email, String password) throws SQLException {
        String psql = "INSERT Into account (username, first_name, last_name, email, password) VALUES (?,?,?,?,?)";
        PreparedStatement statement = DbWork.getConnection().prepareStatement(psql);
        statement.setString(1, username);
        statement.setString(2, firstname);
        statement.setString(3, lastname);
        statement.setString(4, email);
        statement.setString(5, password);
        statement.execute();
    }
}


