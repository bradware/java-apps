import java.awt.Color;
import java.awt.Graphics;


public class Wall extends Tile {
	private boolean isPassable;
	
	public Wall(int rowLocation, int colLocation){
		super(rowLocation, colLocation);
		isPassable = false;
	}

	@Override
	public boolean isPassable() {
		return isPassable;
	}

	@Override
	public void playerEnters(Player p) {
		//performs no action of the player
		
	}


	@Override
	public void drawTile(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(colLocation * tileWidth, rowLocation * tileHeight, tileWidth, tileHeight);
		
		
	}
	
	
}
