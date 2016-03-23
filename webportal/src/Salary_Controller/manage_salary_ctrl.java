package Salary_Controller;

import java.sql.ResultSet;

import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Window;

import connection.queryclass;
import org.joda.time.*;


@SuppressWarnings({ "serial", "rawtypes" })
public class manage_salary_ctrl extends GenericForwardComposer{

	Window win_salary;
	Combobox comboMonth;
	Combobox chkyear;
	Combobox chkdesig;
	ResultSet rsallamp; 
	ResultSet rsallamp1; 
	ResultSet rs_leave;
	Button btnpay;
	Combobox chkemp_id;
	Combobox chkemp_name;
	
	public void onClick$btnpay()
	{
		String month_data = null;			
		String month=comboMonth.getValue().toString();
		if(month.equals("January"))
		{
			month_data="1";
		}
		else  if(month.equals("February"))
		{
			month_data="2";
		}
		else  if(month.equals("March"))
		{
			month_data="3";
		}
		else  if(month.equals("April"))
		{
			month_data="4";
		}
		else  if(month.equals("May"))
		{
			month_data="5";
		}
		else  if(month.equals("June"))
		{
			month_data="6";
		}
		else  if(month.equals("July"))
		{
			month_data="7";
		}
		else  if(month.equals("August"))
		{
			month_data="8";
		}
		else  if(month.equals("September"))
		{
			month_data="9";
		}
		else  if(month.equals("October"))
		{
			month_data="10";
		}
		else  if(month.equals("November"))
		{
			month_data="11";
		}
		else  if(month.equals("December"))
		{
			month_data="12";
		}
		
		
		
		
		if(chkdesig.isDisabled()==false)
		{
			alert("desi");
		}
		else if(chkemp_id.isDisabled()==false)
		{
			alert("emp");
		}
		else if(chkemp_name.isDisabled()==false)
		{
			alert("name");
		}
		else
		{
			
			if(comboMonth.getValue().toString().equals("December"))
			{
				
				// FOR DECEMEBR
				try
				{
					
				ResultSet rsyear;	
				queryclass check_year=new queryclass();
				rsyear=check_year.selectquery("select * from leave_balance where year='"+ Integer.parseInt( chkyear.getValue().toString())+ "'");
				if(rsyear.next())
				{
				
					
				Double basic1,da1,hra1,pf1,gross1,deduction1,net1;
				queryclass allemp_query1=new queryclass();
				rsallamp1=allemp_query1.selectquery("select * from employee");
				
						while(rsallamp1.next())
						{
								
							basic1=Double.parseDouble(rsallamp1.getString("basic_salary"));
							da1=(basic1*0.22);
							hra1=basic1*0.15;
							pf1=(basic1+da1)*0.12;
							gross1=da1+basic1;
							net1=(gross1-pf1)-300;
							deduction1=(double) 0;
							
							int cl_taken=0;
							int sl_taken=0;
							int el_taken=0;
							int cl_pen=0;
							int sl_pen=0;
							int el_pen=0;
							Double cl_ded=0.0;
							Double sl_ded=0.0;
							Double el_ded=0.0;
							
							DateTime d=new DateTime(System.currentTimeMillis());
							int year;
							year=d.getYear();
							String temp_year=String.valueOf(year);
							
							
							queryclass ded_query=new queryclass();
							rs_leave=ded_query.selectquery("SELECT * FROM webportal.leave_balance where emp_id="+ rsallamp1.getString("emp_id") +" and year='"+ Integer.parseInt( chkyear.getValue().toString()) +"';");
							
														
							while(rs_leave.next())
							{
									if(rs_leave.getString("leavetype_id").toString().equals("1"))
									{
											cl_taken=Integer.parseInt(rs_leave.getString("leave_taken"));
											cl_pen=Integer.parseInt(rs_leave.getString("leave_pending"));
											if(cl_pen<0)
											{
												Double one_day;
												one_day=Double.parseDouble(rsallamp1.getString("basic_salary"))/31;
												cl_pen=Math.abs(cl_pen);
												cl_ded=cl_pen*one_day;
												deduction1=deduction1+cl_ded;
												
											}
																						
									}
									if(rs_leave.getString("leavetype_id").toString().equals("2"))
									{
										sl_taken=Integer.parseInt(rs_leave.getString("leave_taken"));
										sl_pen=Integer.parseInt(rs_leave.getString("leave_pending"));
										if(sl_pen<0)
										{
											Double one_day;
											one_day=Double.parseDouble(rsallamp1.getString("basic_salary"))/31;
											sl_pen=Math.abs(sl_pen);
											sl_ded=sl_pen*one_day;
											deduction1=deduction1+sl_ded;
											
										}
																						
									}
									
									if(rs_leave.getString("leavetype_id").toString().equals("3"))
									{
										el_taken=Integer.parseInt(rs_leave.getString("leave_taken"));
										el_pen=Integer.parseInt(rs_leave.getString("leave_pending"));
										if(el_taken>0)
										{
											Double one_day;
											one_day=Double.parseDouble(rsallamp1.getString("basic_salary"))/31;
											el_taken=Math.abs(el_taken);
											el_ded=el_taken*one_day;
											deduction1=deduction1+el_ded;
											
										}
																						
									}
									
							}
							
							queryclass pay_query1=new queryclass();
							pay_query1.insertquery("INSERT INTO `webportal`.`salary` (`emp_id`, `month`, `year`, `basic_salary`, `Da`, `HRA`, `PF`, `deduction`, `Gross_salary`, `net_salary`) VALUES ('"+ rsallamp1.getString("emp_id") + "', '" + month_data + "', "+ Integer.parseInt( chkyear.getValue().toString()) +", " + basic1+ ", "+da1+", "+hra1+", "+ pf1+", " + deduction1 + ", "+ gross1 +", "+ net1+ ");");
						
							
							
						}
						
				}
						
				
				alert("Done : Paid Salary");
						
				}
				catch (Exception e) {
					// TODO: handle exception
					alert(e.getMessage());
					
				}
				
				
				
				
			}
			else
			{
				/*
				 		For NON DECEMBER MONTH
				 
												basic salary --> input from user
												da = 22% of basic salary 
												hra = 15% of basic salary
												pf = 12% of (basic salary + da)
												medical = Rs.300
												gross salary = da+hra+hra+medical
												net salary = gross salary - pf

				 */
				try
				{
					
					
					ResultSet rsyear1;	
					queryclass check_year1=new queryclass();
					rsyear1=check_year1.selectquery("select * from leave_balance where year='"+ Integer.parseInt( chkyear.getValue().toString())+ "'");
					if(rsyear1.next())
					{
						
						
					
				Double basic,da,hra,pf,gross,deduction,net;
				queryclass allemp_query=new queryclass();
				rsallamp=allemp_query.selectquery("select * from employee");
				
						while(rsallamp.next())
						{
								
							basic=Double.parseDouble(rsallamp.getString("basic_salary"));
							da=(basic*0.22);
							hra=basic*0.15;
							pf=(basic+da)*0.12;
							gross=basic+hra;
							net=(gross-pf)-300;
							
							deduction=(double)0;
							
							
							
							queryclass pay_query=new queryclass();
							pay_query.insertquery("INSERT INTO `webportal`.`salary` (`emp_id`, `month`, `year`, `basic_salary`, `Da`, `HRA`, `PF`, `deduction`, `Gross_salary`, `net_salary`) VALUES ('"+ rsallamp.getString("emp_id") + "', '" + month_data + "', "+ Integer.parseInt( chkyear.getValue().toString()) +", " + basic+ ", "+da+", "+hra+", "+ pf+", " + deduction + ", "+ gross +", "+ net+ ");");
							
							
							
							
						}
						
					}
						
						
					alert("Done : Paid Salary");	
				}
				catch (Exception e) {
					// TODO: handle exception
					alert(e.getMessage());
					
				}
			}
		}
	}
	
}
