/* |----------------------------------------------------------------------------------------------|
   |-------------------------Naive Solution (TC: O(N*MAX) | SC: O(1))-----------------------------|
   |----------------------------------------------------------------------------------------------| */ //Where MAX is maximum element of the array

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
   |---------------------Optimal Solution (TC: O(N*log(MAX)) | SC: O(1))--------------------------|
   |----------------------------------------------------------------------------------------------| */ //Where MAX is maximum element of the array

class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1, high = Integer.MIN_VALUE;

        for(int i : nums) high = Math.max(high, i);
        int ans = 0;

        while(low <= high) {
            int mid = (low+high) >>> 1;

            int sum = 0;

            for(int i : nums)
                sum += (int)Math.ceil((double)i/(double)mid);
            
            if(sum <= threshold) {
                ans = mid;
                high = mid-1;
            }

            else
                low = mid+1;
        }

        return ans;
    }
}

