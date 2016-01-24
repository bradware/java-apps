import java.awt.*;



public class Gem extends Item{
	
	public Gem(int val){
		super(val);
	}

	@Override
	public void drawItem(Graphics g, int x, int y) {
		g.setColor(Color.green);
		g.fillRect(x, y, 10, 10);
		
	}
	
	
	
	

}
