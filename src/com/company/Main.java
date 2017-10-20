package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {

        int wordLength;
        int emptyCount;
        String cont = "yes";
        Player player = new Player();
        Scanner s = new Scanner(System.in);

        String difficulty = "";

        do{

            System.out.println("Please select a difficulty by typing 'e', 'm', or 'h' for Easy, Medium, or Hard respectively.");
            System.out.println("Easy - Min Length: 5, Max Length: 10, Lives: 15, Score Multiplier: 1");
            System.out.println("Medium - Min Length: 10, Max Length: 15, Lives: 10, Score Multiplier: 2");
            System.out.println("Hard - Min Length: 15, Max Length: 20, Lives: 5, Score Multiplier: 3");
            difficulty = s.nextLine();

        }while(!(difficulty.equalsIgnoreCase("e") || difficulty.equalsIgnoreCase("m") || difficulty.equalsIgnoreCase("h")));

        do {
            ArrayList<String> letters = new ArrayList();
            ArrayList<String> guessedLetters = new ArrayList();
            ArrayList<String> wordLetters = new ArrayList();

            String word = "";

            word = Logic.GetWord(player, difficulty);
            player.setWord(word);
            wordLength = word.length();

            for (int i = 0; i < wordLength; i++) {

                letters.add("_");
                wordLetters.add(String.valueOf(word.charAt(i)));

            }

            System.out.println("Word: " + word);
            System.out.println("Word Length: " + wordLength);
            System.out.println(letters);
            //System.out.println(wordLetters);

            do {
                emptyCount = 0;
                boolean validLetter = false;
                String guessedLetter = "";

                //do {

                    System.out.println("Enter a letter.");
                    guessedLetter = String.valueOf(s.nextLine());

                    validLetter = guessedLetters.contains(guessedLetter);
                    System.out.println(validLetter);

                //}while(validLetter = true);

                guessedLetters.add(guessedLetter);

                letters = Logic.LetterChecker(player, letters, wordLetters, guessedLetter);
                System.out.println(letters);

                for (int i = 0; i < letters.size(); i++) {

                    String tempChar = letters.get(i);

                    if (tempChar.equalsIgnoreCase("_")) {

                        emptyCount++;

                    }

                }

                System.out.println("You have " + emptyCount + " spaces left and " + player.getLives() + " lives left.");
                System.out.println("You have guessed: " + guessedLetters);
                System.out.println("Your score is:  " + player.getScore());
            } while (emptyCount != 0);

            player.FinishWord();
            System.out.println("Congrats! Your word was " + word);
            System.out.println("Your score is:  " + player.getScore());
            System.out.println("If you would like to continue enter yes, otherwise enter no.");
            cont = s.nextLine();

        }while(cont.equalsIgnoreCase("yes"));

        System.out.println("Thanks for playing!");

        s.close();
    }
}

