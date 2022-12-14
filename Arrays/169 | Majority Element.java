/* |----------------------------------------------------------------------------------------------|
   |---------------------------Naive Solution (TC: O(N^2) | SC: O(1))-----------------------------|
   |----------------------------------------------------------------------------------------------| */

class Solution {
    public int majorityElement(int[] nums) {
        
        for(int i = 0; i < nums.length; i++) {
            int max = 0;
            for(int j = 0; j < nums.length; j++) {
                if(nums[i] == nums[j]) {
                    max+=1;
                }
            }
            
            if(max > nums.length/2) {
                return nums[i];
            }
        }
        
        return -1;
    }
}


/* |----------------------------------------------------------------------------------------------|
   |----------------------------Better Solution (TC: O(N) | SC: O(N))-----------------------------|
   |----------------------------------------------------------------------------------------------| */

class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i : nums) {
            map.put(i, map.getOrDefault(i, 0)+1);
            if(map.get(i) > nums.length/2) return i;
        }
        
        return -1;
    }
}


/* |----------------------------------------------------------------------------------------------|
   |---------------------------Optimal Solution (TC: O(N) | SC: O(1))-----------------------------|
   |----------------------------------------------------------------------------------------------| */

class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int num = 0;
        
        for(int i = 0; i < nums.length; i++) {
            if(count == 0) num = nums[i];
            
            if(nums[i] == num) count++;
            else count--;
        }
        
        return num;
    }
}
