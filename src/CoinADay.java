/**

 10.17.16

 Program that calculates the amount a person would
 earn over a period of time if his or her salary is one penny the first day,
 two pennies the second day, and continues to double each day.
 **/

import java.util.Scanner;
import java.text.DecimalFormat;


public class CoinADay {

    public static void main(String[] args) {
        int pennies;    //Current day's pay in pennies.
        int totalPay;    // Total pay accumulator
        int maxDays;    // Max number of days
        int dayCount;    // Day counter.


        //Create a Scanner object for keyboard input.
        Scanner keyboard = new Scanner(System.in);


        //Get maximum number of days from user.
        System.out.print("How many days will you work?");
        maxDays = keyboard.nextInt();


        //Validate the input.
        while (maxDays < 1) {

            //Prompt user to enter a correct value.
            System.out.println("The number of days must be at least 1");
            System.out.print("Enter the number of days: ");
            maxDays = keyboard.nextInt();
            //Initialize day counter to day 1
            dayCount = 1;

            //Initialize penny accumulator for first day of work.
            pennies = 1;

            //Initialize total pay accumulator
            totalPay = 0;

            //Display the report
            System.out.println();
            System.out.println("Day\t\tPennies Earned");
            System.out.println("-----------------------------");

            //Display the income report
            while (dayCount <= maxDays) {
                // Display the day number and pennies earned.
                System.out.println(dayCount + "\t\t" + pennies);

                //Accumulate the totalPay
                totalPay += pennies;

                //Increment dayCount for next day.
                dayCount++;

                //Double the number of pennies.
                pennies *= 2;

            }

            //Create DecimalFormat object to format output.
            DecimalFormat dollar = new DecimalFormat(" #, ##0.00");

            //Display total pay.
            System.out.println("Total pay: $" + dollar.format(totalPay / 100.0));
        }
    } //Close main

}//Close program
