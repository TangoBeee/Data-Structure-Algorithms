/* |----------------------------------------------------------------------------------------------|
   |---------------------------Naive Solution (TC: O(N) | SC: O(1))-------------------------------|
   |----------------------------------------------------------------------------------------------| */

class Solution {
    public int searchInsert(int[] nums, int target) {
        
        for(int i=0;i<nums.length;i++) 
            if(nums[i]>=target)return i;
        
        return nums.length;
    }
}


/* |----------------------------------------------------------------------------------------------|
   |------------------------Optimal Solution (TC: O(log N) | SC: O(1))----------------------------|
   |----------------------------------------------------------------------------------------------| */

class Solution {
    public int searchInsert(int[] nums, int target) {   
        int i = 0, j = nums.length-1;
        
        while(i <= j) {
            int mid = i + (j - i)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] < target)
                i = mid+1;
            else
                j = mid-1;
        }
        
        return i;
    }
}
