import java.util.*;


/**
 * @author BradWare 
 * @version 10/17/2012
 * This class defines what is a coin 
 * Based on the boolean value that heads represents true, tails represents false
 */

public class Coin {
	
	private boolean headsCorrect;
	private Random gen;
	
	/**
	 * Initializes a new random generator and headsCorrect to be true
	 */
	
	public Coin(){
		headsCorrect = true;
		gen = new Random();
	}
	
	/**
	 * This method simulates the flip of a coin using random generator
	 * If generator produces 1, headsCorrect is false (simulates tails)
	 * No parameters and doesn't return anything
	 */
	
	public void flip(){
		
		int value = gen.nextInt(2);
		if(value == 0){
			headsCorrect = true;
		}else
		headsCorrect = false;
		
		
	}
	
	/**
	 * Get's the coin state based on the value determined by flip
	 * @return true or false, depending on flip (Heads = true)
	 * No parameters, just a getter method
	 */
	public boolean getCoinState(){
		return headsCorrect;
	}
	
	/**
	 * Converts getCoinState value to Heads or Tails
	 * If headsCorrect is true, toString converts to Heads
	 * @return Returns a String comprised of either Tails or Heads
	 */
	
	public String toString(){
		if(getCoinState() == false){
			return "Tails";
		}
		return "Heads";
	}

}
