import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This class creates a CoinPanel that inherits a JPanel
 * CoinPanel allows the user to bet on heads or tails, and type in the amount they want to bet
 *Used 3 JLabel's, JTextField, and 3 JButton's
 * @author BradWare
 * @version 10/17/2012
 *
 */

public class CoinPanel extends JPanel {

	private JLabel label1, label2, brokeLabel;
	private JButton buttonHeads, buttonTails, buttonReset;
	private JTextField text;
	protected Player name1;
	private Coin coin1;
	
	/**
	 * This constructor initializes a new coin, and a new player that takes in coin1
	 * Initializes the 2 labels, and keeps brokeLabel as empty currently until later
	 * Initializes the three buttons, and adds actionListeners to all 3
	 * Sets the JTextField text
	 * adds all of these components to CoinPanel
	 */

	public CoinPanel() {
		
		setPreferredSize(new Dimension(220, 190));
		coin1 = new Coin();
		name1 = new Player(coin1);
		label1 = new JLabel("Current Money: " + name1.getMoney());
		label2 = new JLabel("Current Flip: " + coin1.toString());
		brokeLabel = new JLabel("Enter a bet");
		buttonHeads = new JButton("Bet Heads");
		buttonTails = new JButton("Bet Tails");
		buttonReset = new JButton("Reset");
		text = new JTextField(3);
		buttonHeads.addActionListener(new ButtonListener(true));
		buttonTails.addActionListener(new ButtonListener(false));
		buttonReset.addActionListener(new ResetListener());

		add(label1);
		add(label2);
		add(buttonHeads);
		add(buttonTails);
		add(buttonReset);
		add(text);
		add(brokeLabel);
	}
	
	/**
	 * This class writes ActionListener for the 3 buttons, uses 1 instance field to determine the difference
	 * Updates the JLabel's based off of JTextField and what player betted on
	 * @author BradWare
	 * @version 10/17/2012
	 *
	 */
	
	private class ButtonListener implements ActionListener {

		private boolean betHeads;

		/**
		 * Initializes parameter heads
		 * @param heads takes in this boolean value to see what player is betting on
		 */
		public ButtonListener(boolean betHeads) {
			this.betHeads = betHeads;

		}
		/**
		 * Sees if text contains any value, converts it to integer
		 * bets based off button pushed, decides if betHeads is true or false
		 * If betheads true, runs bet based off true heads parameter, and valBet based on typed in textField
		 * updates money after bet method has been run, and uses toString method to print current side coin is on
		 * If bet is above player's current money, JbrokeLabel is printed out. 
		 * @param Takes in an ActionEvent parameter e
		 */
		public void actionPerformed(ActionEvent e) {

			if (!text.getText().equals("")) {

				String str = text.getText();

				int valBet = Integer.parseInt(str);

				if (valBet <= name1.getMoney()) {

					name1.bet(betHeads, valBet);
					label1.setText("Current Money: " + name1.getMoney());
					label2.setText("Current Flip: " + coin1.toString());

				}

				else {

					brokeLabel.setText("You don't have that much money!");

				}

			}

			
		}
	}
	
	/**
	 * Class creates ActionListener for the button reset if pushed
	 * @author BradWare
	 * @version 10/17/2012
	 */
	private class ResetListener implements ActionListener{
		
		/**
		 * Method resets money of player to 10, and updates label1 to show that
		 */
		public void actionPerformed(ActionEvent e){
			name1.resetMoney();
			label1.setText("Current Money:"  + name1.getMoney());
		}
	}
}
