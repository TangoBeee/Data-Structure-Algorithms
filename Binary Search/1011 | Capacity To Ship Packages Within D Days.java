/* |----------------------------------------------------------------------------------------------|
   |----------------------Optimal Solution (TC: O(N*log(N)) | SC: O(1))---------------------------|
   |----------------------------------------------------------------------------------------------| */

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = Integer.MIN_VALUE, high = 0;
        for(int weight : weights) {
            low = Math.max(low, weight);
            high += weight;
        }

        int capacity = 0;

        while(low <= high) {
            int mid = (low+high) >>> 1;

            if(capacityOfShip(weights, days, mid)) {
                capacity = mid;
                high = mid-1;
            }

            else
                low = mid+1;

        }

        return capacity;        
    }

    private boolean capacityOfShip(int[] weights, int days, int packages) {
        int capacity = 0, day = 1;

        for(int weight : weights) {
            if((capacity+weight) > packages) {
                day += 1;
                capacity = weight;
            }

            else
                capacity += weight;
        }

        return !(day > days);
    }
}
