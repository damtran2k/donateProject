package donateController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.paypal.base.rest.PayPalRESTException;

import bean.User;
import dao.DonationDao;
import model.Donation;
import model.OrderDetail;

/**
 * Servlet implementation class authorizePayment
 */
@WebServlet("/authorizePayment")
public class authorizePayment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public authorizePayment() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			User user = (User)request.getSession();
			Integer userId = user.getId();
			String userName = user.getName();
			String fundName = request.getParameter("fundName");
			request.setAttribute("userID", userId);
			request.setAttribute("fundName", fundName);
			request.getRequestDispatcher("donate.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			Float money = Float.parseFloat(request.getParameter("money"));
	        Integer usernameId = Integer.parseInt(request.getParameter("usernameID"));
	        Integer fundId = Integer.parseInt(request.getParameter("fundID"));
	        String message = request.getParameter("message");
	        DonationDao dao = new DonationDao();
	       int id = dao.getTotalItems() +1;
	       Donation donatation = new Donation(id,money,usernameId,fundId,message);
	       
	       
	       String product = 100+"";
			String subtotal = 100+"";
			String shipping = 10+"";
			String tax = 10+"";
			String total = 120+"";
	       OrderDetail orderDetail = new OrderDetail(product, subtotal,shipping, tax, total);
	       //OrderDetail orderDetail = new OrderDetail(product, total);
	        try {
	            PaymentServices1 paymentServices = new PaymentServices1();
	            String approvalLink = paymentServices.authorizePayment(orderDetail);
	 
	            response.sendRedirect(approvalLink);
	             
	        } catch (PayPalRESTException ex) {
	    
	            ex.printStackTrace();
	            request.getRequestDispatcher("error.jsp").forward(request, response);
	        }
	    
	}

}
