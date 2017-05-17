/*
* This program reverses the two strings "Hello World" and "Hello Person" using recurison.
*/
public class ReverseRecursion {

    public static void main(String[] args) {
        //Print out the string in quotes. The string first goes to the method
        //reverse and prints out the outcome.
        System.out.println(reverse("HELLO Person"));
        System.out.println(reverse("Hello World"));

    }
    //Method to reverse the string in a recursive method.
    public static String reverse(String str){

        //If the string length is less than 0 or 1. It returns
        //the regular string.
        if(str.length()<=1)
            return str;
        else
            //if the string is greater than one. This method happens.
            //the String begins to reverse at the first position, which is the H.
            return reverse(str.substring(1, str.length())) +str.charAt(0);
    }

}