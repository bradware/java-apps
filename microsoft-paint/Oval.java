import java.awt.Color;
import java.awt.Graphics;

/**
 * Defines an Oval,child class of shape
 * Takes in a parameter if the oval is filed
 * @author BradWare
 * @version 1.0 10/30/2012
 *
 */
public class Oval extends Shape{

	private boolean filled;
	
	/**
	 * Sets that an Oval object takes in a starting position, color, and if it is filled or not
	 * @param startX starting X position of the Oval
	 * @param startY starting Y position of the Oval
	 * @param color  color of the Oval
	 * @param filled boolean if the Oval is filled
	 */
	public Oval(int startX, int startY, Color color, boolean filled){
		super(startX, startY, color);
		this.filled = filled;
	}

	
	
	/**
	 * Draws an oval, if filled is true, draws with fillOval
	 * Draws drawOvalif filled is false
	 * takes in startX and startY for initial positons, and calculates the width and height
	 * uses the color set in the constructor for the color it is drawn in
	 */
	
	public void draw(Graphics g) {
		g.setColor(color);
		if(filled == true){
			g.fillOval(startX, startY, Math.abs(bottomRightX - startX), Math.abs(bottomRightY - startY));
		}else
		g.drawOval(startX, startY, bottomRightX - startX, bottomRightY - startY);
		
	}
}
