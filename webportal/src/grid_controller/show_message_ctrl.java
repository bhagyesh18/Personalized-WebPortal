package grid_controller;
import grid_model.employee;
import grid_model.messaging;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import org.apache.catalina.connector.Request;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.sys.ComponentsCtrl;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import connection.queryclass;

@SuppressWarnings({ "rawtypes", "serial" })
public class show_message_ctrl extends GenericForwardComposer{
	private List<messaging> messagings = new ArrayList<messaging>();
	private Listbox list_message;
	ResultSet rs_mes;
	Window win_re_message;
	Textbox txtto;
	Textbox txtsubject;
	Textbox txtmessage;	
	@SuppressWarnings("unchecked")
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);
		
		try
		{
		queryclass mes_obj=new queryclass();
		rs_mes=mes_obj.selectquery("SELECT * FROM webportal.messaging where to_user='" +session.getAttribute("username")+ "' order by status asc;");
		
		while(rs_mes.next())
		{
			messaging mes=new messaging();
			
			mes.setMessage_id(rs_mes.getString("message_id"));
			mes.setTo_user(rs_mes.getString("to_user"));
			mes.setFrom_user(rs_mes.getString("from_user"));
			mes.setSubject(rs_mes.getString("subject"));
			mes.setMessage(rs_mes.getString("message"));
			mes.setDate(rs_mes.getString("date"));
			mes.setTime(rs_mes.getString("time"));
			mes.setStatus(rs_mes.getString("status"));
			
			messagings.add(mes);
			
			
		}
		}
		catch (Exception e) {
			// TODO: handle exception
			
			alert(e.getMessage());
		}
		list_message.setItemRenderer(new ListitemRenderer() {

			@Override
			public void render(Listitem item, Object arg1, int arg2)
					throws Exception {
			messaging val=(messaging)arg1;
			item.appendChild(new Listcell(val.getMessage_id()));
			item.appendChild(new Listcell(val.getTo_user()));
			item.appendChild(new Listcell(val.getFrom_user()));
			item.appendChild(new Listcell(val.getSubject()));
			item.appendChild(new Listcell(val.getMessage()));
			item.appendChild(new Listcell(val.getDate()));
			item.appendChild(new Listcell(val.getTime()));
			
			String statusrw=null;
			if(val.getStatus().equals("1"))
			{
				statusrw="Read";
			}
			else
			{
				statusrw="UnRead";
			}
			
			item.appendChild(new Listcell(statusrw.toString()));
			item.setValue(val);
			item.setAttribute("data", arg1);

			ComponentsCtrl.applyForward(item,
					"onDoubleClick=onDoubleClicked");
				
			}
		
		});
		
		
	}
	
	
	public void onDoubleClicked(Event event) throws Exception {
	
		
		Listitem item = list_message.getSelectedItem();
		messaging mes = (messaging) item.getAttribute("data");
	try
	{
		queryclass change_sta=new queryclass();
		change_sta.updatequery("UPDATE `webportal`.`messaging` SET `status`='1' WHERE `message_id`='"+ mes.getMessage_id().toString() +"';");
	}catch (Exception e) {
		alert(e.getMessage());
	}	
	
		
		 requestScope.put("to", mes.getFrom_user().toString());
		 requestScope.put("from", mes.getTo_user().toString());
		 requestScope.put("subject", mes.getSubject().toString());
		 requestScope.put("message", mes.getMessage().toString());
		
		  Window window = (Window)Executions.createComponents(
                  "reply_message.zul", null, null);
          window.doHighlighted();
          
          
		//win_re_message.setVisible(true);		
		//win_re_message.doHighlighted();
		
		
		//alert(""+requestScope.get("name").toString());
		
		
		}
	
	
	
	public List<messaging> getMessagings1() {
		return messagings;
	}
}
