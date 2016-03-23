package Salary_Controller;

import grid.salary;

import java.awt.Button;
import java.sql.ResultSet;

import jxl.biff.drawing.ComboBox;

import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import java.io.FileOutputStream;
import java.util.Date;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


import connection.queryclass;

@SuppressWarnings({ "rawtypes", "serial" })
public class generate_payslip extends GenericForwardComposer {
	Combobox comboMonth;
	Combobox chkyear;
	Listbox listbox_salary;
	
   Listcell	 lc_salary_id;
   Listcell	 lc_emp_id;
   Listcell	 lc_month;
   Listcell	 lc_year;
   Listcell	  lc_basic_salary;
   Listcell	  lc_da;
   Listcell	 lc_hra;
   Listcell	 lc_pf;
   Listcell	  lc_gross_salary;
   Listcell	  lc_deduction;
   Listcell	  lc_net_salary;
   
   Button btnshow;
   Button btnpdf;
   ResultSet rs_salary;
   ResultSet rs_salary_pdf;
   ResultSet rs_name;
   
   
   //itext varibles 
   private static String FILE = "c:/bg11111.pdf";
   private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
 	      Font.BOLD);
 	  private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
 	      Font.ITALIC, BaseColor.RED);
 	  private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
 	      Font.BOLD);
 	  private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 13,
 	      Font.NORMAL);
   private static Font subjectFont = new Font(Font.FontFamily.TIMES_ROMAN, 10,
 	      Font.BOLD);
   private static Font formulaFont = new Font(Font.FontFamily.TIMES_ROMAN, 9,
 	      Font.ITALIC);
   private static Font noticeFont = new Font(Font.FontFamily.TIMES_ROMAN, 9,
 	      Font.ITALIC,BaseColor.RED);
   
   
   
   //String variable for set to itext fields
   public static String itext_salary_id;
   public static String itext_emp_id;
   public static String itext_month;
   public static String itext_year;
   public static String itext_basic_salary;
   public static String itext_da;
   public static String itext_hra;
   public static String itext_pf;
   public static String itext_gross_salary;
   public static String itext_deduction;
   public static String itext_net_salary;
   
   public static String itext_first_name;
   public static String itext_last_name;
   public static String itext_designation;
   public static String itext_mobile_no;
   public static String itext_email_id;
   
   
   
   public void onClick$btnshow()
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
		
		try
		{
			listbox_salary.setVisible(true);
			
			queryclass salary_obj=new queryclass();
			rs_salary= salary_obj.selectquery("select * from salary where emp_id='"+ session.getAttribute("emp_id") +"' and year='"+ chkyear.getValue().toString() +"' and month='" + month_data + "'   ");
			if(rs_salary.next())
			{
					 lc_salary_id.setLabel(rs_salary.getString("salary_id"));
				  	 lc_emp_id.setLabel(rs_salary.getString("emp_id"));
				 	 lc_month.setLabel(rs_salary.getString("month"));
				  	 lc_year.setLabel(rs_salary.getString("year"));
				   	  lc_basic_salary.setLabel(rs_salary.getString("basic_salary"));
				  	  lc_da.setLabel(rs_salary.getString("da"));
				 	 lc_hra.setLabel(rs_salary.getString("hra"));
				    lc_pf.setLabel(rs_salary.getString("pf"));
				  lc_gross_salary.setLabel(rs_salary.getString("gross_salary"));
				  	  lc_deduction.setLabel(rs_salary.getString("deduction"));
				    lc_net_salary.setLabel(rs_salary.getString("net_salary"));
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		  
	   
   }
   
   
   
   public void onClick$btnpdf()
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
		
		try
		{
			//listbox_salary.setVisible(true);
			
			queryclass salary_obj1=new queryclass();
			rs_salary_pdf= salary_obj1.selectquery("select * from salary where emp_id='"+ session.getAttribute("emp_id") +"' and year='"+ chkyear.getValue().toString() +"' and month='" + month_data + "'   ");
			if(rs_salary_pdf.next())
			{
				itext_salary_id=rs_salary_pdf.getString("salary_id");
				itext_emp_id=rs_salary_pdf.getString("emp_id");
				itext_month=rs_salary_pdf.getString("month");
				itext_year=rs_salary_pdf.getString("year");
				itext_basic_salary=rs_salary_pdf.getString("basic_salary");
				itext_da=rs_salary_pdf.getString("da");
				itext_hra=rs_salary_pdf.getString("hra");
				itext_pf=rs_salary_pdf.getString("pf");
				itext_gross_salary=rs_salary_pdf.getString("gross_salary");
				itext_deduction=rs_salary_pdf.getString("deduction");
				itext_net_salary=rs_salary_pdf.getString("net_salary");
				   	
			}
			
			
			queryclass obj=new queryclass();
			rs_name=obj.selectquery("Select e.first_name ,e.last_name ,e.email_id ,e.mobile_no ,des.emp_designation from webportal.employee e,webportal.employee_designation des where e.emp_id='" +session.getAttribute("emp_id").toString() +"' and e.emp_designation_id=des.emp_designation_id;");
			if(rs_name.next())
			{
				 itext_first_name=rs_name.getString("first_name");
				 itext_last_name=rs_name.getString("last_name");
				   itext_designation=rs_name.getString("emp_designation");
				  itext_mobile_no=rs_name.getString("mobile_no");
				  itext_email_id=rs_name.getString("email_id");
			}
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		  
	   
	   
	   try {
		      Document document = new Document();
		      PdfWriter.getInstance(document, new FileOutputStream(FILE));
		      document.open();
		      addMetaData(document);
		      addTitlePage(document);
		     
		      document.close();
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
		    
		    String fileName = "C:\\bg11111.pdf";
		    String[] commands = {"cmd", "/c", fileName};
		   
		    
		    
		    
		    try {
		        Runtime.getRuntime().exec(commands);
		        		//Runtime.getRuntime().exec("C:\\Users\\Riyasam\\Documents\\NetBeansProjects\\SwingTest\\src\\Test\\RealWorld.chm");
		    } catch (Exception ex) {
		        ex.printStackTrace();
		    }
		      
	   
	   
   }
   
   private static void addMetaData(Document document) {
	    document.addTitle("My first PDF");
	    document.addSubject("Using iText");
	    document.addKeywords("Java, PDF, iText");
	    document.addAuthor("Lars Vogel");
	    document.addCreator("Lars Vogel");
	  }

   private static void addTitlePage(Document document)
   throws DocumentException {
	  
	  
	  Paragraph preface = new Paragraph();
	    // We add one empty line
	    addEmptyLine(preface, 1);
	   
 
 //title 

									    Paragraph Title_head = new Paragraph("Salary Slip",catFont);
									    Title_head.setAlignment(Element.ALIGN_CENTER);
									    document.add(Title_head);
									
									    addEmptyLine(preface, 1);

 // Set Employe property
								   
								    preface.add(new Paragraph("Empploye ID : "+itext_emp_id ,smallBold));
								    preface.add(new Paragraph("Name : "+itext_first_name +" "+itext_last_name ,smallBold));
								    preface.add(new Paragraph("Designation : "+itext_designation ,smallBold));
								    preface.add(new Paragraph("Email Id : "+itext_email_id ,smallBold));
								    preface.add(new Paragraph("Contact No : "+itext_mobile_no ,smallBold));
								    addEmptyLine(preface, 1);
								    preface.add(new Paragraph("Salary Id : " + itext_salary_id ,smallBold));
								    
								    document.add(preface);
								    
 
 
 //Add Subject to table 
 
								    Paragraph subject_to_table=new Paragraph("Month :"+ itext_month +" Year :"+itext_year,subjectFont);
								    subject_to_table.setAlignment(Element.ALIGN_CENTER);
								    addEmptyLine(subject_to_table, 1);
								    document.add(subject_to_table);
								    
 
 // Table Data 
 
											    PdfPTable table = new PdfPTable(2);
											    // t.setBorderColor(BaseColor.GRAY);
											    // t.setPadding(4);
											    // t.setSpacing(4);
											    // t.setBorderWidth(1);

											    PdfPCell c1 = new PdfPCell(new Phrase(" Fields "));
											    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
											    c1.setBackgroundColor(BaseColor.LIGHT_GRAY);
											  
											    table.addCell(c1);
											    
											    c1 = new PdfPCell(new Phrase(" Details "));
											    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
											    c1.setBackgroundColor(BaseColor.LIGHT_GRAY);
											 
											    table.addCell(c1);
											    
											    
											    table.setHeaderRows(1);
											    
											   
											
											    
											    table.addCell("Salary id");
											    table.addCell(itext_salary_id);
											    
											    table.addCell("basic Salary");
											    table.addCell(itext_basic_salary+ " Rs.");
											    
											    table.addCell("Da");
											    table.addCell(itext_da+ " Rs.");
											    
											    table.addCell("HRA");
											    table.addCell(itext_hra+ " Rs.");
											    
											    table.addCell("PF");
											    table.addCell(itext_pf+ " Rs.");
											    
											    table.addCell("Medical");
											    table.addCell("300.00"+ " Rs.");
											    
											    table.addCell("Deduction");
											    table.addCell(itext_deduction+ " Rs.");
											    
											    table.addCell("Gross salary");
											    table.addCell(itext_gross_salary+ " Rs.");
											    
											    table.addCell("Net salary");
											    table.addCell(itext_net_salary+ " Rs.");
											    document.add(table);
 
 
 
 
//Add Fommula   
 
 
								    Paragraph notice = new Paragraph();
								    addEmptyLine(notice, 1);
								    notice.add(new Paragraph(" Formulas to be used in Salary \n da = 22% of basic salary \n hra = 15% of basic salary \n pf = 12% of (basic salary + da) \n medical = Rs.300 \n gross salary = da+hra+hra+medical \n net salary = gross salary - pf",formulaFont));
								    addEmptyLine(notice,1 );
								    notice.add(new Paragraph("This document is a private document to respective individual person in company . this is document is just uncertied payslip copy without true copied by respective HR",
								            redFont));
								    addEmptyLine(notice,10 );
								    document.add(notice);
								    
 
 // add footer

 Paragraph date_footer = new Paragraph("Document printed on :"+new Date(),formulaFont);
 
 date_footer.setAlignment(Element.ALIGN_CENTER);
 document.add(date_footer);
}





private static void addEmptyLine(Paragraph paragraph, int number) {
 for (int i = 0; i < number; i++) {
   paragraph.add(new Paragraph(" "));
 }
}
   
}
