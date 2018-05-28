
package javafxapplication7;


import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import java.awt.Desktop;
import java.io.File;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import static java.sql.JDBCType.NULL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;
import javafx.util.Pair;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.*;




public class FXMLController implements Initializable {

    
    
     public float cess, igst, cgst, sgst;
    
     private static final String EXCEL_FILE_LOCATION1 = "C:\\Users\\Nitins\\Desktop\\TaxInvoice1.xls";
       private static final String EXCEL_FILE_LOCATION = "C:\\Users\\Nitins\\Desktop\\TaxInvoice.xls";
    @FXML
    ToggleButton tog;
    
    @FXML
    RadioButton tax;
    
    @FXML
    RadioButton exempt;
    
    @FXML
    CheckBox ig;
    
    @FXML
    CheckBox ce;
    
    @FXML
    TextField igs;
    
    @FXML
    TextField ces;
    
    
     @FXML
    ComboBox altername;
    

    
    
    @FXML
    TextField nam;
    
    @FXML
    TextField ac;
    
    @FXML
    TextField bra;
    
    @FXML
    TextField gin;
    
    @FXML
    TextField pan;
    
    @FXML
    TextField ob;
    
    @FXML
    TextField isc;
    
    @FXML
    TextArea ad;
    
    @FXML
    TextField stock;
    
    @FXML
    TextField unit;
    
    @FXML
    TextField hsn;
    
    @FXML
    TextField lqty;
    
    @FXML
    TextField lrate;
    
    @FXML
    TextField pqty;
    @FXML
    TextField prate;
    @FXML
    TextField pdis;
    @FXML
    TextArea pnarr;
    @FXML
    Label pcgst;
    @FXML
    Label psgst;
    @FXML
    Label pigst;
    @FXML
    Label pround;
    @FXML
    Label pcess;
    @FXML
    Label ptotal;
    
    @FXML
    Label puntotal;
    @FXML
    TextField pinvoice;
    
    @FXML
    DatePicker pdate;
    @FXML
    TableView table1;
    @FXML
    Label l1;
    @FXML
    Label l2;
    @FXML
    Label l3;
    @FXML
    Label l4;
    @FXML
    Label l5;
    @FXML
    Label l6;
    
    
    
     @FXML
    TextField sqty;
    @FXML
    TextField srate;
    @FXML
    TextField sdis;
    @FXML
    TextArea snarr;
    @FXML
    Label scgst;
    @FXML
    Label ssgst;
    @FXML
    Label sigst;
    @FXML
    Label sround;
    @FXML
    Label scess;
    @FXML
    Label stotal;
    
    @FXML
    Label suntotal;
    @FXML
    TextField sinvoice;
    
    @FXML
    DatePicker sdate;
    
   @FXML
   TableView table2;
   @FXML
   TableView tablel1;
   @FXML
   TableView tablel2;
   @FXML
   TableView tablel3;
   @FXML
   TableView tablea1;
   @FXML
   TableView tablea2;
   @FXML
   TableView tablea3;
    
    
    
    
   @FXML
   ComboBox sta;
   
   @FXML
   ComboBox gro;
   
    @FXML
   ComboBox month;
    
     @FXML
   ComboBox year;

   
   @FXML
   ComboBox sname;
   
   @FXML
   ComboBox iname;
   
   
   @FXML
    DatePicker padate;
   
   @FXML
   ComboBox pato;
   
   @FXML
   ComboBox paby;
   
   @FXML
    TextArea panarr;
   
    @FXML
    TextField paamount;
    @FXML
    TextField reamount;
   @FXML
   TableView table3;
   @FXML
   TableView table4;
   @FXML
   TableView table5;
   @FXML
   TableView table6;
   
     
  @FXML
   private void namevalid()
    {
     String b=nam.getText();
          
    int txtlength=b.length();
    for(int i=0;i<txtlength;i++)
    {
    if((b.charAt(i)<65||(91<b.charAt(i)&&b.charAt(i)<97)||b.charAt(i)>123) && b.charAt(i)!=32 && b.charAt(i)!=46)
    { 
        
    b = b.substring(0,i);
            
            Alert alert=new Alert(AlertType.WARNING);
            alert.setContentText("input should be character");
            alert.setHeaderText("incorrect input");
            alert.showAndWait();
           nam.setText(b);
    }}}
   
   
   @FXML
   private void itemnamevalid()
    {
     String b=stock.getText();
          
    int txtlength=b.length();
    for(int i=0;i<txtlength;i++)
    {
    if((b.charAt(i)<65||(91<b.charAt(i)&&b.charAt(i)<97)||b.charAt(i)>123) && b.charAt(i)!=32 && b.charAt(i)!=46)
    {
    b = b.substring(0,i);
            
            Alert alert=new Alert(AlertType.WARNING);
            alert.setContentText("input should be character");
            alert.setHeaderText("incorrect input");
            alert.showAndWait();
           stock.setText(b);
    }}}
   
   
   @FXML
   private void unitvalid()
    {
     String b=unit.getText();
          
    int txtlength=b.length();
    for(int i=0;i<txtlength;i++)
    {
    if(b.charAt(i)<65||(91<b.charAt(i)&&b.charAt(i)<97)||b.charAt(i)>123)
    {
    b = b.substring(0,i);
            
            Alert alert=new Alert(AlertType.WARNING);
            alert.setContentText("input should be character");
            alert.setHeaderText("incorrect input");
            alert.showAndWait();
           unit.setText(b);
    }}}
   
   
   @FXML
   private void gstinvalid()
   {
   String b=gin.getText();
    int txtlength=b.length();
    if(txtlength>15)
    {
    b=b.substring(0,15);
    gin.setText(b);
    }
    
    for(int i=0;i<2;i++)
    {
    if(b.charAt(i)=='0' ||b.charAt(i)=='1'||b.charAt(i)=='2'||b.charAt(i)=='3'||b.charAt(i)=='4'||b.charAt(i)=='5'||b.charAt(i)=='6'||b.charAt(i)=='7'||b.charAt(i)=='8'||b.charAt(i)=='9')
    {
    
   }
    
    else
    {
        b=b.substring(0,i);
    Alert alert=new Alert(AlertType.WARNING);
            alert.setContentText("INVALID GST");
            alert.setHeaderText("INVALID GST");
            alert.showAndWait();
           gin.setText(b);
    }
    
    
    
    
    for( i=2;i<7;i++)
    {
    if(b.charAt(i)<65||(91<b.charAt(i)&&b.charAt(i)<97)||b.charAt(i)>123)
    {
    b=b.substring(0,i);
    Alert alert=new Alert(AlertType.WARNING);
            alert.setContentText("INVALID GST");
            alert.setHeaderText("INVALID GST");
            alert.showAndWait();
             gin.setText(b);
    }
    }
    
    
    
    
    for( i=7;i<11;i++)
    {
    if(b.charAt(i)=='0' ||b.charAt(i)=='1'||b.charAt(i)=='2'||b.charAt(i)=='3'||b.charAt(i)=='4'||b.charAt(i)=='5'||b.charAt(i)=='6'||b.charAt(i)=='7'||b.charAt(i)=='8'||b.charAt(i)=='9')
    {
    
   }
    
    else
    {
        b=b.substring(0,i);
    Alert alert=new Alert(AlertType.WARNING);
            alert.setContentText("INVALID GST");
            alert.setHeaderText("INVALID GST");
            alert.showAndWait();
           gin.setText(b);
    }
    
    
    
    
    if(b.charAt(11)<65||(91<b.charAt(11)&&b.charAt(11)<97)||b.charAt(11)>123)
    {
    b=b.substring(0,i);
    Alert alert=new Alert(AlertType.WARNING);
            alert.setContentText("INVALID GST");
            alert.setHeaderText("INVALID GST");
            alert.showAndWait();
             gin.setText(b);
    }
    
    
    
    
    if(b.charAt(12)=='0' ||b.charAt(12)=='1'||b.charAt(12)=='2'||b.charAt(12)=='3'||b.charAt(12)=='4'||b.charAt(12)=='5'||b.charAt(12)=='6'||b.charAt(12)=='7'||b.charAt(12)=='8'||b.charAt(12)=='9')
    {
    
   }
    
    else
    {
        b=b.substring(0,i);
    Alert alert=new Alert(AlertType.WARNING);
            alert.setContentText("INVALID GST");
            alert.setHeaderText("INVALID GST");
            alert.showAndWait();
           gin.setText(b);
    }
    
    
    
    
    for( i=13;i<15;i++)
    {
    if(b.charAt(i)<65||(91<b.charAt(i)&&b.charAt(i)<97)||b.charAt(i)>123)
    {
    b=b.substring(0,i);
    Alert alert=new Alert(AlertType.WARNING);
            alert.setContentText("INVALID GST");
            alert.setHeaderText("INVALID GST");
            alert.showAndWait();
             gin.setText(b);
    }
    }
    
   }
   
    
    
    
    
    
   
   }
   }
   
   
   @FXML
   private void panvalid()
   {
       
       
   String b=pan.getText();
    int txtlength=b.length();
    if(txtlength>10)
    {
    b=b.substring(0,10);
    pan.setText(b);
    }
    
       
       for( int i=0;i<5;i++)
    {
    if(b.charAt(i)<65||(91<b.charAt(i)&&b.charAt(i)<97)||b.charAt(i)>123)
    {
    b=b.substring(0,i);
    Alert alert=new Alert(AlertType.WARNING);
            alert.setContentText("INVALID PAN");
            alert.setHeaderText("INVALID PAN");
            alert.showAndWait();
             pan.setText(b);
    }
    }
    
    
    
    
    for( int i=5;i<9;i++)
    {
    if(b.charAt(i)=='0' ||b.charAt(i)=='1'||b.charAt(i)=='2'||b.charAt(i)=='3'||b.charAt(i)=='4'||b.charAt(i)=='5'||b.charAt(i)=='6'||b.charAt(i)=='7'||b.charAt(i)=='8'||b.charAt(i)=='9')
    {
    
   }
    
    else
    {
        b=b.substring(0,i);
    Alert alert=new Alert(AlertType.WARNING);
            alert.setContentText("INVALID PAN");
            alert.setHeaderText("INVALID PAN");
            alert.showAndWait();
           pan.setText(b);
    }
    
    
    
    
    if(b.charAt(9)<65||(91<b.charAt(9)&&b.charAt(9)<97)||b.charAt(9)>123)
    {
    b=b.substring(0,i);
    Alert alert=new Alert(AlertType.WARNING);
            alert.setContentText("INVALID PAN");
            alert.setHeaderText("INVALID PAN");
            alert.showAndWait();
             pan.setText(b);
    }
    
    
    
    }
       
   }
   
   
   
  
   
   @FXML
   private void acvalid()
    {
     String b=ac.getText();
          
    int txtlength=b.length();
    if(txtlength>12)
    {b=b.substring(0,12);
    ac.setText(b);
    }
   
    for(int i=0;i<txtlength;i++)
    { if(b.charAt(i)=='0' ||b.charAt(i)=='1'||b.charAt(i)=='2'||b.charAt(i)=='3'||b.charAt(i)=='4'||b.charAt(i)=='5'||b.charAt(i)=='6'||b.charAt(i)=='7'||b.charAt(i)=='8'||b.charAt(i)=='9')
    {
    
   }
    
    else
    {
    
    b = b.substring(0,i);
            
            Alert alert=new Alert(AlertType.WARNING);
            alert.setContentText("input should be numeric");
            alert.setHeaderText("incorrect input");
            alert.showAndWait();
           ac.setText(b);
    }}}
   
   
   
   @FXML
   private void ifscvalid()
   {
       String b=isc.getText();
    int txtlength=b.length();
    if(txtlength>11)
    {
    b=b.substring(0,11);
    isc.setText(b);
    }
    
    
    
    for(int i=0;i<4;i++)
    {
    if(b.charAt(i)<65||(91<b.charAt(i)&&b.charAt(i)<97)||b.charAt(i)>123)
    {
    b=b.substring(0,i);
    Alert alert=new Alert(AlertType.WARNING);
            alert.setContentText("input should be alphabet");
            alert.setHeaderText("incorrect input");
            alert.showAndWait();
             isc.setText(b);
    }
    }
    
    
    
    
    for(int i=4;i<11;i++)
    {
    if(b.charAt(i)=='0' ||b.charAt(i)=='1'||b.charAt(i)=='2'||b.charAt(i)=='3'||b.charAt(i)=='4'||b.charAt(i)=='5'||b.charAt(i)=='6'||b.charAt(i)=='7'||b.charAt(i)=='8'||b.charAt(i)=='9')
    {
    
   }
    
    else
    {
        b=b.substring(0,i);
    Alert alert=new Alert(AlertType.WARNING);
            alert.setContentText("input should be numeric");
            alert.setHeaderText("incorrect input");
            alert.showAndWait();
           isc.setText(b);
    }
    
    
    
    
   }
   
    
    
    
    
    
    }
   
   
   
   @FXML
   private void branchvalid()
    {
     String b=bra.getText();
          
    int txtlength=b.length();
    for(int i=0;i<txtlength;i++)
    {
    if((b.charAt(i)<65||(91<b.charAt(i)&&b.charAt(i)<97)||b.charAt(i)>123)&& b.charAt(i)!=32 && b.charAt(i)!=46)
    {
    b = b.substring(0,i);
            
            Alert alert=new Alert(AlertType.WARNING);
            alert.setContentText("input should be a character");
            alert.setHeaderText("incorrect input");
            alert.showAndWait();
           bra.setText(b);
    }}}
   
   
   
   @FXML
   private void obvalid()
    {System.out.println("validation check");
     String b=ob.getText();
       
    int txtlength=b.length();
  
    
   
    for(int i=0;i<txtlength;i++)
    {
    if(b.charAt(i)=='0' ||b.charAt(i)=='1'||b.charAt(i)=='2'||b.charAt(i)=='3'||b.charAt(i)=='4'||b.charAt(i)=='5'||b.charAt(i)=='6'||b.charAt(i)=='7'||b.charAt(i)=='8'||b.charAt(i)=='9'||b.charAt(i)==46)
    {  
    }
    
    else
    {
    
    b = b.substring(0,i);
            
            Alert alert=new Alert(AlertType.WARNING);
            alert.setContentText("input should be numeric");
            alert.setHeaderText("incorrect input");
            alert.showAndWait();
           ob.setText(b);
    }}}

    
   
    @FXML
   private void hsnvalid()
    {System.out.println("validation check");
     String b=hsn.getText();
       
    int txtlength=b.length();
  
    
   
    for(int i=0;i<txtlength;i++)
    {
    if(b.charAt(i)=='0' ||b.charAt(i)=='1'||b.charAt(i)=='2'||b.charAt(i)=='3'||b.charAt(i)=='4'||b.charAt(i)=='5'||b.charAt(i)=='6'||b.charAt(i)=='7'||b.charAt(i)=='8'||b.charAt(i)=='9')
    {  
    }
    
    else
    {
    
    b = b.substring(0,i);
            
            Alert alert=new Alert(AlertType.WARNING);
            alert.setContentText("input");
            alert.setHeaderText("incorrect input");
            alert.showAndWait();
           hsn.setText(b);
    }}}

   
   
    @FXML
   private void igsvalid()
    {System.out.println("validation check");
     String b=igs.getText();
       
    int txtlength=b.length();
  
    
   
    for(int i=0;i<txtlength;i++)
    {
    if(b.charAt(i)=='0' ||b.charAt(i)=='1'||b.charAt(i)=='2'||b.charAt(i)=='3'||b.charAt(i)=='4'||b.charAt(i)=='5'||b.charAt(i)=='6'||b.charAt(i)=='7'||b.charAt(i)=='8'||b.charAt(i)=='9'|| b.charAt(i)==46)
    {  
    }
    
    else
    {
    
    b = b.substring(0,i);
            
            Alert alert=new Alert(AlertType.WARNING);
            alert.setContentText("input should be numeric");
            alert.setHeaderText("incorrect input");
            alert.showAndWait();
           igs.setText(b);
    }}}

   
   
    @FXML
   private void cessvalid()
    {System.out.println("validation check");
     String b=ces.getText();
       
    int txtlength=b.length();
  
    
   
    for(int i=0;i<txtlength;i++)
    {
    if(b.charAt(i)=='0' ||b.charAt(i)=='1'||b.charAt(i)=='2'||b.charAt(i)=='3'||b.charAt(i)=='4'||b.charAt(i)=='5'||b.charAt(i)=='6'||b.charAt(i)=='7'||b.charAt(i)=='8'||b.charAt(i)=='9'|| b.charAt(i)==46)
    {  
    }
    
    else
    {
    
    b = b.substring(0,i);
            
            Alert alert=new Alert(AlertType.WARNING);
            alert.setContentText("input should be numeric");
            alert.setHeaderText("incorrect input");
            alert.showAndWait();
           ces.setText(b);
    }}}

   
    @FXML
   private void qtyvalid()
    {System.out.println("validation check");
     String b=lqty.getText();
       
    int txtlength=b.length();
  
    
   
    for(int i=0;i<txtlength;i++)
    {
    if(b.charAt(i)==46 ||b.charAt(i)=='0' ||b.charAt(i)=='1'||b.charAt(i)=='2'||b.charAt(i)=='3'||b.charAt(i)=='4'||b.charAt(i)=='5'||b.charAt(i)=='6'||b.charAt(i)=='7'||b.charAt(i)=='8'||b.charAt(i)=='9')
    {  
    }
    
    else
    {
    
    b = b.substring(0,i);
            
            Alert alert=new Alert(AlertType.WARNING);
            alert.setContentText("input should be numeric");
            alert.setHeaderText("incorrect input");
            alert.showAndWait();
           lqty.setText(b);
    }
    
  
    
    
    
    }}

   
   
    @FXML
   private void ratevalid()
    {System.out.println("validation check");
     String b=lrate.getText();
       
    int txtlength=b.length();
  
    
   
    for(int i=0;i<txtlength;i++)
    {
    if(b.charAt(i)==46 || b.charAt(i)=='0' ||b.charAt(i)=='1'||b.charAt(i)=='2'||b.charAt(i)=='3'||b.charAt(i)=='4'||b.charAt(i)=='5'||b.charAt(i)=='6'||b.charAt(i)=='7'||b.charAt(i)=='8'||b.charAt(i)=='9')
    {  
    }
    
    else
    {
    
    b = b.substring(0,i);
            
            Alert alert=new Alert(AlertType.WARNING);
            alert.setContentText("input should be numeric");
            alert.setHeaderText("incorrect input");
            alert.showAndWait();
           lrate.setText(b);
    }}}

    
   
    @FXML
   private void pamountvalid()
    {System.out.println("validation check");
     String b=paamount.getText();
       
    int txtlength=b.length();
  
    
   
    for(int i=0;i<txtlength;i++)
    {
    if(b.charAt(i)==46 ||b.charAt(i)=='0'||b.charAt(i)=='1'||b.charAt(i)=='2'||b.charAt(i)=='3'||b.charAt(i)=='4'||b.charAt(i)=='5'||b.charAt(i)=='6'||b.charAt(i)=='7'||b.charAt(i)=='8'||b.charAt(i)=='9')
    {  
    }
    
    else
    {
    
    b = b.substring(0,i);
            
            Alert alert=new Alert(AlertType.WARNING);
            alert.setContentText("input should be numeric");
            alert.setHeaderText("incorrect input");
            alert.showAndWait();
           paamount.setText(b);
    }}}

     @FXML
   private void pqtyvalid()
    {System.out.println("validation check");
     String b=pqty.getText();
       
    int txtlength=b.length();
  
    
   
    for(int i=0;i<txtlength;i++)
    {
    if(b.charAt(i)==46 ||b.charAt(i)=='0' ||b.charAt(i)=='1'||b.charAt(i)=='2'||b.charAt(i)=='3'||b.charAt(i)=='4'||b.charAt(i)=='5'||b.charAt(i)=='6'||b.charAt(i)=='7'||b.charAt(i)=='8'||b.charAt(i)=='9')
    {
        
        
        try{
               
      Class.forName("java.sql.Driver");  
      System.out.println("Driver loaded");
      Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gst","root","root");
      System.out.println("Connection obtained");
      int s3=Integer.parseInt(pqty.getText());
      System.out.print(s3);
      String s4=(String) iname.getSelectionModel().getSelectedItem();
      System.out.println(s4);
      System.out.println(s3);
     String query1="select QUANTITY from inventory where STOCK='"+s4+"';";
     Statement stmt1=conn.createStatement(); 
     ResultSet rs1=stmt1.executeQuery(query1);
      int qq = 0;
     while(rs1.next())
      {
          
      
      qq=rs1.getInt(1);
      }
     System.out.println(qq);
      if(s3>qq)
      {b = b.substring(0,i);
          Alert alert=new Alert(AlertType.WARNING);
            alert.setContentText("Qunatity greater than stock");
            alert.setHeaderText("incorrect input");
            alert.showAndWait();
            pqty.setText(b);
      }
      
    else
      {
          
      }
    
    
    
    
    
    }
    
    
    catch (ClassNotFoundException e)
      {}
   catch(SQLException e)
                     
{}
        
    }
    
    else
    {
    
    b = b.substring(0,i);
            
            Alert alert=new Alert(AlertType.WARNING);
            alert.setContentText("input should be numeric");
            alert.setHeaderText("incorrect input");
            alert.showAndWait();
           sqty.setText(b);
           
           
           
           
           
           
            
           
           
           
           
           
    }
    
    
    
    
     
    
    }
    
    }

   
     @FXML
   private void pratevalid()
    {System.out.println("validation check");
     String b=prate.getText();
       
    int txtlength=b.length();
  
    
   
    for(int i=0;i<txtlength;i++)
    {
    if(b.charAt(i)==46 ||b.charAt(i)=='0'||b.charAt(i)=='1'||b.charAt(i)=='2'||b.charAt(i)=='3'||b.charAt(i)=='4'||b.charAt(i)=='5'||b.charAt(i)=='6'||b.charAt(i)=='7'||b.charAt(i)=='8'||b.charAt(i)=='9')
    {  
    }
    
    else
    {
    
    b = b.substring(0,i);
            
            Alert alert=new Alert(AlertType.WARNING);
            alert.setContentText("input should be numeric");
            alert.setHeaderText("incorrect input");
            alert.showAndWait();
           prate.setText(b);
    }}}


   
    @FXML
   private void pdisvalid()
    {System.out.println("validation check");
     String b=pdis.getText();
       
    int txtlength=b.length();
  
    
   
    for(int i=0;i<txtlength;i++)
    {
    if(b.charAt(i)==46 ||b.charAt(i)=='0'||b.charAt(i)=='1'||b.charAt(i)=='2'||b.charAt(i)=='3'||b.charAt(i)=='4'||b.charAt(i)=='5'||b.charAt(i)=='6'||b.charAt(i)=='7'||b.charAt(i)=='8'||b.charAt(i)=='9')
    {  
    }
    
    else
    {
    
    b = b.substring(0,i);
            
            Alert alert=new Alert(AlertType.WARNING);
            alert.setContentText("input should be numeric");
            alert.setHeaderText("incorrect input");
            alert.showAndWait();
           pdis.setText(b);
    }}}

   

   
   
    
    @FXML
    public void close(ActionEvent event) {
    System.exit(0);
    }
    @FXML
    public void mini(ActionEvent event){
        Stage stage=(Stage)((Button)event.getSource()).getScene().getWindow();
        stage.setIconified(true);
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
   
     @FXML
     public void setdata()
     {
         sta.getItems().clear();
         sta.getItems().addAll("Andaman & Nicobar Islands","Andhra Pradesh","Arunachal Pradesh","Assam","Bihar","Chandigarh","Chattisgarh","Dadra & Nagar Haveli","Daman & Diu","Delhi","Goa","Gujarat","Haryana","Himachal Pradesh","Jammu & Kashmir","Karnataka","Kerela","Jharkhand","Lakshwadeep","Madhya Pradesh","Maharashtra","Manipur","Meghalaya","Mizoram","Nagaland","Orissa","Puducherry","Punjab","Rajasthan","Sikkim","Tamil Nadu","Telangana","Tripura","Uttar Pradesh","Uttarakhand","West Bengal");
         new ComboBoxAutoComplete(sta);
     }
     
     @FXML
     public void setgroup()
     {
         gro.getItems().clear();
         gro.getItems().addAll("Capital","Cash-in-hand","Bank Account","Current Assets","Current Liability","Indirect Expenses","Incomes","Supplier","Buyer"); 
         new ComboBoxAutoComplete(gro);
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
    
     
     
    
     @FXML
     public void paymentcombo()
     {
         pato.getItems().clear();
         paby.getItems().clear();
         
         
         try{
               
      Class.forName("java.sql.Driver");  
      System.out.println("Driver loaded");
      Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gst","root","root");
      System.out.println("Connection obtained");
      
      
      
       PreparedStatement stmt1=conn.prepareStatement("select * from LEDGER");
                ResultSet r=stmt1.executeQuery();

 while (r.next()) {  
     String seller=r.getString("NAME");
     
     paby.getItems().add(seller);
     pato.getItems().add(seller);
 }
 new ComboBoxAutoComplete(paby);
 new ComboBoxAutoComplete(pato);
   
stmt1.close();
 
      conn.close();
      }
      
      catch (ClassNotFoundException e)
      {}
   catch(SQLException e)
                     
{}
     

  
         
         
     } 
     
     
        
    @FXML
    public void toinvoice() throws SQLException, ClassNotFoundException, IOException, BiffException, WriteException{
         WritableWorkbook myFirstWbook = null;
        Workbook wbook=null;
        wbook = Workbook.getWorkbook(new File(EXCEL_FILE_LOCATION1));
        myFirstWbook = Workbook.createWorkbook(new File(EXCEL_FILE_LOCATION),wbook);
    WritableSheet excelSheet = myFirstWbook.getSheet(0);
        float invoice, cess, cgst, sgst, igst,roundoff, quantity, rate, total, hsn = 0, taxablevalue, discount,iop=0;
                          String stat=null,buyer, item, gstin = null, date, add = null,unit=null;
    
    
     Class.forName("java.sql.Driver");  
            System.out.println("Driver loaded");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gst","root","root");
            System.out.println("Connection obtained");
                          Statement stmt=conn.createStatement();
                          String query="select * from sale order by INVOICE DESC;";
                          ResultSet rs=stmt.executeQuery(query);
                   
                          while(rs.next())
                          {
                            
                           invoice=rs.getInt("INVOICE");
                           cess=rs.getFloat("CESS");
                           cgst=rs.getFloat("CGST");
                           sgst=rs.getFloat("SGST");
                           igst=rs.getFloat("IGST");
                           roundoff=rs.getFloat("ROUNDOFF");
                           quantity=rs.getInt("QUANTITY");
                           rate=rs.getInt("RATE");
                           total=rs.getInt("TOTAL");
                           discount=rs.getFloat("DISCOUNT");
                           date=rs.getString("DATE_");
                           buyer=rs.getString("BUYER");
                           item=rs.getString("ITEM");
                           System.out.println(roundoff);
                           
                              
                          Statement stmt1=conn.createStatement();
                          String query1="select GSTIN, ADDRESS,STATE from LEDGER where NAME='"+buyer+"';";
                          ResultSet rs1=stmt1.executeQuery(query1);
                           System.out.println(invoice);
                          while(rs1.next())
                           {
                               gstin=rs1.getString("GSTIN");
                               add=rs1.getString("ADDRESS");
                               stat=rs1.getString("STATE");
                           } 
                          System.out.println(add);
                           Statement stmt2=conn.createStatement();
                          String query2="select HSN,UNITS,IGST from INVENTORY where STOCK='"+item+"';";
                          ResultSet rs2=stmt2.executeQuery(query2);
                           while(rs2.next())
                           {
                               hsn=rs2.getInt("HSN");
                               unit=rs2.getString("UNITS");
                               System.out.println(unit);
                               iop=rs2.getInt("IGST");
                           }
                           
                           
                               
      /*sgst=Float.parseFloat(String.format("%.2f",sgst));
      cgst=Float.parseFloat(String.format("%.2f",cgst));
      igst=Float.parseFloat(String.format("%.2f",igst));
      total=Float.parseFloat(String.format("%.2f",total));
      discount=Float.parseFloat(String.format("%.2f",discount));
      roundoff=Float.parseFloat(String.format("%.2f",roundoff));*/
                          
   jxl.write.Label x2=new jxl.write.Label(9,4,date);
   excelSheet.addCell(x2);

    jxl.write.Number x3=new jxl.write.Number(6,4,invoice);
excelSheet.addCell(x3);

jxl.write.Number x5=new jxl.write.Number(5,19,quantity);
excelSheet.addCell(x5);
jxl.write.Label x6=new jxl.write.Label(1,19,item);
excelSheet.addCell(x6);
jxl.write.Label x4=new jxl.write.Label(7,19,unit);
excelSheet.addCell(x4);
jxl.write.Number x8=new jxl.write.Number(9,19,quantity*rate);
excelSheet.addCell(x8);
jxl.write.Label x9=new jxl.write.Label(9,22,String.format("%.2f",discount));
excelSheet.addCell(x9);
jxl.write.Label x10=new jxl.write.Label(9,23,String.format("%.2f",sgst));
excelSheet.addCell(x10);
jxl.write.Label x11=new jxl.write.Label(9,24,String.format("%.2f",cgst));
excelSheet.addCell(x11);
jxl.write.Label x12=new jxl.write.Label(9,26,String.format("%.2f",roundoff));
excelSheet.addCell(x12);
jxl.write.Number x13=new jxl.write.Number(9,27,((quantity*rate)-(quantity*rate*(discount/100))+cgst+sgst+cess+igst-roundoff));
excelSheet.addCell(x13);
jxl.write.Label x14=new jxl.write.Label(9,25,String.format("%.2f",igst));
excelSheet.addCell(x14);

jxl.write.Number x15=new jxl.write.Number(4,33,quantity*rate);
excelSheet.addCell(x15);
jxl.write.Number x16=new jxl.write.Number(9,33,((quantity*rate)-(quantity*rate*(discount/100))+cgst+sgst+cess+igst-roundoff));
excelSheet.addCell(x16);
jxl.write.Label x17=new jxl.write.Label(1,11,buyer);
excelSheet.addCell(x17);
jxl.write.Number x18=new jxl.write.Number(4,19,hsn);
excelSheet.addCell(x18);jxl.write.Number x19=new jxl.write.Number(6,19,rate);
excelSheet.addCell(x19);
jxl.write.Label x20=new jxl.write.Label(1,12,"  "+add);
excelSheet.addCell(x20);
jxl.write.Label x21=new jxl.write.Label(1,14,"GSTIN: "+gstin.toUpperCase());
excelSheet.addCell(x21);
jxl.write.Number x22=new jxl.write.Number(3,33,hsn);
excelSheet.addCell(x22);
jxl.write.Number x23=new jxl.write.Number(5,33,iop/2);
excelSheet.addCell(x23);
jxl.write.Number x24=new jxl.write.Number(6,33,cgst);
excelSheet.addCell(x24);
jxl.write.Number x25=new jxl.write.Number(7,33,iop/2);
excelSheet.addCell(x25);
jxl.write.Number x26=new jxl.write.Number(8,33,sgst);
excelSheet.addCell(x26);
jxl.write.Label x27=new jxl.write.Label(1,13,stat+", India");
excelSheet.addCell(x27);



 break; 
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
Desktop.getDesktop().open(new File(EXCEL_FILE_LOCATION));
    }
    

    
       

      
      
    
    @FXML
    public void move(ActionEvent event) throws IOException, ClassNotFoundException, SQLException
    {
     Node node=(Node) event.getSource();
  Stage stage=(Stage) node.getScene().getWindow();
 FXMLLoader loader = new FXMLLoader(getClass().getResource("Createledger.fxml"));
    Parent root = loader.load();/* Exception */
    FXMLController control=loader.getController();
  Scene scene = new Scene(root);
  stage.setScene(scene);
  stage.show();
  control.setdata();
  control.setgroup();
 
   
    }
    
    
    
     
    @FXML
    public void Balance(ActionEvent event) throws IOException, ClassNotFoundException, SQLException
    {
     Node node=(Node) event.getSource();
  System.out.print("hol");
     Stage stage=(Stage) node.getScene().getWindow();
 System.out.print("hol");
  FXMLLoader loader = new FXMLLoader(getClass().getResource("sheet.fxml"));
 System.out.print("hol");   
 Parent root = loader.load();/* Exception */
    System.out.print("hol");
    FXMLController control=loader.getController();
  System.out.print("hol");
  Dialog<Pair<String, String>> dialog = new Dialog<>();
dialog.setTitle("Protected Page");
dialog.setHeaderText("TEXLINE INDUSTRIES\n\nEnter username and password to proceed");

// Set the icon (must be included in the project).
//dialog.setGraphic(new ImageView(this.getClass().getResource("login.png").toString()));

// Set the button types.
ButtonType loginButtonType = new ButtonType("Login", ButtonBar.ButtonData.OK_DONE);
dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

// Create the username and password labels and fields.
GridPane grid = new GridPane();
grid.setHgap(10);
grid.setVgap(10);


TextField username = new TextField();
username.setPromptText("Username");
PasswordField password = new PasswordField();
password.setPromptText("Password");

grid.add(new Label("Username:"), 0, 0);
grid.add(username, 1, 0);
grid.add(new Label("Password:"), 0, 1);
grid.add(password, 1, 1);

// Enable/Disable login button depending on whether a username was entered.
Node loginButton = dialog.getDialogPane().lookupButton(loginButtonType);
loginButton.setDisable(true);

// Do some validation (using the Java 8 lambda syntax).
username.textProperty().addListener((observable, oldValue, newValue) -> {
    loginButton.setDisable(newValue.trim().isEmpty());
});

dialog.getDialogPane().setContent(grid);

// Request focus on the username field by default.
Platform.runLater(() -> username.requestFocus());

// Convert the result to a username-password-pair when the login button is clicked.
dialog.setResultConverter(dialogButton -> {
    if (dialogButton == loginButtonType) {
        return new Pair<>(username.getText(), password.getText());
    }
    return null;
});

Optional<Pair<String, String>> result = dialog.showAndWait();

result.ifPresent(usernamePassword -> {
   if(usernamePassword.getValue().equals("texline1991")&&usernamePassword.getKey().equals("texline")){

    
    Scene scene = new Scene(root);
  stage.setScene(scene);
  stage.show();
  System.out.print("hol");
  

   }
   else{
       try {
           Balance(event);
       } catch (IOException ex) {
           Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
       } catch (SQLException ex) {
           Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
});control.buildDatal1();
  control.buildDatal2();
  control.buildDatal3();
  control.buildDataa1();
  control.buildDataa2();
  control.buildDataa3();
    control.sum1();
  control.sum2();
  control.sum3();
  control.sum4();
  control.sum5();
  control.sum6();
  control.bancash();
    }
    
     

    
     public void buildData1(){
          
          data = FXCollections.observableArrayList();
          try{
            
                          Class.forName("java.sql.Driver");  
            System.out.println("Driver loaded");
           Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/gst", "root", "root");
            System.out.println("Connection obtained");
                          Statement stmt=conn.createStatement();
            
            String SQL = "SELECT * from sale;";
      
            ResultSet rs = stmt.executeQuery(SQL);

            for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
               
                final int j = i;                
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {                                                                                              
                        return new SimpleStringProperty(param.getValue().get(j).toString());                        
                    }                    
                });

                table2.getColumns().addAll(col); 
                
            }

            while(rs.next()){
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    //Iterate Column
                    row.add(rs.getString(i));
                }
                
                data.add(row);

            }
            stmt.close();
            conn.close();

            //FINALLY ADDED TO TableView
            table2.setItems(data);
          }catch(Exception e){
              e.printStackTrace();
              System.out.println("Error on Building Data");             
          }
      }      public void buildData2(){
          
          data = FXCollections.observableArrayList();
          try{
            
                          Class.forName("java.sql.Driver");  
            System.out.println("Driver loaded");
           Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/gst", "root", "root");
            System.out.println("Connection obtained");
                          Statement stmt=conn.createStatement();
            System.out.println("yo");
            String SQL = "SELECT * from inventory;";
      System.out.println("yo");
            ResultSet rs = stmt.executeQuery(SQL);
System.out.println("yo");
            for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
          System.out.println("yo1");     
                final int j = i;                
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {                                                                                              
                        return new SimpleStringProperty(param.getValue().get(j).toString());                        
                    }                    
                });
System.out.println("yo");
                table3.getColumns().addAll(col); 
                
            }

            while(rs.next()){
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    //Iterate Column
                    row.add(rs.getString(i));
                }
                System.out.println("yo");
                data.add(row);
System.out.println("yo");
            }
            stmt.close();
            conn.close();

            //FINALLY ADDED TO TableView
            table3.setItems(data);System.out.println("yo");
          }catch(Exception e){
              e.printStackTrace();
              System.out.println("Error on Building Data");             
          }
      }
       public void buildData4(){
          
          data = FXCollections.observableArrayList();
          try{
            
                          Class.forName("java.sql.Driver");  
            System.out.println("Driver loaded");
           Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/gst", "root", "root");
            System.out.println("Connection obtained");
                          Statement stmt=conn.createStatement();
            
            String SQL = "SELECT * from ledger order by GROUPS;";
      
            ResultSet rs = stmt.executeQuery(SQL);

            for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
               
                final int j = i;                
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {                                                                                              
                        return new SimpleStringProperty(param.getValue().get(j).toString());                        
                    }                    
                });

                table4.getColumns().addAll(col); 
                
            }

            while(rs.next()){
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    //Iterate Column
                    row.add(rs.getString(i));
                }
                
                data.add(row);

            }
            stmt.close();
            conn.close();

            //FINALLY ADDED TO TableView
            table4.setItems(data);
          }catch(Exception e){
              e.printStackTrace();
              System.out.println("Error on Building Data");             
          }
      }
     public void buildData5(){
          
          data = FXCollections.observableArrayList();
          try{
            
                          Class.forName("java.sql.Driver");  
            System.out.println("Driver loaded");
           Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/gst", "root", "root");
            System.out.println("Connection obtained");
                          Statement stmt=conn.createStatement();
            
            String SQL = "SELECT * from receipt;";
      
            ResultSet rs = stmt.executeQuery(SQL);

            for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
               
                final int j = i;                
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {                                                                                              
                        return new SimpleStringProperty(param.getValue().get(j).toString());                        
                    }                    
                });

                table5.getColumns().addAll(col); 
                
            }

            while(rs.next()){
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    //Iterate Column
                    row.add(rs.getString(i));
                }
                
                data.add(row);

            }
            stmt.close();
            conn.close();

            //FINALLY ADDED TO TableView
            table5.setItems(data);
          }catch(Exception e){
              e.printStackTrace();
              System.out.println("Error on Building Data");             
          }
      } public void buildData6(){
          
          data = FXCollections.observableArrayList();
          try{
            
                          Class.forName("java.sql.Driver");  
            System.out.println("Driver loaded");
           Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/gst", "root", "root");
            System.out.println("Connection obtained");
                          Statement stmt=conn.createStatement();
            
            String SQL = "SELECT * from payment;";
      
            ResultSet rs = stmt.executeQuery(SQL);

            for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
               
                final int j = i;                
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {                                                                                              
                        return new SimpleStringProperty(param.getValue().get(j).toString());                        
                    }                    
                });

                table6.getColumns().addAll(col); 
                
            }

            while(rs.next()){
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    //Iterate Column
                    row.add(rs.getString(i));
                }
                
                data.add(row);

            }
            stmt.close();
            conn.close();

            //FINALLY ADDED TO TableView
            table6.setItems(data);
          }catch(Exception e){
              e.printStackTrace();
              System.out.println("Error on Building Data");             
          }
      }
    

    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML
    public void gotoinven(ActionEvent event) throws IOException
    {
     
     Node node=(Node) event.getSource();
  Stage stage=(Stage) node.getScene().getWindow();
  Parent root = FXMLLoader.load(getClass().getResource("Createinventory.fxml"));/* Exception */
  Scene scene = new Scene(root);
  stage.setScene(scene);
  stage.show();

    }

    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML
    public void gosale(ActionEvent event) throws IOException
    {
     
     Node node=(Node) event.getSource();
  Stage stage=(Stage) node.getScene().getWindow();
 FXMLLoader loader = new FXMLLoader(getClass().getResource("Sales.fxml"));
    Parent root = loader.load();/* Exception */
   FXMLController control=loader.getController(); 
  Scene scene = new Scene(root);
  stage.setScene(scene);
  stage.show();
  //control.paymentcombo();
  
  

    try{
               
      Class.forName("java.sql.Driver");  
      System.out.println("Driver loaded");
      Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gst","root","root");
      System.out.println("Connection obtained");
      
      
       Statement stmt5=conn.createStatement();
       
      String query="select MAX(INVOICE) from SALE;";
       
      ResultSet rs1=stmt5.executeQuery(query);
      
      int s2 = 0;
       while(rs1.next())
      {
        s2=rs1.getInt(1);
        
        
      }
       
       System.out.println(s2);
      ++s2;
      System.out.println(s2);
      control.sinvoice.setText(" "+s2);
      
      System.out.println("Sinvoice");
      
      
       PreparedStatement stmt1=conn.prepareStatement("select * from LEDGER where GROUPS='Supplier' OR GROUPS='Buyer';");
                ResultSet r=stmt1.executeQuery();

 while (r.next()) {  
     String seller=r.getString("NAME");
     
     control.sname.getItems().add(seller);
    
 }
     PreparedStatement stmt2=conn.prepareStatement("select * from INVENTORY;");
                ResultSet s=stmt2.executeQuery();

 while (s.next()) {  
     String item=s.getString("STOCK");
     control.iname.getItems().add(item);
 }   
 stmt2.close();
stmt1.close();
 
      conn.close();
      }
      
      catch (ClassNotFoundException e)
      {}
   catch(SQLException e)
                     
{}
     

  
  
  
     
    }
    
    
     @FXML
    public void docal(ActionEvent e) throws Exception
    {
        Node node=(Node) e.getSource();
  Stage stage=new Stage();
        stage.setTitle("Calculator");
        
        
        stage.setResizable(false);
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("calc.fxml"))));
        stage.show();
    }
    
 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @FXML
    public void gogst(ActionEvent event) throws Exception
    {
         Node node=(Node) event.getSource();
  Stage stage=(Stage) node.getScene().getWindow();
 FXMLLoader loader = new FXMLLoader(getClass().getResource("gst.fxml"));
    Parent root = loader.load();/* Exception */
    gstcontrol control=loader.getController();
  Scene scene = new Scene(root);
  stage.setScene(scene);
  stage.show();
  control.setmonth();
 
    }
    
    
    
    @FXML   
    public void radioenable(ActionEvent e)
    { 
  if(tog.isSelected())
  {
      tax.setDisable(false);
      exempt.setDisable(false);
      
      
  }
  else
  {
      
      tax.setDisable(true);
      exempt.setDisable(true);
      ig.setDisable(true);
      ce.setDisable(true);
      igs.setDisable(true);
      igs.setText("");
      ces.setDisable(true);
      ces.setText("");
      tax.setSelected(false);
      exempt.setSelected(false);
      ig.setSelected(false);
      ce.setSelected(false);
  }
        
    }
    
    
    
    @FXML
    public void groupselected()
    { 
        
        System.out.println("H");
     if(gro.getSelectionModel().getSelectedIndex()==0)
     {
         ob.setDisable(false);
          ad.setDisable(true);
             gin.setDisable(true);
             pan.setDisable(true);
             sta.setDisable(true);
             ac.setDisable(true);
             isc.setDisable(true);
             bra.setDisable(true);
     }
     
      else if(gro.getSelectionModel().getSelectedIndex()==1)
         {
             ob.setDisable(false);
              ad.setDisable(true);
             gin.setDisable(true);
             pan.setDisable(true);
             sta.setDisable(true);
             ac.setDisable(true);
             isc.setDisable(true);
             bra.setDisable(true);
         }
      
         else if(gro.getSelectionModel().getSelectedIndex()==2)
         {
             ac.setDisable(false);
             isc.setDisable(false);
             bra.setDisable(false);
             ob.setDisable(false);   
              ad.setDisable(true);
             gin.setDisable(true);
             pan.setDisable(true);
             sta.setDisable(true);
         }
         
     
         
         else if((gro.getSelectionModel().getSelectedIndex()==3)||(gro.getSelectionModel().getSelectedIndex()==4)||(gro.getSelectionModel().getSelectedIndex()==5)||(gro.getSelectionModel().getSelectedIndex()==6))
         {
             ob.setDisable(false);
              ad.setDisable(true);
             gin.setDisable(true);
             pan.setDisable(true);
             sta.setDisable(true);
             ac.setDisable(true);
             isc.setDisable(true);
             bra.setDisable(true);
         }
         else if((gro.getSelectionModel().getSelectedIndex()==7)||(gro.getSelectionModel().getSelectedIndex()==8))
         {System.out.println("HELLO");
             ad.setDisable(false);
             gin.setDisable(false);
             pan.setDisable(false);
             ob.setDisable(false);
             sta.setDisable(false);
             ac.setDisable(true);
             isc.setDisable(true);
             bra.setDisable(true);
         }
         else 
         {
             
         }
        
      
    }
    
    
    @FXML
    public void gst(ActionEvent e)
    { 
     
      ig.setDisable(false);
      ce.setDisable(false);
      
    }
    public void nogst(ActionEvent e)
    { 
     
      ig.setDisable(true);
      ce.setDisable(true);
      
    }
 
    
   
    @FXML
    public void igstt(ActionEvent e)
            
    {
        if(ig.isSelected())
        {    
     igs.setDisable(false);
        }
        else
        {
      igs.setDisable(true);
        }  
    }
    
    
    @FXML
    public void cest(ActionEvent e)
    {
        if(ce.isSelected())
        {
            ces.setDisable(false);
        }
        else
        {
            ces.setDisable(true);
        }
    }
    
    
    @FXML
    public void inventorysubmit(ActionEvent event) throws IOException
    {   int s6=0,s7=0;
          String s1=stock.getText();
          String s2=unit.getText();
       
         int s3=Integer.parseInt(hsn.getText());
        int s4=Integer.parseInt(lqty.getText());
        int s5=Integer.parseInt(lrate.getText());
        if(exempt.isSelected())
        {
           s6=0;
           s7=0;
        }
        else
        {
            if(ig.isSelected())
            {
        s6=Integer.parseInt(igs.getText());
            }
            if(ce.isSelected())
            {
        s7=Integer.parseInt(ces.getText());
            }
            } 
        
        
        
         try{
               
            Class.forName("java.sql.Driver");  
            System.out.println("Driver loaded");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gst","root","root");
            System.out.println("Connection obtained");
                          PreparedStatement stmt=conn.prepareStatement("insert into INVENTORY values(?,?,?,?,?,?,?)");
                          stmt.setString(1,s1);
                          stmt.setString(2,s2);
                          stmt.setInt(3,s3);
                          stmt.setInt(4,s4);
                          stmt.setInt(5,s5);
                          stmt.setInt(6,s6);
                           stmt.setInt(7,s7);
                           
                          stmt.executeUpdate();
                          //PreparedStatement stmt=conn.prepareStatement("select STOCK,IGST from inventory");
                       
                           stmt.close();
                           conn.close();
          } catch (ClassNotFoundException e)
                  {
                  
                  
                  }
             catch(SQLException e)
                     {}
          
            Alert alert=new Alert(AlertType.INFORMATION);
            alert.setContentText("Successfully Submiited");
            alert.setHeaderText("SUCCESS");
            alert.showAndWait();
         gotoinven(event);
    }
    
   
    
     @FXML
    public void calunt(KeyEvent e) 
    { 
        pqtyvalid();
        pratevalid();
        pdisvalid();
        float d1 = 0,e1 = 0;
    
     String state = null;
    String s14=(String) iname.getSelectionModel().getSelectedItem();
    String s15=(String) sname.getSelectionModel().getSelectedItem();
    
    try{
               
      Class.forName("java.sql.Driver");  
      System.out.println("Driver loaded");
        
        
        
          Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gst","root","root");
     String query="select CESS,IGST from INVENTORY where STOCK='"+s14+"';";
     Statement stmt=conn.createStatement(); 
     ResultSet rs=stmt.executeQuery(query);
     
     
     System.out.println("connection obtained");
     
     
      if(rs.next()) 
      {
          d1=rs.getInt("CESS");
          e1=rs.getInt("IGST");
      }
      
      
     float s10=Float.parseFloat(pqty.getText());
     float s11=Float.parseFloat(prate.getText());
     float s12=0;
     s12=Float.parseFloat(pdis.getText());
     float t=0,amt=0,unt=0;
     
     amt=s10*s11;
     t=amt*(s12/100);
     unt=amt-t;
     
     
      cess=(d1/100)*unt;
      
      igst=(e1/100)*unt;
     puntotal.setText(""+unt);
    
     float rr = 0;
   float total=unt+igst+cess;
          
     if(total%1>0)
     {
         
         rr=total%1;
     }
     pround.setText(String.format("%.2f",rr));
        float tot=total-rr;
     ptotal.setText(""+tot);
     
            
      stmt.close();
      conn.close();
      }
      
      catch (ClassNotFoundException | SQLException a)
                  {                  }

    try{
               
      Class.forName("java.sql.Driver");  
      System.out.println("Driver loaded");
        
        
        
          Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gst","root","root");
     String query="select STATE from LEDGER where NAME='"+s15+"';";
     Statement stmt=conn.createStatement(); 
     ResultSet rs=stmt.executeQuery(query);
     
     
     System.out.println("connection obtained2");
       
     
    
    if(rs.next())
    {
        state=rs.getString("STATE");
    } 
     System.out.println(state);
      if(state.equals("Delhi"))
      { 
          pigst.setText("0");
          pcgst.setText(String.format("%.2f",igst/2));
          psgst.setText(String.format("%.2f",igst/2));
          pcess.setText(String.format("%.2f",cess));
          sgst=cgst=igst/2;
          
          igst=0;
      }
      else
      {
           pigst.setText(String.format("%.2f",igst));
          pcgst.setText("0");
          psgst.setText("0");
          pcess.setText(String.format("%.2f"+cess));
          cgst=sgst=0;
      }
     
     
           
      stmt.close();
      conn.close();
      }
      
      catch (ClassNotFoundException | SQLException a)
                  {                  }


    
          
          
          
          
    
    }
    
    
  
    
    
    
    
    
    
     @FXML
    public void pcalunt(KeyEvent e) 
    { 
       
        float d1 = 0,e1 = 0;
    
     String state = null;
    String s14=(String) iname.getSelectionModel().getSelectedItem();
    String s15=(String) sname.getSelectionModel().getSelectedItem();
    
    try{
               
      Class.forName("java.sql.Driver");  
      System.out.println("Driver loaded");
        
        
        
          Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gst","root","root");
     String query="select CESS,IGST from INVENTORY where STOCK='"+s14+"';";
     Statement stmt=conn.createStatement(); 
     ResultSet rs=stmt.executeQuery(query);
     
     
     System.out.println("connection obtained");
     
     
      if(rs.next()) 
      {
          d1=rs.getInt("CESS");
          e1=rs.getInt("IGST");
      }
      
      
     float s10=Float.parseFloat(sqty.getText());
     float s11=Float.parseFloat(prate.getText());
     float s12=0;
     s12=Float.parseFloat(pdis.getText());
     float t=0,amt=0,unt=0;
     
     amt=s10*s11;
     t=amt*(s12/100);
     unt=amt-t;
     
     
      cess=(d1/100)*unt;
      
      igst=(e1/100)*unt;
     puntotal.setText(""+unt);
    
     float rr = 0;
   float total=unt+igst+cess;
          
     if(total%1>0)
     {
         
         rr=total%1;
     }
     pround.setText(String.format("%.2f",rr));
        float tot=total-rr;
     ptotal.setText(""+tot);
     
            
      stmt.close();
      conn.close();
      }
      
      catch (ClassNotFoundException | SQLException a)
                  {                  }

    try{
               
      Class.forName("java.sql.Driver");  
      System.out.println("Driver loaded");
        
        
        
          Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gst","root","root");
     String query="select STATE from LEDGER where NAME='"+s15+"';";
     Statement stmt=conn.createStatement(); 
     ResultSet rs=stmt.executeQuery(query);
     
     
     System.out.println("connection obtained2");
       
     
    
    if(rs.next())
    {
        state=rs.getString("STATE");
    } 
     System.out.println(state);
      if(state.equals("Delhi"))
      { 
          pigst.setText("0");
          pcgst.setText(String.format("%.2f",igst/2));
          psgst.setText(String.format("%.2f",igst/2));
          pcess.setText(String.format("%.2f",cess));
          sgst=cgst=igst/2;
          
          igst=0;
      }
      else
      {
           pigst.setText(String.format("%.2f",igst));
          pcgst.setText("0");
          psgst.setText("0");
          pcess.setText(String.format("%.2f",cess));
          cgst=sgst=0;
      }
     
     
           
      stmt.close();
      conn.close();
      }
      
      catch (ClassNotFoundException | SQLException a)
                  {                  }


    
          
          
          
          
    
    }
    
    
    
    
    
    
    
    
    
     
    
    
    @FXML
    public void inventoryretrieve()
    {
        
        try{
              Connection conn=null;
              ResultSet rs=null;
            Class.forName("java.sql.Driver");  
            System.out.println("Driver loaded");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gst", "root", "root");
            System.out.println("Connection obtained");
                          Statement stmt=conn.createStatement();
                          rs=stmt.executeQuery("select units,hsn,quantity,rate,igst,cess from inventory where stock='"+altername.getSelectionModel().getSelectedItem()+"';");
                   
                           while(rs.next()) { 
        unit.setText(rs.getString("units"));
        hsn.setText(rs.getString("hsn"));
        lqty.setText(rs.getString("quantity"));
        lrate.setText(rs.getString("rate"));
        igs.setText(rs.getString("igst"));
        ces.setText(rs.getString("cess"));
                           }
                           
                           
                           
                 
                           stmt.close();
                           conn.close();
          } catch (Exception e)
          {}

        
    }
    
    
    
    @FXML
    public void updateinventory(ActionEvent event) throws IOException
    {
        
     
         try{
             Connection conn=null;
            Class.forName("java.sql.Driver");  
            System.out.println("Driver loaded");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gst", "root", "root");
            System.out.println("Connection obtained");
             //if(validation())
           //  {
                          PreparedStatement ps=conn.prepareStatement("update inventory set units= '"+unit.getText()+"', hsn = '"+hsn.getText()+"', quantity = '"+lqty.getText()+"',rate = '"+lrate.getText()+"',igst='"+igs.getText()+"',cess='"+ces.getText()+"' where stock='"+altername.getSelectionModel().getSelectedItem()+"';");                        
                          
                      System.out.println("5");
                          int x=ps.executeUpdate();
                          
                           ps.close();
                           conn.close();
                        Alert alert=new Alert(AlertType.INFORMATION);
            alert.setContentText("Successfully Submiited");
            alert.setHeaderText("SUCCESS");
            alert.showAndWait();
                            hamcontrol hc=new hamcontrol();
         hc.goalterinventory(event);
                           
            // }             
          } catch (ClassNotFoundException e)
                  {
                  
                  
                  }
             catch(SQLException e)
                     {}

    }
    
    
    
    
    
  @FXML
public void ledgerretrieve()
{
    
    try{
              Connection conn=null;
              ResultSet rs=null;
            Class.forName("java.sql.Driver");  
            System.out.println("Driver loaded");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gst", "root", "root");
            System.out.println("Connection obtained");
                        
            
         
            
           
            
            Statement stmt=conn.createStatement();
                          rs=stmt.executeQuery("select address,state,ac,ifsc,branch,pan,gstin,amount,groups from ledger where name='"+altername.getSelectionModel().getSelectedItem()+"';");
                   
                           while(rs.next()) { 
        ad.setText(rs.getString("address"));
     sta.setValue(rs.getString("STATE"));
        ac.setText(rs.getString("ac"));
        isc.setText(rs.getString("ifsc"));
        bra.setText(rs.getString("branch"));
        pan.setText(rs.getString("pan"));
        gin.setText(rs.getString("gstin"));
        ob.setText(rs.getString("amount"));
        System.out.println(rs.getString("groups"));
       gro.setValue(rs.getString("groups"));
       groupselected();
                           }
                           
                           
                           
                 
                           stmt.close();
                           conn.close();
          } catch (Exception e)
          {}

    
    
}

    
    
    
    
 @FXML
    public void updateledger(ActionEvent event) throws IOException
    {
        
     
         try{
             Connection conn=null;
            Class.forName("java.sql.Driver");  
            System.out.println("Driver loaded");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gst", "root", "root");
            System.out.println("Connection obtained");
             //if(validation())
           //  {    
           
           
           
           String address="",state="",ifsc="", branch="",pann="", gstin="";
           double acc=0, obb=0;
           
           
                          address=ad.getText();
                          System.out.println(address);
                          state=(String) sta.getSelectionModel().getSelectedItem();
                          System.out.println(state);
                          ifsc=isc.getText();
                          System.out.println(ifsc);
                          branch=bra.getText();
                          System.out.println(branch);
                          pann=pan.getText();
                          System.out.println(pann);
                          gstin=gin.getText();
                          System.out.println(gstin);
                          acc=Double.parseDouble(ac.getText());
                          System.out.println(acc);
                          
                          obb=Double.parseDouble(ob.getText());
                          System.out.println(obb);
           
                          
                          
         if(gro.getSelectionModel().getSelectedIndex()==0)
     {
         System.out.println("1");
            address="";
             gstin="";
             pann="";
             state="";
             acc=0;
             ifsc="";
             branch="";
     }
     
      else if(gro.getSelectionModel().getSelectedIndex()==1)
         {
             System.out.println("1");
             address="";
             gstin="";
             pann="";
             state="";
             acc=0;
             ifsc="";
             branch="";
         }
      
         else if(gro.getSelectionModel().getSelectedIndex()==2)
         {System.out.println("1");
             
            address="";
             gstin="";
             pann="";
             state="";
             
         }
         
     
         
         else if((gro.getSelectionModel().getSelectedIndex()==3)||(gro.getSelectionModel().getSelectedIndex()==4)||(gro.getSelectionModel().getSelectedIndex()==5)||(gro.getSelectionModel().getSelectedIndex()==6))
         {System.out.println("1");
             
               address="";
             gstin="";
             pann="";
             state="";
             acc=0;
             ifsc="";
             branch="";
            
         }
         else if((gro.getSelectionModel().getSelectedIndex()==7)||(gro.getSelectionModel().getSelectedIndex()==8))
         {
            System.out.println("1");
            
             acc=0;
             ifsc="";
             branch="";
             
         }
         else 
         {
           System.out.println("1");  
         }
         
         
         
                         // address=ad.getText();
                          System.out.println(address);
                         // state=(String) sta.getSelectionModel().getSelectedItem();
                          System.out.println(state);
                         // ifsc=isc.getText();
                          System.out.println(ifsc);
                         // branch=bra.getText();
                          System.out.println(branch);
                         // pann=pan.getText();
                          System.out.println(pann);
                         // gstin=gin.getText();
                          System.out.println(gstin);
                         // acc=Float.parseFloat(ac.getText());
                          System.out.println(acc);
                          
                          //obb=Float.parseFloat(ob.getText());
                          System.out.println(obb);
         
         
         
         
                          
                          
                          
           
           
                          PreparedStatement ps=conn.prepareStatement("update ledger set address='"+address+"', state='"+state+"', ac="+acc+",ifsc ='"+ifsc+"',branch='"+branch+"',pan='"+pann+"', gstin='"+gstin+"',amount="+obb+", groups='"+gro.getSelectionModel().getSelectedItem()+"' where name='"+altername.getSelectionModel().getSelectedItem()+"';");                        
                          
                      System.out.println("5");
                          ps.executeUpdate();
                          
                           ps.close();
                           conn.close();
                  
                           
                           
                           
                           
            // }             
          } catch (ClassNotFoundException e)
                  {
                  
                  
                  }
             catch(SQLException e)
                     {}
          Alert alert=new Alert(AlertType.INFORMATION);
            alert.setContentText("Successfully Submiited");
            alert.setHeaderText("SUCCESS");
            alert.showAndWait();
         hamcontrol hc=new hamcontrol();
         
         hc.goalterledger(event);

    }
    ObservableList<ObservableList> data;
    
    
    
    @FXML
    public void buildData(){
          
          data = FXCollections.observableArrayList();
          try{
            
                          Class.forName("java.sql.Driver");  
            System.out.println("Driver loaded");
           Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/gst", "root", "root");
            System.out.println("Connection obtained");
                          Statement stmt=conn.createStatement();
            
            String SQL = "SELECT * from purchase order by DATE_;";
      
            ResultSet rs = stmt.executeQuery(SQL);

            for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
               
                final int j = i;                
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {                                                                                              
                        return new SimpleStringProperty(param.getValue().get(j).toString());                        
                    }                    
                });

                table1.getColumns().addAll(col); 
                
            }

            while(rs.next()){
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    //Iterate Column
                    row.add(rs.getString(i));
                }
                
                data.add(row);

            }
            stmt.close();
            conn.close();

            //FINALLY ADDED TO TableView
            table1.setItems(data);
          }catch(Exception e){
              e.printStackTrace();
              System.out.println("Error on Building Data");             
          }
      }
    
    @FXML
    public void buildDatal1(){
          
          data = FXCollections.observableArrayList();
          try{
            
                          Class.forName("java.sql.Driver");  
            System.out.println("Driver loaded");
           Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/gst", "root", "root");
            System.out.println("Connection obtained");
                          Statement stmt=conn.createStatement();
            
            String SQL = "SELECT NAME,AMOUNT from ledger where GROUPS like 'Current liability';";
      
            ResultSet rs = stmt.executeQuery(SQL);

            for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
               
                final int j = i;                
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {                                                                                              
                        return new SimpleStringProperty(param.getValue().get(j).toString());                        
                    }                    
                });

                tablel1.getColumns().addAll(col); 
                
            }

            while(rs.next()){
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    //Iterate Column
                    row.add(rs.getString(i));
                }
                
                data.add(row);

            }
            stmt.close();
            conn.close();

            //FINALLY ADDED TO TableView
            tablel1.setItems(data);
          }catch(Exception e){
              e.printStackTrace();
              System.out.println("Error on Building Data");             
          }
      }
    public void buildDatal2(){
          
          data = FXCollections.observableArrayList();
          try{
            
                          Class.forName("java.sql.Driver");  
            System.out.println("Driver loaded");
           Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/gst", "root", "root");
            System.out.println("Connection obtained");
                          Statement stmt=conn.createStatement();
            
            String SQL = "SELECT NAME,AMOUNT from ledger where GROUPS like 'Indirect Expenses';";
      
            ResultSet rs = stmt.executeQuery(SQL);

            for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
               
                final int j = i;                
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {                                                                                              
                        return new SimpleStringProperty(param.getValue().get(j).toString());                        
                    }                    
                });

                tablel2.getColumns().addAll(col); 
                
            }

            while(rs.next()){
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    //Iterate Column
                    row.add(rs.getString(i));
                }
                
                data.add(row);

            }
            stmt.close();
            conn.close();

            //FINALLY ADDED TO TableView
            tablel2.setItems(data);
          }catch(Exception e){
              e.printStackTrace();
              System.out.println("Error on Building Data");             
          }
      }
    
    public void buildDatal3(){
          
          data = FXCollections.observableArrayList();
          try{
            
                          Class.forName("java.sql.Driver");  
            System.out.println("Driver loaded");
           Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/gst", "root", "root");
            System.out.println("Connection obtained");
                          Statement stmt=conn.createStatement();
            
            String SQL = "SELECT NAME,AMOUNT from ledger where GROUPS like 'Supplier';";
      
            ResultSet rs = stmt.executeQuery(SQL);

            for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
               
                final int j = i;                
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {                                                                                              
                        return new SimpleStringProperty(param.getValue().get(j).toString());                        
                    }                    
                });

                tablel3.getColumns().addAll(col); 
                
            }

            while(rs.next()){
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    //Iterate Column
                    row.add(rs.getString(i));
                }
                
                data.add(row);

            }
            stmt.close();
            conn.close();

            //FINALLY ADDED TO TableView
            tablel3.setItems(data);
          }catch(Exception e){
              e.printStackTrace();
              System.out.println("Error on Building Data");             
          }
      }
         public void buildDataa1(){
          
          data = FXCollections.observableArrayList();
          try{
            
                          Class.forName("java.sql.Driver");  
            System.out.println("Driver loaded");
           Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/gst", "root", "root");
            System.out.println("Connection obtained");
                          Statement stmt=conn.createStatement();
            
            String SQL = "SELECT NAME,AMOUNT from ledger where GROUPS like 'Current Assets';";
      
            ResultSet rs = stmt.executeQuery(SQL);

            for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
               
                final int j = i;                
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {                                                                                              
                        return new SimpleStringProperty(param.getValue().get(j).toString());                        
                    }                    
                });

                tablea1.getColumns().addAll(col); 
                
            }

            while(rs.next()){
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    //Iterate Column
                    row.add(rs.getString(i));
                }
                
                data.add(row);

            }
            stmt.close();
            conn.close();

            //FINALLY ADDED TO TableView
            tablea1.setItems(data);
          }catch(Exception e){
              e.printStackTrace();
              System.out.println("Error on Building Data");             
          }
      }
        
     public void buildDataa2(){
          
          data = FXCollections.observableArrayList();
          try{
            
                          Class.forName("java.sql.Driver");  
            System.out.println("Driver loaded");
           Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/gst", "root", "root");
            System.out.println("Connection obtained");
                          Statement stmt=conn.createStatement();
            
            String SQL = "SELECT NAME,AMOUNT from ledger where GROUPS like 'Incomes';";
      
            ResultSet rs = stmt.executeQuery(SQL);

            for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
               
                final int j = i;                
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {                                                                                              
                        return new SimpleStringProperty(param.getValue().get(j).toString());                        
                    }                    
                });

                tablea2.getColumns().addAll(col); 
                
            }

            while(rs.next()){
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    //Iterate Column
                    row.add(rs.getString(i));
                }
                
                data.add(row);

            }
            stmt.close();
            conn.close();

            //FINALLY ADDED TO TableView
            tablea2.setItems(data);
          }catch(Exception e){
              e.printStackTrace();
              System.out.println("Error on Building Data");             
          }
      }
        
    
     public void buildDataa3(){
          
          data = FXCollections.observableArrayList();
          try{
            
                          Class.forName("java.sql.Driver");  
            System.out.println("Driver loaded");
           Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/gst", "root", "root");
            System.out.println("Connection obtained");
                          Statement stmt=conn.createStatement();
            
            String SQL = "SELECT NAME,AMOUNT from ledger where GROUPS like 'Buyer';";
      
            ResultSet rs = stmt.executeQuery(SQL);

            for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
               
                final int j = i;                
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {                                                                                              
                        return new SimpleStringProperty(param.getValue().get(j).toString());                        
                    }                    
                });

                tablea3.getColumns().addAll(col); 
                
            }

            while(rs.next()){
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    //Iterate Column
                    row.add(rs.getString(i));
                }
                
                data.add(row);

            }
            stmt.close();
            conn.close();

            //FINALLY ADDED TO TableView
            tablea3.setItems(data);
          }catch(Exception e){
              e.printStackTrace();
              System.out.println("Error on Building Data");             
          }
      }
     @FXML
    public void sum2() throws ClassNotFoundException, SQLException
    {
        float s2=0;
      Class.forName("java.sql.Driver");  
            System.out.println("Driver loaded");
           Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/gst", "root", "root");
            System.out.println("Connection obtained");
                          Statement stmt=conn.createStatement();
            
            String SQL = "SELECT sum(AMOUNT) from ledger where GROUPS like 'Indirect Expenses';";
      
            ResultSet rs = stmt.executeQuery(SQL); 
            while(rs.next()){
            s2=rs.getFloat(1);}
            l2.setText("Total:"+s2);
    }
    
    @FXML
    public void sum1() throws ClassNotFoundException, SQLException
    {
        float s1=0;
      Class.forName("java.sql.Driver");  
            System.out.println("Driver loaded");
           Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/gst", "root", "root");
            System.out.println("Connection obtained");
                          Statement stmt=conn.createStatement();
            
            String SQL = "SELECT sum(AMOUNT) from ledger where GROUPS like 'Current Liability';";
      
            ResultSet rs = stmt.executeQuery(SQL); 
            while(rs.next()){
            s1=rs.getFloat(1);}
            l1.setText("Total:"+s1);
    }
    @FXML
    public void sum3() throws ClassNotFoundException, SQLException
    {
        float s3=0;
      Class.forName("java.sql.Driver");  
            System.out.println("Driver loaded");
           Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/gst", "root", "root");
            System.out.println("Connection obtained");
                          Statement stmt=conn.createStatement();
            
            String SQL = "SELECT sum(AMOUNT) from ledger where GROUPS like 'Supplier';";
      
            ResultSet rs = stmt.executeQuery(SQL); 
            while(rs.next()){
            s3=rs.getFloat(1);}
            l3.setText("Total:"+s3);
    }   
    @FXML
    public void sum4() throws ClassNotFoundException, SQLException
    {
        float s4=0;
      Class.forName("java.sql.Driver");  
            System.out.println("Driver loaded");
           Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/gst", "root", "root");
            System.out.println("Connection obtained");
                          Statement stmt=conn.createStatement();
            
            String SQL = "SELECT sum(AMOUNT) from ledger where GROUPS like 'Current Assets';";
      
            ResultSet rs = stmt.executeQuery(SQL); 
            while(rs.next()){
            s4=rs.getFloat(1);}
            l4.setText("Total:"+s4);
    }
    
    @FXML
    public void sum5() throws ClassNotFoundException, SQLException
    {
        float s5=0;
      Class.forName("java.sql.Driver");  
            System.out.println("Driver loaded");
           Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/gst", "root", "root");
            System.out.println("Connection obtained");
                          Statement stmt=conn.createStatement();
            
            String SQL = "SELECT sum(AMOUNT) from ledger where GROUPS like 'Incomes';";
      
            ResultSet rs = stmt.executeQuery(SQL); 
            while(rs.next()){
            s5=rs.getFloat(1);
            System.out.println(s5);
            }
            l5.setText("Total:"+s5);
    }
    
    @FXML
    public void sum6() throws ClassNotFoundException, SQLException
    {
        float s6=0;
      Class.forName("java.sql.Driver");  
            System.out.println("Driver loaded");
           Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/gst", "root", "root");
            System.out.println("Connection obtained");
                          Statement stmt=conn.createStatement();
            
            String SQL = "SELECT sum(AMOUNT) from ledger where GROUPS like 'Buyer';";
      
            ResultSet rs = stmt.executeQuery(SQL); 
            while(rs.next()){
            s6=rs.getFloat(1);}
            l6.setText("Total:"+s6);
    }
    
    
    
    
    @FXML
    public void salesubmit(ActionEvent event) throws IOException
    { 
    
    float total = 0, tot;
     int s10=Integer.parseInt(pqty.getText());
     int s11=Integer.parseInt(prate.getText());
         float s12=Float.parseFloat(pdis.getText());
     float t,amt,unt;
     amt=s10*s11;
     System.out.println(s10+"\n"+s11);
     t=amt*(s12/100);
     System.out.println(s12);
     System.out.println(t);
     unt=amt-t;
     System.out.println(unt);
     
     
     
     String s14=(String) iname.getSelectionModel().getSelectedItem();
     
     float rr = 0;
     System.out.println(cgst+"\n"+sgst+"\n"+igst+"\n"+cess);
   total=unt+igst+cess+cgst+sgst;
     System.out.println(total);     
     if(total%1>0)
     {
         
         rr=(unt+igst+cess+cgst+sgst)%1;
         System.out.println(rr);
     }
        
          
      
     
     
     
     tot=unt+igst+cess+sgst+cgst-rr;
     
     
     
     
     
     
     
     
        
        
        
        
   
    
    
       String d;
      LocalDate dd=sdate.getValue();
      Date s1=java.sql.Date.valueOf(dd);
      
     int s2=0;
     String s3=(String) sname.getSelectionModel().getSelectedItem();
     float s4=cess;
     float s5=cgst;
     float s7=igst;
     float s6=sgst;
     String s8=snarr.getText();
     float s9=rr;
     
     float s13=tot;
    
      try{
               
      Class.forName("java.sql.Driver");  
      System.out.println("Driver loaded");
      Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gst","root","root");
      System.out.println("Connection obtained");
      Statement stmt1=conn.createStatement();
      String query="select max(INVOICE) from SALE;";
      ResultSet rs=stmt1.executeQuery(query);
      while(rs.next())
      {
          
      
      s2=rs.getInt(1);
      }
      ++s2;
      
     
      

      PreparedStatement stmt=conn.prepareStatement("insert into SALE values(?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
      stmt.setDate(1,s1);
      stmt.setInt(2,s2);
      stmt.setString(3,s3);
      stmt.setFloat(4,s4);
      stmt.setFloat(5,s5);
      stmt.setFloat(6,s6);
      stmt.setFloat(7,s7);
      stmt.setString(8,s8);
      stmt.setFloat(9,s9);
      stmt.setInt(10,s10);
      stmt.setInt(11,s11);
      stmt.setFloat(12,s12);
      stmt.setFloat(13,s13);
      stmt.setString(14,s14);
      
    
      
      stmt.executeUpdate();
      
      Statement stmt3=conn.createStatement();
      String query1="update INVENTORY set QUANTITY=QUANTITY-"+s10+" where STOCK='"+s14+"';";
      stmt3.executeUpdate(query1);
 
      
      
      
      
      
     
        float av=0,pt=0,profit=0,pp=0;
      
        Statement stmt4=conn.createStatement();
            
            String SQL1 = "SELECT avg(RATE) from purchase where ITEM='"+s14+"' group by ITEM;";
      
            ResultSet rs1 = stmt1.executeQuery(SQL1);
        
            while(rs1.next())
        {
            av=rs1.getFloat(1);
        System.out.println(av);
        pt=av*s10;
        System.out.println(pt);
        profit=s13-pt;
        System.out.println(profit);
        pp=(profit/pt)*100;
        System.out.println(pp);
       
      PreparedStatement stmt2=conn.prepareStatement("insert into profit values(?,?,?,?,?,?);");
      stmt2.setDate(1,s1);
      stmt2.setString(2,s14);
      stmt2.setFloat(3,s13);
      stmt2.setFloat(4,pt);
      stmt2.setFloat(5,profit);
      stmt2.setFloat(6,pp);
          stmt2.executeUpdate();
        System.out.println("updated"); 
        }
          conn.close();
        } 
        
        
        
      catch (ClassNotFoundException e)
      {}
   catch(SQLException e)
                     
{}
      Alert alert=new Alert(AlertType.INFORMATION);
            alert.setContentText("Successfully Submiited");
            alert.setHeaderText("SUCCESS");
            alert.showAndWait();
   gosale(event);     

    
    
    
    }
    

    
    
    
    
    
    
    
    @FXML
    public void purchasesubmit(ActionEvent event) throws IOException
    { 
    
    float total = 0, tot;
     int s10=Integer.parseInt(sqty.getText());
     int s11=Integer.parseInt(prate.getText());
     int s12=Integer.parseInt(pdis.getText());
     float t,amt,unt;
     amt=s10*s11;
     t=amt*(s12/100);
     unt=amt-t;
     
     String s2=pinvoice.getText();
     
     
     String s14=(String) iname.getSelectionModel().getSelectedItem();
     
     float rr = 0;
   total=unt+igst+cess;
          
     if(total%1>0)
     {
         
         rr=total%1;
     }
        
          
      
     
     
     
     tot=unt+igst+cess-rr;
     
     
     
     
     
     
     
     
        
        
        
        
   
    
    
       String d;
      LocalDate dd=pdate.getValue();
      Date s1=java.sql.Date.valueOf(dd);
      
     
     String s3=(String) sname.getSelectionModel().getSelectedItem();
     float s4=cess;
     float s5=cgst;
     float s7=igst;
     float s6=sgst;
     String s8=pnarr.getText();
     float s9=rr;
     
     float s13=tot;
    
      try{
               
      Class.forName("java.sql.Driver");  
      System.out.println("Driver loaded");
      Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gst","root","root");
      System.out.println("Connection obtained");
      
      
      
      
      
      

      PreparedStatement stmt=conn.prepareStatement("insert into PURCHASE values(?,?,?,?,?,?,?,?,?,?,?,?,?,?);");
      stmt.setDate(1,s1);
      stmt.setString(2,s2);
      stmt.setString(3,s3);
      stmt.setFloat(4,s4);
      stmt.setFloat(5,s5);
      stmt.setFloat(6,s6);
      stmt.setFloat(7,s7);
      stmt.setString(8,s8);
      stmt.setFloat(9,s9);
      stmt.setInt(10,s10);
      stmt.setInt(11,s11);
      stmt.setInt(12,s12);
      stmt.setFloat(13,s13);
      stmt.setString(14,s14);
      
     Statement stmt3=conn.createStatement();
      String query1="update INVENTORY set QUANTITY=QUANTITY+"+s10+" where STOCK='"+s14+"';";
      stmt3.executeUpdate(query1);
      
      stmt.executeUpdate();
      stmt.close();
      conn.close();
      
      
      pdate.setValue(null);
      pinvoice.setText("INVOICE");
      pcess.setText("CESS");
      pcgst.setText("CGST");
      psgst.setText("SGST");
      pigst.setText("IGST");
      pnarr.setText("Narration ::");
      pround.setText("Round Off");
      sqty.setText("");
      prate.setText("");
      pdis.setText("");
      ptotal.setText("TOTAL");
      puntotal.setText("TOTAL");
      sname.setValue(null);
      iname.setValue(null);
      }
      
      catch (ClassNotFoundException e)
      {}
   catch(SQLException e)
                     
{}
     
       Alert alert=new Alert(AlertType.INFORMATION);
            alert.setContentText("Successfully Submiited");
            alert.setHeaderText("SUCCESS");
            alert.showAndWait();

     hamcontrol hc=new hamcontrol();
         hc.gopurchase(event);
    
    
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
   
   
    
    
   @FXML
    public void ledgersubmit(ActionEvent event) throws IOException
    { 
   
    
    
    String s1=nam.getText();
        
    
    
    String s2=""; 
    String s3 = null;
     
        s3=(String) sta.getSelectionModel().getSelectedItem();
    //System.out.println("8");
        
    double s4 = 0;
             
    //System.out.println("3");
    String s5="";
                
        
        String s6="";
                
         System.out.println("2"); 
        String s7="";
                
        
        String s8="";
         
         System.out.println("4");
        double s9=0;
            s9=Double.parseDouble(ob.getText());
        
        String s10="";
        
        s10=(String) gro.getSelectionModel().getSelectedItem();
       
         System.out.println("6");
        
        
        
         
         
         
         
         if(gro.getSelectionModel().getSelectedIndex()==0)
     {
        
            ad=null;
             gin=null;
             pan=null;
             sta=null;
             ac=null;
             isc=null;
             bra=null;
     }
     
      else if(gro.getSelectionModel().getSelectedIndex()==1)
         {
             
             ad=null;
             gin=null;
             pan=null;
             sta=null;
             ac=null;
             isc=null;
             bra=null;
         }
      
         else if(gro.getSelectionModel().getSelectedIndex()==2)
         {
             
            ad=null;
             gin=null;
             pan=null;
             sta=null;
             s4=Double.parseDouble(ac.getText());
             s5=isc.getText();
             s6=bra.getText();
             s3="";
         }
         
     
         
         else if((gro.getSelectionModel().getSelectedIndex()==3)||(gro.getSelectionModel().getSelectedIndex()==4)||(gro.getSelectionModel().getSelectedIndex()==5)||(gro.getSelectionModel().getSelectedIndex()==6))
         {
             
               ad=null;
             gin=null;
             pan=null;
             sta=null;
             ac=null;
             isc=null;
             bra=null;
            
         }
         else if((gro.getSelectionModel().getSelectedIndex()==7)||(gro.getSelectionModel().getSelectedIndex()==8))
         {
            
            
             ac=null;
             isc=null;
             bra=null;
             s2=ad.getText();
             s7=pan.getText();
             s8=gin.getText();
         }
         else 
         {
             
         }
         
         
         
         
         
         
         
         
         
         
     
         try{
             Connection conn=null;
            Class.forName("java.sql.Driver");  
            System.out.println("Driver loaded");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gst", "root", "root");
            System.out.println("Connection obtained");
             //if(validation())
           //  {
                          PreparedStatement stmt=conn.prepareStatement("insert into LEDGER values(?,?,?,?,?,?,?,?,?,?)");
                          stmt.setString(1,s1);
                          stmt.setString(2,s2);
                          stmt.setString(3,s3);
                          stmt.setDouble(4,s4);
                          stmt.setString(5,s5);
                          stmt.setString(6,s6);
                          stmt.setString(7,s7);
                          stmt.setString(8,s8);
                          stmt.setDouble(9,s9);
                          
                          stmt.setString(10,s10);                          
                          
                      System.out.println("5");
                          int x=stmt.executeUpdate();
                          
                           stmt.close();
                           conn.close();
                            Alert alert=new Alert(AlertType.INFORMATION);
            alert.setContentText("Successfully Submiited");
            alert.setHeaderText("SUCCESS");
            alert.showAndWait();
                           move(event);
                           
                           
                 
                           
                           
                           
            // }             
          } catch (ClassNotFoundException e)
                  {
                  
                  
                  }
             catch(SQLException e)
                     {}

    
    
    }
    
    
    
    
    
    @FXML
    public void paymentsubmit(ActionEvent event) throws IOException {
        
        LocalDate dd=padate.getValue();
      Date s1=java.sql.Date.valueOf(dd);
        System.out.println(s1);
        
         String s3=(String)pato.getSelectionModel().getSelectedItem();
         System.out.println(s3);
         String s2=(String)paby.getSelectionModel().getSelectedItem();
         System.out.println(s2);
         String s5=(String)panarr.getText();
         System.out.println(s5);
         float s4=Float.parseFloat(paamount.getText());
         System.out.println(s4);
         try{
               
      Class.forName("java.sql.Driver");  
      System.out.println("Driver loaded");
      Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gst","root","root");
      System.out.println("Connection obtained");
      
       PreparedStatement stmt=conn.prepareStatement("insert into PAYMENT values(?,?,?,?,?);");
      stmt.setDate(1,s1);
       stmt.setString(2,s2);
      stmt.setString(3,s3);
      stmt.setFloat(4,s4);
      stmt.setString(5,s5);
      
      stmt.executeUpdate();
      stmt.close();
      
      PreparedStatement stmt1=conn.prepareStatement("update LEDGER set AMOUNT=AMOUNT-"+s4+" where NAME='"+s2+"';");
      PreparedStatement stmt2=conn.prepareStatement("update LEDGER set AMOUNT=AMOUNT+"+s4+" where NAME='"+s3+"';");
      
      
      
      stmt1.executeUpdate();
      stmt2.executeUpdate();
      stmt1.close();
      stmt2.close();
      conn.close();
       Alert alert=new Alert(AlertType.INFORMATION);
            alert.setContentText("Successfully Submiited");
            alert.setHeaderText("SUCCESS");
            alert.showAndWait();
      hamcontrol hc=new hamcontrol();
         hc.gopayment(event);
      
         }
      
      catch (ClassNotFoundException e)
      {}
   catch(SQLException e)
                     
{}
     
    
    }
    
    @FXML
    public void receiptsubmit(ActionEvent event) throws IOException {
        
        LocalDate dd=padate.getValue();
      Date s1=java.sql.Date.valueOf(dd);
        System.out.println(s1);
        
         String s3=(String)pato.getSelectionModel().getSelectedItem();
         System.out.println(s3);
         String s2=(String)paby.getSelectionModel().getSelectedItem();
         System.out.println(s2);
         String s5=panarr.getText();
         System.out.println(s5);
         float s4=0;
                 s4=Float.parseFloat(paamount.getText());
         System.out.println(s4);
         try{
               
      Class.forName("java.sql.Driver");  
      System.out.println("Driver loaded");
      Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gst","root","root");
      System.out.println("Connection obtained");
      
       PreparedStatement stmt=conn.prepareStatement("insert into RECEIPT values(?,?,?,?,?);");
      stmt.setDate(1,s1);
       stmt.setString(2,s2);
      stmt.setString(3,s3);
      stmt.setFloat(4,s4);
      stmt.setString(5,s5);
      
      stmt.executeUpdate();
      stmt.close();
      
      PreparedStatement stmt1=conn.prepareStatement("update LEDGER set AMOUNT=AMOUNT+"+s4+" where NAME='"+s2+"';");
      PreparedStatement stmt2=conn.prepareStatement("update LEDGER set AMOUNT=AMOUNT-"+s4+" where NAME='"+s3+"';");
      
      
      
      stmt1.executeUpdate();
      stmt2.executeUpdate();
      stmt1.close();
      stmt2.close();
      conn.close();
      
       Alert alert=new Alert(AlertType.INFORMATION);
            alert.setContentText("Successfully Submiited");
            alert.setHeaderText("SUCCESS");
            alert.showAndWait();
      
      hamcontrol hc=new hamcontrol();
         hc.goreceipt(event);
      
      
         }
      
      catch (ClassNotFoundException e)
      {}
   catch(SQLException e)
                     
{}
     
    
    }
    
    
    
    
    
    
    
    
    
    @FXML
    TableView table7;
    @FXML
    public void seep(){
        data = FXCollections.observableArrayList();
          try{
            
                          Class.forName("java.sql.Driver");  
            System.out.println("Driver loaded");
           Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/gst", "root", "root");
            System.out.println("Connection obtained");
                          Statement stmt=conn.createStatement();
            
            String SQL = "SELECT * from profit;";
      
            ResultSet rs = stmt.executeQuery(SQL);

            for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
               
                final int j = i;                
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {                                                                                              
                        return new SimpleStringProperty(param.getValue().get(j).toString());                        
                    }                    
                });

                table7.getColumns().addAll(col); 
                
            }

            while(rs.next()){
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    //Iterate Column
                    row.add(rs.getString(i));
                }
                
                data.add(row);

            }
            stmt.close();
            conn.close();

            //FINALLY ADDED TO TableView
            table7.setItems(data);
          }catch(Exception e){
              e.printStackTrace();
              System.out.println("Error on Building Data");             
          } 
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
    public void dispro(ActionEvent event) throws Exception
    {
         Node node=(Node) event.getSource();
  Stage stage=(Stage) node.getScene().getWindow();
 FXMLLoader loader = new FXMLLoader(getClass().getResource("dispro.fxml"));
    Parent root = loader.load();/* Exception */
    FXMLController control=loader.getController();
  Scene scene = new Scene(root);
  stage.setScene(scene);
  stage.show();
  control.seep();
  control.sum7();
  control.buildDatal2();
  control.buildDataa2();
  control.net();
  control.setmonth();
  
  
 
    }
    @FXML
    Label np;
    @FXML
    Label ni;
    @FXML
    Label ne;
    @FXML
    public void net() throws ClassNotFoundException, SQLException
    {        float d=0,f=0,e=0,s=0;
    Class.forName("java.sql.Driver");  
            System.out.println("Driver loaded");
           Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/gst", "root", "root");
            System.out.println("Connection obtained");
                          Statement stmt=conn.createStatement();
            
            String SQL = "SELECT sum(PROFIT) from profit;";
            ResultSet rs = stmt.executeQuery(SQL); 
            while(rs.next()){
            d=rs.getFloat(1);}
            
            
       Statement stmt1=conn.createStatement();
            
            String SQL1 = "SELECT sum(AMOUNT) from ledger where GROUPS like 'Incomes';";
            ResultSet rs1 = stmt.executeQuery(SQL1);
             while(rs1.next()){
           e=rs1.getFloat(1);}
             ni.setText("Total Incomes: Rs"+e);
            Statement stmt2=conn.createStatement();
            
            String SQL2 = "SELECT sum(AMOUNT) from ledger where GROUPS like 'Indirect Expenses';";
            ResultSet rs2 = stmt.executeQuery(SQL2); 
             while(rs2.next()){
            f=rs2.getFloat(1);}
             ne.setText("Total Expenditures: Rs"+f);
      System.out.println(d);System.out.println(e);System.out.println(f);
      
         s=(d+e)-f;
        np.setText("NET PROFIT: Rs"+s);
        
    }
    
    
      @FXML
    public void disl(ActionEvent event) throws Exception
    {
         Node node=(Node) event.getSource();
  Stage stage=(Stage) node.getScene().getWindow();
 FXMLLoader loader = new FXMLLoader(getClass().getResource("disledger.fxml"));
    Parent root = loader.load();/* Exception */
    FXMLController control=loader.getController();
  Scene scene = new Scene(root);
  stage.setScene(scene);
  stage.show();
  control.buildData4();
 
    } @FXML
    public void disst(ActionEvent event) throws Exception
    {
         Node node=(Node) event.getSource();
  Stage stage=(Stage) node.getScene().getWindow();
 FXMLLoader loader = new FXMLLoader(getClass().getResource("disinventory.fxml"));
    Parent root = loader.load();/* Exception */
    FXMLController control=loader.getController();
  Scene scene = new Scene(root);
  stage.setScene(scene);
  stage.show();
  control.buildData2();
 
    } @FXML
    public void diss(ActionEvent event) throws Exception
    {
         Node node=(Node) event.getSource();
  Stage stage=(Stage) node.getScene().getWindow();
 FXMLLoader loader = new FXMLLoader(getClass().getResource("dissale.fxml"));
    Parent root = loader.load();/* Exception */
    FXMLController control=loader.getController();
  Scene scene = new Scene(root);
  stage.setScene(scene);
  stage.show();
  control.buildData1();
 
    } @FXML
    public void dispu(ActionEvent event) throws Exception
    {
         Node node=(Node) event.getSource();
  Stage stage=(Stage) node.getScene().getWindow();
 FXMLLoader loader = new FXMLLoader(getClass().getResource("dispurchase.fxml"));
    Parent root = loader.load();/* Exception */
   FXMLController control=loader.getController();
  Scene scene = new Scene(root);
  stage.setScene(scene);
  stage.show();
  control.buildData();
 
    } @FXML
    public void disp(ActionEvent event) throws Exception
    {
         Node node=(Node) event.getSource();
  Stage stage=(Stage) node.getScene().getWindow();
 FXMLLoader loader = new FXMLLoader(getClass().getResource("dispayment.fxml"));
    Parent root = loader.load();/* Exception */
    FXMLController control=loader.getController();
  Scene scene = new Scene(root);
  stage.setScene(scene);
  stage.show();
  control.buildData6();
 
    } @FXML
    public void disr(ActionEvent event) throws Exception
    {
         Node node=(Node) event.getSource();
  Stage stage=(Stage) node.getScene().getWindow();
 FXMLLoader loader = new FXMLLoader(getClass().getResource("disreceipt.fxml"));
    Parent root = loader.load();/* Exception */
    FXMLController control=loader.getController();
  Scene scene = new Scene(root);
  stage.setScene(scene);
  stage.show();
  control.buildData5();
 
    }
    
    @FXML
    Label lp;
   
   public void sum7() throws ClassNotFoundException, SQLException
   {
       float s6=0;
      Class.forName("java.sql.Driver");  
            System.out.println("Driver loaded");
           Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/gst", "root", "root");
            System.out.println("Connection obtained");
                          Statement stmt=conn.createStatement();
            
            String SQL = "SELECT sum(PROFIT) from profit;";
      
            ResultSet rs = stmt.executeQuery(SQL); 
            while(rs.next()){
            s6=rs.getFloat(1);}
            lp.setText("GROSS PROFIT : Rs"+s6);
   }
  
    @FXML
    Label lb;
    @FXML
    Label lc;
    
    
    @FXML
public void bancash() throws ClassNotFoundException, SQLException{
        
       float s6=0,s=0;
      Class.forName("java.sql.Driver");  
            System.out.println("Driver loaded");
           Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/gst", "root", "root");
            System.out.println("Connection obtained");
                          Statement stmt=conn.createStatement();
            
            String SQL = "SELECT sum(AMOUNT) from ledger where GROUPS like 'Bank Account';";
      
            ResultSet rs = stmt.executeQuery(SQL); 
            while(rs.next()){
            s6=rs.getFloat(1);}
            lb.setText("Bank Balance : Rs"+s6);
            Statement stmt1=conn.createStatement();
            
            String SQL1 = "SELECT sum(AMOUNT) from ledger where GROUPS like 'Cash-in-hand';";
      
            ResultSet rs1 = stmt1.executeQuery(SQL1); 
            while(rs1.next()){
            s=rs1.getFloat(1);}
            lc.setText("Cash-in-hand : Rs"+s);
            conn.close();
    }
    
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         try {
            box = FXMLLoader.load(getClass().getResource("SidePanelContent.fxml"));
            drawer.setSidePane(box);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
   
    }  

    
    
    

