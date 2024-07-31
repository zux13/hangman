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

    public static void startMessage(int maxAttempts) {
        System.out.printf("""
                Добро пожаловать в игру 'Висельник'!
                Ваша задача — угадать слово за %d попыток.
                В любой момент вы можете завершить игру, введя 'Выход'
                Для начала игры выберите сложность, введя число от 1 до 3:
                """, maxAttempts);
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

        int mistakes = player.getMistakes();
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

    public static void gameOver(Player player, String hiddenWord) {
        //todo
    }

    public static void quitMessage() {
        System.out.println("Всего ХО-РО-ШЕ-ГО!");
    }

}
