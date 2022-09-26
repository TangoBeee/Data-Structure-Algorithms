/* |----------------------------------------------------------------------------------------------|
   |------------------------Naive/Optimal Solution (TC: O(N^2) | SC: O(1))--------------------------|
   |----------------------------------------------------------------------------------------------| */

class Solution {
    public int maximumWealth(int[][] accounts) {
        
        int sum = 0;
        
        int row = accounts.length;
        
        for(int i = 0; i < row; i++) {
            int temp = 0;
            for(int j = 0; j < accounts[i].length; j++) {
                temp += accounts[i][j];
            }
            sum = Math.max(temp, sum);
        }
        
        return sum;
    }
}
