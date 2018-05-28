/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication7;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Nitins
 */
public class FXMLDocumentController implements Initializable {
     public FXMLDocumentController() {
        this.left = BigDecimal.ZERO;
        this.selectedOperator = "";
        this.numberInputting = false;
    }
    @FXML
    private BigDecimal left;
    @FXML
    private String selectedOperator;
    @FXML
    private boolean numberInputting;
    @FXML
    TextField display;
    
    
     
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
    protected void handleOnAnyButtonClicked(ActionEvent evt) {
        Button button = (Button)evt.getSource();
        final String buttonText = button.getText();
        if (buttonText.equals("AC")) {
            if (buttonText.equals("AC")) {
                left = BigDecimal.ZERO;
            }
            selectedOperator = "";
            numberInputting = false;
            display.setText("0");;
            return;
        }
        if (buttonText.matches("[0-9\\.]")) {
            if (!numberInputting) {
                numberInputting = true;
                display.clear();
            }
            display.appendText(buttonText);
            return;
        }
        if (buttonText.matches("[＋－×÷]")) {
            left = new BigDecimal(display.getText());
            selectedOperator = buttonText;
            numberInputting = false;
            return;
        }
        if (buttonText.equals("=")) {
            final BigDecimal right = numberInputting ? new BigDecimal(display.getText()) : left;
            left = calculate(selectedOperator, left, right);
            display.setText(left.toString());
            numberInputting = false;
            return;
        }
    }
    
    static BigDecimal calculate(String operator, BigDecimal left, BigDecimal right) {
        switch (operator) {
            case "＋":
                return left.add(right);
            case "－":
                return left.subtract(right);
            case "×":
                return left.multiply(right);
            case "÷":
                return left.divide(right);
            default:
        }
        return right;
    }



    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
