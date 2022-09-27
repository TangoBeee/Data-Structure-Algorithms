

/* |----------------------------------------------------------------------------------------------|
   |---------------------------Naive Solution (TC: O(N) | SC: O(n))-------------------------------|
   |----------------------------------------------------------------------------------------------| */
   
class Solution {
    public int[] shuffle(int[] nums, int n) {
        
        int len = nums.length;
        
        int[] ans = new int[len];
        
        for(int i = 0; i < n; i++) {
            ans[2*i] = nums[i];
            ans[2*i+1] = nums[n+i];
        }
        
        return ans;
    }
}


/* |----------------------------------------------------------------------------------------------|
   |---------------------------Optimal Solution (TC: O(N) | SC: O(1))-----------------------------|
   |----------------------------------------------------------------------------------------------| */
   
   class Solution {
    public int[] shuffle(int[] nums, int n) {
        
        int len = nums.length;
        
        for(int i = n; i < len; i++) {
            nums[i] = (nums[i] << 10) | nums[i - n];
        }
        
        int index = 0;
        for(int i = n; i < len; i++, index += 2) {
            nums[index] = nums[i] & 1023;
            nums[index + 1] = nums[i] >>> 10;
        }
        
        return nums;
    }
}


/*                                  OR                         */

class Solution {
    public int[] shuffle(int[] nums, int n) {
        
        int len = nums.length;
		
		// to store the pair of numbers in right half of the original array
        for(int i = n; i < len; i++) {
            nums[i] = (nums[i] * 1024) + nums[i - n];
        }
        
        int index = 0;
		// to retrive values from the pair of numbers and placing those retrieved value at their desired position
        for(int i = n; i < len; i++, index += 2) {
            nums[index] = nums[i] % 1024;
            nums[index + 1] = nums[i] / 1024;
        }
        
        return nums;
    }
}
