package donateController;

import java.util.ArrayList;
import java.util.List;

import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Details;
import com.paypal.api.payments.Item;
import com.paypal.api.payments.ItemList;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.PayerInfo;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.PaymentExecution;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;

import model.Donation;
import model.OrderDetail;


public class PaymentServices1 {
	private static final String CLIENT_ID = "Ac9QNovBgxrdNh_ZTlH3nEkijf0F_ZrCND8slsFfzOX6G7lvOEIfVvMrbcz1oxv5czl_nTGD185DBKY-";
	
	private static final String CLIENT_SECRET = "EApLX8KsT5e20MeSmDOL8X6t3dcrv2MuoXOh2sULXme-p9Bj3QBB5NqW5GgbVkFYBQ_FGKgnm5-lzhYc";
	private static final String MODE = "sandbox";

	public String authorizePayment(OrderDetail orderDetail)			
			throws PayPalRESTException {		
		//Phương thức này trả về thông tin về người thanh toán (payer)
		Payer payer = getPayerInformation();
		// Phương thức này trả về các URL để chuyển hướng người dùng sau khi thanh toán được xác thực thành công hoặc thất bại
		RedirectUrls redirectUrls = getRedirectURLs();
		
		List<Transaction> listTransaction = getTransactionInformation(orderDetail);
		//Phương thức này truyền vào thông tin về đơn hàng (orderDetail)
		//và trả về một danh sách các giao dịch (transactions) liên quan đến đơn hàng này.
		Payment requestPayment = new Payment();
		requestPayment.setTransactions(listTransaction);
		requestPayment.setRedirectUrls(redirectUrls);
		requestPayment.setPayer(payer);
		requestPayment.setIntent("authorize");
		//Tạo một đối tượng APIContext với thông tin xác thực của bạn,
		//bao gồm CLIENT_ID, CLIENT_SECRET và MODE (chế độ hoạt động của PayPal: sandbox hoặc production).
		APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);

		Payment approvedPayment = requestPayment.create(apiContext);

		System.out.println("=== CREATED PAYMENT: ====");
		System.out.println(approvedPayment);
		//phương thức trả về URL để người dùng có thể chuyển hướng đến trang xác nhận thanh toán 
		//(approval link) từ đối tượng Payment đã được xác thực. 
		//Người dùng sẽ sử dụng link này để tiếp tục quá trình thanh toán trên PayPal.
		return getApprovalLink(approvedPayment);

	}
	
	private Payer getPayerInformation() {
		Payer payer = new Payer();
		payer.setPaymentMethod("paypal");
		
		PayerInfo payerInfo = new PayerInfo();
		payerInfo.setFirstName("test")
				 .setLastName("test")
				 .setEmail("xeboodam123@gmail.com");
		
		payer.setPayerInfo(payerInfo);
		
		return payer;
	}
	
	private RedirectUrls getRedirectURLs() {
		RedirectUrls redirectUrls = new RedirectUrls();
//		redirectUrls.setCancelUrl("http://localhost:8080/PaypalTest/cancel.jsp");
//		redirectUrls.setReturnUrl("http://localhost:8080/PaypalTest/review_payment");
		redirectUrls.setCancelUrl("http://localhost:8080/DonationProject/cancel.jsp");
		redirectUrls.setReturnUrl("http://localhost:8080/DonationProject/review_payment");
		
		return redirectUrls;
	}
	
	private List<Transaction> getTransactionInformation(OrderDetail orderDetail) {
		Details details = new Details();
		details.setShipping(orderDetail.getShipping());
		details.setSubtotal(orderDetail.getSubtotal());
		details.setTax(orderDetail.getTax());

		Amount amount = new Amount();
		amount.setCurrency("USD");
		amount.setTotal(orderDetail.getTotal());
		amount.setDetails(details);

		Transaction transaction = new Transaction();
		transaction.setAmount(amount);
		transaction.setDescription(orderDetail.getProductName());
		
		ItemList itemList = new ItemList();
		List<Item> items = new ArrayList<>();
		
		Item item = new Item();
		item.setCurrency("USD");
		item.setName(orderDetail.getProductName());
		item.setPrice(orderDetail.getSubtotal());
		item.setTax(orderDetail.getTax());
		item.setQuantity("1");
		
		items.add(item);
		itemList.setItems(items);
		transaction.setItemList(itemList);

		List<Transaction> listTransaction = new ArrayList<>();
		listTransaction.add(transaction);	
		
		return listTransaction;
	}
	
	private String getApprovalLink(Payment approvedPayment) {
		List<Links> links = approvedPayment.getLinks();
		String approvalLink = null;
		
		for (Links link : links) {
			if (link.getRel().equalsIgnoreCase("approval_url")) {
				approvalLink = link.getHref();
				break;
			}
		}		
		
		return approvalLink;
	}

	public Payment executePayment(String paymentId, String payerId) throws PayPalRESTException {
		PaymentExecution paymentExecution = new PaymentExecution();
		paymentExecution.setPayerId(payerId);

		Payment payment = new Payment().setId(paymentId);

		APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);

		return payment.execute(apiContext, paymentExecution);
	}
	
	public Payment getPaymentDetails(String paymentId) throws PayPalRESTException {
		APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);
		return Payment.get(apiContext, paymentId);
	}
}
