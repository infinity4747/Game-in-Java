import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import java.io.*;
public class Test extends Application{
	public void start(Stage primeryStage) throws FileNotFoundException{
		Map map= new Map("map.txt");
		
		Scene scene = new Scene(map);
		primeryStage.setScene(scene);
		primeryStage.show();
}}
	