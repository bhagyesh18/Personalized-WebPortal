package leave_absent;

import java.sql.ResultSet;

import org.joda.time.DateTime;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Textbox;

import connection.queryclass;

@SuppressWarnings({ "rawtypes", "serial" })
public class leave_absent_ctrl extends GenericForwardComposer {
	Combobox chkemp_id;
	Combobox chkleavetype;
	Textbox txtldays;
	
	public void onClick$btnabsent()
	{
		final String temp_emp_id;
		final String temp_leavetype_id;
		try
		{
		ResultSet rs2;
		String leave_id = null;
		queryclass obj1=new queryclass();
		rs2=obj1.selectquery("SELECT * FROM webportal.leave_master where leavetype='" +chkleavetype.getValue().toString() + "';");
		if(rs2.next())
		{
			leave_id=rs2.getString("leavetype_id");
		}
		
		alert(leave_id);
		DateTime d=new DateTime(System.currentTimeMillis());
		int year;
		year=d.getYear();
		String temp_year=String.valueOf(year);
		
		queryclass obj_approve=new queryclass();
		obj_approve.updatequery("UPDATE `webportal`.`leave_balance` SET `leave_taken`=leave_taken+"+ txtldays.getValue().toString() +",leave_pending=leave_pending-"+txtldays.getValue().toString()+"   WHERE `leavebalance_id`>0 and leavetype_id='"+ leave_id +"' and emp_id='"+ chkemp_id.getValue().toString() +"' and year='" + temp_year + "';");
		
		
		}
		catch (Exception e) {
			// TODO: handle exception
			
			alert(e.getMessage());
			
		}
		
	}
	
}
