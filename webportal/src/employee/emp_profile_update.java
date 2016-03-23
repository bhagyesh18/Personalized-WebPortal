package employee;

import java.sql.ResultSet;

import org.zkoss.util.media.Media;
import org.zkoss.zhtml.Caption;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Image;
import org.zkoss.zul.Radiogroup;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;
import connection.*;

@SuppressWarnings({ "serial", "rawtypes" })
public class emp_profile_update extends GenericForwardComposer {

Button btnupdate;
Window winemp_profile;
Textbox txtfname;
Textbox txtlname;
Textbox txtadd;
Combobox chkcountry;
Combobox chkstate;
Combobox chkcity;
Textbox txtemail;
Textbox txtmbn;
Datebox birthbox;
Radiogroup rggender;
 Radiogroup rgms;
Textbox txtsecurityque;
Textbox txtsqcurityans;
ResultSet rs;
ResultSet rs1;
ResultSet rs2;
String cityid;
String str;
Caption cpt;
Image img;
Media media;



public void onCreate$winemp_profile()
{
	
	try
	{
	queryclass obj=new queryclass();
	
		rs=obj.selectquery("select * from employee where emp_id='" + (String)session.getAttribute("emp_id") + "' ; ");
	//rs=obj.selectquery("select * from employee where emp_id='20121101181541' ; ");
	
	if(rs.next())
	{
			txtfname.setValue(rs.getString("first_name"));
			txtlname.setValue(rs.getString("last_name"));
			txtadd.setValue(rs.getString("address"));
			txtemail.setValue(rs.getString("email_id"));
			txtmbn.setValue(rs.getString("mobile_no"));
			
				if(rs.getString("gender").equals("1"))
				{
					rggender.setSelectedIndex(0);
				}
				else
				{
					rggender.setSelectedIndex(1);
				}
				
				if(rs.getString("maritual_status").equals("Unmarried"))
				{
					rgms.setSelectedIndex(0);
				}
				else
				{
					rgms.setSelectedIndex(1);
				}
				
				cityid=rs.getString("city_id");
				
				img.setSrc("/emp_images/" + rs.getString("photo").toString());
	}
	}
	catch(Exception e)
	{
	}
	
	try
	{
		queryclass obj2=new queryclass();
		str="SELECT c.city_name,s.state_name,co.country_name FROM webportal.city c,webportal.state s,webportal.country co where c.city_id='" + cityid + "' and c.state_id = s.state_id and s.country_id= co.country_id;";
		rs2=obj2.selectquery(str);
		if(rs2.next())
		{
			chkcountry.setValue(rs2.getString("co.country_name"));
			chkcity.setValue(rs2.getString("c.city_name"));
			chkstate.setValue(rs2.getString("s.state_name"));
		}
	}
	catch(Exception e)
	{
		
	}
	
	try
	{
		queryclass obj1=new queryclass();
		rs1=obj1.selectquery("select * from user_master where user_id='" + session.getAttribute("user_id") + "';");
	//rs1=obj1.selectquery("select * from user_master where user_id='104';");
	
	if(rs1.next())
	{
		txtsecurityque.setValue(rs1.getString("security_question"));
		txtsqcurityans.setValue(rs1.getString("security_answer"));
	}
	}
	catch(Exception e)
	{
	
	}
	
}
	
	public void onClick$btnupdate()
	{
		try
		{
				
			queryclass obj=new queryclass();
			String cityId=null;
			String cityname=chkcity.getValue().toString();
			ResultSet rs=null;
			rs=obj.selectquery("select city_id from city where city_name='"+cityname+"'");
			if(rs.next())
			{
				cityId=rs.getString("city_id").toString();
			}
		//	String photo_path=(String)session.getAttribute("emp_id") + ".jpg";
			obj.updatequery("UPDATE `webportal`.`employee` SET `first_name`='"+txtfname.getValue().toString()+"', `last_name`='"+txtlname.getValue().toString()+"', `address`='"+txtadd.getValue().toString()+"', `city_id`='"+cityId+"', `email_id`='"+txtemail.getValue().toString()+"', `mobile_no`='"+txtmbn.getValue().toString()+"', `maritual_status`='"+rgms.getSelectedIndex()+"' WHERE `emp_id`='" + (String)session.getAttribute("emp_id") + "'");
			
			queryclass obj1=new queryclass();
			rs=null;
			String userId=null;
			rs=obj1.selectquery("select user_id from employee where emp_id='" + (String)session.getAttribute("emp_id") + "'");
			if(rs.next())
			{
				userId=rs.getString("user_id").toString();
			}
			obj1.updatequery("UPDATE `webportal`.`user_master` SET `security_question`='"+txtsecurityque.getValue().toString()+"', `security_answer`='"+txtsqcurityans.getValue().toString()+"' WHERE `user_id`='"+userId+"'");
			alert("Record updated succesffully ");
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
}
