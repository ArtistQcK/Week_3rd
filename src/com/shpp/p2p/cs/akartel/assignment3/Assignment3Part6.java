package com.shpp.p2p.cs.akartel.assignment3;

import acm.graphics.GArc;
import acm.graphics.GLabel;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.random.RandomGenerator;

/**
 * Assignment3Part6 show us animation where Pacman try to collect JAVA - word
 * he eats random symbols in the center of the window and if J,A or V - shows it on window
 * as symbols is random nobody knows could he collect JAVA this time or not
 * for this mission only 5 seconds available
 */
public class Assignment3Part6 extends WindowProgram {
    private static final double SYMBOLS_QUANTITY = 30;
    private static final double PACMAN_SIZE = 100;
    private static final double PAUSE_TIME = 10;
    Random rnd = new Random();
    GArc pacman;
    GLabel java, result, timeL;
    ArrayList<GLabel> symbols = new ArrayList<>();
    String j = "  ", a = "  ", v = "  ";
    Color JAVA_COLOR = new Color(83, 130, 161);

    /**
     * build Pacman , symbols and labels then feed pacman with symbols (5s) and shows results in labels
     */
    @Override
    public void run() {
        labelsInvoke();
        symbolsInvoke();
        pacmanInvoke();
        animation();
        results();
    }

    /**
     * creates and labels before change text for them while animation
     */
    private void labelsInvoke() {
        result = new GLabel("", getWidth() / 2d, getHeight() * 3 / 4d);
        result.setColor(JAVA_COLOR);
        result.setFont("-30");
        add(result);


        java = new GLabel("", getWidth() / 2d, getHeight() / 3d);
        java.setFont("-50");
        java.setColor(JAVA_COLOR);
        add(java);

        add(timeL = new GLabel("", 20, 40));
        timeL.setFont("-25");
        timeL.setColor(JAVA_COLOR);
    }

    /**
     * method shows if Pacman failed to collect java-word in case he not
     * also set pacman in east side of window after animation
     */
    private void results() {
        if (result.getLabel().equals("")) result.setLabel("Failed to collect JAVA");

        pacman.setLocation(getWidth() - PACMAN_SIZE, getHeight() / 2d - PACMAN_SIZE / 2);
    }

    /**
     * create line of random symbols from (A to V) via random Int to create chars
     * and cast it to string , symbols location center of window from left to right
     * also we put all symbols in-to ArrayList to have index for each of them
     */
    private void symbolsInvoke() {
        double symbolsShift = (getWidth() - PACMAN_SIZE) / SYMBOLS_QUANTITY;

        for (int i = 0; i < SYMBOLS_QUANTITY; i++) {
            Character ch = (char) rnd.nextInt(65, 87);
            GLabel symbol = new GLabel(ch.toString());

            symbol.setLocation(PACMAN_SIZE + i * symbolsShift,
                    getHeight() / 2d + RandomGenerator.getDefault().nextInt(0, 15));
            symbol.setColor(JAVA_COLOR);
            symbol.setFont("-18");
            symbols.add(symbol);
            add(symbol);

        }
    }

    /**
     * add Pacman model created from GArc object
     */
    private void pacmanInvoke() {
        pacman = new GArc(0, getHeight() / 2d - PACMAN_SIZE / 2, PACMAN_SIZE, PACMAN_SIZE, 45, 270);
        pacman.setFilled(true);
        pacman.setColor(new Color(255, 180, 15));
        add(pacman);
    }

    /**
     * animation moves Pacman while he eats symbols some informative labels appears : time count until 5 seconds ,
     * result of Pacman journey (collecting J,A,V symbols) and java Label to show progress
     * animation loop lasts ~5000ms
     */
    private void animation() {
        int i = 0;
        double time = System.currentTimeMillis() + 5000;
        while (time > System.currentTimeMillis()) {

i++;
            feedPacman();
            timeLabel(time);
            pause(PAUSE_TIME);
            pacman.movePolar(2.2, 0);
        }
        System.out.println(i);
    }

    /**
     * shows time
     *
     * @param t - time
     */
    private void timeLabel(double t) {
        t -= 5000;
        timeL.setLabel("" + (System.currentTimeMillis() - t));
    }

    /**
     * find out what symbol Pacman ate and collect them in to label or remove
     */
    private void feedPacman() {
        for (int i = 0; i < symbols.size(); i++) {

            if (getElementAt(pacman.getX() + PACMAN_SIZE / 2, pacman.getY() + PACMAN_SIZE / 2) == symbols.get(i)) {

                collectJava(i);
                remove(symbols.get(i));
                mouseBiteImitation(i);
            }
        }
    }

    /**
     * checks if pacman ate J , A or V symbol and add it in label (java)
     * also if JAVA word collected (result) label shows notification for user
     *
     * @param i - index in symbols ArrayList
     */
    private void collectJava(int i) {
        if (Objects.equals(symbols.get(i).getLabel(), "J")) j = "J";
        if (Objects.equals(symbols.get(i).getLabel(), "A")) a = "A";
        if (Objects.equals(symbols.get(i).getLabel(), "V")) v = "V";
        java.setLabel(j + a + v + a);

        if (java.getLabel().equals("JAVA")) result.setLabel("Mission accomplished");
    }

    /**
     * method open and close Pacman mouse while moving through
     * symbols line via every second symbol
     *
     * @param i - index of symbols ArrayList
     */
    private void mouseBiteImitation(int i) {
        if (i % 2 == 1) {
            pacman.setStartAngle(10);
            pacman.setSweepAngle(340);

        } else {
            pacman.setStartAngle(45);
            pacman.setSweepAngle(270);
        }
    }
}
