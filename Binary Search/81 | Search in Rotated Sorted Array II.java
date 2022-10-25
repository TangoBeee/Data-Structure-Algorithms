/* |----------------------------------------------------------------------------------------------|
   |---------------------------Naive Solution (TC: O(N) | SC: O(1))-------------------------------|
   |----------------------------------------------------------------------------------------------| */
   
class Solution {
    public boolean search(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == target)
                return true;
        }
        
        return false;
    }
}



/* |----------------------------------------------------------------------------------------------|
   |------------------------Optimal Solution (TC: O(log N) | SC: O(1))----------------------------|
   |----------------------------------------------------------------------------------------------| */
   
class Solution {
    public boolean search(int[] nums, int target) {
        int i = 0, j = nums.length-1;
        
        while(i <= j) {
            int mid = (i+j)>>1;
            
            if(nums[mid] == target)
                return true;
            else if(nums[i] < nums[mid] || nums[mid] > nums[j]) {
                if(target >= nums[i] && target <= nums[mid])
                    j = mid-1;
                else
                    i = mid+1;
            }
            
            else if(nums[mid] < nums[j] || nums[mid] < nums[i]) {
                if(target >= nums[mid] && target <= nums[j])
                    i = mid+1;
                else
                    j = mid-1;
            }
            
            else
                j--;
        }
        
        return false;
    }
}   
   
