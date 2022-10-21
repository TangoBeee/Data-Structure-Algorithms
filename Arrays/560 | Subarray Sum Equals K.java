/* |----------------------------------------------------------------------------------------------|
   |---------------------------Naive Solution (TC: O(N^3) | SC: O(1))-----------------------------|
   |----------------------------------------------------------------------------------------------| */

class Solution {
    public int subarraySum(int[] nums, int k) {
        
        int count = 0;
        
        for(int i = 0; i < nums.length; i++) {
            for(int j = i; j < nums.length; j++) {
            int temp = 0;
                for(int t = i; t <= j; t++) {
                    temp += nums[t];
                }
            if(temp == k)
                count++;
            }
        }
        return count;
    }
}


/* |----------------------------------------------------------------------------------------------|
   |---------------------------Better Solution (TC: O(N^2) | SC: O(N))----------------------------|
   |----------------------------------------------------------------------------------------------| */

public class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i <= nums.length; i++)
            sum[i] = sum[i - 1] + nums[i - 1];
        for (int start = 0; start < nums.length; start++) {
            for (int end = start + 1; end <= nums.length; end++) {
                if (sum[end] - sum[start] == k)
                    count++;
            }
        }
        return count;
    }
}


/* |----------------------------------------------------------------------------------------------|
   |-----------------------Little Optimal Solution (TC: O(N^2) | SC: O(1))------------------------|
   |----------------------------------------------------------------------------------------------| */

public class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum=0;
            for (int end = start; end < nums.length; end++) {
                sum+=nums[end];
                if (sum == k)
                    count++;
            }
        }
        return count;
    }
}


/* |----------------------------------------------------------------------------------------------|
   |---------------------------- Optimal Solution (TC: O(N) | SC: O(N))---------------------------|
   |----------------------------------------------------------------------------------------------| */


class Solution {
    public int subarraySum(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int sum = 0;
        int count = 0;
        
        map.put(0,1);
        
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(map.containsKey(sum-k))
                count += map.get(sum-k);
            map.put(sum, map.getOrDefault(sum, 0)+1);
                
        }
        
        return count;
        
    }
}
