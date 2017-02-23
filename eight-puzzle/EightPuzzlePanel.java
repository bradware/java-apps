import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This class makes the JPanel to hold the EightPuzzle and the reset and scramble button
 * This specifies what an EightPuzzlePanel is, and makes it into a gridformat, with the images provided
 * Uses an array of JButtons to represent each of the 9 tiles as JButtons
 * @author BradWare
 * @version 1.0 10/24/2012
 *
 */

public class EightPuzzlePanel extends JPanel {
    private EightPuzzle puzzle;
    private JButton[][] tileButtons;
    private JButton scramble;
    private JButton reset;
    private JPanel tilePanel;
    
    /**
     * Sets the scramble JButton and reset JButton
     * Adds a panel hierarchy with tilePanel being holding the "grid"
     * Loops through tileButtons and instantiates a JButton for each tile, and adds a piece listener
     * In the loop also adds each of the new JButton in tileButtons to tilePanel
     * Constructor implements the ActionListener for scramble and reset in the Constructor
     * In scramble action listener is just scrambles tiles when called, reset just resets when called 
     * Adds tilePanel, reset and scramble Button, and sets the size of EightPuzzlePanel
     * @param takes in a EightPuzzle as a parameter to instantiate a EightPuzzlePanel
     */

    public EightPuzzlePanel(EightPuzzle puzzle) {
        this.puzzle = puzzle;
        scramble = new JButton("Scramble");
        reset = new JButton("Reset");
        tilePanel = new JPanel(new GridLayout(3, 3));
        tileButtons = new JButton[3][3];
        for (int i = 0; i < tileButtons.length; i++) {
            for (int j = 0; j < tileButtons[i].length; j++) {
                tileButtons[i][j] = new JButton();
                tileButtons[i][j].addActionListener(new PieceListener(i, j));
                tilePanel.add(tileButtons[i][j]);
            }
        }
        updateGUI();
        
        /**
         * This inner class is a ActionListener, and is used for the scramble JButton
         * @author BradWare
         * @version 1.0 10/24/2012
         */
        scramble.addActionListener(new ActionListener() {
            
            /**
             * method scrambles the puzzle 
             * "EightPuzzlePanel.this.puzzle" uses the parent class instance field from EightPuzzlePanel class
             * No Parameters and returns nothing
             */

            public void actionPerformed(ActionEvent e) {
                EightPuzzlePanel.this.puzzle.scramble();
                updateGUI();
            }

        });
        
        /**
         * This ActionListener class is used for reset JButton
         * @author BradWare
         * @version 1.0 10/24/2012
         */
        reset.addActionListener(new ActionListener() {
            
            /**
             * Method resets the board and updates the GUI afterwards
             * uses puzzle instance field from EightpUzzlePanel class
             * No parameters and returns nothing
             */
            public void actionPerformed(ActionEvent e) {
                EightPuzzlePanel.this.puzzle.reset();
                updateGUI();
            }
        });
        add(tilePanel);
        add(scramble);
        add(reset);
        setPreferredSize(new Dimension(370,380));

    }

    /**
     * This method updates the image of each JButton to match the image of each piece in the board array
     * Uses getGameView to attain the images of each piece
     * sets a double array of ImageIcon's to this, and loops through tileButtons and sets it equal to that
     * No parameters and retruns nothing
     */
    public void updateGUI() {
        ImageIcon[][] images = puzzle.getGameView();
        for (int i = 0; i < tileButtons.length; i++) {
            for (int j = 0; j < tileButtons[i].length; j++) {
                tileButtons[i][j].setIcon(images[i][j]);
            }
        }
    }
    /**
     * This class PieceListener creates an ActionListener for each JButton in tileButton pressed
     * Takes in 2 instance field to know the location of the JButton pressed
     * @author BradWare
     * @version 1.0 10/24/2012
     *
     */
    private class PieceListener implements ActionListener {
        private int col;
        private int row;
        
        /**
         * This constructor sets the row and col equal to this.row and this.col
         * @param row current row of the JButton
         * @param col current column of the JButton
         */

        public PieceListener(int row, int col) {
            this.row = row;
            this.col = col;

        }
        
        /**
         * Method used move method to validate and move the tiles when pressed
         * After the images are upDated after each press, checks to see if the images line up to a solved board
         * Uses static method showConfirmDialog and saves an int that it reutrns
         * Uses standard parameters for showConfirmDialog because we want a standard dialog pop-up
         * Takes in string for what we want it to pop-up as, and uses EightPuzzlePanel for parent component
         * Checks if userChoice is equal to No and Yes option and handles it accordingly
         * 
         */

        public void actionPerformed(ActionEvent e) {
            puzzle.move(row, col);
            updateGUI();
            if (puzzle.isSolved() == true) {
                int userChoice = JOptionPane.showConfirmDialog(EightPuzzlePanel.this,
                        "You win! Play again?");
                
                if (userChoice == JOptionPane.YES_OPTION) {
                    puzzle.scramble();
                    updateGUI();

                }
                if (userChoice == JOptionPane.NO_OPTION) {
                    System.exit(0);
                }
                
            

            }
        }

    }

}
