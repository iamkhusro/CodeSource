package RandomDaily;

/*
Problem statement
Given an integer ‘N’, you are supposed to return the square of the given integer without using multiplication (*), division (/) or power function (pow()).
*/

public class SquareNumber
{
    public static int calculateSquare(int num)
    {
        //    Write your code here.
        int res = 0;
        int numAbs = Math.abs(num);
        for (int i = 1; i <= numAbs; i++) {
            res += numAbs;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(calculateSquare(12));
    }
}