/* |----------------------------------------------------------------------------------------------|
   |---------------------------Naive Solution (TC: O(N) | SC: O(1))-------------------------------|
   |----------------------------------------------------------------------------------------------| */

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int i = 0;
        for(i = 0; i < nums.length-1; i+=2) {
            if(nums[i] != nums[i+1])
                return nums[i];
        }
        
        return nums[i];
    }
}


/* |----------------------------------------------------------------------------------------------|
   |------------------------Optimal Solution (TC: O(log N) | SC: O(1))----------------------------|
   |----------------------------------------------------------------------------------------------| */
   
   class Solution {
    public int singleNonDuplicate(int[] nums) {
        
        int i = 0, j = nums.length-1;
        
        while(i < j){
            int mid = (i + j)/2;
            
            if((mid % 2 == 0 && nums[mid] == nums[mid +1]) || (mid %2 == 1 && nums[mid] == nums[mid - 1]))
                i = mid + 1;
            
            else
                j = mid;
        }
        
        return nums[i];
    }   
}
   
