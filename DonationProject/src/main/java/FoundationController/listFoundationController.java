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
 * Servlet implementation class listFoundationController
 */
@WebServlet("/listFoundationController")
public class listFoundationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listFoundationController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		//  Get Infor from CategoryDao
			FoundationDao listFoundationDao = new FoundationDao();
			int amountItem = 6;
			String indexPage = request.getParameter("index");
			if (indexPage == null) {
				indexPage ="1";
			}
			int index = Integer.parseInt(indexPage);
		
			int count = listFoundationDao.getTotalItems();
			int endPage = count/amountItem;
			if(count%amountItem !=0) {
				endPage++;
			}
			request.setAttribute("endPage", endPage);
			request.setAttribute("amount", amountItem);
			request.setAttribute("count",count);
			try {
				List<Foundation> list = listFoundationDao.pagingFoundation(index, amountItem);
				// Set data and transfer to web
				request.setAttribute("list", list);
				//phan trang du lieu
				request.getRequestDispatcher("manageFoundation.jsp").forward(request, response);	
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
