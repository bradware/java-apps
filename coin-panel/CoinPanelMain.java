import java.awt.*;
import javax.swing.*;

/**
 * This class creates a JFrame to hold our CoinPanel class
 * Adds CoinPanel to our JFrame and sets it up to run as a GUI
 * @author BradWare
 * @version 10/17/2012
 *
 */

public class CoinPanelMain {
    
    /**
     * Sets up frame to hold panel1 to run the GUI
     * @param args
     */
    
    public static void main(String [] args){
        JFrame frame = new JFrame("Coin!");
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        CoinPanel panel1 = new CoinPanel();
        frame.getContentPane().add(panel1);
        frame.pack();
        frame.setVisible(true);
    }
    

}
