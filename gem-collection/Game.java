import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Game {

	private Level level1;
	private Player player1;
	private ArrayList<Monster> monsterList;
	private LevelPanel lp;
	private int playerCurrentRow;
	private int playerCurrentCol;
	private Random gen;
	private Tile[][] floorGrid;
	private int numGems;
	private int numHealthGems;
	private char[][] levelSetup;
	private char[][] levelSetup2;
	private TeleportTile tile1;
	private TeleportTile tile2;
	private final int MAX_SIMPLE = 11;
	private final int MAX_ADVANCED = 3;
	private boolean hasWon;
	private boolean hasLost;
	private ScorePanel sp;
	public static final int LEVEL_ONE = 1;
	public static final int LEVEL_TWO = 2;
	
	private final char[][] levelOneSetup = {
			{ 'f', 'w', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'w',
				'f', 'f', 'f', 'g', 'f', 'f', 'f', 'f' },
		{ 'f', 'w', 'f', 'w', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'w',
				'f', 'f', 'f', 'f', 'f', 'g', 'w', 'f' },
		{ 'f', 'w', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'w', 'h', 'w',
				'f', 'f', 'f', 'f', 'f', 'g', 'f', 'w' },
		{ 'f', 'f', 'f', 'f', 'f', 'w', 'f', 'f', 'f', 'w', 'w', 'w',
				'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f' },
		{ 'f', 'f', 'f', 'f', 'f', 'w', 'w', 'f', 'f', 'f', 'f', 'f',
				'f', 'f', 'f', 'f', 'f', 'f', 'f', 'w' },
		{ 'f', 'w', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'g', 'f',
				'f', 'f', 'f', 'f', 'f', 'f', 'f', 't' },
		{ 'f', 'w', 'f', 'f', 'f', 'g', 'f', 'w', 'f', 'f', 'f', 'f',
				'f', 'f', 'f', 'f', 'f', 'f', 'g', 'f' },
		{ 'g', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f',
				'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f' },
		{ 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f',
				'f', 'f', 'f', 'w', 'f', 'f', 'f', 'f' },
		{ 'f', 'f', 'f', 'f', 'f', 'w', 'w', 'f', 'f', 'f', 'p', 'f',
				'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f' },
		{ 'f', 'f', 'f', 'f', 'f', 'g', 'w', 'f', 'w', 'f', 'w', 'f',
				'w', 'w', 'w', 'f', 'f', 'f', 'w', 'w' },
		{ 'f', 'f', 'f', 'w', 'f', 'w', 'w', 'f', 'w', 'f', 'w', 'f',
				'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f' },
		{ 'f', 'f', 'f', 'w', 'f', 'f', 'f', 'f', 'w', 'w', 'w', 'f',
				'f', 'f', 'f', 'f', 'f', 'f', 'f', 'w' },
		{ 'f', 'f', 'f', 'w', 'g', 'f', 'f', 'f', 'f', 'f', 'f', 'f',
				'f', 'w', 'f', 'f', 'f', 'f', 'f', 'f' },
		{ 'f', 'f', 'f', 'w', 'w', 'w', 'f', 'f', 'f', 'w', 'w', 'f',
				'f', 'w', 'g', 'f', 'f', 'f', 'f', 'w' },
		{ 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'g', 'w', 'f',
				'f', 'w', 'f', 'f', 'f', 'f', 'g', 'f' },
		{ 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'w', 'f',
				'f', 'f', 'f', 'f', 'f', 'f', 'f', 'g' },
		{ 'f', 'w', 'w', 'f', 'f', 'f', 'f', 'f', 'w', 'w', 'f', 'f',
				'f', 'f', 'f', 'f', 'f', 'f', 'w', 'f' },
		{ 'f', 'w', 't', 'f', 'f', 'f', 'f', 'f', 'g', 'f', 'f', 'f',
				'f', 'w', 'f', 'f', 'w', 'f', 'w', 'f' },
		{ 'f', 'w', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f',
				'g', 'w', 'f', 'h', 'w', 'f', 'f', 'f' } };
	
	private final char[][] levelTwoSetup = {
			{ 'f', 'f', 'f', 'f', 't', 'f', 'f', 'f', 'f', 'f', 'f', 'w',
					'f', 'g', 'f', 'f', 'f', 'f', 'f', 'f' },
			{ 'f', 'f', 'f', 'w', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'w',
					'f', 'f', 'f', 'f', 'f', 'f', 'w', 'f' },
			{ 'w', 'w', 'f', 'f', 'f', 'f', 'g', 'f', 'f', 'w', 'h', 'w',
					'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f' },
			{ 'w', 'f', 'f', 'f', 'f', 'w', 'f', 'f', 'f', 'w', 'w', 'w',
					'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f' },
			{ 'f', 'f', 'f', 'f', 'f', 'w', 'w', 'f', 'f', 'f', 'f', 'f',
					'f', 'f', 'f', 'f', 'f', 'f', 'f', 'w' },
			{ 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f',
					'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f' },
			{ 'f', 'f', 'f', 'f', 'f', 'g', 'f', 'w', 'f', 'f', 'f', 'f',
					'f', 'w', 'w', 'f', 'f', 'f', 'g', 'f' },
			{ 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f',
					'f', 'f', 'w', 'f', 'f', 'f', 'f', 'f' },
			{ 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f',
					'f', 'f', 'f', 'w', 'f', 'f', 'f', 'f' },
			{ 'f', 'f', 'f', 'f', 'f', 'w', 'w', 'f', 'f', 'f', 'p', 'f',
					'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f' },
			{ 'f', 'f', 'f', 'f', 'f', 'g', 'w', 'f', 'w', 'f', 'w', 'g',
					'f', 'f', 'f', 'f', 'f', 'f', 'w', 'w' },
			{ 'f', 'f', 'f', 'w', 'f', 'w', 'w', 'f', 'w', 'f', 'w', 'f',
					'f', 'f', 'f', 'g', 'f', 'f', 'f', 'f' },
			{ 'g', 'f', 'f', 'w', 'f', 'f', 'f', 'f', 'w', 'w', 'w', 'f',
					'f', 'f', 'f', 'f', 'f', 'f', 'f', 'w' },
			{ 'f', 'w', 'f', 'w', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f',
					'f', 'w', 'f', 'f', 'f', 'f', 'f', 'f' },
			{ 'w', 'w', 'f', 'w', 'w', 'w', 'f', 'f', 'f', 'w', 'w', 'f',
					'f', 'w', 'f', 'f', 'f', 'f', 'f', 'w' },
			{ 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'g', 'w', 'f',
					'f', 'w', 'f', 'f', 'f', 'f', 'f', 'f' },
			{ 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'f', 'w', 'f',
					'f', 'f', 'f', 'f', 'g', 'f', 'f', 'g' },
			{ 'f', 'w', 'w', 'f', 'g', 'f', 'f', 'f', 'w', 'w', 'f', 'f',
					'f', 'f', 'f', 'f', 'f', 'f', 'w', 'f' },
			{ 'f', 'w', 'f', 'f', 'f', 'w', 'f', 'f', 'f', 'f', 'f', 'f',
					'f', 'w', 'f', 'f', 'w', 'f', 'w', 'f' },
			{ 'f', 'w', 'f', 'f', 'w', 'w', 'f', 'f', 'f', 'f', 'f', 'f',
					'g', 'w', 'f', 'h', 'w', 't', 'f', 'g' } };

	public Game(int level) {
		floorGrid = new Tile[20][20];
		char[][] levelSetup = (level == LEVEL_ONE ? levelOneSetup : levelTwoSetup);
		for (int i = 0; i < floorGrid.length; i++) {
			for (int j = 0; j < floorGrid[i].length; j++) {
				if (levelSetup[i][j] == 'w') {
					floorGrid[i][j] = new Wall(i, j);
				} else if (levelSetup[i][j] == 'g') {
					floorGrid[i][j] = new Floor(i, j, new Gem(10));
					numGems++;

				} else if (levelSetup[i][j] == 'h') {
					floorGrid[i][j] = new Floor(i, j, new HealthGem(10));
					numHealthGems++;

				} else if (levelSetup[i][j] == 't') {
					floorGrid[i][j] = new TeleportTile(i, j);

				} else
					floorGrid[i][j] = new Floor(i, j);
			}
		}
		tile1 = new TeleportTile(5, 19);
		tile2 = new TeleportTile(18, 2);
		playerCurrentRow = 0;
		hasWon = false;
		hasLost = false;
		playerCurrentCol = 0;
		level1 = new Level(this, levelSetup);
		player1 = new Player(this, playerCurrentRow, playerCurrentCol);
		monsterList = new ArrayList<Monster>();
		int numSimpleMonsters = 0;
		int numAdvancedMonsters = 0;
		gen = new Random();

		// generate simple monsters
		while (numSimpleMonsters < MAX_SIMPLE) {
			int randomRow = gen.nextInt(20);
			int randomCol = gen.nextInt(20);
			if (floorGrid[randomRow][randomCol].isPassable()) {
				SimpleMonster newSimMonster = new SimpleMonster(this,
						randomRow, randomCol, -5);
				monsterList.add(newSimMonster);
				numSimpleMonsters++;
			}
		}
		// generate advanced monsters
		while (numAdvancedMonsters < MAX_ADVANCED) {
			int randomRow = gen.nextInt(20);
			int randomCol = gen.nextInt(20);
			if (floorGrid[randomRow][randomCol].isPassable()) {
				AdvancedMonster newAdvMonster = new AdvancedMonster(this,
						randomRow, randomCol, -10);
				monsterList.add(newAdvMonster);
				numAdvancedMonsters++;
			}
		}

	}

	public void lose() {
		hasLost = true;
		JOptionPane.showMessageDialog(lp, "You lose!");

	}

	public void updateState() {
		// monsters move
		// timer moves the monsters

		for (Monster m : monsterList) {
			int randomRowMove = gen.nextInt(3) - 1;
			int randomColMove = gen.nextInt(3) - 1;
			m.move(randomRowMove, randomColMove);
			if(m.runsInto(player1)){
				m.attackAction(player1);
			}
					
		}

	}

	public boolean hasWon() {
		return hasWon;
	}

	public boolean hasLost() {
		return hasLost;
	}

	public Player getPlayer() {
		return player1;
	}

	public Level getLevel() {
		return level1;
	}

	public Tile[][] getFloorGrid() {
		return floorGrid;
	}

	public ArrayList<Monster> getList() {
		return monsterList;
	}

	public int getNumGems() {
		return numGems;
	}

	public int getNumHealthGems() {
		return numHealthGems;
	}

	public TeleportTile getTile1() {
		return tile1;
	}

	public TeleportTile getTile2() {
		return tile2;
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Game!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new GamePanel());
		frame.setPreferredSize(new Dimension(600, 650));
		frame.pack();
		frame.setVisible(true);
	}
}
