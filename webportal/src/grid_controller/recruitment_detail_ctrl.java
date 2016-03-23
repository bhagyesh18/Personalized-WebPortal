package grid_controller;

import java.awt.Checkbox;
import java.io.IOException;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.joda.time.DateTime;
import org.zkoss.util.media.Media;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Image;
import org.zkoss.zul.Radiogroup;
import org.zkoss.zul.Textbox;
import connection.queryclass;

@SuppressWarnings({ "serial", "rawtypes" })
public class recruitment_detail_ctrl extends GenericForwardComposer {
	ResultSet rs;

	Textbox txtfname;
	Textbox txtlname;
	Textbox txtmname;
	Textbox txtmothername;
	Radiogroup rggender;
	Datebox dtDOB;
	Textbox txtpwd;
	Textbox txtgcourse;
	Textbox txtgins;
	Combobox chkgyear;
	Textbox txtgPer;
	Textbox txtpgcourse;
	Textbox txtpgins;
	Combobox chkpgyear;
	Textbox txtpgPer;
	Textbox txtugcourse;
	Textbox txtugins;
	Combobox chkugyear;
	Textbox txtugPer;
	Checkbox chkstatus;
	Image img;
	Media media;
	
	
	@SuppressWarnings("unchecked")
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);

	}
	public void onClick$btnregister() throws IOException {
	
		String flag3;
	
		DateTime dt=new DateTime(dtDOB.getValue());
		int year=dt.getYear();
		String y="Taha";
		for(int i=0;i<year;i++)
		{
			year--;
			chkgyear.appendItem(y);
		}
		
		if(rggender.getSelectedIndex()==0)
		{
			flag3="1";
		}
		else
		{
			flag3="0";
		}
		
		
		String fname = txtfname.getValue();
		String lname=txtlname.getValue();
		String mname=txtmname.getValue();
		String mothername=txtmothername.getValue();
		String birthdate=dtDOB.getText();
		String password=txtpwd.getValue();
		String gcourse=txtgcourse.getValue();
		String gins=txtgins.getValue();
		String gyear=chkgyear.getValue();
		String gper=txtpgPer.getValue();
		String pgcourse=txtpgcourse.getValue();
		String pgins=txtpgins.getValue();
		String pgyear=chkpgyear.getValue();
		String pgper=txtpgPer.getValue();
		String ugcourse=txtugcourse.getValue();
		String ugins=txtugins.getValue();
		String ugyear=chkugyear.getValue();
		String ugper=txtugPer.getValue();
		String status="0";
		
		alert(fname);
		String str;
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date();				
		String recruitment_id=dateFormat.format(date);
		str=txtfname.getValue()+"_"+dtDOB.getText().toString().replaceAll("/","-");
		String photo_path=str + ".jpg";
		String resume_path=str + ".pdf";
		alert(recruitment_id);
		alert(photo_path);
	//	String realpath = null;
	//	Files.copy(new File(realpath.concat("\\webContent\\req_images\\").toString()+recruitment_id+".jpg"), media.getStreamData());
		try
		{
			queryclass obj=new queryclass();
			obj.insertquery("INSERT INTO `webportal`.`recruitment` (`recruitment_id`, `password`, `first_name`, `last_name`, `middle_name`, `mother_name`, `gender`, `dob`, `grad_course`, `grad_institute`, `grad_year`, `grad_percentage`, `post_grad_course`, `post_grad_institute`, `post_grad_year`, `post_grad_percentage`, `under_grad_course`, `under_grad_institute`, `under_grad_year`, `under_grad_percentage`, `status`, `resume_text`, `resume_file_path`) VALUES ('"+recruitment_id+"', '"+password+"', '"+fname+"', '"+lname+"', '"+mname+"', '"+mothername+"', '"+flag3+"', '"+birthdate+"', '"+gcourse+"', '"+gins+"', '"+gyear+"', '"+gper+"', '"+pgcourse+"', '"+pgins+"', '"+pgyear+"', '"+pgper+"', '"+ugcourse+"', '"+ugins+"', '"+ugyear+"', '"+ugper+"', '"+status+"', '"+photo_path+"', '"+resume_path+"')");
			alert("Insert Success...");
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
