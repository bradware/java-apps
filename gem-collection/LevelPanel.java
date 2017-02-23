import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class LevelPanel extends JPanel {

	private Game game1;
	private javax.swing.Timer timer1;
	private ScorePanel sp;

	 

	public LevelPanel(Game game1, ScorePanel sp) {
		setLayout(new BoxLayout (this, BoxLayout.Y_AXIS));
		this.game1 = game1;
		this.sp = sp;
		timer1 = new javax.swing.Timer(100, new TimerListener());
		timer1.start();
		addKeyListener(new DirectionListener());
		setPreferredSize(new Dimension(500,1000));
		setBackground(Color.lightGray);
		setFocusable(true);
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		Tile [][] currentGrid = game1.getFloorGrid();
		ArrayList<Monster> monList = game1.getList();
		for(int i = 0; i < currentGrid.length; i++){
			for(int j = 0; j < currentGrid[i].length; j++){
				currentGrid[i][j].drawTile(g);
			}
		}
		for(Monster m : monList){
			m.draw(g);
		}
		
		game1.getPlayer().draw(g);
		
	}
	
	private class TimerListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			game1.updateState();
			if(game1.getLevel().getNumGems() == 0){
				int userChoice = JOptionPane.showConfirmDialog(null,
						"You win! Keep Playing?");

				if (userChoice == JOptionPane.YES_OPTION) {
					game1 = new Game(Game.LEVEL_TWO);
				}
				if (userChoice == JOptionPane.NO_OPTION) {
					System.exit(0);
				}
			}
			if(game1.getPlayer().getHealth() < 0){
				game1.lose();
				System.exit(0);
				timer1.stop();
			}
			if(game1.hasLost() == true){
				timer1.stop();
			}
	         sp.updateLabels(game1.getLevel().getNumGems(), game1.getPlayer().getHealth());

			
			repaint();
			
		}

	}

	private class DirectionListener extends KeyAdapter {
		
		
		public void keyPressed(KeyEvent e){
			
			switch(e.getKeyCode())
			{
				case KeyEvent.VK_UP:
					
						game1.getPlayer().move(-1, 0);
						//game1.getLevel().collectItem(game1.getPlayer().getCurrentRow() - 1, game1.getPlayer().getCurrentCol());
						break;
					
				case KeyEvent.VK_DOWN:
						game1.getPlayer().move(1,0);
						//game1.getLevel().collectItem(game1.getPlayer().getCurrentRow() + 1, game1.getPlayer().getCurrentCol());
						break;

					
				case KeyEvent.VK_LEFT:
						game1.getPlayer().move(0,-1);
						//game1.getLevel().collectItem(game1.getPlayer().getCurrentRow(), game1.getPlayer().getCurrentCol() - 1);
						break;

					
				case KeyEvent.VK_RIGHT:
						game1.getPlayer().move(0,1);
						//game1.getLevel().collectItem(game1.getPlayer().getCurrentRow(), game1.getPlayer().getCurrentCol() + 1);
						break;

					
			}
			repaint();
		}

		
	}
}
