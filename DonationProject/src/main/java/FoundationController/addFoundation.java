package FoundationController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FoundationDao;

/**
 * Servlet implementation class addFoundation
 */
@WebServlet("/addFoundation")
public class addFoundation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addFoundation() {
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
		String name = request.getParameter("name");
		String des = request.getParameter("description");
		String email = request.getParameter("email");
		String status  = request.getParameter("status");	
		try {
			if ("".equals(name)||"".equals(des)||"".equals(email)) {
				request.setAttribute("error", "value is blank");
				request.getRequestDispatcher("addFoundation.jsp").forward(request, response);
				return;
			}
			FoundationDao dao = new FoundationDao();
			dao.insertFoundation(name, des, status, email);
			String message = "<script>alert('Add foundation Successfully')</script>";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/listFoundationController").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "Add Foundation is failed");
			request.getRequestDispatcher("addFoundation.jsp").forward(request, response);
			
		}
	}

}
