/* |----------------------------------------------------------------------------------------------|
   |--------------------------Naive Solution (TC: O(N*M) | SC: O(1))------------------------------|
   |----------------------------------------------------------------------------------------------| */

class Solution {
    public int[] findPeakGrid(int[][] mat) {
        
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[i].length; j++) {
                boolean check = true;
                
                if(i > 0)
                    if(mat[i][j] < mat[i-1][j]) check = false;
                
                if(i < mat.length-1)
                    if(mat[i][j] < mat[i+1][j]) check = false;
                
                if(j > 0)
                    if(mat[i][j] < mat[i][j-1]) check = false;
                
                if(j < mat[i].length-1)
                    if(mat[i][j] < mat[i][j+1]) check = false;
                
                if(check)
                    return new int[] {i, j};
            }
        }
        
        return null;
    }
}



/* |----------------------------------------------------------------------------------------------|
   |--------------------------Better Solution (TC: O(N*M) | SC: O(1))-----------------------------|
   |----------------------------------------------------------------------------------------------| */

class Solution {
    public int[] findPeakGrid(int[][] mat) {
        
        int maxPeak = 0;
        
        int row = 0, col = 0;
        
        for(int i = 0; i < mat.length; i++)
            for(int j = 0; j < mat[i].length; j++) 
                if(mat[i][j] > maxPeak) {
                    maxPeak = mat[i][j];
                    row = i;
                    col = j;
                }
        
        return new int[] {row, col};
    }
}


/* |----------------------------------------------------------------------------------------------|
   |-----------------------Optimal Solution (TC: O(N log(m)) | SC: O(1))--------------------------|
   |----------------------------------------------------------------------------------------------| */


