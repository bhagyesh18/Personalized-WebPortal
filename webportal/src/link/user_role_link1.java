package link;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import jxl.write.DateTime;

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
public class user_role_link1 extends GenericForwardComposer implements ActionListener{
Vlayout menu;
public String btnarray[];
	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;

	String str1;	
	
	Popup popup;
static int cnt=3;
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public void onCreate$menu()
	{

		//DateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		Messagebox.show(dateFormat.format(date));
	  
		
      	
     //Messagebox.show(""+ ddd.getDate());		
		
		
		 queryclass obj=new queryclass();
	   
		try
        {
    	   
			
      	  //	String str="SELECT link_name FROM link_details LEFT JOIN link_master ON link_details.link_id=link_master.link_id where link_details.user_role_id=2 ";
    	    String str="SELECT link_name FROM webportal.personalized_links LEFT JOIN webportal.link_master ON webportal.personalized_links.link_id = webportal.link_master.link_id where webportal.personalized_links.user_id= 2 order by accessed desc;";
    	    		ResultSet rs=  obj.selectquery(str);
		    
		Button btn;
		while(rs.next())
             {
			
				btn=new Button();
				btn.setId(rs.getString("link_name"));
				btn.setLabel(rs.getString("link_name"));
				
				menu.appendChild(btn);
				
	              btn.addEventListener(Events.ON_CLICK, new EventListener() {
	                  public void onEvent(Event event) throws Exception {
	                	 
	                	  if(event.toString().contains("Registration"))
	                	  {
	                		 
	                		Messagebox.show("registred clicked");
	                		
	                	  }
	                	  if(event.toString().contains("Email"))
	                	  {
	                		 
	                		  Messagebox.show("Clicked reg");
	                  	
	                	  }
	                	  if(event.toString().contains("Manage Salary"))
	                	  {
	                		  
	                  		
	                		Messagebox.show("clciked manage slary");
	                	  }
	                	  
	                	  if(event.toString().contains("Manage Reports"))
	                	  {
	                		
	                		
	                		Messagebox.show("clciked manage reporst");
	                	  }
	                	  
	                  }
	              });
             }
			
        }
        catch(Exception e)
        {
      	  
        }
        
        Messagebox.show("Welcome :- " +(String) session.getAttribute("username"));
              
	}

	
	 
	
	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
