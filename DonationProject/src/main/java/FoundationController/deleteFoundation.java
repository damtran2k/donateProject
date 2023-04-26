package FoundationController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FoundationDao;

/**
 * Servlet implementation class deleteFoundation
 */
@WebServlet("/deleteFoundation")
public class deleteFoundation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteFoundation() {
        super();
       
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String id = request.getParameter("id");
			FoundationDao dao = new FoundationDao();
			dao.deleteFoundation(id);
			String message = "<script>alert('Delete successfully')</script>";
			request.setAttribute("message",message);
			request.getRequestDispatcher("/listFoundationController").forward(request, response);			
		} catch (Exception e) {
			e.printStackTrace();
			String message = "<script>alert('Delete Failed')</script>";
			request.setAttribute("message",message);
			request.getRequestDispatcher("/listFoundationController").forward(request, response);		
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
