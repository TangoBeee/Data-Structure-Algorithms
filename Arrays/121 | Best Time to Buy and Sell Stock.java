/* |----------------------------------------------------------------------------------------------|
   |--------------------------Naive Solution (TC: O(N^2) | SC: O(1))------------------------------|
   |----------------------------------------------------------------------------------------------| */

class Solution {
    public int maxProfit(int[] prices) {
        
        int n = prices.length;
        
        int profit = 0;
        
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                int temp = 0;
                
                if(prices[i] > prices[j]) continue;
                
                temp = prices[j] - prices[i];
                
                profit = Math.max(temp, profit);
            }
        }
        
        return profit;
    }
}


/* |----------------------------------------------------------------------------------------------|
   |-------------------------Optimal Solution (TC: O(N) | SC: O(1))-------------------------------|
   |----------------------------------------------------------------------------------------------| */

class Solution {
    public int maxProfit(int[] prices) {
        
        int n = prices.length;
        
        int profit = 0;
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i < n; i++) {
            if(prices[i] < min) min = prices[i];
            
            else if(prices[i] - min > profit) profit = prices[i] - min;
        }
        
        return profit;
    }
}
