package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Logic {

        public static String GetWord(Player player, String difficulty) {

            int max = 172820;
            String word = "";
            boolean validWord = false;
            int minLength = 0;
            int maxLength = 0;

            if(difficulty.equalsIgnoreCase("e")){

                minLength = 5;
                maxLength = 10;
                player.setLives(15);
                player.setDifficultyMultiplier(1);

            } else if(difficulty.equalsIgnoreCase("m")){

                minLength = 10;
                maxLength = 15;
                player.setLives(10);
                player.setDifficultyMultiplier(2);

            } else if(difficulty.equalsIgnoreCase("h")){

                minLength = 15;
                maxLength = 20;
                player.setLives(5);
                player.setDifficultyMultiplier(3);

            }

            do{
            int line = ThreadLocalRandom.current().nextInt(10, max + 1);
            Scanner s = null;
            File words = new File("words.txt");

            try {
                s = new Scanner(words);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            for (int i = 0; i < line; i++) {

                s.nextLine();

                if (i == line - 1) {

                    word = s.nextLine();

                }

            }

            if(word.length() > minLength && word.length() < maxLength){

                validWord = true;

            }

            s.close();

        }while(!validWord);

            return word;
        }

        public static ArrayList<String> LetterChecker(Player player, ArrayList<String> letters, ArrayList<String> wordLetters, String guessedLetter)
        {
            ArrayList<String> newLetters = letters;

            for(int i = 0; i < wordLetters.size(); i++){

                String tempLetter = wordLetters.get(i);

                if(tempLetter.equalsIgnoreCase(guessedLetter)){

                    for(int j = 0; j < wordLetters.size(); j++){

                        if(tempLetter.equalsIgnoreCase(wordLetters.get(j))){

                            newLetters.remove(j);
                            newLetters.add(j, tempLetter);
                            player.AddScore();

                        }
                    }

                    return newLetters;
                }
            }

                player.LivesDecrement();

            return newLetters;
        }



}
