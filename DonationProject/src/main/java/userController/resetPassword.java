package userController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import util.Email;

/**
 * Servlet implementation class resetPassword
 */
@WebServlet("/resetPassword")
public class resetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public resetPassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String email = request.getParameter("email");
			UserDao dao = new UserDao();
			// CREATE NEW PASSWORD
			String newPassword = dao.forgetPassword(email);
			Email e = new Email();
			e.resetPassword(email, newPassword);
			String message = "<script>alert('Reset password successfully.Please check mail')</script>";
			request.setAttribute("message",message);
			request.getRequestDispatcher("loginSignUp.jsp").forward(request, response);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
