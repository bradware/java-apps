
/**
 * 
 * @author BradWare
 * @version 10/17/2012
 * This class defines a player, each starts with 10 dollars and a coin
 * Player can bet their money based on coin flip
 */
public class Player {
	
	private int money;
	private Coin coin1;
	
	/**
	 * Initializes money to 10, initializes object of coin1
	 * @param coin1 is passes as a parameter, to create a player has to have a coin
	 */
	
	public Player(Coin coin1){
		money = 10;
		this.coin1 = coin1;
		
	}
	/**
	 * Method flips a coin and gets the side it landed on, and compares that to the value the player betted on
	 * @param betSide Boolean expression that the player is betting on, true or false
	 * @param betValue Value that the player is betting
	 */
	
	public void bet(boolean betSide, int betValue){
		
		coin1.flip();
		boolean standBy = coin1.getCoinState();
		if(standBy == betSide){
			money+= betValue;
		}else
		money-= betValue;
		}
	/**
	 * Getter method that gets the current value of the money 
	 * @return an integer value of the money the player contains
	 */
	public int getMoney(){
		return money;
	}
	
	/**
	 * This method resets the value of the player's money back to 10
	 * Takes in no parameters and does not return anything
	 * 
	 */
	
	public void resetMoney(){
		money = 10;
	}
	

}
