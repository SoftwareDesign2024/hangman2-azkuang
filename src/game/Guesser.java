/**
 * Base class for guesser
 * @author Alex K
 */

package game;

public abstract class Guesser {
    protected StringBuilder lettersLeftToGuess;
    
    /**
     * Constructor for Guesser class
     */
    public Guesser() {
        this.lettersLeftToGuess = new StringBuilder("abcdefghijklmnopqrstuvwxyz");
    }
    
    /**
     * Abstract class for each child class to implement makeGuess method
     */
    public abstract char makeGuess();
    
    /**
     * Record the guessed character
     * @param guess
     */
    protected void recordGuess(char guess) {
        int index = lettersLeftToGuess.indexOf("" + guess);
        if (index >= 0) {
            lettersLeftToGuess.deleteCharAt(index);
        }
    }
    
    /**
     * Returns the letters available to guess
     * @return
     */
    public String getLettersLeftToGuess() {
        return lettersLeftToGuess.toString();
    }
}