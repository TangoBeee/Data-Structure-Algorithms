/* |----------------------------------------------------------------------------------------------|
   |---------------------------Naive Solution (TC: O(N) | SC: O(1))-------------------------------|
   |----------------------------------------------------------------------------------------------| */

class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length < 2)
            return nums.length-1;
        
        if(nums[0] > nums[1])
            return 0;
        
        for(int i = 1; i < nums.length-1; i++) {
            if(nums[i] > nums[i-1] && nums[i] > nums[i+1])
                return i;
        }
        
        return nums.length-1;
    }
}



/* |----------------------------------------------------------------------------------------------|
   |------------------------Optimal Solution (TC: O(log N) | SC: O(1))----------------------------|
   |----------------------------------------------------------------------------------------------| */

class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length < 2)
            return nums.length-1;
        
        if(nums[0] > nums[1])
            return 0;
        
        int i = 1, j = nums.length-2;
        
        while(i <= j) {
            int mid = i+(j-i)/2;
            
            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1])
                return mid;
            else if(nums[mid] < nums[mid+1])
                i = mid+1;
            else
                j = mid-1;
        }
        
        return nums.length-1;
    }
}
