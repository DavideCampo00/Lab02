/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class FXMLController {
	
	private Model model;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtInput"
    private TextField txtInput; // Value injected by FXMLLoader

    @FXML // fx:id="txtOutput"
    private TextArea txtOutput; // Value injected by FXMLLoader

    @FXML
    void handleClearText(ActionEvent event) {
    	txtInput.clear();
    	txtOutput.clear();
    	model.clearText();
    }

    @FXML
    void handleTranslate(ActionEvent event) {
    	String s=txtInput.getText();
    	if(model.inputOk(s)==false) {
    		txtOutput.setText("Non si possono inserire numeri");
    		return;
    	}
    	s.toUpperCase();
    	String output;

    	if(s.contains(" ")) {    		
    		model.aggiungiTraduzione(s);
    		txtInput.clear();
    		txtOutput.clear();
    	}
    	
    	else {
    		output=model.fornisciTraduzione(s);
    		txtOutput.setText(output);
    	}


    }
    
   

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtOutput != null : "fx:id=\"txtOutput\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    public void setModel(Model model) {
    	this.model=model;
    }

}

