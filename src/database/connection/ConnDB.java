package database.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import utils.Variables;

public class ConnDB {
	private Connection connection = null;

	public Connection getConn() {
		try {

			/**
			 * Changes will occur in this part of the code to enable
			 * interactions with other DBMS (currently only Postgres is
			 * supported)
			 * 
			 */

			Class.forName("org.postgresql.Driver").newInstance();
			String url = "jdbc:postgresql://localhost:5432/"
					+ Variables.databaseName;

			/**
			 * End
			 */

			connection = DriverManager.getConnection("jdbc:"
					+ Variables.connectionURL + "/" + Variables.databaseName,
					Variables.userName, Variables.password);

		} catch (Exception e) {
			// Database not found
			e.printStackTrace();
		} finally {
		}

		if (connection != null) {
			System.out.println("Connected to the database");
		} else {
			System.out.println("Database not found ");
		}

		return connection;
	}

	public void releaseConnection(Connection c) throws Throwable {
		if (c != null) {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			super.finalize();
		}
	}
}