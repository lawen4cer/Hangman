package com.Personal.WRice;
import java.util.Scanner;

class Prompter {
    private Game game;

    public Prompter(Game game){
        this.game = game;
    }

    public boolean promptForGuess() {
        Scanner scanner = new Scanner(System.in);
        boolean isHit = false;
        boolean isAcceptable = false;

             do {
                     System.out.print("Enter a letter:  ");
                     String guessInput = scanner.nextLine();


                        try {
                            isHit = game.applyGuess(guessInput);
                            isAcceptable = true;
                            } catch (IllegalArgumentException iae) {
                             System.out.printf("%s.  Please try again. %n", iae.getMessage());
                        }
                 } while(! isAcceptable);
        return isHit;
    }

    public void displayProgress() {
        System.out.printf("You have %d tries left to solve:   %s%n", game.getRemainingTries(), game.getCurrentProgress());

    }

    public void displayOutcome() {
        if (game.isWon()) {
            System.out.println("Congratulations, you win the game!");
        } else {
            System.out.printf("Sorry, the correct word was %s ", game.getAnswer());
        }
    }

}
