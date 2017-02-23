import java.awt.Color;
import java.awt.Graphics;

/**
 * Class defines special abilities of a teleport tile
 * @author BradWare
 * @version 1.0 11/25/2012
 *
 */

public class TeleportTile extends Floor {
	
	/**
	 * Uses super to assign variables
	 * @param rowLocation Current row of the tile
	 * @param colLocation current col of the tile
	 */
	

	public TeleportTile(int rowLocation, int colLocation) {
		super(rowLocation, colLocation);
		super.isPassable = true;

	}
	
	/**
	 * Method to determine if character can enter tile
	 * @return Returns boolean value if tile is passable
	 */

	@Override
	public boolean isPassable() {
		return super.isPassable;
	}
	
	/**
	 * Inheriting method from parent, Teleport tile does not override it though with any code
	 */

	@Override
	public void playerEnters(Player p) {}
	
	/**
	 * Overloads playeEnters, sends player to other teleport tile location if he enters
	 * @param p Player that enters tile
	 * @param otherTile Other teleport tile the player is sent to
	 */

	public void playerEnters(Player p, TeleportTile otherTile) {
		
		p.setCurrentRow(otherTile.rowLocation);
		p.setCurrentCol(otherTile.colLocation);
		


	}
	
	/**
	 * Draws a telport tile as a cyan rectangle
	 * @param Takes in graphics parameter
	 */

	@Override
	public void drawTile(Graphics g) {
		g.setColor(Color.CYAN);
		g.fillRect(colLocation * tileWidth, rowLocation * tileHeight,
				tileWidth, tileHeight);

	}

}
