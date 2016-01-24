import java.awt.Graphics;
import java.util.Random;

public class Level {

	private Tile[][] floorGrid;
	private Game game1;
	private int numGems;
	private int numHealthGems;
	private int numTeleportTiles;
	private char[][] levelSetup;

	public Level(Game game1, char[][] charSetup) {
		this.game1 = game1;
		floorGrid = game1.getFloorGrid();
		numHealthGems = 0;
		numGems = game1.getNumGems();
		numHealthGems = game1.getNumHealthGems();
		numTeleportTiles = 2;
		charSetup = levelSetup;
	}
	
	
	public void draw(Graphics g) {
		for (int i = 0; i < floorGrid.length; i++) {
			for (int j = 0; j < floorGrid[i].length; j++) {
				floorGrid[i][j].drawTile(g);
			}
		}
	}

	public boolean canMoveToSquare(int row, int col) {	
			if((row < 0 || row >= 20) || (col < 0 || col>=20)){
				return false;
			}
			if (floorGrid[row][col] instanceof Wall) {
				return false;
			}
		return true;
	}

	public void collectItem(int row, int col) {
		if (floorGrid[row][col] instanceof Floor) {
			if (((Floor)floorGrid[row][col]).getItem() instanceof Gem) {
				floorGrid[row][col] = new Floor(row, col);
				numGems--;
			
			}else 
				if (((Floor)floorGrid[row][col]).getItem() instanceof HealthGem) {
				game1.getPlayer().updateHealth(((Floor)floorGrid[row][col]).getItem().getValue());
				floorGrid[row][col] = new Floor(row, col);
				numHealthGems--;

			}

		}
	}

	public int getNumGems() {
		return numGems;
	}

	public int getNumHealthGems() {
		return numHealthGems;
	}

	public int getNumTeleportTiles() {
		return numTeleportTiles;
	}

	
	public char[][] getLevelSetup() {
		return levelSetup;
	}

}
