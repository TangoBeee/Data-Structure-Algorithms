/* |----------------------------------------------------------------------------------------------|
   |--------------------------Naive Solution (TC: O(N^2) | SC: O(N^2))----------------------------|
   |----------------------------------------------------------------------------------------------| */

class Solution {
    public void rotate(int[][] matrix) {
        
        int n = matrix.length;
        
        int[][] copy = new int[n][n];
        
        int index = n-1;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                copy[j][index] = matrix[i][j];
            }
            index--;
        }
        
            
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                matrix[i][j] = copy[i][j];
            }
        }
    }
}



/* |----------------------------------------------------------------------------------------------|
   |--------------------------Optimal Solution (TC: O(N^2) | SC: O(1))-----------------------------|
   |----------------------------------------------------------------------------------------------| */

class Solution {
    public void rotate(int[][] matrix) {
        
        int n = matrix.length;
        
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n/2; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = temp;
            }
        }
    }
}
