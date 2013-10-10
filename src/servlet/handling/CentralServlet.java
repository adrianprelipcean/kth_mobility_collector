package servlet.handling;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.handling.web.Login;
import user.handling.web.Register;

/**
 * Servlet implementation class AppServlet
 */

@WebServlet("/ConnectToDatabase")
public class CentralServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CentralServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// NOTE: to get the value of POINT
		String method = request.getParameter("method");

		if ("login".equalsIgnoreCase(method)) {
			Login login = new Login();
			try {
				login.getLogin(request, response);
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}// end of if login

		if ("register".equalsIgnoreCase(method)) {
			Register register = new Register();
			try {
				register.getRegister(request, response);
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if ("upload".equalsIgnoreCase(method)) {
			DBS databases = new DBS();
			try {
				databases.getDBS(request, response);
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
