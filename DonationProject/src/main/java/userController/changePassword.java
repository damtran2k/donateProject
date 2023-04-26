package userController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;
import dao.UserDao;
import util.Encrypt;

/**
 * Servlet implementation class changePassword
 */
@WebServlet("/changePassword")
public class changePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changePassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("loginSignUp.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			// GET INFOR BY SESSION
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("user");			
			if (user!= null) {
				String username = user.getUsername();
				String newPassword = request.getParameter("newPassword");
				String reNewPassword = request.getParameter("reNewpassword");
				UserDao dao = new UserDao();
				// CHECK CURRENT PASSWORD
				 if ("".equals(newPassword)|| "".equals(reNewPassword)) {
					request.setAttribute("error", "value is blank");
					request.getRequestDispatcher("changePassword.jsp").forward(request, response);	
					return;
				}
				if (newPassword.equals(reNewPassword) == false) {
					request.setAttribute("error", "new password incorrect");
					request.getRequestDispatcher("changePassword.jsp").forward(request, response);	
					return;
				}
				dao.changePassword(username, newPassword);
				session.invalidate();
				String message = "<script>alert('Update success')</script>";
				request.setAttribute("message", message);	
				//response.sendRedirect("loginSignUp.jsp");	
				request.getRequestDispatcher("loginSignUp.jsp").forward(request, response);
			}
			request.getRequestDispatcher("loginSignUp.jsp").forward(request, response);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
