package user.handling.web;

import java.io.DataOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.connection.ConnDB;

public class Login {
	private Connection connect = null;

	public void getLogin(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		// get the username and password
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// connect to database to check whether there are records in the
		// database
		ConnDB conndb = new ConnDB();
		// to account for how many rows in the database satisfy the conditions
		int rowCount = 0;
		String rows = "";
		String loginSQL = "select * from user_table where username='"
				+ username + "' and password_i='" + password + "'";
		try {
			connect = conndb.getConn();
			Statement stmt = connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet rset = stmt.executeQuery(loginSQL);
			rset.last();
			rowCount = rset.getRow();
			rset.close();
			rset = stmt.executeQuery(loginSQL);
			rset.last();
			rows = rset.getString("userid");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conndb.releaseConnection(connect);
		}
		// give feedback on whether can login or not
		DataOutputStream dos = new DataOutputStream(response.getOutputStream());
		if (rowCount == 1) {
			dos.writeUTF(rows + " "); // returns the userid
		} else {
			dos.writeUTF("Failed"); // account doesn't exist
		}
	}
}
