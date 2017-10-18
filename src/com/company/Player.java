package com.company;

public class Player {

    private int lives = 10;

    public void LivesDecrementer(){

        setLives(getLives() - 1);

        if(getLives() <= 0){

            System.out.println("Oh no! Looks like you have lost all your lives!" );

            System.exit(1);
        }

    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

}
