package Week7;
class Week7{

    static int UniquePathHelper(int i, int j, int m, int n, int[][] A)// A[i][j] is the number of unique paths from (i,j) to (m,n)
    {
        // boundary condition or constraints
        if (i == m || j == n) {
        return 0;
        }
    
        if (A[i][j] == 1)// if the number of unique paths from (i,j) to (m,n) has been calculated before, return the value
         {
        return 0;
        }
    
        // base case
        if (i == m - 1 && j == n - 1)// if the number of unique paths from (i,j) to (m,n) is 1, return 1
         {
        return 1;
        }
    
        return UniquePathHelper(i + 1, j, m, n, A)
        + UniquePathHelper(i, j + 1, m, n, A);
    }
    
    static int uniquePathsWithObstacles(int[][] A)
    {
    
        int m = A.length, n = A[0].length;
    
        return UniquePathHelper(0, 0, m, n, A);
    }
    
    // Driver Code
    public static void main(String[] args)
    {
        int[][] A
        = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
    
        System.out.print(uniquePathsWithObstacles(A));
    }
}