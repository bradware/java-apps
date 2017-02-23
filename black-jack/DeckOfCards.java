

 
import java.util.*;
/**
 * 
 * @author bradware
 * @versiontags  This creates the class for a deck of cards
 */

public class DeckOfCards
{
    /* You should use these arrays when making your cards */
    public static final String[] SUITS = {"Hearts", "Spades", "Clubs", "Diamonds"};
    public static final String[] FACES = {"Ace", "2", "3", "4", "5", "6", "7",
        "8", "9", "10", "Jack", "Queen", "King"};   
    private Card [ ] deck;
    private int cardsLeft;
    Random gen = new Random();

    public DeckOfCards()
    {
        cardsLeft = 51;
        deck = new Card[52];
        
        for(int i = 0; i< SUITS.length; i++){
            for(int j = 0; j < FACES.length; j++)
            {
            
                String currentFace = FACES[j];
                String currentSuit = SUITS[i];
                Card currentCard = new Card(currentFace,currentSuit);
                deck [cardsLeft] = currentCard;
                cardsLeft--;
                    
            }
        }
        cardsLeft = 52;
        
        
    }
    
    /**
     * @param This method takes in no parameters
     * @returntags This method does not return any value
     */
    
    public void shuffle(){  
         for(int a = deck.length-1; a >= 0; a--){
             
             int value = gen.nextInt((a+1));
             Card temp = deck [a];
             deck [a] = deck[value];
             deck [value] = temp;

         }
}
         
  /**
   * @param This method takes in no parameters
   * @return This method returns a Card that is dealt
   */
    public Card deal(){
        
        if(cardsLeft > 0){
            cardsLeft--;
            return deck [cardsLeft];
            
        
        }
            return null;
    
        }
  /**
   * @param This method takes no parameters
   * @return This method returns an integer of cards left in the deck
   */
    public int getCardsLeft(){
        return cardsLeft;
    }
    
    /**
     * @param This method takes no parameters
     * @return This method returns a string comprised of 
     */
    public String toString(){
        String dealtCards = "";
        for(int a = 0; a < cardsLeft;a++){
            dealtCards += deck[a] + ", ";
            
        }
        return cardsLeft + ", " + dealtCards;
        
    }
    
    //TODO - add missing methods and javadocs   

    /**
     * Counts the number of each type of face and suit (4 and 13 respective)
     *
     * This is a dirty hack way to verify all the cards are in the deck
     * We will call this after your shuffle to verify didn't lose any
     * cards. We will call this after shuffle to verify. Please note,
     * the cards must also appear shuffled to get credits.
     *
     * @return true if the shuffle was loss-less, false otherwise
     */
    public static boolean verifyDeck(DeckOfCards cardDeck)
    {
        int[] faceCount = new int[FACES.length];
        int[] suitCount = new int[SUITS.length];

        
        //Count each type of card
        for (Card card : cardDeck.deck)
        {
            String face = card.getFace();
            String suit = card.getSuit();
            for (int i = 0; i < FACES.length; i++)
                if (face.equals(FACES[i]))
                    faceCount[i]++;
            for (int i = 0; i < SUITS.length; i++)
                if (suit.equals(SUITS[i]))
                    suitCount[i]++;
        }

        //verify counts
        for(int i=0; i < faceCount.length; i++)
            if (faceCount[i]!=4){ //if not 4 of each (1 for each suit)
                return false;
            }
        for(int i=0; i < suitCount.length; i++)
            if (suitCount[i]!=13){
                return false;
            }
        return true;
    }

    public static void main(String[] args) //require them to have driver to test class
    {
        //Give them this test code:
        
        DeckOfCards deck = new DeckOfCards();
        System.out.println(deck); //Test creation - cards 'should' be in readable order initially to make sure all there
        System.out.println("Verify Complete Deck: "+DeckOfCards.verifyDeck(deck));

        //test shuffle
        deck.shuffle();
        System.out.println("Shuffled deck:\n" + deck);
        System.out.println("Verify Complete Deck After Shuffle: "+DeckOfCards.verifyDeck(deck));

        System.out.println("Dealt: "+deck.deal());
        System.out.println("Dealt: "+deck.deal());
        System.out.println("Deck state (first 2 cards should not show in deck):\n"+deck);
        
        //deal rest of cards but leave one remaining
        while(deck.getCardsLeft()>1) //technically don't need getters inside same class, regardless of whether it is the same object
        {
            deck.deal();
        }
        System.out.println("Last card: "+deck.deal()); //check boundary condition - should deal last card

        if(deck.deal() != null) //should not have any cards left
        {
            System.out.println("You've dealt more cards than possible!");
        }
        else
            System.out.println("Edge case passed!");

        System.out.println("All cards should be dealt now:\n"+deck);
    }
    
    
}









