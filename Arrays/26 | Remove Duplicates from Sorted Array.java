/* |----------------------------------------------------------------------------------------------|
   |------------------------Naive/Optimal Solution (TC: O(N) | SC: O(1))--------------------------|
   |----------------------------------------------------------------------------------------------| */


class Solution {
    public int removeDuplicates(int[] nums) {
        
        int n = nums.length;
        
        int left = 1;
        int right = 1;
        
        while(right < n) {
            if(nums[right-1] == nums[right]) {
                right++;
                continue;
            }
            
            else if(nums[right-1] < nums[right]) {
                nums[left] = nums[right];
                right++;
                left++;
            }
        }
        
        return left;
    }
}
