/* |----------------------------------------------------------------------------------------------|
   |-------------------------Naive Solution (TC: O(N*MAX) | SC: O(1))-----------------------------|
   |----------------------------------------------------------------------------------------------| */

class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int max = Integer.MIN_VALUE;

        for(int i : nums)
            max = Math.max(max, i);

        int ans = Integer.MAX_VALUE;

        while(max >= 1) {

            int temp = 0;

            for(int i : nums) {
                temp += (int)Math.ceil((double)i/(double)max);
            }
            
            if(temp <= threshold)
                ans = max;

            max--;
        }

        return ans;
    }
}


/* |----------------------------------------------------------------------------------------------|
   |--------------------------Optimal Solution (TC: O() | SC: O(1))-------------------------------|
   |----------------------------------------------------------------------------------------------| */


