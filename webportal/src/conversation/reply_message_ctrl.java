package conversation;

import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.zkoss.lang.Exceptions;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import connection.queryclass;

@SuppressWarnings({ "rawtypes", "serial" })
public class reply_message_ctrl extends GenericForwardComposer{

Window win_reply_msg;

	Textbox txtto;
	Textbox txtsubject;
	Textbox txtmessage;
	Button btnreply;
	ResultSet rs_mes;
	public void onCreate$win_reply_msg()
	{
		txtto.setValue(requestScope.get("to").toString());
		txtsubject.setValue(requestScope.get("subject").toString());
		txtmessage.setValue(requestScope.get("message").toString());
		
	}
	
	public void onClick$btnreply()
	{
		
		try
		{
			
		
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();				
			String send_date=dateFormat.format(date);
			

			DateFormat dateFormat1 = new SimpleDateFormat("HH:mm:ss");
			Date date1 = new Date();				
			String send_time=dateFormat1.format(date1);
			
			
			queryclass mes=new queryclass();
			mes.insertquery("INSERT INTO messaging (`to_user`, `from_user`, `subject`, `message`, `date`, `time`, `status`) VALUES ('" + txtto.getValue().toString() + "', '"+ session.getAttribute("username") +"', '" + txtsubject.getValue().toString() + "', '"+ txtmessage.getValue().toString() +"', '"+ send_date+"', '" + send_time+ "', '0');");
			alert("meessgae sent succefully ");
			win_reply_msg.detach();
			
			
		}
		catch(Exception e)
		{
			alert(e.getMessage());
		}
		
	}
	
	
}
