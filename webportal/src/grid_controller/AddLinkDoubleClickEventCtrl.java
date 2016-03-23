package grid_controller;

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

import org.zkoss.zul.Radio;

import org.zkoss.zul.Textbox;

import connection.queryclass;
import grid.*;
@SuppressWarnings({ "rawtypes", "serial" })
public class AddLinkDoubleClickEventCtrl extends GenericForwardComposer {

	private List<addLink> addLinks=new ArrayList<addLink>();
	private Listbox listaddLink;
	Textbox txtaln;
	Textbox txtalu;
	Textbox txtald;
	Textbox txtalp;
	Textbox txtalpo;
	Combobox chkurole;
	Radio rgls;
	Button btninsert;
	Button btnupdate;
	
	
	@SuppressWarnings("unchecked")
	public void doAfterCompose(Component comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);
		
		ResultSet rs;
		queryclass q1=new queryclass();
		rs=q1.selectquery("select * from link_master");
		while(rs.next())
		{
			addLink al=new addLink();
			al.setLink_name(rs.getString("link_name"));
			al.setLink_url(rs.getString("link_url"));
			al.setLink_description(rs.getString("link_description"));
			al.setLink_page(rs.getString("link_page"));
			al.setLink_position(rs.getString("link_position"));
			String str1=null;
			String str=rs.getString("link_status");
			int p=Integer.parseInt(str);
			if(p==1)
			{
				str1="Active";
			}
			else {
				str1="InActive";
			}
			al.setLink_status(str1);
			
			addLinks.add(al);
		}
		
		listaddLink.setItemRenderer(new ListitemRenderer() {

			@Override
			public void render(Listitem item, Object arg1, int arg2)
					throws Exception {
				// TODO Auto-generated method stub
				addLink value=(addLink) arg1;
				item.appendChild(new Listcell(value.getLink_name()));
				item.appendChild(new Listcell(value.getLink_url()));
				item.appendChild(new Listcell(value.getLink_description()));
				item.appendChild(new Listcell(value.getLink_page()));
				item.appendChild(new Listcell(value.getLink_position()));
				item.appendChild(new Listcell(value.getLink_status()));
				
				item.setValue(value);
				
				item.setAttribute("data", arg1);
				ComponentsCtrl.applyForward(item, "onDoubleClick=onDoubleClicked");
			}
			
		});
	}
	
	    public void onDoubleClicked(Event event) throws Exception {
	        // get the selected object
	    	
	    	Listitem item = listaddLink.getSelectedItem();
	        addLink al= (addLink) item.getAttribute("data");
	        txtaln.setValue(al.getLink_name());
	        txtalu.setValue(al.getLink_url());
	        txtald.setValue(al.getLink_description());
	        txtalp.setValue(al.getLink_page());
	        txtalpo.setValue(al.getLink_position());
	        }
	    
	    public List<addLink> getAddLinks1() {
	        return addLinks;
	    }
	    
	    
	    public void onClick$btninsert()
	    {
	    	
	
	    	
	    	try
	    	{
	    		String urole=chkurole.getValue();
	    		String getUserRoleId = null;
	    		String getUserId=null;
	    		String linkid=null;
	    		queryclass obj=new queryclass();
	    		String strInsert="INSERT INTO `webportal`.`link_master` (`link_name`, `link_url`, `link_description`, `link_page`, `link_position`, `link_status`) VALUES ('"+txtaln.getValue().toString()+"', '"+txtalu.getValue().toString()+"', '"+txtald.getValue().toString()+"', '"+txtalp.getValue().toString()+"', '"+txtalpo.getValue().toString()+"', 1)";
	    	    obj.insertquery(strInsert);
	    	    
	    	    ResultSet rs=null;

	    	    String struserrole="select user_role_id from user_role where user_role='"+urole+"'";
				rs=obj.selectquery(struserrole);
				if(rs.next())
				{
					getUserRoleId=rs.getString("user_role_id").toString();
				}
	    	    rs=null;
				String str1="select link_id from link_master where link_name='"+txtaln.getValue().toString()+"'";
	    	    rs=obj.selectquery(str1);
	    	    
	    	    if (rs.next()) {
	    	    	linkid=rs.getString("link_id").toString();
	    	    }
	    	   	String query="INSERT INTO `webportal`.`link_details` (`user_role_id`, `link_id`) VALUES ('"+getUserRoleId+"', '"+linkid+"')";			
				obj.insertquery(query);
					
				rs=null;
				
				String struser="select user_id from user_master where user_role_id='"+getUserRoleId+"'";
				rs=obj.selectquery(struser);
				while(rs.next())
				{
					getUserId=rs.getString("user_id").toString();
					String strQuery="INSERT INTO `webportal`.`personalized_links` (`user_id`, `link_id`, `accessed`) VALUES ('"+getUserId+"', '"+linkid+"', '1')";
					obj.insertquery(strQuery);
				}				
	    	}
	    	catch (Exception e) {
				alert(e.getMessage());
			}
	    }
	    
	    public void onClick$btnupdate()
		{
			
			try{
				queryclass obj=new queryclass();
				ResultSet rs=null;
				String getUserRoleId=null;
				String linkid=null;
				
				String str1="select link_id from link_master where link_name='"+txtaln.getValue().toString()+"'";
	    	    rs=obj.selectquery(str1);
	    	    
	    	    if (rs.next()) {
	    	    	linkid=rs.getString("link_id").toString();
	    	    }
	    	    String urole=chkurole.getValue();
	    	    ResultSet rs2=null;
				String struserrole="select user_role_id from user_role where user_role='"+urole+"'";
				rs2=obj.selectquery(struserrole);
				if(rs2.next())
				{
					getUserRoleId=rs2.getString("user_role_id").toString();
				}
				
				queryclass obj1=new queryclass();
				
				obj1.updatequery("UPDATE `webportal`.`link_master` SET `link_name`='"+txtaln.getValue().toString()+"', `link_url`='"+txtalu.getValue().toString()+"', `link_description`='"+txtald.getValue().toString()+"', `link_page`='"+txtalp.getValue().toString()+"', `link_position`='"+txtalpo.getValue().toString()+"', `link_status`=1 WHERE `link_id`='"+linkid+"'");
		
				ResultSet rs3=null;
				String getLinkDetailId=null;
				String strlink="select link_details_id from link_details where link_id='"+linkid+"'";
				rs3=obj.selectquery(strlink);
				if(rs3.next())
				{
					getLinkDetailId=rs3.getString("link_details_id").toString();
				}
				
				obj1.updatequery("UPDATE `webportal`.`link_details` SET `user_role_id`='"+getUserRoleId+"', `link_id`='"+linkid+"' WHERE `link_details_id`='"+getLinkDetailId+"'");

				ResultSet rs4=null;alert("Record updated succesffully ");
				String getPerLinkId=null;
				String strplink="select per_link_id from personalized_links where link_id='"+linkid+"'";
				rs4=obj.selectquery(strplink);
				if(rs4.next())
				{
					getPerLinkId=rs4.getString("per_link_id").toString();
				}
				String getUserId=null;
				String struser="select user_id from user_master where user_role_id='"+getUserRoleId+"'";
				rs4=obj.selectquery(struser);
				if(rs4.next())
				{
					getUserId=rs4.getString("user_id").toString();
				}
				obj1.updatequery("UPDATE `webportal`.`personalized_links` SET `user_id`='"+getUserId+"', `link_id`='"+linkid+"', `accessed`='1' WHERE `per_link_id`='"+getPerLinkId+"'");

				
				
			}
			catch (Exception e) {
				// TODO: handle exception
			}
			
			
		}

}
