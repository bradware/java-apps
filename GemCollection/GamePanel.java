import java.awt.BorderLayout;

import javax.swing.JPanel;


public class GamePanel extends JPanel {
	private Game game1;
	
	public GamePanel(){
		//start lvl 1
		game1 = new Game(Game.LEVEL_ONE);
		ScorePanel sp =  new ScorePanel(game1);
		LevelPanel lp = new LevelPanel(game1,sp);
		setLayout(new BorderLayout());
		add(lp,BorderLayout.CENTER);
		add(sp,BorderLayout.NORTH);
	}
}
