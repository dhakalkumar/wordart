package com.kumar.controller;

import java.awt.GraphicsEnvironment;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javax.imageio.ImageWriter;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.stage.FileChooser;

public class WordartController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML private ComboBox<String> fontComboBox, imageTypeComboBox;
    
    @FXML private ColorPicker fontColorPicker, dropShadowColorPicker;
    
    @FXML private Slider fontSizeSlider, dropShadowSizeSlider;
    
    @FXML private Button saveButton;
    
    @FXML
    void initialize() {
    	// fill up the combo boxes
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
 
        String []fontNames=ge.getAvailableFontFamilyNames();
        
        for (int i = 0; i<fontNames.length; i++) {
            fontComboBox.getItems().add(fontNames[i]);
        }
        
        imageTypeComboBox.getItems().addAll(".PNG", ".JPG", ".JPEG", ".BMP");
    }
    
    public void saveButtonController() {
    	FileChooser saveDialog = new FileChooser();
    	saveDialog.showSaveDialog(null);
    	File file = new File(saveDialog.toString());
    	
    	if(file != null) {
    		// TODO use Imagewriter to save the file
    		ImageWriter imageWriter = null;
    		String filename = file.getName() + imageTypeComboBox.getValue().toLowerCase();
    		
    		
    	} else {
    		Alert fileSaveError = new Alert(AlertType.ERROR);
    		fileSaveError.setHeaderText(null);
    		fileSaveError.setContentText("There was an error saving the file. Please try again!");
    		fileSaveError.showAndWait();
    		
    	}
    	
    	
    }
}
