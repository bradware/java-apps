import javax.swing.JFrame;

/**
 * This class runs the Paint application through a main method
 * @author BradWare
 * @version 1.0 10/30/2012
 *
 */
public class PaintGUI {
	
	/**
	 * Creates a new JFrame and sets the default close option on it
	 * Adds a PaintPanel to it, and that takes in already an InputPanel
	 * Packs the frame and sets it's visibility to true
	 * @param args array of Strings
	 */
	public static void main(String[] args){
	
		JFrame frame = new JFrame("Paint!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new PaintPanel(new InputPanel()));
		frame.pack();
		frame.setVisible(true);
	}
}
