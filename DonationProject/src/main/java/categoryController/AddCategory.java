package categoryController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CategoryDao;

/**
 * Servlet implementation class AddCategory
 */
@WebServlet("/AddCategory")
public class AddCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCategory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String name = request.getParameter("name");
			String des = request.getParameter("description");
			String status  = request.getParameter("status");
			if("".equals(name)||"".equals(des)) {
				 request.setAttribute("error", " value is blank");
				  // Chuyển hướng đến trang manageCategory.jsp và hiển thị thông báo lỗi
				 request.getRequestDispatcher("addCategory.jsp").forward(request, response);
				 return;
			}
			CategoryDao dao = new CategoryDao();
			dao.insertCategory(name, des, status);	
			String message = "<script>alert('Add Category Successfully')</script>";
			request.setAttribute("message", message);
			request.getRequestDispatcher("manageCategory").forward(request, response);
			//response.sendRedirect("manageCategory");
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Fail to Add category");

			  // Chuyển hướng đến trang manageCategory.jsp và hiển thị thông báo lỗi
			  RequestDispatcher dispatcher = request.getRequestDispatcher("addCategory.jsp");
			  dispatcher.forward(request, response);
		}
		
	}

}
