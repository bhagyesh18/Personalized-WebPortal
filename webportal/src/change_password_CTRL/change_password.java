package change_password_CTRL;

import java.sql.ResultSet;

import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;
import connection.*;

@SuppressWarnings("rawtypes")
public class change_password extends GenericForwardComposer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8726248125253295254L;

	ResultSet rs;
	
	Window win_change_password;
	Textbox txtuname; 
	Textbox txtemp_id; 
	Textbox txtsecque; 
	Textbox txtsecans;
	Textbox txtoldpwd ;
	Textbox txtpwd;
	Button btnchange;
	ResultSet rs1;
	
	String temp;
	
	public void onCreate$win_change_password()
	{
		
		try
		{
			queryclass obj=new queryclass();
			rs=obj.selectquery("SELECT * FROM webportal.user_master where user_id='" + session.getAttribute("user_id") +"';");
			if(rs.next())
			{
				txtuname.setValue(rs.getString("username"));
				txtsecque.setValue(rs.getString("security_question"));
				txtsecans.setValue(rs.getString("security_answer"));
				temp=rs.getString("password").toString();
				
			}
		}
		catch(Exception e)
		{
			
		}
	}
	
	public void onClick$btnchange()
	{
	
		
		if(txtoldpwd.getValue().toString().equals(temp))
		{
			try
			{
				queryclass obj1=new queryclass();
				obj1.updatequery("UPDATE `webportal`.`user_master` SET `password`='"+ txtpwd.getValue().toString() +"' WHERE `user_id`='"+ session.getAttribute("user_id").toString()+"';");
				
			}
			catch(Exception e)
			{
			}
			
		}
		else
		{
			
			alert("Your old Password is wrong");
		}
		
		alert("password Saved Successfully");
	}
	
}
