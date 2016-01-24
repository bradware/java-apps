

/**
 * This abstract class represents what a Monster is designed to be
 * 
 * @author BradWare
 * @version 1.0 11/26/2012
 *
 */
public abstract class Monster extends Character{
	
	protected int attack;
	protected int monsterWidth;
	protected int monsterHeight;
	
	/**
	 * Initializes all of the instance variables and sets the monster Width and Height
	 * @param Game sets game using super to just a placeholder
	 * @param CurrentRow set using super as placeholder
	 * @param CurrentCol set using super as placeholder
	 * @param Attack set as a placeholder so it can be specified later
	 */
	
	public Monster(Game game, int currentRow, int currentCol, int attack){
		super(game,currentRow,currentCol);
		this.attack = attack;
		monsterWidth = 30;
		monsterHeight = 30;
		
	}
	
	//check this super constructor, instructions want this constructor, so had to make new constructor
	
	/**
	 * Sets attack of the monster
	 * @param p Player that is being attacked by monster
	 */
	
	public abstract void attackAction(Player p);
	
	/**
	 * Get's current Row location of monster
	 * @return Row of monster
	 */
	
	public int getCurrentRow(){
		return currentRow;
	}
	     
	/**
	 * Sets the new row for the monster
	 * @param newRow New rowLocation of monster
	 */
	
	public void setCurrentRow(int newRow){
		currentRow = newRow;
	}
	
	/**
	 * Get's current Column of monster
	 * @return
	 */
	public int getCurrentCol(){
		return currentCol;
	}
	
	/**
	 * sets the new col for the monster
	 * @param newCol New colLcoation of the monster
	 */
	
	public void setCurrentCol(int newCol){
		currentCol = newCol;
	}
}
