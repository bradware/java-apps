import java.awt.Graphics;

/**
 * Sets the abstract idea of a Character in the game
 * @author BradWare
 * version 1.0 11/26/2012
 *
 */
public abstract class Character {
	
	protected Game game1;
	protected int currentRow;
	protected int currentCol;
	
	/**
	 * Assigns all of the instance variables as placeholders for a Character to be constructed
	 * @param game1 Game that the character takes in
	 * @param currentRow Row of the character
	 * @param currentCol Col of the character
	 */
	public Character(Game game1, int currentRow, int currentCol){
		this.game1 = game1;
		this.currentRow = currentRow;
		this.currentCol = currentCol;
		
	}
	
	/**
	 * Character that does not have a location
	 * @param game1 Game that the character takes in
	 */
	
	public Character(Game game1){
		this.game1 = game1;
		
	}
	
	/**
	 * Method that draws the characters
	 * @param g Graphics parameter
	 */
	
	public abstract void draw(Graphics g);
	

	public void update(){
		
	}
	/**
	 * Determines if 2 characters share same location
	 * @param c Character that is run into
	 * @return
	 */
	public boolean runsInto(Character c){
		if(currentCol == c.currentRow && currentRow == c.currentCol){
			return true;
		}
		return false;
	}
	
	/**
	 * Moves the monster when the timer is called
	 * @param newRow Row the monster will move to
	 * @param newCol Column the monster will move to
	 */
	public void move(int newRow, int newCol) {
		if(this instanceof Monster) {
			if (game1.getLevel().canMoveToSquare((currentCol + newCol),
					(currentRow + newRow))) {
				currentRow += newRow;
				currentCol += newCol;
			}
		} else {
			if (game1.getLevel().canMoveToSquare((currentRow + newRow),
					(currentCol + newCol))) {
				currentRow += newRow;
				currentCol += newCol;
			}
		}
	}
	
	
}
