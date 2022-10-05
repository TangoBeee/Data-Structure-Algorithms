/* |----------------------------------------------------------------------------------------------|
   |---------------------------Optimal Solution (TC: O(N) | SC: O(N))-----------------------------|
   |----------------------------------------------------------------------------------------------| */

class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] result = new int[nums.length];
        
        int indexp = 0;
        int indexn = 1;
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                result[indexp] = nums[i];
                indexp += 2;
            }
            
            else {
                result[indexn] = nums[i];
                indexn += 2;
            }
        }
        
        return result;
    }
}
