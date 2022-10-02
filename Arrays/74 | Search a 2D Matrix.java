/* |----------------------------------------------------------------------------------------------|
   |--------------------------Naive Solution (TC: O(N^2) | SC: O(1))------------------------------|
   |----------------------------------------------------------------------------------------------| */

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int n = matrix.length;
        int m = matrix[0].length;
        
        boolean ans = false;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] == target) {
                    ans = true;
                }
            }
        }
        
        return ans;
    }
}

/* |----------------------------------------------------------------------------------------------|
   |--------------------------Optimal Solution (TC: O(N) | SC: O(1))------------------------------|
   |----------------------------------------------------------------------------------------------| */

