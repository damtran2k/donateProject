package controller;

import java.io.IOException;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;
import dao.UserDao;

/**
 * Servlet implementation class LogIn
 */
@WebServlet("/LogIn")
public class LogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogIn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String pass = request.getParameter("pass");

		 try {
			 if("".equals(username)||"".equals(pass)) {
					request.setAttribute("errorLogin", "Value is blank");
					request.getRequestDispatcher("loginSignUp.jsp").forward(request, response);
					return;
				}
				UserDao dao = new UserDao();
				boolean checkLogin = dao.checkLogin(username, pass);
				if(checkLogin) {
					User user = dao.getInfor(username);
					HttpSession session = request.getSession();
					session.setAttribute("user", user);
					if("Admin".equals(user.getRole())) {
						response.sendRedirect("listFundController");
						return;

					}else {
						response.sendRedirect("index.jsp");
						return;
					}
					

				}else {
					request.setAttribute("errorLogin","Wrong user or password ");
					request.getRequestDispatcher("loginSignUp.jsp").forward(request, response);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
