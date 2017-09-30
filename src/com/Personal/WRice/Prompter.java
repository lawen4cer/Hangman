package com.Personal.WRice;
import java.util.Scanner;

class Prompter {
    public int promptForReset;
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
        Scanner scan = new Scanner(System.in);
        if (game.isWon()) {
            System.out.println("Congratulations, you win the game!");
            System.out.println("Would you like to play again?  Enter 1 to play again.. ");
            promptForReset = scan.nextInt();

        } else {
            System.out.printf("Sorry, the correct word was %s ", game.getAnswer());
            System.out.println("Would you like to play again?  Enter 1 to play again.. ");
            promptForReset = scan.nextInt();
        }
    }

    public int getPromptForReset() {
        return promptForReset;

    }

}
