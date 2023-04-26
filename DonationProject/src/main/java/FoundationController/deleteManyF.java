package FoundationController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FoundationDao;

/**
 * Servlet implementation class deleteManyF
 */
@WebServlet("/deleteManyF")
public class deleteManyF extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteManyF() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			FoundationDao dao = new FoundationDao();
			String [] listItems = request.getParameterValues("options1");
			
			for (String item : listItems) {
				dao.deleteFoundation(item);
				
			}
			String message = "<script>alert('Delete successfully')</script>";
			request.setAttribute("message", message);		
			request.getRequestDispatcher("/listFoundationController").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			String message = "<script>alert('Delete Failed')</script>";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/listFoundationController").forward(request, response);
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
