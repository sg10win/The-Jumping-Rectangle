import java.util.Date;
public class Game {

	private Human gamePlayer; 
	// board array. each board store all data for a specific borad/level (rectangle and ball obstacles,
	// initial location and speed of obstacles and player)
	private Board[] boardsArray;
	private int startTime; // game start time
	private int currentBoard; // current level
	public void startAgain (){
		
		this.currentBoard=0;
		this.gamePlayer.setX(this.boardsArray[this.currentBoard].getStartX());
		this.gamePlayer.setY(this.boardsArray[this.currentBoard].getStartY());
		this.gamePlayer.setHealth(5);
		this.gamePlayer.setHumanVelX(0);
		this.gamePlayer.setHumanVelY(0);
		this.startTime = timeM()*60+timeS(); // game start time
	
		
		

}
	public Game (Human player, Board[] boards) {
		this.startTime = timeM()*60+timeS(); // game start time
		this.gamePlayer = player;
		this.boardsArray = boards;
		this.currentBoard = 0;
	}

	public int timeS() {//return the current secend  
		Date date = new Date();
		int Seconds=date.getSeconds();

		return Seconds;
	}
	public int timeM() {//return the curenet Minutes  
		Date date = new Date();

		int minuts=date.getMinutes();

		return minuts;
	}

	public Human getPlayer() {
		return this.gamePlayer;
	}

	public void setPlayer(Human player) {
		this.gamePlayer = player;
	}
	public  Board[] getBoardsArray() {
		return this.boardsArray;
	}

	public void setBoardsArray(Board[] boards) {
		this.boardsArray = boards;
	}

	public int getStartTime()
	{
		return this.startTime;
	}
	public int getCurrentBoard()
	{
		return this.currentBoard;
	}
	public void setCurrentBoard(int currentBoard)
	{
		this.currentBoard = currentBoard;
	}
	public Human getGamePlayer()
	{
		return this.gamePlayer;
	}
	public void setGamePlayer(Human gamePlayer)
	{
		this.gamePlayer = gamePlayer;
	}
	public void setStartTime(int startTime)
	{
		this.startTime = startTime;
	}


}
