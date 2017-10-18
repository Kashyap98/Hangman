package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Logic {


        public static String GetWord(int line){

            Scanner s = null;
            String word = "";
            File words = new File("words.txt");

            try {
                s = new Scanner(words);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            for(int i = 0; i < line; i++){

                s.nextLine();

                if(i == line - 1){

                    word = s.nextLine();

                }

            }

            s.close();
            return word;
        }

        public static ArrayList<String> LetterChecker(Player player, ArrayList<String> letters, ArrayList<String> wordLetters, String guessedLetter)
        {
            ArrayList<String> newLetters = letters;
            int letterCount = 0;

            for(int i = 0; i < wordLetters.size(); i++){

                String tempLetter = wordLetters.get(i);

                if(tempLetter.equalsIgnoreCase(guessedLetter)){

                    for(int j = 0; j < wordLetters.size(); j++){

                        if(tempLetter.equalsIgnoreCase(wordLetters.get(j))){

                            newLetters.remove(j);
                            newLetters.add(j, tempLetter);
                            letterCount++;

                        }
                    }
                }
            }
            if(letterCount == 0){

                player.LivesDecrementer();

            }

            return newLetters;
        }



}
