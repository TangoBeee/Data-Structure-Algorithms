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

class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int low = 0, high = mat.length-1;
        
        while(low <= high) {
            int mid = (low+high) >>> 1;
            
            int maxRow = maxRowElement(mat[mid], mat[mid].length);
            
            if(mid == 0)
                if(mat[mid][maxRow] > mat[mid+1][maxRow])
                    return new int[] {mid, maxRow};
            if(mid == mat.length-1)
                if(mat[mid][maxRow] > mat[mid-1][maxRow])
                    return new int[] {mid, maxRow};
            
            if(mat[mid][maxRow] < mat[mid+1][maxRow])
                low = mid+1;
            else if(mat[mid][maxRow] < mat[mid-1][maxRow])
                high = mid-1;
            
            else
                return new int[] {mid, maxRow};
        }
        
        return null;
    }
    
    private int maxRowElement(int[] nums, int n) {
        int max = 0;
        
        for(int i = 0; i < n; i++) {
            if(nums[i] > nums[max])
                max = i;
        }
        
        return max;
    }
}

// ------------------------------------ OR ---------------------------------- //

class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int low = 0, high = mat[0].length-1;
        
        while(low <= high) {
            int mid = (low+high) >>> 1;
            int maxRow = maxRowElement(mat, mid);
            
            boolean leftIsBig = mid-1 >= low && mat[maxRow][mid-1] > mat[maxRow][mid];
            boolean rightIsBig = mid+1 <= high && mat[maxRow][mid+1] > mat[maxRow][mid];
            
            if(!leftIsBig && !rightIsBig)
                return new int[] {maxRow, mid};
            
            else if(leftIsBig)
                high = mid-1;
            else
                low = mid+1;
        }
        
        return null;
    }
    
    private int maxRowElement(int[][] mat, int mid) {
        int max = 0;
        
        for(int i = 0; i < mat.length; i++) {
            if(mat[i][mid] >= mat[max][mid])
                max = i;
        }
        
        return max;
    }
}
