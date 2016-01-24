import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;

/**
 * This class defines and InputPanel that is used for the buttons , filled
 * checkbox, and Color panel Creates JButton's for all of the shapes, quit
 * option, and color Creates a JCheckBox for the filled option, and a
 * JColorChooser to choose the color Takes in a string to represent the
 * currentShape, a static Color object Takes in a Preview Panel that shows the
 * current color, and JLabel
 * 
 * @author BradWare
 * @version 1.0 10/30/2012
 * 
 */
public class InputPanel extends JPanel {
	private JButton rectangleButton;
	private JButton circleButton;
	private JButton lineButton;
	private JButton colorButton;
	private JButton quitButton;
	private JCheckBox filled;
	private boolean shapeFilled;
	private JColorChooser colorChooser;
	private String currentShape;
	private static Color drawCol;
	private PreviewPanel prevPanel;
	private JLabel currentColor;

	/**
	 * This constructor takes in no parameters, and instantiates the Buttons and
	 * the JLabel Sets the layout to BoxLayout, and instantiates a new
	 * JColorChooser, sets shapeFilled to false This adds the actionListener to
	 * the Buttons, by taking in a String that represents a Rectangel, Oval, or
	 * Line Sets drawCol to Black, and sets the currentShape string to default
	 * to Rectangle Uses anonymous inner class for JButton exit to exit the
	 * program Uses anonymous inner class ItemListener to set shapeFilled to
	 * true if the JCheckBox is checked Uses another anonymous inner class for
	 * colorButton to make an ActionListener that sets drawColor to the return
	 * color value of showDialog adds all of the JButtons, the JLabel, and
	 * JCheckBox to the panel, and adds space in between
	 */

	public InputPanel() {
		currentColor = new JLabel("Current Color:");
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		prevPanel = new PreviewPanel();
		rectangleButton = new JButton("Rectangle");
		circleButton = new JButton("Circle");
		lineButton = new JButton("Line");
		colorButton = new JButton("Color");
		quitButton = new JButton("Quit");
		filled = new JCheckBox("Filled");
		colorChooser = new JColorChooser();
		shapeFilled = false;
		currentShape = "Rectangle";
		drawCol = Color.BLACK;
		rectangleButton.addActionListener(new ButtonListener("Rectangle"));
		circleButton.addActionListener(new ButtonListener("Circle"));
		lineButton.addActionListener(new ButtonListener("Line"));
		// Anonymous inner class that exits the program
		quitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		// Anonymous inner class that sets the shapeFilled boolean to true if
		// filled isSelected
		filled.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (filled.isSelected()) {
					shapeFilled = true;
				} else
					shapeFilled = false;
			}
		});
		// JColorChooser has a static method that makes a dialog and returns the
		// color you choose from it
		// Set drawCol equal to the color chosen from showDialog
		colorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawCol = JColorChooser.showDialog(InputPanel.this,
						"Current Color:", colorChooser.getColor());
				repaint();

			}
		});
		setPreferredSize(new Dimension(200, 400));
		add(Box.createGlue());
		add(Box.createRigidArea(new Dimension(0, 25)));
		add(rectangleButton);
		add(Box.createRigidArea(new Dimension(0, 10)));
		add(circleButton);
		add(Box.createRigidArea(new Dimension(0, 10)));
		add(lineButton);
		add(Box.createRigidArea(new Dimension(0, 10)));
		add(filled);
		add(Box.createRigidArea(new Dimension(0, 10)));
		add(colorButton);
		add(Box.createRigidArea(new Dimension(0, 10)));
		add(currentColor);
		add(Box.createRigidArea(new Dimension(0, 10)));
		add(prevPanel);
		add(Box.createRigidArea(new Dimension(0, 30)));
		add(quitButton);
		add(Box.createRigidArea(new Dimension(0, 60)));
		add(Box.createGlue());

	}

	/**
	 * Static method that get's the current drawCol
	 * 
	 * @return Color drawCol
	 */

	public static Color getColor() {
		return drawCol;
	}

	/**
	 * Returns the current value of isFilled
	 * 
	 * @return boolean value if the shape is filled
	 */

	public boolean isFilled() {

		return shapeFilled;
	}

	/**
	 * Returns whichShape
	 * 
	 * @return the current string of current shape
	 */
	public String whichShape() {

		return currentShape;
	}

	/**
	 * This ButtonListener class implements the interface ActionListener and
	 * takes in a String as an instance variable
	 * 
	 * @author BradWare
	 * @version 1.0 10/30/2012
	 * 
	 */
	private class ButtonListener implements ActionListener {
		private String shape;

		/**
		 * Instantiates a ButtonListener that takes in a String value
		 * 
		 * @param shape
		 *            String value that will represent which shape to use
		 */
		public ButtonListener(String shape) {
			this.shape = shape;
		}

		/**
		 * Once a button is pressed, the instance field currentShape is set
		 * equal to the String passed in as a parameter This essentially just
		 * sets currentShape equal to a String, and each ButtonListener takes in
		 * the String it's actionPerforms calls
		 * 
		 */
		public void actionPerformed(ActionEvent e) {
			currentShape = shape;
		}
		
		
	}

}
