package dev.zux13;

import java.util.Map;
import java.util.Set;

public class Display {

    private static final String[] hangmanStages = {"""
                                       _____
                                      |     |
                                      |    \s
                                      |   \s
                                      |   \s
                                      |   \s
                                    __|____
                                    ""","""
                                       _____
                                      |     |
                                      |     O
                                      |   \s
                                      |   \s
                                      |   \s
                                    __|____
                                    ""","""
                                       _____
                                      |     |
                                      |     O
                                      |     |
                                      |   \s
                                      |   \s
                                    __|____
                                    ""","""
                                       _____
                                      |     |
                                      |     O
                                      |    /|
                                      |   \s
                                      |   \s
                                    __|____
                                    ""","""
                                       _____
                                      |     |
                                      |     O
                                      |    /|\\
                                      |   \s
                                      |   \s
                                    __|____
                                    ""","""
                                       _____
                                      |     |
                                      |     O
                                      |    /|\\
                                      |    /\s
                                      |   \s
                                    __|____
                                    ""","""
                                       _____
                                      |     |
                                      |     O
                                      |    /|\\
                                      |    / \\
                                      |   \s
                                    __|____
                                    """
    };

    private static final Map<Integer, String> difficultyLabels = Map.of(
            1, "Легко",
            2, "Средне",
            3, "Сложно");

    public static void welcomeMessage(int maxAttempts) {
        System.out.printf("""
                Добро пожаловать в игру 'Висельник'!
                Ваша задача — угадать слово за %d попыток.
                """, maxAttempts);
    }

    public static void startGameMessage() {
        System.out.println("\nВведите 'Выход', для выхода.\nВведите число от 1 до 3, чтобы начать игру:");
        for (int i = 1; i <= 3; i++) {
            System.out.printf("%d. %s\n", i, difficultyLabels.get(i));
        }
    }

    public static void invalidIntMessage() {
        System.out.println("Неверный ввод! Ожидается число от 1 до 3 включительно, или 'Выход'");
    }

    public static void invalidInput() {
        System.out.println("Неверный ввод! Ожидается единственный символ в Кириллической (русской) раскладке");
    }

    public static void roundMessage(Player player, String hiddenWord) {

        int mistakes = player.getMistakenLetters().size();
        Set<Character> set = player.getGuessedLetters();

        if (mistakes > 0) {
            System.out.println(hangmanStages[mistakes - 1]);
        }
        for (char ch : hiddenWord.toCharArray()) {
            if (set.contains(Character.toLowerCase(ch))) {
                System.out.print(Character.toUpperCase(ch) + " ");
            } else {
                System.out.print("_ ");
            }
        }
        System.out.printf(
                "\nБукв угадано: %d | Ошибок: %d | Сложность: %s\n"
                , set.size()
                , mistakes
                , difficultyLabels.get(player.getDifficulty())
        );
    }

    public static void alreadyGuessed(char ch) {
        System.out.println("Вы уже открыли символ '" + ch + "'");
    }

    public static void gameOver(Player player, String hiddenWord) {
        System.out.println(hangmanStages[player.getMistakenLetters().size() - 1]);
        System.out.printf("""
                ======== GAME OVER ========
                Увы, вам не удалось отгадать слово '%s'.
                Тем не менее, вы угадали %d букв(ы). Сыграем ещё?
                """, hiddenWord.toUpperCase(), player.getGuessedLetters().size());
    }

    public static void victoryMessage(Player player, String hiddenWord) {
        System.out.printf("""
                ======== П О Б Е Д А! ========
                Поздравляем! Вы угадали слово — '%s'.
                И всего лишь %d ошибки! Сыграем ещё?
                """, hiddenWord.toUpperCase(), player.getMistakenLetters().size());
    }

    public static void quitMessage() {
        System.out.println("Спасибо за игру! Всего хорошего!");
    }

}
