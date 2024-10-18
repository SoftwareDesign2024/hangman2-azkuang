/**
 * Human guesser class that extends Guesser class
 * @author Alex Kuang
 */

package game;
import util.ConsoleReader;

public class HumanGuesser extends Guesser {
    @Override
    public char makeGuess() {
        while (true) {
            String guess = ConsoleReader.promptString("Make a guess: ");
            if (guess.length() == 1 && Character.isAlphabetic(guess.charAt(0))) {
                char result = guess.toLowerCase().charAt(0);
                recordGuess(result);
                return result;
            }
            System.out.println("Please enter a single letter ...");
        }
    }
}