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
public class emp_email_sender extends GenericForwardComposer {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Window email_win;
	String to,cc,message,from,password;
	Button btnsend;
	Textbox txtto;
	Textbox txtmessage;
	Textbox txtcc;
	Textbox txtsubject;
	Textbox txtpassword;
	
	public void onClick$btnsend()
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
					return new PasswordAuthentication("bhagyesh18@gmail.com",txtpassword.getValue());
				}
			});
 
		try {
 
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("bhagyesh18@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(txtto.getValue()));
			String tt;
			tt=txtcc.getValue();
			
			if(tt==null)
			{
			message.setRecipients(Message.RecipientType.CC,
					InternetAddress.parse(txtcc.getValue()));
			}
			message.setSubject(txtsubject.getValue());
			message.setText(txtmessage.getValue());
 
			Transport.send(message);
 
			System.out.println("Done");
			Messagebox.show("Email sent successfully");
			 //txtto.setValue("");
			 txtmessage.setValue("");
			 txtcc.setValue("");
			 txtsubject.setValue("");
			 txtpassword.setValue("");
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}