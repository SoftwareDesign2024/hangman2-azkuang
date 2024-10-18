/**
 * Base class for executioner
 * @author Alex Kuang
 */

package game;

import util.DisplayWord;
import util.HangmanDictionary;

public abstract class Executioner {
    protected String secretWord;
    protected DisplayWord displayWord;
    protected int numGuessesLeft;
    protected HangmanDictionary dictionary;
    
    /**
     * Executioner constructor
     * @param dictionary
     * @param wordLength
     * @param numGuesses
     */
    public Executioner(HangmanDictionary dictionary, int wordLength, int numGuesses) {
        this.dictionary = dictionary;
        this.numGuessesLeft = numGuesses;
        this.secretWord = getSecretWord(dictionary, wordLength);
        this.displayWord = new DisplayWord(secretWord);
    }
    
    /**
     * Abstract class for seperate getSecretWord implmentation
     * @param dictionary
     * @param wordLength
     * @return
     */
    protected abstract String getSecretWord(HangmanDictionary dictionary, int wordLength);
    
    /**
     * Abstract class for seperate checkGuess implmentation
     * @param guess
     */
    public abstract void checkGuess(char guess);
    
    /**
     * Check if the word was guessed correctly
     * @return
     */
    public boolean isGameWon() {
        return displayWord.equals(secretWord);
    }
    
    /**
     * Check if number of guesses is 0
     * @return
     */
    public boolean isGameLost() {
        return numGuessesLeft == 0;
    }
    
    /**
     * Returns the display word
     * @return
     */
    public String getDisplayWord() {
        return displayWord.toString();
    }
    
    /**
     * Returns the number of guesses left
     * @return
     */
    public int getNumGuessesLeft() {
        return numGuessesLeft;
    }
    
    /**
     * Returns the secret word
     * @return
     */
    public String getSecretWordForDisplay() {
        return secretWord;
    }
}
