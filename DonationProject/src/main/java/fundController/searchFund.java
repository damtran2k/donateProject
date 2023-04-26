package fundController;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FundDao;
import model.DonationDetailFund;

/**
 * Servlet implementation class searchFund
 */
@WebServlet("/searchFund")
public class searchFund extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchFund() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String txtsearch = request.getParameter("search");
		String typeSearch = request.getParameter("type");
		System.out.println(txtsearch);
		if(txtsearch == null || "".equals(txtsearch)) {
			response.sendRedirect("listFundController");
		}else {
			if ("Name".equals(typeSearch)) {
				List<DonationDetailFund> list = new FundDao().searchFundByName(txtsearch);
				request.setAttribute("list", list);
				request.setAttribute("txtsearch", txtsearch);
				request.setAttribute("typeSearch", typeSearch);
				request.getRequestDispatcher("manageFund.jsp").forward(request, response);
			}else if ("Category".equals(typeSearch)) {
				List<DonationDetailFund> list = new FundDao().searchFundByCategory(txtsearch);
				request.setAttribute("list", list);
				request.setAttribute("txtsearch", txtsearch);
				request.setAttribute("typeSearch", txtsearch);
				request.getRequestDispatcher("manageFund.jsp").forward(request, response);

			}else {
				List<DonationDetailFund> list = new FundDao().searchFundByFoundation(txtsearch);
				request.setAttribute("list", list);
				request.setAttribute("txtsearch", txtsearch);
				request.getRequestDispatcher("manageFund.jsp").forward(request, response);		
			}
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
