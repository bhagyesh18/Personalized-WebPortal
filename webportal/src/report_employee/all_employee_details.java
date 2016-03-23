package report_employee;

import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.util.Date;

import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Button;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Combobox;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import connection.queryclass;

@SuppressWarnings("rawtypes")
public class all_employee_details extends GenericForwardComposer {

	Button btnreport;   
		
		Checkbox checkbox_desi;
		Combobox chkdesig;
		
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
	   public static String itext_emp_id;
	   public static String itext_user_id;
	   public static String itext_first_name;
	   public static String  itext_last_name;
	   public static String itext_address;
	   public static String itext_city_id;
	   public static String itext_email_id;
	   public static String itext_mobile_no;
	   public static String itext_emp_designation_id;
	   public static String itext_basic_salary;
	   public static String itext_dateOfjoin;
	   public static String itext_dateOfbirth;
	   public static String itext_gender;
	   public static String itext_maritual_status;
	   public static String  itext_status;
	   public static String  itext_photo;
	   
	   public static String   itext_leavebalance_id;
	   public static String  itext_leavetype_id;
	   public static String  itext_leave_taken;
	   public static String  itext_leave_pending;
	   
	   
	   ResultSet rs2;

	
	   
	   public void onClick$btnreport()
	   {
		   
		
		  if(checkbox_desi.isChecked()==false)
		  {
			 // alert("yes");
			  
			  
			   
			   
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
		  else
		  {
			  
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

										    Paragraph Title_head = new Paragraph("Employee Details",catFont);
										    Title_head.setAlignment(Element.ALIGN_CENTER);
										    document.add(Title_head);
										
										    addEmptyLine(preface, 1);

	// Set Employe property
									   
									 
									    


					    

	// Table Data 
									    Paragraph subject_to_table=new Paragraph("Details Of employess",subjectFont);
									    subject_to_table.setAlignment(Element.ALIGN_CENTER);
									    addEmptyLine(subject_to_table, 1);
									    document.add(subject_to_table);
									    
									    

												    PdfPTable table = new PdfPTable(10);
												    // t.setBorderColor(BaseColor.GRAY);
												    // t.setPadding(4);
												    // t.setSpacing(4);
												    // t.setBorderWidth(1);
												   table.setWidthPercentage(99.0f);
												   
												   
												    PdfPCell c1 = new PdfPCell(new Phrase(" Emp_id ", FontFactory.getFont(FontFactory.HELVETICA, 8)));
												    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
												    c1.setBackgroundColor(BaseColor.LIGHT_GRAY);
												  c1.setNoWrap(true);
												 table.addCell(c1);
												    
												    c1 = new PdfPCell(new Phrase("First name", FontFactory.getFont(FontFactory.HELVETICA, 8)));
												    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
												    c1.setBackgroundColor(BaseColor.LIGHT_GRAY);
												    c1.setNoWrap(true);
												    table.addCell(c1);
												    
												    c1 = new PdfPCell(new Phrase(" Last name ", FontFactory.getFont(FontFactory.HELVETICA, 8)));
												    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
												    c1.setBackgroundColor(BaseColor.LIGHT_GRAY);
												    c1.setNoWrap(true);
												    table.addCell(c1);
												    
												    c1 = new PdfPCell(new Phrase(" city ", FontFactory.getFont(FontFactory.HELVETICA, 8)));
												    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
												    c1.setBackgroundColor(BaseColor.LIGHT_GRAY);
												    c1.setNoWrap(true);
												    table.addCell(c1);
												     c1 = new PdfPCell(new Phrase(" Email ", FontFactory.getFont(FontFactory.HELVETICA, 8)));
												    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
												    c1.setBackgroundColor(BaseColor.LIGHT_GRAY);
												    c1.setNoWrap(true);
												    table.addCell(c1);
												    
												    c1 = new PdfPCell(new Phrase(" Mobile ", FontFactory.getFont(FontFactory.HELVETICA, 8)));
												    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
												    c1.setBackgroundColor(BaseColor.LIGHT_GRAY);
												    c1.setNoWrap(true);
												    table.addCell(c1);
												   c1 = new PdfPCell(new Phrase(" Designation ", FontFactory.getFont(FontFactory.HELVETICA, 8)));
												    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
												    c1.setBackgroundColor(BaseColor.LIGHT_GRAY);
												    c1.setNoWrap(true);
												    table.addCell(c1);
												    
												    c1 = new PdfPCell(new Phrase(" Basic Salary ", FontFactory.getFont(FontFactory.HELVETICA, 8)));
												    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
												    c1.setBackgroundColor(BaseColor.LIGHT_GRAY);
												    c1.setNoWrap(true);
												    table.addCell(c1);
												    c1 = new PdfPCell(new Phrase(" Date Of Join ", FontFactory.getFont(FontFactory.HELVETICA, 8)));
												    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
												    c1.setBackgroundColor(BaseColor.LIGHT_GRAY);
												    c1.setNoWrap(true);
												    table.addCell(c1);
												    
												    c1 = new PdfPCell(new Phrase(" Birth Date ", FontFactory.getFont(FontFactory.HELVETICA, 8)));
												    c1.setHorizontalAlignment(Element.ALIGN_LEFT);
												    c1.setBackgroundColor(BaseColor.LIGHT_GRAY);
												    c1.setNoWrap(true);
												    table.addCell(c1);
												    
												    table.setHeaderRows(1);
												    
												   

												    
												    
												    try
													{
														//listbox_salary.setVisible(true);
														
														queryclass profile_obj=new queryclass();
														ResultSet rs1=profile_obj.selectquery("select * from employee");
														while(rs1.next())
														{
															//alert(rs1.getString("emp_id"));
															 itext_emp_id=rs1.getString("emp_id");
															   itext_user_id=rs1.getString("user_id");
															  itext_first_name=rs1.getString("first_name");
															   itext_last_name=rs1.getString("last_name");
															itext_address=rs1.getString("address");
															
															
															queryclass obj=new queryclass();
															
															ResultSet rs2=obj.selectquery("select city_name from city where city_id='"+ rs1.getString("city_id").toString()+"'");
																rs2.next();
															   itext_city_id=rs2.getString("city_name");
															  itext_email_id=rs1.getString("email_id");
															itext_mobile_no=rs1.getString("mobile_no");
															
															
															queryclass obj2=new queryclass();
															ResultSet rs3=obj2.selectquery("SELECT * FROM webportal.employee_designation where emp_designation_id='"+ rs1.getString("emp_designation_id") +"';");
															rs3.next();
															itext_emp_designation_id=rs3.getString("emp_designation").toString();
															
															   
															   itext_basic_salary=rs1.getString("basic_salary");
															 itext_dateOfjoin=rs1.getString("dateOfjoin");
															   itext_dateOfbirth=rs1.getString("dateOfbirth");
															   if(rs1.getString(12).toString().equals("1"))
															   {
																   itext_gender="Male";
															   }
															   else
															   {
																   itext_gender="Female"; 
															   }
															   
															 
															 itext_maritual_status=rs1.getString("maritual_status");
															 
															 itext_status=rs1.getString(14);
															   itext_photo=rs1.getString(15);
															
															
															   
															   
															 
															    table.addCell(new Phrase(itext_emp_id , FontFactory.getFont(FontFactory.HELVETICA, 8)));
																											    
													
															    table.addCell(new Phrase(itext_first_name , FontFactory.getFont(FontFactory.HELVETICA, 8)));
															    
															  
															    table.addCell(new Phrase(itext_last_name , FontFactory.getFont(FontFactory.HELVETICA, 8)));
															    												    
															
															    table.addCell(new Phrase(itext_city_id, FontFactory.getFont(FontFactory.HELVETICA, 8)));
															
															    table.addCell(new Phrase(itext_email_id, FontFactory.getFont(FontFactory.HELVETICA, 8)));
															
															    table.addCell(new Phrase(itext_mobile_no, FontFactory.getFont(FontFactory.HELVETICA, 8)));
															  
															    table.addCell(new Phrase(itext_emp_designation_id, FontFactory.getFont(FontFactory.HELVETICA, 8)));
															    
														
															    table.addCell(new Phrase(itext_basic_salary, FontFactory.getFont(FontFactory.HELVETICA, 8)));
															  
															    table.addCell(new Phrase(itext_dateOfjoin, FontFactory.getFont(FontFactory.HELVETICA, 8)));
															    
															    table.addCell(new Phrase(itext_dateOfbirth, FontFactory.getFont(FontFactory.HELVETICA, 8))); 
															   
															   
														}
													}
														catch (Exception e) {
															
														}
														
												    
												    
												   
												    
												   
												    document.add(table);

												    
												    
												    
												  
												    
												   


												    


	//Add Fommula   


									    Paragraph notice = new Paragraph();
									    addEmptyLine(notice, 1);
									    
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
