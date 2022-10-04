package com.shpp.p2p.cs.akartel.assignment3;

import com.shpp.cs.a.console.TextProgram;

import java.util.Random;

/**
 * Assignment3Part5 program show imitation of some casino game to define
 * how fast you can increase your money up to 20$ by throwing coin
 */

public class Assignment3Part5 extends TextProgram {
    /**
     * imitates game of throwing coin and multiply prize money until get 20$ finally
     */
    @Override
    public void run() {
        play();
        tryAgain();
    }

    /**
     *imitates game of throwing coin
     * money prize doubles if tail-side of coin
     * and adds to total sum until total = 20$ or above
     */
    private void play() {
        int count = 0;
        int total = 0;
        Random randomCoin = new Random();

        while (total < 20) {
            int current = 1;
            while (randomCoin.nextBoolean())current *= 2;
            count++;
            total += current;
            println("This game, you earned $ " + current);
            println("Your total is $ " + total);
        }
        println("It took " + count + " games to earn $20");
    }

    /**
     * method invoke run() again or stop program if type 'stop'
     */
    private void tryAgain() {
        if (!readLine("Type 'stop' to finish program\n\n").equalsIgnoreCase("stop")) run();
    }
}
