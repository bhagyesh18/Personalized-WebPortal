package grid_controller;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Textbox;

import connection.queryclass;

@SuppressWarnings({ "serial", "rawtypes" })
public class SubmitReportInsert extends GenericForwardComposer {
	
	Textbox txtwd;
	Textbox txts;
	Button btnsubmit;
	    
	public void onClick$btnsubmit()
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();				
		String report_date=dateFormat.format(date);
		alert(report_date);
		queryclass obj=new queryclass();
		String query="INSERT INTO `webportal`.`work_report` (`emp_id`, `report_date`, `work_description`, `status`) VALUES ('"+(String)session.getAttribute("emp_id")+"', '"+report_date+"', '"+txtwd.getValue().toString()+"', 1)";
		obj.insertquery(query);
	}
}
