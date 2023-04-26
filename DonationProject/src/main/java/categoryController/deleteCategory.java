package categoryController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDao;

/**
 * Servlet implementation class deleteCategory
 */
@WebServlet("/deleteCategory")
public class deleteCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteCategory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try {
			String id  = request.getParameter("idC");
			CategoryDao dao = new CategoryDao();
			dao.deleteCategory(id);
			System.out.println(id);
			PrintWriter out = response.getWriter();
			String message = "<script>alert('Delete successfully')</script>";
			request.setAttribute("message", message);		
			request.getRequestDispatcher("manageCategory").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
			String message = "<script>alert('Delete Failed')</script>";
			request.setAttribute("message", message);
			 request.getRequestDispatcher("manageCategory").forward(request, response);
			
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	

}
