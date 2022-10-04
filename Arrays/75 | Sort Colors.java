/* |----------------------------------------------------------------------------------------------|
   |------------------------Naive Solution (TC: O(N Log(N))) | SC: O(1))---------------------------|
   |----------------------------------------------------------------------------------------------| */

class Solution {
    public void sortColors(int[] nums) {
        Arrays.sort(nums); // NOTE: You dont have to use inbuild sorting lib i just showing you example that naive solution can be solved using sorting.
    }
}

/* |----------------------------------------------------------------------------------------------|
   |---------------------------Better Solution (TC: O(N)) | SC: O(1))-----------------------------|
   |----------------------------------------------------------------------------------------------| */

class Solution {
    public void sortColors(int[] nums) {
        int zero = 0;
        int one = 0;
        int two = 0;
        
        for(int i : nums) {
            if(i == 0) zero++;
            else if(i == 1) one++;
            else two++;
        }
        
        for(int i = 0; i < zero; i++) nums[i] = 0;
        for(int i = 0; i < one; i++) nums[i+zero] = 1;
        for(int i = 0; i < two; i++) nums[i+zero+one] = 2;
    }
}


/* |----------------------------------------------------------------------------------------------|
   |---------------------Optimal Solution (TC: O(N)) | SC: O(1))-------------------------|
   |----------------------------------------------------------------------------------------------| */


class Solution {
    public void sortColors(int[] nums) {
        if(nums.length <= 1) return;
        
        int start = 0;
        int mid = 0;
        int end = nums.length-1;
        
        while(mid <= end) {
            if(nums[mid] == 2) swap(nums, mid, end--);
            
            else if(nums[mid] == 1) mid++;
            
            else swap(nums, mid++, start++);
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
