import javafx.scene.shape.*;
public class BotPlayer{
	private MyPlayer player;
	private Position position;
	private Map map;
	private Food food;
	private Circle ball;
	BotPlayer(Map map,Food food){ this.map = map; this.food =food;
		int i= position.getX();
		int j = position.getY();
		while(i!=food.getPosition().getX() && j!=food.getPosition().getY()){
			if (i!=food.getPosition().getX()){
				i++;
				ball.setCenterX(ball.getCenterX()+map.getUnit());
			}
			else{
				j++;
				ball.setCenterY(ball.getCenterY()+map.getUnit());
			}
		}
	
	}
}
	
	