import game.CheatingExecutioner;
import game.AutoGuesser;
import game.HangmanGame;
import game.HumanGuesser;
import game.StandardExecutioner;
import util.HangmanDictionary;


/**
 * This class launches the Hangman game and plays once.
 * 
 * @author Michael Hewner
 * @author Mac Mason
 * @author Robert C. Duvall
 * @author Shannon Duvall
 */

public class Main {
    public static final String DICTIONARY = "data/lowerwords.txt";
    public static final int NUM_LETTERS = 6;
    public static final int NUM_MISSES = 8;

    public static void main(String[] args) {
        HangmanDictionary dict = new HangmanDictionary(DICTIONARY);
        
        // Human vs Standard Computer
        HangmanGame game1 = new HangmanGame(new HumanGuesser(), new StandardExecutioner(dict, NUM_LETTERS, NUM_MISSES));
        
        // Computer vs Standard Computer
        HangmanGame game2 = new HangmanGame(new AutoGuesser(), new StandardExecutioner(dict, NUM_LETTERS, NUM_MISSES));
        
        // Human vs Cheating Computer
        HangmanGame game3 = new HangmanGame(new HumanGuesser(), new CheatingExecutioner(dict, NUM_LETTERS, NUM_MISSES));
        
        // Choose which game to play
        game2.play();
    }
}