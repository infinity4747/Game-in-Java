import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.*;
import javafx.event.ActionEvent;
public class Game extends Application{
	private  static Map map;
	MyPlayer player;
	Food food;
	public void start(Stage primaryStage)throws FileNotFoundException{
		player = new MyPlayer(map);
		//food= new Food(map,player);
		/*map.setOnKeyPressed(e->{
			switch(e.getCode()){
				case DOWN:
					player.MoveDown();
					break;
				case UP:
					player.MoveUp();
					break;
				case RIGHT:
					player.MoveRight();
					break;
				case LEFT:
					player.MoveLeft();
					break;
			}
		});*/
		BFSBot t =new BFSBot(map);
		Scene scene= new Scene(map);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		//map.requestFocus();
				
	}
	public static void main(String[]args) throws FileNotFoundException{
		map= new Map(args[0]);
		launch(args);
	}
	public class A implements Runnable {
		public void run(){
			System.out.println(food.getPosition().getX());
		}
	}
}