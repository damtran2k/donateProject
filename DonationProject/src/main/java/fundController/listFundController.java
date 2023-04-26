package fundController;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDao;
import dao.FundDao;
import model.Category;
import model.DonationDetailFund;

/**
 * Servlet implementation class listFundController
 */
@WebServlet("/listFundController")
public class listFundController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listFundController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		proCessRequest(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		proCessRequest(request, response);
	}
protected void proCessRequest(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		response.setContentType("text/html;charset=UTF-8");
	//  Get Infor from FundDao
		FundDao dao = new FundDao();
		int amountItem = 6;
		String indexPage = request.getParameter("index");
		if (indexPage == null) {
			indexPage ="1";
		}
		int index = Integer.parseInt(indexPage);
	
		int count = dao.getTotalItems();
		int endPage = count/amountItem;
		if(count%amountItem !=0) {
			endPage++;
		}
		request.setAttribute("endPage", endPage);
		request.setAttribute("amount", amountItem);
		request.setAttribute("count",count);
		try {
		
			List<DonationDetailFund> list = dao.pagingFund(index, amountItem);
			
			// Set data and transfer to web
			request.setAttribute("list", list);
			//phan trang du lieu
			request.getRequestDispatcher("manageFund.jsp").forward(request, response);
			
			
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
