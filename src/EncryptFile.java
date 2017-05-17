/**
 * OS files accessed: file0 and file1 (generated, encrypted)
 * Program: Encrypts a file.
 */


import java.io.*;
import java.util.Scanner;


public class EncryptFile {

    public static void main(String args[] ) throws IOException
    {
        // Open the file from directory to read. Saved in the same place
        // as program since no absolute or relative path.

        File file = new File ("file0.txt");
        Scanner inputFile = new Scanner(file);


        //Open a file to write to.
        PrintWriter outputFile = new
                PrintWriter("file1.txt");



        //Reads all lines from the file until done.
        while(inputFile.hasNext())
        {
            //read the next line
            String str = inputFile.nextLine();

            for(int x = 0; x < str.length(); x++)
            {
                //Gets one character at a time.
                char c = str.charAt(x);

                //Changes the character into algorithm.
                int encrypt = (int) c;

                //Modify the code above to add 20 to code.
                char nc = (char)(encrypt + 20);

                // Print the code in the output file.
                outputFile.print(nc);
            }

            outputFile.println();
        }
        //Close the files.
        inputFile.close();
        outputFile.close();

    } // end main method.

} //end entire Encrypt file class.