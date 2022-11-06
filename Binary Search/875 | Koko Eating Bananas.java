/* |----------------------------------------------------------------------------------------------|
   |-----------------------Naive Solution (TC: O(N + (K*N)) | SC: O(1))---------------------------|
   |----------------------------------------------------------------------------------------------| */

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int speed = Integer.MIN_VALUE;
        for (int pile : piles) speed = Math.max(speed, pile);

        while (speed > 0) {
            
            int count = 0;
            for (int pile : piles) {
                
                if (speed > pile) count++;
                else count += (pile / speed + (pile % speed == 0 ? 0 : 1));
                if (count > h) return speed + 1;
				
            }
            
            speed--;
        }
        
        return 0;
    }
}



/* |----------------------------------------------------------------------------------------------|
   |----------------------Optimal Solution (TC: O(N * log(M)) | SC: O(1))-------------------------|
   |----------------------------------------------------------------------------------------------| */ //where N is no of piles & M is range of K (left to right)

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int low = 1, high = Integer.MIN_VALUE;
        for (int pile : piles) high = Math.max(high, pile);

        int ans = 0;

        while(low <= high) {
            int mid = (low+high) >>> 1;

            int count = count(piles, mid);

            if(count <= h) {
                ans = mid;
                high = mid-1;
            }
            
            else 
                low = mid+1;
        }
        
        return ans;
    }

    private int count(int[] nums, int pile) {
        int count = 0;
        for(int i : nums) {
            count += Math.ceil((double)i/(double)pile);
        }

        return count;
    }
}
