/* |----------------------------------------------------------------------------------------------|
   |-----------------------Naive Solution (TC: O(N*M) * (N+M) | SC: O(NM))------------------------|
   |----------------------------------------------------------------------------------------------| */

class Solution {
    public void setZeroes(int[][] matrix) {
        
        int n = matrix.length, m = matrix[0].length;
        
        int[][] copy = new int[n][m];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                copy[i][j] = matrix[i][j];
            }
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] == 0) {
                    for(int r = 0; r < m; r++) {
                        copy[i][r] = 0;
                    }
                    for(int c = 0; c < n; c++) {
                        copy[c][j] = 0;
                    }
                }
            }
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                matrix[i][j] = copy[i][j];
            }
        }
        
    }
}


/* |----------------------------------------------------------------------------------------------|
   |---------------------------Better Solution (TC: O(N*M) | SC: O(NM))---------------------------|
   |----------------------------------------------------------------------------------------------| */

class Solution {
    public void setZeroes(int[][] matrix) {
        
        int n = matrix.length, m = matrix[0].length;
        
        int[] row = new int[n];
        int[] col = new int[m];
        
        Arrays.fill(row, 1);
        Arrays.fill(col, 1);
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] == 0) {
                    row[i] = 0;
                    col[j] = 0;
                }
            }
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(row[i] == 0 || col[j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        
    }
}


/* |----------------------------------------------------------------------------------------------|
   |---------------------------Optimal Solution (TC: O(N*M) | SC: O(1))---------------------------|
   |----------------------------------------------------------------------------------------------| */

class Solution {
    public void setZeroes(int[][] matrix){

		int m=matrix.length, n=matrix[0].length;
        
        boolean isRow0=false, isCol0=false;
        
        for(int i = 0; i < m; i++) {
            if(matrix[i][0] == 0) isCol0 = true;
        }
        
        for(int i = 0; i < n; i++) {
            if(matrix[0][i] == 0) isRow0 = true;
        }
        
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
        }

        
        if(isRow0) {
            for(int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }
        
        if(isCol0) {
            for(int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
