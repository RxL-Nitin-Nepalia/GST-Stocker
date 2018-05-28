/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication7;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

/**
 *
 * @author noveshgarg
 */
public class hamcontrol implements Initializable {
    
   @FXML
   ComboBox gro;
    
     @FXML
   ComboBox sname;
     @FXML
   ComboBox iname;
    
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
    public void gopurchase(ActionEvent event) throws IOException
    {
     
     Node node=(Node) event.getSource();
  Stage stage=(Stage) node.getScene().getWindow();
 FXMLLoader loader = new FXMLLoader(getClass().getResource("Purchase.fxml"));
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
     public void setgroup()
     {System.out.println("HELL");
         gro.getItems().clear();
         System.out.println("HELL");
         gro.getItems().addAll("Capital","Cash-in-hand","Bank Account","Current Assets","Current Liability","Indirect Expenses","Incomes","Supplier","Buyer"); 
        System.out.println("HELL");
         new ComboBoxAutoComplete(gro);
     }
    
    
    
    
    
    
    
     @FXML
    public void gopayment(ActionEvent event) throws IOException
    {
     
     Node node=(Node) event.getSource();
  Stage stage=(Stage) node.getScene().getWindow();
 FXMLLoader loader = new FXMLLoader(getClass().getResource("Payment.fxml"));
    Parent root = loader.load();/* Exception */
   FXMLController control=loader.getController(); 
  Scene scene = new Scene(root);
  stage.setScene(scene);
  stage.show();
  control.paymentcombo();
  

     
    }
    
    
    
    
    @FXML
    public void goreceipt(ActionEvent event) throws IOException
    {
     
     Node node=(Node) event.getSource();
  Stage stage=(Stage) node.getScene().getWindow();
 FXMLLoader loader = new FXMLLoader(getClass().getResource("Receipt.fxml"));
    Parent root = loader.load();/* Exception */
   FXMLController control=loader.getController(); 
  Scene scene = new Scene(root);
  stage.setScene(scene);
  stage.show();
  control.paymentcombo();
  

     
    }
    
   
     @FXML
    public void goalterledger(ActionEvent event) throws IOException
    {
     
     Node node=(Node) event.getSource();
  Stage stage=(Stage) node.getScene().getWindow();
 FXMLLoader loader = new FXMLLoader(getClass().getResource("alterledger.fxml"));
    Parent root = loader.load();/* Exception */
   FXMLController control=loader.getController(); 
   System.out.println("1");
  Scene scene = new Scene(root);
  stage.setScene(scene);
  System.out.println("1");
  stage.show();

     try{
               
      Class.forName("java.sql.Driver");  
      System.out.println("1");
      System.out.println("Driver loaded");
      System.out.println("1");
      Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gst","root","root");
      System.out.println("Connection obtained");
      System.out.println("1");
      control.setgroup();
      control.setdata();
       PreparedStatement stmt1=conn.prepareStatement("select * from LEDGER;");
                ResultSet r=stmt1.executeQuery();

 while (r.next()) {  System.out.println("1");
     String seller=r.getString("NAME");
     
     control.altername.getItems().add(seller);
 }
 new ComboBoxAutoComplete(control.altername);
 
stmt1.close();System.out.println("1");
 
      conn.close();
      }
      
      catch (ClassNotFoundException e)
      {}
   catch(SQLException e)
                     
{}
   
     
     
     
     
     
    }
    
         @FXML
    public void goalterinventory(ActionEvent event) throws IOException
    {
     
     Node node=(Node) event.getSource();
  Stage stage=(Stage) node.getScene().getWindow();
 FXMLLoader loader = new FXMLLoader(getClass().getResource("alterinventory.fxml"));
    Parent root = loader.load();/* Exception */
   FXMLController control=loader.getController(); 
  Scene scene = new Scene(root);
  stage.setScene(scene);
  stage.show();
 
  try{
             System.out.println("1");
      Class.forName("java.sql.Driver");  
      System.out.println("Driver loaded");
      Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gst","root","root");
      System.out.println("Connection obtained");
      
      
      System.out.println("1");
       
 
 
     PreparedStatement stmt2=conn.prepareStatement("select * from INVENTORY;");
                ResultSet s=stmt2.executeQuery();
System.out.println("1");
 while (s.next()) {  
     String item=s.getString("STOCK");
     System.out.println("1");
     control.altername.getItems().add(item);  
 }
   new ComboBoxAutoComplete(control.altername);    
 stmt2.close();
System.out.println("1");
 
      conn.close();
      }
      
      catch (ClassNotFoundException e)
      {}
   catch(SQLException e)
                     
{}
   


     
    }
    
    
   @FXML
   public void go1(ActionEvent event) throws Exception
   {
       FXMLController f=new FXMLController();
       
       f.disl(event);
   }
    @FXML
   public void go2(ActionEvent event) throws Exception
   {
       FXMLController f=new FXMLController();
       
       f.disst(event);
   }
    @FXML
   public void go3(ActionEvent event) throws Exception
   {
       FXMLController f=new FXMLController();
       
       f.diss(event);
   }
    @FXML
   public void go4(ActionEvent event) throws Exception
   {
       FXMLController f=new FXMLController();
       
       f.dispu(event);
   }
    @FXML
   public void go5(ActionEvent event) throws Exception
   {
       FXMLController f=new FXMLController();
       
       f.disr(event);
   }
    @FXML
   public void go6(ActionEvent event) throws Exception
   {
       FXMLController f=new FXMLController();
       
       f.disp(event);
   }
    @FXML
   public void go7(ActionEvent event) throws Exception
   {
       FXMLController f=new FXMLController();
       
       f.dispro(event);
   }
    
    @FXML
   public void go8(ActionEvent event) throws Exception
   {
       FXMLController f=new FXMLController();
       
       f.docal(event);
   }
   
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       
        
       
       
      


    }
 
    
    
}