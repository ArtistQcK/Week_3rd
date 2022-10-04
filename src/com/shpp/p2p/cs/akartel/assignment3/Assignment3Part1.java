package com.shpp.p2p.cs.akartel.assignment3;

import com.shpp.cs.a.console.TextProgram;

/**
 * Assignment3Part1 asks the user for the number of minutes spent exercising in the last seven days,
 * and accordingly , reports the following:
 * whether sufficient time was devoted to exercise for (cardiovascular,blood pressure) health
 */
public class Assignment3Part1 extends TextProgram {
    int cardiovascularDeficiency = 5, bloodPressureDeficiency = 3;

    /**
     * method ask user to input time he makes exercises for every day in a week
     * and in case correct values entered prints answer
     * then asking for run method again or finish it by typing 'stop'
     */
    @Override
    public void run() {
        if (userInput()) answerOutput();
        tryAgain();
    }

    /**
     * set variables to previous values
     * start program again or stop it - case user types "stop"
     */
    private void tryAgain() {
        cardiovascularDeficiency = 5;
        bloodPressureDeficiency = 3;
        if (!readLine("Type 'stop' to finish program ").equalsIgnoreCase("stop")) run();
    }

    /**
     * prints results relatively to bloodPressure , cardiovascular exercises deficiency
     */
    private void answerOutput() {
        println(cardiovascularDeficiency > 0 ? "Cardiovascular health:\n" +
                "  You needed to train hard for at least " + cardiovascularDeficiency + " more day(s) a week!" :
                "Cardiovascular health:\nGreat job! You've done enough exercise for cardiovascular health.");

        println(bloodPressureDeficiency > 0 ? "Blood pressure:\n" +
                "You needed to train hard for at least " + bloodPressureDeficiency + " more day(s) a week!" :
                "Blood pressure:\nGreat job !You've done enough exercise to keep a low blood pressure.");
    }

    /**
     * method ask user to input amount of time he spends for training
     * and define bloodPressure , cardiovascular deficiency for current week
     * @return boolean
     */
    private Boolean userInput() {
        final int WEEK = 7;
        try {
            for (int i = 1; i < WEEK + 1; i++) {
                int exercisesTime = readInt("How many minutes did you do on day " + i + "? ");
                if (exercisesTime >= 40) bloodPressureDeficiency--;
                if (exercisesTime >= 30) cardiovascularDeficiency--;
            }
            return true;
        } catch (Exception e) {
            println("\nYOU SHOULD INPUT ONLY DIGITS , TRY AGAIN OR ");
            return false;
        }
    }
}



