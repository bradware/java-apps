import java.awt.Color;
import java.awt.Graphics;


public class HealthGem extends Item {
	
	public HealthGem(int val){
		super(val);
	}

	@Override
	public void drawItem(Graphics g, int x, int y) {
		g.setColor(Color. orange); 
		g.fillRect(x, y, 10, 10);
		
	}
}
