package gci.app.controller;

import gci.app.model.CustomerModel;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.lang.time.DateUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class PDFModule {
    private static CustomerModel customerModel;
    private static String fileName;
    
    protected static void setCustomerModel(CustomerModel cm) {
        customerModel = cm;
    }
    
    protected static void setFilename(String fn){
        fileName = fn;
    }
    
    protected static void createPDF(Date date){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        
        final String name = customerModel.getName();
        final String surname = customerModel.getSurname();
        final String taxCode = customerModel.getTaxCode();
        final String birthDate = dateFormat.format(customerModel.getDateOfBirth());
        final String homeAddress = customerModel.getHomeAddress();
        final String phone = customerModel.getPhone();
        final String email = customerModel.getEmail();
        
        dateFormat = new SimpleDateFormat("dd_MM_yyyy");
        
        Date expDate = DateUtils.addMonths(date, 1);
        
        
        final String dateOfCreation = dateFormat.format(date);
        
        dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        final String expirationDateToWrite = dateFormat.format(expDate);
        
        fileName = taxCode + "_" + dateOfCreation +
                                ".pdf";
        try{
            PDDocument document = new PDDocument();
            PDPage page = new PDPage();

            document.addPage(page);

            PDPageContentStream content = new PDPageContentStream(document, page);

            content.beginText();
            content.setFont(PDType1Font.HELVETICA, 26);
            content.moveTextPositionByAmount(250, 750);
            content.drawString("Bill OF " + name + " " + surname);
            content.endText();


            content.beginText();
            content.setFont(PDType1Font.HELVETICA, 16);
            content.moveTextPositionByAmount(80, 700);
            content.drawString("Tax Code : ");
            content.endText();
            
            content.beginText();
            content.setFont(PDType1Font.HELVETICA, 16);
            content.moveTextPositionByAmount(250, 700);
            content.drawString(taxCode);
            content.endText();


            content.beginText();
            content.setFont(PDType1Font.HELVETICA, 16);
            content.moveTextPositionByAmount(80,650);
            content.drawString("Birth Date : ");
            content.endText();

            content.beginText();
            content.setFont(PDType1Font.HELVETICA, 16);
            content.moveTextPositionByAmount(250,650);
            content.drawString(birthDate);
            content.endText();
            
            content.beginText();
            content.setFont(PDType1Font.HELVETICA, 16);
            content.moveTextPositionByAmount(80,600);
            content.drawString("Home Address : ");
            content.endText();
            
            content.beginText();
            content.setFont(PDType1Font.HELVETICA, 16);
            content.moveTextPositionByAmount(250,600);
            content.drawString(homeAddress);
            content.endText();
            
            content.beginText();
            content.setFont(PDType1Font.HELVETICA, 16);
            content.moveTextPositionByAmount(80,550);
            content.drawString("Phone : ");
            content.endText();
            
            content.beginText();
            content.setFont(PDType1Font.HELVETICA, 16);
            content.moveTextPositionByAmount(250,550);
            content.drawString(phone);
            content.endText();

            content.beginText();
            content.setFont(PDType1Font.HELVETICA, 16);
            content.moveTextPositionByAmount(80,500);
            content.drawString("Email : ");
            content.endText();
            
            content.beginText();
            content.setFont(PDType1Font.HELVETICA, 16);
            content.moveTextPositionByAmount(250,500);
            content.drawString(email);
            content.endText();
            
            content.beginText();
            content.setFont(PDType1Font.HELVETICA, 20);
            content.moveTextPositionByAmount(80,430);
            content.drawString("Expiration Date : ");
            content.endText();
            
            content.beginText();
            content.setFont(PDType1Font.HELVETICA_BOLD, 20);
            content.moveTextPositionByAmount(250,430);
            content.drawString(expirationDateToWrite);
            content.endText();
            
            content.beginText();
            content.setFont(PDType1Font.HELVETICA, 20);
            content.moveTextPositionByAmount(80,380);
            content.drawString("Total To Pay : ");
            content.endText();
            
            content.beginText();
            content.setFont(PDType1Font.HELVETICA_BOLD, 20);
            content.moveTextPositionByAmount(250,380);
            content.drawString("10000" + "€");
            content.endText();
            
            content.close();
            document.save(fileName);
            document.close();
            
            //System.out.println("your file created in : "+ System.getProperty("user.dir"));

        }
        catch(IOException e){
            System.err.println(e.getLocalizedMessage());
        }
        
    }
}
