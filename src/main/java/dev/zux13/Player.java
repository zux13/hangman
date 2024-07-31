package dev.zux13;

import java.util.HashSet;
import java.util.Set;

public class Player {

    private Set<Character> guessedLetters;
    private int mistakes;
    private int difficulty;

    public Player () {
        guessedLetters = new HashSet<>();
        mistakes = 0;
        difficulty = 0;
    }

    public Set<Character> getGuessedLetters() {
        return guessedLetters;
    }

    public void setGuessedLetters(Set<Character> guessedLetters) {
        this.guessedLetters = guessedLetters;
    }

    public int getMistakes() {
        return mistakes;
    }

    public void setMistakes(int mistakes) {
        this.mistakes = mistakes;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public boolean gameOver(int maxAttempts) {
        return mistakes >= maxAttempts;
    }

}
