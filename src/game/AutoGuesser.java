/**
 * Auto guesser class that uses the Guesser base class
 * @author Alex Kuang
 */


package game;

public class AutoGuesser extends Guesser {
    private static final String LETTERS_ORDERED_BY_FREQUENCY = "etaoinshrldcumfpgwybvkxjqz";
    private int currentLetterIndex = 0;
    
    @Override
    public char makeGuess() {
        char guess = LETTERS_ORDERED_BY_FREQUENCY.charAt(currentLetterIndex++);
        recordGuess(guess);
        return guess;
    }
}
