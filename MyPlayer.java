import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.shape.*;
import javafx.scene.paint.Color;
public class MyPlayer implements Player{
	private Circle ball;
	private Map map;
	private Position position;
	
	public MyPlayer(Map map){
		this.map= map;
		position = map.getStartPosition();
		ball= new Circle(position.getX()*map.getUnit()+(map.getUnit()/2),position.getY()*map.getUnit()+(map.getUnit()/2),map.getUnit()/2);//create circle 
		ball.setFill(Color.RED);
		ball.setStroke(Color.BLACK);
		map.getChildren().add(ball);
	}
	public void MoveLeft(){
		int i = position.getX();
		int j= position.getY();
		
		try{ if (position.getX()>=0){//if it biger than 0
			if (map.getMap()[i-1][j]!=1){//if next rectangle is black or not
				position.setX(position.getX()-1);//change position x
				ball.setCenterX(ball.getCenterX()-map.getUnit());//change center;
			}
			else
				System.out.println("You can not go in this side");
		}
		}
		catch (ArrayIndexOutOfBoundsException e){
			System.out.println("You can not go in this side");
		}
	}
	public void MoveRight(){
		int i = position.getX();
		int j= position.getY();
		try{
			if (position.getX()!=(map.getSize()-1)){
				if (map.getMap()[i+1][j]!=1){
					position.setX(position.getX()+1);
					ball.setCenterX(ball.getCenterX()+map.getUnit());
				}
				else
					System.out.println("You can not go in this side");
			}
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("You can not go in this side");
		}
	}
	public void MoveUp(){
		int i = position.getX();
		int j= position.getY();
		try{if (position.getY()>0){
			if (map.getMap()[i][j-1]!=1){
				position.setY(position.getY()-1);
				ball.setCenterY(ball.getCenterY()-map.getUnit());
			}
			else
			System.out.println("You can not go in this side");
		}
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("You can not go in this side");
		}
	}
	public void MoveDown(){
		int i = position.getX();
		int j= position.getY();
		try{
		if (position.getY()!=(map.getSize()-1)){
			if (map.getMap()[i][j+1]!=1){
				position.setY(position.getY()+1);
				ball.setCenterY(ball.getCenterY()+map.getUnit());
			}
			else
			System.out.println("You can not go in this side");
		}
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("You can not go in this side");
		}
	}
	public Position getPosition(){
		return position;
	}
}