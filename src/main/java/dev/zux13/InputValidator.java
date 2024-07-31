package dev.zux13;

public class InputValidator {

    public static boolean isQuitMessage(String input) {
        return "выход".equalsIgnoreCase(input);
    }

    public static boolean isValidInt(String input) {
        try {
            int number = Integer.parseInt(input);
            return number > 0 && number < 4;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isSingleCyrillicCharacter(String input) {
        if (input != null && input.length() == 1) {
            char ch = input.charAt(0);
            return (ch >= '\u0400' && ch <= '\u04FF') || (ch >= '\u0500' && ch <= '\u052F');
        }
        return false;
    }
}
