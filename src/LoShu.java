/**
 * Created by on 11/13/16
 */
public class LoShu {
    public static boolean check(int[][] a){
        int sum,s;
        sum=0;
        for (int col = 0; col< 3; col++) //first set the sum
            sum += a[0][col];

        //check the next two rows
        s = 0;
        for (int row = 1; row < 3; row++){
            s = 0;
            for (int col = 0; col< 3; col++)
                s += a[row][col];
            if (s != sum)
                return false;
        }

        //check columns
        for (int col = 0; col< 3; col++) {
            s = 0;
            for (int row = 0; row < 3; row++){
                s += a[row][col];
            }
            if (s != sum)
                return false;
        }

        //check diagonal 1
        s =0;
        for (int row = 0; row < 3; row++){
            s += a[row][row];
        }
        if (s != sum)
            return false;

        //check diagonal 2
        s =0;
        for (int row = 0; row < 3; row++){
            s += a[row][2 - row];
        }
        if (s != sum)
            return false;

        //check that the numbers 1..9 appear
        //We use an array of booleans and mark each one as we find it.
        boolean[] appears = new boolean[9];
        for (int i=0; i < 9; i++){
            appears[i] = false;
        }

        //Check each one
        for (int col = 0; col< 3; col++) {
            for (int row = 0; row < 3; row++){
                int num = a[row][col];
                if (appears[num-1])
                    return false;
                appears[num-1] = true;
            }
        }


        return true;
    }
}





