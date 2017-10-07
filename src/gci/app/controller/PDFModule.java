package gci.app.controller;

import gci.app.model.CostModel;
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
    private static CostModel costModel;
    private static String fileName;
    
    protected static void setCustomerModel(CustomerModel cm) {
        customerModel = cm;
    }
    
    public static void setCostModel(CostModel cost) {
        costModel = cost;
    }
    
    protected static void setFilename(String fn){
        fileName = fn;
    }
    
    protected static String getFilename(){
        return fileName;
    }
    
    protected static void createPDF(Date date){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        
        final String name = customerModel.getName();
        final String surname = customerModel.getSurname();
        final String taxCode = customerModel.getTaxCode();
        final String homeAddress = customerModel.getHomeAddress();
        final String phone = customerModel.getPhone();
        
        dateFormat = new SimpleDateFormat("dd_MM_yyyy");
        
        Date expDate = DateUtils.addMonths(date, 3);
        
        
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
            content.moveTextPositionByAmount(200, 750);
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
            
            //Cost Calculation 
            final double shippingFees = costModel.getShippingFees();
            final double VAT = costModel.getVAT();
            final double waterRate = costModel.getWaterRate();
            final Double result = customerModel.getConsumption()
                                +(customerModel.getConsumption()* VAT/100)
                                + shippingFees + waterRate;
            // End Calculation
            
            content.beginText();
            content.setFont(PDType1Font.HELVETICA_BOLD, 20);
            content.moveTextPositionByAmount(250,380);
            content.drawString(result.toString()+ " €"); // TODO: Custom
            content.endText();
            
            content.close();
            document.save(fileName);
            document.close();
           
        }
        catch(IOException e){
            System.err.println(e.getLocalizedMessage());
        }
        
    }
}
