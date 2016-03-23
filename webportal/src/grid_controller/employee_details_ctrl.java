package grid_controller;

import emp_profile_changeHR_Controller.Emp_profile_changeHR_CTRL;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.awt.Checkbox;
import java.sql.*;

import connection.*;

import org.zkoss.zhtml.Caption;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.ext.Includer;
import org.zkoss.zk.ui.sys.ComponentsCtrl;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Image;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Radiogroup;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;
import connection.queryclass;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.sun.corba.se.impl.io.OptionalDataException;
import com.sun.java.swing.plaf.windows.resources.windows;

import emp_profile_changeHR_Controller.Emp_profile_changeHR_CTRL;

import grid_model.employee;

;

@SuppressWarnings({ "unused", "rawtypes" })
public class employee_details_ctrl extends GenericForwardComposer {
	private static final long serialVersionUID = 1L;
	private List<employee> employees = new ArrayList<employee>();
	private Listbox listemp;
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

	@SuppressWarnings("unchecked")
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);

		queryclass q1 = new queryclass();

		String str = "select e.emp_id,e.user_id,e.basic_salary, e.mobile_no,e.first_name,e.last_name,e.address,e.email_id,ed.emp_designation,e.emp_designation_id,e.gender,e.status from employee_designation ed, employee e where e.emp_designation_id=ed.emp_designation_id";
		rs11 = q1.selectquery(str);
		List employee = new ArrayList();
		String disgender=null;
		String disstatus=null;
		
		while (rs11.next()) {
			String stgender= rs11.getString("gender").toString();
			int gender=Integer.parseInt(stgender);
			
			String ststatus=rs11.getString("status").toString();
			int status=Integer.parseInt(ststatus);
			
			if(status==1)
			{
				disstatus="Active";
			}
			else {
				disstatus="Not Active";
			}
			if(gender==1)
			{
				disgender="Male";
			}
			else {
				disgender="Female";
			}
			employee em = new employee();
			em.setEmp_id(rs11.getString("emp_id"));
			em.setUser_id(rs11.getString("user_id"));
			em.setFirst_name(rs11.getString("first_name"));
			em.setLast_name(rs11.getString("last_name"));
			em.setAddress(rs11.getString("address"));
			em.setMobile_no(rs11.getString("mobile_no"));
			em.setEmp_designation_id(rs11.getString("emp_designation"));
			em.setBasic_salary(rs11.getString("basic_salary"));
			em.setGender(disgender);
			em.setStatus(disstatus);
			
			employees.add(em);

		}
		listemp.setItemRenderer(new ListitemRenderer() {
			@Override
			public void render(Listitem item, Object arg1, int arg2)
					throws Exception {
				employee value = (employee) arg1;
				item.appendChild(new Listcell(value.getEmp_id()));
				item.appendChild(new Listcell(value.getFirst_name()));
				item.appendChild(new Listcell(value.getLast_name()));
				item.appendChild(new Listcell(value.getUser_id()));
				item.appendChild(new Listcell(value.getAddress()));
				item.appendChild(new Listcell(value.getMobile_no()));
				item.appendChild(new Listcell(value.getEmp_designation_id()));
				item.appendChild(new Listcell(value.getBasic_salary()));
				item.appendChild(new Listcell(value.getGender()));
				item.appendChild(new Listcell(value.getStatus()));
				item.setValue(value);

				item.setAttribute("data", arg1);

				ComponentsCtrl.applyForward(item,
						"onDoubleClick=onDoubleClicked");
			}
		});

	}
	
	public void onSelect(Event event) throws Exception
	{
		Messagebox.show("Select clicked..");
	}
	@SuppressWarnings("unchecked")
	public void onDoubleClicked(Event event) throws Exception {
		// get the selected object
		Listitem item = listemp.getSelectedItem();
		employee emp1 = (employee) item.getAttribute("data");
		// temp_emp_id=emp1.getEmp_id();
		requestScope.put("eid", emp1.getEmp_id().toString());
		
		  Window window = (Window)Executions.createComponents(
               "emp_profile_changeHR.zul", null, null);
       window.doHighlighted();

	}
	
	

	public List<employee> getEmployees1() {
		return employees;
	}
	
	public void onClick$btndelete()
	{
		Listitem item=listemp.getSelectedItem();
		employee emp=(employee)item.getAttribute("data");
		queryclass obj=new queryclass();
		obj.deletequery("DELETE FROM `webportal`.`employee` WHERE `emp_id`='"+emp.getEmp_id().toString()+"'");
		obj.deletequery("DELETE FROM `webportal`.`user_master` WHERE `user_id`='"+emp.getUser_id().toString()+"'");
		obj.deletequery("DELETE FROM `webportal`.`personalized_links` WHERE `user_id`='"+emp.getUser_id().toString()+"'");
		obj.deletequery("DELETE FROM `webportal`.`leave_balance` WHERE `emp_id`='"+emp.getEmp_id().toString()+"'");
		obj.deletequery("DELETE FROM `webportal`.`leave_detail` WHERE `emp_id`='"+emp.getEmp_id().toString()+"'");
		alert("Delete Successful..");
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
			alert("Successfully updated !");
		}
		catch(Exception e)
		{
			
		}
		
		
		
	}
}
