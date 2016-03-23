package webpart_package;


import java.sql.ResultSet;

import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Panel;
import connection.queryclass;

@SuppressWarnings({ "rawtypes", "serial" })
public class webpart_ctrl extends GenericForwardComposer{

	ResultSet rs;
	ResultSet rs1;
	org.zkoss.zul.Panel wiki_plugin;
	Panel twiter_plugin;
	Panel tool_plugin;
	Panel todo_plugin;
	Panel linked_in_plugin;
	Panel facebook_comment_plugin;
	Panel clock_plugin;
Button btn_edit;
	public void onCreate$win_webpart()
	{
		if(session.getAttribute("username")!=null && session.getAttribute("user_id")!=null)
		{
			btn_edit.setVisible(true);
			
			try
			{
						
				queryclass select_panel=new queryclass();
						rs=select_panel.selectquery("SELECT pl.panel_name ,wp.status FROM webportal.personalized_panel wp, webportal.panel_master pl where pl.panel_status='1' and wp.status='1' and wp.panel_id=pl.panel_id and user_id='" + session.getAttribute("user_id").toString()+"';");
											while(rs.next())
								{
									
										if(rs.getString("panel_name").toString().equals("wiki_plugin"))
										{
											wiki_plugin.setVisible(true);	
										}if(rs.getString("panel_name").toString().equals("twiter_plugin"))
										{
											twiter_plugin.setVisible(true);	
										}
										if(rs.getString("panel_name").toString().equals("tool_plugin"))
										{
											tool_plugin.setVisible(true);	
										}
										if(rs.getString("panel_name").toString().equals("todo_plugin"))
										{
											todo_plugin.setVisible(true);	
										}
										if(rs.getString("panel_name").toString().equals("linked_in_plugin"))
										{
											linked_in_plugin.setVisible(true);	
										}
										if(rs.getString("panel_name").toString().equals("facebook_comment_plugin"))
										{
											facebook_comment_plugin.setVisible(true);	
										}
										if(rs.getString("panel_name").toString().equals("clock_plugin"))
										{
											clock_plugin.setVisible(true);	
										}
										
												
												
									}
												
												
															
									}
									catch (Exception e) {
										
									}
					
					
				}
				else if(session.getAttribute("username")==null && session.getAttribute("user_id")==null)
				{
					try
					{
								queryclass select_panel_all=new queryclass();
								rs1=select_panel_all.selectquery("SELECT * FROM webportal.panel_master where panel_status='1';");
													while(rs1.next())
										{
											
												if(rs1.getString("panel_name").toString().equals("wiki_plugin"))
												{
													wiki_plugin.setVisible(true);	
												}if(rs1.getString("panel_name").toString().equals("twiter_plugin"))
												{
													twiter_plugin.setVisible(true);	
												}
												if(rs1.getString("panel_name").toString().equals("tool_plugin"))
												{
													tool_plugin.setVisible(true);	
												}
												if(rs1.getString("panel_name").toString().equals("todo_plugin"))
												{
													todo_plugin.setVisible(true);	
												}
												if(rs1.getString("panel_name").toString().equals("linked_in_plugin"))
												{
													linked_in_plugin.setVisible(true);	
												}
												if(rs1.getString("panel_name").toString().equals("facebook_comment_plugin"))
												{
													facebook_comment_plugin.setVisible(true);	
												}
												if(rs1.getString("panel_name").toString().equals("clock_plugin"))
												{
													clock_plugin.setVisible(true);	
													
												}
												
														
														
											}
														
														
																	
											}
											catch (Exception e) {
												
											}
							
					
				}
		
		
		
	}
}
