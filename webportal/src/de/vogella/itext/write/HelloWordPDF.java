package de.vogella.itext.write;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;

public class HelloWordPDF {
  private static String file = "c:/FirstPdf.pdf";
  private static String OUTPUTFILE = "c:/ReadPdf.pdf";

  public static void main(String[] args) throws Exception
  {
	  String fileName = "C:\\FirstPdf.pdf";
      String[] commands = {"cmd", "/c", fileName};
     
      
      
      
      try {
          Runtime.getRuntime().exec(commands);
//Runtime.getRuntime().exec("C:\\Users\\Riyasam\\Documents\\NetBeansProjects\\SwingTest\\src\\Test\\RealWorld.chm");
      } catch (Exception ex) {
          ex.printStackTrace();
      }
  }
}