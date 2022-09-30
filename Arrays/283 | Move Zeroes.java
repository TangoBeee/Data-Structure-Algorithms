/* |----------------------------------------------------------------------------------------------|
   |------------------------Naive/Optimal Solution (TC: O(N) | SC: O(1))--------------------------|
   |----------------------------------------------------------------------------------------------| */
   
   class Solution {
    public void moveZeroes(int[] nums) {
        
        if(nums.length <= 1) {
            return;
        }
        
        int t = 0;
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                continue;
            }
            swap(nums, i, t++);
        }
        
    }
    
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
