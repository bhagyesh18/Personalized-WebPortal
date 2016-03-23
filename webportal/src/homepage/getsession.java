package homepage;

import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Iframe;
import org.zkoss.zul.Label;
import org.zkoss.zul.Messagebox;

public class getsession extends GenericForwardComposer{	
	Label lblName;
	Iframe ifrmHelp;
	Button btnHelp;
	Label lbluser_id;
	Label lblemp_id;
	public void onCreate$winEmp()
	{
		String ss=(String) session.getAttribute("username");
		lbluser_id.setValue(session.getAttribute("user_id").toString());
		lblName.setValue(ss);
		if(session.getAttribute("emp_id")!=null)
		{
			lblemp_id.setValue("Emp Id: "+(String)session.getAttribute("emp_id"));
		}
		
	}
	public void onClick$btnHelp()
	{
		Messagebox.show("Called");
		ifrmHelp.setSrc("checkuser.zul");
	}
}
