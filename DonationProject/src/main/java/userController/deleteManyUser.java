package userController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FundDao;
import dao.UserDao;

/**
 * Servlet implementation class deleteManyUser
 */
@WebServlet("/deleteManyUser")
public class deleteManyUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteManyUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			UserDao dao = new UserDao();
			String[] list = request.getParameterValues("options1");
			for (String item : list) {
				dao.deleteUser(item);
			}
			String message = "<script>alert('Delete successfully')</script>";
			request.setAttribute("message",message);
			request.getRequestDispatcher("/listUserController").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			String message = "<script>alert('Delete Failed')</script>";
			request.setAttribute("message",message);
			request.getRequestDispatcher("/listUserController").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
