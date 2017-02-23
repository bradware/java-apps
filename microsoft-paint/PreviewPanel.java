import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This class creates a PreviewPanel which displays the current color of the showDialog method
 * Creates a color instance variable to store the value of the color from showDialog
 * 
 * @author BradWare
 * @version 1.0 10/30/2012
 *
 */

public class PreviewPanel extends JPanel {
	
	private Color currentColor;
	
	/**
	 * Constructor takes in no parameters and sets the default color to black
	 */
	
	public PreviewPanel(){
		currentColor = Color.black;
	}
	
	/**
	 * Method overrides paintComponent and takes in a Graphics object page
	 * Calls super of the paintComponent method, and sets currentColor to the InputPanel.getColor
	 * Sets the color of the panel to currentColor, and fills a rectangle with it
	 */
	public void paintComponent(Graphics page)
	{
		super.paintComponent(page);
		currentColor = InputPanel.getColor();
		page.setColor(currentColor);
		page.fillRect(10,0,80,80);
		
	}

}
