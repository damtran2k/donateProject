package donateController;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDao;
import dao.DonationDao;
import model.Category;
import model.Donation;

/**
 * Servlet implementation class listDonateController
 */
@WebServlet("/listDonateController")
public class listDonateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listDonateController() {
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
	//  Get Infor from DonateDao
		DonationDao listDonateDao = new DonationDao();
		int amountItem = 6;
		String indexPage = request.getParameter("index");
		if (indexPage == null) {
			indexPage ="1";
		}
		int index = Integer.parseInt(indexPage);
	
		int count = listDonateDao.getTotalItems();
		int endPage = count/amountItem;
		if(count%amountItem !=0) {
			endPage++;
		}
		request.setAttribute("endPage", endPage);
		request.setAttribute("amount", amountItem);
		request.setAttribute("count",count);
		try {
		
			List<Donation> list = listDonateDao.pagingDonation(index, amountItem);
			// Set data and transfer to web
			request.setAttribute("list", list);
			//phan trang du lieu
			request.getRequestDispatcher("manageDonate.jsp").forward(request, response);
			
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
