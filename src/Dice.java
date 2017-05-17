/**
 * March 13, 2017
 *This class below generates a random number 1-6 to simulate the numbers on the side of the dice and return the value that will match the dice.
 */

import java.util.Random;

public class Dice {

    private int sides;
    private int num;


    public Dice(int numberOfSides)
    {
        sides = numberOfSides;
        roll();
    }

	/*
	 * Method generates random numbers 1-6
	 */

    public void roll() {

        Random rand = new Random();
        num = rand.nextInt(sides);


    }

    public int getSides()
    {
        return sides;
    }
    public int getNum()
    {
        return num;
    }
}