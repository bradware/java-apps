import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 * This class instantiates a PaintPanel which is the Panel where the shapes are
 * painted Has an instance variable for an arrayList of shapes, an InputPanel,
 * two points, and a Shape Uses the InputPanel to access the methods in the
 * InputPanel clas
 * 
 * @author BradWare
 * @version 1.0 10/30/2012
 * 
 */
public class PaintPanel extends JPanel {
	private ArrayList<Shape> shapeList;
	private InputPanel iP;
	//private Point point1 = null, point2 = null;
	private Shape currentShape;

	/**
	 * This sets the layout of the PaintPanel to a BorderLayout, instantiates a
	 * new arrayList, and set's the background to white Adds the InputPanel to
	 * the west side of PaintPanel and adds a MouseListener and
	 * MouseMotionListener
	 * 
	 * @param iP
	 *            takes in an InputPanel to instantiate a PaintPanel
	 */
	public PaintPanel(InputPanel iP) {
		setLayout(new BorderLayout());
		this.iP = iP;
		shapeList = new ArrayList<Shape>();
		setBackground(Color.white);
		setPreferredSize(new Dimension(700, 550));
		add(iP, BorderLayout.WEST);
		addMouseListener(new ShapeListener());
		addMouseMotionListener(new ShapeListener());
		

	}

	/**
	 * This method takes in a Graphics compnent page and calls the parent Class
	 * paintComonent with super Loops through the arrayList of shapes and draws
	 * them on the page
	 */

	public void paintComponent(Graphics page) {
		super.paintComponent(page);
		for (Shape s : shapeList) {
			s.draw(page);
		}

	}

	/**
	 * This class implements the MouseMotionListener and MouseListener
	 * interfaces Implements only mousePressed and mouseDragged methods
	 * 
	 * @author BradWare
	 * @version 1.0 10/30/2012
	 * 
	 */

	private class ShapeListener extends MouseAdapter{ //implements MouseListener, MouseMotionListener {
		/**
		 * Method makes a new point when the mouse is pressed Uses whichShape to
		 * get the String returned of currentShape, which tells which
		 * ButtonListener was called Checks to see what string this equals, and
		 * creates a new Shape based off of that Adds the shape created to the
		 * shapeList
		 */
		
		private Point point1 = null, point2 = null;

		public void mousePressed(MouseEvent e) {
			point1 = e.getPoint();
			if (iP.whichShape().equals("Rectangle")) {
				currentShape = new Rectangle(point1.x, point1.y,
						InputPanel.getColor(), iP.isFilled());

			} else if (iP.whichShape().equals("Circle")) {
				currentShape = new Oval(point1.x, point1.y,
						InputPanel.getColor(), iP.isFilled());

			} else if (iP.whichShape().equals("Line")) {
				currentShape = new Line(point1.x, point1.y,
						InputPanel.getColor());

			}
			shapeList.add(currentShape);

		}

		/**
		 * This method makes a new point every time the mouse is dragged Calls
		 * the updateBottomRight method with this point that essentially keeps
		 * updating as the mouse is being dragged This updateBottomRight will
		 * play into the draw method defined in each class of shapes repaint's
		 * after all of the dragging
		 */

		public void mouseDragged(MouseEvent e) {
			point2 = e.getPoint();
			currentShape.updateBottomRight(point2.x, point2.y);
			repaint();
		}
		/**
		 * These are the rest of the methods that come with the Interface MouseListener and MouseMotionListener
		 */
		
		public void mouseMoved(MouseEvent arg0) {
		}

		@Override
		public void mouseClicked(MouseEvent arg0) {
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
		}
	}
}

