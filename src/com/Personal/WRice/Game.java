package com.Personal.WRice;

public class Game {
    public static final int MAX_MISSES = 7;
    private static final int MAX_NUM = 5;
    private static final int MIN_NUM = 0;
    private String[] answerArray = {"apple", "banana", "orange", "grape", "strawberry", "pineapple",};
    private String answer;
    private String hits;
    private String misses;
    private int randomNumber;
    protected String progress = "";
    protected char display = '-';
    protected char letter = '\0';



    public Game(){
    this.answer = answerArray[getRandomNumber()];
        hits = "";
        misses = "";
    }

    public boolean resetGame(int promptForReset) {
        if (promptForReset == 1) {
            setDisplay('-');
            setCurrentProgress("");
            setLetter('\0');
            return true;
        }else {return false;}
    }

    public int getRandomNumber() {
     randomNumber = MIN_NUM + (int) (Math.random() * MAX_NUM);
     return randomNumber;
    }

    private char normalizeGuess(char letter){
        if(! Character.isLetter(letter)){
            throw new IllegalArgumentException("A letter is required");
        }
        if(misses.indexOf(letter) != -1 || hits.indexOf(letter) != -1){
            throw new IllegalArgumentException(letter + " has already been guessed");
        }
        return letter;
    }

    public boolean applyGuess(char letter){
        letter = normalizeGuess(letter);
        boolean isHit = answer.indexOf(letter) != -1;
        if (isHit) {
            hits += letter;
        }else {
            misses += letter;
        }
        return isHit;
    }

    public boolean applyGuess(String letters){
        if(letters.length() == 0) {
            throw new IllegalArgumentException("No characters found");
        }
        return applyGuess(letters.charAt(0));

    }

    public int getRemainingTries() {
        return MAX_MISSES - misses.length();

    }

    public String getCurrentProgress() {
        progress = "";
        for (char letter : answer.toCharArray()) {
            display = '-';
            if (hits.indexOf(letter) != -1) {
                display = letter;
            }
            progress += display;
        }
        return progress;
    }

    public void setCurrentProgress(String progress) {
        this.progress = progress;
    }

    public void setDisplay(char display) {
        this.display = display;
    }

    public void setLetter(char letter) {
        this.letter = letter;

    }



    public boolean isWon() {
        return getCurrentProgress().indexOf('-') == -1;
    }

    public String getAnswer() {
        return answer;
    }
}
