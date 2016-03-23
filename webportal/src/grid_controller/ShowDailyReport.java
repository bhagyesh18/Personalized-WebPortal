package grid_controller;
import grid.*;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.sys.ComponentsCtrl;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Radio;
import org.zkoss.zul.Textbox;

import connection.queryclass;

@SuppressWarnings({ "serial", "rawtypes" })
public class ShowDailyReport extends GenericForwardComposer {
	
	private List<showReport> showReports=new ArrayList<showReport>();
	private Listbox listshowReport;
	
	@SuppressWarnings("unchecked")
	public void doAfterCompose(Component comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);
		
		ResultSet rs;
		queryclass q1=new queryclass();
		rs=q1.selectquery("select * from work_report");
		
		
		while(rs.next())
		{
			showReport sr=new showReport();
			ResultSet rs1;
			String stremp=rs.getString("emp_id").toString();
			String strquery="select first_name from employee where emp_id='"+stremp+"'";
			rs1=q1.selectquery(strquery);
			String empname = null;
			while (rs1.next()) {
				empname=rs1.getString("first_name").toString();
			}
				
			sr.setEmp(empname);
			sr.setReportDate(rs.getString("report_date"));
			sr.setWorkDescription(rs.getString("work_description"));
			String str1=null;
			String str=rs.getString("status");
			int p=Integer.parseInt(str);
			if(p==1)
			{
				str1="Submit";
			}
			else {
				str1="Not Submit";
			}
			sr.setStatus(str1);
			showReports.add(sr);
		}
		
		listshowReport.setItemRenderer(new ListitemRenderer() {

			@Override
			public void render(Listitem item, Object arg1, int arg2)
					throws Exception {
				// TODO Auto-generated method stub
				showReport value=(showReport) arg1;
				item.appendChild(new Listcell(value.getEmp()));
				item.appendChild(new Listcell(value.getReportDate()));
				item.appendChild(new Listcell(value.getWorkDescription()));
				item.appendChild(new Listcell(value.getStatus()));
				
				item.setValue(value);
				
				item.setAttribute("data", arg1);
				ComponentsCtrl.applyForward(item, "onDoubleClick=onDoubleClicked");
			}
			
		});
	}
	
	    public void onDoubleClicked(Event event) throws Exception {
	        // get the selected object
	    	
	    	Listitem item = listshowReport.getSelectedItem();
	        showReport sr= (showReport) item.getAttribute("data");
	        Messagebox.show(sr.getEmp());
	        }
	    
	    public List<showReport> getShowReports1() {
	        return showReports;
	    }
	}
