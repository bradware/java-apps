/**
 * 
 * @author BradWare
 * @versiontags This creates a class for a card
 */




public class Card {
	
	private String face;
	private String suit;
	
	
	public Card(String face, String suit){
		this.face = face;
		this.suit = suit;
		
	}
	
	/**
	 * @param  Takes no parameters 
	 * @return Returns the face value of the card
	 */
	
	public String getFace(){
		
		return face;
	}
	
	/**
	 * @param Takes no parameters
	 * @return Returns the suit of the card
	 */
	
	public String getSuit(){
		return suit;
	}
	
	/**
	 * @param Takes no parameters
	 * @return Reurns a string of the face value and suit of a card
	 */ 
	
	public String toString(){
		  
		return face + " of " + suit;
		
	}
	
	
	

}
