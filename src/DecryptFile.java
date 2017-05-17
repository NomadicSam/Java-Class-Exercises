/**
 *
 * OS files accessed:  file1 (generated, encrypted) and generates the decrypted file as file2.
 * Program: Decrypts the original encrypted file.
 */


import java.io.*;
import java.util.Scanner;


public class DecryptFile {

    public static void main(String args[] ) throws IOException
    {
        // Open the file from directory to read encrypted file. Saved in the same place
        // as program since no absolute or relative path.

        File file = new File ("file1.txt");
        Scanner inputFile = new Scanner(file);


        //Open a file to write the decrypted message to.
        PrintWriter outputFile = new
                PrintWriter("file2.txt");



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

                //Modify the code above to minus 20 to code since we added in encrypted program.
                char nc = (char)(encrypt - 20);

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