package fundController;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDao;
import dao.FoundationDao;
import dao.FundDao;
import model.Category;
import model.Foundation;

/**
 * Servlet implementation class addFund
 */
@WebServlet("/addFund")
public class addFund extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addFund() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Category> listActiveCategory = new CategoryDao().activeCategory();
		List<Foundation> listActiveFoundation = new FoundationDao().activeFoundation();
		request.setAttribute("listC", listActiveCategory);
		request.setAttribute("listF", listActiveFoundation);
		try {
			request.getRequestDispatcher("addFund.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String name = request.getParameter("name");
			String des = request.getParameter("description");
			String status  = request.getParameter("status");
			String category = request.getParameter("category");
			String foundation = request.getParameter("foundation");
			int categoryID = new CategoryDao().getIdByName(category).getId();
			int foundstionID = new FoundationDao().getIdByName(foundation).getId();
			String content = request.getParameter("content");
			String imgURL = request.getParameter("imgURL");
			String expectMoney = request.getParameter("expectMoney");
			
			String createdDate = request.getParameter("createdDate");
			String  endDate = request.getParameter("endDate");
			String regexDate = "^\\d{4}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$";
			if("".equals(name) || 	"".equals(des)||
					"".equals(content)||"".equals(expectMoney)||"".equals(endDate)||"".equals(createdDate)) {
				 request.setAttribute("error", " value is blank");
				  // và hiển thị thông báo lỗi
				 doGet(request, response);				
				 return;
			}
			if(!createdDate.matches(regexDate)||!endDate.matches(regexDate)) {
				request.setAttribute("error", " Date invalid");
				  // và hiển thị thông báo lỗi
				 doGet(request, response);				
				 return;
			}
			
			FundDao dao = new FundDao();
			float money = Float.parseFloat(expectMoney);
			dao.insertFund(name,des,content,imgURL,money,status,createdDate,endDate,categoryID,foundstionID);	
			String message = "<script>alert('Add Category Successfully')</script>";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/listFundController").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "Fail to Add Fund");

			  // Chuyển hướng đến trang manageCategory.jsp và hiển thị thông báo lỗi
//			  RequestDispatcher dispatcher = request.getRequestDispatcher("addFund");
//			  dispatcher.forward(request, response);
		}
	}
	

}
