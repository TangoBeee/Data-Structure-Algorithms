/* |----------------------------------------------------------------------------------------------|
   |--------------------------Naive Solution (TC: O(N^3) | SC: O(1))------------------------------|
   |----------------------------------------------------------------------------------------------| */

class Solution {
    private boolean arrayContains(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                return true;
            }
        }

        return false;
    }
    public int longestConsecutive(int[] nums) {
        int longestStreak = 0;

        for (int num : nums) {
            int currentNum = num;
            int currentStreak = 1;

            while (arrayContains(nums, currentNum + 1)) {
                currentNum += 1;
                currentStreak += 1;
            }

            longestStreak = Math.max(longestStreak, currentStreak);
        }

        return longestStreak;
    }
}


/* |----------------------------------------------------------------------------------------------|
   |-----------------------Better Solution (TC: O(N Log(N)) | SC: O(1/N))-------------------------|
   |----------------------------------------------------------------------------------------------| */

// SC is O(1/N) because we are sorting are input array so its O(1) but if we are not allowed to modify our input array then we have to make new array for sorting which will increase our space complexity to O(N).

class Solution {
    public int longestConsecutive(int[] nums) {
        
        if(nums.length == 0)
            return 0;
        
        Arrays.sort(nums);
        
        int count = 1;
        int max = 1;
        
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i-1])
                if(nums[i] == nums[i-1]+1)
                    count+=1;
            
            else {
                max = Math.max(max, count);
                count=1;
            }
        }
         max = Math.max(max, count);
        return max;
    }
}


/* |----------------------------------------------------------------------------------------------|
   |-------------------------Optimal Solution (TC: O(N) | SC: O(N))-------------------------------|
   |----------------------------------------------------------------------------------------------| */

class Solution {
    public int longestConsecutive(int[] nums) {
        
        if(nums.length == 0)
            return 0;
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int i : nums) {
            set.add(i);
        }
        
        int max = 0;
        
        for(int i : nums) {
            if(!set.contains(i-1)) {
                int num = i;
                int count = 1;
                
                while(set.contains(num+1)) {
                    count++;
                    num++;
                }
                
                max = Math.max(max, count);
            }
        }
        
        return max;
    }
}
