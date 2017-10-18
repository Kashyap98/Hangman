package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {

        int max = 172820;
        int line;
        int wordLength;
        int emptyCount;
        int lives;
        Scanner s = new Scanner(System.in);
        Player player = new Player();

        ArrayList<String> letters = new ArrayList();
        ArrayList<String> guessedLetters = new ArrayList();
        ArrayList<String> wordLetters = new ArrayList();

        String word = "";
        lives = 10;
        line = ThreadLocalRandom.current().nextInt(10, max + 1);

        word = Logic.GetWord(line);
        wordLength = word.length();

        for(int i = 0; i < wordLength; i++){

            letters.add("_");
            wordLetters.add(String.valueOf(word.charAt(i)));

        }

        System.out.println("Word: " + word);
        System.out.println("Word Length: " + wordLength);
        System.out.println(letters);
        System.out.println(wordLetters);

        do {
            emptyCount = 0;

            System.out.println("Enter a letter.");
            String guessedLetter = String.valueOf(s.nextLine());

            guessedLetters.add(guessedLetter);

            letters = Logic.LetterChecker(player, letters, wordLetters, guessedLetter);
            System.out.println(letters);

            for(int i = 0; i < letters.size(); i ++){

                String tempChar = letters.get(i);

                if(tempChar.equalsIgnoreCase("_")){

                    emptyCount++;

                }

            }

            System.out.println("You have " + emptyCount + " spaces left and " + player.getLives() + " lives left.");
            System.out.println("You have guessed " + guessedLetters);
        }while(emptyCount != 0);

        System.out.println("Congrats! Your word was " + word);

        s.close();
    }
}

