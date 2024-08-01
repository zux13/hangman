package dev.zux13;

import java.util.HashSet;
import java.util.Set;

public class Player {

    private final Set<Character> guessedLetters;
    private final Set<Character> mistakenLetters;
    private int difficulty;

    public Player () {
        guessedLetters = new HashSet<>();
        mistakenLetters = new HashSet<>();
        difficulty = 0;
    }

    public Set<Character> getGuessedLetters() {
        return guessedLetters;
    }

    public Set<Character> getMistakenLetters() {
        return mistakenLetters;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public boolean alreadyGuessed(char ch) {
        return guessedLetters.contains(ch);
    }

    public void manageGuess(char guess, String hiddenWord) {
        for (char ch : hiddenWord.toCharArray()) {
            if (ch == guess) {
                guessedLetters.add(guess);
                return;
            }
        }
        mistakenLetters.add(guess);
    }

    public boolean won(String hiddenWord) {
        for (char ch: hiddenWord.toCharArray()) {
            if (!guessedLetters.contains(ch)) {
                return false;
            }
        }
        return true;
    }

    public boolean lost(int maxAttempts) {
        return mistakenLetters.size() >= maxAttempts;
    }
}
