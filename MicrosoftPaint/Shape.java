import java.awt.Color;
import java.awt.Graphics;

/**
 * This abstract class defines a shape
 * Uses 4 instance variables to represent the x and y components of the shape
 * Takes in a color parameter to specify the color of the shape
 * 
 * @author BradWare
 * @version 1.0 10/30/2012
 *
 */

 public abstract class Shape {
	
	protected int startX;
	protected int startY;
	protected int bottomRightX;
	protected int bottomRightY;
	protected Color color;
	
	/**
	 * Sets that a shape has to have a starting position and a color to be instantiated
	 * @param startX represents the start X value of the shape
	 * @param startY represents the start Y value of the shape
	 * @param color  represents the color of the shape
	 */
	public Shape(int startX, int startY, Color color){
		this.startX = startX;
		this.startY = startY;
		this.color = color;
		bottomRightX = startX;
		bottomRightY = startY;
		
	}
	
	/**
	 * This method updates the bottom right corner of the shape with the variables it takes in
	 * 
	 * @param locX
	 * @param locY
	 */
	
	public void updateBottomRight(int locX, int locY){
		bottomRightX = locX;
		bottomRightY = locY;
	}
	
	/**
	 * This abstact class will draw the shape
	 * @param g Graphics component
	 */

	public abstract void draw(Graphics g);
	
}
