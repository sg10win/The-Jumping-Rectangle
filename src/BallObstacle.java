//The class represents ball obstacle object
public class BallObstacle
{
	private int diameter;
	private int x; //x cordinate of the upper left corner of the square souronding the ball
	private int y; //y cordinate of the upper left corner of the square souronding the ball
	private int ballVelX; // horizontal velocity
	private int ballVelY; // vertical velocity
	private int startX;   // inital x location of the ball when the player start each new level
	private int startY;   // inital y location of the ball when the player start each new level
	private int startBallVelX; // inital horizontal velocity of the ball when the player start each new level
	private int startBallVelY; // inital vertical velocity of the ball when the player start each new level
	private boolean isKiling;  // generic property of the ball. Indicate if the player lose life when thouch the player

	public BallObstacle (int x,int y,int dimater,int ballVelX,int ballVelY, boolean isKiling){  // constructor
		this.x=x;
		this.y=y;
		this.diameter=dimater;
		this.ballVelX=ballVelX;
		this.ballVelY=ballVelY;
		this.startX=x;
		this.startY=y;
		this.startBallVelX=ballVelX;
		this.startBallVelY=ballVelX;
		this.isKiling=isKiling;
	}
	public boolean isTouch (Human player) { //return true if the ball touch the human player)
		if ( ((this.x <= player.getX() && this.x +this.diameter>=player.getX()) ||
				(this.x <= player.getX() + player.getWidth() && this.x+this.diameter >= player.getX()+player.getWidth()) ||
				(this.x >= player.getX() && this.x+this.diameter <= player.getX() + player.getWidth()))
				&&
				((this.y <= player.getY() &&this. y+ this.diameter >= player.getY()) || 
						(this.y <= player.getY() + player.getHeight() && this.y+this.diameter >= player.getY() + player.getHeight()) ||
						(this.y >= player.getY() && this.y+this.diameter <= player.getY() + player.getHeight()))
		) {
			return true;
		} else
			return false;
	}
	public void reset (){ // return the ball to its initial state after player lose life
		this.x=this.startX;
		this.y=this.startY;
		this.ballVelX=this.startBallVelX;
		this.ballVelX=this.startBallVelY;
	}
	public void move () { // each call move the ball per ballVelX an ballVerY variables
		if(this.x>=1328)  // whan reaching the right screen border, change direction toward left
			this.ballVelX=-this.ballVelX;
		if(this.x<=425) // whan reaching the left screen border, change direction toward right
			this.ballVelX=-this.ballVelX;
		if(this.y>=655) // whan reaching the bottom screen border, change direction toward up
			this.ballVelY=-this.ballVelY;
		if(this.y<=25) // // whan reaching the upper screen border, change direction toward down
			this.ballVelY=-this.ballVelY;
		this.setX(this.x+this.ballVelX );
		this.setY( this.y+this.ballVelY );

	}

	public int getX() {
		return this.x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return this.y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getDiameter() {
		return this.diameter;
	}

	public void setDiameter(int diameter) {
		this.diameter = diameter;
	}
	public boolean isKiling()
	{
		return this.isKiling;
	}
	public void setKiling(boolean isKiling)
	{
		this.isKiling = isKiling;
	}

}

