/* |----------------------------------------------------------------------------------------------|
   |--------------------------Optimal Solution (TC: O(N) | SC: O(N))------------------------------|
   |----------------------------------------------------------------------------------------------| */

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        
        int m = matrix.length, n = matrix[0].length;
        
        int left = 0, right = n-1;
        int top = 0, down = m-1;
        
        while(true) {
            
            for(int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            
            top++;
            
            if(left > right || top > down) break;
            
            for(int i = top; i <= down; i++) {
                list.add(matrix[i][right]);
            }
            
            right--;
            
            if(left > right || top > down) break;
            
            for(int i = right; i >= left; i--) {
                list.add(matrix[down][i]);
            }
            
            down--;
            
            if(left > right || top > down) break;
            
            for(int i = down; i >= top; i--) {
                list.add(matrix[i][left]);
            }
            
            left++;
            
            if(left > right || top > down) break;
            
        }
        
        return list;
    }
}
