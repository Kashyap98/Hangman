package com.company;

public class Player {

    private int lives = 10;
    private int score = 0;
    private int letterScore = 100;
    private int wordScore = 500;
    private int difficultyMultiplier = 1;
    private String word = "";

    public void LivesDecrement(){

        setLives(getLives() - 1);

        if(getLives() <= 0){

            System.out.println("Oh no! Looks like you have lost all your lives!" );
            System.out.println("The word was: " + getWord());
            System.exit(1);
        }

    }

    public void AddScore(){

        int addition = letterScore * difficultyMultiplier;
        setScore(getScore() + addition);

    }

    public void FinishWord(){

        int addition = wordScore * difficultyMultiplier;
        setScore(getScore() + addition);

    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getDifficultyMultiplier() {
        return difficultyMultiplier;
    }

    public void setDifficultyMultiplier(int difficultyMultiplier) {
        this.difficultyMultiplier = difficultyMultiplier;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
