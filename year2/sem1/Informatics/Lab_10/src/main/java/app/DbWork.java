package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbWork {

	private static DbWork db;
	private static Connection connection;

	public static DbWork getInstance() {
		DbWork localInstance = db;
		if (localInstance == null) {
			synchronized(DbWork.class) {
				localInstance = db;
				if (localInstance == null) {
					db = localInstance = new DbWork();
					getConnection();
				}
			}
		}
		return db;
	}
	
	public static void clear(){
	}

	public static void close(){
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection() {
		if (db == null) {
			getInstance();
		}

		if (connection == null) {
			try {
				Class.forName("org.postgresql.Driver");
				String url = "jdbc:postgresql://localhost:5432/lab10";
				String username = "postgres";
				String password = "postgres";
				connection = DriverManager.getConnection(url, username, password);

			} catch (SQLException | ClassNotFoundException throwable) {
				throwable.printStackTrace();
			}
		}

		return connection;
	}
}
