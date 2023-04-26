package util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.activation.*;


public class Email {

	//pwuitpynkpeysoxy xeboodam124@gmail.com
	
	public static void main(String[] args) throws Exception {
		Email email = new Email();
		email.sendEmail("damtfx17727@funix.edu.vn", "username128");

	}
	// email 
	private String from = "xeboodam123@gmail.com";
	private static String to = "xeboodam123@gmail.com";
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	
	public void sendEmail(String toEmail,String username) {

		 try {
			//property
				Properties prop = new Properties();
				prop.put("mail.smtp.host", "smtp.gmail.com"); //SMTP HOST
		        prop.put("mail.smtp.port", "587"); //TSL 587 SSL 465
		        prop.put("mail.smtp.auth", "true");
		        prop.put("mail.smtp.starttls.enable", "true"); //TLS
		        prop.put("mail.smtp.socketFactory.class",
		        		"javax.net.ssl.SSLSocketFactory");
				// create authenticator
				Authenticator auth = new Authenticator() {

					@Override
					protected PasswordAuthentication getPasswordAuthentication() {
						// TODO Auto-generated method stub
						return new PasswordAuthentication(from, "tlaavbgyppthmxog");
					}
					
				};
			// sesion
				Session session = Session.getInstance(prop, auth);
				// send email
				// create message
				 MimeMessage message = new MimeMessage(session);
				
			 // type content
			 message.addHeader("Content-type","text/html;charset=UTF-8");
			 message.setFrom(from);
			 //  revice people
			 message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail,false));
			 message.setSubject("Register Validation");
			 //content
			 //Create a MimeMultipart object to hold the HTML content and set the content type to "text/html".
			 MimeMultipart multipart = new MimeMultipart();
			 multipart.setSubType("related");
			// Create HTML part
			 MimeBodyPart messageBodyPart = new MimeBodyPart();
			 String htmlText = "<html>"
			 		+ "<body>"
			 		+ "<a href='http://localhost:8080/DonationProject/VerifiedEmail?username="+username+"'>"
			 				+ " click here to  verified account </a>"
			 				+ "</body>"
			 				+ "</html>";
			 messageBodyPart.setContent(htmlText, "text/html");
			 multipart.addBodyPart(messageBodyPart);
			 message.setContent(multipart);
			 //message.setText(content);
			 // send email
			 Transport.send(message);
			    System.out.println("HTML email sent successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	public void resetPassword(String toEmail,String newPassword) {

		 try {
			//property
				Properties prop = new Properties();
				prop.put("mail.smtp.host", "smtp.gmail.com"); //SMTP HOST
		        prop.put("mail.smtp.port", "587"); //TSL 587 SSL 465
		        prop.put("mail.smtp.auth", "true");
		        prop.put("mail.smtp.starttls.enable", "true"); //TLS
		        prop.put("mail.smtp.socketFactory.class",
		        		"javax.net.ssl.SSLSocketFactory");
				// create authenticator
				Authenticator auth = new Authenticator() {

					@Override
					protected PasswordAuthentication getPasswordAuthentication() {
						// TODO Auto-generated method stub
						return new PasswordAuthentication(from, "tlaavbgyppthmxog");
					}
					
				};
			// sesion
				Session session = Session.getInstance(prop, auth);
				// send email
				// create message
				 MimeMessage message = new MimeMessage(session);
				
			 // type content
			 message.addHeader("Content-type","text/html;charset=UTF-8");
			 message.setFrom(from);
			 //  revice people
			 message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail,false));
			 message.setSubject("Register Validation");
			 //content
			 //Create a MimeMultipart object to hold the HTML content and set the content type to "text/html".
			 MimeMultipart multipart = new MimeMultipart();
			 multipart.setSubType("related");
			// Create HTML part
			 MimeBodyPart messageBodyPart = new MimeBodyPart();
			 String htmlText = "<html>"
			 		+ "<body>"
			 		+ "<p>"+"New Password: "+newPassword
			 				+ "  </p>"
			 				+ "</body>"
			 				+ "</html>";
			 messageBodyPart.setContent(htmlText, "text/html");
			 multipart.addBodyPart(messageBodyPart);
			 message.setContent(multipart);
			 //message.setText(content);
			 // send email
			 Transport.send(message);
			    System.out.println("HTML email sent successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	

}

