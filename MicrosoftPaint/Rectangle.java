import java.awt.Color;
import java.awt.Graphics;

/**
 * This class defines the shape Rectangle, child class of Shape Takes in another
 * instance variable, if the Rectangle is filled
 * 
 * @author BradWare
 * @version 1.0 10/30/2012
 * 
 */

public class Rectangle extends Shape {

	private boolean filled;

	/**
	 * Defines a rectangle that needs a start position, color, and if it is
	 * filled or not Uses super of the parent class to instantiate the start
	 * position and color
	 * 
	 * @param startX
	 *            represents start X position of the rectangle
	 * @param startY
	 *            represents start Y position of the rectangle
	 * @param color
	 *            color of the rectangle
	 * @param filled
	 *            boolean value if the rectangle is filled
	 */
	public Rectangle(int startX, int startY, Color color, boolean filled) {
		super(startX, startY, color);
		this.filled = filled;
	}

	/**
	 * This method draws the rectangle Uses drawRect if filled is false, uses
	 * startX and startY to have the initial position Uses bottomRightX minus
	 * the startX to calculate width, same for Y for the height Uses fillRect if
	 * filled is true Sets the color we want to draw from the color variable
	 */

	public void draw(Graphics g) {
		g.setColor(color);
		if (filled == true) {
			g.fillRect(startX, startY, Math.abs(bottomRightX - startX),
					Math.abs(bottomRightY - startY));
		} else
			g.drawRect(startX, startY, Math.abs(bottomRightX - startX),
					Math.abs(bottomRightY - startY));

	}

}
