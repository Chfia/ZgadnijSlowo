package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ZgadnijSlowo {
    List<String> words = List.of("jeden", "dwa", "trzy", "cztery", "pięć");
    String word, userWord;
    int lives = 3;

    public void play() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Wylosowane słowo to: ");
        word = words.get(new Random().nextInt(words.size()));
        userWord = "_".repeat(word.length());

        while (!gameEnded()) {
            System.out.printf("%s%n%nPodaj literę%npozostało żyć: %d%n", userWord, lives);
            char letter = scanner.nextLine().charAt(0);
            checkLetter(letter);
        }

        System.out.println(lives == 0 ? "przegrałeś" : "Odgadłeś wszystkie litery");
        scanner.close();
    }

    private void checkLetter(char letter) {
        boolean foundLetter = false;

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                userWord = userWord.substring(0, i) + letter + userWord.substring(i + 1);
                foundLetter = true;
            }
        }

        if (!foundLetter) {
            System.out.println("Niestety nie ma takiej litery");
            lives--;
        }
    }

    private boolean gameEnded() {
        return lives == 0 || word.equals(userWord);
    }
}
