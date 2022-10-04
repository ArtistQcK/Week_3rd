package com.shpp.p2p.cs.akartel.assignment3;

import com.shpp.cs.a.console.TextProgram;

public class Assignment3Part3 extends TextProgram {
    @Override
    public void run() {
        println(raiseToPower(readDouble("Enter base number (double) "), readInt("Enter exponent (int) ")));
        tryAgain();
    }

    private double raiseToPower(double base, int exponent) {
        double result = base;
        if (exponent < 0) {
            result = 1 / base;
            base = 1 / base;
            exponent = -exponent;
        }
        for (int i = 0; i < exponent - 1; i++) result *= base;
        if (exponent == 0) result = 1;
        return result;
    }
    private void tryAgain() {
        if (!readLine("Type 'stop' to finish program ").equalsIgnoreCase("stop")) run();
    }
}
