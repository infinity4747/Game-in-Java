import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import javafx.application.Platform;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
public class BFSBot implements Player{
	private Circle ball;
    private Position position;
    private Map map;
    private int size;
    private int[][] intmap;
    private Pane BotPane;
    private Food food;
    private int unit;
    public BFSBot(Map map1){
    	
        this.map = map1;
        this.BotPane = new Pane();
        this.map.getChildren().add(this.BotPane);
        this.size = map.getSize();
        this.intmap = map.getMap();
        this.position = map.getStartPosition();
        this.food = new Food(map,this);
        this.unit = map.getUnit();
        Thread thread = new Thread(() -> {
        	this.createBot();	
        	Platform.runLater(() -> {
                this.BotPane.getChildren().add(this.ball);
            }
            );
        	for(int i = 0; i<10;i++){
            		
	                
	                
	           
	                ArrayList<Position> path = getPath();
	                move(path);
	                try{
	                	Thread.sleep(1000);
	                }
	                catch(InterruptedException ex){}
					
	               }
                
                
                }        
        );
        thread.start();
    }

    public void MoveRight() {
        int x = position.getX();
        int y = position.getY();
        if(size -1  > y && intmap[x+1][y]!=1 )
        position.setX(x+1);
        ball.setCenterX(ball.getCenterX()+unit);
    }


    public void MoveLeft() {
        int x = position.getX();
        int y = position.getY();
        if( x > 0 && intmap[x-1][y]!=1)
        position.setX(x-1);
        ball.setCenterX(ball.getCenterX()-unit);
    }

   public void MoveUp() {
        int y = position.getY();
        int x = position.getX();
        if( y > 0 && intmap[x][y-1]!=1)
        position.setY(y-1);
        ball.setCenterY(ball.getCenterY()-unit);
    }


    public void MoveDown() {
        int y = position.getY();
        int x = position.getX();
        if(size -1 > y && intmap[x][y+1]!=1)
        position.setY(y+1);
        ball.setCenterY(ball.getCenterY()+unit);
    }

    public Position getPosition() {
        return position;
    }
    private void createBot() {
        double d = this.map.getUnit();
        this.ball = new Circle(position.getY() * d + d / 2.0, position.getX() * d + d / 2.0, d / 4.0);
        this.ball.setFill(Color.YELLOW);
    }
	
	public  ArrayList<Position> getPath(){
		Queue<Position> frontier = new LinkedList<Position>();  
		HashMap<Position, Position> came_from = new HashMap<Position, Position>();
		came_from.put(position, null);
		ArrayList<Position> path= new ArrayList<Position>();
		frontier.offer(position);
		Position current = position;
		while(frontier.size()>0){
			current = frontier.remove();
			if (current.equals(food.getPosition())){		
				break;
			}
			for(Position next : getNeighbours(current)){
				if(!came_from.containsKey(next) ){
						frontier.offer(next);
						came_from.put(next,current);
				}
			}
		}
		while(!current.equals(position)){
			path.add(current);
			current = came_from.get(current);
		}
		return path;
	}
	public ArrayList<Position> getNeighbours(Position pos){
		ArrayList<Position> neighbours = new ArrayList<Position>();
		int x = pos.getX();
		int y = pos.getY();
		 if(size -1  > y && intmap[x][y+1]!=1 )
		        neighbours.add(new Position(x,y+1));
		 if( y > 0 && intmap[x][y-1]!=1)
			 neighbours.add(new Position(x,y-1));
		 if( x > 0 && intmap[x-1][y]!=1)
			 neighbours.add(new Position(x-1,y));
		 if(size -1 > x && intmap[x+1][y]!=1)
			 neighbours.add(new Position(x+1,y));
		return neighbours;
	}
	public void move(ArrayList<Position> path){
		
		int x = position.getX();
		int y = position.getY();
		int size = path.size()-1;
		while(size>=0){
			Position pos = path.get(size);
			if(x-1==pos.getX()){
				MoveUp();
				x--;
				size--;
				try{
                	Thread.sleep(50);
                }
                catch(InterruptedException ex){}
			}
			else if(y-1==pos.getY()){
				MoveLeft();
				size--;
				try{
                	Thread.sleep(50);
                }
                catch(InterruptedException ex){}
				y--;
			}
			else if(x+1==pos.getX()){
				size--;
				MoveDown();
				try{
                	Thread.sleep(50);
                }
                catch(InterruptedException ex){}
				x++;
			}
			else if(y+1==pos.getY()){
				size--;
				MoveRight();
				try{
                	Thread.sleep(50);
                }
                catch(InterruptedException ex){}
				y++;
			}
		}
	}

}
