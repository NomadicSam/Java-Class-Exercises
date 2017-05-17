/*
 LoShu Demo Class
 11/13/16
*/


public class LoShuDemo
{

    public static void main (String[] args){
        int[][] loshu = {{4,9,2},{3,5,7},{8,1,6}};
        System.out.println(LoShu.check(loshu));

        int[][] no1 = {{4,9,2},{3,7,5},{8,1,6}};
        System.out.println(LoShu.check(no1));

        int[][] no2 = {{4,9,2},{3,3,5},{8,1,6}};
        System.out.println(LoShu.check(no2));
    }
}