package homepage;

import org.zkoss.web.servlet.dsp.action.Include;
import org.zkoss.zhtml.Center;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zkex.zul.Fisheye;
import org.zkoss.zul.Borderlayout;
import org.zkoss.zul.Button;
import org.zkoss.zul.Label;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.West;
import org.zkoss.zul.Window;

@SuppressWarnings("rawtypes")
public class homesession extends GenericForwardComposer{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Label lblusername;
	Label lbluser_role;
	Borderlayout b_layout_home;
	West west_links;
	Label lbluser_id;
	Label password;
	Label lblemp_id;
	Button initBtn;
	Window loginWin;
	Fisheye home_fish;
	Fisheye services_fish;
	Fisheye career_fish;
	Fisheye technology_fish;
	Fisheye contact_us_fish;
	Center webpartarea;
	Button btnjobs;
	Button locate_us_fish;
	Button feedback_fish;
	Window main;
	org.zkoss.zul.Include include_center;
	
	public void onCreate$main()
	{
		if(session.getAttribute("username")==null)
		{
			btnjobs.setVisible(false);
			initBtn.setLabel("Login");	
			initBtn.setImage("/images/loginlogout/login.png");
			initBtn.setVisible(true);
		}
		else
		{
			btnjobs.setVisible(true);
			initBtn.setLabel("log out");
			initBtn.setImage("/images/loginlogout/login.png");
			
			lbluser_role.setValue("Role: "+(String)session.getAttribute("user_role"));
			lbluser_id.setValue("User Id: "+(String)session.getAttribute("user_id"));
			final String ss=(String) session.getAttribute("username");
			lblusername.setValue("Username: "+ss);
			//alert((String)session.getAttribute("emp_id"));
			if(session.getAttribute("emp_id")!=null)
			{
				lblemp_id.setValue("Emp Id: "+(String)session.getAttribute("emp_id"));
			}
			
				
		}
	}
	public void onClick$initBtn()
	{
		
		if(initBtn.getLabel()=="Login")
		{
			if (!loginWin.isVisible())
				loginWin.setVisible(true);
			loginWin.doHighlighted();
		}
		else if(initBtn.getLabel()=="log out")
		{
			initBtn.setLabel("Login");	
			initBtn.setImage("/images/loginlogout/login.png");
			btnjobs.setVisible(false);
				session.removeAttribute("username");
				session.removeAttribute("user_id");
				session.removeAttribute("user_name");
				session.removeAttribute("password");
				session.removeAttribute("user_role_id");
				session.removeAttribute("user_role");
				session.removeAttribute("user_role_id");
				session.removeAttribute("emp_id");
				
			lblemp_id.setValue(null);
			lbluser_id.setValue(null);
			lbluser_role.setValue(null);
			lblusername.setValue(null);
			
			
		}
		
	}
	public void onClick$home_fish()
	{
			include_center.setSrc("webparts.zul");
	}
	
	public void onClick$locate_us_fish()
	{
			include_center.setSrc("gmaps.zul");
	}
	public void onClick$feedback_fish()
	{
		Window window = (Window) Executions.createComponents(
				"feedback.zul", null, null);
		window.doHighlighted();	
	
	}
	public void onClick$services_fish()
	{
		
			include_center.setSrc("services.zul");
			
	}
	public void onClick$technology_fish()
	{
		
			include_center.setSrc("technologies.zul");
	}
	public void onClick$career_fish()
	{
		
			include_center.setSrc("recruitment.zul");
	}
	public void onClick$contact_us_fish()
	{
		
			include_center.setSrc("contact_us.zul");
	}
	public void onClick$btnjobs()
	{
			Executions.sendRedirect("Hrpage.zul");
	}
}
