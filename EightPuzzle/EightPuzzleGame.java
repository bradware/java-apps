import java.awt.*;
import javax.swing.*;
import java.awt.Event;

/**
 * This class uses the EightPuzzlePanel and adds it to a frame, and creates a GUI
 * @author BradWare
 *@version 1.0 10/24/2012
 */

public class EightPuzzleGame {
	/**
	 * This main method creates a frame, sets the size and preferred close option, and adds a EightPuzzlePanel to it
	 * Has to instantiate a new EightPuzzle in order to add a EightPuzzlePanel
	 * Packs the frame and sets it's visibility to true
	 * @param args array of strings passed as a parameter
	 */
	public static void main(String[] args){
	
		JFrame frame = new JFrame("Eight Puzzle Game");
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		EightPuzzle puzzle = new EightPuzzle();
		EightPuzzlePanel panel1 = new EightPuzzlePanel(puzzle);
		frame.getContentPane().add(panel1);
		frame.pack();
		frame.setVisible(true);
		
		
		
	
	
	
	
	}
}
