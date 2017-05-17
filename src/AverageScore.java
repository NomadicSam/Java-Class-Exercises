/*
 * Simple app that calculates the user's average score.
 */

import java.util.Scanner;
public class AverageScore {
    public static void main ( String[] args)
    {
        //Scanner for user input.
        Scanner scanner = new Scanner (System.in);

        //declare the variables
        double firstScore,secondScore,thirdScore,average;

        //Get's user input from user to average the three scores.
        System.out.println ( "Please enter the first score" ); firstScore = scanner.nextDouble();
        System.out.println ( "Please enter the second score" ); secondScore = scanner.nextDouble();
        System.out.println ( "Please enter the third score" ); thirdScore = scanner.nextDouble();
        average =(firstScore + secondScore + thirdScore )/3;
        System.out.println("Your average of " + firstScore + ", " +secondScore + ", and " + thirdScore +" is " + average);
    } }