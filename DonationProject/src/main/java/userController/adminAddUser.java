package userController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import dao.UserDao;
import util.Email;

/**
 * Servlet implementation class adminAddUser
 */
@WebServlet("/adminAddUser")
public class adminAddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminAddUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String role = request.getParameter("role");
		String password = request.getParameter("password");
		String fullname = request.getParameter("fullname");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String status = request.getParameter("status");
		UserDao dao = new UserDao();	
		// REGEX USERNAME,MAIL,PASSWORD
		try {
				User user = new User();
				if(!user.regexUsername(username)||"".equals(username)) {
					request.setAttribute("error", "username invalid");
					request.getRequestDispatcher("addUser.jsp").forward(request, response);
					return;
					}
				if(!user.regexEmail(email)||"".equals(email)) {
						request.setAttribute("error", "email invalid");
						request.getRequestDispatcher("addUser.jsp").forward(request, response);
						return;
					}
				if(!user.regexPassword(password)) {
						request.setAttribute("error", "password invalid");
						request.getRequestDispatcher("addUser.jsp").forward(request, response);
						return;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				// CHECK  USERNAME EXITS
				try {	
					if (dao.checkUserNameExits(username)) {
						request.setAttribute("error", "username exits");
						request.getRequestDispatcher("addUser.jsp").forward(request, response);
						return;
					}
			
				} catch (Exception e) {
					e.printStackTrace();
					request.getRequestDispatcher("addUser.jsp").forward(request, response);
					return;
					
				}
				//CHECK EMAIL EXITS
				try {	
					if (dao.checkEmailExits(email)) {
						request.setAttribute("error", "email exits");
						request.getRequestDispatcher("addUser.jsp").forward(request, response);
						return;
					}
			
				} catch (Exception e) {
					e.printStackTrace();
					request.getRequestDispatcher("addUser.jsp").forward(request, response);
					return;	
				}
				dao.addUserFromAdmin(username, password, role, email, fullname, phone, address, status);
				
				String message = "<script>alert('Add User Successfully')</script>";
				request.setAttribute("message", message);
				request.getRequestDispatcher("/listUserController").forward(request, response);
				
				
			}
	
	

}
