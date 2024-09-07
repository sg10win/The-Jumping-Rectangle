
public class RectangleObstacle { // rectangle obstacle is not moving (unlike ball obstacle)
	private Rectangle rect;
	private boolean isKiling; // generic property of the rectangle obstacle. Indicate if the player lose life when thouch the player
//	The class represents rectangleObtacle object
	public RectangleObstacle (Rectangle rect, boolean isKiling) { // constructor
		this.rect = rect;
		this.isKiling = isKiling;
	}
	
// handleNonKillingRect handle the interaction between human player and non-killing rectangle obstacles 
	public void handleNonKillingRect(Human h) {

		// handle the case where human right edge touch obstacle left edge
		if (isTouch(h) && (h.getX()+h.getWidth() == this.rect.getX()) && (h.getHumanVelX() > 0)) {
			h.setHumanVelX(0);
			h.move(-1,0);
		}
//		 handle the case where human left edge touch obstacle right edge
		if (isTouch(h) && (h.getX()== this.rect.getX()+this.rect.getWidth()) && (h.getHumanVelX() < 0)) {
			h.setHumanVelX(0);
			h.move(1,0);
		}
		
//		 handle the case where human lower edge touch obstacle upper edge
		if (isTouch(h) && (h.getY()+h.getHeight() == this.rect.getY()) && (h.getHumanVelY() > 0)) {
			h.setHumanVelY(0);
			h.move(0,-1);
		}
		
//		 handle the case where human upper edge touch obstacle lower edge
		if (isTouch(h) && (h.getY()== this.rect.getY()+this.rect.getHight()) && (h.getHumanVelY() < 0)) {
			h.setHumanVelY(1);
			h.move(0,1);
		}

		if (isTouch(h) == false && (h.getX()+h.getWidth() == this.rect.getX()-1) && (h.getHumanVelX() < 0)) {
			h.setHumanVelY(1);
		}
		if (isTouch(h) == false && (h.getX()-1 == this.rect.getX()+this.rect.getWidth()) && (h.getHumanVelX() > 0)) {
			h.setHumanVelY(1);
		}
	}



	public boolean isTouch (Human player) { //return true if the rectangle obstacle touch the human player)
		if ( ((this.rect.getX() <= player.getX() && this.rect.getX() + this.rect.getWidth() >= player.getX()) ||
				(this.rect.getX() <= player.getX() + player.getWidth() && this.rect.getX()+this.rect.getWidth() >= player.getX()+player.getWidth()) ||
				(this.rect.getX() >= player.getX() && this.rect.getX()+this.rect.getWidth() <= player.getX() + player.getWidth()) ) 
				&&
				((this.rect.getY() <= player.getY() && this.rect.getY() + this.rect.getHight() >= player.getY()) || 
						(this.rect.getY() <= player.getY() + player.getHeight() && this.rect.getY()+this.rect.getHight() >= player.getY() + player.getHeight()) ||
						(this.rect.getY() >= player.getY() && this.rect.getY()+this.rect.getHight() <= player.getY() + player.getHeight()) )
		) {
			return true;
		} else
			return false;
	}
	public Rectangle getRect() {
		return this.rect;
	}

	public void setRect(Rectangle r1) {
		this.rect=r1;
	}
	public int getX() {
		return this.rect.getX();
	}

	public void setX(int x) {
		x=this.rect.getX();
	}
	public int getY() {
		return this.rect.getY();
	}

	public void setY(int y) {
		y = this.rect.getY();
	}
	public boolean isKiling() {
		return this.isKiling;
	}

	public void setKiling(boolean isKiling) {
		this.isKiling=isKiling;
	}
	public int getWidth() {
		return this.rect.getWidth();
	}

	public void setWidth(int Width) {
		Width=this.rect.getWidth();
	}
	public int getHeight() {
		return this.rect.getHight();
	}

	public void setHeight(int Hight) {
		Hight=this.rect.getHight();
	}
}
