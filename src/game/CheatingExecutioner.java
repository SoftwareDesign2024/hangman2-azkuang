/**
 * Cheating Executioner that changes the word
 * @author Alex Kuang
 */

package game;

import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import util.DisplayWord;
import util.HangmanDictionary;

public class CheatingExecutioner extends Executioner {
    private List<String> remainingWords;
    
    /**
     * Constructor for Cheating Executioner
     * @param dictionary
     * @param wordLength
     * @param numGuesses
     */
    public CheatingExecutioner(HangmanDictionary dictionary, int wordLength, int numGuesses) {
        super(dictionary, wordLength, numGuesses);
        this.remainingWords = dictionary.getWords(wordLength);
    }
    
    /**
     * Separate implementation for SecretWord
     */
    @Override
    protected String getSecretWord(HangmanDictionary dictionary, int wordLength) {
        return dictionary.getRandomWord(wordLength).toLowerCase();
    }
    
    /**
     * Separate implementation for checkGuess
     */
    @Override
    public void checkGuess(char guess) {
        cheat(guess);
        if (secretWord.indexOf(guess) >= 0) {
            displayWord.update(guess, secretWord);
        } else {
            numGuessesLeft--;
        }
    }
    
    /**
     * Method to change the secret word
     * @param guess
     */
    private void cheat(char guess) {
        // create template of guesses and find one with most matching remaining words
        HashMap<DisplayWord, List<String>> templatedWords = new HashMap<DisplayWord, List<String>>();
        for (String w : remainingWords) {
            DisplayWord template = new DisplayWord(displayWord);
            template.update(guess, w);
            if (!templatedWords.containsKey(template)) {
                templatedWords.put(template, new ArrayList<>());
            }
            templatedWords.get(template).add(w);
        }
        int max = 0;
        DisplayWord maxKey = new DisplayWord("");
        for (Entry<DisplayWord, List<String>> entry : templatedWords.entrySet()) {
            //System.out.println(entry.getValue());
            if (entry.getValue().size() > max) {
                max = entry.getValue().size();
                maxKey = entry.getKey();
            }
        }

        // update secret word to match template of guesses
        remainingWords = templatedWords.get(maxKey);
        Collections.shuffle(remainingWords);
        secretWord = remainingWords.get(0);
        displayWord = maxKey;
    }
}