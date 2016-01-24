import java.awt.Color;
import java.awt.Graphics;

/**
 * This class defines a Line, child class of Shape
 * 
 * @author BradWare
 * @version 1.0 10/30/2012
 *
 */

public class Line extends Shape {
	
	/**
	 * Takes in a starting position and color of the line to instantiate a line
	 * @param startX starting X position of the Line
	 * @param startY starting Y position of the Line
	 * @param color Color of the line
	 */
	public Line(int startX, int startY, Color color){
		super(startX,startY, color);
	}
	
	/**
	 * Sets the color of a line based on the color instance field
	 * Draws a line using the start X and Y and bottomRightX and Y
	 */
	
	public void draw(Graphics g) {
		g.setColor(color);
		g.drawLine(startX, startY, bottomRightX, bottomRightY);
		
	}
	
}
