package link;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Iframe;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Popup;
import org.zkoss.zul.Vlayout;
import org.zkoss.zul.Window;

import connection.queryclass;
@SuppressWarnings("rawtypes")
public class user_role_link extends GenericForwardComposer implements ActionListener{
Vlayout menu_link;
public String btnarray[];
	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	Button btnregistration;
	Button btnemail;
	Iframe ifrmload;
	
	Window winReg;
	Popup popup;
	ResultSet rs3;
	ResultSet rs4;
	
	@SuppressWarnings("unchecked")
	public void onCreate$menu_link()
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		
		//Messagebox.show(dateFormat.format(date));
		//alert((String)session.getAttribute("emp_id"));
		
			try
			{
					
					queryclass newuserlink =new queryclass();
					queryclass select_link_obj =new queryclass();
					queryclass insert_link_obj =new queryclass();
					final queryclass obj=new queryclass();
					
					rs3=newuserlink.selectquery("select * from webportal.personalized_links where user_id='" +  session.getAttribute("user_id") + "';");
					
					if(rs3.first()==false)
					{
						rs4=select_link_obj.selectquery("SELECT link_id FROM webportal.link_details where user_role_id='" + session.getAttribute("user_role_id")+ "' ;")	;
						while(rs4.next())
						{
							insert_link_obj.insertquery("INSERT INTO `webportal`.`personalized_links` (`user_id`, `link_id`, `accessed`) VALUES ('" + session.getAttribute("user_id")  + "', '" + rs4.getString("link_id")+ "', '1');");

						}
						alert("You Are First Time Logged in and System has setuped your personlized views for you. So Logged in Again");
						
						
					}
					else
					{
					
					    
						try
				        {
				    	   
				      	  	String str="SELECT link_name FROM webportal.personalized_links LEFT JOIN webportal.link_master ON webportal.personalized_links.link_id = webportal.link_master.link_id where webportal.personalized_links.user_id= '"  + session.getAttribute("user_id").toString() + "' order by accessed desc;";
				    	    ResultSet rs=  obj.selectquery(str);
						    
						Button btn;
						while(rs.next())
				             {
							
								btn=new Button();
								btn.setId(rs.getString("link_name"));
								btn.setLabel(rs.getString("link_name"));
								btn.setWidth("130px");
								btn.setSclass("classname");
								
								menu_link.appendChild(btn);
							
					              btn.addEventListener(Events.ON_CLICK, new EventListener() {
					                  public void onEvent(Event event) throws Exception {
					                	  if(event.toString().contains("Registration"))
					                	  {
					                		  ifrmload.setSrc("registration.zul");
					                		  obj.updatequery("UPDATE `webportal`.`personalized_links` SET `accessed`=accessed+1 WHERE `per_link_id`>= '1' and link_id=1 and user_id='" + session.getAttribute("user_id").toString()+ "';");
					                		
					                	  }
					                	  if(event.toString().contains("Leave Approval"))
					                	  {
					                		  ifrmload.setSrc("leave_approval.zul");
					                		  obj.updatequery("UPDATE `webportal`.`personalized_links` SET `accessed`=accessed+1 WHERE `per_link_id`>= '1' and link_id=2 and user_id='" + session.getAttribute("user_id").toString()+ "';");
					                		
					                	  }
					                	  if(event.toString().contains("Email"))
					                	  {
					                		  ifrmload.setSrc("email.zul");
					                		  obj.updatequery("UPDATE `webportal`.`personalized_links` SET `accessed`=accessed+1 WHERE `per_link_id`>= '1' and link_id=3 and user_id='" + session.getAttribute("user_id").toString()+ "';");
					                		
					                	  }
					                	  if(event.toString().contains("Manage Reports"))
					                	  {
					                		  ifrmload.setSrc("mange_reports.zul");
					                		  obj.updatequery("UPDATE `webportal`.`personalized_links` SET `accessed`=accessed+1 WHERE `per_link_id`>= '1' and link_id=4 and user_id='" + session.getAttribute("user_id").toString()+ "';");
					                		
					                	  }
					                	  if(event.toString().contains("Manage Salary"))
					                	  {
					                		  ifrmload.setSrc("manage_salary.zul");
					                		  obj.updatequery("UPDATE `webportal`.`personalized_links` SET `accessed`=accessed+1 WHERE `per_link_id`>= '1' and link_id=5 and user_id='" + session.getAttribute("user_id").toString()+ "';");
					                		
					                	  }
					                	  if(event.toString().contains("Payslip"))
					                	  {
					                		  ifrmload.setSrc("payslip.zul");
					                		 obj.updatequery("UPDATE `webportal`.`personalized_links` SET `accessed`=accessed+1 WHERE `per_link_id`>= '1' and link_id=6 and user_id='" + session.getAttribute("user_id").toString()+ "';");
					                		
					                	  }
					                	  if(event.toString().contains("Leave Request"))
					                	  {
					                		  ifrmload.setSrc("leave_request.zul");
					                		  obj.updatequery("UPDATE `webportal`.`personalized_links` SET `accessed`=accessed+1 WHERE `per_link_id`>= '1' and link_id=7 and user_id='" + session.getAttribute("user_id").toString()+ "';");
					                		
					                	  }
					                	  if(event.toString().contains("Submit Report"))
					                	  {
					                		  ifrmload.setSrc("submit_report.zul");
					                		  obj.updatequery("UPDATE `webportal`.`personalized_links` SET `accessed`=accessed+1 WHERE `per_link_id`>= '1' and link_id=8 and user_id='" + session.getAttribute("user_id").toString()+ "';");
					                		
					                	  }
					                	  if(event.toString().contains("Profile"))
					                	  {
					                		  ifrmload.setSrc("Emp_profile.zul");
					                		  obj.updatequery("UPDATE `webportal`.`personalized_links` SET `accessed`=accessed+1 WHERE `per_link_id`>= '1' and link_id=9 and user_id='" + session.getAttribute("user_id").toString()+ "';");
					                		
					                	  }
					                	  if(event.toString().contains("Add Links"))
					                	  {
					                		  ifrmload.setSrc("add_link.zul");
					                		 obj.updatequery("UPDATE `webportal`.`personalized_links` SET `accessed`=accessed+1 WHERE `per_link_id`>= '1' and link_id=10 and user_id='" + session.getAttribute("user_id").toString()+ "';");
					                		
					                	  }
					                	  if(event.toString().contains("Designation"))
					                	  {
					                		  ifrmload.setSrc("emp_designation.zul");
					                		  obj.updatequery("UPDATE `webportal`.`personalized_links` SET `accessed`=accessed+1 WHERE `per_link_id`>= '1' and link_id=11 and user_id='" + session.getAttribute("user_id").toString()+ "';");
					                		
					                	  }
					                	  if(event.toString().contains("Manage max Leaves"))
					                	  {
					                		  ifrmload.setSrc("grid_maxLeave.zul");
					                		 obj.updatequery("UPDATE `webportal`.`personalized_links` SET `accessed`=accessed+1 WHERE `per_link_id`>= '1' and link_id=12 and user_id='" + session.getAttribute("user_id").toString()+ "';");
					                		
					                	  }
					                	  if(event.toString().contains("Employee Details"))
					                	  {
					                		  ifrmload.setSrc("grid_employee.zul");
					                		  obj.updatequery("UPDATE `webportal`.`personalized_links` SET `accessed`=accessed+1 WHERE `per_link_id`>= '1' and link_id=13 and user_id='" + session.getAttribute("user_id").toString()+ "';");
					                		
					                	  }
					                	  if(event.toString().contains("Leave Details"))
					                	  {
					                		  ifrmload.setSrc("grid_leavedetail.zul");
					                		  obj.updatequery("UPDATE `webportal`.`personalized_links` SET `accessed`=accessed+1 WHERE `per_link_id`>= '1' and link_id=14 and user_id='" + session.getAttribute("user_id").toString()+ "';");
					                		
					                	  }
					                	  if(event.toString().contains("change Password"))
					                	  {
					                		  ifrmload.setSrc("Change_password.zul");
					                		  obj.updatequery("UPDATE `webportal`.`personalized_links` SET `accessed`=accessed+1 WHERE `per_link_id`>= '1' and link_id=15 and user_id='" + session.getAttribute("user_id").toString()+ "';");
					                		
					                	  }
					                	  if(event.toString().contains("Check Leaves"))
					                	  {
					                		  ifrmload.setSrc("grid_leaveBalance.zul");
					                		  obj.updatequery("UPDATE `webportal`.`personalized_links` SET `accessed`=accessed+1 WHERE `per_link_id`>= '1' and link_id=16 and user_id='" + session.getAttribute("user_id").toString()+ "';");
						                		
					                	  }
					                	  if(event.toString().contains("Salary Detail"))
					                	  {
					                		  ifrmload.setSrc("grid_salary.zul");
					                		  obj.updatequery("UPDATE `webportal`.`personalized_links` SET `accessed`=accessed+1 WHERE `per_link_id`>= '1' and link_id=17 and user_id='" + session.getAttribute("user_id").toString()+ "';");
						                		
					                	  }
					                	  if(event.toString().contains("Check Leave Status"))
					                	  {
					                		  ifrmload.setSrc("check_Leave_req_status.zul");
					                		  obj.updatequery("UPDATE `webportal`.`personalized_links` SET `accessed`=accessed+1 WHERE `per_link_id`>= '1' and link_id=18 and user_id='" + session.getAttribute("user_id").toString()+ "';");
						                		
					                	  }
					                	  if(event.toString().contains("Make Employee Absent"))
					                	  {
					                		  ifrmload.setSrc("make_emp_Absent.zul");
					                		  obj.updatequery("UPDATE `webportal`.`personalized_links` SET `accessed`=accessed+1 WHERE `per_link_id`>= '1' and link_id=19 and user_id='" + session.getAttribute("user_id").toString()+ "';");
						                		
					                	  }
					                	  if(event.toString().contains("Send message"))
					                	  {
					                		  ifrmload.setSrc("send_message.zul");
					                		  obj.updatequery("UPDATE `webportal`.`personalized_links` SET `accessed`=accessed+1 WHERE `per_link_id`>= '1' and link_id=20 and user_id='" + session.getAttribute("user_id").toString()+ "';");
						                		
					                	  }
					                	  if(event.toString().contains("Show Message"))
					                	  {
					                		  ifrmload.setSrc("show_messages.zul");
					                		  obj.updatequery("UPDATE `webportal`.`personalized_links` SET `accessed`=accessed+1 WHERE `per_link_id`>= '1' and link_id=21 and user_id='" + session.getAttribute("user_id").toString()+ "';");
						                		
					                	  }
					                	 
					                	  if(event.toString().contains("Show Reports"))
					                	  {
					                		  ifrmload.setSrc("show_daily_report.zul");
					                		  obj.updatequery("UPDATE `webportal`.`personalized_links` SET `accessed`=accessed+1 WHERE `per_link_id`>= '1' and link_id=22 and user_id='" + session.getAttribute("user_id").toString()+ "';");
						                		
					                	  }
					                  }
					              });
				             }
							
				        }
				        catch(Exception e)
				        {
				      	  
				        }
				        	
						
					}
		
					}
					catch(Exception e)
					{
	
					}
		
		
       // Messagebox.show("Welcome :- " +(String) session.getAttribute("username"));
              
	}

	
	 
	
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
