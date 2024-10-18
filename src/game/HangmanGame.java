package game;

/**
 * This class represents the traditional word-guessing game Hangman
 * that plays interactively with the user.
 *
 * @author Robert C. Duvall
 * @author Alex Kuang
 */

public class HangmanGame {
    private final Guesser guesser;
    private final Executioner executioner;
    
    /**
     * HangmanGame Constructor
     * @param guesser
     * @param executioner
     */
    public HangmanGame(Guesser guesser, Executioner executioner) {
        this.guesser = guesser;
        this.executioner = executioner;
    }
    
    /**
     * Function to play the game
     */
    public void play() {
        boolean gameOver = false;
        
        while (!gameOver) {
            printStatus();
            
            char guess = guesser.makeGuess();
            executioner.checkGuess(guess);
            
            if (executioner.isGameLost()) {
                System.out.println("YOU ARE HUNG!!!");
                gameOver = true;
            }
            else if (executioner.isGameWon()) {
                System.out.println("YOU WIN!!!");
                gameOver = true;
            }
        }
        System.out.println("The secret word was " + executioner.getSecretWordForDisplay());
    }
    
    /**
     * Display the game text
     */
    private void printStatus() {
        System.out.println(executioner.getDisplayWord());
        System.out.println("# misses left = " + executioner.getNumGuessesLeft());
        System.out.println("letters not yet guessed = " + guesser.getLettersLeftToGuess());
        System.out.println("*** " + executioner.getSecretWordForDisplay());
        System.out.println();
    }
}

