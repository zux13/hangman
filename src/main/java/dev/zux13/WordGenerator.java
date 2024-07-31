package dev.zux13;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

public class WordGenerator {

    public static String generate(int difficulty) {

        try (BufferedReader br = new BufferedReader(new FileReader(".\\src\\main\\resources\\words.txt"))) {
            List<String> list = br.lines().filter(getPredicate(difficulty)).toList();
            Random rnd = new Random();
            return list.get(rnd.nextInt(list.size()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Predicate<String> getPredicate(int difficulty) {
        if (difficulty == 2) {
            return string -> string.length() >= 5 && string.length() <= 7;
        } else if (difficulty == 3) {
            return string -> string.length() >= 8 && string.length() <= 10;
        }
        return string -> string.length() >= 3 && string.length() <= 4;
    }
}
