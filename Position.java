public class Position{
	private int x;
	private int y;
	
	public Position(int a,int b){this.x=a;this.y =b;} // Construction to Position
	
	public int getX(){return x;}// return x 
	public int getY(){return y;}//return y
	
	public void setX(int x){this.x =x;}//change the variable x
	public void setY(int y){this.y=y;}	//change the variable y
	public boolean equals(Position other){
		return (other.getX() == x && other.getY() == y);
	}

}