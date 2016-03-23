package grid_controller;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.sys.ComponentsCtrl;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import org.zkoss.zul.Messagebox;
import grid.empDesignation;
import java.sql.*;
import connection.*;

@SuppressWarnings({ "serial", "rawtypes" })
public class EmpDesignationDoubleClickEventCtrl extends GenericForwardComposer {

	private List<empDesignation> empDesignations=new ArrayList<empDesignation>();
	private Listbox listempDesig;
	
	@SuppressWarnings("unchecked")
	public void doAfterCompose(Component comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);
		
		ResultSet rs;
		queryclass q1=new queryclass();
		rs=q1.selectquery("select * from employee_designation");
		while(rs.next())
		{
			empDesignation ed=new empDesignation();
			ed.setEmpDesignation(rs.getString("emp_designation"));
			empDesignations.add(ed);
		}
		
		listempDesig.setItemRenderer(new ListitemRenderer() {

			@Override
			public void render(Listitem item, Object arg1, int arg2)
					throws Exception {
				// TODO Auto-generated method stub
				empDesignation value=(empDesignation) arg1;
				item.appendChild(new Listcell(value.getEmpDesignation()));
				item.setValue(value);
				
				item.setAttribute("data", arg1);
				ComponentsCtrl.applyForward(item, "onDoubleClick=onDoubleClicked");
			}
			
		});
	}
	
	    public void onDoubleClicked(Event event) throws Exception {
	        // get the selected object
	    	
	    	Listitem item = listempDesig.getSelectedItem();
	        empDesignation ed= (empDesignation) item.getAttribute("data");
	        Messagebox.show(ed.getEmpDesignation());
	        }
	    
	    public List<empDesignation> getEmpDesignations1() {
	        return empDesignations;
	    }
}
