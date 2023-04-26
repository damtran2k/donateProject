package categoryController;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDao;
import model.Category;

/**
 * Servlet implementation class DeleteManyC
 */
@WebServlet("/DeleteManyC")
public class DeleteManyC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteManyC() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			// TODO Auto-generated method stub
			CategoryDao dao = new CategoryDao();
			 String[] listItems = request.getParameterValues("options1");
			 for (String item : listItems) {
				dao.deleteCategory(item);
			}
			 String message = "<script>alert('Delete Successfully')</script>";
				request.setAttribute("message", message);
				request.getRequestDispatcher("manageCategory").forward(request, response);
			 
			
		} catch (Exception e) {
			e.printStackTrace();
			String message = "<script>alert('Delete Failed')</script>";
			request.setAttribute("message", message);
			 request.getRequestDispatcher("manageCategory").forward(request, response);
		}
	
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		//loadData(request,response);
	}
	


}
