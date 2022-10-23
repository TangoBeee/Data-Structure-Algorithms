/* |----------------------------------------------------------------------------------------------|
   |---------------------------Naive Solution (TC: O(N) | SC: O(1))-------------------------------|
   |----------------------------------------------------------------------------------------------| */

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = -1;
        int end = -1;
        
        int i = 0, j = 0;
        
        while(i < nums.length && j < nums.length) {
            if(nums[i] == target) {
                start = i;
            }
            else
                i++;
            
            if(nums[j] == target) {
                end = j;
                j++;
            }
            else
                j++;
        }
        
        return new int[] {start, end};
    }
}



/* |----------------------------------------------------------------------------------------------|
   |------------------------Optimal Solution (TC: O(log N) | SC: O(1))----------------------------|
   |----------------------------------------------------------------------------------------------| */

class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int i = 0, j = nums.length-1;
        int[] res = {-1, -1};
        
        //for first position
        while(i <= j) {
            int mid = i+(j-i)/2;
            
            if(nums[mid] == target) {
                res[0] = mid;
                j = mid-1;
            }
            else if(nums[mid] < target)
                i = mid+1;
            else
                j = mid-1;
            
        }
        
        i = 0;
        j = nums.length-1;
        
        //for last position
        while(i <= j) {
            int mid = i+(j-i)/2;
            
            if(nums[mid] == target) {
                res[1] = mid;
                i = mid+1;
            }
            else if(nums[mid] < target)
                i = mid+1;
            else
                j = mid-1;
            
        }
        
        return res;
    }
}
