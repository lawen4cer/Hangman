package com.Personal.WRice;

public class Hangman {

    public static void main(String[] args) {
        Game game = new Game();
        Prompter prompter = new Prompter(game);
    do{
        do {
            prompter.displayProgress();
            prompter.promptForGuess();
    } while (game.getRemainingTries() > 0 && !game.isWon());
    prompter.displayOutcome();
    } while (game.resetGame(prompter.getPromptForReset()));

    }
}
