package conversation;

import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Textbox;

import connection.queryclass;

@SuppressWarnings({ "serial", "rawtypes" })
public class send_message_CTRL extends GenericForwardComposer{

	
	Textbox txtto;
	Textbox txtsubject;
	Textbox txtmessage;
	Button btnsend;
	ResultSet rs_mes;
	public void onClick$btnsend()
	{
		
		try
		{
			
		
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();				
			String send_date=dateFormat.format(date);
			

			DateFormat dateFormat1 = new SimpleDateFormat("HH:mm:ss");
			Date date1 = new Date();				
			String send_time=dateFormat1.format(date1);
			
			//alert(txtmessage.getValue());
		
			
			queryclass mes=new queryclass();
			mes.insertquery("INSERT INTO messaging (`to_user`, `from_user`, `subject`, `message`, `date`, `time`, `status`) VALUES ('" + txtto.getValue().toString() + "', '"+ session.getAttribute("username") +"', '" + txtsubject.getValue().toString() + "', '"+ txtmessage.getValue().toString() +"', '"+ send_date+"', '" + send_time+ "', '0');");
			alert("meessgae sent succefully ");
			
			
		}
		catch(Exception e)
		{
			alert(e.getMessage());
		}
		
	}
	
	
}
