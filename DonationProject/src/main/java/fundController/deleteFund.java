package fundController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FundDao;

/**
 * Servlet implementation class deleteFund
 */
@WebServlet("/deleteFund")
public class deleteFund extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteFund() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String id = request.getParameter("id");
			FundDao dao = new FundDao();
			dao.deleteFund(id);
			String message = "<script>alert('Delete successfully')</script>";
			request.setAttribute("message",message);
			request.getRequestDispatcher("/listFundController").forward(request, response);
		} catch (Exception e) {
			String message = "<script>alert('Delete Failed')</script>";
			request.setAttribute("message",message);
			request.getRequestDispatcher("/listFundController").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
