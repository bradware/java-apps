import javax.swing.*;
/**
 * This class defines the object Piece, and has two instance variables, VALUE, and image
 * @author BradWare
 * @version 1.0 10/24/2012
 *
 */

public class Piece {
    
    private final int VALUE; 
    private ImageIcon image;
    
    /**
     * Initializes the value and imageIcon variable so that an object Piece has to contain them
     * @param image ImageIcon that produces the image of a Piece
     * @param value integer that is final that takes in the value of a Piece
     */
    public Piece(ImageIcon image,int value){
        this.image = image;
        VALUE = value;
        
    }
    
    /**
     * Method gets the value of a piece
     * @returns an int of the value of a piece
     */
    
    public int getValue(){
        return VALUE;
    }
    
    
    /**
     * Method geets the image of a Piece
     * @return the image of the particular piece
     */
    public ImageIcon getImage(){
        return image;
    }
    
    
    

}
