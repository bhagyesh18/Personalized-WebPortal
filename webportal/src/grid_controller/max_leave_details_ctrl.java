package grid_controller;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import connection.*;

import grid_model.employee;
import grid_model.max_leave;

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
import org.zkoss.zul.Textbox;

@SuppressWarnings({ "rawtypes", "serial" })
public class max_leave_details_ctrl extends GenericForwardComposer{
	private List<max_leave> max_leaves = new ArrayList<max_leave>();
	private Listbox listbox_max_leave;
	ResultSet rs;
	Combobox chkempd;
	Combobox chkleavetype;
	Textbox	txtmleave;
Button btnupdate;
Long temp_desi,temp_leave;


	@Override
	public void doAfterCompose(Component comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);
		
		queryclass q1=new queryclass();
		rs=q1.selectquery("select lm.leavetype,m.maxleave,e.emp_designation from max_leave m , employee_designation e ,leave_master lm  where m.emp_designation_id=e.emp_designation_id and m.leavetype_id=lm.leavetype_id;");
		List maxleave=new ArrayList();
		
		while(rs.next())
		{
			max_leave max=new max_leave();
			max.setEmp_designation(rs.getString("emp_designation"));
			max.setLeavetype(rs.getString("leavetype"));
			max.setMaxleave(rs.getString("maxleave"));
			max_leaves.add(max);
		}
		listbox_max_leave.setItemRenderer(new ListitemRenderer() {

			@Override
			public void render(Listitem arg0, Object arg1, int arg2)
					throws Exception {
				// TODO Auto-generated method stub
				
				max_leave value=(max_leave)arg1;
				arg0.appendChild(new Listcell(value.getEmp_designation()));
				arg0.appendChild(new Listcell(value.getLeavetype()));
				arg0.appendChild(new Listcell(value.getMaxleave()));
				arg0.setValue(value);
				arg0.setAttribute("data", arg1);

				ComponentsCtrl.applyForward(arg0,
						"onDoubleClick=onDoubleClicked");
			}
		
		
		});
		
	}
	
	public void onDoubleClicked(Event event) throws Exception {
		// get the selected object
		Listitem item = listbox_max_leave.getSelectedItem();
		max_leave max = (max_leave) item.getAttribute("data");
		// temp_emp_id=emp1.getEmp_id();
		//alert(max.getEmp_designation());
		chkempd.setValue(max.getEmp_designation());
		chkleavetype.setValue(max.getLeavetype());
		txtmleave.setValue(max.getMaxleave());
		
		
		
	
		
	}
	public List<max_leave> getMax_leaves1() {
		return max_leaves;
	}
	
	
	public void onClick$btnupdate()
	{
		
		try{
			queryclass obj2=new queryclass();
			ResultSet rs2=obj2.selectquery("SELECT ed.emp_designation_id,lm.leavetype_id FROM webportal.employee_designation ed,webportal.leave_master lm  where lm.leavetype= '"+ chkleavetype.getValue().toString() +"' and ed.emp_designation='"+ chkempd.getValue().toString() +"';");
			if(rs2.next())
			{
				temp_desi=Long.parseLong(   rs2.getString("emp_designation_id").toString());
				temp_leave=Long.parseLong(rs2.getString("leavetype_id").toString());
				
			}
			
			
			queryclass obj1=new queryclass();
			
			obj1.updatequery("UPDATE `webportal`.`max_leave` SET `maxleave`=" + txtmleave.getValue().toString() + " WHERE emp_designation_id="+ temp_desi + " and leavetype_id= " + temp_leave + " ;");
			alert("Record updated succesffully ");
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
}
