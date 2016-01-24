import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;


public class AdvancedMonster extends Monster {
	
	public AdvancedMonster(Game game1, int currentRow, int currentCol, int attack){
		super(game1, currentRow, currentCol, -10);
		Random gen = new Random();
	}

	@Override
	public void attackAction(Player p) {
		p.updateHealth(attack);
		
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.magenta);
		g.fillRect(currentRow * monsterHeight, currentCol * monsterWidth, 30, 30);
	}

	
}
