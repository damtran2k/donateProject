package userController;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.User;
import dao.CategoryDao;
import dao.FoundationDao;
import dao.FundDao;
import dao.UserDao;
import model.Category;
import model.DonationDetailFund;
import model.Foundation;

/**
 * Servlet implementation class editUser
 */
@WebServlet("/editUser")
public class editUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		UserDao dao = new UserDao();
		User user = dao.getInforById(id);
		request.setAttribute("user", user);
		request.getRequestDispatcher("editUser.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String id = request.getParameter("id");
			String username = request.getParameter("username");
			String email = request.getParameter("email");
			String role = request.getParameter("role");
			String fullname = request.getParameter("fullname");
			String phone = request.getParameter("phone");
			String address = request.getParameter("address");
			String status = request.getParameter("status");
			if ("".equals(role)||"".equals(fullname)||"".equals(phone)||"".equals(address)) {
				request.setAttribute("error", "value is blank");
				doGet(request, response);
				return;
			}
			UserDao dao = new UserDao();
			dao.updateInforUser(id, role, fullname, phone, address, status);
			String message = "<script>alert('Update success')</script>";
			request.setAttribute("message", message);	
//			RequestDispatcher dispatcher //
//            = request.getServletContext().getRequestDispatcher("/listUserController");
			request.getRequestDispatcher("/listUserController").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
