/**
 * Normal Executioner class
 * @author Alex Kuang
 */

package game;
import util.HangmanDictionary;

public class StandardExecutioner extends Executioner {
    /**
     * Construtor for Standard Executioner
     * @param dictionary
     * @param wordLength
     * @param numGuesses
     */
    public StandardExecutioner(HangmanDictionary dictionary, int wordLength, int numGuesses) {
        super(dictionary, wordLength, numGuesses);
    }
    
    /**
     * Separate implementation of getSecretWord
     */
    @Override
    protected String getSecretWord(HangmanDictionary dictionary, int wordLength) {
        return dictionary.getRandomWord(wordLength).toLowerCase();
    }
    
    /**
     * Separate implemntation of checkGuess
     */
    @Override
    public void checkGuess(char guess) {
        if (secretWord.indexOf(guess) >= 0) {
            displayWord.update(guess, secretWord);
        } else {
            numGuessesLeft--;
        }
    }
}

