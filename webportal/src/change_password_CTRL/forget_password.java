package change_password_CTRL;

import java.sql.ResultSet;
import java.util.Properties;
import java.util.Random;

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
import connection.*;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import link.popup_windows;

import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

@SuppressWarnings({ "serial", "rawtypes" })
public class forget_password extends GenericForwardComposer{

	
	Window win_forgot_password;
	
	Textbox txtuname; 
	Textbox txtemail;
	
	Textbox txtsecque; 
	Textbox txtsecans;
	Button btnsend;
	ResultSet rs1;
	
	String temp;
	public void onCreate$win_forgot_password()
	{
		win_forgot_password.doModal();
		
		
		try
		{
			
			
			
		}
		catch(Exception e)
		{
			
		}
		
	}
	public void onClick$btnsend()
	{
		
		try
		{
			
			queryclass obj1=new queryclass();
			ResultSet rs1=obj1.selectquery("select * from user_master where username='" + txtuname.getValue().toString() + "' and security_answer='" + txtsecans.getValue().toString() + "' ");
			if(rs1.next())
			{
				
			
			
			char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
			StringBuilder sb = new StringBuilder();
			Random random = new Random();
			for (int i = 0; i < 10; i++) {
			    char c = chars[random.nextInt(chars.length)];
			    sb.append(c);
			}
			String output = sb.toString();
			
			
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
						InternetAddress.parse(txtemail.getValue()));
				
				message.setSubject("New Password From WEB Poratl");
				message.setText("New Password Generated from system is : " + output);
		
				Transport.send(message);
	 
				System.out.println("Done");
				Messagebox.show("New Pasword has been sent in Email successfully");
				 //txtto.setValue("");
				
				obj1.updatequery("UPDATE `webportal`.`user_master` SET `password`='"+ output +"' WHERE `username`='" +txtuname.getValue().toString()+ "';");
				
				
			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
			
			}
			else
			{
				alert("Your Deatils is Wrong ");
				
			}
			win_forgot_password.detach();
			
		}
		catch(Exception e)
		{
			
		}
	}
	
}
