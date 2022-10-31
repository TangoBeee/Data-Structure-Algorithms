/* |----------------------------------------------------------------------------------------------|
   |--------------------------Naive Solution (TC: O(N*M) | SC: O(1))------------------------------|
   |----------------------------------------------------------------------------------------------| */

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        for(int[] i : matrix) 
            for(int j : i) 
                if(j == target)
                    return true;
        
        return false;
    }
}


/* |----------------------------------------------------------------------------------------------|
   |----------------------Better Solution (TC: O(N * log(M)) | SC: O(1))--------------------------|
   |----------------------------------------------------------------------------------------------| */

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int[] i : matrix)
            if(binarySearch(i, target))
                return true;
        
        return false;
    }
    
    private boolean binarySearch(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        
        while(low <= high) {
            int mid = low+(high-low)/2;
            
            if(nums[mid] == target)
                return true;
            
            else if(nums[mid] < target)
                low = mid+1;
            
            else
                high = mid-1;
        }
        
        return false;
    }
}


/* |----------------------------------------------------------------------------------------------|
   |------------------------Better Solution (TC: O(N + M) | SC: O(1))-----------------------------|
   |----------------------------------------------------------------------------------------------| */

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0, j = matrix[0].length-1;
        
        while(i < matrix.length && j >= 0) {
            if(matrix[i][j] == target)
                return true;
            
            else if(matrix[i][j] < target)
                i++;
            
            else
                j--;
        }
        
        return false;
    }
}

/* |----------------------------------------------------------------------------------------------|
   |-----------------------Optimal Solution (TC: O(log(N M)) | SC: O(1))--------------------------|
   |----------------------------------------------------------------------------------------------| */

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int n = matrix.length;
        int m = matrix[0].length;
        
        int totalLen = (n * m);
        
        int low = 0, high = totalLen-1;
        
        while(low <= high) {
            int mid = low+(high-low)/2;
            
            if(matrix[mid/m][mid%m] == target)
                return true;
            
            else if(matrix[mid/m][mid%m] < target) {
                low = mid+1;
            }
            
            else
                high = mid-1;
        }
        
        return false;
    }
}
