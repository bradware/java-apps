/**
 * 
 * @author bradware
 *@versiontags This is the class that creates the Black jack player. It takes a player name and an array of the hand of the player
 */
public class BlackjackPlayer {
  
    private Card[] hand;
    private int numCards;
    private String playerName;

    public BlackjackPlayer(String playerName)
    {
      this.playerName = playerName;
    }
/**
 * 
 * @param takes two cards as parameters
 * @return Does not return anything, just sets cards in the array of hand
 */
    public void newHand(Card card1, Card card2)
    {
      hand = new Card[11];
      hand[0] = card1;
      hand[1] = card2;
      numCards = 2;
    }
/**
 * @return This method does not return anything
 * @param Takes in a card as a parameter
 */
    public void addCard(Card card)
    {
      hand[numCards] = card;
      numCards++;
      
    }
/**
 * @return This method does not return anything
 * @param This method does not take any parameters, just clears the hand
 */
    public void clearHand()
    {
      for(int i = 0; i<hand.length; i++){
        hand[i] = null;
        
      }
      numCards = 0;
    }
/**
 * @param This method takes in no parameters
 * @return TRhis method returns an arry handVal, which returns an array of all the values the hand could be 
 */
    public int[] handValues()
    {
      int aceCounter = 1;
      int totalVal = 0;
      
      for(int i = 0; i < numCards; i++){
        if(hand[i].getFace().equals("Ace")){
          aceCounter++;
        }
        totalVal += evaluateCard(hand[i]);  
      }
      
    //creating array  
    int [] handVal = new int [1 + aceCounter];
    //no aces 
    if(aceCounter==0){
        handVal[0]=totalVal;
        return handVal;
      }
    //aces
      for(int i = 0; i < handVal.length; i++){
        handVal[i]=totalVal;
        totalVal+=10;
        
      }
      return handVal;
    }
/**
 * @param This method does not take in any parameters
 * @return Loops through and returns the best value that does not bust 21, if all bust, returns -1
 */
  public int bestScore()
  {
    int [] arr = handValues();
    if(!bust()){
      int best = arr[0];
      for(int i=1; i<arr.length; i++){
        if(arr[i] > best && arr[i] <= 21)
          best=arr[i];
      }
      return best;
      
    }
    else
      return -1;
      
    }
/**
 * @param This method does not take in any parameters
 * @return this method returns true if all the possible values in the hand is over 21
 */

    public boolean bust()
    {
      int[] arr = handValues();
      for(int i =0; i < arr.length; i++){
        if(arr[i] <= 21){
          
          return false;
        }
        
      }
      return true;
    }
/**
 * @param This method does not take in any parameters   
 * @return This method returns a String of the players name
 */
    public String getPlayerName(){
      
      return playerName;
    }

    //TODO: any remaining methods
/**
 * @param This method does not take in any parameters
 * @return This method returns a toString of the players name and the hand it has.
 */
    public String toString()
    {
      
      String str = getPlayerName()+", ";
      for(int i=0; i<numCards; i++){
        if(hand[i] != null){
          str+=hand[i].toString() + ", ";
        }
      }
      return str;
      
    }
    //System.out.println(toString(hand));


    /**
     * May alter to fit implementation as long as handValues works
     * 2-10 = respective value
     * J, Q, K = 10, A = 1 or 11
     * TODO complete javadoc
     *  
     * @return a numeric value representing the face of the card
     */
    public static int evaluateCard(Card card)
    {
       String faceVal = card.getFace();
       if(faceVal.equals("King") || faceVal.equals("Queen") || faceVal.equals("Jack")){
         
         return 10;
       }
       if(faceVal.equals("Ace")){
         return 1;
         
       }
       return new Integer(faceVal);
        
    }

    public static void main(String[] args)
    {
      
      /* I suggest you test these incrementally - don't try to run
       * all the tests at once, but comment out the rest and then
       * add them one at a time
       */
    
      BlackjackPlayer p = new BlackjackPlayer("Burdell");
      DeckOfCards d = new DeckOfCards();
      p.newHand(d.deal(), d.deal());

      /*May want to manually check hand first if having problems*/
      //i.e.
      //System.out.println("Check hand by individual cards (Should print two cards)");
      //for (int i = 0; i < p.getNumCards(); i++)
      //{
        //System.out.println(p.hand[i]);
      //}
      //System.out.println();

      
      System.out.println(p);
      System.out.println("Bust? "+p.bust()+"\n");

      System.out.println("Testing Aces: ");
      p.addCard(new Card("Ace", "Spades"));
      System.out.println(p+"\n");
      System.out.println("Testing Aces: ");
      p.addCard(new Card("Ace", "Clubs"));
      System.out.println(p+"\n");

      System.out.println("Adding cards to guarantee bust...");
      p.addCard(new Card("Jack", "Hearts"));
      System.out.println(p);
      System.out.println("Bust? "+p.bust()); //Probably wont bust here yet
      p.addCard(new Card("Jack", "Spades"));

      System.out.println(p);
      System.out.println("Bust? "+p.bust());
      if (p.bust() == false)
        System.out.println("Something is wrong - Didn't bust!");
      System.out.println();

      System.out.println("Testing clear (no cards should print: ");
      p.clearHand();
      System.out.println(p+"\n");

      /*TODO: Now write your own test case to make sure 
       * you can add can create a new hand.
       *
       * You may also want to make additional test cases
       * to make sure all your classes work optimally,
       * as we will also be conducted additional tests
       */
      
      
      System.out.println("Testing new hand creation: ");
      
      p.newHand(d.deal(), d.deal());
      System.out.println(p);
    }
}

