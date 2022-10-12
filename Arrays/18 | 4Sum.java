/* |----------------------------------------------------------------------------------------------|
   |--------------------------Naive Solution (TC: O(N^4) | SC: O(M))------------------------------|
   |----------------------------------------------------------------------------------------------| */

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        for(int i = 0; i < nums.length-3; i++) {
            for(int j = i+1; j < nums.length; j++) {
                for(int k = j+1; k < nums.length; k++) {
                    for(int l = k+1; l < nums.length; l++) {
                        List<Integer> set = new ArrayList<>();
                        if(nums[i] + nums[j] + nums[k] + nums[l] == target) {
                            set.add(nums[i]);
                            set.add(nums[j]);
                            set.add(nums[k]);
                            set.add(nums[l]);
                        }
                        Collections.sort(set);
                        if(set.isEmpty()) continue;
                        else if(!result.contains(set)) result.add(set);
                    }
                }
            }
        }
        
        return result;
    }
}
