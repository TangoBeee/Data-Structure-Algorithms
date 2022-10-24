/* |----------------------------------------------------------------------------------------------|
   |---------------------------Naive Solution (TC: O(N) | SC: O(1))-------------------------------|
   |----------------------------------------------------------------------------------------------| */
   
class Solution {
    public int search(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == target)
                return i;
        }
        
        return -1;
    }
}


/* |----------------------------------------------------------------------------------------------|
   |------------------------Optimal Solution (TC: O(log N) | SC: O(1))----------------------------|
   |----------------------------------------------------------------------------------------------| */
   
class Solution {
    public int search(int[] nums, int target) {
        int i = 0, j = nums.length-1;
        
        while(i <= j) {
            int mid = (i+j) >> 1;
            
            if(nums[mid] == target)
                return mid;
            
            else if(nums[i] <= nums[mid]) {
                if(nums[i] <= target && nums[mid] >= target)
                    j = mid-1;
                else
                    i = mid+1;
            }
            
            else {
                if(nums[mid] <= target && nums[j] >= target)
                    i = mid+1;
                else
                    j = mid-1;
            }
        }
        
        return -1;
    }
}
