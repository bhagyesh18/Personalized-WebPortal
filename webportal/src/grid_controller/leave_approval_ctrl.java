package grid_controller;

import grid_model.leave_request_details;


import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import connection.*;


import org.zkoss.web.servlet.dsp.action.Page;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.sys.ComponentsCtrl;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;
import org.joda.time.*;
@SuppressWarnings({ "serial", "rawtypes" })
public class leave_approval_ctrl extends GenericForwardComposer {
	private List<leave_request_details> Leave_details = new ArrayList<leave_request_details>();
	private Listbox list_leave_approval;
	ResultSet rs;
	Button btn_approve;
	Button btn_not_approve;
	Button btn_available_leave;
	
	String str11;
	
	@SuppressWarnings("unchecked")
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		
		super.doAfterCompose(comp);
		
		queryclass q1=new queryclass();
		
		String str="select l.leavedetail_id,l.leave_reason,l.leave_permission,l.leave_start_date,l.leave_end_date,l.total_leave_days, e.emp_id,e.first_name,lt.leavetype from leave_detail l, employee e, leave_master lt where l.emp_id=e.emp_id and l.leavetype_id=lt.leavetype_id and l.leave_permission='0'";
		rs=q1.selectquery(str);
		while(rs.next())
		{
			 str11=rs.getString("leave_permission");
			int p=Integer.parseInt(str11);
			if(p==1)
			{
				str11="Approve";
			}
			if(p==0)
			{
				str11="Not Approve";
			}
			leave_request_details ld=new leave_request_details();
			ld.setLeavedetail_id(rs.getString("leavedetail_id"));
			ld.setEmp_id(rs.getString("emp_id"));
			ld.setFirstname(rs.getString("first_name"));
			ld.setLeavetype(rs.getString("leavetype"));
			ld.setLeave_reason(rs.getString("leave_reason"));
			ld.setLeave_permission(str11);
			ld.setLeave_start(rs.getString("leave_start_date"));
			ld.setLeave_end(rs.getString("leave_end_date"));
			ld.setTotal_Leaves_days(rs.getString("total_leave_days"));
			
			Leave_details.add(ld);
		}
	
		
		
		list_leave_approval.setItemRenderer(new ListitemRenderer() {

			@Override
			public void render(Listitem item, Object arg1, int arg2)
					throws Exception {
				
				leave_request_details value = (leave_request_details) arg1;
				item.appendChild(new Listcell(value.getLeavedetail_id()));
				item.appendChild(new Listcell(value.getEmp_id()));
				item.appendChild(new Listcell(value.getFirstname()));
				item.appendChild(new Listcell(value.getLeavetype()));
				item.appendChild(new Listcell(value.getLeave_reason()));
				item.appendChild(new Listcell(value.getLeave_permission()));
				item.appendChild(new Listcell(value.getLeave_start()));
				item.appendChild(new Listcell(value.getLeave_end()));
				item.appendChild(new Listcell(value.getTotal_Leaves_days()));
				
				item.setValue(value);

				item.setAttribute("data", arg1);

				ComponentsCtrl.applyForward(item,
						"onDoubleClick=onDoubleClicked");
			}
			
		});
		
		
	}
	
	public void onClick$btn_approve()
	{
		Listitem item = list_leave_approval.getSelectedItem();
		leave_request_details p1= (leave_request_details) item.getAttribute("data");
		final String temp_emp_id;
		final String temp_leavetype_id;
		try
		{
		ResultSet rs2;
		String leave_id = null;
		queryclass obj1=new queryclass();
		rs2=obj1.selectquery("SELECT * FROM webportal.leave_master where leavetype='" + p1.getLeavetype().toString() + "';");
		if(rs2.next())
		{
			leave_id=rs2.getString("leavetype_id");
		}
		
		//alert(leave_id);
		DateTime d=new DateTime(System.currentTimeMillis());
		int year;
		year=d.getYear();
		String temp_year=String.valueOf(year);
		
		queryclass obj_approve=new queryclass();
		obj_approve.updatequery("UPDATE `webportal`.`leave_balance` SET `leave_taken`=leave_taken+"+ p1.getTotal_Leaves_days().toString() +",leave_pending=leave_pending-"+p1.getTotal_Leaves_days().toString()+"   WHERE `leavebalance_id`>0 and leavetype_id='"+ leave_id +"' and emp_id='"+ p1.getEmp_id().toString() +"' and year='" + temp_year + "';");
		
		queryclass query_leave_permision=new queryclass();
		query_leave_permision.updatequery("UPDATE `webportal`.`leave_detail` SET `leave_permission`=1 WHERE `leavedetail_id`='" +p1.getLeavedetail_id().toString()+ "';");
		alert("approve");
		}
		catch (Exception e) {
			// TODO: handle exception
			
			alert(e.getMessage());
			
		}
		
	}

	public void onClick$btn_not_approve()
	{
		Listitem item = list_leave_approval.getSelectedItem();
		leave_request_details p1= (leave_request_details) item.getAttribute("data");
		Messagebox.show("Not Approve");
		
		
		
		
		
	}
	public void onClick$btn_available_leave()
	{
		Listitem item = list_leave_approval.getSelectedItem();
		leave_request_details p1= (leave_request_details) item.getAttribute("data");
		
		requestScope.put("req_emp_id", p1.getEmp_id().toString());
		requestScope.put("req_emp_name", p1.getFirstname().toString());
		
		Window window = (Window) Executions.createComponents(
				"show_req_ava_leave.zul", null, null);
		window.doHighlighted();
		
		
	}
	public void onDoubleClicked(Event event) throws Exception {
	
	alert("ssss");
	}
	
	public List<leave_request_details> getLeave_request_details1() {
		return Leave_details;
	}
	
}
