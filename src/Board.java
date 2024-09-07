//The class represents board object
public class Board {
	private RectangleObstacle[] RectanglesArray; // the rectangle obstacles of the board (level)
	private BallObstacle[] BallsArray; // the ball obstacles of the board (level)
	private int startX;  // human player starting location (x cordinate) for the board
	private int startY;  // human player starting location (y cordinate) for the board
	private int endX;    // when player reach that vertical location, he complete successfully this level and pass to next level

	public Board(int startX,int startY,int endX,RectangleObstacle[] RectanglesArray,BallObstacle[] BallsArray) { //constructor
		this.RectanglesArray=RectanglesArray;
		this.BallsArray=BallsArray;
		this.startX=startX;
		this.startY=startY;
		this.endX=endX;
	}
	
	public int getStartX() {
		return this.startX;
	}

	public void setStartX(int startX) {
		this.startX = startX;
	}

	public int getStartY() {
		return this.startY;
	}

	public void setStartY(int startY) {
		this.startY = startY;
	}

	public int getEndX() {
		return this.endX;
	}

	public void setEndX(int endX) {
		this.endX = endX;
	}
	public RectangleObstacle[] getRectanglesArray() {
		return this.RectanglesArray;
	}

	public void setRectanglesArray(RectangleObstacle[] rectanglesArray) {
		this.RectanglesArray = rectanglesArray;
	}

	public BallObstacle[] getBallsArray() {
		return this.BallsArray;
	}

	public void setBallsArray(BallObstacle[] ballsArray) {
		this.BallsArray = ballsArray;
	}
}


