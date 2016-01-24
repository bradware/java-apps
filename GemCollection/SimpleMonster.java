import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 * Specifies a monster even further by specifying a SimpleMonster
 * @author BradWare
 *@version 1.0 11/26/2012
 */
public class SimpleMonster extends Monster {
	
	/**
	 * Uses super constructor to assign all of the instance variables inherited, assigns attack to -5
	 * @param game1 Game that a SimpleMonster takes in
	 * @param currentRow Assigns placeholder for the row location of Monster
	 * @param currentCol Assings placeholder for col location of Monster
	 */
	
	public SimpleMonster(Game game1, int currentRow, int currentCol, int attack){
		super(game1, currentRow, currentCol, -5);
		
		
	}
	
	/**
	 * Method attacks player by updating his health by -5
	 * @param Takes in a player as a parameter
	 */

	@Override
	public void attackAction(Player p) {
		p.updateHealth(attack);

	}
	
	/**
	 * Draws a simple monster, represented by a red rectangle
	 * @param Takes in a graphics parameter
	 */

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(currentRow * monsterHeight, currentCol * monsterWidth, 30, 30);
	}
	
	
	
	
}
