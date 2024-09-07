import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Font;
import java.lang.Math;
//The class represents rectangle object
public class Rectangle {
	private int hight;
	private int width;
	private int x;
	private int y;
	private Color c1;



	public Rectangle(int x, int y,int width,int hight,  Color c1) {
		this.hight=hight;
		this.width=width;
		this.x=x;
		this.y=y;
		this.c1=c1;
	}


	public void setHight(int hight) {

		this.hight = hight;
	}

	public int getHight() {
		return this.hight;
	}	

	public void setWidth(int width) {

		this.width = width;
	}

	public int getWidth() {
		return this.width;
	}	

	public void setX(int x) {

		this.x = x;
	}

	public int getX() {
		return this.x;
	}	

	public void setY(int y) {

		this.y = y;
	}

	public int getY() {
		return this.y;
	}	

	public void setC1(Color c1) {

		this.c1 = c1;
	}

	public Color getC1() {
		return this.c1;
	}	

//	boolean draw(Graphics g) {
//		
//		super.pa 
//
//		Rectangle rectangle = new Rectangle(x, y, 25, hight, Color.green);
//		Human player = new Human(rectangle);
//		java.awt.Rectangle human=new java.awt.Rectangle(this.getHight(), this.getWidth(), this.getX(), this.getY());
//		//creating the  RectangleObstacle object
//		Rectangle r=new Rectangle(600, 605, 20, 70, Color.green);		
//		java.awt.Rectangle r1=new java.awt.Rectangle(r.getHight(),r.getWidth(),r.getX(),r.getY());
//		RectangleObstacle Obstacle=new RectangleObstacle(r,true);
//
//
////		crating RectangleObstacle object
//		Rectangle r2=new Rectangle(777, 605,41,33,Color.green);		
//		java.awt.Rectangle r3=new java.awt.Rectangle(r2.getHight(),r2.getWidth(),r2.getX(),r2.getY());
//		RectangleObstacle Obstacle1=new RectangleObstacle(r2,true);
//
//		Rectangle[] theRects=new Rectangle[3];
//		BallObstacle[] balls=new BallObstacle[3];
//		RectangleObstacle[] theRectsHits=new RectangleObstacle[3];
//		java.awt.Rectangle[] theRectsPaints=new java.awt.Rectangle[3];
//		//creating board object
//		Board[] Boards=new Board[2];
//		Board Board1=new Board(427,595,1111,theRectsHits,balls);
//		Graphics2D g2 = (Graphics2D) g;
//		Color C1=new Color(197,140,50);
//
//		g.setColor(C1);
//		g.fillRect(455, 0,1360,25);
//		g.fillRect(0, 675,1360,25);
//		g2.setFont(new Font("Times New Roman",Font.PLAIN,20));
//		g.drawString("welcome to dungen     OmerAndSegevGame", 960/2,44);
//		g.drawString("to move right push the right arrow button", 670,58);
//		g.drawString("to move left push the left arrow button", 670,81);
//		g.drawString("to jump push the up arrow button", 670,104);
//		g.drawString("to crouch push the down arrow button", 670,127);
//		g.drawString("when you in the air you can move left and right but you cat crouch", 666,150);
//
//		g.fillRect(0, 0,424,760);
//		g.setColor(Color.blue);
//		g.fillRect(x, y, 25, hight);
//
//
//		g2.fill(human);
//		g2.draw(r3);
//
//		Game gg=new Game(player,Boards);
//		g2.draw(r1);
//		if(r1.intersects(human)&& a) {
//			a=false;
//
//			player.ruduceLife(Obstacle.isTouch(player),Board1 );
//			x=Board1.getStartX();
//			y=Board1.getStartY();
//
//		}
//		a=true;
//
//
//		if(r3.intersects(human)&& a) {
//			a=false;
//			player.ruduceLife(Obstacle.isTouch(player), Board1);
//			x=Board1.getStartX();
//			y=Board1.getStartY();
//		}
//		a=true;
//		if(player.isDead()){
//			g.clearRect(0, 0, sizex, sizey);
//			g2.setFont(new Font("Times New Roman",Font.PLAIN,33));
//			g2.drawString("you lose loser", 680, 363);
//		}
//		g2.drawString(" "+player.getHealth(), 100, 100);
//
//	}
}




