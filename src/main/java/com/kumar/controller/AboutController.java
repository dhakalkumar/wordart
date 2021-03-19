package com.kumar.controller;

import java.io.IOException;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class AboutController {
	@FXML
	private MenuItem aboutMenuItem;

	@FXML
	private Hyperlink email;
	@FXML
	private Hyperlink githubLink;

	public void aboutMenuController() {

		BorderPane aboutScreen = new BorderPane();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/kumar/resources/About.fxml"));

		Application app = new Application()
		{
			@Override
			public void start(Stage primaryStage) throws Exception {
			}
		};
		HostServices service = app.getHostServices();
		try {
			aboutScreen = loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
