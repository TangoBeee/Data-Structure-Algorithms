/* |----------------------------------------------------------------------------------------------|
   |-------------------Optimal Solution (TC: O(N*LOg(high)) | SC: O(1))-----------------------|
   |----------------------------------------------------------------------------------------------| */

class Solution {
    public int minDays(int[] bloomDay, int m, int k) {

        if((long)m*k > bloomDay.length)
            return -1;

        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;

        for(int i : bloomDay) {
            low = Math.min(low, i);
            high = Math.max(high, i);
        }

        while(low < high) {
            int mid = (low+high) >>> 1;

            if(bloomedFlowers(bloomDay, m, k, mid)) {
                high = mid;
            }

            else
                low = mid+1;

        }

        return low;
    }

    private boolean bloomedFlowers(int[] nums, int m, int k, int mid) {
        int count = 0;

        for(int i : nums) {
            count = i <= mid ? count + 1 : 0;

            if(count == k) {
                count = 0;
                m--;
            }
        }
        return m <= 0;
    }
}
