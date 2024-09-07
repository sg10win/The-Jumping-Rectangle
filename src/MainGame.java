import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public  class MainGame extends JPanel implements ActionListener, KeyListener{
	Timer time = new Timer(0,this);//creating Timer

	public MainGame(){//constructor

		this.time.start(); // start sending events to actionPerformed() (listen to events)
		addKeyListener(this); // start reading keyboard events by keyPressed()
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	}
	//for the one more chance
	static boolean oneMore=true;
	static int resets;

	static int sizeX=1360,sizeY=726; // sizeX is the JFrame screen width; sizeY is the JFrame screen height;
	static int speed=1;
	static int lastKeyPressed=-1,  maxHeight;
	static Game game;
	static int lastCurrentTime=0;


	//main
	public static void main (String arge[]) {
		Rectangle rectangleH = new Rectangle( 427, 595, 25, 80, Color.blue); // create the rectangle that will represent the human player
		Human player = new Human(rectangleH, 5,0,0); // create the human player with 5 lives
		MainGame adventure = new MainGame();
		JFrame f = new JFrame("Omer & Segav adventure game");

		// Each array stores all the obstacles (of the same type) in a specifc board (there is a board per each game level).
		// there is a limit of 3 obstacles of the same type (balls or rectangle) in a board
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////3,4
		BallObstacle[] ballsObstacles_board_0, ballsObstacles_board_1, ballsObstacles_board_2, ballsObstacles_board_3, ballsObstacles_board_4;    
		RectangleObstacle[] RectangleObstacles_board_0, RectangleObstacles_board_1, RectangleObstacles_board_2,RectangleObstacles_board_3,RectangleObstacles_board_4;

//		creating the Rectangle objects
		RectangleObstacles_board_0 = new RectangleObstacle[3];
		RectangleObstacles_board_1 = new RectangleObstacle[3];
		RectangleObstacles_board_2 = new RectangleObstacle[3];
		RectangleObstacles_board_3 = new RectangleObstacle[3];
		RectangleObstacles_board_4 = new RectangleObstacle[3];
		//////////////////////////////////////////////////////
		
		

		//		level 1 rectangle obstacles
		RectangleObstacles_board_0[0]=null; 
		RectangleObstacles_board_0[1]=null;
		RectangleObstacles_board_0[2]=null;

		//   	 level 2 rectangle obstacles
		RectangleObstacles_board_1[0]=new RectangleObstacle( new Rectangle(600, 605,20,70, Color.darkGray) ,true);
		RectangleObstacles_board_1[1]=new RectangleObstacle( new Rectangle(777, 605,41,33, Color.darkGray) ,true);
		RectangleObstacles_board_1[2]=new RectangleObstacle( new Rectangle(888, 505,41,70, Color.darkGray) ,false);

		//		 level 3 rectangle obstacles
		RectangleObstacles_board_2[0]=new RectangleObstacle( new Rectangle(600, 605,20,70, Color.green) ,true);
		RectangleObstacles_board_2[1]=new RectangleObstacle( new Rectangle(777, 605,41,33, Color.green) ,true);
		RectangleObstacles_board_2[2]=new RectangleObstacle( new Rectangle(888, 605,41,70, Color.darkGray) ,false);
		
		///////////////////////////////////////
//		 level 4 rectangle obstacles
		RectangleObstacles_board_3[0]=null;
		RectangleObstacles_board_3[1]=null;
		RectangleObstacles_board_3[2]=null;

		//level 5 rectangle obstacles
		
		RectangleObstacles_board_4[0]=new RectangleObstacle( new Rectangle(620, 505,80,200, Color.green) ,false);;
		RectangleObstacles_board_4[1]=new RectangleObstacle( new Rectangle(740, 405,70,300, Color.green) ,false);;
		RectangleObstacles_board_4[2]=new RectangleObstacle( new Rectangle(700, 605,40,100, Color.green) ,true);;
		
		
		
		
		
		
		
		
		
		
		
		//		creating the  BallObstacle objects
		ballsObstacles_board_0=new BallObstacle[3];
		ballsObstacles_board_1=new BallObstacle[3];
		ballsObstacles_board_2=new BallObstacle[3];
		ballsObstacles_board_3=new BallObstacle[3];
		ballsObstacles_board_4=new BallObstacle[3];

		ballsObstacles_board_0[0]=null; // level 1 ball obstacles
		ballsObstacles_board_0[1]=null;
		ballsObstacles_board_0[2]=null;

		ballsObstacles_board_1[0]=null; // level 2 ball obstacles
		ballsObstacles_board_1[1]=null;
		ballsObstacles_board_1[2]=null;

		// level 3 ball obstacles
		ballsObstacles_board_2[0]=new BallObstacle(460,573,22,1,0,true); 
		ballsObstacles_board_2[1]=new BallObstacle(876,550,23,0,1,true);
		ballsObstacles_board_2[2]=new BallObstacle(666,550,24,2,2,true);

		// level 4 ball obstacles
		ballsObstacles_board_3[0]=new BallObstacle(666,550,40,1,4,true);
		ballsObstacles_board_3[1]=new BallObstacle(626,630,40,1,4,true);
		ballsObstacles_board_3[2]=new BallObstacle(586,600,40,1,4,true);
		
		//level 5 ball obstacles
		ballsObstacles_board_4[0]=new BallObstacle(500,380,24,1,0,true);
		ballsObstacles_board_4[1]=null;
		ballsObstacles_board_4[2]=null;
		
		
		Board[] Boards = new Board[5];
		//creating the boards in the array
		Boards[0] = new Board(427,595,sizeX,RectangleObstacles_board_0, ballsObstacles_board_0);
		Boards[1] = new Board(427,595,sizeX,RectangleObstacles_board_1, ballsObstacles_board_1);
		Boards[2] = new Board(427,595,sizeX,RectangleObstacles_board_2, ballsObstacles_board_2);
		Boards[3] = new Board(427,595,sizeX,RectangleObstacles_board_3, ballsObstacles_board_3);
		Boards[4] = new Board(427,595,sizeX,RectangleObstacles_board_4,  ballsObstacles_board_4);
		game = new Game(player, Boards);

		f.setSize(sizeX,sizeY); // set graphic JFrame window size
		f.setVisible(true);     // visible 
		f.setResizable(false); // disable resizing
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(adventure);
	}

//	run continuously in parallel to actionPerfromed, keyPressed & keyReleased
//	This function is drawing the screens and moving all moving obstacles
	public void paint (Graphics g) { 
		int currentTime;
		Human player;
		int currentBoard = game.getCurrentBoard(); // the current level that the player reached 
		super.paint(g);
		Board[] Boards = game.getBoardsArray();
		Graphics2D g2=(Graphics2D)g;
		g.setColor(Color.darkGray);
		player = game.getPlayer(); // human object 
		if (currentBoard == Boards.length){ 
			// end of game ! player passed the last level (board)
			// show a winning message
			g.clearRect(0, 0, sizeX, sizeY);
			g2.setFont(new Font("Times New Roman",Font.PLAIN,33));
			g2.drawString("you win winner", 600, 300);
			g.setColor(Color.red);
			g2.drawString("'R'- reset",70,70);
			// show the the game time.  
			if(lastCurrentTime%60 >= 10)
				g.drawString(""+lastCurrentTime/60+":"+lastCurrentTime%60, 650, 360);
			else 
				g.drawString(""+lastCurrentTime/60+":0"+lastCurrentTime%60, 650, 360);
			g.setColor(Color.darkGray);
			repaint();
			return;
		}

		if (player.isDead()) {
			// end of game. the player lost with no more remaining lives.
			// show losing message

			g.clearRect(0, 0, sizeX, sizeY);//clearing the frame grafics

			g2.setFont(new Font("Times New Roman",Font.PLAIN,33));
			g2.drawString("you lose loser :(", 600, 300);
			g.setColor(Color.red);
			g2.drawString("'R'- Reset",70,70);
			//
			if(oneMore==true)
			g2.drawString("'B'- One more",100,100);
			//	show the the game time. 
			if(lastCurrentTime%60 >= 10)
				g.drawString(""+lastCurrentTime/60+":"+lastCurrentTime%60, 650, 360);
			else 
				g.drawString(""+lastCurrentTime/60+":0"+lastCurrentTime%60, 650, 360);
			g.setColor(Color.darkGray);
			repaint();
			return;
		}

		// the below section moves ball obstacles (only ball obstacles are moving) if exist in the current board (level)
		for (int i = 0; i < Boards[currentBoard].getBallsArray().length; i++) {
			if (Boards[currentBoard].getBallsArray()[i] != null ) {
				Boards[currentBoard].getBallsArray()[i].move();
				g.fillArc(Boards[currentBoard].getBallsArray()[i].getX(), Boards[currentBoard].getBallsArray()[i].getY(), 
						Boards[currentBoard].getBallsArray()[i].getDiameter(), 
						Boards[currentBoard].getBallsArray()[i].getDiameter(), 0, 360);
			}
		}
		// prepare the graphic for the human player rectangle
		java.awt.Rectangle playerGraphix = 
			new java.awt.Rectangle(player.getX(), player.getY(), player.getWidth(), player.getHeight());
		g.setColor(Color.darkGray);

		// draw the rectangle obstacles if exist in the current board (level)
		if (Boards[currentBoard].getRectanglesArray()[0] != null ) {
			java.awt.Rectangle graphicsRectObstacle1 = 
				new java.awt.Rectangle(Boards[currentBoard].getRectanglesArray()[0].getX(), 
						Boards[currentBoard].getRectanglesArray()[0].getY(),
						Boards[currentBoard].getRectanglesArray()[0].getWidth(), 
						Boards[currentBoard].getRectanglesArray()[0].getHeight());
			if(Boards[currentBoard].getRectanglesArray()[0].isKiling()==false)
				
				g2.fill(graphicsRectObstacle1);
				
			else
				g2.setColor(Color.red);
				g2.fill(graphicsRectObstacle1);
				g2.setColor(Color.darkGray);
			if (Boards[currentBoard].getRectanglesArray()[0].isKiling()==false)
				game.getBoardsArray()[currentBoard].getRectanglesArray()[0].handleNonKillingRect(player);
		}
		if (Boards[currentBoard].getRectanglesArray()[1] != null ) {
			java.awt.Rectangle graphicsRectObstacle2 =
				new java.awt.Rectangle(Boards[currentBoard].getRectanglesArray()[1].getX(),
						Boards[currentBoard].getRectanglesArray()[1].getY(),
						Boards[currentBoard].getRectanglesArray()[1].getWidth(),
						Boards[currentBoard].getRectanglesArray()[1].getHeight());
			if(Boards[currentBoard].getRectanglesArray()[1].isKiling()==false)
				g2.fill(graphicsRectObstacle2);
			else
				g2.setColor(Color.red);
			g2.fill(graphicsRectObstacle2);
			g2.setColor(Color.darkGray);
			if (Boards[currentBoard].getRectanglesArray()[1].isKiling()==false)
				game.getBoardsArray()[currentBoard].getRectanglesArray()[1].handleNonKillingRect(player);
		}

		if (Boards[currentBoard].getRectanglesArray()[2] != null ) {
			java.awt.Rectangle graphicsRectObstacle2 =
				new java.awt.Rectangle(Boards[currentBoard].getRectanglesArray()[2].getX(),
						Boards[currentBoard].getRectanglesArray()[2].getY(),
						Boards[currentBoard].getRectanglesArray()[2].getWidth(),
						Boards[currentBoard].getRectanglesArray()[2].getHeight());
			if(Boards[currentBoard].getRectanglesArray()[2].isKiling()==false)
				g2.fill(graphicsRectObstacle2);
			else
				g2.setColor(Color.red);
			g2.fill(graphicsRectObstacle2);
			g2.setColor(Color.darkGray);
			if (Boards[currentBoard].getRectanglesArray()[2].isKiling()==false)
				game.getBoardsArray()[currentBoard].getRectanglesArray()[2].handleNonKillingRect(player);//check mportnt
		}
		g.fillRect(455, 0,1360,25); // upper graphic square that block movement toward the upper screen border
		g.fillRect(0, 675,1360,25); // lower graphic square that block movement toward the lower screen border
		g2.setFont(new Font("Times New Roman",Font.PLAIN,20));
		g.drawString("welcome to dungen        Level "+(currentBoard+1), 960/2,44); // show current level
		if(currentBoard==0){ // display game instructions only for the first board
			g.drawString("You pass each level by avoiding rectangle and ball obstacles", 670,78);
			g.drawString("and reaching the right boarder of the screen", 670,101);
			g.drawString("right:  right arrow button", 670,124);
			g.drawString("left:   left arrow button", 670,147);
			g.drawString("jump:   up arrow button", 670,170);
			g.drawString("crouch: down arrow button", 670,193);
			g.drawString("when you in the air you can move left and right but you can't crouch", 670,216);
			g.drawString("'R' for restart the game", 670,239);
		}


		g.fillRect(0, 0,424,760); // left graphic square that block movement toward the left screen border
		g.setColor(Color.blue);
		g2.fill(playerGraphix);
		g.setColor(Color.blue);

		// the below section checks if the human player is touching a killing obstacle and reduce life when it happen.
		// when reducing life all obstacles return to their ininital location and velocity
		for (int i = 0; i < Boards[currentBoard].getRectanglesArray().length; i++) {
			if (   
					(Boards[currentBoard].getRectanglesArray()[i] != null && 
							Boards[currentBoard].getRectanglesArray()[i].isKiling() && 
							Boards[currentBoard].getRectanglesArray()[i].isTouch(player)) ||
							(Boards[currentBoard].getBallsArray()[i] != null && 
									Boards[currentBoard].getBallsArray()[i].isKiling() && 
									Boards[currentBoard].getBallsArray()[i].isTouch(player))) 
			{
				player.reduceLife(true,Boards[currentBoard]);
				// Returns balls obstacles to their initial positions in that board
				for (int j = 0; j < Boards[currentBoard].getBallsArray().length; j++) {

					if (Boards[currentBoard].getBallsArray()[j] != null)
						Boards[currentBoard].getBallsArray()[j].reset();
				}
			}
		}
		// calculate and show game time (the time that passed from the start of the game)
		currentTime=game.timeM()*60+game.timeS()-game.getStartTime();
		if(currentTime < 0){ //lastCurrentTime
			currentTime = currentTime+3600;
		}
		lastCurrentTime=currentTime;
		g.setColor(Color.RED);
		g2.setFont(new Font("Times New Roman",Font.PLAIN,33));

		if(currentTime%60 >= 10)
			g.drawString(""+currentTime/60+":"+currentTime%60, 200, 150);
		else 
			g.drawString(""+currentTime/60+":0"+currentTime%60, 200, 150);

		g.setColor(Color.darkGray);
		g2.setFont(new Font("Times New Roman",Font.PLAIN,20));
		g.setColor(Color.RED) ;

		g2.setFont(new Font("Times New Roman",Font.PLAIN,33));
		g2.drawString("remaining lives: "+player.getHealth(), 100, 100);//hp
		g2.setFont(new Font("Times New Roman",Font.PLAIN,20));
		repaint();
	}
public void actionPerformed(ActionEvent e) {  
		Human player;

		if (game == null || game.getCurrentBoard() == game.getBoardsArray().length)
			return;
		Board[] Boards = game.getBoardsArray();
		int currentBoard = game.getCurrentBoard();

		player = game.getPlayer(); // human object 

		if(player.getX() < 425){
			player.setHumanVelX(0);
			player.setX(425);
		}

		if(player.getY()+player.getHeight()< 620 && player.getHumanVelY() == 0){
			player.setHumanVelY(speed);

		}

		if(player.getY() <= maxHeight) {
			if (player.getHumanVelY() == -speed)
				player.setHumanVelY(speed);
		}
		if(player.getY() >= 595) {
			if (player.getHumanVelY() == speed)
				player.setHumanVelY(0);
		}
		player.move(player.getHumanVelX(), player.getHumanVelY());
		if( Boards[currentBoard].getEndX() == player.getX()+player.getWidth()){
			game.setCurrentBoard( currentBoard+1 );
			if( currentBoard+1 < Boards.length){
				game.getPlayer().setX(Boards[ currentBoard+1].getStartX());	
				game.getPlayer().setY(Boards[ currentBoard+1].getStartY());	
			}
		}
	}
	public void keyPressed(KeyEvent k1){
		int key;
		Human player;
//
		player = game.getPlayer(); // human object 
		key=k1.getKeyCode();
		if(key==KeyEvent.VK_R) {
			game.startAgain();
			lastCurrentTime=0;
			oneMore=true;
			resets++;
		}
		//reset the level
		
		if(key==KeyEvent.VK_B&&oneMore&&player.isDead()){
			player.setHealth(1);
			player.setX(game.getBoardsArray()[game.getCurrentBoard()].getStartX());
			player.setY(game.getBoardsArray()[game.getCurrentBoard()].getStartY());
		 
			
			for (int j = 0; j < game.getBoardsArray()[game.getCurrentBoard()].getBallsArray().length; j++) {

				if (game.getBoardsArray()[game.getCurrentBoard()].getBallsArray()[j] != null){
					game.getBoardsArray()[game.getCurrentBoard()].getBallsArray()[j].reset();
				}
					
			}
			oneMore=false;
		}
	
			
	
		if (lastKeyPressed != KeyEvent.VK_DOWN&&lastKeyPressed!=KeyEvent.VK_S){
			if(key == KeyEvent.VK_DOWN||key==KeyEvent.VK_S){

				player.setHumanVelX(0);
				if ((player.getHumanVelY() == 0) ){
					lastKeyPressed = KeyEvent.VK_DOWN;
					lastKeyPressed=KeyEvent.VK_S;
					player.setHumanVelY(0);
					player.setHeight( player.getHeight()-10 );
					player.move( 0, 10); 		
				} else 
					player.setHumanVelY(speed);
			}
		}
		if(key==KeyEvent.VK_LEFT||key==KeyEvent.VK_A){
			player.setHumanVelX(-speed);
			if (lastKeyPressed == KeyEvent.VK_DOWN||lastKeyPressed==KeyEvent.VK_S)
				player.setHumanVelX(0);

		}
		if ((key==KeyEvent.VK_W||key==KeyEvent.VK_UP )&& player.getHumanVelY()==0 && (lastKeyPressed !=KeyEvent.VK_DOWN||lastKeyPressed==KeyEvent.VK_S)){
			player.setHumanVelY(-speed);
			player.setHumanVelX(0);
			maxHeight = player.getY()-200;
		}
		if (key==KeyEvent.VK_RIGHT||key==KeyEvent.VK_D){
			player.setHumanVelX(speed);

			if (lastKeyPressed == KeyEvent.VK_DOWN || lastKeyPressed == KeyEvent.VK_S)
				player.setHumanVelX(0);
		}
	}

	public void keyReleased(KeyEvent e) {
		Human player;

		player = game.getPlayer(); // human object 

		player.setHumanVelX(0);
		if (lastKeyPressed == KeyEvent.VK_DOWN||lastKeyPressed==KeyEvent.VK_S){
			player.setHeight( player.getHeight()+10 );

			player.move(0, -10); 
			lastKeyPressed = -1;
		}

	}

	public void keyTyped(KeyEvent e) {
	}
}