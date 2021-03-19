package com.kumar;

import com.kumar.controller.WordartController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


/**
 * JavaFX WordArt
 */
public class WordArt extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/kumar/resources/Wordartui.fxml"));
			root = loader.load();
			
			WordartController controller = loader.getController();
		    controller.setHostServices(getHostServices());
		    
			Scene scene = new Scene(root,800,600);
			primaryStage.setScene(scene);
			primaryStage.setTitle("WordArt by Kumar Dhakal");
			primaryStage.setResizable(false);
			
			primaryStage.show();			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

    public static void main(String[] args) {
        launch();
    }

}