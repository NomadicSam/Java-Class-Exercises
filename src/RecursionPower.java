/*
 * 4/4/17
 * This problem calculates the power of an integer by using recursion as
 * the calculation process.
 */

import java.io.*;
import java.util.Scanner; //needed for user input

class RecursionPower {

    public static void main(String[] args)
    {
        //variable declaration.
        int x, y, result;

        //create scanner obj. for keyboard input.
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter Number value:");
        x = keyboard.nextInt();

        //inputting y value
        System.out.println("Enter the Power Value:");
        y = keyboard.nextInt();

        //calls to the created method below.
        result = power (x,y);

        // Format output result.
        System.out.println(x+" Power "+y+" is : "+result);

        //close window when done.
        System.exit(0);

    } //end static main.

    //function to raise x to the power n.
    public static int power (int x, int n)
    {
        if(n == 0)
            return 1;

        else
            return x * power(x, n-1);
    }// end power function.
} //end program.

