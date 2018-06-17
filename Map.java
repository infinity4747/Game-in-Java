import javafx.scene.layout.Pane;
import java.io.*;
import java.util.Scanner;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
public  class Map extends Pane{
	private int unit=20;
	private int size;
	private int[][] map;
	private Position start;
	
	public Map(String fileName) throws FileNotFoundException{//construction
		File file = new File(fileName);
		Scanner input= new Scanner(file);//go in to file
		size = input.nextInt();//give size that it is first number
		map = new int[size][size];//create map with this size
		int i=0;//row
		int j=0;//column
		while(input.hasNext()){
			int number = input.nextInt();//
			map[j][i]=number;//give variable in to map
			
			Rectangle r=  new Rectangle(j*unit,i*unit,unit,unit);// in all case we create rectangle 
			switch(number){
				case 1:{
					r.setFill(Color.BLACK);//pain the rectangle to black
					break;
				}
				case 2:{
					start = new Position(i,j);
					r.setFill(Color.WHITE);// do rectangle  white
				r.setStroke(Color.BLACK);//remove positio0n
					break;
				}
				case 0:{
				r.setFill(Color.WHITE);// do rectangle  white
				r.setStroke(Color.BLACK);	
				}
			}
			getChildren().add(r);
			j++;//column increase
			if(j==size){
				j=0;//if it  equal to size, it``111 
				i++;
			}
			
		}
	}
	public int getUnit(){return unit;}// return unit

	public int getSize(){return size;}//return size
	public int[][] getMap(){return map;}//return map
	public Position getStartPosition(){return start;} //return start position
}
		