/* |----------------------------------------------------------------------------------------------|
   |-----------------------Optimal Solution (TC: O(log(N)) | SC: O(1))----------------------------|
   |----------------------------------------------------------------------------------------------| */

class Solution {
    public int splitArray(int[] nums, int k) {

        int low = Integer.MAX_VALUE, high = 0;

        for(int i : nums) {
            low = Math.min(low, i);
            high += i;
        }

        int ans = 0;
        while(low <= high) {
            int mid = (low+high) >>> 1;
            if(isValid(nums, mid, k)) {
                ans = mid;
                high = mid-1;
            }

            else {
                low = mid+1;
            }
        }

        return ans;
    }

    private boolean isValid(int[] nums, int sum, int k) {
        int count = 0;
        int no = 0;

        for(int i : nums) {
            if(count+i > sum) {
                count = i;
                no++;

                if(count > sum)
                    return false;
            }

            else
                count += i;
        }

        if(no < k)
            return true;
        return false;
    }
}
