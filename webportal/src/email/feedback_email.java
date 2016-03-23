package email;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

@SuppressWarnings("rawtypes")
public class feedback_email extends GenericForwardComposer {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Window feedback_win;
	String to,cc,message,from,password;
	Button btnfeedback;
	Textbox txtto;
	Textbox txtmessage;
	Textbox txtcc;
	Textbox txtsubject;
	Textbox txtpassword;
	
	public void onClick$btnfeedback()
	{
	
		
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
 
		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("bhagyesh18@gmail.com","dream@9879032183");
				}
			});
 
		try {
 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("bhagyesh18@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("bhagyesh18@gmail.com"));
			
			
			message.setSubject("feedback of user");
			message.setText(txtmessage.getValue());
 
			Transport.send(message);
 
			System.out.println("Done");
			
			
			Messagebox.show("feedback recieved successfully");
			 //txtto.setValue("");
			 txtmessage.setValue("");
			
			
 
		} catch (MessagingException e) {
			Messagebox.show(e.getMessage());
			throw new RuntimeException(e);
		}
	}
}