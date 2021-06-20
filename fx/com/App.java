package fx.com;

import java.net.URL;

import javafx.application.Application;
//import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Scene scene = new Scene(new MyGridPane(primaryStage));
		primaryStage.setScene(scene);
		
		URL url = App.this.getClass().getProtectionDomain().getCodeSource().getLocation();
		
		Image img = new Image(url.toExternalForm() + "img/xyy1.png");
		
		primaryStage.getIcons().add(img);
		
		primaryStage.setTitle("URLTRANS");
		primaryStage.setWidth(840);
		primaryStage.setHeight(460);
		primaryStage.setResizable(false);
		
		primaryStage.show();
//		Platform.exit();
		
	}

}
