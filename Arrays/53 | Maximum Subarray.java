/* |----------------------------------------------------------------------------------------------|
   |--------------------------Naive Solution (TC: O(N^3) | SC: O(1))------------------------------|
   |----------------------------------------------------------------------------------------------| */

class Solution {
    public int maxSubArray(int[] nums) {
        int sum = Integer.MIN_VALUE;
        
        for(int i = 0; i < nums.length; i++) {
            for(int j = i; j < nums.length; j++) {
                int temp = 0;
                for(int k = i; k <= j; k++) {
                    temp += nums[k];
                }
                sum = Math.max(sum, temp);
            }
        }
        return sum;
    }
}


/* |----------------------------------------------------------------------------------------------|
   |---------------------------Optimal Solution (TC: O(N) | SC: O(1))-----------------------------|
   |----------------------------------------------------------------------------------------------| */

class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(sum, max);
            
            if(sum < 0) sum = 0;
        }
        
        return max;
    }
}
