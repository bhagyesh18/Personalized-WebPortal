package emp_profile_changeHR_Controller;

import grid_controller.employee_details_ctrl;
import grid_model.employee;

import java.awt.Checkbox;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.zkoss.zhtml.Caption;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Image;
import org.zkoss.zul.Radiogroup;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import connection.queryclass;

@SuppressWarnings({ "serial", "rawtypes" })
public class Emp_profile_changeHR_CTRL extends GenericForwardComposer {

	ResultSet rs;

	Textbox txtemp_id;
	Textbox txtfname;
	Button btnupdate;

	Window win_employee;
	Textbox txtbasic;
	Combobox chkempd;
	Checkbox chkstatus1;
	Checkbox chkstatus;

	Textbox txtlname;
	Textbox txtadd;
	Combobox chkcountry;
	Combobox chkstate;
	Combobox chkcity;
	Textbox txtemail;
	Textbox txtmbn;
	Datebox birthbox;
	Datebox dateofjoin;

	Radiogroup rggender;
	Radiogroup rgms;
	Textbox txtsecurityque;
	Textbox txtsqcurityans;
	ResultSet rs11;
	ResultSet rs1;
	ResultSet rs2;
	String cityid;
	String str;
	Caption cpt;
	int choice;
	ResultSet rs3;
	Radiogroup rgstatus;
	Image img;
	Textbox txtuser_id;

	Window winemp_profile;

	public void onCreate$winemp_profile() {

		int choice = 0;
		try {

			queryclass obj = new queryclass();

			//alert(requestScope.get("eid").toString());
			rs = obj.selectquery("select * from employee where emp_id='"+requestScope.get("eid").toString()+"';");
			
			if (rs.next()) {
			//	alert(rs.getString("emp_id"));
			//	alert(rs.getString("first_name"));
				txtemp_id.setValue(rs.getString("emp_id"));
				txtuser_id.setValue(rs.getString("user_id"));
				txtfname.setValue(rs.getString("first_name"));
				txtlname.setValue(rs.getString("last_name"));
				txtadd.setValue(rs.getString("address"));
				txtemail.setValue(rs.getString("email_id"));
				txtmbn.setValue(rs.getString("mobile_no"));
				img.setSrc("/emp_images/" + rs.getString("photo").toString());
				String doj = rs.getString("dateOfjoin");
				txtbasic.setValue(rs.getString("basic_salary"));

				choice = Integer.parseInt(rs.getString("emp_designation_id")
						.toString());

				dateofjoin.setText(doj.replaceAll("-", "/"));

				if (rs.getString("gender").equals("1")) {
					rggender.setSelectedIndex(0);
				} else {
					rggender.setSelectedIndex(1);
				}

				if (rs.getString("maritual_status").equals("Unmarried")) {
					rgms.setSelectedIndex(0);
				} else {
					rgms.setSelectedIndex(1);
				}

				cityid = rs.getString("city_id");
				
				if (rs.getString("status").toString().equals("0")) {
					rgstatus.setSelectedIndex(0);

				} else if (rs.getString("status").toString().toString()
						.equals("1")) {
					rgstatus.setSelectedIndex(1);
				}
			}

		} catch (Exception e) {
		}

		try {
			queryclass obj2 = new queryclass();
			str = "SELECT * FROM webportal.employee_designation where emp_designation_id='"
					+ choice + "' ";
			ResultSet rs3 = obj2.selectquery(str);
			if (rs3.next()) {

				chkempd.setValue(rs3.getString("emp_designation"));

			}

		} catch (Exception e) {

		}

		try
		{
			queryclass obj2=new queryclass();
			str="SELECT c.city_name,s.state_name,co.country_name FROM webportal.city c,webportal.state s,webportal.country co where c.city_id='" + cityid + "' and c.state_id = s.state_id and s.country_id= co.country_id";
			rs2=obj2.selectquery(str);
			alert("Hiiii");
			if(rs2.next())
			{
				//alert(rs2.getString("c.city_name"));
				chkcountry.setValue(rs2.getString("co.country_name"));
				chkcity.setValue(rs2.getString("c.city_name"));
				chkstate.setValue(rs2.getString("s.state_name"));
			}
		}
		catch(Exception e)
		{
			
		}
		
		try {
			queryclass obj1 = new queryclass();
			rs1 = obj1.selectquery("select * from user_master where user_id='"
					+ txtuser_id.getValue() + "';");
			// rs1=obj1.selectquery("select * from user_master where user_id='104';");

			if (rs1.next()) {
				txtsecurityque.setValue(rs1.getString("security_question"));
				txtsqcurityans.setValue(rs1.getString("security_answer"));
			}
		} catch (Exception e) {

		}
	}
public void onClick$btnupdate() {
	
		
		String status;
		int flag=0,flag1=0,flag3=0,flag4=0;
		if(rgstatus.getSelectedIndex()==0)
		{
			flag=1;
		}
		else
		{
			flag=0;
		}
		if(rgstatus.getSelectedIndex()==1)
		{
			flag1=1;
		}
		else
		{
			flag1=0;
		}
		
		if(rggender.getSelectedIndex()==0)
		{
			flag3=1;
		}
		else
		{
			flag3=0;
		}
	
		
		String fname = txtfname.getValue();
		String lname=txtlname.getValue();
		String add=txtadd.getValue();
		String country=chkcountry.getValue();
		String state=chkstate.getValue();
		String city=chkcity.getValue();
		String basic_salary=txtbasic.getValue();
		
		String email = txtemail.getValue();

		String mno=txtmbn.getValue();
		String empdesig=chkempd.getValue(); 
		String birthdate=birthbox.getText();
		String joiningdate=dateofjoin.getText();
		alert(birthdate);
		alert(joiningdate);
		String gender=rggender.getSelectedItem().toString();
		int mstatus=rgms.getSelectedIndex();
		String securityque=txtsecurityque.getValue();
		String securityans=txtsqcurityans.getValue();
	
		String getUserRoleId;
		String getCountryId;
		String getStateId;
		String getCityId;
		String getEmpDesigId; 
		if(mstatus==0)
		{
			status="Unmarried";
		}
		else
		{
			status="Married";
		}
	
		try
		{

			queryclass cn=new queryclass();
			queryclass cn1=new queryclass();
			ResultSet rs=null;
			
			
			
			String strCountry="select country_id from country where country_name='"+country+"'";
			rs=cn.selectquery(strCountry);
			rs.next();
			getCountryId=rs.getString("country_id").toString();
			
			String strState="select state_id from state where state_name='"+state+"'";
			rs=cn.selectquery(strState);
			rs.next();
			getStateId=rs.getString("state_id").toString();
			
			String strCity="select city_id from city where city_name='"+city+"'";
			rs=cn.selectquery(strCity);
			rs.next();
			getCityId=rs.getString("city_id").toString();
			
			String strEmpDesig="select emp_designation_id from employee_designation where emp_designation='"+empdesig+"'";
			rs=cn.selectquery(strEmpDesig);
			rs.next();
			getEmpDesigId=rs.getString("emp_designation_id").toString();
		
			String strLastUser="select user_id from user_master";
			rs=cn.selectquery(strLastUser);
			String lastValueUser = null;
			while(rs.next())
			{
				lastValueUser=rs.getString("user_id");
			}
			int temp1=Integer.parseInt(lastValueUser);
			temp1++;
						
			/*
			
			last record of emp_id but changed to varchar and dateformat id
			String strLast="select emp_id from employee";
			rs=cn.selectquery(strLast);
			String lastValue;
			while(rs.next())
			{
				lastValue=rs.getString("emp_id");
			}
			int temp=Integer.parseInt(lastValue);
			temp++;
			alert(temp);
			*/
			DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
			Date date = new Date();				
			String emp_id=dateFormat.format(date);
		
			String strUserInsert="UPDATE `webportal`.`user_master` SET `security_question`='" + securityque + "', `security_answer`= '" + securityans + "' WHERE `user_id`='"+txtuser_id.getValue().toString()+"';";
			String strEmployeeInsert="UPDATE `webportal`.`employee` SET `emp_id`='" + txtemp_id.getValue().toString() + "', `user_id`='"+ txtuser_id.getValue().toString() + "', `first_name`='" + fname + "', `last_name`='" + lname + "', `address`='" + add + "', `city_id`='" + getCityId + "', `email_id`='"+ email +"', `mobile_no`='" + mno + "', `emp_designation_id`='" + getEmpDesigId + "', `basic_salary`='"+ basic_salary +"', `dateOfjoin`='" + joiningdate + "', `dateOfbirth`=' " + birthdate + "', `gender`=" + flag3 + ", `maritual_status`='" + status + "', `status`=" + flag1 + " WHERE `emp_id`='" + txtemp_id.getValue().toString() +"';";
		
			
			cn.insertquery(strUserInsert);
			cn1.insertquery(strEmployeeInsert);
		}
		catch(Exception e)
		{
			
		}
		
		alert("Successfully updated !");
		
	}

}
