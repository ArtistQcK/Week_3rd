package com.shpp.p2p.cs.akartel.assignment3;

import com.shpp.cs.a.console.TextProgram;

/**
 * Assignment3Part2 shows the sequence of "Gradient number"
 * via casting any positive number util it become '1'
 */
public class Assignment3Part2 extends TextProgram {
    int n;

    /**
     * method ask user to input positive number above 1
     * in case correct entered values
     * cast it until it gets to '1' and shows sequence
     * method asks to type 'stop' for  finish
     */
    @Override
    public void run() {
        if (userInput())castToOne();
        tryAgain();
    }

    /**
     * starts method run until user type stop
     */
    private void tryAgain() {
        if (!readLine("Type 'stop' to finish program ").equalsIgnoreCase("stop")) run();
    }

    /**
     * cast any positive number above one to one via divide by 2 even numbers
     * and multiply x3 and add one for odd numbers
     * and print it
     */
    private void castToOne() {
        while (n != 1) {
            if (n % 2 == 0) {
                print(n + " is even so I take half: ");
                n /= 2;
                println(n);
            } else {
                print(n + " is odd so I make 3n + 1: ");
                n = n * 3 + 1;
                println(n);
            }
        }
    }

    /**
     * user number entry + check for positive number above one
     * @return true of false
     */
    private Boolean userInput() {
        boolean result;
        try {
            if ((n = readInt("Enter a number: ")) > 1) result = true;
              else {
                  println("YOU SHOULD ENTRY POSITIVE NUMBER ABOVE 1");
                  result = false;
            }
        } catch (Exception e) {
            println("YOU SHOULD ENTRY POSITIVE NUMBER ABOVE 1 (NO LETTERS)");
            result = false;
        }
        return result;
    }
}

