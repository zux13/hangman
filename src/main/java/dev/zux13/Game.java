package dev.zux13;

public class Game {

    private final Player player;
    private final int maxAttempts;
    private String hiddenWord;

    public Game() {
        player = new Player();
        maxAttempts = 7;
        hiddenWord = "";
    }

    private void processGuess(char ch) {
        //todo
    }

    private void startGame() {
        boolean quitMessage = false;
        Display.startMessage(maxAttempts);

        while (!player.gameOver(maxAttempts) && !quitMessage) {

            if (!hiddenWord.isEmpty()) {
                Display.roundMessage(player, hiddenWord);
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
                processGuess(input.charAt(0));
            }
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
    }
}