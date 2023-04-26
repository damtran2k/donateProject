package FoundationController;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FoundationDao;
import model.Foundation;

/**
 * Servlet implementation class searchFoundation
 */
@WebServlet("/searchFoundation")
public class searchFoundation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchFoundation() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String txtSearch = request.getParameter("search");
			if (txtSearch == null || txtSearch == "") {
				response.sendRedirect("listFoundationController");
			}else {
				List<Foundation> list = new FoundationDao().searchFoundation(txtSearch);
				request.setAttribute("list", list);
				request.setAttribute("txtSearch", txtSearch);
				request.getRequestDispatcher("manageFoundation.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("failed");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

}
