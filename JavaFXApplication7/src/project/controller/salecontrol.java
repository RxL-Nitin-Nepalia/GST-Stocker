package javafxapplication7;


import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.*;


public class salecontrol{
    

    private static final String EXCEL_FILE_LOCATION1 = "C:\\Users\\Nitins\\Desktop\\TaxInvoice1.xls";
       private static final String EXCEL_FILE_LOCATION = "C:\\Users\\Nitins\\Desktop\\TaxInvoice.xls"; 
    public void saleto() throws IOException, BiffException, SQLException, ClassNotFoundException, WriteException
    {
  
        WritableWorkbook myFirstWbook = null;
        Workbook wbook=null;
        wbook = Workbook.getWorkbook(new File(EXCEL_FILE_LOCATION1));
        myFirstWbook = Workbook.createWorkbook(new File(EXCEL_FILE_LOCATION),wbook);
    WritableSheet excelSheet = myFirstWbook.getSheet(0);
  int invoice,total,rate,quantity,discount,cgst,sgst,hsn=0,roundoff,igst,cess;
            String date,buyer,item=null,gstin=null,add=null,units=null;
             Class.forName("java.sql.Driver");  
            System.out.println("Driver loaded");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gst","root","root");
            System.out.println("Connection obtained1234567");
                          Statement stmt=conn.createStatement();
                          String query="select MAX(INVOICE) from sale";
                          ResultSet rs=stmt.executeQuery(query);
    while(rs.next())
    {
                           invoice=rs.getInt("INVOICE");
                           quantity=rs.getInt("QUANTITY");
                           rate=rs.getInt("RATE");
                           total=rs.getInt("TOTAL");
                           discount=rs.getInt("DISCOUNT");
                           date=rs.getString("DATE_");
                           buyer=rs.getString("BUYER");
                           item=rs.getString("ITEM");
                           roundoff=rs.getInt("ROUNDOFF");
                           cgst=rs.getInt("CGST");
                           sgst=rs.getInt("SGST");
                           igst=rs.getInt("IGST");
                           cess=rs.getInt("CESS");                          
                           System.out.println(invoice);
                         Statement stmt1=conn.createStatement();
                          String query1="select GSTIN, ADDRESS from LEDGER where NAME='"+buyer+"';";
                          ResultSet rs1=stmt1.executeQuery(query1);
                           
                          while(rs1.next())
                           {
                               gstin=rs1.getString("GSTIN");
                               add=rs1.getString("ADDRESS");
                           }
                           Statement stmt2=conn.createStatement();
                          String query2="select HSN from INVENTORY where STOCK='"+item+"';";
                          ResultSet rs2=stmt2.executeQuery(query2);
                           while(rs2.next())
                           {
                               hsn=rs2.getInt("HSN");
                               units=rs2.getString("UNITS");
                           }
        Label x2=new Label(9,4,date);
excelSheet.addCell(x2);
jxl.write.Number x3=new jxl.write.Number(6,4,invoice);
excelSheet.addCell(x3);
jxl.write.Number x4=new jxl.write.Number(4,19,hsn);
excelSheet.addCell(x4);
jxl.write.Number x5=new jxl.write.Number(5,19,quantity);
excelSheet.addCell(x5);
Label x6=new Label(1,19,item);
excelSheet.addCell(x6);
Label x7=new Label(7,19,units);
excelSheet.addCell(x7);
jxl.write.Number x8=new jxl.write.Number(9,19,total-cgst-igst-sgst-discount);
excelSheet.addCell(x8);
jxl.write.Number x9=new jxl.write.Number(8,21,discount);
excelSheet.addCell(x9);
jxl.write.Number x10=new jxl.write.Number(8,22,sgst);
excelSheet.addCell(x10);
jxl.write.Number x11=new jxl.write.Number(8,23,cgst);
excelSheet.addCell(x11);
jxl.write.Number x12=new jxl.write.Number(8,24,roundoff);
excelSheet.addCell(x12);
jxl.write.Number x13=new jxl.write.Number(8,25,total);
excelSheet.addCell(x13);
jxl.write.Number x14=new jxl.write.Number(2,30,hsn);
excelSheet.addCell(x14);
jxl.write.Number x15=new jxl.write.Number(4,30,total-cgst-sgst-cess-igst+discount);
excelSheet.addCell(x15);
jxl.write.Number x16=new jxl.write.Number(9,30,total);
excelSheet.addCell(x16);
Label x17=new Label(1,11,buyer);
excelSheet.addCell(x17);
Label x18=new Label(1,12,add);
excelSheet.addCell(x18);
Label x19=new Label(1,14,gstin);
excelSheet.addCell(x19);
    }
     myFirstWbook.write();
       
            if (myFirstWbook != null) {
                try {
                    myFirstWbook.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (WriteException e) {
                    e.printStackTrace();
                }
            }
           
stmt.close();
                           conn.close();
                          // Desktop.getDesktop().open(new File(EXCEL_FILE_LOCATION));
   }
    
}