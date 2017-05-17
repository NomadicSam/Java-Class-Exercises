/**
 * Validation Class
 *11/13/16
 */

public class Validator
{
    //Array of valid numbers
    private int[] valid = { 565884, 4520125, 7895122, 8777541,
            0451277, 1302850, 8080152, 4562555,
            5552012, 5050552, 7825877, 1250255,
            1005231, 6545231, 3852085, 7576651,
            7881200, 4581002

    };

    /**
     The isValid method uses a sequential search to determine whether
     the number argument appears in the array of valid numbers.
     If the number is found, the method returns true. Otherwise,
     the method returns false.

     */

    public boolean isValid (int number)
    {
        boolean found = false; //search flag
        int index = 0;		// array index

        //search the valid array to see if number appears in it.

        while (!found && index < valid.length)
        {
            if (valid [index] == number)
                found =true;
            else
                index++;


        }

        //return the status of the search.
        return found;
    }
}
