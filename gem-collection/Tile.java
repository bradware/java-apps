import java.awt.Graphics;

/**
 * Class defines the abstract idea of a Tile
 * @author BradWare
 * @version 1.0 11/26/2012
 *
 */
public abstract class Tile {
	protected static int tileHeight;
	protected static int tileWidth;
	protected int rowLocation;
	protected int colLocation;
	
	/**
	 * Sets placeholder for the location of a tile, and sets height and width to 30
	 * @param rowLocation Current row of the Tile
	 * @param colLocation Current col of the Tile
	 */
		public Tile(int rowLocation, int colLocation){
		this.rowLocation = rowLocation;
		this.colLocation = colLocation;
		tileHeight = 30;
		tileWidth = 30;
		//this.rowLocation = rowLocation;
		//this.colLocation = colLocation;
	}
		
	/**
	 * Method to determine if a character can move onto the tile
	 * @return boolean value if the tile is passable or not
	 */
	
	public abstract boolean isPassable();
	
	/**
	 * Determines action brought onto Player that enters the tile
	 * @param p Player that enters the tile
	 */
	public abstract void playerEnters(Player p);
	
	/**
	 * Draws the tile
	 * @param g Graphics parameter
	 */
	public abstract void drawTile(Graphics g);
	
	public int getRow(){
		return rowLocation;
	}
	public int getCol(){
		return colLocation;
	}
	
	
}
