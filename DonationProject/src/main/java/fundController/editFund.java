package fundController;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDao;
import dao.FoundationDao;
import dao.FundDao;
import model.Category;
import model.DonationDetailFund;
import model.Foundation;

/**
 * Servlet implementation class editFund
 */
@WebServlet("/editFund")
public class editFund extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editFund() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		FundDao dao = new FundDao();
		DonationDetailFund fund = dao.getFundByID(id);
		List<Category> listActiveCategory = new CategoryDao().activeCategory();
		List<Foundation> listActiveFoundation = new FoundationDao().activeFoundation();
		request.setAttribute("listC", listActiveCategory);
		request.setAttribute("listF", listActiveFoundation);
		request.setAttribute("fund", fund);
		request.getRequestDispatcher("editFund.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String category = request.getParameter("category");
		String category_id = String.valueOf(new CategoryDao().getIdByName(category).getId()) ;
		String foundation = request.getParameter("foundation");
		String foundation_id = String.valueOf(new FoundationDao().getIdByName(foundation).getId()) ;
		String description = request.getParameter("description");
		String content = request.getParameter("content");
		String img_url = request.getParameter("img_url");
		String expectMoney = request.getParameter("expectMoney");
		float money = Float.parseFloat(expectMoney);
		String createdDate = request.getParameter("createdDate");
		String endDate = request.getParameter("endDate");
		String status = request.getParameter("status");
		String regexDate = "^\\d{4}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$";
		if("".equals(name)||"".equals(content)||"".equals(description)||"".equals(createdDate)||"".equals(endDate)) {
			request.setAttribute("error", " value is blank");
			  // Chuyển hướng đến trang manageCategory.jsp và hiển thị thông báo lỗi
			 doGet(request, response);	
			 return;
		}
		if (!createdDate.matches(regexDate)|| !endDate.matches(regexDate)) {
			request.setAttribute("error", " Date invalid type");
			doGet(request, response);	
			 return;
		}
		FundDao dao = new FundDao();
		dao.updateFund(id, name, content, description, img_url, expectMoney, status, createdDate, endDate, category_id, foundation_id);
		String message = "<script>alert('Update success')</script>";
		request.setAttribute("message", message);
		request.getRequestDispatcher("/listFundController").forward(request, response);
		
	}

}
