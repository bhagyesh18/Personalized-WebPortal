package webpart_package;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import connection.*;

import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Vbox;
import org.zkoss.zul.Vlayout;
import org.zkoss.zul.Window;

@SuppressWarnings({ "serial", "rawtypes" })
public class edit_webpart_ctrl extends GenericForwardComposer  {

	Button btnedit;
	Vlayout menu_button;
	Window Win_edit;
	ResultSet rs;
	
	Checkbox ch1;
	Checkbox ch2;
	Checkbox ch3;
	Checkbox ch4;
	Checkbox ch5;
	Checkbox ch6;
	Checkbox ch7;
	
	
	
	
 	@SuppressWarnings("unchecked")
	public void onCreate$Win_edit()
 	{
 		
 		
 		
 		try
		{
					queryclass select_panel=new queryclass();
					rs=select_panel.selectquery("SELECT pl.panel_name ,wp.status FROM webportal.personalized_panel wp, webportal.panel_master pl where pl.panel_status='1' and wp.status='0' and wp.panel_id=pl.panel_id and user_id='"+ session.getAttribute("user_id")+"';");
							while(rs.next())
							{
								
									if(rs.getString("panel_name").toString().equals("twiter_plugin") )
									{
										ch1.setChecked(false);
									}if(rs.getString("panel_name").toString().equals("wiki_plugin") )
									{
										ch2.setChecked(false);
									}
									if(rs.getString("panel_name").toString().equals("tool_plugin") )
									{
										ch3.setChecked(false);		
									}
									if(rs.getString("panel_name").toString().equals("linked_in_plugin") )
									{
										ch4.setChecked(false);
									}
									if(rs.getString("panel_name").toString().equals("clock_plugin") )
									{
										ch5.setChecked(false);	
									}
									if(rs.getString("panel_name").toString().equals("facebook_comment_plugin"))
									{
										ch6.setChecked(false);	
									}
									if(rs.getString("panel_name").toString().equals("clock_plugin") )
									{
										ch7.setChecked(false);
									}
									
											
											
								}
											
											
														
								}
								catch (Exception e) {
									
								}
					
					
								
								
									
									
											
								
		}
 	
 	
 	
 	public void onClick$btnedit()
 	{
 		
 		queryclass up_obj=new queryclass();
 		try
 		{
 		if(ch1.isChecked())
		{
 			up_obj.updatequery("UPDATE `webportal`.`personalized_panel` SET `status`=1 WHERE per_panel_id>1 and  `panel_id`='1'  and user_id='" + session.getAttribute("user_id").toString()+"';");	
		}
 		else
 		{
 			alert("yes");
 			up_obj.updatequery("UPDATE `webportal`.`personalized_panel` SET `status`=0 WHERE per_panel_id>1 and  `panel_id`='1' and user_id='" + session.getAttribute("user_id").toString()+"';");	
 			
 		}
 		
 		if(ch2.isChecked())
		{
			up_obj.updatequery("UPDATE `webportal`.`personalized_panel` SET `status`=1 WHERE  per_panel_id>1 and `panel_id`='2' and user_id='" + session.getAttribute("user_id").toString()+"';");	
			
		}else
 		{
			up_obj.updatequery("UPDATE `webportal`.`personalized_panel` SET `status`=0 WHERE  per_panel_id>1 and  per_panel_id>1 and `panel_id`='2' and user_id='" + session.getAttribute("user_id").toString()+"';");	
			
 		}
 		
 		
		if(ch3.isChecked())
		{
			up_obj.updatequery("UPDATE `webportal`.`personalized_panel` SET `status`=1 WHERE  per_panel_id>1 and `panel_id`='3' and user_id='" + session.getAttribute("user_id").toString()+"';");	
			
		}else
 		{
			up_obj.updatequery("UPDATE `webportal`.`personalized_panel` SET `status`=0 WHERE  per_panel_id>1 and `panel_id`='3' and user_id='" + session.getAttribute("user_id").toString()+"';");	
			
 		}
		
		
		if(ch4.isChecked())
		{
			up_obj.updatequery("UPDATE `webportal`.`personalized_panel` SET `status`=1 WHERE  per_panel_id>1 and `panel_id`='4' and user_id='" + session.getAttribute("user_id").toString()+"';");	
			
		}else
 		{
			up_obj.updatequery("UPDATE `webportal`.`personalized_panel` SET `status`=0 WHERE per_panel_id>1 and  `panel_id`='4' and user_id='" + session.getAttribute("user_id").toString()+"';");	
			
 		}
		
		
		if(ch5.isChecked())
		{
			up_obj.updatequery("UPDATE `webportal`.`personalized_panel` SET `status`=1 WHERE  per_panel_id>1 and `panel_id`='5' and user_id='" + session.getAttribute("user_id").toString()+"';");	
				
		}else
 		{
			up_obj.updatequery("UPDATE `webportal`.`personalized_panel` SET `status`=0 WHERE  per_panel_id>1 and `panel_id`='5' and user_id='" + session.getAttribute("user_id").toString()+"';");	
			
 		}
		
		
		if(ch6.isChecked())
		{
			up_obj.updatequery("UPDATE `webportal`.`personalized_panel` SET `status`=1 WHERE  per_panel_id>1 and `panel_id`='6' and user_id='" + session.getAttribute("user_id").toString()+"';");	
			
		}else
 		{
			up_obj.updatequery("UPDATE `webportal`.`personalized_panel` SET `status`=0 WHERE  per_panel_id>1 and `panel_id`='6' and user_id='" + session.getAttribute("user_id").toString()+"';");	
			
 		}
		
		
		if(ch7.isChecked())
		{
			up_obj.updatequery("UPDATE `webportal`.`personalized_panel` SET `status`=1 WHERE  per_panel_id>1 and `panel_id`='7' and user_id='" + session.getAttribute("user_id").toString()+"';");	
				
		}else
 		{
			up_obj.updatequery("UPDATE `webportal`.`personalized_panel` SET `status`=0 WHERE per_panel_id>1 and `panel_id`='7' and user_id='" + session.getAttribute("user_id").toString()+"';");	
		
 			
 		}
 		}
 		catch (Exception e) {
			alert(e.getMessage());
		}
		alert("your preference has been saved successfully");
 	}
 	
 	
 	
}
