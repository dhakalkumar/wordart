package com.kumar.controller;

import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.application.HostServices;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.robot.Robot;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class WordartController {

	@FXML
	private TextField textField;
	
	@FXML private Label wordart;
	
	@FXML private Button enterKey;

	@FXML
	private ComboBox<String> fontComboBox, imageTypeComboBox;

	@FXML
	private ColorPicker fontColorPicker, dropShadowColorPicker;

	@FXML
	private Slider fontSizeSlider, dropShadowSizeSlider;

	@FXML
	private Button saveButton;
	
//	@FXML private MenuItem aboutMenuItem;
	
	@FXML
	private Hyperlink email;
	@FXML
	private Hyperlink githubLink;
	
	 private HostServices hostServices ;

	    public HostServices getHostServices() {
	        return hostServices ;
	    }

	    public void setHostServices(HostServices hostServices) {
	        this.hostServices = hostServices ;
	    }
	

	@FXML
	void initialize() {
		// fill up the combo boxes
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

		String[] fontNames = ge.getAvailableFontFamilyNames();

		for (int i = 0; i < fontNames.length; i++) {
			fontComboBox.getItems().add(fontNames[i]);
		}
		fontComboBox.setValue("Times New Roman"); // initially selected value

		imageTypeComboBox.getItems().addAll(".PNG", ".JPEG", ".BMP", ".GIF");
		imageTypeComboBox.setValue(".PNG"); // initially selected value

	}

	public void saveButtonController() throws FileNotFoundException {
		FileChooser saveDialog = new FileChooser();
		saveDialog.getExtensionFilters().addAll(new ExtensionFilter("PNG file", "*.png"),
				new ExtensionFilter("JPEG file", "*.jpeg"), new ExtensionFilter("BMP file", "*.bmp"),
				new ExtensionFilter("GIF file", "*.gif"));

		Robot robot = new Robot();
		WritableImage imgOut = new WritableImage(800, 332);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		WritableImage imgReturn = robot.getScreenCapture(imgOut, new Rectangle2D(0, 0, 800, 332));

		File file = saveDialog.showSaveDialog(null);
		String extension = imageTypeComboBox.getValue().substring(1).toLowerCase();

		if (file != null) {

			try {
				ImageIO.write(SwingFXUtils.fromFXImage(imgReturn, null), extension, file);
//				System.out.println("image saved");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

				Alert fileSaveError = new Alert(AlertType.ERROR);
				fileSaveError.setHeaderText(null);
				fileSaveError.setContentText("There was an error saving the file. Please try again!");
				fileSaveError.showAndWait();
			}
		}
	}
	
	public void enterKeyController() {
		wordart.setText(textField.getText());
		wordart.setPrefWidth(textField.getText().length());
		textField.setText("");
		
	}
	
	public void aboutMenuController() {
		BorderPane aboutScreen = new BorderPane();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/kumar/resources/About.fxml"));
		HostServices service = app.getHostServices();
		
		AboutController aboutController = loader.getController();
		aboutController.setHostServices(hostServices);
        
		Scene aboutScene = new Scene(aboutScreen, 600, 400);
		Stage aboutStage = new Stage();
		aboutStage.setScene(aboutScene);
		aboutStage.setTitle("About WordArt");
		aboutStage.setResizable(false);

		email.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				service.showDocument("mailto:dhakalkumar20@gmail.com");
			}
		});
		
		githubLink.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				service.showDocument("https://www.github.com/dhakalkumar");
			}
		});
		aboutStage.show();
	}
}
