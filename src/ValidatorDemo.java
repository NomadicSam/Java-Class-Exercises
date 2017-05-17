import java.util.Scanner;

/**
 Demo program for the validator class
 11/13/16

 */

public class ValidatorDemo
{
    public static void main(String[] args)
    {
        int accountNumber; // account number to validate

        //create a scanner object
        Scanner keyboard = new Scanner (System.in);

        //create a validator object.
        Validator val = new Validator();

        //Get a charge account number
        System.out.print ("Enter your charge account number: ");
        accountNumber = keyboard.nextInt();

        //Determine whether it is valid.
        if (val.isValid(accountNumber))
            System.out.println ("That's a valid account number.");

        else
            System.out.println("That's an INVALID account number.");

    }
}
