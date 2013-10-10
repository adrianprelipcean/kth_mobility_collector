package servlet.handling;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.Variables;
import database.connection.ConnDB;

/**
 * Servlet implementation class CheckDatabase
 */
@WebServlet("/CheckDatabase")
public class CheckDatabase extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckDatabase() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	private Connection connection = null;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ConnDB conn = new ConnDB();
		boolean testUserDatabase = false;
		boolean testObjectDatabase = false;

		
		  try { java.sql.Connection connection = conn.getConn();
		  DatabaseMetaData meta = connection.getMetaData(); ResultSet res =
		  meta.getTables(null, null, null, new String[] { "TABLE" });
		  System.out.println("List of tables: ");
		  
		  String[] tableString = new String[] { "annotation_table",
		  "location_table", "simple_location_table", "user_table" };
		  
		  while (res.next()) {
		  
		  for (String s : tableString) { if
		  (res.getString("TABLE_NAME").equals(s)) {
		  response.getWriter().println( res.getString("TABLE_SCHEM") + ", " +
		  res.getString("TABLE_NAME") + ", " + res.getString("TABLE_TYPE") +
		  " -> " + "SUCCESS"); if (s.equals("user_table")) testUserDatabase =
		  true; else testObjectDatabase = true; } } } res.close();
		  
		  if (testUserDatabase && testObjectDatabase)
		  response.getWriter().println(
		  "Your database is configured correctly"); else {
		  response.getWriter().println("Configuring your database"); Statement
		  st = connection.createStatement();
		  st.executeUpdate(Variables.sqlStatement1);
		  st.executeUpdate(Variables.sqlStatement2);
		  st.executeUpdate(Variables.sqlStatement3);
		  st.executeUpdate(Variables.sqlStatement4);
		  
		  ResultSet res2 = meta.getTables(null, null, null, new String[] {
		  "TABLE" });
		  
		  while (res2.next()) {
		  
		  for (String s : tableString) { if
		  (res2.getString("TABLE_NAME").equals(s)) {
		  response.getWriter().println( res2.getString("TABLE_SCHEM") + ", " +
		  res2.getString("TABLE_NAME") + ", " + res2.getString("TABLE_TYPE") +
		  " -> " + "SUCCESS"); if (s.equals("user_table")) testUserDatabase =
		  true; else testObjectDatabase = true; } } } res2.close(); if
		  (testUserDatabase && testObjectDatabase)
		  response.getWriter().println(
		  "Your database is configured correctly"); }
		  
		  response.getWriter().println("Host = " + request.getServerName());
		  response.getWriter().println("Port = " + request.getServerPort());
		  response.getWriter().println( "Remote Address = " +
		  request.getRemoteAddr()); response.getWriter().println(
		  "Remote Host = " + request.getRemoteHost() + " " +
		  request.getRemotePort());
		  
		  connection.close(); } catch (SQLException e) { e.printStackTrace(); }
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

}
