import java.util.Random;

import javax.swing.*;

/**
 * This class instantiates an EightPuzzle, an array that contains 9 Pieces an assigns images to every piece
 * Class could be used as a skeleton for more than just an Eight Puzzle
 * @author BradWare
 * @version 1.0 10/24/2012
 *
 */
public class EightPuzzle {
    private final int BOARD_SIZE;
    private Piece board[][];
    private Random rand;
    private int currentCol;
    private int currentRow;
    private ImageIcon[] images;
    private final int SHUFFLE_NUM;
    private boolean prevDimMov = false;
    /**
     * This constructor takes no paramters sets currentCol and currentRow to 2, bc that is the blank tile
     * Sets SHUFFLE_NUM to 50 to make sure board is scrambled, and BOARD_SIZE to 9
     * creates an array of image files to assign to each board piece
     * creates an array and assigns each object of it to a different piece with a image from images and a VALUE
     * Contains no parameters
     */
    public EightPuzzle(){
        currentCol = 2;
        currentRow = 2;
        BOARD_SIZE = 9;
        SHUFFLE_NUM = 50;
        images = new ImageIcon[BOARD_SIZE];
        board = new Piece[3][3];
        rand = new Random();
        int counter = 1;
        for (int i = 0; i < BOARD_SIZE-1; i++) {
            images[i] = new ImageIcon("Piece"+ counter +".jpg");
            counter++;
        }
        images[8] = new ImageIcon("blankpiece.jpg");
        int count = 1;
        int imgCount = 0;
        for(int i = 0; i < board.length; i++ ){
            for(int j = 0; j < board[i].length; j++){
                board [i][j] = new Piece(images[imgCount],count);
                count++;
                imgCount++;
            }
        }
    
        
    }
    /**
     * Method scrambles the board each time it is called. Scrambles by using the move method to ensure that there is a solution to the scramble
     * If used just random then there might not be a solution
     * Used SHUFFLE_NUM to determine how many times to loop through and scramble
     */
    
    public void scramble(){
        for(int i = 0; i < SHUFFLE_NUM; i++){
            //checking to see if blank tile is in center of board
            if(currentRow == 1 && currentCol == 1) {  
                //instantiates swapRow to a random int between [-1,1]
                int swapRow = rand.nextInt(3)-1; 
                //conditional operator that will set swapCol to 1 if true, and -1 if false
                int swapCol = (rand.nextBoolean() ? 1:-1);
                //moving blanktile Row and is Row is generated as 0, adding swapCol
                move(currentRow + swapRow, currentCol + (swapRow == 0 ? swapCol:0));
            } else {  //testing for every tile besides the blank one
                if(prevDimMov) { // this will fluctuate moving the Col and Row of the tile selected in move. 
                    move(currentRow,currentCol + (currentCol-1<rand.nextInt(2) ? 1:-1) );
                    prevDimMov = !prevDimMov; //Sets boolean expression to opposite of it's original value
                } else { //same but for the Rows of the individual piece selected for move
                    move(currentRow + (currentRow-1<rand.nextInt(2) ? 1:-1), currentCol);
                    prevDimMov = !prevDimMov;
                }
            }
            
        }
        //this searches the board after it is shuffled and updates the position of the blank tile
        for(int a = board.length-1; a >= 0; a--){
            for(int b = board[a].length-1; b>=0; b--){
                if(board[a][b].getImage() == images[8]){
                    currentRow = a;
                    currentCol = b;
                }
            }
        }
    }
    /**
     * This method moves the tiles when being clicked, based on just swapping blank tile with valid tiles to left, right, up or down
     * @param swapRow Int position of the row of the tile being swapped with blank tile
     * @param swapCol Int position of the column of the tile being swapped with blank tile
     * @return true if the move method is valid, false otherwise
     */
    public boolean move(int swapRow, int swapCol){
        //calculates difference between the column and row of tile you are trying to swap with blank tile
        int diffY = Math.abs(swapRow - currentRow);
        int diffX = Math.abs(swapCol - currentCol);
        //checks to see if passed in parameters are on the board
        if(swapRow <= 2 && swapRow >= 0){
            if(swapCol <= 2 && swapCol >= 0){
                //swap based on the diff between swap tiles and blank has to be 1, and can only be one of the two
                //if both, this would mean swapRow and swapCol are from a diagonal tile, which cannot be swapped
                if((diffY == 1 && diffX == 0) || (diffX == 1 && diffY == 0)){
                    Piece temp = board[swapRow][swapCol];
                    board[swapRow][swapCol] = board[currentRow][currentCol];
                    board[currentRow][currentCol] = temp;
                    currentRow = swapRow;
                    currentCol = swapCol;
                    return true;
                }
                
            }
        }
        return false;
    }
    
    /**
     * This method is checking to see if the board has all of the pieces in the correct order
     * Correct Order: 1-3 on the first horizontal row, 4-6 second horizontal row, 7-blank last horizontal row
     * @return true if all of the pieces are in the correct order, false otherwise
     * NO Parameters
     */
    public boolean isSolved(){
        int counter = 0;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                counter++;
                if(board[i][j].getValue() != counter){ //checks to see VALUE doesn't equal what it is suppose to
                    return false;
                }
            }
        }
        return true;
        
    }
    /**
     * This method resets the board into the original position(or solved position)
     * This method has no parameters and does not return anything
     */
    public void reset(){
        int count = 1;
        int imgCount = 0;
        for(int i = 0; i < board.length; i++ ){
            for(int j = 0; j < board[i].length; j++){
                //have to make a new Piece b/c VALUE is a final variable and can't instantiate setValue
                board [i][j] = new Piece(images[imgCount],count);
                count++;
                imgCount++;
            }
        }
     
    }
    /**
     * This method loops through the game and obtains the image from each piece and adds it to the array gameImages
     * Used to update the view of the board after tiles have been moved
     * @return a double array of ImageIcon
     */
    
    public ImageIcon [][] getGameView(){
        ImageIcon [] [] gameImages = new ImageIcon[3][3];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                gameImages[i][j] = board[i][j].getImage();
                
            }
        }
        
        return gameImages;
        
    }

}
