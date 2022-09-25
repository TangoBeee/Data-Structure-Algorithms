/* |----------------------------------------------------------------------------------------------|
   |---------------------------Naive Solution (TC: O(N) | SC: O(N))-------------------------------|
   |----------------------------------------------------------------------------------------------| */

class Solution {
    public int[] buildArray(int[] nums) {
        
        int n = nums.length;
        
        for(int i = 0; i < n; i++)
            nums[i] = nums[nums[i]];
        
        return nums;
    }
}

/* |----------------------------------------------------------------------------------------------|
   |---------------------------Optimal Solution (TC: O(N) | SC: O(1))-----------------------------|
   |----------------------------------------------------------------------------------------------| */

class Solution {
   public int[] buildArray(int[] nums) {
    
        int n = nums.length;
     
  	    int mask = 1023; // Decimal value of the binary number '1111111111' (We are using bit-shifting)
    
    	  for(int i = 0; i < n; i++)
		        nums[i] |= (nums[nums[i]] & mask) << 10;
    
    	  for(int i = 0; i < n; i++)
		        nums[i] = nums[i] >> 10;
    
	     return nums;
   }
}
