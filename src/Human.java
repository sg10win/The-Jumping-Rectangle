//The class represents the human player object
public class Human {
	private	Rectangle humanRect; // the rectangle shape that represent the human player
	private  int Health;  // number of remaining lives
	private  int initalHumanHeight;  // initial player height. When crouching the height is reduced. Height reyurn to normal (inital height) after losing life
	private int humanVelX;// humanVelX the horizontal speed of the player
	private int humanVelY; // humanVelY the vertical speed of the player
	
	public Human (Rectangle rect, int lives, int humanVelX, int humanVelY) { // constructor
		this.humanRect = rect;
		this.Health = lives;
		this.initalHumanHeight = rect.getHight();
		this.humanVelX = humanVelX;
		this.humanVelY = humanVelY;
	}

	public void move (int distanceX, int distanceY) { // move the player
		this.humanRect.setX( this.humanRect.getX()+distanceX ); 
		this.humanRect.setY( this.humanRect.getY()+distanceY );
	}
	
	public boolean isDead(){ // return true if remaining lives reach zero
		if(this.Health == 0)
			return true;
		return false;
	}
		// AFter losing life, player return to its inital location and size per the game level
		// return true if player is dead (no more remaining lives)
	public boolean reduceLife (boolean isKiling ,Board b1) { 
	
		if (isKiling == true) {
			this.Health --;
			this.humanRect.setX(b1.getStartX());
			this.humanRect.setY(b1.getStartY());
			this.humanRect.setHight(this.initalHumanHeight);
			if (this.Health <= 0) {
				this.Health = 0;
				return true;
			}
		}

		return false;
	}

	public void setX(int newX) {

		this.humanRect.setX( newX );
	}
	public void setY(int newY) {

		this.humanRect.setY( newY );
	}

	public int getX() {
		return this.humanRect.getX();
	}	
	public int getY() {
		return this.humanRect.getY();
	}	
	public int getWidth() {
		return this.humanRect.getWidth();
	}	
	public void setWidth(int newWidth) {

		this.humanRect.setWidth( newWidth );
	}

	public int getHeight() {
		return this.humanRect.getHight();
	}	
	public void setHeight(int newHight) {

		this.humanRect.setHight( newHight );
	}
	public void setHealth(int Health) {

		this.Health = Health;
	}

	public int getHealth() {
		return this.Health;
	}

	public int getHumanVelX()
	{
		return this.humanVelX;
	}

	public void setHumanVelX(int humanVelX)
	{
		this.humanVelX = humanVelX;
	}

	public int getHumanVelY()
	{
		return this.humanVelY;
	}

	public void setHumanVelY(int humanVelY)
	{
		this.humanVelY = humanVelY;
	}	

}
