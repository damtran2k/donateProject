package categoryController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDao;
import model.Category;

/**
 * Servlet implementation class EditCategory
 */
@WebServlet("/EditCategory")
public class EditCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCategory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		CategoryDao dao = new CategoryDao();
		Category c = dao.getCategoryById(id);
		request.setAttribute("c", c);
		request.getRequestDispatcher("editCategory.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String description = request.getParameter("description");
			String status = request.getParameter("status");
			if("".equals(name) || "".equals(description)) {
				 request.setAttribute("error", " value is blank");
				  // Chuyển hướng đến trang manageCategory.jsp và hiển thị thông báo lỗi
				 doGet(request, response);
				 return;
			}
			CategoryDao dao = new CategoryDao();
			dao.updateCategory(id, name, description, status);
			String message = "<script>alert('Update success')</script>";
			request.setAttribute("message", message);	
			RequestDispatcher dispatcher //
            = request.getServletContext().getRequestDispatcher("/ListCategoryController");
    dispatcher.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
