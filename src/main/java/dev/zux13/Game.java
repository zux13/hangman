package dev.zux13;

public class Game {

    private Player player;
    private final int maxAttempts;
    private String hiddenWord;

    public Game() {
        maxAttempts = 7;
        initializeFields();
    }

    private void initializeFields() {
        player = new Player();
        hiddenWord = "";
    }

    private void processGuess(char guess) {

        if (player.alreadyGuessed(guess)) {
            Display.alreadyGuessed(guess);
            return;
        }

        player.manageGuess(guess, hiddenWord);

        if (player.won(hiddenWord)) {
            Display.victoryMessage(player, hiddenWord);
            initializeFields();
        }

        if(player.lost(maxAttempts)) {
            Display.gameOver(player, hiddenWord);
            initializeFields();
        }

    }

    private void startGame() {

        Display.welcomeMessage(maxAttempts);

        boolean quitMessage = false;
        while (!quitMessage) {

            if (!hiddenWord.isEmpty()) {
                Display.roundMessage(player, hiddenWord);
            } else {
                Display.startGameMessage();
            }

            String input = InputHandler.getLine();

            if (InputValidator.isQuitMessage(input)) {
                quitMessage = true;
                Display.quitMessage();
            } else if(player.getDifficulty() == 0) {
                if (InputValidator.isValidInt(input)) {
                    int difficulty = Integer.parseInt(input);
                    player.setDifficulty(difficulty);
                    hiddenWord = WordGenerator.generate(difficulty);
                } else {
                    Display.invalidIntMessage();
                }
            } else {
                if (!InputValidator.isSingleCyrillicCharacter(input)) {
                    Display.invalidInput();
                    continue;
                }
                processGuess(Character.toLowerCase(input.charAt(0)));
            }
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
    }
}