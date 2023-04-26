package controller;

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
 * Servlet implementation class SignUp
 */
@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processResquest(request, response);
	}
	protected void processResquest(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html;charset=UTF-8");
		String username = request.getParameter("username");
		String fullname = request.getParameter("fullname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String rePassword = request.getParameter("rePassword");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		UserDao dao = new UserDao();
		// REGEX USERNAME,MAIL,PASSWORD
		try {
			User user = new User();
			if(!user.regexUsername(username)) {
				request.setAttribute("message", "<script>alert('Username invalid')</script>");
				request.getRequestDispatcher("loginSignUp.jsp").forward(request, response);
				return;
			}
			if(!user.regexEmail(email)) {
				request.setAttribute("message", "<script>alert('email invalid')</script>");
				request.getRequestDispatcher("loginSignUp.jsp").forward(request, response);
				return;
			}
			if(!user.regexPassword(password)) {
				request.setAttribute("message", "<script>alert('password invalid')</script>");
				request.getRequestDispatcher("loginSignUp.jsp").forward(request, response);
				return;
			}
			if (!password.equals(rePassword)) {
				request.setAttribute("message", "<script>alert('Password and Repassword not match')</script>");
				request.getRequestDispatcher("loginSignUp.jsp").forward(request, response);
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// CHECK  USERNAME EXITS
		try {	
			if (dao.checkUserNameExits(username)) {
				request.setAttribute("message", "<script>alert('Username exits')</script>");
				request.getRequestDispatcher("loginSignUp.jsp").forward(request, response);
				return;
			}
	
		} catch (Exception e) {
			e.printStackTrace();
			request.getRequestDispatcher("loginSignUp.jsp").forward(request, response);
			return;
			
		}
		//CHECK EMAIL EXITS
		try {	
			if (dao.checkEmailExits(email)) {
				request.setAttribute("message", "<script>alert('email exits')</script>");
				request.getRequestDispatcher("loginSignUp.jsp").forward(request, response);
				return;
			}
	
		} catch (Exception e) {
			e.printStackTrace();
			request.getRequestDispatcher("loginSignUp.jsp").forward(request, response);
			return;	
		}
		dao.signUp(username,password, email, fullname, phone, address);
		// SEND EMAIL TO VERIFY ACCOUNT
		Email mailTo = new Email();
		mailTo.sendEmail(email,username);
		String message = "<script>alert('Sign Up Successfully.Please check mail to veryfy account')</script>";
		request.setAttribute("message", message);
		request.setAttribute("username", username);
		request.getRequestDispatcher("loginSignUp.jsp").forward(request, response);
		
		
	}

}
