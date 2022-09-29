** |----------------------------------------------------------------------------------------------|
   |---------------------------Naive Solution (TC: O(N) | SC: O(N))-------------------------------|
   |----------------------------------------------------------------------------------------------| */

  class Solution {
    public void rotate(int[] nums, int k) {
        
        int n = nums.length;
        
        int[] temp = new int[n];
        
        for(int i = 0; i < n; i++) {
            temp[(i+k)%n] = nums[i];
        }
        
        for(int i = 0; i < n; i++) {
            nums[i] = temp[i];
        }
    }
}   



/* |----------------------------------------------------------------------------------------------|
   |---------------------------Optimal Solution (TC: O(N) | SC: O(1))-----------------------------|
   |----------------------------------------------------------------------------------------------| */

class Solution {
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        
        reverse(nums, 0, nums.length-1);
        
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }
    
    private void reverse(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            
            start++;
            end--;
        }
    }
}
