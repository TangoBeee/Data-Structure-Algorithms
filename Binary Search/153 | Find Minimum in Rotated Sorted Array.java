/* |----------------------------------------------------------------------------------------------|
   |---------------------------Naive Solution (TC: O(N) | SC: O(1))-------------------------------|
   |----------------------------------------------------------------------------------------------| */

class Solution {
    public int findMin(int[] nums) {
        
        int min = Integer.MAX_VALUE;
        
        for(int i : nums)
            min = Math.min(min, i);
        
        return min;
        
    }
}


/* |----------------------------------------------------------------------------------------------|
   |------------------------Optimal Solution (TC: O(log N) | SC: O(1))----------------------------|
   |----------------------------------------------------------------------------------------------| */

class Solution {
    public int findMin(int[] nums) {
        
        if (nums.length == 1) 
            return nums[0];
        
        int i = 0, j = nums.length - 1;

        if (nums[j] > nums[0]) 
            return nums[0];

        while (j >= i) {
            
            int mid = i + (j - i) / 2;

            if (nums[mid] > nums[mid + 1])
                return nums[mid + 1];

            if (nums[mid - 1] > nums[mid]) 
                return nums[mid];

            if (nums[mid] > nums[0]) 
                i = mid + 1;
            
            else 
                j = mid - 1;
        }
        
        
        return -1;
    }
}


/* |----------------------------------------------------------------------------------------------|
   |------------------------Optimal Solution (TC: O(log N) | SC: O(1))----------------------------|
   |----------------------------------------------------------------------------------------------| */

//Less operations as compared to above solution

class Solution {
    public int findMin(int[] nums) {
        
        int i= 0, j = nums.length-1;
        
        while(i < j) {
            
            int mid = i + (j-i)/2;
            
            if(nums[mid] > nums[j])
                i = mid + 1;
            
            else
                j = mid;
        }
        
        return nums[i];
    }
}

