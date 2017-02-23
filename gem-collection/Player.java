
import java.awt.*;
import java.util.ArrayList;

/**
 * This class defines the Player in the game
 * @author BradWare
 * @version 1.0 11/26/2012
 *
 */
public class Player extends Character {
	
	private int health;
	private int numGems;
	
	/**
	 * Uses super reference to assign the player's variables, and sets score to 0 and health to 20
	 * @param game1 Sets placeholder for a player to have a Game
	 * @param currentRow Sets currentRow for the player
	 * @param currentCol Sets currentCol for the player
	 */
	
	public Player(Game game1, int currentRow, int currentCol){
		super(game1, currentRow, currentCol);
		health = 50;
	}
	
	/**
	 * Draws player as blue oval
	 * @param g Graphics parameter
	 */

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.blue);
		g.fillOval(currentCol*30, currentRow*30, 30, 30);
	}
	
	/**
	 * Getter method for Player row
	 * @return CurrentRow of the player
	 */
	
	public int getCurrentRow(){
		return currentRow;
	}
	
	/**
	 * getter method for col of the player
	 * @return current col of the player
	 */
	public int getCurrentCol(){
		return currentCol;
	}
	
	/**
	 * setter for the row of the player
	 * @param dRow Row to be set as player's currentRow
	 */
	
	public void setCurrentRow(int dRow){
		currentRow = dRow;
	}
	
	/**
	 * setter for the col of the player
	 * @param dCol Col to be set as player's currentCol
	 */
	public void setCurrentCol(int dCol){
		currentCol = dCol;
	}
	
	/**
	 * Method moves player, but checks first to see if move is legal and returns Item after it is moved
	 * @param dRow Row that the player is trying to move to
	 * @param dCol Col that the player is trying to move to
	 */
	
	
	public void move(int dRow, int dCol){
		super.move(dRow,dCol);
	    if(((Floor)game1.getFloorGrid()[currentRow][currentCol]).hasItem()){
			game1.getLevel().collectItem(currentRow, currentCol);
			
		}
		if(((Tile)game1.getFloorGrid()[currentRow][currentCol]) instanceof TeleportTile){
			if(((Tile)game1.getFloorGrid()[currentRow][currentCol]).getRow() == game1.getTile1().getRow()
				&& ((Tile)game1.getFloorGrid()[currentRow][currentCol]).getCol() == game1.getTile1().getCol()){
				((TeleportTile)game1.getFloorGrid()[currentRow][currentCol]).playerEnters(this,game1.getTile2());
			}else
				((TeleportTile)game1.getFloorGrid()[currentRow][currentCol]).playerEnters(this ,game1.getTile1());

		}
	}
	
	
	
	/**
	 * Getter for the health of the player
	 * @return Player's current health
	 */
	public int getHealth(){
		return health;
	}
	
	
	
	
	
	
	/**
	 * Method that updates the health of the player
	 * @param addHealth Amount added to player's score
	 */
	
	public void updateHealth(int addHealth){
		health+=addHealth;
	}
	
}
