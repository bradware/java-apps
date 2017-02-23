import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class ScorePanel extends JPanel {
	
	private JLabel scoreLabel;
	private JLabel gemLabel;
	private JLabel healthLabel;
	private Game game1;
	
	public ScorePanel(Game game1){
		scoreLabel = new JLabel("Player's State: ");
		gemLabel = new JLabel("Gems Left: " + game1.getLevel().getNumGems());
		healthLabel = new JLabel("Health: " + game1.getPlayer().getHealth());
		add(scoreLabel);
		add(gemLabel);
		add(healthLabel);
		
		

	}
	
	public JLabel getHealthLabel(){
		return healthLabel;
	}
	
	public JLabel getGemLabel(){
		return gemLabel;
		
	}
	
	public void updateLabels(int gems, int health){
		gemLabel.setText("Gems Left: " + Integer.toString(gems));
        healthLabel.setText("Health: " + Integer.toString(health));
       
	}

	
}
