package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Main Window");
			
			FXMLLoader loader = new FXMLLoader();
			
			loader.setLocation(Main.class.getResource("/PlaceOrder.fxml"));
			
			AnchorPane mainLayout = (AnchorPane)loader.load();
			
			Scene scene = new Scene(mainLayout);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Order Coffee");
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main (String[] args) {
		launch(args);
	}
		
}
