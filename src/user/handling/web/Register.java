package user.handling.web;

import java.io.DataOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.connection.ConnDB;

public class Register {
	private Connection connect = null;
	private PreparedStatement ps = null;

	public void getRegister(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		// get the username and password
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// connect to database to check whether there are records in the
		// database
		ConnDB conndb = new ConnDB();
		// to account how many rows in the database satisfy the conditions
		int rowCount = 0;
		String rows = "";
		String searchSQL = "select * from user_table where username='"
				+ username + "'";
		String insertSQL = "insert into user_table(username,password_i) values('"
				+ username + "','" + password + "') returning userid";

		try {
			connect = conndb.getConn();
			Statement stmt = connect.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			ResultSet rset = stmt.executeQuery(searchSQL);
			rset.last();
			rowCount = rset.getRow();
			rset.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conndb.releaseConnection(connect);
		}
		DataOutputStream dos = new DataOutputStream(response.getOutputStream());
		if (rowCount == 1) {
			dos.writeUTF("Failed");

		} else {
			try {
				connect = conndb.getConn();
				Statement stmt = connect.createStatement(
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_UPDATABLE);
				ResultSet rset = stmt.executeQuery(insertSQL);
				rset.last();
				rows = rset.getString("userid");
				rset.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				dos.writeUTF(rows + "");
				conndb.releaseConnection(connect);
			}
		}
	}

}
