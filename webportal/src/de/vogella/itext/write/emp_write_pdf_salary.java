package de.vogella.itext.write;

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


public class emp_write_pdf_salary {
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
  public static void main(String[] args) {
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

  // iText allows to add metadata to the PDF which can be viewed in your Adobe
  // Reader
  // under File -> Properties
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
								   
								    preface.add(new Paragraph("Employee ID : " ,smallBold));
								    preface.add(new Paragraph("Name : " ,smallBold));
								    preface.add(new Paragraph("Designation : " ,smallBold));
								    preface.add(new Paragraph("Email Id : " ,smallBold));
								    preface.add(new Paragraph("Contact No : " ,smallBold));
								    addEmptyLine(preface, 1);
								    preface.add(new Paragraph("Salary Id : " ,smallBold));
								    
								    document.add(preface);
								    
    
    
    //Add Subject to table 
    
								    Paragraph subject_to_table=new Paragraph("Month : December  Year 2012 : ",subjectFont);
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
											    table.addCell("1.1");
											    
											    table.addCell("basic Salary");
											    table.addCell("2.1");
											    
											    table.addCell("Da");
											    table.addCell("2.3");
											    
											    table.addCell("HRA");
											    table.addCell("1.1");
											    
											    table.addCell("PF");
											    table.addCell("2.1");
											    
											    table.addCell("Deduction");
											    table.addCell("2.3");
											    
											    table.addCell("Gross salary");
											    table.addCell("1.1");
											    
											    table.addCell("Net salary");
											    table.addCell("2.1");
											    document.add(table);
    
    
    
    
  //Add Fommula   
    
    
								    Paragraph notice = new Paragraph();
								    addEmptyLine(notice, 1);
								    notice.add(new Paragraph(" Formulas to be used in Salary \n da = 22% of basic salary \n hra = 15% of basic salary \n pf = 12% of (basic salary + da) \n medical = Rs.300 \n gross salary = da+hra+hra+medical \n net salary = gross salary - pf",formulaFont));
								    addEmptyLine(notice,1 );
								    notice.add(new Paragraph("This document is a private document to respective indivisula person in company . this is document is just untrue copy without true copied by respective HR",
								            redFont));
								    addEmptyLine(notice,11 );
								    document.add(notice);
								    
    
    // add footer
   
    Paragraph date_footer = new Paragraph("This is left aligned text",formulaFont);
    
    date_footer.setAlignment(Element.ALIGN_CENTER);
    document.add(date_footer);
  }

  
 
 

  private static void addEmptyLine(Paragraph paragraph, int number) {
    for (int i = 0; i < number; i++) {
      paragraph.add(new Paragraph(" "));
    }
  }
} 