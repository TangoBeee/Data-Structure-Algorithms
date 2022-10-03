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

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        
        boolean ans = false;
        
        for(int i = 0; i < n; i++) {
            
            ans = helper(matrix[i], 0, matrix[i].length-1, target);
            if(ans == true) break;
            
        }
        
        return ans;
    }
    
    private boolean helper(int[] nums, int start, int end, int target) {
        
        while(start <= end) {
            int mid = (start+end)/2;
            
            if(nums[mid] == target) return true;
            
           else  if(nums[mid] < target) start = mid+1;
            
            else end = mid-1;
        }
    
        return false;
    }
}
