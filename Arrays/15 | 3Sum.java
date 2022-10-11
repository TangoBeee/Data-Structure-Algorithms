/* |----------------------------------------------------------------------------------------------|
   |--------------------------Naive Solution (TC: O(N^3) | SC: O(M))------------------------------|
   |----------------------------------------------------------------------------------------------| */

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> list = new ArrayList<>();
        
        for(int i = 0; i < nums.length; i++) {
            for(int j = i+1; j < nums.length; j++) {
                for(int k = j+1; k < nums.length; k++) {
                    List<Integer> temp = new ArrayList<>();
                    if(nums[i]+nums[j]+nums[k] == 0) {
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        
                        Collections.sort(temp);
                        
                        if(!list.contains(temp)) list.add(temp);
                    }
                }
            }
        }
        
        return list;
    }
}

/* |----------------------------------------------------------------------------------------------|
   |-------------------------Optimal Solution (TC: O(N^2) | SC: O(N))-----------------------------|
   |----------------------------------------------------------------------------------------------| */

class Solution {
    public static List<List<Integer>> threeSum(int[] nums) {
        
        Arrays.sort(nums);
        
        List<List<Integer>> result = new ArrayList<>();
        
        for(int i = 0; i < nums.length-2; i++) {
            if(i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                int low = i+1, high = nums.length-1, sum = 0 - nums[i];
                while(low < high) {
                    if(nums[low]+nums[high] == sum) {
                        result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        
                        while(low < high && nums[low] == nums[low+1]) low++;
                        while(low < high && nums[high] == nums[high-1]) high--;
                        
                        low++; high--;
                    }
                    
                    else {
                        if(nums[low]+nums[high] < sum) low++;
                        else high--;
                    }
                }
            }
        }
        
        return result;
    }
}
