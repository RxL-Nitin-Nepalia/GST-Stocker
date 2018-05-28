package javafxapplication7;


import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.*;
   public class gstcontrol{
     
    @FXML
   ComboBox month;
    
     @FXML
   ComboBox year;
      @FXML
    public void close(ActionEvent event) {
    System.exit(0);
    }
    @FXML
    public void mini(ActionEvent event){
        Stage stage=(Stage)((Button)event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }
   @FXML
    private JFXDrawer drawer;

    @FXML
    private JFXHamburger hamburger;
    
    @FXML
     AnchorPane r1;
    @FXML
    public AnchorPane rootP;
    @FXML
    VBox box;

    
    
   @FXML
    public void ham(MouseEvent e)
    { 
  
   
    if(drawer.isShown())
            {
                drawer.close();
                drawer.setPrefWidth(30);
            }else
    {
        drawer.setPrefWidth(180);
                drawer.open();
    
    }
    
    }
    
     @FXML
     public void setmonth()
     {
         month.getItems().clear();
         month.getItems().addAll("January","February","March","April","May","June","July","August","September","October","November","December"); 
         new ComboBoxAutoComplete(month);
     year.getItems().clear();
         year.getItems().addAll("2017-2018"); 
         
     
     }
    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML
    public void back(ActionEvent event) throws IOException
    {
     Node node=(Node) event.getSource();
     Stage stage=(Stage) node.getScene().getWindow();
     Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));/* Exception */
     Scene scene = new Scene(root);
     stage.setScene(scene);
     stage.show();
    
    }
    @FXML
    public void help(ActionEvent event) throws IOException
    {
     Node node=(Node) event.getSource();
     Stage stage=(Stage) node.getScene().getWindow();
     Parent root = FXMLLoader.load(getClass().getResource("help.fxml"));/* Exception */
     Scene scene = new Scene(root);
     stage.setScene(scene);
     stage.show();
    }
   
     private static final String EXCEL_FILE_LOCATION1 = "C:\\Users\\Nitins\\Desktop\\GSTR1f.xls";
       private static final String EXCEL_FILE_LOCATION = "C:\\Users\\Nitins\\Desktop\\GSTR1.xls"; 
       private static final String EXCEL_FILE_LOCATION2 = "C:\\Users\\Nitins\\Desktop\\GSTR2f.xls";
       private static final String EXCEL_FILE_LOCATION3 = "C:\\Users\\Nitins\\Desktop\\GSTR2.xls";
       private static final String EXCEL_FILE_LOCATION4 = "C:\\Users\\Nitins\\Desktop\\GSTR3Bf.xls";
       private static final String EXCEL_FILE_LOCATION5 = "C:\\Users\\Nitins\\Desktop\\GSTR3B.xls";
       
     @FXML
    public void gstr1(ActionEvent event) throws SQLException, ClassNotFoundException, IOException, BiffException, WriteException
    {    
     WritableWorkbook myFirstWbook = null;
        Workbook wbook=null;

       
        wbook = Workbook.getWorkbook(new File(EXCEL_FILE_LOCATION1));
        myFirstWbook = Workbook.createWorkbook(new File(EXCEL_FILE_LOCATION),wbook);
     

            WritableSheet excelSheet = myFirstWbook.getSheet(0);
        int m;
        int x,o,z,h,maxi,mini;
        if(month.getSelectionModel().getSelectedItem()==null){
        
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Please Select the month and year");
            alert.setHeaderText("Entries not filled");
            alert.showAndWait();
        }else{
        m=month.getSelectionModel().getSelectedIndex();
       m++;
       
       System.out.println(m);
       
       int invoice, cess, cgst, sgst, igst,roundoff, quantity, rate, total, hsn = 0, taxablevalue, discount;
                          String buyer, item, un = null,gstin = null, date, state = null;
       
       int y=2017;
       System.out.println(y);
       if(m<4)
       {
           y=2018;
       }
Label x2=new Label(6,1,"07AADFG1324J1ZP");
excelSheet.addCell(x2);
Label x3=new Label(6,2,"Tex Line Industries");
excelSheet.addCell(x3);
 int insertrow,i;
               
            Class.forName("java.sql.Driver");  
            System.out.println("Driver loaded");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gst","root","root");
            System.out.println("Connection obtained");
                          Statement stmt=conn.createStatement();
                          String query="select * from SALE where DATE_>='"+y+"-"+m+"-01' AND DATE_<='"+y+"-"+m+"-31';";
                          ResultSet rs=stmt.executeQuery(query);
                    int c=0,xd=0;
                          
                          while(rs.next())
                          {
                            
                           invoice=rs.getInt("INVOICE");
                           cess=rs.getInt("CESS");
                           cgst=rs.getInt("CGST");
                           sgst=rs.getInt("SGST");
                           igst=rs.getInt("IGST");
                           roundoff=rs.getInt("ROUNDOFF");
                           quantity=rs.getInt("QUANTITY");
                           rate=rs.getInt("RATE");
                           total=rs.getInt("TOTAL");
                           discount=rs.getInt("DISCOUNT");
                           date=rs.getString("DATE_");
                           buyer=rs.getString("BUYER");
                           item=rs.getString("ITEM");
                           
                           
                              
                          Statement stmt1=conn.createStatement();
                          String query1="select GSTIN, STATE from LEDGER where NAME='"+buyer+"';";
                          ResultSet rs1=stmt1.executeQuery(query1);
                           
                          while(rs1.next())
                           {
                               gstin=rs1.getString("GSTIN");
                               state=rs1.getString("STATE");
                           }
                           
                           
                             
                           
                           Statement stmt2=conn.createStatement();
                          String query2="select HSN from INVENTORY where STOCK='"+item+"';";
                          ResultSet rs2=stmt2.executeQuery(query2);
                           while(rs2.next())
                           {
                               hsn=rs2.getInt("HSN");
                           }
                           
                           
                             taxablevalue=total-cgst-sgst-cess-igst+discount;
                            
                             if(total<=250000){insertrow=13;
                             
                             
                             
                             
                                  excelSheet.insertRow(insertrow);
            Label l1=new Label(0,insertrow,gstin);
            
                excelSheet.addCell(l1);
                jxl.write.Number l2=new jxl.write.Number(1,insertrow,invoice);
            
                excelSheet.addCell(l2);
                        Label l3=new Label(2,insertrow,date);
            
                excelSheet.addCell(l3);
                        jxl.write.Number l4=new jxl.write.Number(3,insertrow,total);
                        excelSheet.addCell(l4);
            
               jxl.write.Number l5=new jxl.write.Number(4,insertrow,rate);
            
                excelSheet.addCell(l5);jxl.write.Number l6=new jxl.write.Number(5,insertrow,taxablevalue);
            
                excelSheet.addCell(l6);jxl.write.Number l7=new jxl.write.Number(6,insertrow,igst);
            
                excelSheet.addCell(l7);jxl.write.Number l8=new jxl.write.Number(8,insertrow,cgst);
            
                excelSheet.addCell(l8);
                jxl.write.Number l9=new jxl.write.Number(10,insertrow,sgst);
            
                excelSheet.addCell(l9);jxl.write.Number l10=new jxl.write.Number(12,insertrow,cess);
            
                excelSheet.addCell(l10);
               Label l11=new Label(14,insertrow,state);
            
                excelSheet.addCell(l11);
                              
 c++;    }
                             
            
                            
                          if(total>250000){insertrow=19+c;
                          excelSheet.insertRow(insertrow);
            Label l1=new Label(0,insertrow,state);
            
                excelSheet.addCell(l1);
                jxl.write.Number l2=new jxl.write.Number(2,insertrow,invoice);
            
                excelSheet.addCell(l2);
                        Label l3=new Label(3,insertrow,date);
            
                excelSheet.addCell(l3);
                        jxl.write.Number l4=new jxl.write.Number(4,insertrow,total);
                        excelSheet.addCell(l4);
            
               jxl.write.Number l5=new jxl.write.Number(5,insertrow,rate);
            
                excelSheet.addCell(l5);jxl.write.Number l6=new jxl.write.Number(6,insertrow,taxablevalue);
            
                excelSheet.addCell(l6);jxl.write.Number l7=new jxl.write.Number(7,insertrow,igst);
            
                excelSheet.addCell(l7);jxl.write.Number l10=new jxl.write.Number(9,insertrow,sgst);
                
            ;jxl.write.Number l8=new jxl.write.Number(11,insertrow,cgst);
                
            
                excelSheet.addCell(l8);;jxl.write.Number l9=new jxl.write.Number(13,insertrow,cess);
                
            
                excelSheet.addCell(l9);
                excelSheet.addCell(l10);
              
                xd++;
                          }
                          }
            Class.forName("java.sql.Driver");  
            System.out.println("Driver loaded");
           conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/gst","root","root");
            System.out.println("Connection obtained");
                          stmt=conn.createStatement();
                          query="select * from SALE where DATE_>='"+y+"-"+m+"-01' AND DATE_<='"+y+"-"+m+"-31';";
                          rs=stmt.executeQuery(query);
                    
                          x=0;
                          o=0;
                          while(rs.next())
                          {
                            
                        //   invoice=rs.getInt("INVOICE");
                           cess=rs.getInt("CESS");
                           cgst=rs.getInt("CGST");
                           sgst=rs.getInt("SGST");
                           igst=rs.getInt("IGST");
                           roundoff=rs.getInt("ROUNDOFF");
                         //  quantity=rs.getInt("QUANTITY");
                           rate=rs.getInt("RATE");
                           total=rs.getInt("TOTAL");
                           discount=rs.getInt("DISCOUNT");
                        //   date=rs.getString("DATE_");
                           buyer=rs.getString("BUYER");
                           item=rs.getString("ITEM");
                           
                       
                          Statement stmt1=conn.createStatement();
                          String query1="select GSTIN, STATE from LEDGER where NAME='"+buyer+"';";
                          ResultSet rs1=stmt1.executeQuery(query1);
                           
                          while(rs1.next())
                           {
                       //        gstin=rs1.getString("GSTIN");
                               state=rs1.getString("STATE");
                           }
                           
                           
                           
                           Statement stmt2=conn.createStatement();
                          String query2="select HSN from INVENTORY where STOCK='"+item+"';";
                          ResultSet rs2=stmt2.executeQuery(query2);
                           while(rs2.next())
                           {
                               hsn=rs2.getInt("HSN");
                           }
                           
                           
                             
                              
                             taxablevalue=total-cgst-sgst-cess-igst+discount;
                             System.out.println(total);
                 
                 if(cgst+sgst==0&&igst==0){
                     if(state.equals("Delhi"))
                     {
                         x+=total;
                        
                     }
                     else
                         o+=total;
                     
                 }
                 
                          }
                          System.out.println(x);
                          System.out.println(o);
                          
            jxl.write.Number l12=new jxl.write.Number(9,24+c+xd,o);
            
            
                excelSheet.addCell(l12);
                jxl.write.Number l13=new jxl.write.Number(9,25+c+xd,x);
            
            
                excelSheet.addCell(l13);
                jxl.write.Number l14=new jxl.write.Number(7,24+c+xd,0);
            
            
                excelSheet.addCell(l14);jxl.write.Number l15=new jxl.write.Number(7,25+c+xd,0);
            
            
                excelSheet.addCell(l15);jxl.write.Number l16=new jxl.write.Number(7,26+c+xd,0);
            
            
                excelSheet.addCell(l16);jxl.write.Number l17=new jxl.write.Number(7,27+c+xd,0);
            
            
                excelSheet.addCell(l17);jxl.write.Number l18=new jxl.write.Number(13,24+c+xd,0);
            
            
                excelSheet.addCell(l18);
                jxl.write.Number l19=new jxl.write.Number(13,25+xd+c,0);
            
            
                excelSheet.addCell(l19);jxl.write.Number l20=new jxl.write.Number(13,26+xd+c,0);
            
            
                excelSheet.addCell(l20);
                jxl.write.Number l21=new jxl.write.Number(13,27+c+xd,0);
            
            
                excelSheet.addCell(l21);
                jxl.write.Number l93=new jxl.write.Number(9,26+c+xd,0);
            
            
                excelSheet.addCell(l93);
                jxl.write.Number l94=new jxl.write.Number(9,27+c+xd,0);
            
            
                excelSheet.addCell(l94);
                
               
              

    int p=0;
   Class.forName("java.sql.Driver");  
            System.out.println("Driver loaded");
           conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/gst","root","root");
            System.out.println("Connection obtained");
                          stmt=conn.createStatement();
                          query="select SUM(CESS),SUM(CGST),SUM(SGST),SUM(IGST),ROUNDOFF,QUANTITY,TOTAL,DISCOUNT,ITEM  from SALE group by ITEM;";
                          
                          rs=stmt.executeQuery(query);
while(rs.next())
        {//invoice=rs.getInt("INVOICE");
                           cess=rs.getInt(1);
                           cgst=rs.getInt(2);
                           sgst=rs.getInt(3);
                           igst=rs.getInt(4);
                           roundoff=rs.getInt("ROUNDOFF");
                           quantity=rs.getInt("QUANTITY");
                      //     rate=rs.getInt("RATE");
                           total=rs.getInt("TOTAL");
                           discount=rs.getInt("DISCOUNT");
                       //    date=rs.getString("DATE_");
                     //      buyer=rs.getString("BUYER");
                           item=rs.getString("ITEM");
                           
                           
                           System.out.println(cess);System.out.println(cgst);System.out.println(sgst);System.out.println(igst);
                           
                           
                           
                           taxablevalue=total-cgst-sgst-cess-igst+discount;
                           
                           p++;
                           
                           int inser=34+c+xd;
                           
                           excelSheet.insertRow(inser);
                           
                            jxl.write.Number l27=new jxl.write.Number(6,inser,taxablevalue);
            
                excelSheet.addCell(l27);
                jxl.write.Number l28=new jxl.write.Number(8,inser,igst);
            
                excelSheet.addCell(l28);
                jxl.write.Number l29=new jxl.write.Number(9,inser,cgst);
            
                excelSheet.addCell(l29);
                jxl.write.Number l30=new jxl.write.Number(10,inser,sgst);
            
                excelSheet.addCell(l30);
                jxl.write.Number l31=new jxl.write.Number(11,inser,cess);                      
   excelSheet.addCell(l31);
    jxl.write.Number l32=new jxl.write.Number(5,inser,total);                      
   excelSheet.addCell(l32);
    jxl.write.Number l33=new jxl.write.Number(4,inser,quantity);                      
   excelSheet.addCell(l33);
  Statement stmt2=conn.createStatement();
                          String query2="select HSN,UNITS from INVENTORY where STOCK='"+item+"';";
                          ResultSet rs2=stmt2.executeQuery(query2);
                           while(rs2.next())
                           {
                               hsn=rs2.getInt("HSN");
                               un=rs2.getString("UNITS");
                           } 
                     jxl.write.Number l34=new jxl.write.Number(1,inser,hsn);                      
                    excelSheet.addCell(l34); 
                     Label l35=new Label(3,inser,un);
                    excelSheet.addCell(l35);
}


    
             Class.forName("java.sql.Driver");  
            System.out.println("Driver loaded");
           conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/gst","root","root");
            System.out.println("Connection obtained");
                          stmt=conn.createStatement();
                          query="select MAX(INVOICE) as mi, MIN(INVOICE) as mii from SALE;";
                          rs=stmt.executeQuery(query);
                    
                          
                          while(rs.next())
                          {
                           maxi=rs.getInt("mi");
                           mini=rs.getInt("mii");
                           jxl.write.Number l22=new jxl.write.Number(7,38+c+p+xd,maxi-mini+1);
            
            
                excelSheet.addCell(l22);
                 jxl.write.Number l23=new jxl.write.Number(5,38+p+c+xd,mini);
            
            
                excelSheet.addCell(l23); jxl.write.Number l24=new jxl.write.Number(6,38+p+c+xd,maxi);
            
            
                excelSheet.addCell(l24);
                 jxl.write.Number l25=new jxl.write.Number(8,38+p+c+xd,0);
            
            
                excelSheet.addCell(l25);
                jxl.write.Number l26=new jxl.write.Number(9,38+p+c+xd,maxi-mini+1);
            
            
                excelSheet.addCell(l26);
              
}         
Label l91=new Label(6,4,"3145266");                      
                    excelSheet.addCell(l91);
                          
                    jxl.write.Number l36=new jxl.write.Number(7,39+p+c+xd,0);                      
                    excelSheet.addCell(l36);jxl.write.Number l37=new jxl.write.Number(5,39+p+c+xd,0);                      
                    excelSheet.addCell(l37);jxl.write.Number l38=new jxl.write.Number(5,40+p+c+xd,0);                      
                    excelSheet.addCell(l38);jxl.write.Number l39=new jxl.write.Number(5,41+p+c+xd,0);                      
                    excelSheet.addCell(l39);jxl.write.Number l40=new jxl.write.Number(5,42+p+c+xd,0);                      
                    excelSheet.addCell(l40);jxl.write.Number l41=new jxl.write.Number(5,43+p+c+xd,0);                      
                    excelSheet.addCell(l41);jxl.write.Number l42=new jxl.write.Number(5,44+p+c+xd,0);                      
                    excelSheet.addCell(l42);jxl.write.Number l43=new jxl.write.Number(5,45+p+c+xd,0);                      
                    excelSheet.addCell(l43);jxl.write.Number l44=new jxl.write.Number(5,46+p+c+xd,0);                      
                    excelSheet.addCell(l44);jxl.write.Number l45=new jxl.write.Number(5,47+p+c+xd,0);                      
                    excelSheet.addCell(l45);jxl.write.Number l46=new jxl.write.Number(5,48+p+c+xd,0);                      
                    excelSheet.addCell(l46);jxl.write.Number l47=new jxl.write.Number(5,49+p+c+xd,0);                      
                    excelSheet.addCell(l47);jxl.write.Number l48=new jxl.write.Number(6,39+p+c+xd,0);                      
                    excelSheet.addCell(l48);jxl.write.Number l49=new jxl.write.Number(6,40+p+c+xd,0);                      
                    excelSheet.addCell(l49);jxl.write.Number l50=new jxl.write.Number(6,41+p+c+xd,0);                      
                    excelSheet.addCell(l50);jxl.write.Number l51=new jxl.write.Number(6,42+p+c+xd,0);                      
                    excelSheet.addCell(l51);jxl.write.Number l52=new jxl.write.Number(6,43+p+c+xd,0);                      
                    excelSheet.addCell(l52);jxl.write.Number l53=new jxl.write.Number(6,44+p+c+xd,0);                      
                    excelSheet.addCell(l53);jxl.write.Number l54=new jxl.write.Number(6,45+p+c+xd,0);                      
                    excelSheet.addCell(l54);jxl.write.Number l55=new jxl.write.Number(6,46+p+c+xd,0);                      
                    excelSheet.addCell(l55);jxl.write.Number l56=new jxl.write.Number(6,47+p+c+xd,0);                      
                    excelSheet.addCell(l56);jxl.write.Number l57=new jxl.write.Number(6,48+p+c+xd,0);                      
                    excelSheet.addCell(l57);jxl.write.Number l58=new jxl.write.Number(6,49+p+c+xd,0);                      
                    excelSheet.addCell(l58);jxl.write.Number l59=new jxl.write.Number(7,40+p+c+xd,0);                      
                    excelSheet.addCell(l59);jxl.write.Number l60=new jxl.write.Number(7,41+p+c+xd,0);                      
                    excelSheet.addCell(l60);jxl.write.Number l61=new jxl.write.Number(7,42+p+c+xd,0);                      
                    excelSheet.addCell(l61);jxl.write.Number l62=new jxl.write.Number(7,43+p+c+xd,0);                      
                    excelSheet.addCell(l62);jxl.write.Number l63=new jxl.write.Number(7,44+p+c+xd,0);                      
                    excelSheet.addCell(l63);jxl.write.Number l64=new jxl.write.Number(7,45+p+c+xd,0);                      
                    excelSheet.addCell(l64);jxl.write.Number l65=new jxl.write.Number(7,46+p+c+xd,0);                      
                    excelSheet.addCell(l65);jxl.write.Number l66=new jxl.write.Number(7,47+p+c+xd,0);                      
                    excelSheet.addCell(l66);jxl.write.Number l67=new jxl.write.Number(7,48+p+c+xd,0);                      
                    excelSheet.addCell(l67);jxl.write.Number l68=new jxl.write.Number(7,49+p+c+xd,0);                      
                    excelSheet.addCell(l68);jxl.write.Number l69=new jxl.write.Number(8,39+p+c+xd,0);                      
                    excelSheet.addCell(l69);jxl.write.Number l70=new jxl.write.Number(8,40+p+c+xd,0);                      
                    excelSheet.addCell(l70);jxl.write.Number l71=new jxl.write.Number(8,41+p+c+xd,0);                      
                    excelSheet.addCell(l71);jxl.write.Number l72=new jxl.write.Number(8,42+p+c+xd,0);                      
                    excelSheet.addCell(l72);jxl.write.Number l73=new jxl.write.Number(8,43+p+c+xd,0);                      
                    excelSheet.addCell(l73);jxl.write.Number l74=new jxl.write.Number(8,44+p+c+xd,0);                      
                    excelSheet.addCell(l74);jxl.write.Number l75=new jxl.write.Number(8,45+p+c+xd,0);                      
                    excelSheet.addCell(l75);jxl.write.Number l76=new jxl.write.Number(8,46+p+c+xd,0);                      
                    excelSheet.addCell(l76);jxl.write.Number l77=new jxl.write.Number(8,47+p+c+xd,0);                      
                    excelSheet.addCell(l77);jxl.write.Number l78=new jxl.write.Number(8,48+p+c+xd,0);                      
                    excelSheet.addCell(l78);jxl.write.Number l79=new jxl.write.Number(8,49+p+c+xd,0);                      
                    excelSheet.addCell(l79);jxl.write.Number l80=new jxl.write.Number(9,39+p+c+xd,0);                      
                    excelSheet.addCell(l80);jxl.write.Number l81=new jxl.write.Number(9,40+p+c+xd,0);                      
                    excelSheet.addCell(l81);jxl.write.Number l82=new jxl.write.Number(9,41+p+c+xd,0);                      
                    excelSheet.addCell(l82);jxl.write.Number l83=new jxl.write.Number(9,42+p+c+xd,0);                      
                    excelSheet.addCell(l83);jxl.write.Number l84=new jxl.write.Number(9,43+p+c+xd,0);                      
                    excelSheet.addCell(l84);jxl.write.Number l85=new jxl.write.Number(9,44+p+c+xd,0);                      
                    excelSheet.addCell(l85);jxl.write.Number l86=new jxl.write.Number(9,45+p+c+xd,0);                      
                    excelSheet.addCell(l86);jxl.write.Number l87=new jxl.write.Number(9,46+p+c+xd,0);                      
                    excelSheet.addCell(l87);jxl.write.Number l88=new jxl.write.Number(9,47+p+c+xd,0);                      
                    excelSheet.addCell(l88);jxl.write.Number l89=new jxl.write.Number(9,48+p+c+xd,0);                      
                    excelSheet.addCell(l89);jxl.write.Number l90=new jxl.write.Number(9,49+p+c+xd,0);                      
                    excelSheet.addCell(l90);
             
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
                           Desktop.getDesktop().open(new File(EXCEL_FILE_LOCATION));
        }}
   
                      
                          
          

      

        


        
        
 
    
    
    
     @FXML
    public void gstr2(ActionEvent event) throws SQLException, ClassNotFoundException, IOException, BiffException, WriteException
    {
      WritableWorkbook myFirstWbook = null;
        Workbook wbook=null;

       
        wbook = Workbook.getWorkbook(new File(EXCEL_FILE_LOCATION2));
        myFirstWbook = Workbook.createWorkbook(new File(EXCEL_FILE_LOCATION3),wbook);
     

            WritableSheet excelSheet = myFirstWbook.getSheet(0);
             int m;
        int x,o,z,h,maxi,mini;  if(month.getSelectionModel().getSelectedItem()==null){
        
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Please Select the month and year");
            alert.setHeaderText("Entries not filled");
            alert.showAndWait();
        }else{
        m=month.getSelectionModel().getSelectedIndex();
       m++;
       String kk=(String) month.getSelectionModel().getSelectedItem();
       System.out.println(m);
       
       int invoice, cess, cgst, sgst, igst,roundoff, quantity, rate, total, hsn = 0, taxablevalue, discount;
                          String seller, item, un = null,gstin = null, date, state = null;
       
       int y=2017;
       System.out.println(y);
       if(m<4)
       {
           y=2018;
       }
       jxl.write.Number x5=new jxl.write.Number(7,3,y);
       excelSheet.addCell(x5);
       Label x6=new Label(7,4,kk);
       excelSheet.addCell(x6);
Label x2=new Label(6,6,"07AADFG1324J1ZP");
excelSheet.addCell(x2);
Label x3=new Label(6,7,"Tex Line Industries");
excelSheet.addCell(x3);

            Class.forName("java.sql.Driver");  
            System.out.println("Driver loaded");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gst","root","root");
            System.out.println("Connection obtained");
                          Statement stmt=conn.createStatement();
                          String query="select * from PURCHASE where DATE_>='"+y+"-"+m+"-01' AND DATE_<='"+y+"-"+m+"-31';";
                          ResultSet rs=stmt.executeQuery(query);
                    int rr=0,ff=0,kt=0,ct=0,c=0;
                          x=0;
                          o=0;
                          while(rs.next())
                          {
                            
                           invoice=rs.getInt("INVOICE");
                           cess=rs.getInt("CESS");
                           cgst=rs.getInt("CGST");
                           sgst=rs.getInt("SGST");
                           igst=rs.getInt("IGST");
                           roundoff=rs.getInt("ROUNDOFF");
                           quantity=rs.getInt("QUANTITY");
                           rate=rs.getInt("RATE");
                           total=rs.getInt("TOTAL");
                           discount=rs.getInt("DISCOUNT");
                           date=rs.getString("DATE_");
                           seller=rs.getString("SELLER");
                           item=rs.getString("ITEM");
                           
                           
                              
                          Statement stmt1=conn.createStatement();
                          String query1="select GSTIN, STATE from LEDGER where NAME='"+seller+"';";
                          ResultSet rs1=stmt1.executeQuery(query1);
                           
                          while(rs1.next())
                           {
                               gstin=rs1.getString("GSTIN");
                               state=rs1.getString("STATE");
                           }
                             
                 if(cgst+sgst==0&&igst==0){
                     if(state.equals("Delhi"))
                     {
                         x+=total;
                        
                     }
                     else
                         o+=total;
                     
                 }
                 
                           
                             
                           
                           Statement stmt2=conn.createStatement();
                          String query2="select HSN from INVENTORY where STOCK='"+item+"';";
                          ResultSet rs2=stmt2.executeQuery(query2);
                           while(rs2.next())
                           {
                               hsn=rs2.getInt("HSN");
                           }
                           
                           
                             taxablevalue=total-cgst-sgst-cess-igst+discount;
                             int insertrow,i;
                             insertrow=19;
                             
                             
                             
                                  excelSheet.insertRow(insertrow);
            Label l1=new Label(0,insertrow,gstin);
            
                excelSheet.addCell(l1);
                jxl.write.Number l2=new jxl.write.Number(1,insertrow,invoice);
            
                excelSheet.addCell(l2);
                        Label l3=new Label(2,insertrow,date);
            
                excelSheet.addCell(l3);
                        jxl.write.Number l4=new jxl.write.Number(3,insertrow,total);
                        excelSheet.addCell(l4);
            
               jxl.write.Number l5=new jxl.write.Number(4,insertrow,rate);
            
                excelSheet.addCell(l5);jxl.write.Number l6=new jxl.write.Number(5,insertrow,taxablevalue);
            
                excelSheet.addCell(l6);jxl.write.Number l7=new jxl.write.Number(6,insertrow,igst);
            
                excelSheet.addCell(l7);jxl.write.Number l8=new jxl.write.Number(7,insertrow,cgst);
            
                excelSheet.addCell(l8);
                jxl.write.Number l9=new jxl.write.Number(8,insertrow,sgst);
            
                excelSheet.addCell(l9);jxl.write.Number l10=new jxl.write.Number(9,insertrow,cess);
            
                excelSheet.addCell(l10);
               Label l11=new Label(10,insertrow,state);
            
                excelSheet.addCell(l11);
                             Label l112=new Label(11,insertrow,"NO");
            
                excelSheet.addCell(l112);
                jxl.write.Number l113=new jxl.write.Number(12,insertrow,igst);
            
                excelSheet.addCell(l113);jxl.write.Number l114=new jxl.write.Number(13,insertrow,cgst);
            
                excelSheet.addCell(l114);
                jxl.write.Number l115=new jxl.write.Number(14,insertrow,sgst);
            
                excelSheet.addCell(l115);jxl.write.Number l116=new jxl.write.Number(15,insertrow,cess);
            
                excelSheet.addCell(l116);
                rr+=igst;
                ff+=cgst;
                kt+=sgst;
                ct+=cess;
                c++;
                
                             
                          } 
                          System.out.println(rr);
                           jxl.write.Number l120=new jxl.write.Number(7,35+c,rr);
            
                excelSheet.addCell(l120);jxl.write.Number l121=new jxl.write.Number(8,35+c,ff);
            
                excelSheet.addCell(l121);jxl.write.Number l122=new jxl.write.Number(9,35+c,kt);
            
                excelSheet.addCell(l122);jxl.write.Number l123=new jxl.write.Number(10,35+c,ct);
            
                excelSheet.addCell(l123);jxl.write.Number l124=new jxl.write.Number(7,36+c,0);
            
                excelSheet.addCell(l124);jxl.write.Number l125=new jxl.write.Number(8,36+c,0);
            
                excelSheet.addCell(l125);jxl.write.Number l126=new jxl.write.Number(10,36+c,0);
            
                excelSheet.addCell(l126); jxl.write.Number l127=new jxl.write.Number(9,36+c,0);
            
                excelSheet.addCell(l127);jxl.write.Number l128=new jxl.write.Number(7,37+c,0);
            
                excelSheet.addCell(l128);jxl.write.Number l129=new jxl.write.Number(9,37+c,0);
            
                excelSheet.addCell(l129);jxl.write.Number l130=new jxl.write.Number(10,37+c,0);
            
                excelSheet.addCell(l130);jxl.write.Number l131=new jxl.write.Number(8,37+c,0);
            
                excelSheet.addCell(l131);jxl.write.Number l132=new jxl.write.Number(7,38+c,0);
            
                excelSheet.addCell(l132);jxl.write.Number l133=new jxl.write.Number(9,38+c,0);
            
                excelSheet.addCell(l133);jxl.write.Number l134=new jxl.write.Number(10,38+c,0);
            
                excelSheet.addCell(l134);jxl.write.Number l135=new jxl.write.Number(8,38+c,0);
            
                excelSheet.addCell(l135);jxl.write.Number l136=new jxl.write.Number(7,39+c,0);
            
                excelSheet.addCell(l136);jxl.write.Number l137=new jxl.write.Number(9,39+c,0);
            
                excelSheet.addCell(l137);jxl.write.Number l138=new jxl.write.Number(10,39+c,0);
            
                excelSheet.addCell(l138);jxl.write.Number l139=new jxl.write.Number(8,39+c,0);
            
                excelSheet.addCell(l139);jxl.write.Number l140=new jxl.write.Number(9,40+c,0);
            
                excelSheet.addCell(l140);jxl.write.Number l141=new jxl.write.Number(8,40+c,0);
            
                excelSheet.addCell(l141);jxl.write.Number l142=new jxl.write.Number(10,40+c,0);
            
                excelSheet.addCell(l142);jxl.write.Number l143=new jxl.write.Number(7,40+c,0);
            
                excelSheet.addCell(l143);jxl.write.Number l144=new jxl.write.Number(9,41+c,0);
            
                excelSheet.addCell(l144);jxl.write.Number l145=new jxl.write.Number(8,41+c,0);
            
                excelSheet.addCell(l145);jxl.write.Number l146=new jxl.write.Number(10,41+c,0);
            
                excelSheet.addCell(l146);jxl.write.Number l147=new jxl.write.Number(7,41+c,0);
            
                excelSheet.addCell(l147);jxl.write.Number l148=new jxl.write.Number(9,42+c,0);
            
                excelSheet.addCell(l148);jxl.write.Number l149=new jxl.write.Number(10,42+c,0);
            
                excelSheet.addCell(l149);jxl.write.Number l150=new jxl.write.Number(8,42+c,0);
            
                excelSheet.addCell(l150);jxl.write.Number l151=new jxl.write.Number(7,42+c,0);
            
                excelSheet.addCell(l151);
                              
                             
            
 int p=0;
                          Class.forName("java.sql.Driver");  
            System.out.println("Driver loaded");
           conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/gst","root","root");
            System.out.println("Connection obtained");
                          stmt=conn.createStatement();
                          query="select * from PURCHASE group by ITEM;";
                          rs=stmt.executeQuery(query);
while(rs.next())
        {//invoice=rs.getInt("INVOICE");
                           cess=rs.getInt("CESS");
                           cgst=rs.getInt("CGST");
                           sgst=rs.getInt("SGST");
                           igst=rs.getInt("IGST");
                           roundoff=rs.getInt("ROUNDOFF");
                           quantity=rs.getInt("QUANTITY");
                      //     rate=rs.getInt("RATE");
                           total=rs.getInt("TOTAL");
                           discount=rs.getInt("DISCOUNT");
                       //    date=rs.getString("DATE_");
                     //      buyer=rs.getString("BUYER");
                           item=rs.getString("ITEM");
                           
                           
                           
                           taxablevalue=total-cgst-sgst-cess-igst+discount;
                           p++;
                           
                           
                           int inser=50+c;
                           
                           excelSheet.insertRow(inser);
                           
                            jxl.write.Number l27=new jxl.write.Number(6,inser,taxablevalue);
            
                excelSheet.addCell(l27);
                jxl.write.Number l28=new jxl.write.Number(7,inser,igst);
            
                excelSheet.addCell(l28);
                jxl.write.Number l29=new jxl.write.Number(8,inser,cgst);
            
                excelSheet.addCell(l29);
                jxl.write.Number l30=new jxl.write.Number(9,inser,sgst);
            
                excelSheet.addCell(l30);
                jxl.write.Number l31=new jxl.write.Number(10,inser,cess);                      
   excelSheet.addCell(l31);
    jxl.write.Number l32=new jxl.write.Number(5,inser,total);                      
   excelSheet.addCell(l32);
    jxl.write.Number l33=new jxl.write.Number(4,inser,quantity);                      
   excelSheet.addCell(l33);
  Statement stmt2=conn.createStatement();
                          String query2="select HSN,UNITS from INVENTORY where STOCK='"+item+"';";
                          ResultSet rs2=stmt2.executeQuery(query2);
                           while(rs2.next())
                           {
                               hsn=rs2.getInt("HSN");
                               un=rs2.getString("UNITS");
                           } 
                     jxl.write.Number l34=new jxl.write.Number(1,inser,hsn);                      
                    excelSheet.addCell(l34); 
                     Label l35=new Label(2,inser,un);
                    excelSheet.addCell(l35);
                    jxl.write.Number l100=new jxl.write.Number(0,inser,p);
                    excelSheet.addCell(l100);
        }
jxl.write.Number l101=new jxl.write.Number(4,25+c,x);
excelSheet.addCell(l101);
jxl.write.Number l102=new jxl.write.Number(4,26+c,o);
excelSheet.addCell(l102);
jxl.write.Number l103=new jxl.write.Number(2,25+c,0);
excelSheet.addCell(l103);
jxl.write.Number l104=new jxl.write.Number(2,26+c,0);
excelSheet.addCell(l104);jxl.write.Number l105=new jxl.write.Number(5,25+c,0);
excelSheet.addCell(l105);
jxl.write.Number l106=new jxl.write.Number(6,26+c,0);
excelSheet.addCell(l106);jxl.write.Number l107=new jxl.write.Number(6,25+c,0);
excelSheet.addCell(l107);
jxl.write.Number l108=new jxl.write.Number(8,26+c,0);
excelSheet.addCell(l108);jxl.write.Number l109=new jxl.write.Number(8,25+c,0);
excelSheet.addCell(l109);


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
                           Desktop.getDesktop().open(new File(EXCEL_FILE_LOCATION3));
    }
    
    }   
    
    
    
    
     @FXML
    public void gstr3b() throws BiffException, IOException, WriteException, ClassNotFoundException, SQLException
    {
       WritableWorkbook myFirstWbook = null;
        Workbook wbook=null;

       
        wbook = Workbook.getWorkbook(new File(EXCEL_FILE_LOCATION4));
        myFirstWbook = Workbook.createWorkbook(new File(EXCEL_FILE_LOCATION5),wbook);
     

            WritableSheet excelSheet = myFirstWbook.getSheet(0);
             int m;
        int x,o;
        m=month.getSelectionModel().getSelectedIndex();
       m++; if(month.getSelectionModel().getSelectedItem()==null){
        
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Please Select the month and year");
            alert.setHeaderText("Entries not filled");
            alert.showAndWait();
        }else{
       String kk=(String) month.getSelectionModel().getSelectedItem();
       System.out.println(m);
       
       int invoice, cess, cgst, sgst, igst,roundoff, quantity, rate, total, hsn = 0, taxablevalue, discount;
                          String seller, item, un = null,gstin = null, date, state = null;
       
       int y=2017;
       System.out.println(y);
       if(m<4)
       {
           y=2018;
       }
       jxl.write.Number x5=new jxl.write.Number(3,2,y);
       excelSheet.addCell(x5);
       Label x6=new Label(3,3,kk);
       excelSheet.addCell(x6);
Label x2=new Label(6,5,"07AADFG1324J1ZP");
excelSheet.addCell(x2);
Label x3=new Label(6,6,"Tex Line Industries");
excelSheet.addCell(x3);

            Class.forName("java.sql.Driver");  
            System.out.println("Driver loaded");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gst","root","root");
            System.out.println("Connection obtained");
                          Statement stmt=conn.createStatement();
                          String query="select * from SALE where DATE_>='"+y+"-"+m+"-01' AND DATE_<='"+y+"-"+m+"-31';";
                          ResultSet rs=stmt.executeQuery(query);
                    int is=0,ss=0,cs=0,css=0;
                          x=0;
                          o=0;
                          while(rs.next())
                          {
                            
                           invoice=rs.getInt("INVOICE");
                           cess=rs.getInt("CESS");
                           cgst=rs.getInt("CGST");
                           sgst=rs.getInt("SGST");
                           igst=rs.getInt("IGST");
                           roundoff=rs.getInt("ROUNDOFF");
                           quantity=rs.getInt("QUANTITY");
                           rate=rs.getInt("RATE");
                           total=rs.getInt("TOTAL");
                           discount=rs.getInt("DISCOUNT");
                           date=rs.getString("DATE_");
                           seller=rs.getString("BUYER");
                           item=rs.getString("ITEM");
                           
                 
                           
                             taxablevalue=total-cgst-sgst-cess-igst+discount;
                             if(cgst==0&&igst==0&&sgst==0&&cess==0)
                             {
                                 x+=taxablevalue;
                             }
                             else 
                             { o+=taxablevalue;
                             is+=igst;
                             ss+=sgst;
                             cs+=cgst;
                             css+=cess;
                             }
                             
    }
    jxl.write.Number tt=new jxl.write.Number(7,12,o);
                             excelSheet.addCell(tt);
                             jxl.write.Number ti=new jxl.write.Number(8,12,is);
                             excelSheet.addCell(ti);
                             jxl.write.Number ts=new jxl.write.Number(9,12,ss);
                             excelSheet.addCell(ts);
                             jxl.write.Number tc=new jxl.write.Number(10,12,is);
                             excelSheet.addCell(tc);
                             jxl.write.Number tcs=new jxl.write.Number(11,12,is);
                             excelSheet.addCell(tcs);
    jxl.write.Number ntt=new jxl.write.Number(7,13,x);
                             excelSheet.addCell(ntt);
                             jxl.write.Number x1=new jxl.write.Number(8,13,0);
                             excelSheet.addCell(x1);jxl.write.Number x14=new jxl.write.Number(9,13,0);
                             excelSheet.addCell(x14);jxl.write.Number x13=new jxl.write.Number(10,13,0);
                             excelSheet.addCell(x13);jxl.write.Number x4=new jxl.write.Number(11,13,0);
                             excelSheet.addCell(x4);jxl.write.Number x15=new jxl.write.Number(7,14,0);
                             excelSheet.addCell(x15);jxl.write.Number x16=new jxl.write.Number(8,14,0);
                             excelSheet.addCell(x16);jxl.write.Number x7=new jxl.write.Number(9,14,0);
                             excelSheet.addCell(x7);jxl.write.Number x8=new jxl.write.Number(10,14,0);
                             excelSheet.addCell(x8);jxl.write.Number x9=new jxl.write.Number(11,14,0);
                             excelSheet.addCell(x9);jxl.write.Number x10=new jxl.write.Number(7,15,0);
                             excelSheet.addCell(x10);jxl.write.Number x11=new jxl.write.Number(8,15,0);
                             excelSheet.addCell(x11);jxl.write.Number x12=new jxl.write.Number(9,15,0);
                             excelSheet.addCell(x12);jxl.write.Number x17=new jxl.write.Number(10,15,0);
                             excelSheet.addCell(x17);jxl.write.Number x18=new jxl.write.Number(11,15,0);
                             excelSheet.addCell(x18);jxl.write.Number x19=new jxl.write.Number(11,15,0);
                          
                              excelSheet.addCell(x19);jxl.write.Number x20=new jxl.write.Number(7,16,0);
                             excelSheet.addCell(x20);jxl.write.Number x21=new jxl.write.Number(8,16,0);
                             excelSheet.addCell(x21);jxl.write.Number x22=new jxl.write.Number(9,16,0);
                             excelSheet.addCell(x22);jxl.write.Number x23=new jxl.write.Number(10,16,0);
                             excelSheet.addCell(x23);jxl.write.Number x24=new jxl.write.Number(11,16,0);
                             excelSheet.addCell(x24);
                             
             String name=null;  
             float aa;
             float bb;
                             Class.forName("java.sql.Driver");  
            System.out.println("Driver loaded");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gst","root","root");
            System.out.println("Connection obtained");
                          stmt=conn.createStatement();
                          
                          query="select * from LEDGER;"; 
                          ResultSet rs1=stmt.executeQuery(query);
                           aa=0;
                           bb=0;
                          while(rs1.next())
                           {
                               gstin=rs1.getString("GSTIN");
                               
                               
                           if(gstin.equals(null))
                           {name=rs1.getString("NAME");
                               state=rs1.getString("STATE");
                               Statement stmt2=conn.createStatement();
                          String query2="select * from sale where BUYER='"+name+"';";
                          ResultSet rs2=stmt2.executeQuery(query2);
                           while(rs2.next())
                           {
                               invoice=rs2.getInt("INVOICE");
                           cess=rs2.getInt("CESS");
                           cgst=rs2.getInt("CGST");
                           sgst=rs2.getInt("SGST");
                           igst=rs2.getInt("IGST");
                           roundoff=rs2.getInt("ROUNDOFF");
                           quantity=rs2.getInt("QUANTITY");
                           rate=rs2.getInt("RATE");
                           total=rs2.getInt("TOTAL");
                           discount=rs2.getInt("DISCOUNT");
                           date=rs2.getString("DATE_");
                           seller=rs2.getString("BUYER");
                           item=rs2.getString("ITEM");
                            taxablevalue=total-igst-cgst-sgst-cess+discount;
                            aa+=taxablevalue;
                            bb+=igst;
                           }
                             
                               
                           }
                           jxl.write.Label x25=new jxl.write.Label(4,22,state);
                             excelSheet.addCell(x25);jxl.write.Number x26=new jxl.write.Number(6,22,aa);
                             excelSheet.addCell(x26);jxl.write.Number x27=new jxl.write.Number(8,22,bb);
                             excelSheet.addCell(x27);jxl.write.Number x28=new jxl.write.Number(4,23,0);
                             excelSheet.addCell(x28);jxl.write.Number x29=new jxl.write.Number(6,23,0);
                             excelSheet.addCell(x29);jxl.write.Number x30=new jxl.write.Number(8,23,0);
                             excelSheet.addCell(x30);jxl.write.Number x31=new jxl.write.Number(8,24,0);
                             excelSheet.addCell(x31);jxl.write.Number x32=new jxl.write.Number(4,24,0);
                             excelSheet.addCell(x32);jxl.write.Number x33=new jxl.write.Number(6,24,0);
                             excelSheet.addCell(x33);
                             
                           
                           
                           
                           }
                          Statement stmt2=conn.createStatement();
                          String query2="SELECT SUM(IGST),SUM(SGST),SUM(CGST),SUM(CESS) FROM purchase;";
                          ResultSet rs2=stmt2.executeQuery(query2);
                           while(rs2.next())
                           {
                             jxl.write.Number x30=new jxl.write.Number(4,31,(rs2.getInt(1)));
                             excelSheet.addCell(x30);jxl.write.Number x31=new jxl.write.Number(6,31,(rs2.getInt(3)));
                             excelSheet.addCell(x31);jxl.write.Number x32=new jxl.write.Number(7,31,(rs2.getInt(2)));
                             excelSheet.addCell(x32);jxl.write.Number x33=new jxl.write.Number(8,31,(rs2.getInt(4)));
                             excelSheet.addCell(x33);
                             
                              
                           }
                   jxl.write.Number l36=new jxl.write.Number(7,33,0);                      
                    excelSheet.addCell(l36);jxl.write.Number l37=new jxl.write.Number(4,32,0);                      
                    excelSheet.addCell(l37);jxl.write.Number l38=new jxl.write.Number(4,33,0);                      
                    excelSheet.addCell(l38);jxl.write.Number l39=new jxl.write.Number(4,33,0);                      
                    excelSheet.addCell(l39);jxl.write.Number l40=new jxl.write.Number(4,34,0);                      
                    excelSheet.addCell(l40);jxl.write.Number l41=new jxl.write.Number(4,35,0);                      
                    excelSheet.addCell(l41);jxl.write.Number l42=new jxl.write.Number(4,36,0);                      
                    excelSheet.addCell(l42);jxl.write.Number l43=new jxl.write.Number(4,37,0);                      
                    excelSheet.addCell(l43);jxl.write.Number l44=new jxl.write.Number(4,38,0);                      
                    excelSheet.addCell(l44);jxl.write.Number l45=new jxl.write.Number(4,39,0);                      
                    excelSheet.addCell(l45);jxl.write.Number l46=new jxl.write.Number(4,40,0);                      
                    excelSheet.addCell(l46);jxl.write.Number l47=new jxl.write.Number(4,41,0);                      
                    excelSheet.addCell(l47);jxl.write.Number l48=new jxl.write.Number(6,32,0);                      
                    excelSheet.addCell(l48);jxl.write.Number l49=new jxl.write.Number(6,33,0);                      
                    excelSheet.addCell(l49);jxl.write.Number l50=new jxl.write.Number(6,34,0);                      
                    excelSheet.addCell(l50);jxl.write.Number l51=new jxl.write.Number(6,35,0);                      
                    excelSheet.addCell(l51);jxl.write.Number l52=new jxl.write.Number(6,36,0);                      
                    excelSheet.addCell(l52);jxl.write.Number l53=new jxl.write.Number(6,37,0);                      
                    excelSheet.addCell(l53);jxl.write.Number l54=new jxl.write.Number(6,38,0);                      
                    excelSheet.addCell(l54);jxl.write.Number l55=new jxl.write.Number(6,39,0);                      
                    excelSheet.addCell(l55);jxl.write.Number l56=new jxl.write.Number(6,40,0);                      
                    excelSheet.addCell(l56);jxl.write.Number l57=new jxl.write.Number(6,41,0);                      
                    excelSheet.addCell(l57);jxl.write.Number l58=new jxl.write.Number(6,42,0);                      
                    excelSheet.addCell(l58);jxl.write.Number l59=new jxl.write.Number(7,32,0);                      
                    excelSheet.addCell(l59);jxl.write.Number l60=new jxl.write.Number(7,42,0);                      
                    excelSheet.addCell(l60);jxl.write.Number l61=new jxl.write.Number(7,41,0);                      
                    excelSheet.addCell(l61);jxl.write.Number l62=new jxl.write.Number(7,40,0);                      
                    excelSheet.addCell(l62);jxl.write.Number l63=new jxl.write.Number(7,39,0);                      
                    excelSheet.addCell(l63);jxl.write.Number l64=new jxl.write.Number(7,38,0);                      
                    excelSheet.addCell(l64);jxl.write.Number l65=new jxl.write.Number(7,37,0);                      
                    excelSheet.addCell(l65);jxl.write.Number l66=new jxl.write.Number(7,36,0);                      
                    excelSheet.addCell(l66);jxl.write.Number l67=new jxl.write.Number(7,35,0);                      
                    excelSheet.addCell(l67);jxl.write.Number l68=new jxl.write.Number(7,34,0);                      
                    excelSheet.addCell(l68);jxl.write.Number l69=new jxl.write.Number(8,32,0);                      
                    excelSheet.addCell(l69);jxl.write.Number l70=new jxl.write.Number(8,33,0);                      
                    excelSheet.addCell(l70);jxl.write.Number l71=new jxl.write.Number(8,41,0);                      
                    excelSheet.addCell(l71);jxl.write.Number l72=new jxl.write.Number(8,42,0);                      
                    excelSheet.addCell(l72);jxl.write.Number l73=new jxl.write.Number(8,40,0);                      
                    excelSheet.addCell(l73);jxl.write.Number l74=new jxl.write.Number(8,39,0);                      
                    excelSheet.addCell(l74);jxl.write.Number l75=new jxl.write.Number(8,38,0);                      
                    excelSheet.addCell(l75);jxl.write.Number l76=new jxl.write.Number(8,37,0);                      
                    excelSheet.addCell(l76);jxl.write.Number l77=new jxl.write.Number(8,36,0);                      
                    excelSheet.addCell(l77);jxl.write.Number l78=new jxl.write.Number(8,35,0);                      
                    excelSheet.addCell(l78);jxl.write.Number l79=new jxl.write.Number(8,34,0);                      
                    excelSheet.addCell(l79);
                    jxl.write.Number l80=new jxl.write.Number(6, 48, 0);
                    jxl.write.Number l81=new jxl.write.Number(8, 48, 0);
                     jxl.write.Number l82=new jxl.write.Number(6, 49, 0);
                    jxl.write.Number l83=new jxl.write.Number(8, 49, 0);
                 excelSheet.addCell(l80);
                    excelSheet.addCell(l81);
                    excelSheet.addCell(l82);
                    excelSheet.addCell(l83);
                    jxl.write.Number l88=new jxl.write.Number(4,42,0);                      
                    excelSheet.addCell(l88);
                    float i,j,k,l,q,n,r,p;
                    i=j=k=l=q=p=r=n=0;
                    
                    Statement stmt3=conn.createStatement();
                          String query3="SELECT SUM(IGST),SUM(SGST),SUM(CGST),SUM(CESS) FROM purchase;";
                          ResultSet rs3=stmt3.executeQuery(query3);
                           while(rs3.next())
                           { 
                             i=rs3.getFloat(1);
                             j=rs3.getFloat(3);
                             k=rs3.getFloat(2);
                             l=rs3.getFloat(4);
                           }      
                          Statement stmt4=conn.createStatement();
                          String query4="SELECT IGST,SGST,CGST,CESS from sale;";
                          ResultSet rs4=stmt4.executeQuery(query4);   
                           while(rs4.next()){
                               q=rs4.getFloat(1);
                               n=rs4.getFloat(3);
                               p=rs4.getFloat(2);
                               r=rs4.getFloat(4);
                               if(q!=0&&p!=0&&n!=0&&r!=0)
                               {
                                   is+=q;
                                   cs+=p;
                                   ss+=n;
                                   css+=r;
                                           
                               }
                               
                              
                               
                           }
                           float nit=is-i;
                           float ish=cs-k;
                           float apo=ss-j;
                           float nov=css-l;
                           
                          jxl.write.Label hkj=new jxl.write.Label(3,56,String.format("%.2f",nit));
                          excelSheet.addCell(hkj);
                           jxl.write.Label sdh=new jxl.write.Label(3,57,String.format("%.2f",ish));
                          excelSheet.addCell(sdh);
                           jxl.write.Label sadn=new jxl.write.Label(3,58,String.format("%.2f",apo));
                          excelSheet.addCell(sadn);
                           jxl.write.Label ncb=new jxl.write.Label(3,59,String.format("%.2f",nov));
                          excelSheet.addCell(ncb);
                          
                          
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
                           Desktop.getDesktop().open(new File(EXCEL_FILE_LOCATION5));
    }
    }
    
    
     @FXML
    public void gstr3()
    {
        
    }
    
    
    
    
     @FXML
    public void gstr9()
    {
        
    }


    }
   
    