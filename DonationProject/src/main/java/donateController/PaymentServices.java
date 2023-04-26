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

public class PaymentServices {
	private static final String CLIENT_ID = "AaTh4chQXlGhbDfEMiKBMa3LCr-HFmPbLh2pZNH4KQnrCAK1aQfDfmRPsXIm3T7--J4y1mqN97zOAQUW";
	private static final String CLIENT_SECRET = "EJ9O9-J7u-i5doO_z-79uFNqV_-oUIm5qkmcgl798eN3vIwUK8G952CfuTqPiBX36ywNXigjDZ3wxv31";
	private static final String MODE = "sandbox";

	public String authorizePayment(Donation donation)			
			throws PayPalRESTException {		

		Payer payer = getPayerInformation();
		RedirectUrls redirectUrls = getRedirectURLs();
		List<Transaction> listTransaction = getTransactionInformation(donation);
		Payment requestPayment = new Payment();
		requestPayment.setTransactions(listTransaction);
		requestPayment.setRedirectUrls(redirectUrls);
		requestPayment.setPayer(payer);
		requestPayment.setIntent("authorize");
		APIContext apiContext = new APIContext(CLIENT_ID,CLIENT_SECRET,MODE);

		Payment approvedPayment = requestPayment.create(apiContext);
		
		System.out.println("=== CREATED PAYMENT: ====");
		System.out.println(approvedPayment);

		return getApprovalLink(approvedPayment);

	}
	
	private Payer getPayerInformation() {
		Payer payer = new Payer();
		payer.setPaymentMethod("paypal");
		
		PayerInfo payerInfo = new PayerInfo();
		payerInfo.setFirstName("William")
				 .setLastName("Peterson")
				 .setEmail("xeboodam123@gmail.com");
		
		payer.setPayerInfo(payerInfo);
		
		return payer;
	}
	
	private RedirectUrls getRedirectURLs() {
		RedirectUrls redirectUrls = new RedirectUrls();
		redirectUrls.setCancelUrl("http://localhost:8080/PaypalTest/cancel.jsp");
		redirectUrls.setReturnUrl("http://localhost:8080/PaypalTest/review_payment");
		
		return redirectUrls;
	}
	// CREATE TRANSATCTIOON TO DONATE
	private List<Transaction> getTransactionInformation(Donation donation) {
		
		Details details = new Details();
		details.setSubtotal(donation.getMoney());

		Amount amount = new Amount();
		amount.setCurrency("USD");
		amount.setDetails(details);
//		Đoạn code này sử dụng đối tượng Transaction của PayPal API 
//		để mô tả thông tin về giao dịch thanh toán. Cụ thể, nó sử dụng đối tượng
//		Amount để xác định số tiền thanh toán và loại tiền tệ, 
//		sau đó gán đối tượng Amount này cho thuộc tính amount của đối tượng Transaction
		Transaction transaction = new Transaction();
		transaction.setAmount(amount);
		transaction.setDescription("Donate to fundID"+donation.getFund_id());
		
		ItemList itemList = new ItemList();
		List<Item> items = new ArrayList<>();
		Item item = new Item();
		item.setCurrency("USD");
		item.setPrice(donation.getMoney());
		items.add(item);
		itemList.setItems(items);
		transaction.setItemList(itemList);

		List<Transaction> listTransaction = new ArrayList<>();
		listTransaction.add(transaction);	
		
		return listTransaction;
	}
	
	private String getApprovalLink(Payment approvedPayment) {
		// Lấy ra danh sách các Link
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

		APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET);

		return payment.execute(apiContext, paymentExecution);
	}
	
	public Payment getPaymentDetails(String paymentId) throws PayPalRESTException {
		APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET);
		return Payment.get(apiContext, paymentId);
	}
}
