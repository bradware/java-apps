import java.awt.Graphics;


public abstract class Item {
	
	protected int value;
	
	public Item(int value){
		this.value = value;
	}
	
	public abstract void drawItem(Graphics g, int x, int y);
	
	public int getValue(){
		return value;
	}
	
}
