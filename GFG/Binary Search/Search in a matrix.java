/*
Naive and Better Solutions https://github.com/TangoBeee/Data-Structure-Algorithms/blob/main/Binary%20Search/74%20%7C%20Search%20a%202D%20Matrix.java (optimal solution will not work)
*/

/* --------------------------------------------------------------------------------- */

class Sol
{
    public static int matSearch(int mat[][], int N, int M, int X) {
        int i = 0, j = M-1;
        
        while(i < N && j >= 0) {
            if(mat[i][j] == X)
                return 1;
            
            else if(mat[i][j] < X)
                i++;
            
            else
                j--;
        }
        
        return 0;
    }
}

//TC: O(N+M)
//SC: O(1)

//Optimal Solution(only for GFG)
