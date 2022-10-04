package com.shpp.p2p.cs.akartel.assignment3;

import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

/**
 * Assignment3Part4 builds pyramid in center y-axis from bottom
 */
public class Assignment3Part4 extends WindowProgram {
    final double BRICK_HEIGHT = 30;
    final double BRICK_WIDTH = 55;
    final double BRICK_SHIFT = BRICK_WIDTH * 1.2;
    final double BRICKS_IN_BASE = 11;

    /**
     * build pyramid at the bottom, centered in middle by y-axis
     * relatively to BRICK WIDTH, HEIGHT and number in base
     */
    @Override
    public void run() {
        double x = getWidth() / 2d - BRICK_WIDTH / 2;
        double y = getHeight() - BRICKS_IN_BASE * BRICK_SHIFT / 2;

        for (int i = 0; i < BRICKS_IN_BASE; i++) {
            for (int j = 0; j < i + 1; j++) {
                boxItem(x + BRICK_SHIFT * j - BRICK_SHIFT * i / 2, y + BRICK_SHIFT / 2 * i);
            }
        }
    }

    /**
     * adds black filled rectangle
     * @param x axis
     * @param y axis
     */
    private void boxItem(double x, double y) {
        GRect box = new GRect(x, y, BRICK_WIDTH, BRICK_HEIGHT);
        box.setFilled(true);
        add(box);
    }
}
