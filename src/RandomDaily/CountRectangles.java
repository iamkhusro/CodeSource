package RandomDaily;

/*
Problem statement
You are given a positive integer N. Your task is to find the number of possible rectangles, excluding squares, in a N x N chessboard.
Example:
Let’s assume that we have a chessboard of dimension 4x4, i.e. N = 4.
Then the rectangles can have the following possible dimensions: {1*2, 1*3, 1*4, 2*1, ……, 2*4, ………,4*4}.
So, the total number of rectangles in the chessboard is 70.

Hint: number of rectangles (including squares): (N(N+1)/2)^2
      number of squares: N(N+1)(2N+1)/6
*/
public class CountRectangles {
    public static int countRectangles(int n)
    {
        // Write your code here
        long totalRectangles = (n * (n + 1L) / 2L) * (n * (n + 1L) / 2L);
        long totalSquares = (n * (n + 1L) * (2L * n + 1L)) / 6L;

        return (int) (totalRectangles - totalSquares);
    }

    public static void main(String[] args) {
        System.out.println(countRectangles(5));
    }
}
