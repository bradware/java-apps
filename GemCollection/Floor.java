import java.awt.Color;
import java.awt.Graphics;


public class Floor extends Tile {
	
	private Item item;
	private boolean hasItem;
	protected boolean isPassable;
	//something isn't right about where the floor is located
	public Floor(int rowLocation, int colLocation, Item item){
		super(rowLocation, colLocation);
		this.item = item;
		hasItem = true;
		isPassable = true;
		
	}
	public Floor(int rowLocation, int colLocation){
		super(rowLocation, colLocation);
		hasItem = false;
		isPassable = true;
	}
	
	public Item getItem(){
		return item;
		
	}
	
	public boolean hasItem(){
		return hasItem;
	}
	@Override
	public boolean isPassable() {
		return isPassable;
	}
	@Override
	public void playerEnters(Player p) {
		//nothing
		
	}
	@Override
	public void drawTile(Graphics g) {
		if(hasItem){
			if(getItem() instanceof HealthGem)
				((HealthGem)getItem()).drawItem(g,colLocation * tileWidth, rowLocation * tileHeight);
			if(getItem() instanceof Gem)
				((Gem)getItem()).drawItem(g,colLocation * tileWidth, rowLocation * tileHeight);

		}else
		g.setColor(Color.white);
		g.fillRect(colLocation * tileWidth, rowLocation * tileHeight, tileWidth, tileHeight);
	}
}
