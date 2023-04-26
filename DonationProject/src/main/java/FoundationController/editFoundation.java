package FoundationController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDao;
import dao.FoundationDao;
import model.Foundation;

/**
 * Servlet implementation class editFoundation
 */
@WebServlet("/editFoundation")
public class editFoundation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editFoundation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		FoundationDao dao = new FoundationDao();
		Foundation f = dao.getFoundationById(id);
		request.setAttribute("f", f);
		request.getRequestDispatcher("editFoundation.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String description = request.getParameter("description");
			String status = request.getParameter("status");
			if ("".equals(name)||"".equals(description)||"".equals(email)) {
				request.setAttribute("error", "value is blank");
				doGet(request, response);
				return;
			}
			FoundationDao dao = new FoundationDao();
			dao.updateFoundation(id, name,email, description, status);
			String message = "<script>alert('Update successfully')</script>";
			request.setAttribute("message", message);	
			RequestDispatcher dispatcher //
            = request.getServletContext().getRequestDispatcher("/listFoundationController");
    dispatcher.forward(request, response);
			//response.sendRedirect("manageCategory");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
